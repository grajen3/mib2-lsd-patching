/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class WavebandInfo {
    public int waveband;
    public long lowerLimit;
    public long upperLimit;
    public long stepWidth;
    public long multiplier;

    public WavebandInfo() {
        this.waveband = 0;
        this.lowerLimit = 0L;
        this.upperLimit = 0L;
        this.stepWidth = 0L;
        this.multiplier = 0L;
    }

    public WavebandInfo(int n, long l, long l2, long l3, long l4) {
        this.waveband = n;
        this.lowerLimit = l;
        this.upperLimit = l2;
        this.stepWidth = l3;
        this.multiplier = l4;
    }

    public int getWaveband() {
        return this.waveband;
    }

    public long getLowerLimit() {
        return this.lowerLimit;
    }

    public long getUpperLimit() {
        return this.upperLimit;
    }

    public long getStepWidth() {
        return this.stepWidth;
    }

    public long getMultiplier() {
        return this.multiplier;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("WavebandInfo");
        stringBuffer.append('(');
        stringBuffer.append("waveband");
        stringBuffer.append('=');
        stringBuffer.append(this.waveband);
        stringBuffer.append(',');
        stringBuffer.append("lowerLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.lowerLimit);
        stringBuffer.append(',');
        stringBuffer.append("upperLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.upperLimit);
        stringBuffer.append(',');
        stringBuffer.append("stepWidth");
        stringBuffer.append('=');
        stringBuffer.append(this.stepWidth);
        stringBuffer.append(',');
        stringBuffer.append("multiplier");
        stringBuffer.append('=');
        stringBuffer.append(this.multiplier);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

