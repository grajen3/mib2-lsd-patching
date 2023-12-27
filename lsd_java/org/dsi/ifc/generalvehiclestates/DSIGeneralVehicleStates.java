/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

public interface DSIGeneralVehicleStates
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETDSSSKOMBIWARNING;
    public static final int RT_SETTLODATA;
    public static final int RT_SETAPPCONNECTSTATE;
    public static final int ATTR_AIRBAGDATA;
    public static final int ATTR_TANKINFO;
    public static final int ATTR_DIMMEDHEADLIGHT;
    public static final int ATTR_ACOUSTICPARKINGSYSTEM;
    public static final int ATTR_CARVELOCITYTHRESHOLD;
    public static final int ATTR_TVVELOCITYTHRESHOLD;
    public static final int ATTR_HDDVELOCITYTHRESHOLD;
    public static final int ATTR_BROWSERSLIDESHOWVELOCITYTHRESHOLD;
    public static final int ATTR_BROWSERBORDBOOKVELOCITYTHRESHOLD;
    public static final int ATTR_BROWSERTRAVELAGENTVELOCITYTHRESHOLD;
    public static final int ATTR_BROWSERWEBVELOCITYTHRESHOLD;
    public static final int ATTR_BWSVELOCITYTHRESHOLD;
    public static final int ATTR_RADIOTEXTVELOCITYTHRESHOLD;
    public static final int ATTR_DISPLAYDAYNIGHTDESIGN;
    public static final int ATTR_BTBONDINGVELOCITYTHRESHOLD;
    public static final int ATTR_MESSAGINGVELOCITYTHRESHOLD;
    public static final int ATTR_DESTINATIONINPUTVELOCITYTHRESHOLD;
    public static final int ATTR_REVERSEGEAR;
    public static final int ATTR_DSSSVIEWOPTION;
    public static final int ATTR_VEHICLESTANDSTILL;
    public static final int ATTR_SERVICEKEYDATA;
    public static final int ATTR_SERVICEKEYVIEWOPTION;
    public static final int ATTR_PERSONALIZATIONSTATUS;
    public static final int ATTR_TLOVIEWOPTIONS;
    public static final int ATTR_EMERGENCYASSISTVOLLOWERING;
    public static final int ATTR_PARKINGBRAKE;
    public static final int ATTR_APPCONNECTTRIGGER;
    public static final int ATTR_STPSTATE;
    public static final int ATTR_AUTOMATICGEARSHIFTTRANSMODE;
    public static final int AIRBAGCRASHINTENSITY_NOCRASH;
    public static final int AIRBAGCRASHINTENSITY_INTENSITY1;
    public static final int AIRBAGCRASHINTENSITY_INTENSITY2;
    public static final int AIRBAGCRASHINTENSITY_INTENSITY3;
    public static final int DSSSWARNING_NO_WARNING;
    public static final int DSSSWARNING_RED_TRAFFIC_LIGHT_GUIDANCE;
    public static final int DSSSWARNING_STOP_SIGN_WARNING;
    public static final int DSSSWARNING_REAR_END_COLLISION_AVOIDANCE_WARNING;
    public static final int DSSSWARNING_INTERSECTION_COLLISION_AVOIDANCE_WARNING_RIGHT;
    public static final int DSSSWARNING_INTERSECTION_COLLISION_AVOIDANCE_WARNING_LEFT;
    public static final int DSSSWARNING_TURN_RIGHT_COLLISION_AVOIDANCE;
    public static final int DSSSWARNING_TURN_LEFT_COLLISION_AVOIDANCE;
    public static final int DSSSWARNING_PEDESTRIAN_CROSSING_RIGHT;
    public static final int DSSSWARNING_PEDESTRIAN_CROSSING_LEFT;
    public static final int DSSSWARNING_BICYCLE_COLLISION_RIGHT;
    public static final int DSSSWARNING_BICYCLE_COLLISION_LEFT;
    public static final int TLOTIMESTATE_UNAVAILABLE;
    public static final int TLOTIMESTATE_STOPTHENPROCEED;
    public static final int TLOTIMESTATE_STOPANDREMAIN;
    public static final int TLOTIMESTATE_PREMOVEMENT;
    public static final int TLOTIMESTATE_PERMISSIVEMOVEMENTALLOWED;
    public static final int TLOTIMESTATE_PROTECTEDMOVEMENTALLOWED;
    public static final int TLOTIMESTATE_PERMISSIVECLEARANCE;
    public static final int TLOTIMESTATE_PROTECTEDCLEARANCE;
    public static final int TLOTIMESTATE_CAUTIONCONFLICTINGTRAFFIC;
    public static final int TLOHMISTATE_INIT;
    public static final int TLOHMISTATE_ACTIVEFUNCTIONCONNECTIONOK;
    public static final int TLOHMISTATE_STANDBYNORMALMODEWAITINGFORNEWDATA;
    public static final int TLOHMISTATE_SWITCHEDOFFBYDRIVER;
    public static final int TLOHMISTATE_FILTEREDOUTNOTDISPLAYED;
    public static final int TLOSTARTSTOPINFO_RUNNINGENGINENOTNECESSARY;
    public static final int TLOSTARTSTOPINFO_RUNNINGENGINENOTREALYNECESSARY;
    public static final int TLOSTARTSTOPINFO_RUNNINGENGINESTRONGLYNECESSARY;
    public static final int TLOSTARTSTOPINFO_SYSTEMERROR;
    public static final int EMERGENCYASSISTVOLLOWERING_INIT;
    public static final int EMERGENCYASSISTVOLLOWERING_NOLOWERING;
    public static final int EMERGENCYASSISTVOLLOWERING_LOWERING;
    public static final int EMERGENCYASSISTVOLLOWERING_MUTE;
    public static final int APPCONNECTTRIGGER_IDLE;
    public static final int APPCONNECTTRIGGER_REQUEST;
    public static final int APPCONNECTTRIGGER_RELEASE;
    public static final int STPSTATE_INIT;
    public static final int STPSTATE_NOT_ACTIVE;
    public static final int STPSTATE_NOT_ACTIVATABLE;
    public static final int STPSTATE_ACTIVATABLE;
    public static final int STPSTATE_ACTIVE;
    public static final int STPSTATE_ACTIVE_ESK0;
    public static final int STPSTATE_ACTIVE_ESK1;
    public static final int STPSTATE_ACTIVE_ESK2;
    public static final int STPSTATE_ACTIVE_ESK3;
    public static final int STPSTATE_ACTIVE_EMERGENCY;
    public static final int STPSTATE_ACTIVE_STABLE_STATE;
    public static final int STPSTATE_ACTIVE_ADOPTION;
    public static final int STPSTATE_ERROR;

    default public void setDSSSKombiWarning(int n) {
    }

    default public void setTLOData(int n, int n2, TLOInfoElement[] tLOInfoElementArray) {
    }

    default public void setAppConnectState(boolean bl) {
    }
}

