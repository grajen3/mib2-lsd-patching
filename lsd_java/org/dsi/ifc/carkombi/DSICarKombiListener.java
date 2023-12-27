/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCIndications;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCRefuelVolume;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsRE;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;

public interface DSICarKombiListener
extends DSIListener {
    default public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
    }

    default public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
    }

    default public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
    }

    default public void indicateEndOfSIAReset(boolean bl) {
    }

    default public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    default public void responseSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
    }

    default public void updateSIAHistoryListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateSIADistanceOilUser(SIADistanceData sIADistanceData, int n) {
    }

    default public void updateSIADistanceAirFilterUser(SIADistanceData sIADistanceData, int n) {
    }

    default public void updateSIADistanceOilFilterUser(SIADistanceData sIADistanceData, int n) {
    }

    default public void updateSIAInspectionDistanceUser(SIADistanceData sIADistanceData, int n) {
    }

    default public void updateSIADailyAverageMileage(int n, int n2, int n3) {
    }

    default public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
    }

    default public void updateBCIndications(BCIndications bCIndications, int n) {
    }

    default public void updateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    default public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    default public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
    }

    default public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
    }

    default public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
    }

    default public void updateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
    }

    default public void updateBCVZADisplay(boolean bl, int n) {
    }

    default public void updateBCLifeTipsDisplay(boolean bl, int n) {
    }

    default public void updateBCConsumerDisplay(boolean bl, int n) {
    }

    default public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
    }

    default public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
    }

    default public void updateBCRefuelVolume1(BCRefuelVolume bCRefuelVolume, int n) {
    }

    default public void updateBCRefuelVolume2(BCRefuelVolume bCRefuelVolume, int n) {
    }

    default public void updateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    default public void updateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    default public void updateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    default public void updateBCOilTemperature(boolean bl, int n) {
    }

    default public void updateBCDigitalSpeed(boolean bl, int n) {
    }

    default public void updateBCStopwatch(boolean bl, int n) {
    }

    default public void updateBCVzaMFA(boolean bl, int n) {
    }

    default public void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
    }

    default public void updateBCGearRecommendation(boolean bl, int n) {
    }

    default public void updateBCRearSeatbeltWarning(boolean bl, int n) {
    }

    default public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    default public void indicateEndOfBCMenuReset(boolean bl) {
    }

    default public void updateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
    }

    default public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    default public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
    }

    default public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
    }

    default public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
    }

    default public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
    }

    default public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    default public void acknowledgeBcSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeHUDSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeDCSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeBcStatisticsReset(int n) {
    }

    default public void updateBCStatisticsDistanceAC1(BCStatisticsAC bCStatisticsAC, int n) {
    }

    default public void updateBCStatisticsDistanceAC2(BCStatisticsAC bCStatisticsAC, int n) {
    }

    default public void updateBCStatisticsDistanceRE(BCStatisticsRE bCStatisticsRE, int n) {
    }

    default public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
    }

    default public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
    }

    default public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
    }

    default public void updateBCStatisticsTimeAC1(BCStatisticsAC bCStatisticsAC, int n) {
    }

    default public void updateBCStatisticsTimeAC2(BCStatisticsAC bCStatisticsAC, int n) {
    }

    default public void updateBCStatisticsTimeRE(BCStatisticsRE bCStatisticsRE, int n) {
    }

    default public void updateBCStatisticsTimeZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
    }

    default public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
    }

    default public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
    }

    default public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
    }

    default public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
    }

    default public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
    }

    default public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
    }

    default public void updateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    default public void updateBCComfortPowerConsumption(BCComfortPowerConsumption bCComfortPowerConsumption, int n) {
    }

    default public void updateBCTotalCurrentRange(CarBCDistance carBCDistance, int n) {
    }

    default public void updateBCZeroEmissionDistanceST(CarBCDistance carBCDistance, int n) {
    }

    default public void updateBCZeroEmissionDistanceLT(CarBCDistance carBCDistance, int n) {
    }

    default public void updateBCZeroEmissionDistanceCY(CarBCDistance carBCDistance, int n) {
    }

    default public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
    }

    default public void updateBCZeroEmissionTimeLT(CarBCTime carBCTime, int n) {
    }

    default public void updateBCZeroEmissionTimeCY(CarBCTime carBCTime, int n) {
    }

    default public void updateBCMaxValues(BCMaxValues bCMaxValues, int n) {
    }

    default public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    default public void updateBCResetTimeStampLT(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    default public void updateBCResetTimeStampCY(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    default public void updateBCAstaMFA(boolean bl, int n) {
    }

    default public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
    }

    default public void updateHUDHeightAdjustment(byte by, int n) {
    }

    default public void updateHUDBrightness(byte by, int n) {
    }

    default public void updateHUDColour(int n, int n2, int n3) {
    }

    default public void updateHUDContent(HUDContent hUDContent, int n) {
    }

    default public void updateHUDInfo(boolean bl, int n) {
    }

    default public void updateHUDSystemOnOff(boolean bl, int n) {
    }

    default public void updateHUDRotationAdjustment(int n, int n2) {
    }

    default public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
    }

    default public void updateDCBrightness(int n, int n2) {
    }

    default public void updateDCVolume(int n, int n2) {
    }

    default public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    default public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    default public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    default public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
    }

    default public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
    }

    default public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
    }

    default public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
    }

    default public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
    }

    default public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
    }

    default public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
    }

    default public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
    }

    default public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2, int n) {
    }

    default public void updateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
    }

    default public void responseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
    }

    default public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
    }

    default public void updateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
    }

    default public void updateDCActiveDisplayPreset(int n, int n2) {
    }

    default public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration, int n) {
    }

    default public void updateCompassInfo(int n, int n2, int n3) {
    }

    default public void updateHUDLicense(boolean bl, int n) {
    }

    default public void updateDCLEDConfiguration(boolean bl, int n) {
    }
}

