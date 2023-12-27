/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.collector;

public class PresetListCollector {
    private int presetNumber;
    private String stationName;
    private int serviceType;

    public PresetListCollector() {
        this.presetNumber = 0;
        this.stationName = "";
        this.serviceType = 0;
    }

    public PresetListCollector(int n, String string, int n2) {
        this.presetNumber = n;
        this.stationName = string;
        this.serviceType = n2;
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
}

