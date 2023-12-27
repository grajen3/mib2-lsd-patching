/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarKombi
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SIAVIEWOPTIONS;
    public static final int ATTR_SIASERVICEDATA;
    public static final int ATTR_SIAOILINSPECTION;
    public static final int ATTR_SIAHISTORYLISTUPDATEINFO;
    public static final int ATTR_SIAHISTORYLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_SIADISTANCEOILUSER;
    public static final int ATTR_SIADISTANCEAIRFILTERUSER;
    public static final int ATTR_SIADISTANCEOILFILTERUSER;
    public static final int ATTR_SIAINSPECTIONDISTANCEUSER;
    public static final int ATTR_SIADAILYAVERAGEMILEAGE;
    public static final int ATTR_BCVIEWOPTIONS;
    public static final int ATTR_BCINDICATIONS;
    public static final int ATTR_BCCURRENTCONSUMPTION1;
    public static final int ATTR_BCCURRENTCONSUMPTION2;
    public static final int ATTR_BCCURRENTRANGE1;
    public static final int ATTR_BCCURRENTRANGE2;
    public static final int ATTR_BCTOTALDISTANCE;
    public static final int ATTR_BCSHORTTERMAVERAGECONSUMPTION1;
    public static final int ATTR_BCSHORTTERMAVERAGECONSUMPTION2;
    public static final int ATTR_BCSHORTTERMGENERAL;
    public static final int ATTR_BCLONGTERMAVERAGECONSUMPTION1;
    public static final int ATTR_BCLONGTERMAVERAGECONSUMPTION2;
    public static final int ATTR_BCLONGTERMGENERAL;
    public static final int ATTR_BCCYCLEAVERAGECONSUMPTION1;
    public static final int ATTR_BCCYCLEAVERAGECONSUMPTION2;
    public static final int ATTR_BCCYCLEGENERAL;
    public static final int ATTR_BCVZADISPLAY;
    public static final int ATTR_BCLIFETIPSDISPLAY;
    public static final int ATTR_BCCONSUMERDISPLAY;
    public static final int ATTR_BCTANKLEVEL1;
    public static final int ATTR_BCTANKLEVEL2;
    public static final int ATTR_BCREFUELVOLUME1;
    public static final int ATTR_BCREFUELVOLUME2;
    public static final int ATTR_BCMENUE1CONFIG;
    public static final int ATTR_BCMENUE2CONFIG;
    public static final int ATTR_BCMENUE3CONFIG;
    public static final int ATTR_BCOILTEMPERATURE;
    public static final int ATTR_BCDIGITALSPEED;
    public static final int ATTR_BCSTOPWATCH;
    public static final int ATTR_BCSPEEDWARNING;
    public static final int ATTR_BCGEARRECOMMENDATION;
    public static final int ATTR_BCREARSEATBELTWARNING;
    public static final int ATTR_HUDVIEWOPTIONS;
    public static final int ATTR_HUDHEIGHTADJUSTMENT;
    public static final int ATTR_HUDBRIGHTNESS;
    public static final int ATTR_HUDCONTENT;
    public static final int ATTR_BCVEHICLESTATELISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_COMPASSINFO;
    public static final int ATTR_BCVZAMFA;
    public static final int ATTR_HUDINFO;
    public static final int ATTR_BCSTATISTICSCONFIG;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODZE;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODRE;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODAC2;
    public static final int ATTR_BCSTATISTICSTIMECURRENTPERIODAC1;
    public static final int ATTR_BCSTATISTICSTIMEZE;
    public static final int ATTR_BCSTATISTICSTIMERE;
    public static final int ATTR_BCSTATISTICSTIMEAC2;
    public static final int ATTR_BCSTATISTICSTIMEAC1;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALZE;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALRE;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALAC2;
    public static final int ATTR_BCSTATISTICSDISTANCECURRENTINTERVALAC1;
    public static final int ATTR_BCSTATISTICSDISTANCEZE;
    public static final int ATTR_BCSTATISTICSDISTANCERE;
    public static final int ATTR_BCSTATISTICSDISTANCEAC2;
    public static final int ATTR_BCSTATISTICSDISTANCEAC1;
    public static final int ATTR_BCCOMFORTPOWERCONSUMPTION;
    public static final int ATTR_BCCOOLANTTEMPERATURE;
    public static final int ATTR_BCOILTEMPERATUREVALUE;
    public static final int ATTR_BCOUTSIDETEMPERATURE;
    public static final int ATTR_HUDROTATIONADJUSTMENT;
    public static final int ATTR_BCSTATISTICDISTANCEEUKM;
    public static final int ATTR_BCSTATISTICDISTANCEEUMLS;
    public static final int ATTR_BCTOTALCURRENTRANGE;
    public static final int ATTR_BCZEROEMISSIONDISTANCEST;
    public static final int ATTR_BCZEROEMISSIONTIMEST;
    public static final int ATTR_BCZEROEMISSIONDISTANCELT;
    public static final int ATTR_BCZEROEMISSIONTIMELT;
    public static final int ATTR_BCZEROEMISSIONDISTANCECY;
    public static final int ATTR_BCZEROEMISSIONTIMECY;
    public static final int ATTR_BCMAXVALUES;
    public static final int ATTR_BCRESETTIMESTAMPST;
    public static final int ATTR_BCRESETTIMESTAMPLT;
    public static final int ATTR_BCRESETTIMESTAMPCY;
    public static final int ATTR_HUDSYSTEMONOFF;
    public static final int ATTR_HUDCOLOUR;
    public static final int ATTR_DCVIEWOPTIONS;
    public static final int ATTR_DCBRIGHTNESS;
    public static final int ATTR_DCVOLUME;
    public static final int ATTR_DCELEMENTCONTENTSELECTIONLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_DCDISPLAY1SETUP;
    public static final int ATTR_DCDISPLAY2SETUP;
    public static final int ATTR_DCDISPLAY3SETUP;
    public static final int ATTR_DCDISPLAY1MAINSELECTION;
    public static final int ATTR_DCDISPLAY2MAINSELECTION;
    public static final int ATTR_DCDISPLAY3MAINSELECTION;
    public static final int ATTR_DCELEMENTCONTENTSELECTIONLISTUPDATEINFO;
    public static final int ATTR_DCADDITIONALINSTRUMENTSETUP;
    public static final int ATTR_BCASTAMFA;
    public static final int ATTR_DCADDITIONALINSTRUMENT2SETUP;
    public static final int ATTR_DCDISPLAYPRESETSLISTTOTALNUMBEROFELEMENTS;
    public static final int ATTR_DCDISPLAYPRESETSLISTUPDATEINFO;
    public static final int ATTR_DCDISPLAYDEPENDENCYSETUP;
    public static final int ATTR_DCACTIVEDISPLAYPRESET;
    public static final int ATTR_DCDISPLAYVIEWCONFIGURATION;
    public static final int ATTR_HUDLICENSE;
    public static final int ATTR_DCLEDCONFIGURATION;
    public static final int RT_RESETSIAVALUE;
    public static final int RT_REQUESTSIAHISTORYLIST;
    public static final int RT_SETSIADISTANCEOILUSER;
    public static final int RT_SETSIADISTANCEAIRFILTERUSER;
    public static final int RT_SETSIADISTANCEOILFILTERUSER;
    public static final int RT_SETSIAINSPECTIONDISTANCEUSER;
    public static final int RT_SETBCVZADISPLAY;
    public static final int RT_SETBCLIFETIPSDISPLAY;
    public static final int RT_SETBCCONSUMERDISPLAY;
    public static final int RT_SETBCMENUECONFIG;
    public static final int RT_RESETBCMENUE;
    public static final int RT_SETBCOILTEMPERATURE;
    public static final int RT_SETBCDIGITALSPEED;
    public static final int RT_SETBCSTOPWATCH;
    public static final int RT_SETBCSPEEDWARNING;
    public static final int RT_SETBCGEARRECOMMENDATION;
    public static final int RT_SETBCREARSEATBELTWARNING;
    public static final int RT_SETHUDHEIGHTADJUSTMENT;
    public static final int RT_SETHUDBRIGHTNESS;
    public static final int RT_SETHUDCONTENT;
    public static final int RT_SETBCSETFACTORYDEFAULT;
    public static final int RT_REQUESTVEHICLESTATELIST;
    public static final int RT_RESETBCSTATISTICS;
    public static final int RT_SETBCVZAMFA;
    public static final int RT_SETHUDROTATIONADJUSTMENT;
    public static final int RT_SETHUDCOLOUR;
    public static final int RT_SETHUDSETFACTORYDEFAULT;
    public static final int RT_SETHUDSYSTEMONOFF;
    public static final int RT_SETDCSETFACTORYDEFAULT;
    public static final int RT_SETDCBRIGHTNESS;
    public static final int RT_SETDCVOLUME;
    public static final int RT_SETDCDISPLAY1MAINSELECTION;
    public static final int RT_SETDCDISPLAY2MAINSELECTION;
    public static final int RT_SETDCDISPLAY3MAINSELECTION;
    public static final int RT_SETDCELEMENTCONTENTSELECTIONLISTRA1;
    public static final int RT_SETDCELEMENTCONTENTSELECTIONLISTRA2;
    public static final int RT_SETDCELEMENTCONTENTSELECTIONLISTRAF;
    public static final int RT_REQUESTDCELEMENTCONTENTSELECTIONLIST;
    public static final int RT_SETDCADDITIONALINSTRUMENTSETUP;
    public static final int RT_SETBCASTAMFA;
    public static final int RT_SETDCADDITIONALINSTRUMENT2SETUP;
    public static final int RT_SETDCDISPLAYDEPENDENCYSETUP;
    public static final int RT_SETDCACTIVEDISPLAYPRESET;
    public static final int RT_SETDCDISPLAYVIEWCONFIGURATION;
    public static final int RT_SETHUDLICENSE;
    public static final int RT_REQUESTDCDISPLAYPRESETSLIST;
    public static final int RT_SETDCDISPLAYPRESETSLIST;
    public static final int RT_SETDCLEDCONFIGURATION;
    public static final int RP_INDICATEENDOFSIARESET;
    public static final int RP_INDICATEENDOFBCMENURESET;
    public static final int RP_ACKNOWLEDGEBCSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEHUDSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGEDCSETFACTORYDEFAULT;
    public static final int IN_RESPONSEVEHICLESTATELISTWARNINGIDDYNVALUEALTERNATIVETEXT;
    public static final int IN_RESPONSEVEHICLESTATELISTWARNINGIDDYNVALUE;
    public static final int IN_RESPONSEVEHICLESTATELISTALTERNATIVETEXT;
    public static final int IN_RESPONSEVEHICLESTATELISTDYNVALUE;
    public static final int RP_ACKNOWLEDGEBCSTATISTICSRESET;
    public static final int IN_RESPONSEVEHICLESTATEUPDATEINFO;
    public static final int IN_RESPONSEVEHICLESTATELISTPOS;
    public static final int IN_RESPONSEDCELEMENTCONTENTSELECTIONLISTRAF;
    public static final int IN_RESPONSEDCELEMENTCONTENTSELECTIONLISTRA1;
    public static final int IN_RESPONSEDCELEMENTCONTENTSELECTIONLISTRA2;
    public static final int IN_RESPONSEDCDISPLAYPRESETSLIST;
    public static final int IN_RESPONSESIAHISTORYLIST;
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

    default public void resetSIAValue(int n) {
    }

    default public void requestSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
    }

    default public void setSIADistanceOilUser(int n, int n2) {
    }

    default public void setSIADistanceAirFilterUser(int n, int n2) {
    }

    default public void setSIADistanceOilFilterUser(int n, int n2) {
    }

    default public void setSIAInspectionDistanceUser(int n, int n2) {
    }

    default public void setBCVZADisplay(boolean bl) {
    }

    default public void setBCLifeTipsDisplay(boolean bl) {
    }

    default public void setBCConsumerDisplay(boolean bl) {
    }

    default public void setBCMenueConfig(BCMenueConfiguration bCMenueConfiguration, int n) {
    }

    default public void resetBCMenue(int n) {
    }

    default public void setBCOilTemperature(boolean bl) {
    }

    default public void setBCDigitalSpeed(boolean bl) {
    }

    default public void setBCStopwatch(boolean bl) {
    }

    default public void setBCVzaMFA(boolean bl) {
    }

    default public void setBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
    }

    default public void setBCGearRecommendation(boolean bl) {
    }

    default public void setBCRearSeatbeltWarning(boolean bl) {
    }

    default public void requestVehicleStateList(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
    }

    default public void setBcSetFactoryDefault() {
    }

    default public void resetBCStatistics(BCStatisticsReset bCStatisticsReset) {
    }

    default public void setBCAstaMFA(boolean bl) {
    }

    default public void setHUDHeightAdjustment(byte by) {
    }

    default public void setHUDBrightness(byte by) {
    }

    default public void setHUDContent(HUDContent hUDContent) {
    }

    default public void setHUDRotationAdjustment(int n) {
    }

    default public void setHUDColour(int n, int n2) {
    }

    default public void setHUDSetFactoryDefault() {
    }

    default public void setHUDSystemOnOff(boolean bl) {
    }

    default public void setDCSetFactoryDefault() {
    }

    default public void setDCBrightness(int n) {
    }

    default public void setDCVolume(int n) {
    }

    default public void setDCDisplay1MainSelection(DCMainItems dCMainItems) {
    }

    default public void setDCDisplay2MainSelection(DCMainItems dCMainItems) {
    }

    default public void setDCDisplay3MainSelection(DCMainItems dCMainItems) {
    }

    default public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
    }

    default public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
    }

    default public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
    }

    default public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
    }

    default public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument) {
    }

    default public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2) {
    }

    default public void requestDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
    }

    default public void setDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
    }

    default public void setDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency) {
    }

    default public void setDCActiveDisplayPreset(int n) {
    }

    default public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration) {
    }

    default public void setHUDLicense(boolean bl) {
    }

    default public void setDCLEDConfiguration(boolean bl) {
    }
}

