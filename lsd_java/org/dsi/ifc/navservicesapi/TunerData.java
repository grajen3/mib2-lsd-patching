/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class TunerData {
    public String stationName;
    public long frequency;

    public TunerData() {
        this.stationName = null;
        this.frequency = 0L;
    }

    public TunerData(String string, long l) {
        this.stationName = string;
        this.frequency = l;
    }

    public String getStationName() {
        return this.stationName;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("TunerData");
        stringBuffer.append('(');
        stringBuffer.append("stationName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.stationName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

