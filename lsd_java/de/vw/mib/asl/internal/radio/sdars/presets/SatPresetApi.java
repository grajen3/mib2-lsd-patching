/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.presets;

import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPreset;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPresetModel;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public final class SatPresetApi {
    static final int INVALID_INDEX;
    private final SatDb mDb;
    private SatPresetModel mModel;
    private static int satPresetCountFromModel;
    private static boolean satPresetsLoadedAndInitialized;
    private boolean satPresetCountTriggeredFromModel = false;

    public SatPresetApi(SatDb satDb) {
        this.mDb = satDb;
    }

    public static boolean isSatPresetsLoadedAndInitialized() {
        return satPresetsLoadedAndInitialized;
    }

    public void setPresetsLoadedAndInitialized(boolean bl) {
        try {
            satPresetsLoadedAndInitialized = bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void startModule() {
        if (this.mModel == null) {
            this.mModel = new SatPresetModel(this.mDb);
        }
    }

    public void storeStationOnPreset(int n, StationInfo stationInfo) {
        if (null != this.mModel) {
            this.mModel.storeStationOnPreset(n, stationInfo);
        }
    }

    public void notifyChannelTuned() {
        if (null != this.mModel) {
            this.mModel.autoCompare();
        }
    }

    public void deleteBySID(int n) {
        if (null != this.mModel) {
            this.mModel.deleteBySid(n);
        }
    }

    public int findStation(StationInfo stationInfo) {
        SatPreset satPreset;
        if (this.mModel != null && (satPreset = this.mModel.findStation(stationInfo)) != null) {
            return satPreset.getIndex();
        }
        return -1;
    }

    public StationInfo findStation(int n) {
        SatPreset satPreset;
        if (this.mModel != null && (satPreset = this.mModel.findStation(n)) != null) {
            return satPreset.getStation();
        }
        return null;
    }

    public void setIndex(int n) {
        if (null != this.mModel) {
            this.mModel.setCurrentIndex(n);
        }
    }

    public void setBankIndex(int n) {
        if (null != this.mModel) {
            this.mModel.setBankIndex(n);
        }
    }

    public void refresh() {
        if (null != this.mModel) {
            this.mModel.updateHmi();
        }
    }

    public SatPreset[] getSatPreset() {
        if (null != this.mModel) {
            return this.mModel.getSatPreset();
        }
        return null;
    }

    public int getCurrentPresetsBankIndex() {
        if (null != this.mModel) {
            return this.mModel.getCurrentPresetsBankIndex();
        }
        return -1;
    }

    public int getLastSelectedPresetIndex() {
        if (null != this.mModel) {
            return this.mModel.getLastSelectedPresetIndex();
        }
        return -1;
    }

    public ResourceLocator getCurrentImage() {
        if (null != this.mModel) {
            return this.mModel.getCurrentImage();
        }
        return null;
    }

    public void clear() {
        if (null != this.mModel) {
            this.mModel.clear();
        }
    }

    public void updateHmi() {
        if (null != this.mModel) {
            this.mModel.updateHmi();
        }
    }

    public void setIndexOnLoad(int n) {
        if (null != this.mModel) {
            this.mModel.setIndexOnLoad(n);
        }
    }

    public void resetSettings() {
        if (null != this.mModel) {
            this.mModel.resetSettings();
        }
    }

    public void setSatPresetCountFromModel(EventGeneric eventGeneric) {
        try {
            if (null == eventGeneric) {
                return;
            }
            this.satPresetCountTriggeredFromModel = true;
            int n = eventGeneric.getInt(3);
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("SatPresetApi- setSatPresetCountFromModel() - newPresetCount = ").append(n).log();
            }
            if (n >= 15 && n <= 18) {
                SatPresetApi.setSatPresetCountFromModel(n);
                this.createNewSatPresets();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static int getSatPresetCountFromModel() {
        try {
            if (satPresetCountFromModel >= 15 && satPresetCountFromModel <= 18) {
                return satPresetCountFromModel;
            }
            return 15;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return 15;
        }
    }

    public static void setSatPresetCountFromModel(int n) {
        try {
            if (n >= 15 && n <= 18) {
                satPresetCountFromModel = n;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private boolean isSatPresetCountTriggeredFromModel() {
        return this.satPresetCountTriggeredFromModel;
    }

    public void createNewSatPresets() {
        try {
            if (this.isSatPresetCountTriggeredFromModel() && SatPresetApi.isSatPresetsLoadedAndInitialized()) {
                LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("Create new SAT Presets with new preset count:").append(SatPresetApi.getSatPresetCountFromModel()).log();
                }
                SatPersistence satPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getSatPersistence();
                satPersistence.setSatNoOfPresets(SatPresetApi.getSatPresetCountFromModel());
                SatConfig.mMaxPresetsPerBank = SatPresetApi.getSatPresetCountFromModel() / 3;
                if (null != this.mModel) {
                    this.mModel.createNewSatPresets();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    static {
        satPresetCountFromModel = 15;
        satPresetsLoadedAndInitialized = false;
    }
}

