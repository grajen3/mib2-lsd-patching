/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition;

import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarAirConditionC {
    default public void setAirconAirCirculationMan(boolean bl) {
    }

    default public void setAirconAirCirculationAuto(boolean bl) {
    }

    default public void setAirconMiddleExhaustion(int n) {
    }

    default public void setAirconRearWindowHeater(boolean bl) {
    }

    default public void setAirconIndirectVentilation(boolean bl) {
    }

    default public void setAirconPopupTime(int n) {
    }

    default public void setAirconHeater(boolean bl) {
    }

    default public void setAirconRearAuxHeater(boolean bl) {
    }

    default public void setAirconFrontWindowHeater(boolean bl) {
    }

    default public void setAirconDefrost(boolean bl) {
    }

    default public void setAirconMaxDefrost(boolean bl) {
    }

    default public void setAirconSolar(boolean bl) {
    }

    default public void setAirconAC(boolean bl) {
    }

    default public void setAirconMaxAC(boolean bl) {
    }

    default public void setAirconEcoAC(boolean bl) {
    }

    default public void setAirconRearControl(boolean bl) {
    }

    default public void setAirconRearControlFondPlus(boolean bl) {
    }

    default public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater) {
    }

    default public void setAirconFrontWindowHeaterAuto(boolean bl) {
    }

    default public void setAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation) {
    }

    default public void setAirconSynchronisation(AirconSynchronisation airconSynchronisation) {
    }

    default public void setAirconSuppressVisualisation(boolean bl) {
    }

    default public void setAirconSystemOnOffRow(int n, boolean bl) {
    }

    default public void setAirconAirCirculationSensitivity(int n) {
    }

    default public void setAirconResidualHeat(boolean bl) {
    }

    default public void showAirconPopup(AirconContent airconContent) {
    }

    default public void cancelAirconPopup(AirconContent airconContent, int n) {
    }

    default public void setAirconContent(AirconContent airconContent) {
    }

    default public void setAirconTempZone(int n, AirconTemp airconTemp) {
    }

    default public void setAirconAirVolume(int n, AirconAirVolume airconAirVolume) {
    }

    default public void setAirconAirDistribution(int n, AirconAirDistribution airconAirDistribution) {
    }

    default public void setAirconFootwellTemp(int n, int n2) {
    }

    default public void setAirconSeatHeater(int n, int n2, int n3) {
    }

    default public void setAirconSeatVentilation(int n, int n2, int n3) {
    }

    default public void setAirconHMIIsReady(boolean bl) {
    }

    default public void setAirconSeatHeaterDistribution(int n, int n2) {
    }

    default public void setAirconSeatVentilationDistribution(int n, int n2) {
    }

    default public void setAirconTempStep(int n, int n2) {
    }

    default public void setAirconClimateStyle(int n, int n2) {
    }

    default public void setAirconSetFactoryDefaultMaster() {
    }

    default public void setAirconSetFactoryDefaultRow(int n) {
    }

    default public void setAirconNozzleControlRow1(int n) {
    }

    default public void setAirconNozzleControlRow2(int n) {
    }

    default public void setAirconNozzleControlRow3(int n) {
    }

    default public void requestAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo) {
    }

    default public void setAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
    }

    default public void setAirconSideWindowDefrost(boolean bl) {
    }

    default public void setAirconPureAir(AirconPureAirSetup airconPureAirSetup) {
    }

    default public void setAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration) {
    }

    default public void setAirconAirQuality(int n, int n2) {
    }

    default public void setAirconSeatNeckHeater(int n, boolean bl, int n2) {
    }

    default public void setAirconSeatSurfaceHeater(int n, boolean bl, boolean bl2, int n2) {
    }

    default public void setAirconIndividualClimatisation(int n, boolean bl) {
    }

    default public void setAirconIonisator(int n, int n2) {
    }

    default public void setAirconBodyCloseMeasures(int n, boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
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

