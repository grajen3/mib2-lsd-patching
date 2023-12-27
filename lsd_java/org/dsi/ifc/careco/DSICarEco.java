/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public interface DSICarEco
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_BCMEVIEWOPTIONS;
    public static final int ATTR_BCMELISTUPDATEINFO;
    public static final int ATTR_BCMECONSUMPTION;
    public static final int ATTR_BCMELIVETIP;
    public static final int ATTR_BCMECONSUMERLISTCONSUMPTIONUPDATEINFO;
    public static final int ATTR_BCMEENERGYFLOWCOMFORT;
    public static final int ATTR_BCMERANGEGAINTOTAL;
    public static final int ATTR_BCMECONSUMERLISTRANGEUPDATEINFO;
    public static final int ATTR_BCMECURRENTRANGE;
    public static final int ATTR_BCMECONSUMERLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_BCMECONSUMERLISTCONSUMPTIONTOTALNUMBEROFELEMENTS;
    public static final int ATTR_BCMECONSUMERLISTRANGETOTALNUMBEROFELEMENTS;
    public static final int ATTR_STARTSTOPPROHIBITREASONLISTUPDATEINFO;
    public static final int ATTR_STARTSTOPRESTARTREASONLISTUPDATEINFO;
    public static final int ATTR_STARTSTOPRESTARTPROHIBITREASONLISTUPDATEINFO;
    public static final int ATTR_STARTSTOPSTATE;
    public static final int ATTR_STARTSTOPPROHIBITREASONLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_STARTSTOPRESTARTREASONLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_STARTSTOPRESTARTPROHIBITREASONLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_STARTSTOPVIEWOPTIONS;
    public static final int ATTR_STARTSTOPCOLLECTEDREASONS;
    public static final int ATTR_RDVIEWOPTIONS;
    public static final int ATTR_RDCONSUMPTIONMOTORWAY1;
    public static final int ATTR_RDCONSUMPTIONMOTORWAY2;
    public static final int ATTR_RDCONSUMPTIONHIGHWAY1;
    public static final int ATTR_RDCONSUMPTIONHIGHWAY2;
    public static final int ATTR_RDCONSUMPTIONCOUNTRYROAD1;
    public static final int ATTR_RDCONSUMPTIONCOUNTRYROAD2;
    public static final int ATTR_RDCONSUMPTIONDISTRICTROAD1;
    public static final int ATTR_RDCONSUMPTIONDISTRICTROAD2;
    public static final int ATTR_RDCONSUMPTIONLOCALROAD1;
    public static final int ATTR_RDCONSUMPTIONLOCALROAD2;
    public static final int ATTR_RDCONSUMPTIONRURALROAD1;
    public static final int ATTR_RDCONSUMPTIONRURALROAD2;
    public static final int ATTR_RDCONSUMPTIONUNCLASSIFIEDROAD1;
    public static final int ATTR_RDCONSUMPTIONUNCLASSIFIEDROAD2;
    public static final int ATTR_RDMAXRANGE1;
    public static final int ATTR_RDMAXRANGE2;
    public static final int ATTR_RDRESIDUALENERGY1;
    public static final int ATTR_RDRESIDUALENERGY2;
    public static final int ATTR_EAVIEWOPTIONS;
    public static final int ATTR_EASYSTEM;
    public static final int ATTR_EAPEDALJERK;
    public static final int ATTR_EAFREEWHEELING;
    public static final int ATTR_EASTARTSTOP;
    public static final int ATTR_BCMECURRENTRANGESOC;
    public static final int ATTR_BCMECATALOGUERANGE;
    public static final int RT_REQUESTBCMECONSUMERLIST;
    public static final int RT_SETBCMELIVETIP;
    public static final int RT_SETBCMESETFACTORYDEFAULT;
    public static final int RT_REQUESTSTARTSTOPPROHIBITLIST;
    public static final int RT_REQUESTSTARTSTOPRESTARTLIST;
    public static final int RT_REQUESTSTARTSTOPRESTARTPROHIBITLIST;
    public static final int RT_SETRDSETFACTORYDEFAULT;
    public static final int RT_REQUESTBCMECONSUMERLISTCONSUMPTION;
    public static final int RT_REQUESTBCMECONSUMERLISTRANGE;
    public static final int RT_SETEASYSTEM;
    public static final int RT_SETEAPEDALJERK;
    public static final int RT_SETEASETFACTORYDEFAULT;
    public static final int RT_SETEAFREEWHEELING;
    public static final int RT_SETEASTARTSTOP;
    public static final int IN_RESPONSEBCMECONSUMERLIST;
    public static final int RP_ACKNOWLEDGEBCMESETFACTORYDEFAULT;
    public static final int RP_RESPONSESTARTSTOPPROHIBITREASONLIST;
    public static final int RP_RESPONSESTARTSTOPRESTARTREASONLIST;
    public static final int RP_RESPONSESTARTSTOPRESTARTPROHIBITREASONLIST;
    public static final int RP_ACKNOWLEDGERDSETFACTORYDEFAULT;
    public static final int IN_RESPONSEBCMECONSUMERLISTCONSUMPTIONRA0;
    public static final int IN_RESPONSEBCMECONSUMERLISTCONSUMPTIONRA1;
    public static final int IN_RESPONSEBCMECONSUMERLISTCONSUMPTIONRAF;
    public static final int IN_RESPONSEBCMECONSUMERLISTRANGERA0;
    public static final int IN_RESPONSEBCMECONSUMERLISTRANGERA1;
    public static final int IN_RESPONSEBCMECONSUMERLISTRANGERA2;
    public static final int IN_RESPONSEBCMECONSUMERLISTRANGERAF;
    public static final int RP_ACKNOWLEDGEEASETFACTORYDEFAULT;
    public static final int BCMELIVETIP_NONE;
    public static final int BCMELIVETIP_CLOSEWINDOW;
    public static final int BCMELIVETIP_CLOSEROOF;
    public static final int BCMELIVETIP_CLOSEWINDOWROOF;
    public static final int BCMELIVETIP_ENGINEBRAKE;
    public static final int BCMELIVETIP_ENGINESTART;
    public static final int BCMELIVETIP_SHIFTGEAR;
    public static final int BCMELIVETIP_STARTSTOPREADY;
    public static final int BCMELIVETIP_STARTSTOPDEACTIVE;
    public static final int BCMELIVETIP_ACWINDOW;
    public static final int BCMELIVETIP_ACROOF;
    public static final int BCMELIVETIP_ACWINDOWROOF;
    public static final int BCMELIVETIP_POSD;
    public static final int BCMELIVETIP_THROTTLESTANDING;
    public static final int BCMELIVETIP_ACCONVERTIBLE;
    public static final int BCMELIVETIP_WARMUPSTANDING;
    public static final int BCMECONSUMERS_CLIMATECONTROLUNIT;
    public static final int BCMECONSUMERS_AUXHEATER;
    public static final int BCMECONSUMERS_REARWINDOWHEATER;
    public static final int BCMECONSUMERS_SEATHEATINGFRONTLEFT;
    public static final int BCMECONSUMERS_SEATHEATINGFRONTRIGHT;
    public static final int BCMECONSUMERS_SEATVENTILATIONFRONLEFT;
    public static final int BCMECONSUMERS_SSEATVENTILATIONFRONRIGHT;
    public static final int BCMECONSUMERS_NECKHEATINGLEFT;
    public static final int BCMECONSUMERS_NECKHEATINGRIGHT;
    public static final int BCMECONSUMERS_FOGLIGHTFRONT;
    public static final int BCMECONSUMERS_FOGLIGHTREAR;
    public static final int BCMECONSUMERS_FRONTWINDOWHEATING;
    public static final int BCMECONSUMERS_STEERINGWHEELHEATING;
    public static final int BCMECONSUMERS_MIRRORHEATING;
    public static final int BCMECONSUMERS_SEATHEATINGREAR;
    public static final int BCMECONSUMERS_SEATVENTILATIONREAR;
    public static final int BCMECONSUMERS_220VPLUGIN;
    public static final int BCMECONSUMERS_THERMOCUPHOLDER;
    public static final int BCMEARRAYCONTENT_INIT;
    public static final int BCMEARRAYCONTENT_ALL;
    public static final int BCMEARRAYCONTENT_ALL_FORWARD;
    public static final int BCMEARRAYCONTENT_ALL_BACKWARD;
    public static final int BCMEARRAYCONTENT_ONLY_CHANGES;
    public static final int BCMEARRAYCONTENT_ELEMENTS_REMOVED;
    public static final int BCMEARRAYCONTENT_BLOCK_INSERTED;
    public static final int BCMEARRAYCONTENT_BACKWARD;
    public static final int BCMERECORDCONTENT_RA0;
    public static final int BCMERECORDCONTENT_RA1;
    public static final int BCMERECORDCONTENT_RA2;
    public static final int BCMERECORDCONTENT_RAF;
    public static final int BCMERANGEUNIT_KM;
    public static final int BCMERANGEUNIT_MLS;
    public static final int BCMERANGEUNIT_PERCENT;
    public static final int BCMEENGINETYPE_NOT_INSTALLED;
    public static final int BCMEENGINETYPE_PETROL;
    public static final int BCMEENGINETYPE_GAS;
    public static final int BCMEENGINETYPE_ELECTRIC;
    public static final int BCMEENGINETYPE_UNKNOWN;
    public static final int BCMEDISPLAYSTYLE_NOSTYLE;
    public static final int BCMEDISPLAYSTYLE_STYLE1;
    public static final int BCMEDISPLAYSTYLE_STYLE2;
    public static final int BCMEDISPLAYSTYLE_STYLE3;
    public static final int BCMEDISPLAYSTYLE_STYLE4;
    public static final int STARTSTOPREASON_TRAILER;
    public static final int STARTSTOPREASON_FOGGING;
    public static final int STARTSTOPREASON_OPERATING_TEMP;
    public static final int STARTSTOPREASON_DRIVER_ABSENT;
    public static final int STARTSTOPREASON_KEYLESS_ENTRY;
    public static final int STARTSTOPREASON_POWER_CONSUMPTION;
    public static final int STARTSTOPREASON_CLIMATE_INT_SYS;
    public static final int STARTSTOPREASON_ENGINE;
    public static final int STARTSTOPREASON_SLOPE;
    public static final int STARTSTOPREASON_NOT_AVAILABLE;
    public static final int STARTSTOPREASON_EMERGENCY_BREAKING;
    public static final int STARTSTOPREASON_BRAKE_SYSTEM_SYS;
    public static final int STARTSTOPREASON_ENERGY_MANAGEMENT_SYS;
    public static final int STARTSTOPREASON_CLIMATE_SYSTEM;
    public static final int STARTSTOPREASON_STEERING;
    public static final int STARTSTOPREASON_PARKING;
    public static final int STARTSTOPREASON_DEFROST;
    public static final int STARTSTOPREASON_DRIVER_SEATBELT;
    public static final int STARTSTOPREASON_DRIVER_DOOR;
    public static final int STARTSTOPREASON_THROTTLE;
    public static final int STARTSTOPREASON_FRONT_SCREEN_HEATING;
    public static final int STARTSTOPREASON_CLIMATE_MAX;
    public static final int STARTSTOPREASON_FRONT_LID;
    public static final int STARTSTOPREASON_STANDSTILL;
    public static final int STARTSTOPREASON_OFFROAD;
    public static final int STARTSTOPREASON_CHILD_LOCK;
    public static final int STARTSTOPREASON_GEAR;
    public static final int STARTSTOPREASON_BUTTON;
    public static final int STARTSTOPREASON_CLIMATE_INT;
    public static final int STARTSTOPREASON_ACC;
    public static final int STARTSTOPREASON_PARK_ASSIST;
    public static final int STARTSTOPREASON_BRAKE_SYSTEM;
    public static final int STARTSTOPREASON_ENERGY_MANAGEMENT;
    public static final int STARTSTOPREASON_SYSTEM;
    public static final int STARTSTOPREASON_DRIVER_PERM_ABSENT_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_DRIVER_DOOR_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_FRONT_LID_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_SEATBELT_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_DRIVER_ABSENT_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_COMPONENT_PROTECTION_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_COORDINATOR_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_MANUAL_RESTART_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_PRESS_THROTTLE;
    public static final int STARTSTOPREASON_PRESS_BUTTON;
    public static final int STARTSTOPREASON_SWTICH_TO_R;
    public static final int STARTSTOPREASON_BY_DRIVER;
    public static final int STARTSTOPREASON_DEFROST_RESTART;
    public static final int STARTSTOPREASON_FRONT_SCREEN_HEATING_RESTART;
    public static final int STARTSTOPREASON_CLIMATE_INT_RESTART;
    public static final int STARTSTOPREASON_AC_MAX;
    public static final int STARTSTOPREASON_SECURITY;
    public static final int STARTSTOPREASON_FOGGING_HAZARD;
    public static final int STARTSTOPREASON_POWER_CONSUMPTION_RESTART;
    public static final int STARTSTOPREASON_ENGINE_REQUIRED;
    public static final int STARTSTOPREASON_BUTTON_PUSHED;
    public static final int STARTSTOPREASON_OFFROAD_RESTART;
    public static final int STARTSTOPREASON_BRAKE_SYSTEM_RESTART;
    public static final int STARTSTOPREASON_ENERGY_MANAGEMENT_RESTART;
    public static final int STARTSTOPREASON_CLIMATE_CONTROL_RESTART;
    public static final int STARTSTOPREASON_SYSTEM_RESTART;
    public static final int STARTSTOPREASON_ENGAGED_GEAR_RESTART_PROHIBIT;
    public static final int STARTSTOPREASON_ACC_REQUIRES_ENGINE_RUNNING;
    public static final int STARTSTOPREASON_SHIFT_BY_WIRE;
    public static final int STARTSTOPREASON_S_OR_TIP_GEAR_RESTART;
    public static final int STARTSTOPREASON_PLA_REQUIRES_ENGINE_RUNNING;
    public static final int STARTSTOPREASON_ESC_OFF_BUTTON;
    public static final int STARTSTOPREASON_GEARBOX;
    public static final int STARTSTOPREASON_INIT;
    public static final int STARTSTOPREASON_S_OR_TIP_GEAR;
    public static final int STARTSTOPREASON_TRAFFIC_SITUATION;
    public static final int STARTSTOPREASON_STOP_AND_GO;
    public static final int STARTSTOPREASON_TRAFFIC_LIGHT;
    public static final int STARTSTOPREASON_DOOR_OPEN;
    public static final int STARTSTOPREASON_PEA;
    public static final int STARTSTOPREASON_OPEN_DOOR;
    public static final int STARTSTOPREASON_TRAFFIC_LIGHT_RESTART;
    public static final int STARTSTOPREASON_PEA_RESTART;
    public static final int STARTSTOPARRAYCONTENT_INIT;
    public static final int STARTSTOPARRAYCONTENT_ALL;
    public static final int STARTSTOPARRAYCONTENT_ONLY_CHANGES;
    public static final int STARTSTOPSTATE_IDLE;
    public static final int STARTSTOPSTATE_AVAILABLE;
    public static final int STARTSTOPSTATE_STOPMODE;
    public static final int STARTSTOPSTATE_CLUTCH;
    public static final int STARTSTOPSTATE_CONFIRMPRESENCE;
    public static final int STARTSTOPSTATE_CLUTCHENABLESSTART;
    public static final int STARTSTOPSTATE_SWITCHEDOFF;
    public static final int STARTSTOPSTATE_SYSTEMERROR;
    public static final int STARTSTOPSTATE_NOTAVAILBLE;
    public static final int STARTSTOPSTATE_STOPMODE_RESTART_BRAKE;
    public static final int STARTSTOPSTATE_STOPMODE_RESTART_GAS;
    public static final int STARTSTOPSTATE_STOPMODE_RESTART_GEARSHIFT;
    public static final int STARTSTOPSTATE_STOPMODE_RESTART_CLUTCH;
    public static final int STARTSTOPCOLLECTEDREASONS_HEATING_COOLING_PROHIBITS_STOP;
    public static final int STARTSTOPCOLLECTEDREASONS_SYSTEM_NEEDS_PROHIBIT_STOP;
    public static final int STARTSTOPCOLLECTEDREASONS_SYSTEM_SAFETY_PROHIBITS_STOP;
    public static final int STARTSTOPCOLLECTEDREASONS_TRAFFIC_SITUATION_PROHIBITS_STOP;
    public static final int STARTSTOPCOLLECTEDREASONS_DRIVER_SEATBELT_PROHIBITS_STOP;
    public static final int STARTSTOPCOLLECTEDREASONS_DRIVER_DOOR_OPEN_PROHIBITS_STOP;
    public static final int STARTSTOPCOLLECTEDREASONS_SYSTEM_ERROR;
    public static final int STARTSTOPCOLLECTEDREASONS_DRIVER_SEATBELT_PROHIBITS_RESTART;
    public static final int STARTSTOPCOLLECTEDREASONS_DRIVER_DOOR_OPEN_PROHIBITS_RESTART;
    public static final int STARTSTOPCOLLECTEDREASONS_SYSTEM_SAFETY_PROHIBITS_RESTART;
    public static final int STARTSTOPCOLLECTEDREASONS_STARTSTOP_SWITCHED_OFF;
    public static final int STARTSTOPCOLLECTEDREASONS_STARTSTOP_AVAILABLE;
    public static final int STARTSTOPCOLLECTEDREASONS_STOPMODE_RESTART_BY_BRAKE;
    public static final int STARTSTOPCOLLECTEDREASONS_STOPMODE_RESTART_BY_GAS;
    public static final int STARTSTOPCOLLECTEDREASONS_STOPMODE_RESTART_BY_GEAR_SHIFT;
    public static final int STARTSTOPCOLLECTEDREASONS_STOPMODE_RESTART_BY_CLUTCH;
    public static final int STARTSTOPCOLLECTEDREASONS_RESTART_DUE_HEATING_COOLING;
    public static final int STARTSTOPCOLLECTEDREASONS_RESTART_DUE_SYSTEM_NEEDS;
    public static final int STARTSTOPCOLLECTEDREASONS_RESTART_DUE_SYSTEM_SAFETY;
    public static final int STARTSTOPCOLLECTEDREASONS_RESTART_DUE_TRAFFIC_SITUATION;
    public static final int RDENERGYUNIT_LITER;
    public static final int RDENERGYUNIT_KWH;
    public static final int RDENERGYUNIT_KG;
    public static final int RDENERGYUNIT_M3;

    default public void requestBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo) {
    }

    default public void setBCmELiveTip(int n, boolean bl) {
    }

    default public void setBcmeSetFactoryDefault() {
    }

    default public void requestStartStopProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
    }

    default public void requestStartStopRestartList(StartStopListUpdateInfo startStopListUpdateInfo) {
    }

    default public void requestStartStopRestartProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
    }

    default public void requestBCmEConsumerListConsumption(BCmEListUpdateInfo bCmEListUpdateInfo) {
    }

    default public void requestBCmEConsumerListRange(BCmEListUpdateInfo bCmEListUpdateInfo) {
    }

    default public void setRDSetFactoryDefault() {
    }

    default public void setEASystem(boolean bl) {
    }

    default public void setEAPedalJerk(boolean bl) {
    }

    default public void setEASetFactoryDefault() {
    }

    default public void setEAFreeWheeling(boolean bl) {
    }

    default public void setEAStartStop(boolean bl) {
    }
}

