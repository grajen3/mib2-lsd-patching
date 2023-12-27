/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class SIAOilInspection {
    public int distanceStatus;
    public int distance;
    public int distanceUnit;
    public int timeStatus;
    public int time;

    public SIAOilInspection() {
        this.distanceStatus = 0;
        this.distance = 0;
        this.distanceUnit = 0;
        this.timeStatus = 0;
        this.time = 0;
    }

    public SIAOilInspection(int n, int n2, int n3, int n4, int n5) {
        this.distanceStatus = n;
        this.distance = n2;
        this.distanceUnit = n3;
        this.timeStatus = n4;
        this.time = n5;
    }

    public int getDistanceStatus() {
        return this.distanceStatus;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public int getTimeStatus() {
        return this.timeStatus;
    }

    public int getTime() {
        return this.time;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SIAOilInspection");
        stringBuffer.append('(');
        stringBuffer.append("distanceStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceStatus);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("distanceUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceUnit);
        stringBuffer.append(',');
        stringBuffer.append("timeStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.timeStatus);
        stringBuffer.append(',');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

