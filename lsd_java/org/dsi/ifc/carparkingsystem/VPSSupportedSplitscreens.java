/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSSupportedSplitscreens {
    public boolean parkbox;
    public boolean parallelToRoad;
    public boolean offroad;
    public boolean crossing;
    public boolean trailerAssist;
    public boolean sideview;

    public VPSSupportedSplitscreens() {
        this.parkbox = false;
        this.parallelToRoad = false;
        this.offroad = false;
        this.crossing = false;
        this.trailerAssist = false;
        this.sideview = false;
    }

    public VPSSupportedSplitscreens(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.parkbox = bl;
        this.parallelToRoad = bl2;
        this.offroad = bl3;
        this.crossing = bl4;
        this.trailerAssist = bl5;
        this.sideview = bl6;
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

    public boolean isCrossing() {
        return this.crossing;
    }

    public boolean isTrailerAssist() {
        return this.trailerAssist;
    }

    public boolean isSideview() {
        return this.sideview;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("VPSSupportedSplitscreens");
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
        stringBuffer.append("crossing");
        stringBuffer.append('=');
        stringBuffer.append(this.crossing);
        stringBuffer.append(',');
        stringBuffer.append("trailerAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerAssist);
        stringBuffer.append(',');
        stringBuffer.append("sideview");
        stringBuffer.append('=');
        stringBuffer.append(this.sideview);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

