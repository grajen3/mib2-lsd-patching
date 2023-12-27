/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

public class VolumeRange {
    public int min;
    public int max;

    public int getMin() {
        return this.min;
    }

    public void setMin(int n) {
        this.min = n;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int n) {
        this.max = n;
    }

    public VolumeRange() {
    }

    public VolumeRange(int n, int n2) {
        this.min = n;
        this.max = n2;
    }

    public String toString() {
        return new StringBuffer("VolumeRange{").append("min=").append(this.min).append(", max=").append(this.max).append("}").toString();
    }
}

