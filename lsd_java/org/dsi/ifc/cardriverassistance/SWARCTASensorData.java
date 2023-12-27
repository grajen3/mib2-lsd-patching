/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class SWARCTASensorData {
    public int statusLevelRearRight;
    public int distanceRearRight;
    public int statusLevelRearLeft;
    public int distanceRearLeft;

    public SWARCTASensorData() {
        this.statusLevelRearRight = 0;
        this.distanceRearRight = 0;
        this.statusLevelRearLeft = 0;
        this.distanceRearLeft = 0;
    }

    public SWARCTASensorData(int n, int n2, int n3, int n4) {
        this.statusLevelRearRight = n;
        this.distanceRearRight = n2;
        this.statusLevelRearLeft = n3;
        this.distanceRearLeft = n4;
    }

    public int getStatusLevelRearRight() {
        return this.statusLevelRearRight;
    }

    public int getDistanceRearRight() {
        return this.distanceRearRight;
    }

    public int getStatusLevelRearLeft() {
        return this.statusLevelRearLeft;
    }

    public int getDistanceRearLeft() {
        return this.distanceRearLeft;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SWARCTASensorData");
        stringBuffer.append('(');
        stringBuffer.append("statusLevelRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevelRearRight);
        stringBuffer.append(',');
        stringBuffer.append("distanceRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceRearRight);
        stringBuffer.append(',');
        stringBuffer.append("statusLevelRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevelRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("distanceRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceRearLeft);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

