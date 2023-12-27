/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RDKWheelPressures {
    public int pressureUnit;
    public int frontLeft;
    public int frontRight;
    public int rearLeft;
    public int rearRight;
    public int spareWheel;

    public RDKWheelPressures() {
        this.pressureUnit = 0;
        this.frontLeft = 0;
        this.frontRight = 0;
        this.rearLeft = 0;
        this.rearRight = 0;
        this.spareWheel = 0;
    }

    public RDKWheelPressures(int n, int n2, int n3, int n4, int n5, int n6) {
        this.pressureUnit = n;
        this.frontLeft = n2;
        this.frontRight = n3;
        this.rearLeft = n4;
        this.rearRight = n5;
        this.spareWheel = n6;
    }

    public int getPressureUnit() {
        return this.pressureUnit;
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
        stringBuffer.append("RDKWheelPressures");
        stringBuffer.append('(');
        stringBuffer.append("pressureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureUnit);
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

