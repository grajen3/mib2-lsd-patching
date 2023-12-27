/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

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
import org.dsi.ifc.carkombi.DSICarKombiListener;
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

public class DsiCarKombiListenerAdapter
implements DSICarKombiListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
    }

    @Override
    public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
    }

    @Override
    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
    }

    @Override
    public void indicateEndOfSIAReset(boolean bl) {
    }

    @Override
    public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    @Override
    public void responseSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
    }

    @Override
    public void updateSIAHistoryListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void updateSIADistanceOilUser(SIADistanceData sIADistanceData, int n) {
    }

    @Override
    public void updateSIADistanceAirFilterUser(SIADistanceData sIADistanceData, int n) {
    }

    @Override
    public void updateSIADistanceOilFilterUser(SIADistanceData sIADistanceData, int n) {
    }

    @Override
    public void updateSIAInspectionDistanceUser(SIADistanceData sIADistanceData, int n) {
    }

    @Override
    public void updateSIADailyAverageMileage(int n, int n2, int n3) {
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
    }

    @Override
    public void updateBCIndications(BCIndications bCIndications, int n) {
    }

    @Override
    public void updateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    @Override
    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
    }

    @Override
    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
    }

    @Override
    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
    }

    @Override
    public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
    }

    @Override
    public void updateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
    }

    @Override
    public void updateBCVZADisplay(boolean bl, int n) {
    }

    @Override
    public void updateBCLifeTipsDisplay(boolean bl, int n) {
    }

    @Override
    public void updateBCConsumerDisplay(boolean bl, int n) {
    }

    @Override
    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
    }

    @Override
    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
    }

    @Override
    public void updateBCRefuelVolume1(BCRefuelVolume bCRefuelVolume, int n) {
    }

    @Override
    public void updateBCRefuelVolume2(BCRefuelVolume bCRefuelVolume, int n) {
    }

    @Override
    public void updateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    @Override
    public void updateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    @Override
    public void updateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    @Override
    public void updateBCOilTemperature(boolean bl, int n) {
    }

    @Override
    public void updateBCDigitalSpeed(boolean bl, int n) {
    }

    @Override
    public void updateBCStopwatch(boolean bl, int n) {
    }

    @Override
    public void updateBCVzaMFA(boolean bl, int n) {
    }

    @Override
    public void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
    }

    @Override
    public void updateBCGearRecommendation(boolean bl, int n) {
    }

    @Override
    public void updateBCRearSeatbeltWarning(boolean bl, int n) {
    }

    @Override
    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    @Override
    public void indicateEndOfBCMenuReset(boolean bl) {
    }

    @Override
    public void updateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    @Override
    public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
    }

    @Override
    public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
    }

    @Override
    public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
    }

    @Override
    public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
    }

    @Override
    public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    @Override
    public void acknowledgeBcSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeHUDSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeDCSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeBcStatisticsReset(int n) {
    }

    @Override
    public void updateBCStatisticsDistanceAC1(BCStatisticsAC bCStatisticsAC, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceAC2(BCStatisticsAC bCStatisticsAC, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceRE(BCStatisticsRE bCStatisticsRE, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
    }

    @Override
    public void updateBCStatisticsTimeAC1(BCStatisticsAC bCStatisticsAC, int n) {
    }

    @Override
    public void updateBCStatisticsTimeAC2(BCStatisticsAC bCStatisticsAC, int n) {
    }

    @Override
    public void updateBCStatisticsTimeRE(BCStatisticsRE bCStatisticsRE, int n) {
    }

    @Override
    public void updateBCStatisticsTimeZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption carBCConsumption, int n) {
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
    }

    @Override
    public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
    }

    @Override
    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
    }

    @Override
    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
    }

    @Override
    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
    }

    @Override
    public void updateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
    }

    @Override
    public void updateBCComfortPowerConsumption(BCComfortPowerConsumption bCComfortPowerConsumption, int n) {
    }

    @Override
    public void updateBCTotalCurrentRange(CarBCDistance carBCDistance, int n) {
    }

    @Override
    public void updateBCZeroEmissionDistanceST(CarBCDistance carBCDistance, int n) {
    }

    @Override
    public void updateBCZeroEmissionDistanceLT(CarBCDistance carBCDistance, int n) {
    }

    @Override
    public void updateBCZeroEmissionDistanceCY(CarBCDistance carBCDistance, int n) {
    }

    @Override
    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
    }

    @Override
    public void updateBCZeroEmissionTimeLT(CarBCTime carBCTime, int n) {
    }

    @Override
    public void updateBCZeroEmissionTimeCY(CarBCTime carBCTime, int n) {
    }

    @Override
    public void updateBCMaxValues(BCMaxValues bCMaxValues, int n) {
    }

    @Override
    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    @Override
    public void updateBCResetTimeStampLT(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    @Override
    public void updateBCResetTimeStampCY(BCResetTimeStamp bCResetTimeStamp, int n) {
    }

    @Override
    public void updateBCAstaMFA(boolean bl, int n) {
    }

    @Override
    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
    }

    @Override
    public void updateHUDHeightAdjustment(byte by, int n) {
    }

    @Override
    public void updateHUDBrightness(byte by, int n) {
    }

    @Override
    public void updateHUDColour(int n, int n2, int n3) {
    }

    @Override
    public void updateHUDContent(HUDContent hUDContent, int n) {
    }

    @Override
    public void updateHUDInfo(boolean bl, int n) {
    }

    @Override
    public void updateHUDSystemOnOff(boolean bl, int n) {
    }

    @Override
    public void updateHUDRotationAdjustment(int n, int n2) {
    }

    @Override
    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
    }

    @Override
    public void updateDCBrightness(int n, int n2) {
    }

    @Override
    public void updateDCVolume(int n, int n2) {
    }

    @Override
    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    @Override
    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    @Override
    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
    }

    @Override
    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
    }

    @Override
    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
    }

    @Override
    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
    }

    @Override
    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
    }

    @Override
    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
    }

    @Override
    public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
    }

    @Override
    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
    }

    @Override
    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
    }

    @Override
    public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2, int n) {
    }

    @Override
    public void updateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void responseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
    }

    @Override
    public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
    }

    @Override
    public void updateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
    }

    @Override
    public void updateDCActiveDisplayPreset(int n, int n2) {
    }

    @Override
    public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration, int n) {
    }

    @Override
    public void updateCompassInfo(int n, int n2, int n3) {
    }

    @Override
    public void updateHUDLicense(boolean bl, int n) {
    }

    @Override
    public void updateDCLEDConfiguration(boolean bl, int n) {
    }
}

