/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

public class DrvSchoolSpeedData {
    public int speed = 0;
    public int unit = 0;

    public DrvSchoolSpeedData() {
    }

    public DrvSchoolSpeedData(int n, int n2) {
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getUnit() {
        return this.unit;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DrvSchoolSpeedData");
        stringBuffer.append('(');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("unit");
        stringBuffer.append('=');
        stringBuffer.append(this.unit);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

