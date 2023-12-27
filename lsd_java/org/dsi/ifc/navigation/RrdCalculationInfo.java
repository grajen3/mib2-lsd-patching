/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class RrdCalculationInfo {
    public int rrdInfo;
    public long rttInfo;

    public RrdCalculationInfo() {
        this.rrdInfo = 0;
        this.rttInfo = 0L;
    }

    public RrdCalculationInfo(int n, long l) {
        this.rrdInfo = n;
        this.rttInfo = l;
    }

    public int getRrdInfo() {
        return this.rrdInfo;
    }

    public long getRttInfo() {
        return this.rttInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("RrdCalculationInfo");
        stringBuffer.append('(');
        stringBuffer.append("rrdInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.rrdInfo);
        stringBuffer.append(',');
        stringBuffer.append("rttInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.rttInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

