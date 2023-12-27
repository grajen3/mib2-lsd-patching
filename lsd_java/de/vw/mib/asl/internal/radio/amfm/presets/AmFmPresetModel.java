/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.api.background.ASLBackgroundFactory;
import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.asl.api.background.services.ParticleSubStates;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetUpdater;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmDefaultSettings;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class AmFmPresetModel {
    static final int DEFAULT_INDEX;
    static final int DEFAULT_BANK_INDEX;
    private final AmFmPresetList mAmPresets = AmFmFactory.getAmFmPresetList(this, 0, 321);
    private final AmFmPresetList mFmPresets = AmFmFactory.getAmFmPresetList(this, 1, 320);
    private AmFmPresetUpdater mUpdater = null;
    private AmFmStation freezedStation = null;

    AmFmPresetModel() {
    }

    AmFmPreset activateNextPreset(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - activateNextPreset( ").append(n).append(" )").log();
        }
        AmFmPresetList amFmPresetList = this.getList(n);
        AmFmPreset amFmPreset = null;
        if (amFmPresetList != null) {
            amFmPreset = amFmPresetList.activateNextPreset();
        }
        return amFmPreset;
    }

    boolean activatePreset(int n, int n2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - activatePreset( ").append(n).append(", ").append(n2).append(" )").log();
        }
        AmFmPresetList amFmPresetList = this.getList(n);
        boolean bl = false;
        if (amFmPresetList != null) {
            bl = amFmPresetList.activatePreset(n2);
        }
        return bl;
    }

    AmFmPreset activatePreviousPreset(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - activatePreviousPreset( ").append(n).append(" )").log();
        }
        AmFmPresetList amFmPresetList = this.getList(n);
        AmFmPreset amFmPreset = null;
        if (amFmPresetList != null) {
            amFmPreset = amFmPresetList.activatePreviousPreset();
        }
        return amFmPreset;
    }

    void autoCompare() {
        AmFmStation amFmStation;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - autoCompare()").log();
        }
        if (null != (amFmStation = RadioData.getAmfmDatabase().getCurrentStation()) && !amFmStation.isCoChannel()) {
            this.autoCompare(RadioCurrentWaveband.get(), amFmStation);
        } else {
            int n = RadioCurrentWaveband.get();
            this.resetAutoCompare(n);
        }
    }

    void autoCompare(int n, AmFmStation amFmStation) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - autoCompare( ").append(n).append(", ").append(amFmStation.toString()).append(" )").log();
        }
        if (amFmStation.getFrequency() <= 0) {
            return;
        }
        AmFmPresetList amFmPresetList = this.getList(n);
        if (amFmPresetList != null) {
            amFmPresetList.autocompare(amFmStation);
        }
    }

    void autoCompareJapan(int n, boolean bl) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - autoCompareJapan( ").append(n).append(", ").append(bl).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.autoCompareJapan(bl);
        }
    }

    void changeName(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - changeName( ").append(n).append(" )").log();
        }
        if (null != (amFmPresetList = this.getList(n)) && null != this.freezedStation) {
            amFmPresetList.changeName(this.freezedStation);
        }
    }

    void setAmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setAmStationLogoFromDatabaseSouthSide() - logoType = ").append(n).log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(0)) != null) {
            amFmPresetList.setAmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n);
        }
    }

    void setFmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setFmStationLogoFromDatabaseSouthSide() - logoType = ").append(n).log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(1)) != null) {
            amFmPresetList.setFmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n);
        }
    }

    void setDatabaseDataForAmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setDatabaseDataForAmPreset() - logoType = ").append(n).log();
        }
        if ((amFmPresetList = this.getList(0)) != null) {
            amFmPresetList.setDatabaseDataForAmPreset(radioStationLogoResponse, radioStationDataRequest, n);
        }
    }

    void setDatabaseDataForFmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setDatabaseDataForFmPreset() - logoType = ").append(n).log();
        }
        if ((amFmPresetList = this.getList(1)) != null) {
            amFmPresetList.setDatabaseDataForFmPreset(radioStationLogoResponse, radioStationDataRequest, n);
        }
    }

    void setManualAssignedFmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setManualAssignedFmStationLogoForAllPresets()").log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(1)) != null) {
            amFmPresetList.setManualAssignedFmStationLogoForAllPresets(resourceLocator, amFmStation);
        }
    }

    void setManualAssignedAmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setManualAssignedAmStationLogoForAllPresets()").log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(0)) != null) {
            amFmPresetList.setManualAssignedAmStationLogoForAllPresets(resourceLocator, amFmStation);
        }
    }

    void deletePreset(int n, int n2) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - deletePreset( ").append(n).append(", ").append(n2).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.delete(n2);
        }
    }

    void setPresetsToDefault(int n, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setPresetsToDefault( ").append(n).append(", ").append(bl).append(" )").log();
        }
        if (n == 1) {
            this.mFmPresets.clearAndChangeBankIndex(bl);
        } else if (n == 0) {
            this.mAmPresets.clearAndChangeBankIndex(bl);
        }
    }

    void deletePresets(int n, boolean bl) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - deletePresets( ").append(n).append(", ").append(bl).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.clearAndChangeBankIndex(bl);
        }
    }

    void forceHmiUpdate(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - forceHmiUpdate( ").append(n).append(" )").log();
        }
        this.mUpdater.updateGuiBank();
        this.updateGuiList(RadioCurrentWaveband.get());
        AmFmPresetList amFmPresetList = this.getList(n);
        if (amFmPresetList != null) {
            amFmPresetList.forceHmiUpdate();
        }
    }

    int getBankIndex(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getBankIndex( ").append(n).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.getBankIndex();
        }
        return -1;
    }

    ResourceLocator getImage(int n, int n2) {
        AmFmPresetList amFmPresetList;
        if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getImage( ").append(n).append(", ").append(n2).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.getImage(n2);
        }
        return null;
    }

    int getIndex(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getIndex( ").append(n).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.getIndex();
        }
        return -1;
    }

    AmFmPresetList getList(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getList( ").append(n).append(" )").log();
        }
        if (n == 0) {
            return this.mAmPresets;
        }
        if (n == 1) {
            return this.mFmPresets;
        }
        return null;
    }

    void createNewNoOfPresets(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - createNewNoOfPresets( ").append(n).append(" )").log();
        }
        if (n == 0) {
            this.mAmPresets.createNewNoOfPresets();
        } else if (n == 1) {
            this.mFmPresets.createNewNoOfPresets();
        }
        this.updateGuiList(RadioCurrentWaveband.get());
    }

    AmFmPreset getPreset(AmFmStation amFmStation) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getPreset()").log();
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        if (null != amFmStation && (amFmPresetList = this.getList(amFmStation.getAslWaveband())) != null) {
            return amFmPresetList.getPreset(amFmStation);
        }
        return null;
    }

    public boolean isResourceLocatorUsed(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        AmFmPresetList amFmPresetList = this.getList(amFmStation.getAslWaveband());
        if (amFmPresetList != null) {
            return amFmPresetList.isResourceLocatorUsed(resourceLocator, amFmStation);
        }
        return false;
    }

    AmFmPreset getPreset(int n, AmFmStation amFmStation) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getPreset() - aWaveband = ").append(n).log();
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.getPreset(amFmStation);
        }
        return null;
    }

    AmFmPreset getPresetByIndex(int n, int n2) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getPresetByIndex( ").append(n).append(", ").append(n2).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.get(n2);
        }
        return null;
    }

    int getPresetIndexByStationId(int n, long l, boolean bl) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getPresetIndexByStationId( ").append(n).append(", ").append(l).append(", ").append(bl).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.getPresetIndexByStationId(l, bl);
        }
        return -1;
    }

    void resetAutoCompare(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - resetAutoCompare( ").append(n).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.clearIndex();
        }
    }

    void setBankIndex(int n, int n2) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setBankIndex( ").append(n2).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.setVisibleBankIndex(n2);
        }
    }

    void setCurrentIndex(int n, int n2) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setCurrentIndex( ").append(n).append(", ").append(n2).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.setCurrentIndex(n2);
        }
    }

    AmFmStation setImage(int n, int n2, ResourceLocator resourceLocator, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setImage( ").append(n).append(", ").append(n2).append(", ").append("aImage").append(", ").append(bl).append(" )").log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
        }
        AmFmPresetList amFmPresetList = this.getList(n);
        AmFmStation amFmStation = null;
        if (amFmPresetList != null) {
            amFmStation = amFmPresetList.setImage(n2, resourceLocator, bl);
        }
        return amFmStation;
    }

    void setAllImages(int n, ResourceLocator resourceLocator, boolean bl) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setAllImages( ").append(n).append(", ").append("aImage").append(", ").append(bl).append(" )").log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.setAllImages(resourceLocator, bl);
        }
    }

    void setStation(int n, int n2, AmFmStation amFmStation, boolean bl, boolean bl2) {
        try {
            AmFmPresetList amFmPresetList;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setStation()").log();
            }
            if ((amFmPresetList = this.getList(n)) != null) {
                amFmPresetList.setStation(n2, amFmStation, bl, bl2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void setUpdater(AmFmPresetUpdater amFmPresetUpdater) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setUpdater()").log();
        }
        this.mUpdater = amFmPresetUpdater;
        this.mAmPresets.setUpdater(amFmPresetUpdater);
        this.mFmPresets.setUpdater(amFmPresetUpdater);
    }

    void storeFreezedStationOnPreset(int n) {
        AmFmStation amFmStation;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - storeFreezedStationOnPreset( ").append(n).append(" )").log();
        }
        if ((amFmStation = this.getFreezedStation()) != null) {
            int n2 = RadioCurrentWaveband.get();
            int n3 = amFmStation.getAslWaveband();
            if (n3 == n2) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("Model storeFreezedStationOnPreset wb = ").append(amFmStation.getAslWaveband()).append(" presetIndex = ").append(n).append(" frequency = ").append(amFmStation.getFrequency()).append(" pi = ").append(amFmStation.getPi()).append(" name = ").append(amFmStation.getName()).log();
                }
                this.setStation(n2, n, amFmStation, true, true);
                AmFmDsiApi.selectStation(amFmStation);
            }
        }
    }

    void storeStationOnPreset(int n, AmFmStation amFmStation) {
        if (amFmStation != null) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - storeStationOnPreset( ").append(n).append(", ").append(amFmStation.toString()).append(" )").log();
            }
            int n2 = RadioCurrentWaveband.get();
            if (amFmStation.getAslWaveband() == n2) {
                this.setStation(n2, n, amFmStation, true, true);
            }
        } else {
            ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - storeStationOnPreset() - amFmStation == null").log();
        }
    }

    void storeAmStationOnPreset(int n, AmFmStation amFmStation, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - storeAmStationOnPreset( ").append(n).append(", ").append("newStation").append(", ").append(bl).append(" )").log();
        }
        this.setStation(0, n, amFmStation, true, bl);
    }

    void storeFmStationOnPreset(int n, AmFmStation amFmStation, boolean bl, boolean bl2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - storeFmStationOnPreset( ").append(n).append(", ").append("newStation").append(", ").append(bl).append(", ").append(bl2).append(" )").log();
        }
        this.setStation(1, n, amFmStation, bl, bl2);
    }

    void syncFmName(AmFmStation amFmStation) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - syncFmName( amFmStation )").log();
        }
        this.mFmPresets.syncName(amFmStation);
    }

    void updateCurrentPreset() {
        int n;
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - updateCurrentPreset()").log();
        }
        if ((amFmPresetList = this.getList(n = RadioCurrentWaveband.get())) != null) {
            amFmPresetList.updateCurrentPreset();
        }
    }

    void updateDsi() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - updateDsi()").log();
        }
        this.mFmPresets.updateDsi();
    }

    public String getCurrentPresetName() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getCurrentPresetName()").log();
        }
        return this.mFmPresets.getCurrentPresetName();
    }

    public boolean isImageAvailableForPreset(AmFmStation amFmStation) {
        AmFmPreset amFmPreset;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("isImageAvailableForPreset - ( ").append("aslStation").append(" )").log();
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        return (amFmPreset = this.getPreset(amFmStation)) != null && amFmPreset.getImage() != null;
    }

    public boolean isImageUserAssignedForPreset(AmFmStation amFmStation) {
        boolean bl = false;
        AmFmPreset amFmPreset = this.getPreset(amFmStation);
        if (amFmPreset != null && amFmPreset.getImage() != null && amFmPreset.isLogoManuallyAssignedToPreset()) {
            bl = true;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - isImageUserAssignedForPreset():").append(bl).log();
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        return bl;
    }

    public boolean isImageUserAssignedForCurrentPreset() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - isImageUserAssignedForCurrentPreset()").log();
        }
        return this.isImageUserAssignedForPreset(this.getIndex(RadioCurrentWaveband.get()));
    }

    public boolean isImageUserAssignedForPreset(int n) {
        AmFmPreset amFmPreset;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - isImageUserAssignedForPreset()").log();
        }
        return (amFmPreset = this.getPresetByIndex(RadioCurrentWaveband.get(), n)) != null && amFmPreset.getImage() != null && amFmPreset.isLogoManuallyAssignedToPreset();
    }

    public void setFreezedListStation(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setFreezedListStation( ").append(n).append(" )").log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            return;
        }
        if (RadioCurrentWaveband.isFm()) {
            FMStationInfoCollector fMStationInfoCollector = (FMStationInfoCollector)ListManager.getGenericASLList(1462).getRowItem(n);
            this.setFreezedStation(fMStationInfoCollector.station);
            AmFmFactory.getAslAmfmModelController().updateFrequencyToStoreOnPreset(fMStationInfoCollector.station);
        } else if (RadioCurrentWaveband.isAm()) {
            AMStationInfoCollector aMStationInfoCollector = (AMStationInfoCollector)ListManager.getGenericASLList(1452).getRowItem(n);
            this.setFreezedStation(aMStationInfoCollector.station);
            AmFmFactory.getAslAmfmModelController().updateFrequencyToStoreOnPreset(aMStationInfoCollector.station);
        }
    }

    public void setFreezedStation(AmFmStation amFmStation) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setFreezedStation( freezedAmFMStation )").log();
            if (null != amFmStation) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.toString()).log();
            }
        }
        if (null == this.freezedStation) {
            this.freezedStation = new AmFmStation(amFmStation);
        } else {
            this.freezedStation.copyOf(amFmStation);
        }
    }

    public AmFmStation getFreezedStation() {
        if (null == this.freezedStation) {
            this.freezedStation = new AmFmStation(AmFmDefaultSettings.getAmFmDefaultStation());
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getFreezedStation() - freezedStation = ").append(this.freezedStation.toString()).log();
        }
        return this.freezedStation;
    }

    public void initializePresetBankForBand() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - initializePresetBankForBand( )").log();
        }
        this.mUpdater.updateGuiBank();
        this.updateGuiList(RadioCurrentWaveband.get());
        this.autoCompare();
    }

    public void updateHdPresetList() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - updateHdPresetList()").log();
        }
        AmFmPresetList amFmPresetList = this.getList(1);
        AmFmPresetList amFmPresetList2 = this.getList(0);
        if (amFmPresetList != null && amFmPresetList2 != null) {
            if (RadioCurrentWaveband.isFm()) {
                amFmPresetList.clearFMHdInfoOnPresets();
                amFmPresetList.updateGuiList();
            } else if (RadioCurrentWaveband.isAm()) {
                amFmPresetList2.clearAMHdInfoOnPresets();
                amFmPresetList2.updateGuiList();
            }
        }
    }

    public AmFmStation[] getValidPresetStationList(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - getValidPresetStationList( ").append(n).append(" )").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.getValidPresetStations();
        }
        return null;
    }

    public void dehighlightPresets() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - dehighlightPresets()").log();
        }
        this.resetAutoCompare(RadioCurrentWaveband.get());
    }

    void updateGuiList(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - updateGuiList()").log();
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.updateGuiList();
        }
    }

    public void deleteAllPresetLogos(int n) {
        try {
            AmFmPresetList amFmPresetList;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - deleteAllPresetLogos( ").append(n).append(" )").log();
            }
            if ((amFmPresetList = this.getList(n)) != null) {
                amFmPresetList.deleteAllLogos();
            }
            this.updateGuiList(RadioCurrentWaveband.get());
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void deleteAllDatabaseStationIds(int n) {
        try {
            AmFmPresetList amFmPresetList;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - deleteAllDatabaseStationIds( ").append(n).append(" )").log();
            }
            if ((amFmPresetList = this.getList(n)) != null) {
                amFmPresetList.deleteAllDatabaseStationIds();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public AmFmStation deletePresetLogo(int n, int n2) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - deletePresetLogo( ").append(n).append(", ").append(n2).append(" )").log();
            }
            AmFmPresetList amFmPresetList = this.getList(n);
            AmFmStation amFmStation = null;
            if (amFmPresetList != null) {
                amFmStation = amFmPresetList.deleteLogo(n2);
            }
            this.updateGuiList(RadioCurrentWaveband.get());
            return amFmStation;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    void fromPersistence() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - fromPersistence()").log();
            }
            AmFmPresetApi.setPersistenceWriteAccessBlocked(true);
            if (this.mAmPresets != null) {
                this.mAmPresets.clearPresetsForProfileChange();
                this.mAmPresets.fromPersistence();
            }
            if (this.mFmPresets != null) {
                this.mFmPresets.clearPresetsForProfileChange();
                this.mFmPresets.fromPersistence();
            }
            AmFmPresetApi.setPersistenceWriteAccessBlocked(false);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            AmFmPresetApi.setPersistenceWriteAccessBlocked(false);
        }
    }

    public void toPersistence(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - toPersistence()").log();
        }
        if (n == 0) {
            this.mAmPresets.toPersistence();
        } else if (n == 1) {
            this.mFmPresets.toPersistence();
        }
    }

    boolean isVisible(int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - isVisible( ").append(n).append(" )").log();
        }
        if ((amFmPresetList = this.getList(RadioCurrentWaveband.get())) != null) {
            return amFmPresetList.isVisible(n);
        }
        return false;
    }

    void setPresetIndexForParticleBackgroundService(int n, int n2) {
        try {
            AmFmPresetSettings amFmPresetSettings;
            if (!RadioData.amFmTunerIsInitialized) {
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setPresetIndexForParticleBackgroundService( ").append(n).append(" )").log();
            }
            if (null == (amFmPresetSettings = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getAmFmPresetSettings())) {
                ServiceManager.logger.error(128).append("AmFmPresetModel - setPresetIndexForParticleBackgroundService() - null == amFmPresetSettingsPersistence").log();
                return;
            }
            int n3 = 0;
            if (n2 == 0) {
                n3 = amFmPresetSettings.getCurrentBankIndexAm();
            } else if (n2 == 1) {
                n3 = amFmPresetSettings.getCurrentBankIndexFm();
            } else {
                ServiceManager.logger.error(128).append("AmFmPresetModel - setPresetIndexForParticleBackgroundService() - waveband = ").append(n2).log();
                return;
            }
            ParticleBackgroundService particleBackgroundService = ASLBackgroundFactory.getBackgroundApi().getParticleBackgroundService();
            if (null == particleBackgroundService) {
                ServiceManager.logger.error(128).append("AmFmPresetModel - setPresetIndexForParticleBackgroundService() - null == particleBackgroundService").log();
                return;
            }
            int n4 = RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets();
            if (n4 == 15) {
                block1 : switch (n3) {
                    case 0: {
                        if (this.isVisible(n)) {
                            switch (n) {
                                case 0: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET1);
                                    break block1;
                                }
                                case 1: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET2);
                                    break block1;
                                }
                                case 2: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET3);
                                    break block1;
                                }
                                case 3: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET4);
                                    break block1;
                                }
                                case 4: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET5);
                                    break block1;
                                }
                            }
                            particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_UNDEFINED);
                            break;
                        }
                        particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_UNDEFINED);
                        break;
                    }
                    case 1: {
                        if (this.isVisible(n)) {
                            switch (n) {
                                case 5: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET1);
                                    break block1;
                                }
                                case 6: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET2);
                                    break block1;
                                }
                                case 7: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET3);
                                    break block1;
                                }
                                case 8: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET4);
                                    break block1;
                                }
                                case 9: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET5);
                                    break block1;
                                }
                            }
                            particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_UNDEFINED);
                            break;
                        }
                        particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_UNDEFINED);
                        break;
                    }
                    case 2: {
                        if (this.isVisible(n)) {
                            switch (n) {
                                case 10: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET1);
                                    break block1;
                                }
                                case 11: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET2);
                                    break block1;
                                }
                                case 12: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET3);
                                    break block1;
                                }
                                case 13: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET4);
                                    break block1;
                                }
                                case 14: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET5);
                                    break block1;
                                }
                            }
                            particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_UNDEFINED);
                            break;
                        }
                        particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_UNDEFINED);
                        break;
                    }
                }
            } else if (n4 == 18) {
                block27 : switch (n3) {
                    case 0: {
                        if (this.isVisible(n)) {
                            switch (n) {
                                case 0: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET1);
                                    break block27;
                                }
                                case 1: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET2);
                                    break block27;
                                }
                                case 2: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET3);
                                    break block27;
                                }
                                case 3: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET4);
                                    break block27;
                                }
                                case 4: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET5);
                                    break block27;
                                }
                                case 5: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_PRESET6);
                                    break block27;
                                }
                            }
                            particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_UNDEFINED);
                            break;
                        }
                        particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK1_UNDEFINED);
                        break;
                    }
                    case 1: {
                        if (this.isVisible(n)) {
                            switch (n) {
                                case 6: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET1);
                                    break block27;
                                }
                                case 7: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET2);
                                    break block27;
                                }
                                case 8: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET3);
                                    break block27;
                                }
                                case 9: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET4);
                                    break block27;
                                }
                                case 10: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET5);
                                    break block27;
                                }
                                case 11: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_PRESET6);
                                    break block27;
                                }
                            }
                            particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_UNDEFINED);
                            break;
                        }
                        particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK2_UNDEFINED);
                        break;
                    }
                    case 2: {
                        if (this.isVisible(n)) {
                            switch (n) {
                                case 12: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET1);
                                    break block27;
                                }
                                case 13: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET2);
                                    break block27;
                                }
                                case 14: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET3);
                                    break block27;
                                }
                                case 15: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET4);
                                    break block27;
                                }
                                case 16: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET5);
                                    break block27;
                                }
                                case 17: {
                                    particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_PRESET6);
                                    break block27;
                                }
                            }
                            particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_UNDEFINED);
                            break;
                        }
                        particleBackgroundService.applySubState(ParticleSubStates.TUNER_BANK3_UNDEFINED);
                        break;
                    }
                }
            } else {
                ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - setPresetIndexForParticleBackgroundServic - presetCount = ").append(n4).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void updateStationLogoFromDatabase(RadioStationData radioStationData, ResourceLocator resourceLocator, int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - updateStationLogoFromDatabase() - waveband = ").append(n).append(", radioStationData = ").append(radioStationData.toString()).log();
            if (null != resourceLocator) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(resourceLocator.toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            amFmPresetList.updateStationLogoFromDatabase(radioStationData, resourceLocator);
        }
    }

    boolean updateStationLogoFromStationList(AmFmStation amFmStation, int n) {
        AmFmPresetList amFmPresetList;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetModel - updateStationLogoFromStationList() - waveband = ").append(n).append(", amFmStation = ").append(amFmStation.toString()).log();
            if (null != amFmStation.getStationArt()) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append(amFmStation.getStationArt().toString()).log();
            }
        }
        if ((amFmPresetList = this.getList(n)) != null) {
            return amFmPresetList.updateStationLogoFromStationList(amFmStation);
        }
        return false;
    }

    public int getLastSelectedPresetIndex(int n) {
        AmFmPresetList amFmPresetList = this.getList(n);
        if (amFmPresetList != null) {
            return amFmPresetList.getLastSelectedPresetIndex();
        }
        return -1;
    }
}

