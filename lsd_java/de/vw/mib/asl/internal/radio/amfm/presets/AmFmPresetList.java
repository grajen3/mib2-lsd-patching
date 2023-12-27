/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetUpdater;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public interface AmFmPresetList {
    default public void setUpdater(AmFmPresetUpdater amFmPresetUpdater) {
    }

    default public int getBankIndex() {
    }

    default public void setVisibleBankIndex(int n) {
    }

    default public void setCurrentIndex(int n) {
    }

    default public void clear() {
    }

    default public void clearAndChangeBankIndex(boolean bl) {
    }

    default public void delete(int n) {
    }

    default public AmFmStation setImage(int n, ResourceLocator resourceLocator, boolean bl) {
    }

    default public AmFmStation deleteLogo(int n) {
    }

    default public void setAllImages(ResourceLocator resourceLocator, boolean bl) {
    }

    default public void changeName(AmFmStation amFmStation) {
    }

    default public ResourceLocator getImage(int n) {
    }

    default public void setStation(int n, AmFmStation amFmStation, boolean bl, boolean bl2) {
    }

    default public AmFmPreset get(int n) {
    }

    default public int getPresetIndexByStationId(long l, boolean bl) {
    }

    default public AmFmPreset getPreset(AmFmStation amFmStation) {
    }

    default public void setIndexOfCurrentStation() {
    }

    default public void syncName(AmFmStation amFmStation) {
    }

    default public AmFmPreset getNextOccupiedPreset() {
    }

    default public AmFmPreset getPreviousOccupiedPreset() {
    }

    default public String getCurrentPresetName() {
    }

    default public boolean activatePreset(int n) {
    }

    default public AmFmPreset activateNextPreset() {
    }

    default public AmFmPreset activatePreviousPreset() {
    }

    default public int getIndex() {
    }

    default public void autocompare(AmFmStation amFmStation) {
    }

    default public void autoCompareJapan(boolean bl) {
    }

    default public int calcBankIndex(int n) {
    }

    default public boolean isVisible(int n) {
    }

    default public int getFirstPresetBankIndexWithEmptyElement() {
    }

    default public int getFirstOccupiedPresetBankIndex() {
    }

    default public boolean getAtLeastOnePresetHasLogo() {
    }

    default public void updateGuiList() {
    }

    default public void clearAMHdInfoOnPresets() {
    }

    default public void clearFMHdInfoOnPresets() {
    }

    default public void updateGuiBank() {
    }

    default public void clearIndex() {
    }

    default public void forceHmiUpdate() {
    }

    default public void updateDsi() {
    }

    default public void updateCurrentPreset() {
    }

    default public void setAmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
    }

    default public void setFmStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
    }

    default public void setDatabaseDataForFmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
    }

    default public void setDatabaseDataForAmPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
    }

    default public void setManualAssignedFmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
    }

    default public void setManualAssignedAmStationLogoForAllPresets(ResourceLocator resourceLocator, AmFmStation amFmStation) {
    }

    default public AmFmStation[] getValidPresetStations() {
    }

    default public int getSizeOfNonEmptyPresets() {
    }

    default public void clearUnknownValues(short s) {
    }

    default public void deleteAllLogos() {
    }

    default public void deleteAllDatabaseStationIds() {
    }

    default public void createNewNoOfPresets() {
    }

    default public AmFmPreset[] getPresets() {
    }

    default public void fromPersistence() {
    }

    default public void toPersistence() {
    }

    default public void updateStationLogoFromDatabase(RadioStationData radioStationData, ResourceLocator resourceLocator) {
    }

    default public int getLastSelectedPresetIndex() {
    }

    default public void clearPresetsForProfileChange() {
    }

    default public boolean isResourceLocatorUsed(ResourceLocator resourceLocator, AmFmStation amFmStation) {
    }

    default public boolean updateStationLogoFromStationList(AmFmStation amFmStation) {
    }
}

