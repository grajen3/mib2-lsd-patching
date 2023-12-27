/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class VPSSupportedRVModes {
    public boolean parkbox;
    public boolean parallelToRoad;
    public boolean crossing;
    public boolean trailerAssist;
    public boolean offroadKOG;
    public boolean trailerAssistARA;

    public VPSSupportedRVModes() {
        this.parkbox = false;
        this.parallelToRoad = false;
        this.crossing = false;
        this.trailerAssist = false;
        this.offroadKOG = false;
        this.trailerAssistARA = false;
    }

    public VPSSupportedRVModes(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.parkbox = bl;
        this.parallelToRoad = bl2;
        this.crossing = bl3;
        this.trailerAssist = bl4;
        this.offroadKOG = bl5;
        this.trailerAssistARA = bl6;
    }

    public boolean isParkbox() {
        return this.parkbox;
    }

    public boolean isParallelToRoad() {
        return this.parallelToRoad;
    }

    public boolean isCrossing() {
        return this.crossing;
    }

    public boolean isOffroadKOG() {
        return this.offroadKOG;
    }

    public boolean isTrailerAssist() {
        return this.trailerAssist;
    }

    public boolean isTrailerAssistARA() {
        return this.trailerAssistARA;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("VPSSupportedRVModes");
        stringBuffer.append('(');
        stringBuffer.append("parkbox");
        stringBuffer.append('=');
        stringBuffer.append(this.parkbox);
        stringBuffer.append(',');
        stringBuffer.append("parallelToRoad");
        stringBuffer.append('=');
        stringBuffer.append(this.parallelToRoad);
        stringBuffer.append(',');
        stringBuffer.append("crossing");
        stringBuffer.append('=');
        stringBuffer.append(this.crossing);
        stringBuffer.append(',');
        stringBuffer.append("trailerAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerAssist);
        stringBuffer.append(',');
        stringBuffer.append("offroadKOG");
        stringBuffer.append('=');
        stringBuffer.append(this.offroadKOG);
        stringBuffer.append(',');
        stringBuffer.append("trailerAssistARA");
        stringBuffer.append('=');
        stringBuffer.append(this.trailerAssistARA);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

