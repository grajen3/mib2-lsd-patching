/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetModel;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetUpdater;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class AmFmPresetApi {
    private static HsmTarget mParent;
    private static AmFmPresetTarget mTarget;
    private static AmFmPresetModel mModel;
    private static AmFmPresetUpdater mUpdater;
    private static boolean userCanSelectPresetImage;
    private static boolean isPresetHighlightingEnabled;
    private static boolean amPresetsLoadedAndInitialized;
    private static boolean fmPresetsLoadedAndInitialized;
    private static int amfmPresetCountFromModel;
    private static boolean amfmPresetCountTriggeredFromModel;
    private static boolean isPresetPersistenceBlocked;

    private AmFmPresetApi() {
    }

    public static boolean isAmPresetsLoadedAndInitialized() {
        return amPresetsLoadedAndInitialized;
    }

    public static boolean isFmPresetsLoadedAndInitialized() {
        return fmPresetsLoadedAndInitialized;
    }

    public static void setAmPresetsLoadedAndInitialized(boolean bl) {
        try {
            ServiceManager.logger.info(128).append("AM Presets are Initialized").log();
            amPresetsLoadedAndInitialized = bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setFmPresetsLoadedAndInitialized(boolean bl) {
        try {
            ServiceManager.logger.info(128).append("FM Presets are Initialized").log();
            fmPresetsLoadedAndInitialized = bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static int getAmfmPresetCountFromModel() {
        try {
            if (amfmPresetCountFromModel >= 15 && amfmPresetCountFromModel <= 18) {
                return amfmPresetCountFromModel;
            }
            return 15;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return 15;
        }
    }

    public static void setAmfmPresetCountFromModel(int n) {
        try {
            if (n >= 15 && n <= 18) {
                amfmPresetCountFromModel = n;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isAmfmPresetCountTriggeredFromModel() {
        return amfmPresetCountTriggeredFromModel;
    }

    public static void setAmFmPresetCountTriggeredFromModel(boolean bl) {
        amfmPresetCountTriggeredFromModel = bl;
    }

    public static void createNewAmFmPresets() {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetApi - createNewAmFmPresets()").log();
            }
            if (AmFmPresetApi.isAmPresetsLoadedAndInitialized() && AmFmPresetApi.isFmPresetsLoadedAndInitialized() && AmFmPresetApi.isAmfmPresetCountTriggeredFromModel()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("Create new AM/FM Presets with new preset count: ").append(AmFmPresetApi.getAmfmPresetCountFromModel()).log();
                }
                RadioData.getAmfmDatabase().getSettingsPersistable().setAmFmNoOfPresets(AmFmPresetApi.getAmfmPresetCountFromModel());
                AmFmPresetApi.createNewNoOfPresets(0);
                AmFmPresetApi.createNewNoOfPresets(1);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void autoCompare() {
        try {
            if (isPresetHighlightingEnabled && null != mModel) {
                mModel.autoCompare();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void autoCompareJapan(int n, boolean bl) {
        try {
            if (null != mModel) {
                mModel.autoCompareJapan(n, bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void resetAutoCompare(int n) {
        try {
            if (null != mModel) {
                mModel.resetAutoCompare(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void autoCompare(int n, AmFmStation amFmStation) {
        try {
            if (null == amFmStation || null == mModel) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - autoCompare() - null == amFmStation").log();
                return;
            }
            mModel.autoCompare(n, amFmStation);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void changeName(int n) {
        try {
            if (null != mModel) {
                mModel.changeName(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setAmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null == resourceLocator) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setAmStationLogoFromDatabaseSouthSide() - null == resourceLocator").log();
                return;
            }
            if (null == radioStationDataRequest) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setAmStationLogoFromDatabaseSouthSide() - null == radioStationDataRequest").log();
                return;
            }
            if (null != mModel) {
                mModel.setAmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setFmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null == resourceLocator) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setFmStationLogoFromDatabaseSouthSide() - null == resourceLocator").log();
                return;
            }
            if (null == radioStationDataRequest) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setFmStationLogoFromDatabaseSouthSide() - null == radioStationDataRequest").log();
                return;
            }
            if (null != mModel) {
                mModel.setFmStationLogoFromDatabaseSouthSide(resourceLocator, radioStationDataRequest, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setDatabaseDataForAmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null == radioStationLogoResponse) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setDatabaseDataForAmPreset() - null == stationLogoResponse").log();
                return;
            }
            if (null == radioStationDataRequest) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setDatabaseDataForAmPreset() - null == radioStationDataRequest").log();
                return;
            }
            if (null != mModel) {
                mModel.setDatabaseDataForAmPreset(radioStationLogoResponse, radioStationDataRequest, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setDatabaseDataForFmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null == radioStationLogoResponse) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setDatabaseDataForFmPreset() - null == stationLogoResponse").log();
                return;
            }
            if (null == radioStationDataRequest) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setDatabaseDataForFmPreset() - null == radioStationDataRequest").log();
                return;
            }
            if (null != mModel) {
                mModel.setDatabaseDataForFmPreset(radioStationLogoResponse, radioStationDataRequest, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setManualAssignedFmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        try {
            if (null == resourceLocator) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setManualAssignedFmStationLogoForAllPresets() - null == resourceLocator").log();
                return;
            }
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setManualAssignedFmStationLogoForAllPresets() - null == amFmStation").log();
                return;
            }
            if (null != mModel) {
                mModel.setManualAssignedFmStationLogoForAllPresets(resourceLocator, amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setManualAssignedAmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        try {
            if (null == resourceLocator) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setManualAssignedAmStationLogoForAllPresets() - null == resourceLocator").log();
                return;
            }
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - setManualAssignedAmStationLogoForAllPresets() - null == amFmStation").log();
                return;
            }
            if (null != mModel) {
                mModel.setManualAssignedAmStationLogoForAllPresets(resourceLocator, amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setPresetsToDefault(int n, boolean bl) {
        try {
            if (null != mModel) {
                mModel.setPresetsToDefault(n, bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void deletePresets(int n, boolean bl) {
        try {
            if (null != mModel) {
                mModel.deletePresets(n, bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void forceHmiUpdate() {
        try {
            if (null != mModel) {
                int n = RadioCurrentWaveband.get();
                mModel.forceHmiUpdate(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static ResourceLocator getCurrentImage() {
        try {
            return AmFmPresetApi.getImage(RadioData.getAmfmDatabase().getCurrentStation());
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static ResourceLocator getImage(AmFmStation amFmStation) {
        try {
            AmFmPreset amFmPreset;
            if (amFmStation != null && (amFmPreset = AmFmPresetApi.getPreset(amFmStation)) != null) {
                return amFmPreset.getImage();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static int getCurrentIndex() {
        try {
            if (null != mModel) {
                int n = RadioCurrentWaveband.get();
                return mModel.getIndex(n);
            }
            return -1;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return -1;
        }
    }

    public static String getCurrentPresetName() {
        try {
            if (null != mModel) {
                return mModel.getCurrentPresetName();
            }
            return "";
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    public static int getIndexOfPreset(AmFmStation amFmStation) {
        try {
            if (null != mModel) {
                AmFmPreset amFmPreset = mModel.getPreset(amFmStation);
                return amFmPreset == null ? -1 : amFmPreset.getIndex();
            }
            return -1;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return -1;
        }
    }

    static HsmTarget getParent() {
        return mParent;
    }

    public static AmFmPreset getPreset(AmFmStation amFmStation) {
        try {
            if (null == amFmStation || null == mModel) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append("AmFmPresetApi - getPreset() - null == amFmStation").log();
                }
                return null;
            }
            return mModel.getPreset(amFmStation);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static AmFmPreset getPreset(int n, AmFmStation amFmStation) {
        try {
            if (null == amFmStation || null == mModel) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - getPreset() - null == amFmStation").log();
                return null;
            }
            return mModel.getPreset(n, amFmStation);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static AmFmPreset getPresetByIndex(int n, int n2) {
        try {
            if (null != mModel) {
                return mModel.getPresetByIndex(n, n2);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static AbstractTarget getTarget() {
        return mTarget;
    }

    public static void setBankIndex(int n, int n2) {
        try {
            if (null != mModel) {
                mModel.setBankIndex(n, n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static int getBankIndex(int n) {
        try {
            if (null != mModel) {
                return mModel.getBankIndex(n);
            }
            return -1;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return -1;
        }
    }

    public static void setImage(int n, int n2, ResourceLocator resourceLocator, boolean bl) {
        try {
            if (null != mModel) {
                mModel.setImage(n, n2, resourceLocator, bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static ResourceLocator getImage(int n, int n2) {
        try {
            if (null != mModel) {
                return mModel.getImage(n, n2);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static void start(HsmTarget hsmTarget) {
        try {
            if (mModel == null) {
                mParent = hsmTarget;
                mModel = new AmFmPresetModel();
                mTarget = new AmFmPresetTarget(hsmTarget, mModel);
                mUpdater = new AmFmPresetUpdater(mModel);
                mModel.setUpdater(mUpdater);
                SelectedStationHighlighting.setPresetTarget(mTarget);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static AmFmPresetUpdater getAmFmPresetUpdater() {
        return mUpdater;
    }

    public static void storeStationOnPreset(int n, AmFmStation amFmStation) {
        try {
            if (null != amFmStation && n > -1 && null != mModel) {
                mModel.storeStationOnPreset(n, amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void storeAmStationOnPreset(int n, AmFmStation amFmStation, boolean bl) {
        try {
            if (null != amFmStation && n > -1 && null != mModel) {
                mModel.storeAmStationOnPreset(n, amFmStation, bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void storeFmStationOnPreset(int n, AmFmStation amFmStation, boolean bl, boolean bl2) {
        try {
            if (null != amFmStation && n > -1 && null != mModel) {
                mModel.storeFmStationOnPreset(n, amFmStation, bl, bl2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void syncFmName(AmFmStation amFmStation) {
        try {
            if (null != mModel && null != amFmStation && !ServiceManager.configManagerDiag.isFeatureFlagSet(423)) {
                mModel.syncFmName(amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean activateStationPreset(int n) {
        try {
            if (null != mTarget) {
                return mTarget.activateStationPreset(n);
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    public static void setFeedbackEvent(int n, int n2) {
        try {
            AmFmPreset.setFeedbackEvent(n, n2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void updateGui(boolean bl) {
        try {
            SelectedStationHighlighting.updateGui(bl);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isImageAvailableForPreset(AmFmStation amFmStation) {
        try {
            if (null == amFmStation || null == mModel) {
                return false;
            }
            return mModel.isImageAvailableForPreset(amFmStation);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    public static void setFreezedListStation(int n) {
        try {
            if (null != mModel) {
                mModel.setFreezedListStation(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setFreezedStation(AmFmStation amFmStation) {
        try {
            if (null != mModel) {
                mModel.setFreezedStation(amFmStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static AmFmStation getFreezedStation() {
        try {
            if (null != mModel) {
                return mModel.getFreezedStation();
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static void initializePresetBankForBand() {
        try {
            if (null != mModel) {
                mModel.initializePresetBankForBand();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setUserCanSelectPresetImage(boolean bl) {
        userCanSelectPresetImage = bl;
    }

    public static boolean getUserCanSelectPresetImage() {
        return userCanSelectPresetImage;
    }

    public static void updateHdPresetList() {
        try {
            if (null != mModel) {
                mModel.updateHdPresetList();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void dehighlightPresets() {
        try {
            if (null != mModel) {
                mModel.dehighlightPresets();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void updateGuiList(int n) {
        try {
            if (null != mModel) {
                mModel.updateGuiList(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void deleteAllPresetLogos(int n) {
        try {
            if (null != mModel) {
                mModel.deleteAllPresetLogos(n);
                AmFmFactory.getAslAmfmModelController().updateAtLeastOnePresetHasLogo(n, false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void deleteAllDatabaseStationIds(int n) {
        try {
            if (null != mModel) {
                mModel.deleteAllDatabaseStationIds(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static AmFmStation deletePresetLogo(int n, int n2) {
        try {
            if (null != mModel) {
                return mModel.deletePresetLogo(n, n2);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static boolean isImageUserAssignedForCurrentPreset() {
        try {
            if (null != mModel) {
                return mModel.isImageUserAssignedForCurrentPreset();
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    public static boolean isImageUserAssignedForPreset(AmFmStation amFmStation) {
        try {
            if (null != mModel) {
                return mModel.isImageUserAssignedForPreset(amFmStation);
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    public static AmFmPresetList getList(int n) {
        try {
            if (null != mModel) {
                return mModel.getList(n);
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static void enablePresetHighlighting(boolean bl) {
        try {
            isPresetHighlightingEnabled = bl;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void updateDSI() {
        try {
            if (null != mModel) {
                mModel.updateDsi();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void createNewNoOfPresets(int n) {
        try {
            if (null != mModel) {
                mModel.createNewNoOfPresets(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void fromPersistence() {
        try {
            if (null != mModel) {
                mModel.fromPersistence();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void toPersistence(int n) {
        try {
            if (null != mModel) {
                mModel.toPersistence(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isPersistenceWriteAccessBlocked() {
        return isPresetPersistenceBlocked;
    }

    public static void setPersistenceWriteAccessBlocked(boolean bl) {
        isPresetPersistenceBlocked = bl;
    }

    public static void setAmfmPresetCountFromModel(EventGeneric eventGeneric) {
        try {
            if (null == eventGeneric) {
                return;
            }
            if (!AmFmPresetApi.isAmfmPresetCountTriggeredFromModel()) {
                AmFmPresetApi.setAmFmPresetCountTriggeredFromModel(true);
                int n = eventGeneric.getInt(2);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AmFmPresetApi- setAmfmPresetCountFromModel(eventGeneric) - newPresetCount = ").append(n).log();
                }
                if (n >= 15 && n <= 18) {
                    AmFmPresetApi.setAmfmPresetCountFromModel(n);
                    AmFmPresetApi.createNewAmFmPresets();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean isVisible(int n) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_PRESETS).append("AmFmPresetApi - isVisible( ").append(n).append(" )").log();
            }
            if (null != mModel) {
                return mModel.isVisible(n);
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    public static void setPresetIndexForParticleBackgroundService(int n, int n2) {
        try {
            if (null != mModel) {
                mModel.setPresetIndexForParticleBackgroundService(n, n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void updateStationLogoFromDatabase(RadioStationData radioStationData, ResourceLocator resourceLocator, int n) {
        try {
            if (null == radioStationData) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - updateStationLogoFromDatabase() - null == radioStationData").log();
                return;
            }
            if (null != mModel) {
                mModel.updateStationLogoFromDatabase(radioStationData, resourceLocator, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static boolean updateStationLogoFromStationList(AmFmStation amFmStation, int n) {
        try {
            if (null == amFmStation) {
                ServiceManager.logger.error(128).append("AmFmPresetApi - updateStationLogoFromStationList() - null == amFmStation").log();
                return false;
            }
            if (null != mModel) {
                return mModel.updateStationLogoFromStationList(amFmStation, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return false;
    }

    public static int getLastSelectedPresetIndex(int n) {
        try {
            if (null != mModel) {
                return mModel.getLastSelectedPresetIndex(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return -1;
    }

    public static void clearAmFmPresetModel() {
        mModel = null;
    }

    public static boolean isResourceLocatorUsed(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        try {
            if (null == resourceLocator || null == amFmStation) {
                return false;
            }
            return mModel.isResourceLocatorUsed(resourceLocator, amFmStation);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    static {
        mTarget = null;
        userCanSelectPresetImage = true;
        isPresetHighlightingEnabled = true;
        amPresetsLoadedAndInitialized = false;
        fmPresetsLoadedAndInitialized = false;
        amfmPresetCountFromModel = 15;
        amfmPresetCountTriggeredFromModel = false;
        isPresetPersistenceBlocked = false;
    }
}

