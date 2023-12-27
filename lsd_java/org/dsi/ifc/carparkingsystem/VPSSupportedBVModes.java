/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSSupportedBVModes {
    public boolean parkbox;
    public boolean offroad;
    public boolean mainMode;
    public boolean offroadKOG;
    public boolean birdview3D;

    public VPSSupportedBVModes() {
        this.parkbox = false;
        this.offroad = false;
        this.mainMode = false;
        this.offroadKOG = false;
        this.birdview3D = false;
    }

    public VPSSupportedBVModes(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.parkbox = bl;
        this.offroad = bl2;
        this.mainMode = bl3;
        this.offroadKOG = bl4;
        this.birdview3D = bl5;
    }

    public boolean isParkbox() {
        return this.parkbox;
    }

    public boolean isOffroad() {
        return this.offroad;
    }

    public boolean isMainMode() {
        return this.mainMode;
    }

    public boolean isOffroadKOG() {
        return this.offroadKOG;
    }

    public boolean isBirdview3D() {
        return this.birdview3D;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("VPSSupportedBVModes");
        stringBuffer.append('(');
        stringBuffer.append("parkbox");
        stringBuffer.append('=');
        stringBuffer.append(this.parkbox);
        stringBuffer.append(',');
        stringBuffer.append("offroad");
        stringBuffer.append('=');
        stringBuffer.append(this.offroad);
        stringBuffer.append(',');
        stringBuffer.append("mainMode");
        stringBuffer.append('=');
        stringBuffer.append(this.mainMode);
        stringBuffer.append(',');
        stringBuffer.append("offroadKOG");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadKOG);
        stringBuffer.append(',');
        stringBuffer.append("birdview3D");
        stringBuffer.append('=');
        stringBuffer.append(this.birdview3D);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

