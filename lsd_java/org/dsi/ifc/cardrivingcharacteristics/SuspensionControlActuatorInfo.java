/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlActuatorInfo {
    public int frontLeft;
    public int frontRight;
    public int rearLeft;
    public int rearRight;

    public SuspensionControlActuatorInfo() {
        this.frontLeft = 101;
        this.frontRight = 101;
        this.rearLeft = 101;
        this.rearRight = 101;
    }

    public SuspensionControlActuatorInfo(int n, int n2, int n3, int n4) {
        this.frontLeft = n;
        this.frontRight = n2;
        this.rearLeft = n3;
        this.rearRight = n4;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SuspensionControlActuatorInfo");
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

