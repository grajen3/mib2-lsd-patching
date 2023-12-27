/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid;

public interface DSICarHybrid$Consts {
    public static final String VERSION;
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
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;
}

