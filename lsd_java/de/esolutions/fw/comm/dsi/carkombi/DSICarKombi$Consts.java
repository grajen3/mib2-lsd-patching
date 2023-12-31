/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi;

public interface DSICarKombi$Consts {
    public static final String VERSION;
    public static final int SIADISTANCESTATUS_UNDEFINED;
    public static final int SIADISTANCESTATUS_NOT_CALCULATED_YET;
    public static final int SIADISTANCESTATUS_SERVICE_IN;
    public static final int SIADISTANCESTATUS_SERVICE_AGO;
    public static final int SIATIMESTATUS_UNDEFINED;
    public static final int SIATIMESTATUS_NOT_CALCULATED;
    public static final int SIATIMESTATUS_SERVICE_IN;
    public static final int SIATIMESTATUS_SERVICE_AGO;
    public static final int SIARESETVALUES_OIL_DISTANCE;
    public static final int SIARESETVALUES_OIL_TIME;
    public static final int SIARESETVALUES_INSPECTION_DISTANCE;
    public static final int SIARESETVALUES_INSPECTION_TIME;
    public static final int SIAHISTORYLISTRACONTENT_POS;
    public static final int SIAHISTORYLISTRACONTENT_SERVICE_TYPE;
    public static final int SIAHISTORYLISTRACONTENT_SERVICE_ATTRIBUTES;
    public static final int SIAHISTORYLISTRACONTENT_YEAR;
    public static final int SIAHISTORYLISTRACONTENT_MONTH;
    public static final int SIAHISTORYLISTRACONTENT_DAY;
    public static final int SIAHISTORYLISTRACONTENT_ORDER_CODE;
    public static final int SIAHISTORYLISTRACONTENT_MILAGE;
    public static final int SIAHISTORYLISTRACONTENT_MILAGE_UNIT;
    public static final int SIAHISTORYLISTRACONTENT_DEALER_NAME;
    public static final int BCENGINE_PRIMARY_ENGINE;
    public static final int BCENGINE_SECONDARY_ENGINE;
    public static final int BCENGINETYPE_NOT_INSTALLED;
    public static final int BCENGINETYPE_PETROL;
    public static final int BCENGINETYPE_GAS;
    public static final int BCENGINETYPE_ELECTRIC;
    public static final int BCENGINETYPE_UNKNOWN;
    public static final int BCENGINETYPE_NOT_SUPPORTED;
    public static final int BCENGINETYPE_PETROL_DIESEL;
    public static final int BCENGINETYPE_PETROL_GASOLINE;
    public static final int BCENGINETYPE_GAS_CNG;
    public static final int BCENGINETYPE_GAS_LPG;
    public static final int BCMENUSTATE_INVALID;
    public static final int BCMENUSTATE_VALID;
    public static final int BCTEMPERATURESTATE_INITIAL;
    public static final int BCTEMPERATURESTATE_VALID;
    public static final int BCTEMPERATURESTATE_INVALID;
    public static final int BCCOUNTERSTATE_INITIAL;
    public static final int BCCOUNTERSTATE_VALID;
    public static final int BCCOUNTERSTATE_INVALID;
    public static final int BCMENUE_ALL;
    public static final int BCMENUE_ONE;
    public static final int BCMENUE_TWO;
    public static final int BCMENUE_THREE;
    public static final int BCMENUE_MAX_VALUES;
    public static final int BCMENUE_TRIP;
    public static final int VEHICLESTATELISTARRAYCONTENT_NONE;
    public static final int VEHICLESTATELISTARRAYCONTENT_ALL;
    public static final int VEHICLESTATELISTARRAYCONTENT_ALL_FORWARD;
    public static final int VEHICLESTATELISTARRAYCONTENT_ALL_BACKWARD;
    public static final int VEHICLESTATELISTARRAYCONTENT_ONLY_CHANGES;
    public static final int VEHICLESTATELISTARRAYCONTENT_ELEMENTS_REMOVED;
    public static final int VEHICLESTATELISTARRAYCONTENT_BLOCK_INSERTED;
    public static final int VEHICLESTATELISTARRAYCONTENT_BACKWARD;
    public static final int VEHICLESTATELISTRECORDCONTENT_WARNINGID_DYNVALUE_ALTERNATIVETEXT;
    public static final int VEHICLESTATELISTRECORDCONTENT_WARNINGID_DYNVALUE;
    public static final int VEHICLESTATELISTRECORDCONTENT_ALTERNATIVETEXT;
    public static final int VEHICLESTATELISTRECORDCONTENT_DYNVALUE;
    public static final int VEHICLESTATELISTRECORDCONTENT_POS_ONLY;
    public static final int VEHICLESTATELISTRECORDCONTENT_NONE;
    public static final int BCVALUESTATE_INVALID;
    public static final int BCVALUESTATE_VALID;
    public static final int BCVALUESTATE_MAX;
    public static final int BCVALUESTATE_NOT_CALCULATED;
    public static final int BCVALUESTATE_INIT;
    public static final int BCACKSTATE_SUCCESSFUL;
    public static final int BCACKSTATE_NOT_SUCCESSFUL;
    public static final int BCACKSTATE_ABORT_SUCCESSFUL;
    public static final int BCACKSTATE_ABORT_NOT_SUCCESSFUL;
    public static final int HUDINFORMATION_FAULTY;
    public static final int HUDINFORMATION_PROPERLY;
    public static final int HUDCOLOURDESIGN_AUTO;
    public static final int HUDCOLOURDESIGN_DAY;
    public static final int HUDCOLOURDESIGN_NIGHT;
    public static final int HUDCOLOUR_DEFAULT;
    public static final int HUDCOLOUR_ALTERNATIVE;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RA0;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RA1;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RA2;
    public static final int DCELEMENTCONTENTSELECTIONLISTRECORDCONTENT_RAF;
    public static final int DCELEMENTCONTENT_BLANKLINE;
    public static final int DCELEMENTCONTENT_BOOSTPRESSURE;
    public static final int DCELEMENTCONTENT_OILPRESSURE;
    public static final int DCELEMENTCONTENT_OILTEMPERATURE;
    public static final int DCELEMENTCONTENT_COOLANTTEMPERATURE;
    public static final int DCELEMENTCONTENT_FUELRANGE;
    public static final int DCELEMENTCONTENT_DESTINATIONARRIVALTIME;
    public static final int DCELEMENTCONTENT_INTERMEDIATEARRIVALTIME;
    public static final int DCELEMENTCONTENT_DESTINATIONTRIPTIME;
    public static final int DCELEMENTCONTENT_INTERMEDIATETRIPTIME;
    public static final int DCELEMENTCONTENT_COMPASS;
    public static final int DCELEMENTCONTENT_GPSHEIGHT;
    public static final int DCELEMENTCONTENT_TIME;
    public static final int DCELEMENTCONTENT_DATE;
    public static final int DCELEMENTCONTENT_HYBRIDBATTERY;
    public static final int DCELEMENTCONTENT_STATIONTRACK;
    public static final int DCELEMENTCONTENT_PHONEINFO;
    public static final int DCELEMENTCONTENT_LATERALACCELERATION;
    public static final int DCELEMENTCONTENT_ACCELERATION;
    public static final int DCELEMENTCONTENT_DECELERATION;
    public static final int DCELEMENTCONTENT_ELECTRICRANGE;
    public static final int DCELEMENTCONTENT_BATTERYSTATEOFCHARGE;
    public static final int DCELEMENTCONTENT_CHARGINGTIMELEFT;
    public static final int DCELEMENTCONTENT_BATTERYTEMPERATURE;
    public static final int DCELEMENTCONTENT_BATTERYLEVELRANGE;
    public static final int DCELEMENTCONTENT_COOLANT;
    public static final int DCELEMENTCONTENT_BOOSTLEVELVALUE;
    public static final int DCELEMENTCONTENT_BATTERYCOOLANT;
    public static final int DCELEMENTCONTENT_BATTERYBOOST;
    public static final int DCELEMENTCONTENT_BOOSTCOOLANT;
    public static final int DCELEMENTCONTENT_VEHICLEVOLTAGE;
    public static final int DCELEMENTCONTENT_AVERAGECONSUMPTION;
    public static final int DCELEMENTCONTENT_DISTANCE;
    public static final int DCELEMENTCONTENT_DRIVINGTIME;
    public static final int DCELEMENTCONTENT_CURRENTCONSUMPTION;
    public static final int DCELEMENTCONTENT_ZEROEMISSION;
    public static final int DCELEMENTCONTENT_DRIVINGPROFILE;
    public static final int DCELEMENTCONTENT_SECONDARYSPEED;
    public static final int DCELEMENTCONTENT_DIGITALSPEED;
    public static final int DCELEMENTCONTENT_ENERGYFLOW;
    public static final int DCELEMENTCONTENT_ACC;
    public static final int DCELEMENTCONTENT_ROUTEGUIDANCE;
    public static final int DCELEMENTCONTENT_TRAFFICSIGNDETECTION;
    public static final int DCELEMENTCONTENT_SHIFTUPINDICATION;
    public static final int DCELEMENTCONTENT_PERFORMANCE;
    public static final int DCELEMENTCONTENT_PREDICTIVEEFFICIENCYASSISTANT;
    public static final int DCELEMENTCONTENT_WILDCARD;
    public static final int DCELEMENTCONTENT_STEERINGANGLE;
    public static final int DCELEMENTCONTENT_SLOPE;
    public static final int DCELEMENTCONTENT_CONSUMPTION_DATA;
    public static final int DCELEMENTCONTENT_COMBUSTOR_CONSUMPTION;
    public static final int DCELEMENTCONTENT_ELECTRICAL_CONSUMPTION;
    public static final int DCELEMENTCONTENT_AVERAGESPEED;
    public static final int DCELEMENTCONTENT_POWERMETER;
    public static final int DCELEMENTCONTENT_TACHOMETER;
    public static final int DCELEMENTCONTENT_POWERMETER_AND_TACHOMETER;
    public static final int DCELEMENTCONTENT_HYBRID;
    public static final int DCELEMENTCONTENT_ENGINE_DATA;
    public static final int DCELEMENTCONTENT_SHORTTERM_DATA;
    public static final int DCELEMENTCONTENT_LONGTERM_DATA;
    public static final int DCELEMENTCONTENT_G_METER;
    public static final int DCELEMENTCONTENT_TYRE_PRESSURE_MONITOR;
    public static final int DISPLAYPRESETLISTRACONTENT_POS;
    public static final int DISPLAYPRESETSLISTRACONTENT_STATE;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAYPRESETTYPE;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAYPRESETINSTANCE;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY1MAINSELECTION;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY1ADDITIONALINFO1;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY1ADDITIONALINFO2;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY2MAINSELECTION;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY2ADDITIONALINFO1;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY2ADDITIONALINFO2;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY3MAINSELECTION;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY3ADDITIONALINFO1;
    public static final int DISPLAYPRESETSLISTRACONTENT_DISPLAY3ADDITIONALINFO2;
    public static final int DCSTATE_EMPTY;
    public static final int DCSTATE_PREDEFINED;
    public static final int DCSTATE_USERDEFINED;
    public static final int DCDISPLAYPRESETSTYPE_UNKNOWN;
    public static final int DCDISPLAYPRESETSTYPE_INDIVIDUAL;
    public static final int DCDISPLAYPRESETSTYPE_CLASSIC;
    public static final int DCDISPLAYPRESETSTYPE_DRIVINGPROFILE;
    public static final int DCDISPLAYVIEWCONFIGURATION_UNKNOWN;
    public static final int DCDISPLAYVIEWCONFIGURATION_NORMAL;
    public static final int DCDISPLAYVIEWCONFIGURATION_LARGE;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW1;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW2;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW3;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW4;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW5;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW6;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW7;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW8;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW9;
    public static final int DCDISPLAYVIEWCONFIGURATION_DISPLAY_VIEW10;
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;
}

