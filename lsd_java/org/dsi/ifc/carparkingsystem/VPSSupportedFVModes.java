/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSSupportedFVModes {
    public boolean parkbox;
    public boolean offroad;
    public boolean crossing;
    public boolean offroadKOG;

    public VPSSupportedFVModes() {
        this.parkbox = false;
        this.offroad = false;
        this.crossing = false;
        this.offroadKOG = false;
    }

    public VPSSupportedFVModes(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.parkbox = bl;
        this.offroad = bl2;
        this.crossing = bl3;
        this.offroadKOG = bl4;
    }

    public boolean isParkbox() {
        return this.parkbox;
    }

    public boolean isOffroad() {
        return this.offroad;
    }

    public boolean isCrossing() {
        return this.crossing;
    }

    public boolean isOffroadKOG() {
        return this.offroadKOG;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("VPSSupportedFVModes");
        stringBuffer.append('(');
        stringBuffer.append("parkbox");
        stringBuffer.append('=');
        stringBuffer.append(this.parkbox);
        stringBuffer.append(',');
        stringBuffer.append("offroad");
        stringBuffer.append('=');
        stringBuffer.append(this.offroad);
        stringBuffer.append(',');
        stringBuffer.append("crossing");
        stringBuffer.append('=');
        stringBuffer.append(this.crossing);
        stringBuffer.append(',');
        stringBuffer.append("offroadKOG");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadKOG);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

