/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSSupportedSVModes {
    public boolean offroad;
    public boolean rightSideview;
    public boolean leftSideview;
    public boolean leftRightSideview;
    public boolean onlySideview;
    public boolean offroadKOG;

    public VPSSupportedSVModes() {
        this.offroad = false;
        this.rightSideview = false;
        this.leftSideview = false;
        this.leftRightSideview = false;
        this.onlySideview = false;
        this.offroadKOG = false;
    }

    public VPSSupportedSVModes(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.offroad = bl;
        this.rightSideview = bl2;
        this.leftSideview = bl3;
        this.leftRightSideview = bl4;
        this.onlySideview = bl5;
        this.offroadKOG = bl6;
    }

    public boolean isOffroad() {
        return this.offroad;
    }

    public boolean isRightSideview() {
        return this.rightSideview;
    }

    public boolean isLeftSideview() {
        return this.leftSideview;
    }

    public boolean isLeftRightSideview() {
        return this.leftRightSideview;
    }

    public boolean isOnlySideview() {
        return this.onlySideview;
    }

    public boolean isOffroadKOG() {
        return this.offroadKOG;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("VPSSupportedSVModes");
        stringBuffer.append('(');
        stringBuffer.append("offroad");
        stringBuffer.append('=');
        stringBuffer.append(this.offroad);
        stringBuffer.append(',');
        stringBuffer.append("rightSideview");
        stringBuffer.append('=');
        stringBuffer.append(this.rightSideview);
        stringBuffer.append(',');
        stringBuffer.append("leftSideview");
        stringBuffer.append('=');
        stringBuffer.append(this.leftSideview);
        stringBuffer.append(',');
        stringBuffer.append("leftRightSideview");
        stringBuffer.append('=');
        stringBuffer.append(this.leftRightSideview);
        stringBuffer.append(',');
        stringBuffer.append("onlySideview");
        stringBuffer.append('=');
        stringBuffer.append(this.onlySideview);
        stringBuffer.append(',');
        stringBuffer.append("offroadKOG");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadKOG);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

