/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlHeightInfo {
    public short frontLeft;
    public short frontRight;
    public short rearLeft;
    public short rearRight;

    public SuspensionControlHeightInfo() {
        this.frontLeft = 0;
        this.frontRight = 0;
        this.rearLeft = 0;
        this.rearRight = 0;
    }

    public SuspensionControlHeightInfo(short s, short s2, short s3, short s4) {
        this.frontLeft = s;
        this.frontRight = s2;
        this.rearLeft = s3;
        this.rearRight = s4;
    }

    public short getFrontLeft() {
        return this.frontLeft;
    }

    public short getFrontRight() {
        return this.frontRight;
    }

    public short getRearLeft() {
        return this.rearLeft;
    }

    public short getRearRight() {
        return this.rearRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SuspensionControlHeightInfo");
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

