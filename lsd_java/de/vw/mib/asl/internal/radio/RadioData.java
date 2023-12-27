/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioFactory;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.AmfmController;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmHDOptionRequester;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmPTY31Option;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmTPOption;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.TargetRadioData;

public final class RadioData {
    private static boolean writeToPersistenceEnabled = true;
    private static DabDatabase mDabDatabase;
    public static AmfmController mAmfmDatabase;
    public static boolean mGlobalTAAvailability;
    public static boolean listStoreViewEntered;
    public static boolean amFmTunerIsInitialized;
    public static boolean amFmTunerIsCompletelyInitialized;
    public static int amFmTunerAvailabilityStatus;
    public static int dsiAmFmTunerUpdateAvailabilityAvailableCount;
    public static TargetRadioData targetRadioData;

    private RadioData() {
    }

    public static AmfmController getAmfmDatabase() {
        if (mAmfmDatabase == null) {
            mAmfmDatabase = RadioFactory.createAslAmfmDatabase();
        }
        return mAmfmDatabase;
    }

    public static DabDatabase getDabDatabase() {
        if (mDabDatabase == null) {
            mDabDatabase = new DabDatabase();
        }
        return mDabDatabase;
    }

    public static void resetAMFMTunerSettings() {
        RadioData.getAmfmDatabase().resetOptions();
        AmfmTPOption.reset();
        AmfmScopeOfArrowKeys.reset();
        AmfmPTY31Option.reset();
        RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentAmStation(new AmFmStation(3, 0));
        RadioData.getAmfmDatabase().getSettingsPersistable().setCurrentFmStation(new AmFmStation(1, 0));
        RadioServiceManager.getServiceManager().setAmFmDefaultOrLsmFreqYetTobeTuned(true);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            AmFmHDOptionRequester.fmSetup(true);
            AmFmHDOptionRequester.set(true);
            AmFmHDOptionRequester.fmSetup(false);
            AmFmHDOptionRequester.set(true);
            RadioData.getAmfmDatabase().getSettingsPersistable().setFMHDFilter(false);
            AmFmHDOptionRequester.notifyDSIHDMode(true, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM);
        }
        AmFmPresetApi.setPresetsToDefault(0, true);
        AmFmPresetApi.setPresetsToDefault(1, true);
        if (2 == RadioCodingAdapter.getCarBrand()) {
            AmFmPresetApi.storeFmStationOnPreset(0, new AmFmStation(0), true, false);
        }
        RadioData.getAmfmDatabase().getFixedStationList().clearAndMarkDirty();
        if (4 == RadioCodingAdapter.getCarBrand()) {
            AmFmFactory.getInstanceEUStationListViewWalker().setFmStationListSortOrder(0);
        } else {
            AmFmFactory.getInstanceEUStationListViewWalker().setFmStationListSortOrder(1);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(418)) {
            RadioData.getAmfmDatabase().getSettingsPersistable().setTiJapanFrequency(0);
        }
        RadioData.getAmfmDatabase().getSettingsPersistable().setUserSelectedHomeCountry(-1);
        RadioData.getAmfmDatabase().getSettingsPersistable().setCalculatedHomeCountry(1);
        RadioDataApi.setHomeCountryAutoSelectionActive();
    }

    public static boolean isWriteToPersistenceEnabled() {
        return writeToPersistenceEnabled;
    }

    public static void setWriteToPersistenceEnabled(boolean bl) {
        writeToPersistenceEnabled = bl;
    }

    static {
        mGlobalTAAvailability = false;
        listStoreViewEntered = false;
        amFmTunerIsInitialized = false;
        amFmTunerIsCompletelyInitialized = false;
        amFmTunerAvailabilityStatus = 0;
        dsiAmFmTunerUpdateAvailabilityAvailableCount = 0;
        targetRadioData = null;
    }
}

