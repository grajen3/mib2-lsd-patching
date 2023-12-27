/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RDKWheelStates {
    public int frontLeft;
    public int frontRight;
    public int rearLeft;
    public int rearRight;
    public int spareWheel;
    public int collectedState;

    public RDKWheelStates() {
        this.frontLeft = 0;
        this.frontRight = 0;
        this.rearLeft = 0;
        this.rearRight = 0;
        this.spareWheel = 0;
        this.collectedState = 0;
    }

    public RDKWheelStates(int n, int n2, int n3, int n4, int n5, int n6) {
        this.frontLeft = n;
        this.frontRight = n2;
        this.rearLeft = n3;
        this.rearRight = n4;
        this.spareWheel = n5;
        this.collectedState = n6;
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

    public int getCollectedState() {
        return this.collectedState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("RDKWheelStates");
        stringBuffer.append('(');
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
        stringBuffer.append(',');
        stringBuffer.append("collectedState");
        stringBuffer.append('=');
        stringBuffer.append(this.collectedState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

