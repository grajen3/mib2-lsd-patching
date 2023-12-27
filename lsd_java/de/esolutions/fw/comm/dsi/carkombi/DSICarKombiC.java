/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi;

import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarKombiC {
    default public void resetSIAValue(int n) {
    }

    default public void requestSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
    }

    default public void setSIADistanceOilUser(int n, int n2) {
    }

    default public void setSIADistanceAirFilterUser(int n, int n2) {
    }

    default public void setSIADistanceOilFilterUser(int n, int n2) {
    }

    default public void setSIAInspectionDistanceUser(int n, int n2) {
    }

    default public void setBCVZADisplay(boolean bl) {
    }

    default public void setBCLifeTipsDisplay(boolean bl) {
    }

    default public void setBCConsumerDisplay(boolean bl) {
    }

    default public void setBCMenueConfig(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    default public void resetBCMenue(int n) {
    }

    default public void setBCOilTemperature(boolean bl) {
    }

    default public void setBCDigitalSpeed(boolean bl) {
    }

    default public void setBCStopwatch(boolean bl) {
    }

    default public void setBCVzaMFA(boolean bl) {
    }

    default public void setBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
    }

    default public void setBCGearRecommendation(boolean bl) {
    }

    default public void setBCRearSeatbeltWarning(boolean bl) {
    }

    default public void requestVehicleStateList(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
    }

    default public void setBcSetFactoryDefault() {
    }

    default public void resetBCStatistics(BCStatisticsReset bCStatisticsReset) {
    }

    default public void setBCAstaMFA(boolean bl) {
    }

    default public void setHUDHeightAdjustment(byte by) {
    }

    default public void setHUDBrightness(byte by) {
    }

    default public void setHUDContent(HUDContent hUDContent) {
    }

    default public void setHUDRotationAdjustment(int n) {
    }

    default public void setHUDColour(int n, int n2) {
    }

    default public void setHUDSetFactoryDefault() {
    }

    default public void setHUDSystemOnOff(boolean bl) {
    }

    default public void setDCSetFactoryDefault() {
    }

    default public void setDCBrightness(int n) {
    }

    default public void setDCVolume(int n) {
    }

    default public void setDCDisplay1MainSelection(DCMainItems dCMainItems) {
    }

    default public void setDCDisplay2MainSelection(DCMainItems dCMainItems) {
    }

    default public void setDCDisplay3MainSelection(DCMainItems dCMainItems) {
    }

    default public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
    }

    default public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
    }

    default public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
    }

    default public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
    }

    default public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument) {
    }

    default public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2) {
    }

    default public void requestDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
    }

    default public void setDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
    }

    default public void setDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency) {
    }

    default public void setDCActiveDisplayPreset(int n) {
    }

    default public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration) {
    }

    default public void setHUDLicense(boolean bl) {
    }

    default public void setDCLEDConfiguration(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

