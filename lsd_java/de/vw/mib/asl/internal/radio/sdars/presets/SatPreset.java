/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.presets;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetModel;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.sdars.StationInfo;

public final class SatPreset {
    private final int mIndex;
    private final SatPresetModel mModel;
    private StationInfo mStation = null;
    private int mSIDfromPersistence = 0;

    SatPreset(int n, SatPresetModel satPresetModel) {
        this.mIndex = n;
        this.mModel = satPresetModel;
    }

    int getIndex() {
        return this.mIndex;
    }

    boolean isValid() {
        return this.mStation != null;
    }

    boolean isEmpty() {
        return this.mStation == null;
    }

    public void setStationInternally(StationInfo stationInfo) {
        this.mStation = stationInfo == null ? null : new StationInfo(stationInfo.stationNumber, stationInfo.sID, stationInfo.shortLabel, stationInfo.fullLabel, stationInfo.subscription, stationInfo.categoryNumber, stationInfo.mature, stationInfo.channelArt);
    }

    void clear() {
        this.setStationInternally(null);
    }

    public void storeStationOnPreset(StationInfo stationInfo) {
        if (stationInfo == null) {
            if (this.mStation != null) {
                this.setStationInternally(null);
                this.setDirty();
                this.mModel.getPool().setInt(76, this.mIndex);
            }
        } else {
            this.setStationInternally(stationInfo);
            this.setDirty();
            this.mModel.getPool().setObject(75, this);
        }
    }

    void channelListUpdated() {
        int n = this.mStation != null ? this.mStation.getSID() : this.mSIDfromPersistence;
        if (n != 0) {
            SatDb satDb = this.mModel.getDb();
            StationInfo stationInfo = satDb.getChannels().getChannelBySID(n);
            if (stationInfo == null) {
                boolean bl = satDb.getPool().getBoolean(70);
                if (bl) {
                    LogMessage logMessage = satDb.getLogHandler().getLogMsg();
                    if (logMessage != null) {
                        logMessage.append(" remove preset during list update: ").append(n).log();
                    }
                    this.setStationInternally(null);
                    this.mSIDfromPersistence = 0;
                    this.setDirty();
                }
            } else {
                this.setStationInternally(stationInfo);
                this.mSIDfromPersistence = 0;
                this.setDirty();
            }
        }
    }

    void recall() {
        if (this.isValid()) {
            this.mModel.setCurrentIndex(this.mIndex);
            this.mModel.getDb().getTuneHandler().tuneChannel(1, this.mStation, true);
            this.mModel.getPool().setObject(77, this);
        }
    }

    void delete() {
        if (this.isValid()) {
            this.setStationInternally(null);
            this.mSIDfromPersistence = 0;
            this.setDirty();
            this.mModel.notifyPresetDeleted(this.mIndex);
        }
    }

    private void setDirty() {
        this.mModel.updateHmi();
        this.mModel.getPersistable().toPersistence();
    }

    boolean match(int n) {
        return this.isValid() && n == this.mStation.getSID();
    }

    void tune(int n) {
        if (this.isValid()) {
            this.mModel.getDb().getTuneHandler().tuneChannel(n, this.mStation, true);
        }
    }

    public StationInfo getStation() {
        return this.mStation;
    }

    public boolean isInStationListAndSubscribed() {
        SatDb satDb = this.mModel.getDb();
        if (null != satDb && null != this.mStation) {
            StationInfo stationInfo = satDb.getChannels().getChannelBySID(this.mStation.getSID());
            if (null == stationInfo) {
                return false;
            }
            return stationInfo.getSubscription() == 2;
        }
        return false;
    }
}

