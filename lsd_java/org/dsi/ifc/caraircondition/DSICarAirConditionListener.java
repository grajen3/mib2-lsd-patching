/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarAirConditionListener
extends DSIListener {
    default public void requestAirconPopup(AirconContent airconContent) {
    }

    default public void acknowlegdeAirconPopup(AirconContent airconContent) {
    }

    default public void updateAirconContent(AirconContent airconContent, int n) {
    }

    default public void updateAirconAirCirculationMan(boolean bl, int n) {
    }

    default public void updateAirconAirCirculationAuto(boolean bl, int n) {
    }

    default public void updateAirconAirCirculationSensitivity(int n, int n2) {
    }

    default public void updateAirconAirCirculationMiddleExhaustion(int n, int n2) {
    }

    default public void updateAirconRearWindowHeater(boolean bl, int n) {
    }

    default public void updateAirconIndirectVentilation(boolean bl, int n) {
    }

    default public void updateAirconPopupTime(int n, int n2) {
    }

    default public void updateAirconHeater(boolean bl, int n) {
    }

    default public void updateAirconRearAuxHeater(boolean bl, int n) {
    }

    default public void updateAirconFrontWindowHeater(boolean bl, int n) {
    }

    default public void updateAirconDefrost(boolean bl, int n) {
    }

    default public void updateAirconMaxDefrost(boolean bl, int n) {
    }

    default public void updateAirconSolar(boolean bl, int n) {
    }

    default public void updateAirconAC(boolean bl, int n) {
    }

    default public void updateAirconMaxAC(boolean bl, int n) {
    }

    default public void updateAirconEcoAC(boolean bl, int n) {
    }

    default public void updateAirconRearControl(boolean bl, int n) {
    }

    default public void updateAirconRearControlFondPlus(boolean bl, int n) {
    }

    default public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
    }

    default public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
    }

    default public void updateAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation, int n) {
    }

    default public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
    }

    default public void updateAirconSuppressVisualisation(boolean bl, int n) {
    }

    default public void updateAirconResidualHeat(boolean bl, int n) {
    }

    default public void updateAirconSystemOnOffRow1(boolean bl, int n) {
    }

    default public void updateAirconSystemOnOffRow2(boolean bl, int n) {
    }

    default public void updateAirconSystemOnOffRow3(boolean bl, int n) {
    }

    default public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconFootwellTempZone1(int n, int n2) {
    }

    default public void updateAirconSeatHeaterZone1(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone1(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconFootwellTempZone2(int n, int n2) {
    }

    default public void updateAirconSeatHeaterZone2(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone2(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconFootwellTempZone3(int n, int n2) {
    }

    default public void updateAirconSeatHeaterZone3(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone3(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconFootwellTempZone4(int n, int n2) {
    }

    default public void updateAirconSeatHeaterZone4(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone4(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone5(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone5(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone5(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconFootwellTempZone5(int n, int n2) {
    }

    default public void updateAirconSeatHeaterZone5(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone5(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone6(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone6(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone6(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconFootwellTempZone6(int n, int n2) {
    }

    default public void updateAirconSeatHeaterZone6(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone6(int n, int n2, int n3) {
    }

    default public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
    }

    default public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
    }

    default public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
    }

    default public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
    }

    default public void updateAirconSeatHeaterDistributionZone5(int n, int n2) {
    }

    default public void updateAirconSeatHeaterDistributionZone6(int n, int n2) {
    }

    default public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
    }

    default public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
    }

    default public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
    }

    default public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
    }

    default public void updateAirconSeatVentilationDistributionZone5(int n, int n2) {
    }

    default public void updateAirconSeatVentilationDistributionZone6(int n, int n2) {
    }

    default public void updateAirconTempStepZone1(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone2(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone3(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone4(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone5(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone6(int n, int n2, int n3) {
    }

    default public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
    }

    default public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
    }

    default public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
    }

    default public void updateAirconViewOptionsRow3(AirconRowViewOptions airconRowViewOptions, int n) {
    }

    default public void acknowledgeAirconSetFactoryDefaultMaster(boolean bl) {
    }

    default public void acknowledgeAirconSetFactoryDefaultRow(int n, boolean bl) {
    }

    default public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
    }

    default public void acknowledgeAirconNozzleControlRow2(boolean bl, boolean bl2) {
    }

    default public void acknowledgeAirconNozzleControlRow3(boolean bl, boolean bl2) {
    }

    default public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    default public void responseAirconNozzleListRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    default public void responseAirconNozzleListRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    default public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    default public void updateAirconNozzleListUpdateInfoRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    default public void updateAirconNozzleListUpdateInfoRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    default public void updateAirconNozzleListTotalNumberOfElementsRow1(int n, int n2) {
    }

    default public void updateAirconNozzleListTotalNumberOfElementsRow2(int n, int n2) {
    }

    default public void updateAirconNozzleListTotalNumberOfElementsRow3(int n, int n2) {
    }

    default public void updateAirconSideWindowDefrost(boolean bl, int n) {
    }

    default public void updateAirconPureAir(AirconPureAirSetup airconPureAirSetup, int n, int n2) {
    }

    default public void updateAirconFreshAirState(AirconFreshAirCartridge airconFreshAirCartridge, AirconFreshAirCartridge airconFreshAirCartridge2, int n) {
    }

    default public void updateAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration, int n) {
    }

    default public void updateAirconAirQuality(AirconAirQuality airconAirQuality, int n) {
    }

    default public void updateAirconNozzleStatusRow1(boolean bl, int n) {
    }

    default public void updateAirconNozzleStatusRow2(boolean bl, int n) {
    }

    default public void updateAirconNozzleStatusRow3(boolean bl, int n) {
    }

    default public void updateAirconClimateStyleZone1(int n, int n2) {
    }

    default public void updateAirconClimateStyleZone2(int n, int n2) {
    }

    default public void updateAirconClimateStyleZone3(int n, int n2) {
    }

    default public void updateAirconClimateStyleZone4(int n, int n2) {
    }

    default public void updateAirconClimateStyleZone5(int n, int n2) {
    }

    default public void updateAirconClimateStyleZone6(int n, int n2) {
    }

    default public void updateAirconClimateStateZone1(int n, int n2) {
    }

    default public void updateAirconClimateStateZone2(int n, int n2) {
    }

    default public void updateAirconClimateStateZone3(int n, int n2) {
    }

    default public void updateAirconClimateStateZone4(int n, int n2) {
    }

    default public void updateAirconClimateStateZone5(int n, int n2) {
    }

    default public void updateAirconClimateStateZone6(int n, int n2) {
    }

    default public void updateAirconSeatNeckHeaterZone1(boolean bl, int n, int n2) {
    }

    default public void updateAirconSeatNeckHeaterZone2(boolean bl, int n, int n2) {
    }

    default public void updateAirconSeatNeckHeaterZone3(boolean bl, int n, int n2) {
    }

    default public void updateAirconSeatNeckHeaterZone4(boolean bl, int n, int n2) {
    }

    default public void updateAirconSeatNeckHeaterZone5(boolean bl, int n, int n2) {
    }

    default public void updateAirconSeatNeckHeaterZone6(boolean bl, int n, int n2) {
    }

    default public void updateAirconSeatSurfaceHeaterZone1(boolean bl, boolean bl2, int n, int n2) {
    }

    default public void updateAirconSeatSurfaceHeaterZone2(boolean bl, boolean bl2, int n, int n2) {
    }

    default public void updateAirconSeatSurfaceHeaterZone3(boolean bl, boolean bl2, int n, int n2) {
    }

    default public void updateAirconSeatSurfaceHeaterZone4(boolean bl, boolean bl2, int n, int n2) {
    }

    default public void updateAirconSeatSurfaceHeaterZone5(boolean bl, boolean bl2, int n, int n2) {
    }

    default public void updateAirconSeatSurfaceHeaterZone6(boolean bl, boolean bl2, int n, int n2) {
    }

    default public void updateAirconIndividualClimatisationZone1(boolean bl, int n) {
    }

    default public void updateAirconIndividualClimatisationZone2(boolean bl, int n) {
    }

    default public void updateAirconIndividualClimatisationZone3(boolean bl, int n) {
    }

    default public void updateAirconIndividualClimatisationZone4(boolean bl, int n) {
    }

    default public void updateAirconIndividualClimatisationZone5(boolean bl, int n) {
    }

    default public void updateAirconIndividualClimatisationZone6(boolean bl, int n) {
    }

    default public void updateAirconIonisatorZone1(int n, int n2) {
    }

    default public void updateAirconIonisatorZone2(int n, int n2) {
    }

    default public void updateAirconIonisatorZone3(int n, int n2) {
    }

    default public void updateAirconIonisatorZone4(int n, int n2) {
    }

    default public void updateAirconIonisatorZone5(int n, int n2) {
    }

    default public void updateAirconIonisatorZone6(int n, int n2) {
    }

    default public void updateAirconBodyCloseMeasuresZone1(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
    }

    default public void updateAirconBodyCloseMeasuresZone2(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
    }

    default public void updateAirconBodyCloseMeasuresZone3(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
    }

    default public void updateAirconBodyCloseMeasuresZone4(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
    }

    default public void updateAirconBodyCloseMeasuresZone5(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
    }

    default public void updateAirconBodyCloseMeasuresZone6(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
    }
}

