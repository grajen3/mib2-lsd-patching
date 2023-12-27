/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.model;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.transformer.AMStationInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.FMStationInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public interface AmFmModelController {
    default public void setPropertyBoolean(int n, boolean bl) {
    }

    default public void setPropertyInteger(int n, int n2) {
    }

    default public void setPropertyLong(int n, long l) {
    }

    default public void setPropertyString(int n, String string) {
    }

    default public void setPropertyResourceLocator(int n, ResourceLocator resourceLocator) {
    }

    default public void updateAfSetupOptionState(boolean bl) {
    }

    default public void updateFmPresetBankWithEmptyElement(int n) {
    }

    default public void updateFmActiveStationIndex(int n) {
    }

    default public void updateFmActiveSubStationIndex(int n) {
    }

    default public void updateFmRadioTextPlus(String string, String string2) {
    }

    default public void updateRadioTextPlusSetupOptionAvailable(boolean bl) {
    }

    default public void updateRadioTextPlusFM(String string, String string2, String string3) {
    }

    default public void updateHDStationInfo(String string, String string2, String string3) {
    }

    default public void updateRadioTextSetupState(boolean bl) {
    }

    default public void updateRadioTextPlusSetupState(boolean bl) {
    }

    default public void updateIndexOfFirstOccupiedPresetFm(int n) {
    }

    default public void updateRdsSetupOptionAvailable(boolean bl) {
    }

    default public void updateRdsRegionalizationOptionState(int n) {
    }

    default public void updatePsFixed(boolean bl) {
    }

    default public void updatePsNameAvailable(boolean bl) {
    }

    default public void updateFmRadioText(String string) {
    }

    default public void updateFmRadiotextAndState(String string, int n) {
    }

    default public void updateAmActiveStationIndex(int n) {
    }

    default public void updateListState(int n) {
    }

    default public void updateAmRadioTextArtist(String string, String string2) {
    }

    default public void updatePresetBankWithEmptyElement(int n) {
    }

    default public void updateAmIndexOfFirstOccupiedPreset(int n) {
    }

    default public void updateIndexOfActivatedAmPreset(int n) {
    }

    default public void updateAmIndexOfPresetBank(int n) {
    }

    default public void updateFmIndexOfPresetBank(int n) {
    }

    default public void updateAtLeastOnePresetHasLogo(int n, boolean bl) {
    }

    default public void updateAmStationList(AMStationInfoCollector[] aMStationInfoCollectorArray, int n, long l) {
    }

    default public void updateFmStationList(FMStationInfoCollector[] fMStationInfoCollectorArray, int n, int n2, long l) {
    }

    default public void updateFmSubStationList(FMStationInfoCollector[] fMStationInfoCollectorArray, int n, long l) {
    }

    default public void updateAmStationListItem(AMStationInfoCollector aMStationInfoCollector, int n) {
    }

    default public void updateFmStationListItem(FMStationInfoCollector fMStationInfoCollector, int n, int n2) {
    }

    default public void updateFmSubStationListItem(FMStationInfoCollector fMStationInfoCollector, int n) {
    }

    default public void updateCurrentStationInfoFrequencyOnly(int n) {
    }

    default public void updateCurrentStationInfoHmiAndBap(AmFmStation amFmStation, int n) {
    }

    default public void updateStationNameInMainView(AmFmStation amFmStation) {
    }

    default public void updateCurrentStationInfo(AmFmStation amFmStation) {
    }

    default public void updateRdsSetupOptionState(boolean bl) {
    }

    default public void updateIndexOfActivatedFmPreset(int n) {
    }

    default public void updateNewStationListIDAndPresetIndexForBAP(long l, int n) {
    }

    default public void updateAmFrequencyMinValue(int n) {
    }

    default public void updateAmFrequencyMaxValue(int n) {
    }

    default public void updateAmFrequencyStepValue(int n) {
    }

    default public void updateFmFrequencyMinValue(int n) {
    }

    default public void updateFmFrequencyMaxValue(int n) {
    }

    default public void updateFmFrequencyStepValue(int n) {
    }

    default public void updateTAEmergencyState(boolean bl) {
    }

    default public void updateAMFrequencyScale(int n) {
    }

    default public void updateFmFrequencyScale(int n) {
    }

    default public void updatePICoding(boolean bl) {
    }

    default public void updateFMStationShortNameToStoreOnPreset(String string) {
    }

    default public void updateFMStationSubChannelNrToStoreOnPreset(int n) {
    }

    default public void updateFMFrequencyToStoreOnPreset(int n) {
    }

    default public void updateAMStationShortNameToStoreOnPreset(String string) {
    }

    default public void updateAMFrequencyToStoreOnPreset(int n) {
    }

    default public void updateFrequencyToStoreOnPreset(AmFmStation amFmStation) {
    }

    default public void updateStationShortNameToStoreOnPreset(String string) {
    }

    default public void updateFmViewState(int n) {
    }

    default public void updateAmViewState(int n) {
    }

    default public void updateLogoInStationView(ResourceLocator resourceLocator) {
    }

    default public void updateLogoToHmi() {
    }

    default public void updateTrafficInformationFrequency(int n) {
    }

    default public void updateHdRadioState(int n) {
    }

    default public void updateAmHdRadioState(int n) {
    }

    default public void updateFmHdRadioState(int n) {
    }

    default public void updateAMHDRadioEnabled(boolean bl) {
    }

    default public void updateFMHDRadioEnabled(boolean bl) {
    }

    default public void updateTransferredSongTags(int n) {
    }

    default public void updateTransferringSongTagsActive(boolean bl) {
    }

    default public void updateFMPresetLogosAutoSelectList(String[] stringArray) {
    }

    default public void openSelectPresetLogoPopup() {
    }

    default public void presetStoredSuccessfully() {
    }

    default public void enableTaggingButton(boolean bl) {
    }

    default public void updateFmStationListSortOrder(int n) {
    }

    default public void updateLogoAutoStoreActive(boolean bl) {
    }

    default public void updateHomeCountryNameInSetup(String string) {
    }

    default public void updateEnhancedRadioTextSetupOptionState(boolean bl) {
    }

    default public void updateAutoStoreStationLogosFeatureAvailable(boolean bl) {
    }

    default public void updateHomeCountrySetupOptionVisible(boolean bl) {
    }

    default public boolean isRadioTextBlocked() {
    }

    default public void setRadioTextBlocked(boolean bl) {
    }

    default public void updateHDFilterinAM(boolean bl) {
    }

    default public void updateHDFilterinFM(boolean bl) {
    }

    default public void isHDFilteredStationListEmpty(boolean bl) {
    }

    default public void updateFmSetupHomeCountryListBackButtonVisible(boolean bl) {
    }

    default public void updateTaggingButtonVisibility(boolean bl) {
    }

    default public void updateIsHongKongVariant(boolean bl) {
    }

    default public void updateIsSetupTrafficProgramButtonAvailable(boolean bl) {
    }

    default public void updateIsSetupAdvancedRdsRegButtonAvailable(boolean bl) {
    }

    default public ResourceLocator getLogoForStationView() {
    }

    default public ResourceLocator getAmFmStationArt(AmFmStation amFmStation) {
    }

    default public String getAmStationName(AmFmStation amFmStation) {
    }

    default public String getFmStationName(AmFmStation amFmStation) {
    }
}

