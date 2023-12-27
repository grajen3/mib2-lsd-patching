/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.timezone;

import de.esolutions.fw.util.commons.Buffer;

public final class TraceTimeTuple {
    private final long tzTime;
    private final long coreTime;
    private final int epoch;

    public TraceTimeTuple(long l, long l2, int n) {
        this.tzTime = l;
        this.coreTime = l2;
        this.epoch = n;
    }

    public long getTraceZoneTime() {
        return this.tzTime;
    }

    public long getCoreTime() {
        return this.coreTime;
    }

    public int getEpoch() {
        return this.epoch;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[");
        buffer.append(this.tzTime);
        buffer.append(",");
        buffer.append(this.coreTime);
        buffer.append("@");
        buffer.append(this.epoch);
        buffer.append("]");
        return buffer.toString();
    }
}

