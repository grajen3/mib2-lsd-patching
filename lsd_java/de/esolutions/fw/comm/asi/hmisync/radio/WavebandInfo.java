/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

public class WavebandInfo {
    public int bandId;
    public int minFrequency;
    public int maxFrequency;
    public int stepWidth;

    public int getBandId() {
        return this.bandId;
    }

    public void setBandId(int n) {
        this.bandId = n;
    }

    public int getMinFrequency() {
        return this.minFrequency;
    }

    public void setMinFrequency(int n) {
        this.minFrequency = n;
    }

    public int getMaxFrequency() {
        return this.maxFrequency;
    }

    public void setMaxFrequency(int n) {
        this.maxFrequency = n;
    }

    public int getStepWidth() {
        return this.stepWidth;
    }

    public void setStepWidth(int n) {
        this.stepWidth = n;
    }

    public WavebandInfo() {
    }

    public WavebandInfo(int n, int n2, int n3, int n4) {
        this.bandId = n;
        this.minFrequency = n2;
        this.maxFrequency = n3;
        this.stepWidth = n4;
    }

    public String toString() {
        return new StringBuffer("WavebandInfo{").append("bandId=").append(this.bandId).append(", minFrequency=").append(this.minFrequency).append(", maxFrequency=").append(this.maxFrequency).append(", stepWidth=").append(this.stepWidth).append("}").toString();
    }
}

