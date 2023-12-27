/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSDynParkingMode {
    public boolean parkbox;
    public boolean parallelToRoad;
    public boolean offroad;
    public boolean rightSideview;
    public boolean leftSideview;
    public boolean crossing;
    public boolean trailerAssist;

    public VPSDynParkingMode() {
        this.parkbox = false;
        this.parallelToRoad = false;
        this.offroad = false;
        this.rightSideview = false;
        this.leftSideview = false;
        this.crossing = false;
        this.trailerAssist = false;
    }

    public VPSDynParkingMode(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.parkbox = bl;
        this.parallelToRoad = bl2;
        this.offroad = bl3;
        this.rightSideview = bl4;
        this.leftSideview = bl5;
        this.crossing = bl6;
        this.trailerAssist = bl7;
    }

    public boolean isParkbox() {
        return this.parkbox;
    }

    public boolean isParallelToRoad() {
        return this.parallelToRoad;
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

    public boolean isCrossing() {
        return this.crossing;
    }

    public boolean isTrailerAssist() {
        return this.trailerAssist;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("VPSDynParkingMode");
        stringBuffer.append('(');
        stringBuffer.append("parkbox");
        stringBuffer.append('=');
        stringBuffer.append(this.parkbox);
        stringBuffer.append(',');
        stringBuffer.append("parallelToRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.parallelToRoad);
        stringBuffer.append(',');
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
        stringBuffer.append("crossing");
        stringBuffer.append('=');
        stringBuffer.append(this.crossing);
        stringBuffer.append(',');
        stringBuffer.append("trailerAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerAssist);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

