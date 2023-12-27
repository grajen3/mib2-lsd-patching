/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.collector;

public class TVStationListCollector {
    private int presetNumber;
    private String stationName;
    private int serviceType;
    private long namePID;
    private int servicePID;

    public TVStationListCollector() {
        this.presetNumber = 0;
        this.stationName = "";
        this.serviceType = 0;
        this.namePID = 0L;
        this.servicePID = 0;
    }

    public TVStationListCollector(int n, String string, int n2, long l, int n3) {
        this.presetNumber = n;
        this.stationName = string;
        this.serviceType = n2;
        this.namePID = l;
        this.servicePID = n3;
    }

    public int getPresetNumber() {
        return this.presetNumber;
    }

    public String getStationName() {
        return this.stationName;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public long getNamePID() {
        return this.namePID;
    }

    public int getServicePID() {
        return this.servicePID;
    }
}

