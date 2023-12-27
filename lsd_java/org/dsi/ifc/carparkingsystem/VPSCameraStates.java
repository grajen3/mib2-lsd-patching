/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSCameraStates {
    public int rearCamera;
    public int frontCamera;
    public int rightCamera;
    public int leftCamera;

    public VPSCameraStates() {
        this.rearCamera = 255;
        this.frontCamera = 255;
        this.rightCamera = 255;
        this.leftCamera = 255;
    }

    public VPSCameraStates(int n, int n2, int n3, int n4) {
        this.rearCamera = n;
        this.frontCamera = n2;
        this.rightCamera = n3;
        this.leftCamera = n4;
    }

    public int getRearCamera() {
        return this.rearCamera;
    }

    public int getFrontCamera() {
        return this.frontCamera;
    }

    public int getRightCamera() {
        return this.rightCamera;
    }

    public int getLeftCamera() {
        return this.leftCamera;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("VPSCameraStates");
        stringBuffer.append('(');
        stringBuffer.append("rearCamera");
        stringBuffer.append('=');
        stringBuffer.append(this.rearCamera);
        stringBuffer.append(',');
        stringBuffer.append("frontCamera");
        stringBuffer.append('=');
        stringBuffer.append(this.frontCamera);
        stringBuffer.append(',');
        stringBuffer.append("rightCamera");
        stringBuffer.append('=');
        stringBuffer.append(this.rightCamera);
        stringBuffer.append(',');
        stringBuffer.append("leftCamera");
        stringBuffer.append('=');
        stringBuffer.append(this.leftCamera);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

