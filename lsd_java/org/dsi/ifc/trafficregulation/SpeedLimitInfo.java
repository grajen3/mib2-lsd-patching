/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

public class SpeedLimitInfo {
    public int speedLimit;
    public int speedLimitType;
    public int speedUnit;

    public SpeedLimitInfo() {
        this.speedLimit = 0;
        this.speedLimitType = 0;
        this.speedUnit = 0;
    }

    public SpeedLimitInfo(int n, int n2, int n3) {
        this.speedLimit = n;
        this.speedLimitType = n2;
        this.speedUnit = n3;
    }

    public int getSpeedLimit() {
        return this.speedLimit;
    }

    public int getSpeedLimitType() {
        return this.speedLimitType;
    }

    public int getSpeedUnit() {
        return this.speedUnit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SpeedLimitInfo");
        stringBuffer.append('(');
        stringBuffer.append("speedLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimit);
        stringBuffer.append(',');
        stringBuffer.append("speedLimitType");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimitType);
        stringBuffer.append(',');
        stringBuffer.append("speedUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedUnit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

