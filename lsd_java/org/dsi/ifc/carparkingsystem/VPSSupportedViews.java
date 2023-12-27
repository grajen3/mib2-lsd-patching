/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSSupportedViews {
    public boolean rearview;
    public boolean frontview;
    public boolean leftsideview;
    public boolean rightsideview;
    public boolean birdview;
    public boolean extCam;

    public VPSSupportedViews() {
        this.rearview = false;
        this.frontview = false;
        this.leftsideview = false;
        this.rightsideview = false;
        this.birdview = false;
        this.extCam = false;
    }

    public VPSSupportedViews(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.rearview = bl;
        this.frontview = bl2;
        this.leftsideview = bl3;
        this.rightsideview = bl4;
        this.birdview = bl5;
        this.extCam = bl6;
    }

    public boolean isRearview() {
        return this.rearview;
    }

    public boolean isFrontview() {
        return this.frontview;
    }

    public boolean isLeftsideview() {
        return this.leftsideview;
    }

    public boolean isRightsideview() {
        return this.rightsideview;
    }

    public boolean isBirdview() {
        return this.birdview;
    }

    public boolean isExtCam() {
        return this.extCam;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("VPSSupportedViews");
        stringBuffer.append('(');
        stringBuffer.append("rearview");
        stringBuffer.append('=');
        stringBuffer.append(this.rearview);
        stringBuffer.append(',');
        stringBuffer.append("frontview");
        stringBuffer.append('=');
        stringBuffer.append(this.frontview);
        stringBuffer.append(',');
        stringBuffer.append("leftsideview");
        stringBuffer.append('=');
        stringBuffer.append(this.leftsideview);
        stringBuffer.append(',');
        stringBuffer.append("rightsideview");
        stringBuffer.append('=');
        stringBuffer.append(this.rightsideview);
        stringBuffer.append(',');
        stringBuffer.append("birdview");
        stringBuffer.append('=');
        stringBuffer.append(this.birdview);
        stringBuffer.append(',');
        stringBuffer.append("extCam");
        stringBuffer.append('=');
        stringBuffer.append(this.extCam);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

