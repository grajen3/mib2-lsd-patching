/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

public class RouteProviderSetting {
    public int clientID;
    public int resolutionInMeter;
    public int maxRangeInMeter;
    public int offsetInMeter;
    public int includeStopOvers;

    public int getClientID() {
        return this.clientID;
    }

    public void setClientID(int n) {
        this.clientID = n;
    }

    public int getResolutionInMeter() {
        return this.resolutionInMeter;
    }

    public void setResolutionInMeter(int n) {
        this.resolutionInMeter = n;
    }

    public int getMaxRangeInMeter() {
        return this.maxRangeInMeter;
    }

    public void setMaxRangeInMeter(int n) {
        this.maxRangeInMeter = n;
    }

    public int getOffsetInMeter() {
        return this.offsetInMeter;
    }

    public void setOffsetInMeter(int n) {
        this.offsetInMeter = n;
    }

    public int getIncludeStopOvers() {
        return this.includeStopOvers;
    }

    public void setIncludeStopOvers(int n) {
        this.includeStopOvers = n;
    }

    public RouteProviderSetting() {
    }

    public RouteProviderSetting(int n, int n2, int n3, int n4, int n5) {
        this.clientID = n;
        this.resolutionInMeter = n2;
        this.maxRangeInMeter = n3;
        this.offsetInMeter = n4;
        this.includeStopOvers = n5;
    }

    public String toString() {
        return new StringBuffer("RouteProviderSetting{").append("clientID=").append(this.clientID).append(", resolutionInMeter=").append(this.resolutionInMeter).append(", maxRangeInMeter=").append(this.maxRangeInMeter).append(", offsetInMeter=").append(this.offsetInMeter).append(", includeStopOvers=").append(this.includeStopOvers).append("}").toString();
    }
}

