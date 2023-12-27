/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

import de.esolutions.fw.util.tracing.util.Speedometer$1;

class Speedometer$Sample {
    private long delta;
    private int count;
    private long data;

    private Speedometer$Sample() {
    }

    public void set(long l, long l2) {
        this.delta = l;
        this.data = l2;
        this.count = 1;
    }

    public void add(long l) {
        this.data += l;
        ++this.count;
    }

    public long getDelta() {
        return this.delta;
    }

    public int getCounter() {
        return this.count;
    }

    public long getDataSum() {
        return this.data;
    }

    public String toString() {
        return new StringBuffer().append("d=").append(this.delta).append(",c=").append(this.count).append(",v=").append(this.data).toString();
    }

    /* synthetic */ Speedometer$Sample(Speedometer$1 speedometer$1) {
        this();
    }
}

