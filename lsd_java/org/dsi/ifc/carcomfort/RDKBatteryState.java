/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class RDKBatteryState {
    public boolean okFrontLeft;
    public boolean okFrontRight;
    public boolean okRearLeft;
    public boolean okRearRight;
    public boolean okSpareWheel;

    public RDKBatteryState() {
        this.okFrontLeft = false;
        this.okFrontRight = false;
        this.okRearLeft = false;
        this.okRearRight = false;
        this.okSpareWheel = false;
    }

    public RDKBatteryState(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.okFrontLeft = bl;
        this.okFrontRight = bl2;
        this.okRearLeft = bl3;
        this.okRearRight = bl4;
        this.okSpareWheel = bl5;
    }

    public boolean isOkFrontLeft() {
        return this.okFrontLeft;
    }

    public boolean isOkFrontRight() {
        return this.okFrontRight;
    }

    public boolean isOkRearLeft() {
        return this.okRearLeft;
    }

    public boolean isOkRearRight() {
        return this.okRearRight;
    }

    public boolean isOkSpareWheel() {
        return this.okSpareWheel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("RDKBatteryState");
        stringBuffer.append('(');
        stringBuffer.append("okFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.okFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("okFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.okFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("okRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.okRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("okRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.okRearRight);
        stringBuffer.append(',');
        stringBuffer.append("okSpareWheel");
        stringBuffer.append('=');
        stringBuffer.append(this.okSpareWheel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

