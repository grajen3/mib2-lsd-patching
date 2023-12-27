/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSVideoInfo {
    public boolean trailerHitched;
    public boolean trunkOpen;
    public boolean speedToHigh;
    public boolean calibration;
    public boolean guidelinesLeftSide;
    public boolean guidelinesRightSide;
    public boolean extMirrorFolded;

    public VPSVideoInfo() {
        this.trailerHitched = false;
        this.trunkOpen = false;
        this.speedToHigh = false;
        this.calibration = false;
        this.guidelinesLeftSide = false;
        this.guidelinesRightSide = false;
        this.extMirrorFolded = false;
    }

    public VPSVideoInfo(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.trailerHitched = bl;
        this.trunkOpen = bl2;
        this.speedToHigh = bl3;
        this.calibration = bl4;
        this.guidelinesLeftSide = bl5;
        this.guidelinesRightSide = bl6;
        this.extMirrorFolded = bl7;
    }

    public boolean isTrailerHitched() {
        return this.trailerHitched;
    }

    public boolean isTrunkOpen() {
        return this.trunkOpen;
    }

    public boolean isSpeedToHigh() {
        return this.speedToHigh;
    }

    public boolean isCalibration() {
        return this.calibration;
    }

    public boolean isGuidelinesLeftSide() {
        return this.guidelinesLeftSide;
    }

    public boolean isGuidelinesRightSide() {
        return this.guidelinesRightSide;
    }

    public boolean isExtMirrorFolded() {
        return this.extMirrorFolded;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("VPSVideoInfo");
        stringBuffer.append('(');
        stringBuffer.append("trailerHitched");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerHitched);
        stringBuffer.append(',');
        stringBuffer.append("trunkOpen");
        stringBuffer.append('=');
        stringBuffer.append(this.trunkOpen);
        stringBuffer.append(',');
        stringBuffer.append("speedToHigh");
        stringBuffer.append('=');
        stringBuffer.append(this.speedToHigh);
        stringBuffer.append(',');
        stringBuffer.append("calibration");
        stringBuffer.append('=');
        stringBuffer.append(this.calibration);
        stringBuffer.append(',');
        stringBuffer.append("guidelinesLeftSide");
        stringBuffer.append('=');
        stringBuffer.append(this.guidelinesLeftSide);
        stringBuffer.append(',');
        stringBuffer.append("guidelinesRightSide");
        stringBuffer.append('=');
        stringBuffer.append(this.guidelinesRightSide);
        stringBuffer.append(',');
        stringBuffer.append("extMirrorFolded");
        stringBuffer.append('=');
        stringBuffer.append(this.extMirrorFolded);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

