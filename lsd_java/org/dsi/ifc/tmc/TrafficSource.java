/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

public class TrafficSource {
    public int trafficSourceType;
    public String trafficSourceName;
    public int trafficSourceState;

    public TrafficSource() {
        this.trafficSourceType = 0;
        this.trafficSourceName = null;
        this.trafficSourceState = 0;
    }

    public TrafficSource(int n, String string) {
        this.trafficSourceType = n;
        this.trafficSourceName = string;
        this.trafficSourceState = 0;
    }

    public TrafficSource(int n, String string, int n2) {
        this.trafficSourceType = n;
        this.trafficSourceName = string;
        this.trafficSourceState = n2;
    }

    public int getTrafficSourceType() {
        return this.trafficSourceType;
    }

    public String getTrafficSourceName() {
        return this.trafficSourceName;
    }

    public int getTrafficSourceState() {
        return this.trafficSourceState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("TrafficSource");
        stringBuffer.append('(');
        stringBuffer.append("trafficSourceType");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSourceType);
        stringBuffer.append(',');
        stringBuffer.append("trafficSourceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.trafficSourceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("trafficSourceState");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSourceState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

