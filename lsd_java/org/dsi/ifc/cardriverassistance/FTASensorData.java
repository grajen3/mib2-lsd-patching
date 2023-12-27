/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class FTASensorData {
    public int statusLevelFrontRight;
    public int statusLevelFrontLeft;

    public FTASensorData() {
        this.statusLevelFrontRight = 0;
        this.statusLevelFrontLeft = 0;
    }

    public FTASensorData(int n, int n2) {
        this.statusLevelFrontRight = n;
        this.statusLevelFrontLeft = n2;
    }

    public int getStatusLevelFrontRight() {
        return this.statusLevelFrontRight;
    }

    public int getStatusLevelFrontLeft() {
        return this.statusLevelFrontLeft;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("FTASensorData");
        stringBuffer.append('(');
        stringBuffer.append("statusLevelFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevelFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("statusLevelFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.statusLevelFrontLeft);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

