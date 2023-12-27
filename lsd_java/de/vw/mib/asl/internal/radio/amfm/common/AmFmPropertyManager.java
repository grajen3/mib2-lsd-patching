/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.common;

public final class AmFmPropertyManager {
    private static boolean manualModeActive = false;
    private static int manualModeFrequency = 0;
    private boolean reloadList = false;
    private boolean stationTuned = false;
    private int signalLostStationFrequency = 0;
    private int signalLostStationServiceId = -1;
    private boolean presetTune = false;
    private boolean _wavebandChanged = false;

    public boolean isWavebandChanged() {
        return this._wavebandChanged;
    }

    public void setWavebandChanged(boolean bl) {
        this._wavebandChanged = bl;
    }

    public void setManualModeActive(boolean bl) {
        manualModeActive = bl;
    }

    public boolean getManualModeActive() {
        return manualModeActive;
    }

    public void setManualModeFrequency(int n) {
        manualModeFrequency = n;
    }

    public int getManualModeFrequency() {
        return manualModeFrequency;
    }

    public boolean isReloadList() {
        return this.reloadList;
    }

    public void setReloadList(boolean bl) {
        this.reloadList = bl;
    }

    public void setStationTuneStarted(boolean bl) {
        this.stationTuned = bl;
        if (!bl) {
            this.setPresetTuned(bl);
        }
    }

    public boolean isStationTuneStarted() {
        return this.stationTuned;
    }

    public void setHDSingalLostStation(int n, int n2) {
        this.signalLostStationFrequency = n;
        this.signalLostStationServiceId = n2;
    }

    public int getHDSignalLostStationFrequency() {
        return this.signalLostStationFrequency;
    }

    public int getHDSignalLostStationServiceId() {
        return this.signalLostStationServiceId;
    }

    public boolean isHDSignalLostStationActive() {
        return this.signalLostStationFrequency != 0 && this.signalLostStationServiceId != -1;
    }

    public boolean isPresetTuned() {
        return this.presetTune;
    }

    public void setPresetTuned(boolean bl) {
        this.presetTune = bl;
    }
}

