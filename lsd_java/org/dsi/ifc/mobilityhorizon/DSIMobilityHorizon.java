/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizon
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETCONSUMPTIONINFO;
    public static final int RT_SETLOCATIONS;
    public static final int RT_SETCONSIDEREDLOCATIONTYPES;
    public static final int RT_SETDRIVETRAINMODE;
    public static final int RT_REQUESTLOCATIONRANGELEVEL;
    public static final int RP_REQUESTLOCATIONRANGELEVELRESULT;
    public static final int IN_LOCATIONRANGELEVELCHANGED;
    public static final int ATTR_LOCATIONS;
    public static final int ATTR_CONSIDEREDLOCATIONTYPES;
    public static final int ATTR_DRIVETRAINMODE;
    public static final int ATTR_MOBILITYHORIZONSTATUS;
    public static final int UNIT_UNKNOWN;
    public static final int UNIT_LITER;
    public static final int UNIT_KILOGRAM;
    public static final int UNIT_KILOWATT_HOUR;
    public static final int LOCATIONTYPE_NONE;
    public static final int LOCATIONTYPE_ONEWAY;
    public static final int LOCATIONTYPE_HOME;
    public static final int LOCATIONTYPE_USERDEFINED;
    public static final int DRIVETRAINMODE_PRIMARY;
    public static final int DRIVETRAINMODE_SECONDARY;
    public static final int DRIVETRAINMODE_COMBINED;
    public static final int MOBILITYHORIZONSTATUS_SYSTEMNOTREADY;
    public static final int MOBILITYHORIZONSTATUS_SYSTEMREADY;
    public static final int MOBILITYHORIZONSTATUS_NODATABASEFOUND;
    public static final int MOBILITYHORIZONSTATUS_DATABASEDEFECT;
    public static final int MOBILITYHORIZONSTATUS_CRITICALENERGYLEVEL_1;
    public static final int MOBILITYHORIZONSTATUS_CRITICALENERGYLEVEL_2;
    public static final int MOBILITYHORIZONSTATUS_NOTENOUGHENERGY;
    public static final int MOBILITYHORIZONSTATUS_OTHERFAILURE;
    public static final int LOCATIONRANGETYPE_TARGET;
    public static final int LOCATIONRANGETYPE_HOME;
    public static final int LOCATIONRANGETYPE_USERDEFINED;
    public static final int LOCATIONRANGELEVEL_UNDEFINED;
    public static final int LOCATIONRANGELEVEL_INRANGE;
    public static final int LOCATIONRANGELEVEL_CRITICAL;
    public static final int LOCATIONRANGELEVEL_OUTOFRANGE;

    default public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
    }

    default public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
    }

    default public void setConsideredLocationTypes(int[] nArray) {
    }

    default public void setDriveTrainMode(int n) {
    }

    default public void requestLocationRangeLevel(int n) {
    }
}

