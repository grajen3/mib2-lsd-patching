/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

import org.dsi.ifc.base.DSIBase;
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

public interface DSICarAirCondition
extends DSIBase {
    public static final String VERSION;
    public static final int STYLE_WEAK;
    public static final int STYLE_MEDIUM;
    public static final int STYLE_STRONG;
    public static final int AIRVOLUMEAUTO_OFF;
    public static final int AIRVOLUMEAUTO_AUTO;
    public static final int AIRVOLUMEAUTO_AUTOLOW;
    public static final int AIRVOLUMEAUTO_AUTOHIGH;
    public static final int SYNCHRONISATION_NOTACTIVE;
    public static final int SYNCHRONISATION_ZL1R;
    public static final int SYNCHRONISATION_ZR1R;
    public static final int SYNCHRONISATION_ZL2R;
    public static final int SYNCHRONISATION_ZR2R;
    public static final int SYNCHRONISATION_ZL3R;
    public static final int SYNCHRONISATION_ZR3R;
    public static final int AIRCONCONTENT_NONE;
    public static final int AIRCONCONTENT_AIRDISTRIBUTION;
    public static final int AIRCONCONTENT_TEMPERATURE;
    public static final int AIRCONCONTENT_SEATHEATER;
    public static final int AIRCONCONTENT_SEATVENTILATION;
    public static final int AIRCONCONTENT_AIRVOLUME;
    public static final int AIRCONCONTENT_EXHAUSTION;
    public static final int AIRCONCONTENT_SETUP;
    public static final int AIRCONCONTENT_DEFROST;
    public static final int AIRCONCONTENT_AUTO;
    public static final int AIRCONCONTENT_CIRCULATION;
    public static final int AIRCONCONTENT_AC;
    public static final int AIRCONCONTENT_MIDDLEEXHAUSTION;
    public static final int AIRCONCONTENT_SYNCHRONISATION;
    public static final int AIRCONCONTENT_REARWINDOWHEATER;
    public static final int AIRCONCONTENT_REARCONTROL;
    public static final int AIRCONCONTENT_RESIDUAL;
    public static final int AIRCONCONTENT_HEATER;
    public static final int AIRCONCONTENT_STYLE;
    public static final int AIRCONCONTENT_FRONTWINDOWHEATER;
    public static final int AIRCONCONTENT_FOOTWELLTEMP;
    public static final int AIRCONCONTENT_STEERINGWHEELHEATER;
    public static final int STEERINGWHEELHEATINGSTEP_STEP1;
    public static final int STEERINGWHEELHEATINGSTEP_STEP2;
    public static final int STEERINGWHEELHEATINGSTEP_STEP3;
    public static final int STYLESTATE_UNKNOWN;
    public static final int STYLESTATE_COOLING;
    public static final int STYLESTATE_VENTING;
    public static final int STYLESTATE_HEATING;
    public static final int STYLESTATE_PASSIVE_COOLING;
    public static final int STYLESTATE_PASSIVE_VENTING;
    public static final int STYLESTATE_PASSIVE_HEATING;
    public static final int NOZZLEHORIZONTALPOSITION_LEFT;
    public static final int NOZZLEHORIZONTALPOSITION_LEFTCENTRE;
    public static final int NOZZLEHORIZONTALPOSITION_RIGHTCENTRE;
    public static final int NOZZLEHORIZONTALPOSITION_RIGHT;
    public static final int NOZZLEVERTICALPOSITION_UP;
    public static final int NOZZLEVERTICALPOSITION_CENTRE;
    public static final int NOZZLEVERTICALPOSITION_BOTTOM;
    public static final int NOZZLEINTERVAL_OFF;
    public static final int NOZZLEINTERVAL_SLOW;
    public static final int NOZZLEINTERVAL_MEDIUM;
    public static final int NOZZLEINTERVAL_FAST;
    public static final int NOZZLELISTRACONTENT_POS;
    public static final int NOZZLELISTRACONTENT_HORIZONTALPOSITION;
    public static final int NOZZLELISTRACONTENT_VERTICALPOSITION;
    public static final int NOZZLELISTRACONTENT_CAPABILITIES;
    public static final int NOZZLELISTRACONTENT_HORIZONTAL;
    public static final int NOZZLELISTRACONTENT_VERTICAL;
    public static final int NOZZLELISTRACONTENT_AIRFLOW;
    public static final int NOZZLELISTRACONTENT_STYLE;
    public static final int NOZZLELISTRACONTENT_INTERVALHORIZONTAL;
    public static final int NOZZLELISTRACONTENT_INTERVALVERTICAL;
    public static final int NOZZLECONTROL_CLOSE;
    public static final int NOZZLECONTROL_OPEN;
    public static final int PUREAIRSTATE_STEP0;
    public static final int PUREAIRSTATE_STEP1;
    public static final int PUREAIRSTATE_STEP2;
    public static final int PUREAIRSTATE_STEP3;
    public static final int PUREAIRSTATE_STEP4;
    public static final int PUREAIRSTATE_STEP5;
    public static final int PUREAIRSTATE_STEP6;
    public static final int PUREAIRSTATE_STEP7;
    public static final int PUREAIRSTATE_STEP8;
    public static final int PUREAIRSTATE_STEP9;
    public static final int PUREAIRSTATE_STEP10;
    public static final int PUREAIRSTATE_NOTSUPPORTED;
    public static final int FRESHAIRCARTRIDGEWARNING_NONE;
    public static final int FRESHAIRCARTRIDGEWARNING_LEVEL1;
    public static final int FRESHAIRCARTRIDGEWARNING_LEVEL2;
    public static final int FRESHAIRCARTRIDGEWARNING_LEVEL3;
    public static final int FRESHAIRCONFIGSETUP_OFF;
    public static final int FRESHAIRCONFIGSETUP_AUTO;
    public static final int FRESHAIRCONFIGSETUP_AUTOONLINEIQS;
    public static final int FRESHAIRCARTRIDGESELECTION_NONE;
    public static final int FRESHAIRCARTRIDGESELECTION_CARTRIDGE1;
    public static final int FRESHAIRCARTRIDGESELECTION_CARTRIDGE2;
    public static final int SEATCLIMATESTATE_OFF;
    public static final int SEATCLIMATESTATE_ON;
    public static final int SEATCLIMATESTATE_AUTO;
    public static final int IONISATORSETUP_OFF;
    public static final int IONISATORSETUP_AUTO;
    public static final int IONISATORSETUP_AUTOONLINEIQS;
    public static final int ZONES_ZONE1;
    public static final int ZONES_ZONE2;
    public static final int ZONES_ZONE3;
    public static final int ZONES_ZONE4;
    public static final int ZONES_ZONE5;
    public static final int ZONES_ZONE6;
    public static final int ROWS_ROW1;
    public static final int ROWS_ROW2;
    public static final int ROWS_ROW3;
    public static final int ATTR_AIRCONVIEWOPTIONSMASTER;
    public static final int ATTR_AIRCONCONTENT;
    public static final int ATTR_AIRCONAIRCIRCULATIONMAN;
    public static final int ATTR_AIRCONAIRCIRCULATIONAUTO;
    public static final int ATTR_AIRCONAIRCIRCULATIONSENSITIVITY;
    public static final int ATTR_AIRCONAIRCIRCULATIONMIDDLEEXHAUSTION;
    public static final int ATTR_AIRCONREARWINDOWHEATER;
    public static final int ATTR_AIRCONINDIRECTVENTILATION;
    public static final int ATTR_AIRCONPOPUPTIME;
    public static final int ATTR_AIRCONHEATER;
    public static final int ATTR_AIRCONREARAUXHEATER;
    public static final int ATTR_AIRCONFRONTWINDOWHEATER;
    public static final int ATTR_AIRCONDEFROST;
    public static final int ATTR_AIRCONMAXDEFROST;
    public static final int ATTR_AIRCONSOLAR;
    public static final int ATTR_AIRCONAC;
    public static final int ATTR_AIRCONMAXAC;
    public static final int ATTR_AIRCONECOAC;
    public static final int ATTR_AIRCONREARCONTROL;
    public static final int ATTR_AIRCONREARCONTROLFONDPLUS;
    public static final int ATTR_AIRCONSTEERINGWHEELHEATER;
    public static final int ATTR_AIRCONFRONTWINDOWHEATERAUTO;
    public static final int ATTR_AIRCONBLOWERCOMPENSATION;
    public static final int ATTR_AIRCONSYNCHRONISATION;
    public static final int ATTR_AIRCONSUPPRESSVISUALISATION;
    public static final int ATTR_AIRCONSYSTEMONOFFROW1;
    public static final int ATTR_AIRCONSYSTEMONOFFROW2;
    public static final int ATTR_AIRCONSYSTEMONOFFROW3;
    public static final int ATTR_AIRCONRESIDUALHEAT;
    public static final int ATTR_AIRCONSIDEWINDOWDEFROST;
    public static final int ATTR_AIRCONPUREAIR;
    public static final int ATTR_AIRCONFRESHAIRSTATE;
    public static final int ATTR_AIRCONFRESHAIRCONFIG;
    public static final int ATTR_AIRCONAIRQUALITY;
    public static final int ATTR_AIRCONVIEWOPTIONSROW1;
    public static final int ATTR_AIRCONNOZZLELISTUPDATEINFOROW1;
    public static final int ATTR_AIRCONNOZZLELISTTOTALNUMBEROFELEMENTSROW1;
    public static final int ATTR_AIRCONNOZZLESTATUSROW1;
    public static final int ATTR_AIRCONTEMPZONE1;
    public static final int ATTR_AIRCONAIRVOLUMEZONE1;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE1;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE1;
    public static final int ATTR_AIRCONSEATHEATERZONE1;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE1;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE1;
    public static final int ATTR_AIRCONCLIMATESTATEZONE1;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE1;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE1;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE1;
    public static final int ATTR_AIRCONIONISATORZONE1;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE1;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE1;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE1;
    public static final int ATTR_AIRCONTEMPSTEPZONE1;
    public static final int ATTR_AIRCONTEMPZONE2;
    public static final int ATTR_AIRCONAIRVOLUMEZONE2;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE2;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE2;
    public static final int ATTR_AIRCONSEATHEATERZONE2;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE2;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE2;
    public static final int ATTR_AIRCONCLIMATESTATEZONE2;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE2;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE2;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE2;
    public static final int ATTR_AIRCONIONISATORZONE2;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE2;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE2;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE2;
    public static final int ATTR_AIRCONTEMPSTEPZONE2;
    public static final int ATTR_AIRCONVIEWOPTIONSROW2;
    public static final int ATTR_AIRCONNOZZLELISTUPDATEINFOROW2;
    public static final int ATTR_AIRCONNOZZLELISTTOTALNUMBEROFELEMENTSROW2;
    public static final int ATTR_AIRCONNOZZLESTATUSROW2;
    public static final int ATTR_AIRCONTEMPZONE3;
    public static final int ATTR_AIRCONAIRVOLUMEZONE3;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE3;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE3;
    public static final int ATTR_AIRCONSEATHEATERZONE3;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE3;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE3;
    public static final int ATTR_AIRCONCLIMATESTATEZONE3;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE3;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE3;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE3;
    public static final int ATTR_AIRCONIONISATORZONE3;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE3;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE3;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE3;
    public static final int ATTR_AIRCONTEMPSTEPZONE3;
    public static final int ATTR_AIRCONTEMPZONE4;
    public static final int ATTR_AIRCONAIRVOLUMEZONE4;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE4;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE4;
    public static final int ATTR_AIRCONSEATHEATERZONE4;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE4;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE4;
    public static final int ATTR_AIRCONCLIMATESTATEZONE4;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE4;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE4;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE4;
    public static final int ATTR_AIRCONIONISATORZONE4;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE4;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE4;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE4;
    public static final int ATTR_AIRCONTEMPSTEPZONE4;
    public static final int ATTR_AIRCONVIEWOPTIONSROW3;
    public static final int ATTR_AIRCONNOZZLELISTUPDATEINFOROW3;
    public static final int ATTR_AIRCONNOZZLELISTTOTALNUMBEROFELEMENTSROW3;
    public static final int ATTR_AIRCONNOZZLESTATUSROW3;
    public static final int ATTR_AIRCONTEMPZONE5;
    public static final int ATTR_AIRCONAIRVOLUMEZONE5;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE5;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE5;
    public static final int ATTR_AIRCONSEATHEATERZONE5;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE5;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE5;
    public static final int ATTR_AIRCONCLIMATESTATEZONE5;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE5;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE5;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE5;
    public static final int ATTR_AIRCONIONISATORZONE5;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE5;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE5;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE5;
    public static final int ATTR_AIRCONTEMPSTEPZONE5;
    public static final int ATTR_AIRCONTEMPZONE6;
    public static final int ATTR_AIRCONAIRVOLUMEZONE6;
    public static final int ATTR_AIRCONAIRDISTRIBUTIONZONE6;
    public static final int ATTR_AIRCONFOOTWELLTEMPZONE6;
    public static final int ATTR_AIRCONSEATHEATERZONE6;
    public static final int ATTR_AIRCONSEATVENTILATIONZONE6;
    public static final int ATTR_AIRCONCLIMATESTYLEZONE6;
    public static final int ATTR_AIRCONCLIMATESTATEZONE6;
    public static final int ATTR_AIRCONSEATNECKHEATERZONE6;
    public static final int ATTR_AIRCONSEATSURFACEHEATERZONE6;
    public static final int ATTR_AIRCONINDIVIDUALCLIMATISATIONZONE6;
    public static final int ATTR_AIRCONIONISATORZONE6;
    public static final int ATTR_AIRCONBODYCLOSEMEASURESZONE6;
    public static final int ATTR_AIRCONSEATHEATERDISTRIBUTIONZONE6;
    public static final int ATTR_AIRCONSEATVENTILATIONDISTRIBUTIONZONE6;
    public static final int ATTR_AIRCONTEMPSTEPZONE6;
    public static final int RT_SHOWAIRCONPOPUP;
    public static final int RT_CANCELAIRCONPOPUP;
    public static final int RT_SETAIRCONAIRCIRCULATIONMAN;
    public static final int RT_SETAIRCONAIRCIRCULATIONAUTO;
    public static final int RT_SETAIRCONMIDDLEEXHAUSTION;
    public static final int RT_SETAIRCONREARWINDOWHEATER;
    public static final int RT_SETAIRCONINDIRECTVENTILATION;
    public static final int RT_SETAIRCONPOPUPTIME;
    public static final int RT_SETAIRCONHEATER;
    public static final int RT_SETAIRCONREARAUXHEATER;
    public static final int RT_SETAIRCONFRONTWINDOWHEATER;
    public static final int RT_SETAIRCONDEFROST;
    public static final int RT_SETAIRCONMAXDEFROST;
    public static final int RT_SETAIRCONSOLAR;
    public static final int RT_SETAIRCONAC;
    public static final int RT_SETAIRCONMAXAC;
    public static final int RT_SETAIRCONECOAC;
    public static final int RT_SETAIRCONREARCONTROL;
    public static final int RT_SETAIRCONREARCONTROLFONDPLUS;
    public static final int RT_SETAIRCONSTEERINGWHEELHEATER;
    public static final int RT_SETAIRCONFRONTWINDOWHEATERAUTO;
    public static final int RT_SETAIRCONBLOWERCOMPENSATION;
    public static final int RT_SETAIRCONSYNCHRONISATION;
    public static final int RT_SETAIRCONSUPPRESSVISUALISATION;
    public static final int RT_SETAIRCONSYSTEMONOFFROW;
    public static final int RT_SETAIRCONRESIDUALHEAT;
    public static final int RT_SETAIRCONCONTENT;
    public static final int RT_SETAIRCONAIRCIRCULATIONSENSITIVITY;
    public static final int RT_SETAIRCONHMIISREADY;
    public static final int RT_SETAIRCONTEMPZONE;
    public static final int RT_SETAIRCONAIRVOLUME;
    public static final int RT_SETAIRCONAIRDISTRIBUTION;
    public static final int RT_SETAIRCONFOOTWELLTEMP;
    public static final int RT_SETAIRCONSEATHEATER;
    public static final int RT_SETAIRCONSEATVENTILATION;
    public static final int RT_SETAIRCONSEATHEATERDISTRIBUTION;
    public static final int RT_SETAIRCONSEATVENTILATIONDISTRIBUTION;
    public static final int RT_SETAIRCONTEMPSTEP;
    public static final int RT_SETAIRCONIONISATOR;
    public static final int RT_SETAIRCONCLIMATESTYLE;
    public static final int RT_SETAIRCONSETFACTORYDEFAULTMASTER;
    public static final int RT_SETAIRCONSETFACTORYDEFAULTROW;
    public static final int RT_SETAIRCONNOZZLECONTROLROW1;
    public static final int RT_SETAIRCONNOZZLECONTROLROW2;
    public static final int RT_SETAIRCONNOZZLECONTROLROW3;
    public static final int RT_REQUESTAIRCONNOZZLELISTROW;
    public static final int RT_SETAIRCONNOZZLELISTROW;
    public static final int RT_SETAIRCONSIDEWINDOWDEFROST;
    public static final int RT_SETAIRCONPUREAIR;
    public static final int RT_SETAIRCONFRESHAIRCONFIG;
    public static final int RT_SETAIRCONAIRQUALITY;
    public static final int RT_SETAIRCONSEATNECKHEATER;
    public static final int RT_SETAIRCONSEATSURFACEHEATER;
    public static final int RT_SETAIRCONINDIVIDUALCLIMATISATION;
    public static final int RT_SETAIRCONBODYCLOSEMEASURES;
    public static final int RP_ACKNOWLEDGEAIRCONSETFACTORYDEFAULTMASTER;
    public static final int RP_ACKNOWLEDGEAIRCONSETFACTORYDEFAULTROW;
    public static final int RP_ACKNOWLEDGEAIRCONNOZZLECONTROLROW1;
    public static final int RP_ACKNOWLEDGEAIRCONNOZZLECONTROLROW2;
    public static final int RP_ACKNOWLEDGEAIRCONNOZZLECONTROLROW3;
    public static final int IN_REQUESTAIRCONPOPUP;
    public static final int IN_ACKNOWLEGDEAIRCONPOPUP;
    public static final int IN_RESPONSEAIRCONNOZZLELISTROW1;
    public static final int IN_RESPONSEAIRCONNOZZLELISTROW2;
    public static final int IN_RESPONSEAIRCONNOZZLELISTROW3;

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
}

