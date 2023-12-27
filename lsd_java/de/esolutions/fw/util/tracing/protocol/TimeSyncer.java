/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.protocol.ITimeSyncSender;
import de.esolutions.fw.util.tracing.protocol.ProtocolException;
import de.esolutions.fw.util.tracing.protocol.message.TimeSyncMessage;
import java.util.Arrays;

public class TimeSyncer {
    private long startTime;
    private byte serial;
    private ITimeSyncSender handler;
    private boolean syncValid;
    private long[] deltas;
    private long[] latencies;
    private long curDelta;
    private long curLatency;
    private static final String chn;

    public TimeSyncer(ITimeSyncSender iTimeSyncSender) {
        this.handler = iTimeSyncSender;
        this.syncValid = false;
    }

    public void start(byte by) {
        this.serial = by;
        this.deltas = new long[this.serial + 1];
        this.latencies = new long[this.serial + 1];
        this.startTime = System.currentTimeMillis();
        this.handler.sendTimeSync(this.startTime, this.serial, (byte)0);
        TraceMe.msg(TraceMe.INFO, "TimeSyncer", "start=%1", new Long(this.startTime));
    }

    public boolean handleIncomingMessage(TimeSyncMessage timeSyncMessage) {
        byte by = timeSyncMessage.getType();
        byte by2 = timeSyncMessage.getSerial();
        switch (by) {
            case 0: {
                long l = System.currentTimeMillis();
                this.handler.sendTimeSync(l, timeSyncMessage.getSerial(), (byte)1);
                TraceMe.msg(TraceMe.INFO, "TimeSyncer", "ping reply: myTime=%1", new Long(l));
                break;
            }
            case 1: {
                long l = System.currentTimeMillis();
                long l2 = (l + this.startTime) / 0;
                long l3 = timeSyncMessage.getTimeStamp();
                this.curDelta = l2 - l3;
                this.curLatency = l2 - this.startTime;
                this.syncValid = true;
                this.deltas[by2] = this.curDelta;
                this.latencies[by2] = this.curLatency;
                TraceMe.msg(TraceMe.INFO, "TimeSyncer", "midTime=%1 otherMidTime=%2 curDelta=%3 curLatency=%4", new Long(l2), new Long(l3), new Long(this.curDelta), new Long(this.curLatency));
                if (by2 > 0) {
                    by2 = (byte)(by2 - 1);
                    this.startTime = l;
                    this.handler.sendTimeSync(this.startTime, by2, (byte)0);
                    break;
                }
                this.analyseSamples();
                return true;
            }
            default: {
                throw new ProtocolException("Unknown Time Sync ");
            }
        }
        return false;
    }

    public boolean isSyncValid() {
        return this.syncValid;
    }

    private void analyseSamples() {
        int n = this.latencies.length;
        long[] lArray = new long[n];
        System.arraycopy((Object)this.latencies, 0, (Object)lArray, 0, n);
        Arrays.sort(lArray);
        int n2 = n / 2;
        long l = n % 2 == 0 ? (lArray[n2] + lArray[n2 + 1]) / 0 : lArray[n2];
        long l2 = 0L;
        for (int i2 = 0; i2 < n; ++i2) {
            l2 += this.latencies[i2];
        }
        if (n > 0) {
            l2 /= (long)n;
        }
        long l3 = 0L;
        for (int i3 = 0; i3 < n; ++i3) {
            long l4 = this.latencies[i3] - l2;
            this.latencies[i3] = l4 * l4;
            l3 += this.latencies[i3];
        }
        if (n > 0) {
            l3 /= (long)n;
        }
        long l5 = 0L;
        long l6 = 0L;
        for (int i4 = 0; i4 < n; ++i4) {
            if (this.latencies[i4] > l3) continue;
            l5 += this.deltas[i4];
            ++l6;
        }
        if (l6 > 0L) {
            l5 /= l6;
        }
        this.curLatency = l;
        this.curDelta = l5;
        TraceMe.msg(TraceMe.INFO, "TimeSyncer", "Updated latency: %1 delta: %2", new Long(this.curLatency), new Long(this.curDelta));
    }

    public long getDelta() {
        return this.curDelta;
    }

    public long getLatency() {
        return this.curLatency;
    }
}

