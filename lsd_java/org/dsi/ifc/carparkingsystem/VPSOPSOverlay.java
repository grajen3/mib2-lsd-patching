/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSOPSOverlay {
    public boolean rearview;
    public boolean frontview;
    public boolean sideview;
    public boolean birdview;

    public VPSOPSOverlay() {
        this.rearview = false;
        this.frontview = false;
        this.sideview = false;
        this.birdview = false;
    }

    public VPSOPSOverlay(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.rearview = bl;
        this.frontview = bl2;
        this.sideview = bl3;
        this.birdview = bl4;
    }

    public boolean isRearview() {
        return this.rearview;
    }

    public boolean isFrontview() {
        return this.frontview;
    }

    public boolean isSideview() {
        return this.sideview;
    }

    public boolean isBirdview() {
        return this.birdview;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("VPSOPSOverlay");
        stringBuffer.append('(');
        stringBuffer.append("rearview");
        stringBuffer.append('=');
        stringBuffer.append(this.rearview);
        stringBuffer.append(',');
        stringBuffer.append("frontview");
        stringBuffer.append('=');
        stringBuffer.append(this.frontview);
        stringBuffer.append(',');
        stringBuffer.append("sideview");
        stringBuffer.append('=');
        stringBuffer.append(this.sideview);
        stringBuffer.append(',');
        stringBuffer.append("birdview");
        stringBuffer.append('=');
        stringBuffer.append(this.birdview);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

