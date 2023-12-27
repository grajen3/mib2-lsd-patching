/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RDKWheelTemperatures {
    public int temperatureUnit;
    public int frontLeft;
    public int frontRight;
    public int rearLeft;
    public int rearRight;
    public int spareWheel;

    public RDKWheelTemperatures() {
        this.temperatureUnit = 0;
        this.frontLeft = 0;
        this.frontRight = 0;
        this.rearLeft = 0;
        this.rearRight = 0;
        this.spareWheel = 0;
    }

    public RDKWheelTemperatures(int n, int n2, int n3, int n4, int n5, int n6) {
        this.temperatureUnit = n;
        this.frontLeft = n2;
        this.frontRight = n3;
        this.rearLeft = n4;
        this.rearRight = n5;
        this.spareWheel = n6;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public int getFrontLeft() {
        return this.frontLeft;
    }

    public int getFrontRight() {
        return this.frontRight;
    }

    public int getRearLeft() {
        return this.rearLeft;
    }

    public int getRearRight() {
        return this.rearRight;
    }

    public int getSpareWheel() {
        return this.spareWheel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("RDKWheelTemperatures");
        stringBuffer.append('(');
        stringBuffer.append("temperatureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.temperatureUnit);
        stringBuffer.append(',');
        stringBuffer.append("frontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.frontLeft);
        stringBuffer.append(',');
        stringBuffer.append("frontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.frontRight);
        stringBuffer.append(',');
        stringBuffer.append("rearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.rearLeft);
        stringBuffer.append(',');
        stringBuffer.append("rearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.rearRight);
        stringBuffer.append(',');
        stringBuffer.append("spareWheel");
        stringBuffer.append('=');
        stringBuffer.append(this.spareWheel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

