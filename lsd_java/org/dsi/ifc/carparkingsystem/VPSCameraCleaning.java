/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSCameraCleaning {
    public boolean rearCamera;

    public VPSCameraCleaning() {
        this.rearCamera = false;
    }

    public VPSCameraCleaning(boolean bl) {
        this.rearCamera = bl;
    }

    public boolean isRearCamera() {
        return this.rearCamera;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("VPSCameraCleaning");
        stringBuffer.append('(');
        stringBuffer.append("rearCamera");
        stringBuffer.append('=');
        stringBuffer.append(this.rearCamera);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

