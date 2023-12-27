/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.presets;

import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatPersistable;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPreset;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetTarget;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

final class SatPresetModel {
    static final int INVALID_INDEX;
    private final SatDb mDb;
    private final IAslPool mPool;
    private SatPreset[] mPresets;
    private StationInfo[] mStationsToUpdateHmi;
    private int mBankIndex = -1;
    private boolean mDisableAutocompareNow = false;
    private int mIndexOnLoad = -1;
    private int lastSelectedPresetIndex = 0;

    SatPresetModel(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        int n = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence().getSatNoOfPresets();
        this.mPresets = new SatPreset[n];
        this.mStationsToUpdateHmi = new StationInfo[n];
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2] = new SatPreset(i2, this);
        }
        new SatPresetTarget(this.mDb.getMainTarget(), this);
        this.updateHmi();
    }

    void autoCompare() {
        if (!this.mDisableAutocompareNow) {
            StationInfo stationInfo = this.mDb.getPool().getChannel(15);
            if (stationInfo != null) {
                int n;
                if (this.mIndexOnLoad != -1) {
                    if (this.mPresets[this.mIndexOnLoad].isValid() && this.mPresets[this.mIndexOnLoad].match(stationInfo.getSID())) {
                        this.setCurrentIndex(this.mIndexOnLoad);
                    }
                    this.mIndexOnLoad = -1;
                }
                if ((n = this.mPool.getInt(156)) != -1 && this.mPresets[n].isValid() && this.mPresets[n].match(stationInfo.getSID())) {
                    return;
                }
                SatPreset satPreset = this.findStation(stationInfo);
                if (satPreset != null) {
                    this.setCurrentIndex(satPreset.getIndex());
                    return;
                }
            }
            this.setCurrentIndex(-1);
        }
    }

    void createNewSatPresets() {
        try {
            SatPersistence satPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence();
            SatPreset[] satPresetArray = this.mPresets;
            this.mPresets = new SatPreset[satPersistence.getSatNoOfPresets()];
            this.mStationsToUpdateHmi = new StationInfo[satPersistence.getSatNoOfPresets()];
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                this.mPresets[i2] = new SatPreset(i2, this);
                if (null == satPresetArray || i2 >= satPresetArray.length || null == satPresetArray[i2]) continue;
                this.mPresets[i2].setStationInternally(satPresetArray[i2].getStation());
            }
            this.updateHmi();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    boolean checkIndex(int n) {
        return n >= 0 && n < this.mPresets.length;
    }

    public void clear() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].clear();
        }
    }

    void deleteAllPresets() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            this.mPresets[i2].delete();
        }
    }

    void deleteByIndex(int n) {
        if (this.checkIndex(n)) {
            this.mPresets[n].delete();
        }
    }

    void deleteBySid(int n) {
        int n2 = this.mPool.getInt(156);
        for (int i2 = this.mPresets.length - 1; i2 >= 0; --i2) {
            if (!this.mPresets[i2].match(n)) continue;
            this.mPresets[i2].delete();
            if (n2 != i2) continue;
            this.setCurrentIndex(-1);
        }
    }

    SatPreset findStation(StationInfo stationInfo) {
        if (stationInfo != null) {
            int n;
            int n2;
            int n3 = this.mBankIndex >= 0 ? this.mBankIndex : 0;
            for (n2 = n = n3 * SatConfig.mMaxPresetsPerBank; n2 < this.mPresets.length; ++n2) {
                if (!this.mPresets[n2].isValid() || !this.mPresets[n2].match(stationInfo.getSID())) continue;
                return this.mPresets[n2];
            }
            for (n2 = 0; n2 < n; ++n2) {
                if (!this.mPresets[n2].isValid() || !this.mPresets[n2].match(stationInfo.getSID())) continue;
                return this.mPresets[n2];
            }
        }
        return null;
    }

    private int getFirst() {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (!this.mPresets[i2].isValid()) continue;
            return i2;
        }
        return -1;
    }

    SatPreset getIndex() {
        int n = this.mPool.getInt(156);
        if (n >= 0 && n < this.mPresets.length) {
            return this.mPresets[n];
        }
        return null;
    }

    private int getLast() {
        for (int i2 = this.mPresets.length - 1; i2 >= 0; --i2) {
            if (!this.mPresets[i2].isValid()) continue;
            return i2;
        }
        return -1;
    }

    SatPreset getNextChannel() {
        StationInfo stationInfo;
        SatPreset satPreset;
        int n = this.mPool.getInt(156);
        int n2 = n == -1 ? ((satPreset = this.findStation(stationInfo = this.mPool.getChannel(23))) != null ? this.walk(satPreset.getIndex(), true) : this.getFirst()) : this.walk(n, true);
        this.setCurrentIndex(n2);
        return this.getIndex();
    }

    SatPreset getPreviousChannel() {
        StationInfo stationInfo;
        SatPreset satPreset;
        int n = this.mPool.getInt(156);
        int n2 = n == -1 ? ((satPreset = this.findStation(stationInfo = this.mPool.getChannel(23))) != null ? this.walk(satPreset.getIndex(), false) : this.getLast()) : this.walk(n, false);
        this.setCurrentIndex(n2);
        return this.getIndex();
    }

    SatPersistable getPersistable() {
        return this.mDb.getPersistable();
    }

    void recallPreset(int n) {
        if (this.checkIndex(n)) {
            this.mPresets[n].recall();
            StationInfo stationInfo = this.mPresets[n].getStation();
            this.mDisableAutocompareNow = stationInfo == null || stationInfo.getStationNumber() == 2;
        }
    }

    void enableAutoCompare() {
        this.mDisableAutocompareNow = false;
        this.autoCompare();
    }

    void disableAutocompare() {
        this.mDisableAutocompareNow = true;
    }

    public void setBankIndex(int n) {
        if (n >= 0 && n < SatConfig.mMaxPresetBanks && n != this.mBankIndex) {
            this.mBankIndex = n;
            this.updateBankIndex();
            this.getPersistable().toPersistence();
        }
    }

    void setCurrentIndex(int n) {
        if (n >= 0) {
            this.lastSelectedPresetIndex = n;
        }
        if (this.checkIndex(n) || n == -1) {
            this.mPool.setInt(156, n);
        }
    }

    public int getLastSelectedPresetIndex() {
        return this.lastSelectedPresetIndex;
    }

    ResourceLocator getCurrentImage() {
        try {
            SatPreset satPreset = this.getIndex();
            if (null != satPreset && null != satPreset.getStation()) {
                return this.mDb.getImageDb().getImage(satPreset.getStation().getSID());
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
        return null;
    }

    void storeStationOnPreset(int n, StationInfo stationInfo) {
        if (this.checkIndex(n)) {
            this.mPresets[n].storeStationOnPreset(stationInfo);
            StationInfo stationInfo2 = this.mPool.getChannel(23);
            if (stationInfo.sID == stationInfo2.sID) {
                this.setCurrentIndex(n);
            } else {
                this.autoCompare();
            }
            if (null != stationInfo && stationInfo.getChannelArt() != null) {
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
            }
            RadioSystemEventsUtil.sendPresetStored();
        }
    }

    void updateBankIndex() {
        this.mPool.setInt(158, this.mBankIndex * SatConfig.mMaxPresetsPerBank);
    }

    public void updateHmi() {
        int n = -1;
        int n2 = -1;
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (this.mPresets[i2].isEmpty()) {
                if (n == -1) {
                    n = i2;
                }
                this.mStationsToUpdateHmi[i2] = null;
                continue;
            }
            if (n2 == -1) {
                n2 = i2;
            }
            this.mStationsToUpdateHmi[i2] = this.mPresets[i2].getStation();
        }
        SatModelApi satModelApi = this.mDb.getModelApi();
        this.mPool.setInt(155, n);
        this.mPool.setInt(157, n2);
        satModelApi.updatePresetListInfo(this.mStationsToUpdateHmi);
    }

    private int walk(int n, boolean bl) {
        int n2 = n;
        int n3 = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence().getSatNoOfPresets();
        do {
            if (bl) {
                if (++n2 >= n3) {
                    n2 = 0;
                }
            } else if (--n2 < 0) {
                n2 = n3 - 1;
            }
            if (null == this.mPresets[n2] || !this.mPresets[n2].isValid() || !this.mPresets[n2].isInStationListAndSubscribed()) continue;
            return n2;
        } while (n2 != n);
        return n2;
    }

    void notifyPresetDeleted(int n) {
        int n2 = this.mPool.getInt(156);
        if (n2 == n && n != -1) {
            this.setCurrentIndex(-1);
            this.autoCompare();
            RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
        }
    }

    void resetSettings() {
        this.deleteAllPresets();
        this.storeStationOnPreset(0, SatConfig.DEFAULT_CHANNEL);
        this.setBankIndex(0);
    }

    SatDb getDb() {
        return this.mDb;
    }

    IAslPool getPool() {
        return this.mDb.getPool();
    }

    StationInfo[] getPresets() {
        StationInfo[] stationInfoArray = new StationInfo[RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence().getSatNoOfPresets()];
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            stationInfoArray[i2] = this.mPresets[i2].isEmpty() ? null : this.mPresets[i2].getStation();
        }
        return stationInfoArray;
    }

    public void checkPresetsAfterChannelListUpdate() {
        if (this.mDb.getChannels().isValid()) {
            for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                this.mPresets[i2].channelListUpdated();
            }
        }
        this.autoCompare();
    }

    public SatPreset findStation(int n) {
        for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
            if (!this.mPresets[i2].isValid() || !this.mPresets[i2].match(n)) continue;
            return this.mPresets[i2];
        }
        return null;
    }

    public SatPreset[] getSatPreset() {
        return this.mPresets;
    }

    public int getCurrentPresetsBankIndex() {
        return this.mBankIndex;
    }

    public void setIndexOnLoad(int n) {
        this.mIndexOnLoad = n;
    }
}

