/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public interface DSICarHybrid
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETBATTERYCONTROLIMMEDIATELY;
    public static final int RT_SETBATTERYCONTROLTIMERSTATE;
    public static final int RT_SETBATTERYCONTROLTIMER;
    public static final int RT_SETBATTERYCONTROLSETFACTORYDEFAULT;
    public static final int RT_REQUESTBATTERYCONTROLPROFILELIST;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA0;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA1;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA2;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA3;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA4;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA5;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA6;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA7;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRAF;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRA0;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRA1;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRA2;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRAE;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRAF;
    public static final int RT_REQUESTBATTERYCONTROLPOWERPROVIDERLIST;
    public static final int RT_SETHYBRIDTARGETRANGE;
    public static final int RT_SETHYBRIDENERGYASSISTCONTROL;
    public static final int RT_SETBATTERYCONTROLPASTERRORREASON;
    public static final int RT_SETBATTERYCONTROLREMAININGCHARGETIME;
    public static final int RT_SETHYBRIDACTIVEPEDAL;
    public static final int RP_ACKNOWLEDGEBATTERYCONTROLSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEBATTERYCONTROLIMMEDIATELY;
    public static final int IN_RESPONSEPROFILELISTRA0;
    public static final int IN_RESPONSEPROFILELISTRA1;
    public static final int IN_RESPONSEPROFILELISTRA2;
    public static final int IN_RESPONSEPROFILELISTRA3;
    public static final int IN_RESPONSEPROFILELISTRA4;
    public static final int IN_RESPONSEPROFILELISTRA5;
    public static final int IN_RESPONSEPROFILELISTRA6;
    public static final int IN_RESPONSEPROFILELISTRA7;
    public static final int IN_RESPONSEPROFILELISTRAF;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRA0;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRA1;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRA2;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRAE;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRAF;
    public static final int ATTR_HYBRIDVIEWOPTIONS;
    public static final int ATTR_HYBRIDCHARGE;
    public static final int ATTR_HYBRIDENERGYFLOWSTATE;
    public static final int ATTR_HYBRIDRECOVEREDENERGY;
    public static final int ATTR_HYBRIDENERGYFLOW;
    public static final int ATTR_BATTERYCONTROLVIEWOPTIONS;
    public static final int ATTR_BATTERYCONTROLPLUG;
    public static final int ATTR_BATTERYCONTROLCHARGESTATE;
    public static final int ATTR_BATTERYCONTROLCLIMATESTATE;
    public static final int ATTR_BATTERYCONTROLTIMERSTATE;
    public static final int ATTR_BATTERYCONTROLTIMER1;
    public static final int ATTR_BATTERYCONTROLTIMER2;
    public static final int ATTR_BATTERYCONTROLTIMER3;
    public static final int ATTR_BATTERYCONTROLTIMER4;
    public static final int ATTR_BATTERYCONTROLTOTALNUMBEROFPROFILES;
    public static final int ATTR_BATTERYCONTROLPROFILESLISTUPDATEINFO;
    public static final int ATTR_BATTERYCONTROLTOTALNUMBEROFPOWERPROVIDER;
    public static final int ATTR_BATTERYCONTROLPOWERPROVIDERLISTUPDATEINFO;
    public static final int ATTR_HYBRIDTARGETRANGE;
    public static final int ATTR_HYBRIDENERGYASSISTCONTROL;
    public static final int ATTR_HYBRIDENERGYASSISTSTATE;
    public static final int ATTR_BATTERYCONTROLPASTERRORREASON;
    public static final int ATTR_BATTERYCONTROLPLUGDISPLAYSTATE;
    public static final int ATTR_BATTERYCONTROLREMAININGCHARGETIME;
    public static final int ATTR_BATTERYCONTROLLOWESTMAXCURRENT;
    public static final int ATTR_HYBRIDINHIBITREASON;
    public static final int ATTR_HYBRIDACTIVEPEDAL;
    public static final int MOTIONSTATE_NOTSUPPORTED;
    public static final int MOTIONSTATE_INIT;
    public static final int MOTIONSTATE_STANDSTILL;
    public static final int MOTIONSTATE_FORWARD;
    public static final int MOTIONSTATE_REVERSE;
    public static final int ICESTATE_NOTSUPPORTED;
    public static final int ICESTATE_INIT;
    public static final int ICESTATE_INACTIVE;
    public static final int ICESTATE_GENERATORMODE;
    public static final int ICESTATE_DRIVEMODE;
    public static final int ICESTATE_PASSIVMODE;
    public static final int BATTERYSTATE_NOTSUPPORTED;
    public static final int BATTERYSTATE_INIT;
    public static final int BATTERYSTATE_CHARGING;
    public static final int BATTERYSTATE_INACTIVE;
    public static final int BATTERYSTATE_DISCHARGING;
    public static final int BATTERYSTATE_NOCURRENT;
    public static final int TORQUESTATE_NOTSUPPORTED;
    public static final int TORQUESTATE_INIT;
    public static final int TORQUESTATE_INACTIVENODRIVEREADYNESS;
    public static final int TORQUESTATE_MAXIMUMDRIVETORQUEDEMANDBOOST;
    public static final int TORQUESTATE_POSITIVEDRIVETORQUEDEMAND;
    public static final int TORQUESTATE_NODRIVETORQUEDEMAND;
    public static final int TORQUESTATE_NEGATIVEDRIVETORQUEDEMAND;
    public static final int POWERSUPPLYSTATE_NOTSUPPORTED;
    public static final int POWERSUPPLYSTATE_INIT;
    public static final int POWERSUPPLYSTATE_INACTIVE;
    public static final int POWERSUPPLYSTATE_ICE;
    public static final int POWERSUPPLYSTATE_BATTERYCHARGER;
    public static final int POWERSUPPLYSTATE_HVBATTERY;
    public static final int POWERSUPPLYSTATE_RECUPERATION;
    public static final int POWERSUPPLYSTATE_RECUPERATIONHVBATTERY;
    public static final int POWERSUPPLYSTATE_ICEHVBATTERY;
    public static final int EESTATE_NOTSUPPORTED;
    public static final int EESTATE_INIT;
    public static final int EESTATE_INACTIVE;
    public static final int EESTATE_POSITIVEDRIVETORQUE;
    public static final int EESTATE_NODRIVETORQUE;
    public static final int EESTATE_NEGATIVEDRIVETORQUE;
    public static final int BATTERYCONTROLLOCKSETUP_UNLOCK;
    public static final int BATTERYCONTROLLOCKSETUP_LOCK;
    public static final int BATTERYCONTROLLOCKSETUP_INIT;
    public static final int BATTERYCONTROLLOCKSTATE_AUTOLOCKERROR;
    public static final int BATTERYCONTROLLOCKSTATE_UNLOCKERROR;
    public static final int BATTERYCONTROLLOCKSTATE_INIT;
    public static final int BATTERYCONTROLSUPPLYSTATE_INACTIVE;
    public static final int BATTERYCONTROLSUPPLYSTATE_ACTIVE;
    public static final int BATTERYCONTROLSUPPLYSTATE_CHARGESTATION_CONNECTED;
    public static final int BATTERYCONTROLSUPPLYSTATE_INIT;
    public static final int BATTERYCONTROLPLUGSTATE_NOTPLUGGED;
    public static final int BATTERYCONTROLPLUGSTATE_PLUGGED;
    public static final int BATTERYCONTROLPLUGSTATE_INIT;
    public static final int BATTERYCONTROLCHARGEMODE_OFF;
    public static final int BATTERYCONTROLCHARGEMODE_AC;
    public static final int BATTERYCONTROLCHARGEMODE_DC;
    public static final int BATTERYCONTROLCHARGEMODE_CONDITIONING;
    public static final int BATTERYCONTROLCHARGEMODE_AC_AND_CONDITIONING;
    public static final int BATTERYCONTROLCHARGEMODE_DC_AND_CONDITIONING;
    public static final int BATTERYCONTROLCHARGEMODE_INIT;
    public static final int BATTERYCONTROLCHARGESTATE_INIT;
    public static final int BATTERYCONTROLCHARGESTATE_IDLE;
    public static final int BATTERYCONTROLCHARGESTATE_RUNNING;
    public static final int BATTERYCONTROLCHARGESTATE_CONSERVATION_CHARGING;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_TEMPERATURETOOLOW;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_GENERALDEVICEERROR;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_POWERSUPPLYNOTAVAILABLE;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_NOTINPARKINGPOSITION;
    public static final int BATTERYCONTROLCHARGESTATE_COMPLETED;
    public static final int BATTERYCONTROLCHARGESTATE_NO_ERROR;
    public static final int BATTERYCONTROLCHARGESTARTREASON_INIT;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER1;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER2;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER3;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER4;
    public static final int BATTERYCONTROLCHARGESTARTREASON_IMMEDIATELY;
    public static final int BATTERYCONTROLCHARGESTARTREASON_PUSHBUTTON;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_INIT;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_OFF;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_COOLING;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_HEATING;
    public static final int BATTERYCONTROLCLIMATESTATE_INIT;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_CARBODYSHELLOPEN;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_IGNITIONISON;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_PARKHEATER_NOFUEL;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_PARKHEATER_MAX_OPTIME_REACHED;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_NOEXTERNALSUPPLY;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_GENERALDEVICEERROR;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_BATTERYCONDITION;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_BATTERYCHARGING;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_BATTERYLOW;
    public static final int BATTERYCONTROLCLIMATESTATE_IDLE;
    public static final int BATTERYCONTROLCLIMATESTATE_RUNNING;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_NOTINPARKINGPOSITION;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_POWERREDUCTION;
    public static final int BATTERYCONTROLCLIMATESTATE_COMPLETED;
    public static final int BATTERYCONTROLCLIMATESTATE_DEFECTIVE;
    public static final int BATTERYCONTROLCLIMATESTATE_AUXHEATER_DEFECTIVE;
    public static final int BATTERYCONTROLCLIMATESTATE_NO_ERROR;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_INIT;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_IGNITIONISON;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_GENERALDEVICEERROR;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_BATTERYCONDITION;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_BATTERYLOW;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_IDLE;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_RUNNING;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_COMPLETED;
    public static final int BATTERYCONTROLTIMER_TIMER_UNKNOWN;
    public static final int BATTERYCONTROLTIMER_TIMER1;
    public static final int BATTERYCONTROLTIMER_TIMER2;
    public static final int BATTERYCONTROLTIMER_TIMER3;
    public static final int BATTERYCONTROLTIMER_TIMER4;
    public static final int BATTERYCONTROLSCHEDULESTATE_IDLE;
    public static final int BATTERYCONTROLSCHEDULESTATE_CALCULATE;
    public static final int BATTERYCONTROLSCHEDULESTATE_OK;
    public static final int BATTERYCONTROLSCHEDULESTATE_CHARGINGNOTREACHABLE;
    public static final int BATTERYCONTROLSCHEDULESTATE_TIMERINVALID;
    public static final int BATTERYCONTROLARRAYCONTENT_NONE;
    public static final int BATTERYCONTROLARRAYCONTENT_ALL;
    public static final int BATTERYCONTROLARRAYCONTENT_ALL_FORWARD;
    public static final int BATTERYCONTROLARRAYCONTENT_ALL_BACKWARD;
    public static final int BATTERYCONTROLARRAYCONTENT_ONLY_CHANGES;
    public static final int BATTERYCONTROLARRAYCONTENT_ELEMENTS_REMOVED;
    public static final int BATTERYCONTROLARRAYCONTENT_BLOCK_INSERTED;
    public static final int BATTERYCONTROLARRAYCONTENT_BACKWARD;
    public static final int BATTERYCONTROLRECORDCONTENT_RA0;
    public static final int BATTERYCONTROLRECORDCONTENT_RA1;
    public static final int BATTERYCONTROLRECORDCONTENT_RA2;
    public static final int BATTERYCONTROLRECORDCONTENT_RA3;
    public static final int BATTERYCONTROLRECORDCONTENT_RA4;
    public static final int BATTERYCONTROLRECORDCONTENT_RA5;
    public static final int BATTERYCONTROLRECORDCONTENT_RA6;
    public static final int BATTERYCONTROLRECORDCONTENT_RA7;
    public static final int BATTERYCONTROLRECORDCONTENT_RAF;
    public static final int PROFILELIST_POS;
    public static final int PROFILELIST_NONE;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RA0;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RA1;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RA2;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RAE;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RAF;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENTLIST_POS;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENTLIST_NONE;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_DC;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_AC_MODE2;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_AC_MODE3;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_NONE;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_OFF;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_PERMANENT_ON;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_BLINK;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_PULSE;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_FLASH;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_NONE;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_GREEN;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_YELLOW;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_RED;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_NONE;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_ONBOARD_CHARGE_DEVICE;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_CABLE;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_CHARGING_STATION;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_AC_HEADUNIT;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_INIT;
    public static final int BATTERYCONTROLPASTERRORREASONRESET_NOERROR;
    public static final int BATTERYCONTROLPASTERRORREASONRESET_ERROR;
    public static final int BATTERYCONTROLCHARGESTATETARGETSOC_MINSOC;
    public static final int BATTERYCONTROLCHARGESTATETARGETSOC_MAXSOC;
    public static final int BATTERYCONTROLCHARGESTATETARGETSOC_INIT;
    public static final int ENERGYASSISTSTATE_NOTACTIVE;
    public static final int ENERGYASSISTSTATE_ACTIVE;
    public static final int ENERGYASSISTSTATE_CALCULATION_ACTIVE;
    public static final int ENERGYASSISTSTATE_ROUTEGUIDANCE_NOTACTIVE;
    public static final int ENERGYASSISTSTATE_TEMP_NOTAVAILABLE;
    public static final int ENERGYASSISTSTATE_DEFECTIVE;

    default public void setBatteryControlImmediately(int n, int n2) {
    }

    default public void setBatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
    }

    default public void setBatteryControlTimer(int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
    }

    default public void setBatteryControlSetFactoryDefault() {
    }

    default public void setHybridTargetRange(short s, int n) {
    }

    default public void setHybridEnergyAssistControl(boolean bl) {
    }

    default public void requestBatteryControlProfileList(BatteryControlProfilesAH batteryControlProfilesAH) {
    }

    default public void setBatteryControlProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
    }

    default public void setBatteryControlProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
    }

    default public void setBatteryControlProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
    }

    default public void setBatteryControlProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
    }

    default public void setBatteryControlProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
    }

    default public void setBatteryControlProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
    }

    default public void setBatteryControlProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
    }

    default public void setBatteryControlProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
    }

    default public void setBatteryControlProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
    }

    default public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
    }

    default public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
    }

    default public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
    }

    default public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
    }

    default public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
    }

    default public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
    }

    default public void setBatteryControlPastErrorReason(int n) {
    }

    default public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) {
    }

    default public void setHybridActivePedal(boolean bl) {
    }
}

