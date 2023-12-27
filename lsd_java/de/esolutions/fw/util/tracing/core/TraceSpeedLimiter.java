/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.core.TraceCoreStats;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public class TraceSpeedLimiter {
    private final TraceCoreStats stats;
    private int totalSize;
    private int totalCount;
    private int checkIntervals;
    private int[] sizeLimits;
    private int[] countLimits;
    private final ITimeSource timeSource;
    private final int sampleBufSize;
    private final long[] sampleTs;
    private final int[] sampleSize;
    private int sampleOffset;
    private int sampleNum;

    public TraceSpeedLimiter(TraceConfig traceConfig, TraceCoreStats traceCoreStats, ITimeSource iTimeSource) {
        this.stats = traceCoreStats;
        this.timeSource = iTimeSource;
        traceCoreStats.registerKey("sc", 12);
        traceCoreStats.registerKey("sb", 12);
        this.checkIntervals = traceConfig.getCheckIntervals();
        if (this.checkIntervals < 1) {
            this.checkIntervals = 1;
        }
        int n = traceConfig.getLowerSizeLimit();
        int n2 = traceConfig.getUpperSizeLimit();
        int n3 = traceConfig.getLowerCountLimit();
        int n4 = traceConfig.getUpperCountLimit();
        int n5 = traceConfig.getMaxCount();
        if (n2 < 0) {
            n2 = 0;
        }
        if (n4 < 0) {
            n4 = 0;
        }
        if (n <= 0 || n > n2) {
            n = n2;
        }
        if (n3 <= 0 || n3 > n4) {
            n3 = n4;
        }
        int n6 = 5;
        this.sizeLimits = new int[n6 + 1];
        this.countLimits = new int[n6 + 1];
        for (int i2 = 0; i2 <= n6; ++i2) {
            float f2 = (n2 - n) * i2 / n6 + n;
            float f3 = (n4 - n3) * i2 / n6 + n3;
            this.sizeLimits[i2] = (int)(f2 * (float)this.checkIntervals / 31300 + 63);
            this.countLimits[i2] = (int)(f3 * (float)this.checkIntervals / 31300 + 63);
            TraceMe.msg(TraceMe.DEBUG, "speed", "speed limiter: level=%1, size=%2, count=%3", new Integer(i2), new Integer(this.sizeLimits[i2]), new Integer(this.countLimits[i2]));
        }
        this.sampleBufSize = n4 > 0 ? n4 : n5;
        this.sampleTs = new long[this.sampleBufSize];
        this.sampleSize = new int[this.sampleBufSize];
        this.sampleOffset = 0;
        this.sampleNum = 0;
    }

    public int[] getSizeLimits() {
        return this.sizeLimits;
    }

    public int[] getCountLimits() {
        return this.countLimits;
    }

    public int getSampleBufferSize() {
        return this.sampleBufSize;
    }

    public boolean check(ITraceMessage iTraceMessage, boolean bl) {
        return this.check(iTraceMessage.getMessageData().length, iTraceMessage.getLevel(), bl);
    }

    public boolean check(int n, short s, boolean bl) {
        long l = this.timeSource.getCurrentTime();
        boolean bl2 = this.moveWindow(l - (long)this.checkIntervals);
        boolean bl3 = this.tryStore(l, n, s, bl);
        if (bl2 || bl3) {
            this.stats.updateKey("sc", this.totalCount);
            this.stats.updateKey("sb", this.totalSize);
        }
        return bl3;
    }

    private boolean tryStore(long l, int n, short s, boolean bl) {
        int n2 = this.totalSize + n;
        int n3 = this.totalCount + 1 + (bl ? 1 : 0);
        TraceMe.msg(TraceMe.DEBUG, "speed", "speed limiter: size=%1/%2, count=%3/%4", new Integer(n2), new Integer(this.sizeLimits[s]), new Integer(n3), new Integer(this.countLimits[s]));
        int n4 = this.countLimits[s];
        if (n4 > 0 && n3 > n4) {
            return false;
        }
        int n5 = this.sizeLimits[s];
        if (n5 > 0 && n2 > n5) {
            return false;
        }
        this.totalCount = n3;
        this.totalSize = n2;
        this.add(l, n);
        if (bl) {
            this.add(l, 0);
        }
        return true;
    }

    private void add(long l, int n) {
        if (this.sampleNum < this.sampleBufSize) {
            int n2 = (this.sampleOffset + this.sampleNum) % this.sampleTs.length;
            this.sampleTs[n2] = l;
            this.sampleSize[n2] = n;
            ++this.sampleNum;
        }
    }

    private boolean moveWindow(long l) {
        if (l < 0L) {
            return false;
        }
        boolean bl = false;
        while (this.sampleNum > 0) {
            long l2 = this.sampleTs[this.sampleOffset];
            int n = this.sampleSize[this.sampleOffset];
            if (l2 > l) break;
            --this.totalCount;
            this.totalSize -= n;
            ++this.sampleOffset;
            if (this.sampleOffset == this.sampleTs.length) {
                this.sampleOffset = 0;
            }
            --this.sampleNum;
            bl = true;
        }
        return bl;
    }
}

