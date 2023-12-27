/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSRimProtection {
    public int tireAngle;
    public int tireStateFrontLeft;
    public int tireStateFrontRight;
    public int tireStateRearLeft;
    public int tireStateRearRight;

    public VPSRimProtection() {
        this.tireAngle = 0;
        this.tireStateFrontLeft = 0;
        this.tireStateFrontRight = 0;
        this.tireStateRearLeft = 0;
        this.tireStateRearRight = 0;
    }

    public VPSRimProtection(int n, int n2, int n3, int n4, int n5) {
        this.tireAngle = n;
        this.tireStateFrontLeft = n2;
        this.tireStateFrontRight = n3;
        this.tireStateRearLeft = n4;
        this.tireStateRearRight = n5;
    }

    public int getTireAngle() {
        return this.tireAngle;
    }

    public int getTireStateFrontLeft() {
        return this.tireStateFrontLeft;
    }

    public int getTireStateFrontRight() {
        return this.tireStateFrontRight;
    }

    public int getTireStateRearLeft() {
        return this.tireStateRearLeft;
    }

    public int getTireStateRearRight() {
        return this.tireStateRearRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("VPSRimProtection");
        stringBuffer.append('(');
        stringBuffer.append("tireAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.tireAngle);
        stringBuffer.append(',');
        stringBuffer.append("tireStateFrontLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.tireStateFrontLeft);
        stringBuffer.append(',');
        stringBuffer.append("tireStateFrontRight");
        stringBuffer.append('=');
        stringBuffer.append(this.tireStateFrontRight);
        stringBuffer.append(',');
        stringBuffer.append("tireStateRearLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.tireStateRearLeft);
        stringBuffer.append(',');
        stringBuffer.append("tireStateRearRight");
        stringBuffer.append('=');
        stringBuffer.append(this.tireStateRearRight);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

