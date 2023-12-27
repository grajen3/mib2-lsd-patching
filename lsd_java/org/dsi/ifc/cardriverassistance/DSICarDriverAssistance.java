/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSICarDriverAssistance
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SWAVIEWOPTIONS;
    public static final int ATTR_SWAGONGSTATE;
    public static final int ATTR_SWAGONGVOLUME;
    public static final int ATTR_SWASYSTEM;
    public static final int ATTR_SWAWARNINGTIME;
    public static final int ATTR_SWABRIGHTNESS;
    public static final int ATTR_SWAFREQUENCY;
    public static final int ATTR_SWARCTASENSORDATA;
    public static final int ATTR_SWARCTA;
    public static final int ATTR_SWAEXITASSIST;
    public static final int ATTR_NVVIEWOPTIONS;
    public static final int ATTR_NVACTIVATION;
    public static final int ATTR_NVCONTRAST;
    public static final int ATTR_NVBRIGHTNESS;
    public static final int ATTR_NVOBJECTDETECTION;
    public static final int ATTR_NVCOLORPA;
    public static final int ATTR_NVDESIGNPA;
    public static final int ATTR_NVDISPLAY;
    public static final int ATTR_NVZOOMPANNING;
    public static final int ATTR_NVSOUND;
    public static final int ATTR_NVSYMBOL;
    public static final int ATTR_NVSYSTEM;
    public static final int ATTR_NVWARNINGTIMEGAP;
    public static final int ATTR_LDWHCAVIEWOPTIONS;
    public static final int ATTR_LDWWARNINGTIME;
    public static final int ATTR_LDWSTEERINGWHEELVIBRATION;
    public static final int ATTR_HCATOLERANCELEVEL;
    public static final int ATTR_HCAINTERVENTIONSTYLE;
    public static final int ATTR_LDWHCASYSTEMONOFF;
    public static final int ATTR_LDWHCAWARNINGSOUND;
    public static final int ATTR_ACCVIEWOPTIONS;
    public static final int ATTR_ACCGONGSTATE;
    public static final int ATTR_ACCGONGVOLUME;
    public static final int ATTR_ACCDRIVINGPROGRAM;
    public static final int ATTR_ACCTIMEGAP;
    public static final int ATTR_ACCDEFAULTMODE;
    public static final int ATTR_ACCCURVEASSIST;
    public static final int ATTR_ACCSPEEDLIMITADOPTION;
    public static final int ATTR_ACCSPEEDLIMITOFFSET;
    public static final int ATTR_ACCTRAFFICJAMASSIST;
    public static final int ATTR_ACCDISTANCEWARNING;
    public static final int ATTR_PACCSENSIBILITY;
    public static final int ATTR_PACCMAXSPEED;
    public static final int ATTR_PACCMEANVELOCITY;
    public static final int ATTR_PACCMEANCONSUMPTION;
    public static final int ATTR_PACCCOASTINGPERCENTAGE;
    public static final int ATTR_PACCDRIVINGPROGRAM;
    public static final int ATTR_PACCSYSTEMSTATE;
    public static final int ATTR_AWVVIEWOPTIONS;
    public static final int ATTR_AWVSYSTEM;
    public static final int ATTR_AWVWARNING;
    public static final int ATTR_AWVGONG;
    public static final int ATTR_AWVGONGVOLUME;
    public static final int ATTR_AWVBRAKEJERK;
    public static final int ATTR_AWVEMERGENCYBRAKE;
    public static final int ATTR_AWVDISTANCEWARNING;
    public static final int ATTR_AWVWARNINGTIMEGAP;
    public static final int ATTR_TSDVIEWOPTIONS;
    public static final int ATTR_TSDSYSTEMONOFF;
    public static final int ATTR_TSDTRAILERDETECTION;
    public static final int ATTR_TSDSIGN1;
    public static final int ATTR_TSDSIGN2;
    public static final int ATTR_TSDSIGN3;
    public static final int ATTR_TSDSIGN4;
    public static final int ATTR_TSDSIGN5;
    public static final int ATTR_TSDROADSIGNFILTER;
    public static final int ATTR_TSDSPEEDWARNINGTHRESHOLD;
    public static final int ATTR_TSDTRAILERSPEEDLIMIT;
    public static final int ATTR_TSDSYSTEMMESSAGES;
    public static final int ATTR_TSDSPEEDWARNINGACOUSTICS;
    public static final int ATTR_MKEVIEWOPTIONS;
    public static final int ATTR_MKESYSTEMONOFF;
    public static final int ATTR_PAVIEWOPTIONS;
    public static final int ATTR_PASYSTEMONOFF;
    public static final int ATTR_PACONFIGINFORMATION;
    public static final int ATTR_PACONFIGWARNING;
    public static final int ATTR_PAWARNINGTIMEGAP;
    public static final int ATTR_CURVEASSISTSYSTEMONOFF;
    public static final int ATTR_FTAVIEWOPTIONS;
    public static final int ATTR_FTASYSTEMONOFF;
    public static final int ATTR_FTASENSORDATA;
    public static final int ACCDRIVINGPROGRAM_COMFORT;
    public static final int ACCDRIVINGPROGRAM_STANDARD;
    public static final int ACCDRIVINGPROGRAM_DYNAMIC;
    public static final int ACCDRIVINGPROGRAM_ECO;
    public static final int ACCDEFAULTMODE_PRESELECTION;
    public static final int ACCDEFAULTMODE_LASTVALUE;
    public static final int ACCSPEEDLIMITOFFSET_OFF;
    public static final int ACCSPEEDLIMITOFFSET_SMALL;
    public static final int ACCSPEEDLIMITOFFSET_MEDIUM;
    public static final int ACCSPEEDLIMITOFFSET_LARGE;
    public static final int PACCSYSTEMSTATE_OFF;
    public static final int PACCSYSTEMSTATE_INIT;
    public static final int PACCSYSTEMSTATE_STANDBY;
    public static final int PACCSYSTEMSTATE_ACTIVEREGULATING;
    public static final int PACCSYSTEMSTATE_PASSIVE;
    public static final int PACCSYSTEMSTATE_ERRORMAP;
    public static final int PACCSYSTEMSTATE_ERRORSYSTEM;
    public static final int PACCSYSTEMSTATE_ERRORIRREVERSIBLE;
    public static final int AWVSYSTEMMODE_LRR;
    public static final int AWVSYSTEMMODE_SRR;
    public static final int AWVSYSTEMMODE_FCW;
    public static final int LDWSTEERINGWHEELVIBRATION_LOW;
    public static final int LDWSTEERINGWHEELVIBRATION_MEDIUMADAPTIVE;
    public static final int LDWSTEERINGWHEELVIBRATION_STRONG;
    public static final int LDWWARNINGTIME_EARLY;
    public static final int LDWWARNINGTIME_MEDIUMADAPTIVE;
    public static final int LDWWARNINGTIME_LATE;
    public static final int HCAINTERVENTIONSTYLE_TORQUE;
    public static final int HCAINTERVENTIONSTYLE_TORQUEVIBRATION;
    public static final int HCAINTERVENTIONSTYLE_VIBRATION;
    public static final int HCATOLERANCELEVEL_EARLY;
    public static final int HCATOLERANCELEVEL_MEDIUMADAPTIVE;
    public static final int HCATOLERANCELEVEL_LATE;
    public static final int LDWHCAWARNINGSOUND_VERYSILENT;
    public static final int LDWHCAWARNINGSOUND_SILENT;
    public static final int LDWHCAWARNINGSOUND_MEDIUM;
    public static final int LDWHCAWARNINGSOUND_LOUD;
    public static final int LDWHCAWARNINGSOUND_VERYLOUD;
    public static final int SWABRIGHTNESS_VERY_DARK;
    public static final int SWABRIGHTNESS_DARK;
    public static final int SWABRIGHTNESS_MEDIUM;
    public static final int SWABRIGHTNESS_BRIGHT;
    public static final int SWABRIGHTNESS_VERY_BRIGHT;
    public static final int SWAWARNINGTIME_EARLY;
    public static final int SWAWARNINGTIME_MEDIUM;
    public static final int SWAWARNINGTIME_LATE;
    public static final int SWAFREQUENCY_EU;
    public static final int SWAFREQUENCY_GB;
    public static final int SWASYSTEM_SWA;
    public static final int SWASYSTEM_BSD;
    public static final int SWAGONGVOLUME_QUIET;
    public static final int SWAGONGVOLUME_NORMAL;
    public static final int SWAGONGVOLUME_LOUD;
    public static final int SWARCTASTATUSLEVEL_NOTACTIVE;
    public static final int SWARCTASTATUSLEVEL_NOOBSTACLE;
    public static final int SWARCTASTATUSLEVEL_CRITICALOBSTACLE;
    public static final int SWARCTASTATUSLEVEL_HIGHCRITICALOBSTACLE;
    public static final int SWARCTASTATUSLEVEL_DEFECT;
    public static final int SWARCTADISTANCE_NOOBSTACLE;
    public static final int SWARCTADISTANCE_GREAT;
    public static final int SWARCTADISTANCE_MEDIUM;
    public static final int SWARCTADISTANCE_SMALL;
    public static final int SWARCTADISTANCE_UNKNOWN;
    public static final int FTASTATUSLEVEL_NOTACTIVE;
    public static final int FTASTATUSLEVEL_NOOBSTACLE;
    public static final int FTASTATUSLEVEL_CRITICALOBSTACLE;
    public static final int FTASTATUSLEVEL_HIGHCRITICALOBSTACLE;
    public static final int FTASTATUSLEVEL_DEFECT;
    public static final int NIGHTVISIONSOUND_OFF;
    public static final int NIGHTVISIONSOUND_LOW;
    public static final int NIGHTVISIONSOUND_MEDIUM;
    public static final int NIGHTVISIONSOUND_LOUD;
    public static final int NVCOLORPA_COLOR0;
    public static final int NVCOLORPA_COLOR1;
    public static final int NVCOLORPA_COLOR2;
    public static final int NVCOLORPA_COLOR3;
    public static final int NVCOLORPA_COLOR4;
    public static final int NVDESIGNPA_DESIGN0;
    public static final int NVDESIGNPA_DESIGN1;
    public static final int NVDESIGNPA_DESIGN2;
    public static final int NVDESIGNPA_DESIGN3;
    public static final int NVDESIGNPA_DESIGN4;
    public static final int NVDISPLAY_INSTRUMENTCLUSTER;
    public static final int NVDISPLAY_HEADUPDISPLAY;
    public static final int NVDISPLAY_MMI;
    public static final int NVZOOMPANNING_ZOOMPANNINGOFF;
    public static final int NVZOOMPANNING_ZOOMON;
    public static final int NVZOOMPANNING_ZOOMPANNINGON;
    public static final int NVWARNINGTIMEGAP_OFF;
    public static final int NVWARNINGTIMEGAP_LATE;
    public static final int NVWARNINGTIMEGAP_MEDIUM;
    public static final int NVWARNINGTIMEGAP_EARLY;
    public static final int TSDTRAILERSTATE_TRAILER_NOT_DETECTED;
    public static final int TSDTRAILERSTATE_TRAILER_DETECTED;
    public static final int TSDTYPE_NONE;
    public static final int TSDTYPE_VZA;
    public static final int TSDTYPE_VZE;
    public static final int TSDSIGN_NOSIGN;
    public static final int TSDSIGN_SPEEDLIMITEU;
    public static final int TSDSIGN_CANCELSPEEDLIMITEU;
    public static final int TSDSIGN_SPEEDLIMITVAREU;
    public static final int TSDSIGN_CANCELSPEEDLIMITVAREU;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESEU;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLESEU;
    public static final int TSDSIGN_NOPASSINGMORE35TEU;
    public static final int TSDSIGN_CANCELNOPASSINGMORE35TEU;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVAREU;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLESVAREU;
    public static final int TSDSIGN_NOPASSINGMORE35TVAREU;
    public static final int TSDSIGN_CANCELNOPASSINGMORE35TVAREU;
    public static final int TSDSIGN_CANCELALLLIMITSEU;
    public static final int TSDSIGN_CANCELALLLIMITSVAREU;
    public static final int TSDSIGN_RECOMMENDEDSPEED;
    public static final int TSDSIGN_SPEEDLIMITNARUSA;
    public static final int TSDSIGN_SPEEDLIMITVARNARUSA;
    public static final int TSDSIGN_CANCELSPEEDLIMITNARUSA;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARNARUSA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESNARUSA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARNARUSA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLENARUSA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARNARUSA;
    public static final int TSDSIGN_CANCELALLLIMITSNARUSA;
    public static final int TSDSIGN_CANCELALLLIMITSVARNARUSA;
    public static final int TSDSIGN_SPEEDLIMITNARCANADA;
    public static final int TSDSIGN_SPEEDLIMITVARNARCANADA;
    public static final int TSDSIGN_CANCELSPEEDLIMITNARCANADA;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARNARCANADA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESNARCANADA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARNARCANADA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLENARCANADA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARNARCANADA;
    public static final int TSDSIGN_CANCELALLLIMITSNARCANADA;
    public static final int TSDSIGN_CANCELALLLIMITSVARNARCANADA;
    public static final int TSDSIGN_SPEEDLIMITCHINA;
    public static final int TSDSIGN_SPEEDLIMITVARCHINA;
    public static final int TSDSIGN_CANCELSPEEDLIMITCHINA;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARCHINA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESCHINA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARCHINA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLECHINA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARCHINA;
    public static final int TSDSIGN_CANCELALLLIMITSCHINA;
    public static final int TSDSIGN_CANCELALLLIMITSVARCHINA;
    public static final int TSDSIGN_SPEEDLIMITJAPAN;
    public static final int TSDSIGN_SPEEDLIMITVARJAPAN;
    public static final int TSDSIGN_CANCELSPEEDLIMITJAPAN;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARJAPAN;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESJAPAN;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARJAPAN;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEJAPAN;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARJAPAN;
    public static final int TSDSIGN_CANCELALLLIMITSJAPAN;
    public static final int TSDSIGN_CANCELALLLIMITSVARJAPAN;
    public static final int TSDSIGN_SPEEDLIMITSOUTHKOREA;
    public static final int TSDSIGN_SPEEDLIMITVARSOUTHKOREA;
    public static final int TSDSIGN_CANCELSPEEDLIMITSOUTHKOREA;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARSOUTHKOREA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESSOUTHKOREA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARSOUTHKOREA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLESOUTHKOREA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARSOUTHKOREA;
    public static final int TSDSIGN_CANCELALLLIMITSSOUTHKOREA;
    public static final int TSDSIGN_CANCELALLLIMITSVARSOUTHKOREA;
    public static final int TSDSIGN_SPEEDLIMITAUSTRALIA;
    public static final int TSDSIGN_SPEEDLIMITVARAUSTRALIA;
    public static final int TSDSIGN_CANCELSPEEDLIMITAUSTRALIA;
    public static final int TSDSIGN_CANCELSPEEDLIMITVARAUSTRALIA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESAUSTRALIA;
    public static final int TSDSIGN_NOPASSINGALLVEHICLESVARAUSTRALIA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEAUSTRALIA;
    public static final int TSDSIGN_CANCELNOPASSINGALLVEHICLEVARAUSTRALIA;
    public static final int TSDSIGN_CANCELALLLIMITSAUSTRALIA;
    public static final int TSDSIGN_CANCELALLLIMITSVARAUSTRALIA;
    public static final int TSDSIGN_DANGER_GENERALDANGEREU;
    public static final int TSDSIGN_DANGER_UNMARKEDINTERSECTIONAHEADEU;
    public static final int TSDSIGN_DANGER_PRIORITYATNEXTINTERSECTIONEU;
    public static final int TSDSIGN_DANGER_CURVELEFTEU;
    public static final int TSDSIGN_DANGER_CURVERIGHTEU;
    public static final int TSDSIGN_DANGER_DOUBLECURVELEFTEU;
    public static final int TSDSIGN_DANGER_DOUBLECURVERIGHTEU;
    public static final int TSDSIGN_DANGER_SLIPPERYROADEU;
    public static final int TSDSIGN_DANGER_ROADNARROWSBOTHSIDES;
    public static final int TSDSIGN_DANGER_ROADNARROWSRIGHT;
    public static final int TSDSIGN_DANGER_ROADNARROWSLEFT;
    public static final int TSDSIGN_DANGER_ROADWORKEU;
    public static final int TSDSIGN_DANGER_CONGESTIONHAZARDEU;
    public static final int TSDSIGN_DANGER_PEDESTRIANSEU;
    public static final int TSDSIGN_DANGER_WATCHFORCHILDRENEU;
    public static final int TSDSIGN_DANGER_BYCICLESEU;
    public static final int TSDSIGN_DANGER_WILDANIMALCROSSINGEU;
    public static final int TSDADDSIGN_NOSIGN;
    public static final int TSDADDSIGN_EMPTYADDSIGNEU;
    public static final int TSDADDSIGN_WETEU;
    public static final int TSDADDSIGN_RAINEU;
    public static final int TSDADDSIGN_TEMPCONDEU;
    public static final int TSDADDSIGN_ONLYPASSENGERCAREU;
    public static final int TSDADDSIGN_VEHICLEWITHTRAILEREU;
    public static final int TSDADDSIGN_VEHILCESTURNRIGHT;
    public static final int TSDADDSIGN_VEHILCESTURNLEFT;
    public static final int TSDADDSIGN_OVERTAKINGTRACTORALLOWED;
    public static final int TSDADDSIGN_VARIABLESIGNEU;
    public static final int TSDADDSIGN_FOGEU;
    public static final int TSDADDSIGN_SCHOOLNAR;
    public static final int TSDADDSIGN_NIGHTNAR;
    public static final int TSDADDSIGN_WORKNAR;
    public static final int SYSTEMSTATE_SYSTEM_OFF;
    public static final int SYSTEMSTATE_SYSTEM_ON;
    public static final int WARNINGTIMEGAP_OFF;
    public static final int WARNINGTIMEGAP_LATE;
    public static final int WARNINGTIMEGAP_MEDIUM;
    public static final int WARNINGTIMEGAP_EARLY;
    public static final int RT_SETLDWWARNINGTIME;
    public static final int RT_SETLDWSTEERINGWHEELVIBRATION;
    public static final int RT_SETHCAINTERVENTIONSTYLE;
    public static final int RT_SETHCATOLERANCELEVEL;
    public static final int RT_SETLDWHCASETFACTORYDEFAULT;
    public static final int RT_SETLDWHCASYSTEMONOFF;
    public static final int RT_SETLDWHCAWARNINGSOUND;
    public static final int RT_SETSWASYSTEM;
    public static final int RT_SETSWABRIGHTNESS;
    public static final int RT_SETSWAWARNINGTIME;
    public static final int RT_SETSWAFREQUENCY;
    public static final int RT_SETSWAGONGSTATE;
    public static final int RT_SETSWAGONGVOLUME;
    public static final int RT_SETSWARCTA;
    public static final int RT_SETSWAEXITASSIST;
    public static final int RT_SETACCGONGVOLUME;
    public static final int RT_SETACCDRIVINGPROGRAM;
    public static final int RT_SETACCGONGSTATE;
    public static final int RT_SETACCDEFAULTMODE;
    public static final int RT_SETACCTIMEGAP;
    public static final int RT_SETACCCURVEASSIST;
    public static final int RT_SETACCSPEEDLIMITADOPTION;
    public static final int RT_SETACCTRAFFICJAMASSIST;
    public static final int RT_SETACCSPEEDLIMITOFFSET;
    public static final int RT_SETACCDISTANCEWARNING;
    public static final int RT_SETACCSETFACTORYDEFAULT;
    public static final int RT_SETPACCSENSIBILITY;
    public static final int RT_SETPACCMAXSPEED;
    public static final int RT_SETPACCDRIVINGPROGRAM;
    public static final int RT_SETAWVSYSTEM;
    public static final int RT_SETAWVWARNING;
    public static final int RT_SETAWVGONG;
    public static final int RT_SETAWVGONGVOLUME;
    public static final int RT_SETAWVBRAKEJERK;
    public static final int RT_SETAWVEMERGENCYBRAKE;
    public static final int RT_SETAWVDISTANCEWARNING;
    public static final int RT_SETAWVWARNINGTIMEGAP;
    public static final int RT_SETAWVSETFACTORYDEFAULT;
    public static final int RT_SETNVSOUND;
    public static final int RT_SETNVCONTRAST;
    public static final int RT_SETNVACTIVATION;
    public static final int RT_SETNVBRIGHTNESS;
    public static final int RT_SETNVOBJECTDETECTION;
    public static final int RT_SETNVCOLORPA;
    public static final int RT_SETNVDESIGNPA;
    public static final int RT_SETNVDISPLAY;
    public static final int RT_SETNVZOOMPANNING;
    public static final int RT_SETNVSYMBOL;
    public static final int RT_SETNVSETFACTORYDEFAULT;
    public static final int RT_SETNVSYSTEM;
    public static final int RT_SETNVWARNINGTIMEGAP;
    public static final int RT_SETTSDSYSTEMONOFF;
    public static final int RT_SETTSDROADSIGNFILTER;
    public static final int RT_SETTSDSETFACTORYDEFAULT;
    public static final int RT_SETTSDSPEEDWARNINGTHRESHOLD;
    public static final int RT_SETTSDTRAILERSPEEDLIMIT;
    public static final int RT_SETTSDSPEEDWARNINGACOUSTICS;
    public static final int RT_SETMKESYSTEMONOFF;
    public static final int RT_SETMKESETFACTORYDEFAULT;
    public static final int RT_SETPASYSTEMONOFF;
    public static final int RT_SETPASETFACTORYDEFAULT;
    public static final int RT_SETPACONFIGINFORMATION;
    public static final int RT_SETPACONFIGWARNING;
    public static final int RT_SETPAWARNINGTIMEGAP;
    public static final int RT_SETCURVEASSISTSYSTEMONOFF;
    public static final int RT_SETCURVEASSISTSETFACTORYDEFAULT;
    public static final int RT_SETFTASYSTEMONOFF;
    public static final int RP_ACKNOWLEDGELDWHCASETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGETSDSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEACCSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEMKESETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEPASETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGECURVEASSISTSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEAWVSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGENVSETFACTORYDEFAULT;

    default public void setACCGongState(boolean bl) {
    }

    default public void setACCGongVolume(int n) {
    }

    default public void setACCDrivingProgram(int n) {
    }

    default public void setACCTimeGap(int n) {
    }

    default public void setACCDefaultMode(int n) {
    }

    default public void setACCCurveAssist(boolean bl) {
    }

    default public void setACCSpeedLimitAdoption(boolean bl) {
    }

    default public void setACCTrafficJamAssist(boolean bl) {
    }

    default public void setACCSpeedLimitOffset(int n) {
    }

    default public void setACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning) {
    }

    default public void setACCSetFactoryDefault() {
    }

    default public void setPACCSensibility(boolean bl) {
    }

    default public void setPACCMaxSpeed(int n, int n2) {
    }

    default public void setPACCDrivingProgram(int n) {
    }

    default public void setAWVSystem(int n) {
    }

    default public void setAWVWarning(boolean bl) {
    }

    default public void setAWVGong(boolean bl) {
    }

    default public void setAWVGongVolume(int n) {
    }

    default public void setAWVBrakeJerk(boolean bl) {
    }

    default public void setAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake) {
    }

    default public void setAWVDistanceWarning(boolean bl) {
    }

    default public void setAWVWarningTimegap(int n) {
    }

    default public void setAWVSetFactoryDefault() {
    }

    default public void setSWABrightness(int n) {
    }

    default public void setSWAWarningTime(int n) {
    }

    default public void setSWAFrequency(int n) {
    }

    default public void setSWASystem(int n) {
    }

    default public void setSWAGongState(boolean bl) {
    }

    default public void setSWAGongVolume(int n) {
    }

    default public void setSWARCTA(boolean bl) {
    }

    default public void setSWAExitAssist(boolean bl) {
    }

    default public void setNVActivation(boolean bl) {
    }

    default public void setNVContrast(int n) {
    }

    default public void setNVBrightness(int n) {
    }

    default public void setNVObjectDetection(NVObjectDetection nVObjectDetection) {
    }

    default public void setNVColorPA(int n) {
    }

    default public void setNVDesignPA(int n) {
    }

    default public void setNVDisplay(int n) {
    }

    default public void setNVZoomPanning(int n) {
    }

    default public void setNVSound(int n) {
    }

    default public void setNVSymbol(boolean bl) {
    }

    default public void setNVSetFactoryDefault() {
    }

    default public void setNVWarningTimegap(int n) {
    }

    default public void setNVSystem(boolean bl) {
    }

    default public void setLDWWarningTime(int n) {
    }

    default public void setLDWSteeringWheelVibration(int n) {
    }

    default public void setHCAInterventionStyle(int n) {
    }

    default public void setHCAToleranceLevel(int n) {
    }

    default public void setLdwhcaSetFactoryDefault() {
    }

    default public void setLDWHCASystemOnOff(boolean bl) {
    }

    default public void setLDWHCAWarningSound(boolean bl, int n) {
    }

    default public void setTSDSystemOnOff(boolean bl) {
    }

    default public void setTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter) {
    }

    default public void setTsdSetFactoryDefault() {
    }

    default public void setTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed) {
    }

    default public void setTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed) {
    }

    default public void setTSDSpeedWarningAcoustics(boolean bl) {
    }

    default public void setMKESystemOnOff(boolean bl) {
    }

    default public void setMKESetFactoryDefault() {
    }

    default public void setPASystemOnOff(boolean bl) {
    }

    default public void setPASetFactoryDefault() {
    }

    default public void setPAConfigInformation(boolean bl) {
    }

    default public void setPAConfigWarning(boolean bl) {
    }

    default public void setPAWarningTimegap(int n) {
    }

    default public void setCurveAssistSystemOnOff(boolean bl) {
    }

    default public void setCurveAssistSetFactoryDefault() {
    }

    default public void setFTASystemOnOff(boolean bl) {
    }
}

