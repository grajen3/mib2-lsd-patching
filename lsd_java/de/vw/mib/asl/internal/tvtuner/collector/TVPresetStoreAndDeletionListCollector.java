/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.collector;

public class TVPresetStoreAndDeletionListCollector {
    private int presetNumber;
    private String stationName;
    private boolean allocationState;

    public TVPresetStoreAndDeletionListCollector() {
        this.presetNumber = 0;
        this.stationName = "";
        this.allocationState = false;
    }

    public TVPresetStoreAndDeletionListCollector(int n, String string, boolean bl) {
        this.presetNumber = n;
        this.stationName = string;
        this.allocationState = bl;
    }

    public int getPresetNumber() {
        return this.presetNumber;
    }

    public String getStationName() {
        return this.stationName;
    }

    public boolean getAllocationState() {
        return this.allocationState;
    }
}

