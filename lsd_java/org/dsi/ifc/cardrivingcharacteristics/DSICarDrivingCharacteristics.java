/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

public interface DSICarDrivingCharacteristics
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SUSPENSIONCONTROLVIEWOPTIONS;
    public static final int ATTR_SUSPENSIONCONTROLLIFTMODE;
    public static final int ATTR_SUSPENSIONCONTROLCARJACKMODE;
    public static final int ATTR_SUSPENSIONCONTROLTRAILERMODE;
    public static final int ATTR_SUSPENSIONCONTROLLOADINGMODE;
    public static final int ATTR_SUSPENSIONCONTROLACTIVEPROFILE;
    public static final int ATTR_SUSPENSIONCONTROLACCESSIBLEAIRPROFILES;
    public static final int ATTR_SUSPENSIONCONTROLACCESSIBLEDRCPROFILES;
    public static final int ATTR_SUSPENSIONCONTROLVEHICLESTATUS;
    public static final int ATTR_SUSPENSIONCONTROLACTIVEMODE;
    public static final int ATTR_EABCEASYENTRY;
    public static final int ATTR_EABCPITCHCONTROL;
    public static final int ATTR_EABCSPECIALPOSITION;
    public static final int ATTR_EABCPREVIEW;
    public static final int ATTR_EABCPREVIEWSTATE;
    public static final int ATTR_SUSPENSIONCONTROLACTUATORINFO;
    public static final int ATTR_CHARISMAVIEWOPTIONS;
    public static final int ATTR_CHARISMAACTIVEPROFILE;
    public static final int ATTR_CHARISMALISTUPDATEINFO;
    public static final int ATTR_CHARISMACONTENT;
    public static final int ATTR_CHARISMATRAILERDETECTION;
    public static final int ATTR_CHARISMATRAILERSETTING;
    public static final int ATTR_CHARISMAPROGBUTTON;
    public static final int ATTR_CHARISMASOUND;
    public static final int ATTR_TADVIEWOPTIONS;
    public static final int ATTR_TADCONTENT;
    public static final int ATTR_TADVEHICLEINFO;
    public static final int ATTR_TADCURRENTROLLANGLE;
    public static final int ATTR_TADCURRENTPITCHANGLE;
    public static final int ATTR_TADPOSMAXROLLANGLE;
    public static final int ATTR_TADNEGMAXROLLANGLE;
    public static final int ATTR_TADPOSMAXPITCHANGLE;
    public static final int ATTR_TADNEGMAXPITCHANGLE;
    public static final int ATTR_CHARISMAACTIVEOPERATIONMODE;
    public static final int ATTR_SUSPENSIONCONTROLCURRENTLEVEL;
    public static final int ATTR_SUSPENSIONCONTROLTARGETLEVEL;
    public static final int ATTR_SUSPENSIONCONTROLHEIGHTINFO;
    public static final int ATTR_SUSPENSIONCONTROLOPERATIONMESSAGES;
    public static final int ATTR_SPOILERVIEWOPTIONS;
    public static final int ATTR_SPOILERPOSITIONSELECTION;
    public static final int ATTR_SPOILERSTATE;
    public static final int ATTR_SPOILERACTUATION;
    public static final int ATTR_SPOILERMESSAGES;
    public static final int ATTR_SPOILERSYSTEMONOFF;
    public static final int ATTR_SUSPENSIONCONTROLSNOWCHAINMODE;
    public static final int ATTR_SUSPENSIONCONTROLVEHICLESTATECONTROL;
    public static final int ATTR_SOUNDVIEWOPTIONS;
    public static final int ATTR_SOUNDSYSTEMONOFF;
    public static final int ATTR_SOUNDONOFF;
    public static final int ATTR_SOUNDSTYLE;
    public static final int RT_SETSUSPENSIONCONTROLLIFTMODE;
    public static final int RT_SETSUSPENSIONCONTROLCARJACKMODE;
    public static final int RT_SETSUSPENSIONCONTROLTRAILERMODE;
    public static final int RT_SETSUSPENSIONCONTROLLOADINGMODE;
    public static final int RT_SETSUSPENSIONCONTROLACTIVEPROFILE;
    public static final int RT_SETSUSPENSIONCONTROLACTIVEMODE;
    public static final int RT_SETEABCEASYENTRY;
    public static final int RT_SETEABCPITCHCONTROL;
    public static final int RT_SETEABCSPECIALPOSITION;
    public static final int RT_SETEABCPREVIEW;
    public static final int RT_SETCHARISMAACTIVEPROFILE;
    public static final int RT_REQUESTCHARISMAPROFILEFUNCTION;
    public static final int RT_REQUESTCHARISMALIST;
    public static final int RT_SHOWCHARISMAPOPUP;
    public static final int RT_CANCELCHARISMAPOPUP;
    public static final int RT_SETCHARISMATRAILERSETTING;
    public static final int RT_SETCHARISMAPROGBUTTON;
    public static final int RT_SETCHARISMASETFACTORYDEFAULT;
    public static final int RT_SETCHARISMASOUND;
    public static final int RT_SHOWTADPOPUP;
    public static final int RT_CANCELTADPOPUP;
    public static final int RT_SETTADSETFACTORYDEFAULT;
    public static final int RT_SETTADMAXMINANGLERESET;
    public static final int RT_SETCHARISMAACTIVEOPERATIONMODE;
    public static final int RT_SETHMIISREADY;
    public static final int RT_SETSPOILERSETFACTORYDEFAULT;
    public static final int RT_SETSPOILERPOSITIONSELECTION;
    public static final int RT_SETSPOILERACTUATION;
    public static final int RT_SETSPOILERSYSTEMONOFF;
    public static final int RT_SETSUSPENSIONCONTROLSNOWCHAINMODE;
    public static final int RT_SETSOUNDSETFACTORYDEFAULT;
    public static final int RT_SETSOUNDSYSTEMONOFF;
    public static final int RT_SETSOUNDONOFF;
    public static final int RT_SETSOUNDSTYLE;
    public static final int RP_ACKNOWLEDGECHARISMAPOPUP;
    public static final int RP_ACKNOWLEDGECHARISMASETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGETADMAXMINANGLERESET;
    public static final int RP_ACKNOWLEDGETADPOPUP;
    public static final int RP_ACKNOWLEDGETADSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGESPOILERSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGESOUNDSETFACTORYDEFAULT;
    public static final int IN_REQUESTCHARISMAPOPUP;
    public static final int IN_RESPONSECHARISMALISTWITHOPTIONMASK;
    public static final int IN_RESPONSECHARISMALISTWITHOUTOPTIONMASK;
    public static final int IN_REQUESTTADPOPUP;
    public static final int SUSPENSIONDEVICETYPE_AIRSUSPENSION;
    public static final int SUSPENSIONDEVICETYPE_DRC;
    public static final int SUSPENSIONDEVICETYPE_EABC;
    public static final int SUSPENSIONMODELTYPE_NORMAL;
    public static final int SUSPENSIONMODELTYPE_SPORT;
    public static final int SUSPENSIONMODELTYPE_SUV;
    public static final int SUSPENSIONMODELTYPE_ALLROAD;
    public static final int SUSPENSIONMODELTYPE_SPORT2;
    public static final int SUSPENSIONMODELTYPE_SPORT3;
    public static final int SUSPENSIONMODELTYPE_SHIELDED;
    public static final int SUSPENSIONEABCOBSTACLELEVEL_NOOBSTACLE;
    public static final int SUSPENSIONEABCOBSTACLELEVEL_LEVEL1;
    public static final int SUSPENSIONEABCOBSTACLELEVEL_LEVEL2;
    public static final int SUSPENSIONEABCOBSTACLELEVEL_LEVEL3;
    public static final int SUSPENSIONEABCOBSTACLELEVEL_INIT;
    public static final int SUSPENSIONEABCOBSTACLELEVEL_ERROR;
    public static final int SUSPENSIONEABCPREVIEWLEVEL_INACTIVE;
    public static final int SUSPENSIONEABCPREVIEWLEVEL_LEVEL1;
    public static final int SUSPENSIONEABCPREVIEWLEVEL_LEVEL2;
    public static final int SUSPENSIONCONTROLPROFILE_NOPROFILE;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE01;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE02;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE03;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE04;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE05;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE06;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE07;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE08;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE09;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE10;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE11;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE12;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE13;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE14;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE15;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE16;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE17;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE18;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE19;
    public static final int SUSPENSIONCONTROLPROFILE_PROFILE20;
    public static final int SUSPENSIONCONTROLMODE_MODE0;
    public static final int SUSPENSIONCONTROLMODE_MODE1;
    public static final int SUSPENSIONCONTROLMODE_MODE2;
    public static final int SUSPENSIONCONTROLMODE_MODE3;
    public static final int SUSPENSIONCONTROLMODE_MODE4;
    public static final int SUSPENSIONCONTROLMODE_MODE5;
    public static final int SUSPENSIONCONTROLMODE_MODE6;
    public static final int SUSPENSIONCONTROLMODE_MODE7;
    public static final int SUSPENSIONCONTROLMODE_MODE8;
    public static final int SUSPENSIONCONTROLMODE_MODE9;
    public static final int SUSPENSIONCONTROLMODE_MODE10;
    public static final int SUSPENSIONCONTROLMODE_MODE11;
    public static final int SUSPENSIONCONTROLMODE_MODE12;
    public static final int SUSPENSIONCONTROLMODE_MODE13;
    public static final int SUSPENSIONCONTROLMODE_MODE14;
    public static final int SUSPENSIONCONTROLMODE_MODE15;
    public static final int SUSPENSIONCONTROLVEHICLESTATUS_INACTIVE;
    public static final int SUSPENSIONCONTROLVEHICLESTATUS_SINK_VEHICLE;
    public static final int SUSPENSIONCONTROLVEHICLESTATUS_LIFT_VEHICLE;
    public static final int SUSPENSIONCONTROLVEHICLESTATUS_HOLD_LEVEL;
    public static final int SUSPENSIONCONTROLLEVEL_NOLEVEL;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL1;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL2;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL3;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL4;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL5;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL6;
    public static final int SUSPENSIONCONTROLLEVEL_LEVEL7;
    public static final int SUSPENSIONCONTROLFAILUREREASON_NONEGCONFIRMATION;
    public static final int SUSPENSIONCONTROLFAILUREREASON_VELOCITYTOOHIGH;
    public static final int SUSPENSIONCONTROLFAILUREREASON_SYSTEMNOTAVAILABLE;
    public static final int SUSPENSIONCONTROLFAILUREREASON_ADJUSTMENTNOTPOSSIBLE;
    public static final int SUSPENSIONCONTROLFAILUREREASON_ADJUSTMENTNOTALLOWED;
    public static final int SUSPENSIONCONTROLFAILUREREASON_REARAXLEADJUSTMENTNOTALLOWED;
    public static final int SUSPENSIONCONTROLFAILUREREASON_INCORRECT_RIDE_HEIGHT;
    public static final int SUSPENSIONCONTROLFAILUREREASON_INCORRECT_DRIVESELECT_MODE;
    public static final int SUSPENSIONCONTROLFAILUREREASON_VELOCITY_TO_HIGH;
    public static final int SUSPENSIONCONTROLCONFIRMATION_NOCONFIRMATION;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION1;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION2;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION3;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION4;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION5;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION6;
    public static final int SUSPENSIONCONTROLCONFIRMATION_CONFIRMATION7;
    public static final int SUSPENSIONCONTROLATTAINMENT_NOATTAINMENT;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION1;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION2;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION3;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION4;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION5;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION6;
    public static final int SUSPENSIONCONTROLATTAINMENT_SELECTION7;
    public static final int SUSPENSIONCONTROLREGULATION_NOREGULATION;
    public static final int SUSPENSIONCONTROLREGULATION_ACTIVE;
    public static final int SUSPENSIONCONTROLREGULATION_INACTIVE;
    public static final int CHARISMAPROFILES_COMFORT;
    public static final int CHARISMAPROFILES_AUTO_NORMAL;
    public static final int CHARISMAPROFILES_DYNAMIC;
    public static final int CHARISMAPROFILES_OFFROAD_ALLROAD;
    public static final int CHARISMAPROFILES_EFFICIENCY;
    public static final int CHARISMAPROFILES_SPORT_RACE;
    public static final int CHARISMAPROFILES_INDIVIDUAL;
    public static final int CHARISMAPROFILES_RANGE;
    public static final int CHARISMAPROFILES_LIFT;
    public static final int CHARISMAPROFILES_OFFROADLEVEL2;
    public static final int CHARISMAPROFILES_OFFROADLEVEL3;
    public static final int CHARISMAPROFILES_OFFROADLEVEL4;
    public static final int CHARISMAPROFILES_NOPROFILE_INIT;
    public static final int CHARISMAFUNCTIONS_ENGINEPOWER;
    public static final int CHARISMAFUNCTIONS_ENGINESTARTSTOP;
    public static final int CHARISMAFUNCTIONS_GEARBOXDRIVINGPOSITION;
    public static final int CHARISMAFUNCTIONS_REARAXLEDIFFERENTIAL;
    public static final int CHARISMAFUNCTIONS_POWERSTEERINGASSIST;
    public static final int CHARISMAFUNCTIONS_SUPERPOSITIONSTEERING;
    public static final int CHARISMAFUNCTIONS_DAMPER;
    public static final int CHARISMAFUNCTIONS_CLIMATECONTROL;
    public static final int CHARISMAFUNCTIONS_ADAPTIVECRUISECONTROL;
    public static final int CHARISMAFUNCTIONS_SOUNDACTUATOR;
    public static final int CHARISMAFUNCTIONS_STEERABLEBEAM;
    public static final int CHARISMAFUNCTIONS_INTERIORLIGHT;
    public static final int CHARISMAFUNCTIONS_AIRSUSPENSION;
    public static final int CHARISMAFUNCTIONS_PRETENSIONER;
    public static final int CHARISMAFUNCTIONS_SEATSIDEBOLSTERADJUSTMENT;
    public static final int CHARISMAFUNCTIONS_NAVIGATION1;
    public static final int CHARISMAFUNCTIONS_NAVIGATION2;
    public static final int CHARISMAFUNCTIONS_FREEROLLING;
    public static final int CHARISMAFUNCTIONS_ECOLIVETIPS;
    public static final int CHARISMAFUNCTIONS_ACTIVEEXHAUSTSYSTEMSOUNDCONTROL;
    public static final int CHARISMAFUNCTIONS_FRONTAXLEDIFFERENTIAL;
    public static final int CHARISMAFUNCTIONS_CENTREDIFFERENTIAL;
    public static final int CHARISMAFUNCTIONS_CENTREANDREARAXLEDIFFERENTIAL;
    public static final int CHARISMAFUNCTIONS_ELECTRICTORQUEVECTORING;
    public static final int CHARISMAFUNCTIONS_ANTISLIPCONTROL;
    public static final int CHARISMAFUNCTIONS_MATRIXBEAM;
    public static final int CHARISMAFUNCTIONS_REARSPOILER;
    public static final int CHARISMAFUNCTIONS_BRAKECONTROLSYSTEM;
    public static final int CHARISMAFUNCTIONS_REARAXLESTEERINGSYSTEM;
    public static final int CHARISMAFUNCTIONS_ACTIVEANTIROLLBAR;
    public static final int CHARISMAFUNCTIONS_CURVEASSIST;
    public static final int CHARISMAFUNCTIONS_HYBRIDCOMPONENTS;
    public static final int CHARISMAFUNCTIONS_DRIVETRAIN;
    public static final int CHARISMAFUNCTIONS_CHASSIS;
    public static final int CHARISMAFUNCTIONS_EXHAUSTFLAP;
    public static final int CHARISMAFUNCTIONS_SOUNDCOMPONENTS;
    public static final int CHARISMAFUNCTIONS_PASSENGERCABIN;
    public static final int CHARISMAFUNCTIONS_DRIVESEAT;
    public static final int CHARISMAFUNCTIONS_TIREPRESSUREMONITORING;
    public static final int CHARISMAFUNCTIONS_LANEASSIST;
    public static final int CHARISMAFUNCTIONS_DYNENGINEMOUNT;
    public static final int CHARISMAFUNCTIONS_MAGNETICRIDE;
    public static final int CHARISMAFUNCTIONS_SWITCHABLEDAMPER;
    public static final int CHARISMAFUNCTIONS_HILLSTEPDOWNASSIST;
    public static final int CHARISMAFUNCTIONS_DRIVERASSIST_1;
    public static final int CHARISMAFUNCTIONS_DRIVERASSIST_2;
    public static final int CHARISMAFUNCTIONS_DISPLAYSETUP_1;
    public static final int CHARISMAFUNCTIONS_DISPLAYSETUP_2;
    public static final int CHARISMAFUNCTIONS_ENERGODISPLAYSETUP;
    public static final int CHARISMAFUNCTIONS_ENERGO_ACC;
    public static final int CHARISMAFUNCTIONS_ESOUND;
    public static final int CHARISMAFUNCTIONS_EABC;
    public static final int CHARISMAFUNCTIONS_DRIVEMODE;
    public static final int CHARISMAFUNCTIONS_EBKV;
    public static final int CHARISMAFUNCTIONS_DRIVEMODE2;
    public static final int CHARISMAFUNCTIONS_DRIVEMODE3;
    public static final int CHARISMAFUNCTIONS_NONE;
    public static final int CHARISMASETTINGS_STEP1;
    public static final int CHARISMASETTINGS_STEP2;
    public static final int CHARISMASETTINGS_STEP3;
    public static final int CHARISMASETTINGS_STEP4;
    public static final int CHARISMASETTINGS_STEP5;
    public static final int CHARISMASETTINGS_STEP6;
    public static final int CHARISMASETTINGS_STEP7;
    public static final int CHARISMASETTINGS_STEP8;
    public static final int CHARISMASETTINGS_STEP9;
    public static final int CHARISMASETTINGS_STEP10;
    public static final int CHARISMASETTINGS_STEP11;
    public static final int CHARISMASETTINGS_STEP12;
    public static final int CHARISMASETTINGS_STEP13;
    public static final int CHARISMASETTINGS_STEP14;
    public static final int CHARISMASETTINGS_STEP15;
    public static final int CHARISMASETTINGS_STEP16;
    public static final int CHARISMAMASK_STEP1;
    public static final int CHARISMAMASK_STEP2;
    public static final int CHARISMAMASK_STEP3;
    public static final int CHARISMAMASK_STEP4;
    public static final int CHARISMAMASK_STEP5;
    public static final int CHARISMAMASK_STEP6;
    public static final int CHARISMAMASK_STEP7;
    public static final int CHARISMAMASK_STEP8;
    public static final int CHARISMAMASK_STEP9;
    public static final int CHARISMAMASK_STEP10;
    public static final int CHARISMAMASK_STEP11;
    public static final int CHARISMAMASK_STEP12;
    public static final int CHARISMAMASK_STEP13;
    public static final int CHARISMAMASK_STEP14;
    public static final int CHARISMAMASK_STEP15;
    public static final int CHARISMAMASK_STEP16;
    public static final int CHARISMAARRAYCONTENT_NONE;
    public static final int CHARISMAARRAYCONTENT_ALL;
    public static final int CHARISMAARRAYCONTENT_ONLY_CHANGES;
    public static final int CHARISMARECORDCONTENT_NONE;
    public static final int CHARISMARECORDCONTENT_WITHOPTIONMASK;
    public static final int CHARISMARECORDCONTENT_WITHOUTOPTIONMASK;
    public static final int CHARISMACONTENT_NONE;
    public static final int CHARISMACONTENT_PROFILEDCC;
    public static final int CHARISMACONTENT_PROFILE;
    public static final int CHARISMACONTENT_DCC;
    public static final int CHARISMACONTENT_AIRSUSPENSION;
    public static final int CHARISMACONTENT_HYBRID;
    public static final int CHARISMACONTENT_OFFROAD;
    public static final int CHARISMASYSTEMTYPE_FPA;
    public static final int CHARISMASYSTEMTYPE_FREEWHEEL;
    public static final int CHARISMASYSTEMTYPE_DCC;
    public static final int CHARISMAOPERATIONMODE_EVMODE;
    public static final int CHARISMAOPERATIONMODE_HYBRIDMODE;
    public static final int CHARISMAOPERATIONMODE_SUSTAININGMODE;
    public static final int CHARISMAOPERATIONMODE_CHARGINGMODE;
    public static final int CHARISMAOPERATIONMODE_SOCCONTROLMODE;
    public static final int CHARISMAOPERATIONMODE_HYBRIDSPORTMODE;
    public static final int CHARISMAOPERATIONMODE_NOMODE_INIT;
    public static final int TADCONTENT_NONE;
    public static final int TADCONTENT_ROLLPITCHANGLE;
    public static final int SPOILERPOSITION_POSITION0;
    public static final int SPOILERPOSITION_POSITION1;
    public static final int SPOILERPOSITION_POSITION2;
    public static final int SPOILERPOSITION_POSITION3;
    public static final int SPOILERPOSITION_POSITION4;
    public static final int SPOILERPOSITION_POSITION5;
    public static final int SPOILERSTATE_SPOILERRETRACTED;
    public static final int SPOILERSTATE_SPOILEREXTENDED;
    public static final int SPOILERSTATE_ERRORDIAGNOSTIC;
    public static final int SPOILERSTATE_SPOILERMOVING;
    public static final int SPOILERMESSAGES_NOMESSAGE;
    public static final int SPOILERMESSAGES_SPOILEREXTENDING;
    public static final int SPOILERMESSAGES_SPOILEREXTENDINGHOLDBUTTON;
    public static final int SPOILERMESSAGES_SPOIERRETRACTING;
    public static final int SPOILERMESSAGES_SPOILERRETRACTINGHOLDBUTTON;
    public static final int SPOILERMESSAGES_SPOILEREXTENDED;
    public static final int SPOILERMESSAGES_SPOILERRETRACTED;
    public static final int SPOILERMESSAGES_EXTENDINGSPOILERNOTPOSSIBLE;
    public static final int SPOILERMESSAGES_RETRACTINGSPOILERNOTPOSSIBLE;
    public static final int SPOILERMESSAGES_SPOILERNOTAVAILABLE;
    public static final int SPOILERMESSAGES_THERMALPROTECTION;
    public static final int SPOILERMESSAGES_PROTECTIONAGAINSTMISUSE;
    public static final int SPOILERMESSAGES_INTERMEDIATEPOSITION;
    public static final int SOUNDSTYLE_STYLE1;
    public static final int SOUNDSTYLE_STYLE2;
    public static final int SOUNDSTYLE_STYLE3;
    public static final int SOUNDSTYLE_STYLE4;
    public static final int SOUNDSTYLE_STYLE5;
    public static final int SOUNDSTYLE_STYLE6;
    public static final int SOUNDSTYLE_STYLE7;
    public static final int SOUNDSTYLE_STYLE8;

    default public void setSuspensionControlLiftMode(boolean bl) {
    }

    default public void setSuspensionControlCarJackMode(boolean bl) {
    }

    default public void setSuspensionControlTrailerMode(boolean bl) {
    }

    default public void setSuspensionControlLoadingMode(boolean bl) {
    }

    default public void setSuspensionControlActiveProfile(int n) {
    }

    default public void setSuspensionControlSnowChainMode(boolean bl) {
    }

    default public void setSuspensionControlActiveMode(int n) {
    }

    default public void seteABCEasyEntry(boolean bl) {
    }

    default public void seteABCPitchControl(boolean bl) {
    }

    default public void seteABCSpecialPosition(boolean bl) {
    }

    default public void seteABCPreview(int n) {
    }

    default public void setCharismaActiveProfile(int n) {
    }

    default public void setCharismaActiveOperationMode(int n) {
    }

    default public void setCharismaTrailerSetting(boolean bl) {
    }

    default public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
    }

    default public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    default public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
    }

    default public void showCharismaPopup(int n, int n2) {
    }

    default public void cancelCharismaPopup(int n, int n2) {
    }

    default public void setCharismaSetFactoryDefault() {
    }

    default public void setCharismaSound(boolean bl) {
    }

    default public void showTADPopup(int n, int n2) {
    }

    default public void cancelTADPopup(int n, int n2) {
    }

    default public void setTADSetFactoryDefault() {
    }

    default public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
    }

    default public void setHMIIsReady(boolean bl) {
    }

    default public void setSpoilerSetFactoryDefault() {
    }

    default public void setSpoilerPositionSelection(int n) {
    }

    default public void setSpoilerActuation(boolean bl) {
    }

    default public void setSpoilerSystemOnOff(boolean bl) {
    }

    default public void setSoundSetFactoryDefault() {
    }

    default public void setSoundStyle(int n) {
    }

    default public void setSoundSystemOnOff(boolean bl) {
    }

    default public void setSoundOnOff(boolean bl) {
    }
}

