/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public interface DSINavigation
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AFAMODE;
    public static final int ATTR_AFASPEAKING;
    public static final int ATTR_ETCDEMOMODESTATE;
    public static final int ATTR_ETCLANGUAGELOADPROGRESS;
    public static final int ATTR_ETCLANGUAGELOADSTATUS;
    public static final int ATTR_ETCMETRICSYSTEM;
    public static final int ATTR_DMLASTDESTINATIONSLIST;
    public static final int ATTR_DMRECENTROUTESLIST;
    public static final int ATTR_LISPISSPELLERACTIVE;
    public static final int ATTR_RGACTIVE;
    public static final int ATTR_RGCURRENTROUTE;
    public static final int ATTR_RGCURRENTROUTEOPTIONS;
    public static final int ATTR_RGLANEGUIDANCE;
    public static final int ATTR_RGTURNTOSTREET;
    public static final int ATTR_RGUNFULFILLEDROUTEOPTIONS;
    public static final int ATTR_RGDESTINATIONINFO;
    public static final int ATTR_RGSTREETLIST;
    public static final int ATTR_RGPOIINFO;
    public static final int ATTR_SOPOSPOSITION;
    public static final int ATTR_SOPOSPOSITIONDESCRIPTION;
    public static final int ATTR_RRDACTIVE;
    public static final int ATTR_RRDCALCULATIONINFO;
    public static final int ATTR_ETCVERSIONINFO;
    public static final int ATTR_RGDETAILEDSTREETLIST;
    public static final int ATTR_RMPERSISTENTROUTE;
    public static final int ATTR_RGTIMEAFATODESTINATION;
    public static final int ATTR_RGCALCULATEDROUTES;
    public static final int ATTR_RGROUTECOSTCHANGEINFORMATION;
    public static final int ATTR_TRMEMORYUTILIZATION;
    public static final int ATTR_TROPERATINGMODE;
    public static final int ATTR_TRTRACELIST;
    public static final int ATTR_RMROUTELIST;
    public static final int ATTR_RGROUTECALCULATIONSTATE;
    public static final int ATTR_NAVSTATEOFOPERATION;
    public static final int ATTR_NAVMEDIA;
    public static final int ATTR_RGTURNLIST;
    public static final int ATTR_AVAILABLELANGUAGES;
    public static final int ATTR_LANGUAGE;
    public static final int ATTR_DISTANCETONEXTMANEUVER;
    public static final int ATTR_TRDIRECTIONTOWAYPOINT;
    public static final int ATTR_POISUBSTRINGSEARCHSTATUS;
    public static final int ATTR_TRRECORDINGSTATE;
    public static final int ATTR_DMFLAGDESTINATION;
    public static final int ATTR_LICITYHISTORY;
    public static final int ATTR_LICOUNTRYFORCITYANDSTREETHISTORY;
    public static final int ATTR_LISTREETHISTORY;
    public static final int ATTR_RGTURNLISTCALCULATIONHORIZON;
    public static final int ATTR_RGPOIINFOCALCULATIONHORIZON;
    public static final int ATTR_RGINFOFORNEXTDESTINATION;
    public static final int ATTR_BAPMANEUVERDESCRIPTOR;
    public static final int ATTR_RGROUTEPROPERTIES;
    public static final int ATTR_ETCCURRENTNAVDATABASE;
    public static final int ATTR_ETCAVAILABLENAVDATABASES;
    public static final int ATTR_AUDIOREQUEST;
    public static final int ATTR_LITHESAURUSHISTORY;
    public static final int ATTR_COUNTRYINFO;
    public static final int ATTR_BAPTURNTOINFO;
    public static final int ATTR_RGISTRING;
    public static final int ATTR_STYLEDBPATHS;
    public static final int ATTR_ROUTERESUMEPOSSIBLE;
    public static final int ATTR_POISENTERINGPROXIMITYRANGE;
    public static final int ATTR_ETCAVAILABLEPERSONALPOIDATABASES;
    public static final int ATTR_PERSONALPOISEARCHSTATUS;
    public static final int ATTR_LISTATEHISTORY;
    public static final int ATTR_NAVDBREGIONSSTATE;
    public static final int ATTR_TRINFOFORNEXTWAYPOINT;
    public static final int ATTR_RGENHANCEDSIGNPOSTINFOSTATUS;
    public static final int ATTR_SOPOSTIMEINFORMATION;
    public static final int ATTR_RGVIRTUALDESTINATIONINFO;
    public static final int ATTR_RGMOTORWAYINFO;
    public static final int ATTR_RGTURNTOINFO;
    public static final int ATTR_RGPERSISTEDROUTEDATAAVAILABLE;
    public static final int ATTR_MAPINTEGRATIONSTATE;
    public static final int ATTR_MAPINTEGRATIONPROGRESS;
    public static final int ATTR_BAPMANEUVERSTATE;
    public static final int ATTR_RMIMPORTTOURSFROMGPXFILESTATUS;
    public static final int ATTR_BAPMANEUVERINFORMATION;
    public static final int ATTR_PROFILESTATE;
    public static final int STARTRGRETURNCODE_NOTPOSSIBLE;
    public static final int STARTRGRETURNCODE_OK;
    public static final int NAVLANLOADSTATUS_NLS_IDLE;
    public static final int NAVLANLOADSTATUS_NLS_LOADING;
    public static final int NAVLANLOADSTATUS_NLS_SUCCEEDED;
    public static final int NAVLANLOADSTATUS_NLS_FAILED;
    public static final int AFAMODE_AFAMODE_OFF;
    public static final int AFAMODE_AFAMODE_CURRENTGUIDANCEOFF;
    public static final int AFAMODE_AFAMODE_ON;
    public static final int SELCRITDES_RESERVED;
    public static final int SELCRITDES_COUNTRY;
    public static final int SELCRITDES_TOWN;
    public static final int SELCRITDES_STREET;
    public static final int SELCRITDES_JUNCTION;
    public static final int SELCRITDES_HOUSENUMBER;
    public static final int SELCRITDES_ZIP_CODE;
    public static final int SELCRITDES_TELEPHONENUMBER;
    public static final int SELCRITDES_TOWNCENTER;
    public static final int SELCRITDES_ROAD_DISTANCE;
    public static final int SELCRITDES_NAVIGATION_INTERNAL_DATA;
    public static final int SELCRITDES_AIR_DISTANCE;
    public static final int SELCRITDES_GEOGRAPHICAL_POSITION;
    public static final int SELCRITDES_REFINEBYADDITONALCRITERIA;
    public static final int SELCRITDES_REFINEBYINCLUSION;
    public static final int SELCRITDES_REFINEBYASSOCIATION;
    public static final int SELCRITDES_COUNTRYABBREVIATION;
    public static final int SELCRITDES_SEGMENTID;
    public static final int SELCRITDES_SUBICONINDEX;
    public static final int SELCRITDES_ICONINDEX;
    public static final int SELCRITDES_MMI_INTERNAL_DATA;
    public static final int SELCRITDES_POI_INDEX;
    public static final int SELCRITDES_XAC_POI;
    public static final int SELCRITDES_XAC_POI_MAX;
    public static final int SELCRITDES_INDEX_TYPE;
    public static final int SELCRITDES_INDEX_VALUE;
    public static final int SELCRITDES_POI_INDEX_NAME;
    public static final int SELCRITDES_POI_INDEX_TYPE;
    public static final int SELCRITDES_POI;
    public static final int SELCRITDES_POI_BY_CLASS;
    public static final int SELCRITDES_POI_BY_CATEGORY;
    public static final int SELCRITDES_POI_BY_NAME;
    public static final int SELCRITDES_POI_BY_CHILD;
    public static final int SELCRITDES_POI_BY_CHILD_CLASS;
    public static final int SELCRITDES_POI_BY_CHILD_CATEGORY;
    public static final int SELCRITDES_POI_BY_CHILD_NAME;
    public static final int SELCRITDES_POI_BY_PHONE;
    public static final int SELCRITDES_POI_BY_TOP_POI;
    public static final int SELCRITDES_POI_BY_SUBSTRING;
    public static final int SELCRITDES_POI_BY_THESAURUS;
    public static final int SELCRITDES_POI_BY_PARENT_POI;
    public static final int SELCRITDES_POI_BY_STACK;
    public static final int SELCRITDES_STREET_FIRST;
    public static final int SELCRITDES_POI_CATEGORY_BY_UID;
    public static final int SELCRITDES_POI_ADDITIONAL_FLAGS;
    public static final int SELCRITDES_POI_MULTISUBSTRING;
    public static final int SELCRITDES_POI_FROMPOIINFO;
    public static final int SELCRITDES_MAX;
    public static final int SELCRITDES_SSPVDE_ADMINID;
    public static final int SELCRITDES_SSPVDE_CLUSTERID;
    public static final int SELCRITDES_SSPVDE_EXPORTZONE;
    public static final int SELCRITDES_URLADDRESS;
    public static final int SELCRITDES_COUNTRIES_WITH_VIGNETTE;
    public static final int SELCRITDES_CITIES_WITH_VIGNETTE;
    public static final int SELCRITDES_VIAPOINTS;
    public static final int SELCRITDES_LICENSEPLATE_CODE;
    public static final int SELCRITDES_VIAPOINTCOUNTRYLIST;
    public static final int SELCRITDES_HOUSENUMBER_FREETEXT;
    public static final int SELCRITDES_HOUSENUMBER_ALTERNATIVES;
    public static final int SELCRITDES_TOWN_AND_ZIP;
    public static final int SELCRITDES_STATE;
    public static final int SELCRITDES_COUNTRY_STATE;
    public static final int SELCRITDES_HOUSENUMBER_EXTENDED_ALTERNATIVES;
    public static final int SELCRITDES_STREET_FULLNAME;
    public static final int SELCRITDES_MAPCODE;
    public static final int SELCRITDES_DISTRICT;
    public static final int SELCRITDES_CHOME;
    public static final int SELCRITDES_TOWN_WITHOUTDISTRICT;
    public static final int SELCRITDES_POI_BY_BUILDING;
    public static final int SELCRITDES_PLACENAME;
    public static final int SELCRITDES_SUBMUNICIPALTOWN;
    public static final int SELCRITDES_VILLAGE;
    public static final int SELCRITDES_SUBMUNICIPALTOWN_AND_STREET;
    public static final int SELCRITDES_VILLAGE_AND_STREET;
    public static final int SELCRITDES_WARD;
    public static final int SELCRITDES_POI_BY_TPEG;
    public static final int SELCRITDES_HOUSENUMBER_BYSDS;
    public static final int ISLIT_ATTR_UNKNOWN;
    public static final int ISLIT_ATTR_NAME;
    public static final int ISLIT_ATTR_TYPE;
    public static final int ISLIT_ATTR_SUBTYPE;
    public static final int ISLIT_ATTR_COUNTRY;
    public static final int ISLIT_ATTR_CITYNAME;
    public static final int ISLIT_ATTR_HOUSENUMBER;
    public static final int ISLIT_ATTR_STREET;
    public static final int ISLIT_ATTR_POSTALAREA;
    public static final int ISLIT_ATTR_PHONENUMBER;
    public static final int ISLIT_ATTR_FAXNUMBER;
    public static final int ISLIT_ATTR_BRAND;
    public static final int ISLIT_ATTR_TOCOUNTRY;
    public static final int ISLIT_ATTR_FOODTYPE;
    public static final int ISLIT_ATTR_PARKINGTYPE;
    public static final int ISLIT_ATTR_SPECIAL;
    public static final int ISLIT_ATTR_GEOPOS;
    public static final int ISLIT_ATTR_TOCOUNTRYID;
    public static final int ISLIT_ATTR_ONAME;
    public static final int ISLIT_ATTR_PREMIUMTYPE;
    public static final int ISLIT_ATTR_SUPERTYPE;
    public static final int ISLIT_ATTR_ROUTEPATCHEDGEOPOS;
    public static final int ISLIT_ATTR_HTMLFILEREFERENCE;
    public static final int ISLIT_NUMBEROFATTRS;
    public static final int ISLIT_ATTR_GEOPOS_NVC;
    public static final int ISLIT_ATTR_GEOPOS_MULTISUBSTRING;
    public static final int ISLIT_ATTR_ALTROTATIONBIT;
    public static final int DATATYPE_NODATA;
    public static final int DATATYPE_STRING;
    public static final int DATATYPE_U8;
    public static final int DATATYPE_S8;
    public static final int DATATYPE_U16;
    public static final int DATATYPE_S16;
    public static final int DATATYPE_U32;
    public static final int DATATYPE_S32;
    public static final int DATATYPE_E8;
    public static final int DATATYPE_B8;
    public static final int DATATYPE_S16_LENGTH10M;
    public static final int DATATYPE_S16_LENGTH100M;
    public static final int DATATYPE_CLOCKTIME;
    public static final int DATATYPE_DATE;
    public static final int DATATYPE_S16_TIMEMINUTES;
    public static final int DATATYPE_S16_SPEEDCMS;
    public static final int DATATYPE_U8_DIRECTIONABSOLUTE;
    public static final int DATATYPE_U8_DIRECTIONRELATIVE;
    public static final int DATATYPE_POSITIONWGS84;
    public static final int DATATYPE_LOCATIONDESCRIPTION;
    public static final int DATATYPE_S32_LENGTH10M;
    public static final int DATATYPE_CONTAINER;
    public static final int DATATYPE_B16;
    public static final int DATATYPE_OLDCONTAINER;
    public static final int ROUTEDESTINATIONTYPE_RESERVED;
    public static final int ROUTEDESTINATIONTYPE_HARDDESTINATION;
    public static final int ROUTEDESTINATIONTYPE_SOFTDESTINATION;
    public static final int ROUTEDESTINATIONTYPE_WAYPOINT;
    public static final int METRICSYSTEM_RESERVED;
    public static final int METRICSYSTEM_DEFAULT;
    public static final int METRICSYSTEM_KILOMETERS_METERS;
    public static final int METRICSYSTEM_IMPERIAL_GB_MILES_YARDS;
    public static final int METRICSYSTEM_IMPERIAL_US_MILES_FEET;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CENTER;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_FOR_COUNTRY;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_COUNTRY;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_HOUSENR;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_LASTDEST;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_CITY;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_ZIP;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_POI;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_JUNCTION;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_POI_TYPE;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_POI_VALUE;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_VICINITY;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_AND_STREET;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_COUNTRY;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_FOR_STREET;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STATE;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_FOR_STATE;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_STATE;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_HOUSENUMBER_FOR_STATE;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_HOUSENUMBER_FOR_COUNTRY;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_DISTRICT;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CHOME;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_DISTRICT;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_SUBMUNICIPALTOWN;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_SUBMUNICIPALTOWN;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_PLACENAME;
    public static final int ICONTYPE_ROAD;
    public static final int ICONTYPE_POI;
    public static final int ICONTYPE_TMC_EVENT;
    public static final int ICONTYPE_ROAD_CLASS;
    public static final int ICONTYPE_TRAFFIC_REGULATION;
    public static final int ICONTYPE_TARGET;
    public static final int ICONTYPE_ROADSEGMENT_PROPERTY;
    public static final int INPUTTYPE_FULL_WORD;
    public static final int INPUTTYPE_SPELLING;
    public static final int FILESTATUS_FILE_STATUS_AVAILABLE;
    public static final int FILESTATUS_FILE_STATUS_PROVIDING_NOT_FINISHED;
    public static final int POIMODE_CURRENT_POSITION;
    public static final int POIMODE_NATIONWIDE;
    public static final int POIMODE_ON_ROUTE;
    public static final int POIMODE_OTHER_TOWN;
    public static final int POIMODE_POI_PHONE_NUMBER;
    public static final int POIMODE_POI_SHORTCUT;
    public static final int POIMODE_STOPOVER_POSITION;
    public static final int POIMODE_TARGET_POSITION;
    public static final int POILISTSTYLE_DEFAULT;
    public static final int POILISTSTYLE_FLAT;
    public static final int POILISTSTYLE_HIERARCHICAL;
    public static final int DESTINATIONSET_AMBIGUOUS;
    public static final int DESTINATIONSET_NOT_AMBIGUOUS;
    public static final int DESTINATIONSET_INVALID;
    public static final int ITEMCHECK_ITEM_CHECK_AMBIGUOUS;
    public static final int ITEMCHECK_ITEM_CHECK_HIERARCHICAL;
    public static final int ITEMCHECK_ITEM_CHECK_NOTAMBIGUOUS;
    public static final int ITEMCHECK_ITEM_CHECK_NOTVALID;
    public static final int ITEMCHECK_ITEM_CHECK_INVALIDVALUE;
    public static final int LIVALUELISTOUTPUTMETHOD_DSI;
    public static final int LIVALUELISTFILESTATUS_COMPLETE;
    public static final int LIVALUELISTFILESTATUS_ERROR;
    public static final int LIVALUELISTFILETYPE_DYNAMIC;
    public static final int LIVALUELISTFILETYPE_STATIC;
    public static final int MANEUVERELEMENTELEMENT_NOSYMBOL;
    public static final int MANEUVERELEMENTELEMENT_NOINFO;
    public static final int MANEUVERELEMENTELEMENT_DIRECTIONTODESTINATION;
    public static final int MANEUVERELEMENTELEMENT_ARRIVED;
    public static final int MANEUVERELEMENTELEMENT_NEARDESTINATION;
    public static final int MANEUVERELEMENTELEMENT_ARRIVEDDESTINATIONOFFROAD;
    public static final int MANEUVERELEMENTELEMENT_OFFROAD;
    public static final int MANEUVERELEMENTELEMENT_OFFMAP;
    public static final int MANEUVERELEMENTELEMENT_NOROUTE;
    public static final int MANEUVERELEMENTELEMENT_CALCROUTE;
    public static final int MANEUVERELEMENTELEMENT_RECALCROUTE;
    public static final int MANEUVERELEMENTELEMENT_FOLLOWSTREET;
    public static final int MANEUVERELEMENTELEMENT_CHANGELANE;
    public static final int MANEUVERELEMENTELEMENT_TURN;
    public static final int MANEUVERELEMENTELEMENT_TURNONMAINROAD;
    public static final int MANEUVERELEMENTELEMENT_EXITRIGHT;
    public static final int MANEUVERELEMENTELEMENT_EXITLEFT;
    public static final int MANEUVERELEMENTELEMENT_SERVICEROADRIGHT;
    public static final int MANEUVERELEMENTELEMENT_SERVICEROADLEFT;
    public static final int MANEUVERELEMENTELEMENT_FORK2;
    public static final int MANEUVERELEMENTELEMENT_FORK3;
    public static final int MANEUVERELEMENTELEMENT_ROUNDABOUTTRSRIGHT;
    public static final int MANEUVERELEMENTELEMENT_ROUNDABOUTTRSLEFT;
    public static final int MANEUVERELEMENTELEMENT_SQUARETRSRIGHT;
    public static final int MANEUVERELEMENTELEMENT_SQUARETRSLEFT;
    public static final int MANEUVERELEMENTELEMENT_UTURN;
    public static final int MANEUVERELEMENTELEMENT_EXITROUNDABOUTTRSRIGHT;
    public static final int MANEUVERELEMENTELEMENT_EXITROUNDABOUTTRSLEFT;
    public static final int MANEUVERELEMENTELEMENT_PREPARETURN;
    public static final int MANEUVERELEMENTELEMENT_PREPAREROUNDABOUT;
    public static final int MANEUVERELEMENTELEMENT_PREPARESQUARE;
    public static final int MANEUVERELEMENTELEMENT_PREPAREUTURN;
    public static final int MANEUVERELEMENTELEMENT_EXITRIGHTRAMPUP;
    public static final int MANEUVERELEMENTELEMENT_EXITRIGHTRAMPDOWN;
    public static final int MANEUVERELEMENTELEMENT_MICHIGANTURN;
    public static final int MANEUVERELEMENTELEMENT_DOUBLETURN;
    public static final int MANEUVERELEMENTELEMENT_EXITLEFTRAMPUP;
    public static final int MANEUVERELEMENTELEMENT_EXITLEFTRAMPDOWN;
    public static final int MANEUVERELEMENTELEMENT_DIRECTIONTOWAYPOINT;
    public static final int MANEUVERELEMENTELEMENT_SIDESTREET;
    public static final int MANEUVERELEMENTELEMENT_PROHIBITEDSIDESTREET;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_TRAFFICINFORMATION_CAUSING_DELAY;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_TRAFFICINFORMATION_NOT_CAUSING_DELAY;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_VIGNETTE_OBLIGATION;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_TOLL_OBLIGATION;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_LOW_PETROL_LEVEL;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_BORDER_CROSSING;
    public static final int MANEUVERELEMENTELEMENT_START_HOV_LANE;
    public static final int MANEUVERELEMENTELEMENT_LEAVE_HOV_LANE;
    public static final int MANEUVERELEMENTELEMENT_BORDER_CROSSING;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_ONTO_FERRY;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_OFF_FERRY;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_ONTO_CARTRAIN;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_OFF_CARTRAIN;
    public static final int MANEUVERELEMENTATTRIBUTE_ENTRYSTREET;
    public static final int MANEUVERELEMENTATTRIBUTE_SINGLECARRIAGE;
    public static final int MANEUVERELEMENTATTRIBUTE_MULTICARRIAGE;
    public static final int MANEUVERELEMENTATTRIBUTE_ABSTRACT_MTWY_EXIT;
    public static final int MANEUVERELEMENTATTRIBUTE_ABSTRACT_MANEUVER_MTWY_CHANGE;
    public static final int MANEUVERELEMENTATTRIBUTE_AUDIBLE;
    public static final int CRITERIANUMBER_CLASS_PPOI;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RESTAREA_WC;
    public static final int CRITERIANUMBER_CLASS_PARK_AND_REFUEL;
    public static final int CRITERIANUMBER_CATEGORY_PETROLSTATION;
    public static final int CRITERIANUMBER_CATEGORY_MOTORWAYEXIT;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PETROLSTATION;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PARKINGLOT;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RESTSTOP;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RESTAURANT;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_HOTEL;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_AUDISERVICE;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RAILROADSTATION;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_AIRPORT;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_HOSPITAL;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_VW_SERVICE;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_BENTLEY_SERVICE;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PORSCHE_SERVICE;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_CONVENIENCE_STORE;
    public static final int CRITERIANUMBER_CLASS_PARKING;
    public static final int CRITERIANUMBER_CLASS_REFUEL;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PETROLSTATION_DIESEL_NAR;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_POLICE_NAR;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_ATM_NAR;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_COFFEESHOP_NAR;
    public static final int CRITERIANUMBER_CATEGORY_SPEEDCAMERA;
    public static final int CRITERIANUMBER_CATEGORY_OTHERCAMERA;
    public static final int CRITERIANUMBER_CATEGORY_CHARGINGSTATION_FAST;
    public static final int CRITERIANUMBER_CATEGORY_CHARGINGSTATION_NORMAL;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_CHARGINGSTATION;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_CNGSTATION;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_LPGSTATION;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_HYDROGENSTATION;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_E100ETHANOLSTATION;
    public static final int CRITERIANUMBER_CATEGORY_PPOI_CHARGINGSTATION_FAST;
    public static final int CRITERIANUMBER_CATEGORY_PPOI_CHARGINGSTATION_NORMAL;
    public static final int TBMSTATE_OK;
    public static final int TBMSTATE_UNKNOWN;
    public static final int TBMSTATE_MISSING;
    public static final int TBMSTATE_AMBIGIOUS;
    public static final int TBMSTATE_INCONSISTENT;
    public static final int TBMSTATE_INCOMPLETE;
    public static final int GUIDANCE_MODE_COMPACT;
    public static final int GUIDANCE_MODE_COMPLETE;
    public static final int GUIDANCE_MODE_TRAFFIC;
    public static final int GUIDANCE_MODE_OFF;
    public static final int TRACERECORDINGMODE_DELETESTART;
    public static final int TRACERECORDINGMODE_RESUMESTART;
    public static final int NAVRESULTCODE_OK;
    public static final int NAVRESULTCODE_NOT_OPERABLE;
    public static final int NAVRESULTCODE_ERROR;
    public static final int NAVRESULTCODE_UNSUPPORTED;
    public static final int TRACEERROR_NOERROR;
    public static final int TRACEERROR_COMMUNICATION;
    public static final int TRACEERROR_WRONGTRACEID;
    public static final int TRACEERROR_NOTRACEMEMORY;
    public static final int TRACEOPERATINGMODE_DEFAULT;
    public static final int TRACEOPERATINGMODE_AUTOMATIC;
    public static final int TRACEOPERATINGMODE_EQUIDISTANT;
    public static final int TRACEOPERATINGMODE_DISABLE;
    public static final int RMID_WAYPOINTROUTES;
    public static final int RMID_ROUTEPLAN;
    public static final int RMID_PRESSROUTES;
    public static final int ROUTECALCULATIONSTATE_IDLE;
    public static final int ROUTECALCULATIONSTATE_CALCULATING;
    public static final int ROUTECALCULATIONSTATE_READY;
    public static final int ROUTECALCULATIONSTATE_RUBBERBANDREADY;
    public static final int AFAREPEATSOURCE_NAV_INFO_REPEAT;
    public static final int AFAREPEATSOURCE_MFL_REPEAT;
    public static final int AFAREPEATSOURCE_SDS_REPEAT;
    public static final int AFAREPEATSOURCE_ANNOUNCE_SELECT_ROUTE;
    public static final int AFAREPEATSOURCE_ANNOUNCE_BLOCKEDROUTE;
    public static final int AFAREPEATSOURCE_ANNOUNCE_MUCHBETTERROUTE;
    public static final int AFAREPEATSOURCE_ANNOUNCE_EMERGENCYEVENT;
    public static final int NAVSTATEOFOPERATION_UNKNOWN;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_NOT_ACTIVATED;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_DAMAGED;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_EJECT;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_DISKERROR;
    public static final int NAVSTATEOFOPERATION_FULLY_OPERABLE;
    public static final int NAVSTATEOFOPERATION_NOT_COMPATIBLE;
    public static final int NAVSTATEOFOPERATION_NOT_IDENTICAL_MEDIUM;
    public static final int NAVSTATEOFOPERATION_CHECKING_MEDIUM;
    public static final int NAVSTATEOFOPERATION_NO_COMPLETE_DATA;
    public static final int NAVSTATEOFOPERATION_REINITIALISATION;
    public static final int NAVSTATEOFOPERATION_LOCKED;
    public static final int NAVSTATEOFOPERATION_READY4NAV;
    public static final int NAVSTATEOFOPERATION_GLOVE_BOX_OPEN;
    public static final int NAVSTATEOFOPERATION_REINIT_CUSTOMERUPDATE;
    public static final int ADDITIONALFLAG_POI_24H;
    public static final int ADDITIONALFLAG_POI_3D;
    public static final int ADDITIONALFLAG_POI_PREMIUM;
    public static final int ADDITIONALFLAG_POI_DIESEL;
    public static final int ADDITIONALFLAG_ISSTREETBASENAME;
    public static final int ADDITIONALFLAG_POI_PAYBYCREDITCARD;
    public static final int ADDITIONALFLAG_POI_PARKINGPOSSIBLE;
    public static final int ADDITIONALFLAG_ISLOCATIONINCITYSTATE;
    public static final int ADDITIONALFLAG_IS_SPELLED_STATE;
    public static final int ADDITIONALFLAG_ISFULLPOSTALCODE;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_TOWNREFINEMENT;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_ZIPCODE;
    public static final int ADDITIONALFLAG_ISSPELLED_ZIPCODE;
    public static final int ADDITIONALFLAG_TOWNISORDER9;
    public static final int BOOLEANVALUE_UNDEFINED;
    public static final int BOOLEANVALUE_FALSE;
    public static final int BOOLEANVALUE_TRUE;
    public static final int ADDITIONALPOIATTRIBUTE_PROVIDER;
    public static final int ADDITIONALPOIATTRIBUTE_PAY;
    public static final int ADDITIONALPOIATTRIBUTE_SUBSCRIPTION;
    public static final int ADDITIONALPOIATTRIBUTE_ON_SITE_PAYMENT;
    public static final int ADDITIONALPOIATTRIBUTE_ACCESS;
    public static final int ADDITIONALPOIATTRIBUTE_OPEN_24_H;
    public static final int ADDITIONALPOIATTRIBUTE_ADDITIONALINFO;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_INVALID;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_PRIVATE;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_PUBLIC;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_SEMI_PRIVATE;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_SEMI_PUBLIC;
    public static final int CONNECTORATTRIBUTE_CHARGE_MODE;
    public static final int CONNECTORATTRIBUTE_CHARGE_LEVEL;
    public static final int CONNECTORATTRIBUTE_NAME;
    public static final int CONNECTORATTRIBUTE_TYPE;
    public static final int CONNECTORATTRIBUTE_FUSE_PROTECTION;
    public static final int CONNECTORATTRIBUTE_POWER_OUTPUT;
    public static final int CONNECTORATTRIBUTE_COUNT_AVAILABLE;
    public static final int CONNECTORATTRIBUTETYPE_UNSPECIFIED;
    public static final int CONNECTORATTRIBUTETYPE_DOMESTIC;
    public static final int CONNECTORATTRIBUTETYPE_TYPE_1;
    public static final int CONNECTORATTRIBUTETYPE_TYPE_2;
    public static final int CONNECTORATTRIBUTETYPE_COMBO_1;
    public static final int CONNECTORATTRIBUTETYPE_COMBO_2;
    public static final int CONNECTORATTRIBUTETYPE_CHADEMO;
    public static final int CONNECTORATTRIBUTETYPE_OTHER;
    public static final int POISORTORDER_NATURAL;
    public static final int POISORTORDER_ALPHABETICALLY;
    public static final int POISORTORDER_BY_DISTANCE;
    public static final int DESTINATIONSTATUS_AVAILABLE;
    public static final int DESTINATIONSTATUS_NAVIGABLE;
    public static final int DESTINATIONSTATUS_NOT_AVAILABLE;
    public static final int DESTINATIONSTATUS_NOT_DEFINED;
    public static final int DESTINATIONSTATUS_NOT_NAVIGABLE;
    public static final int CALCULATIONSTATE_NOT_CALCULATED;
    public static final int CALCULATIONSTATE_CALCULATING;
    public static final int CALCULATIONSTATE_PRELIMINARY_CALCULATED;
    public static final int CALCULATIONSTATE_CALCULATED;
    public static final int CALCULATIONSTATE_CALCULATION_FAILED;
    public static final int CALCULATIONSTATE_RGACTIVE;
    public static final int POISEARCHSTATUS_INVALID;
    public static final int POISEARCHSTATUS_CANCELED;
    public static final int POISEARCHSTATUS_RUNNING;
    public static final int POISEARCHSTATUS_FINISHED;
    public static final int ROUTEID_ONROAD;
    public static final int ROUTEID_WAYPOINT;
    public static final int ROUTEID_TRAIL;
    public static final int TRACERECORDINGSTATE_INVALID;
    public static final int TRACERECORDINGSTATE_IDLE;
    public static final int TRACERECORDINGSTATE_ACTIVE;
    public static final int TRACERECORDINGSTATE_BUFFER_FULL;
    public static final int ROUTECALCTYPE_FAST;
    public static final int ROUTECALCTYPE_SHORT;
    public static final int ROUTECALCTYPE_SCENIC_1;
    public static final int ROUTECALCTYPE_SCENIC_2;
    public static final int ROUTECALCTYPE_WAYPOINT;
    public static final int ROUTECALCTYPE_OPTIMAL;
    public static final int ROUTECALCTYPE_EFFICIENCY;
    public static final int ROUTECALCTYPE_ECOLOGICAL;
    public static final int ROUTECALCTYPE_ACTIVEROUTE;
    public static final int ROUTECALCTYPE_FAST_DYNAMIC;
    public static final int ROUTECALCTYPE_ECOLOGICAL_DYNAMIC;
    public static final int ROUTEOPTHYBRIDMODE_NO;
    public static final int ROUTEOPTHYBRIDMODE_MID;
    public static final int ROUTEOPTHYBRIDMODE_FULL;
    public static final int ROUTEOPTHYBRIDMODE_ECAR;
    public static final int ROUTEOPTSTATE_UNKNOWN;
    public static final int ROUTEOPTSTATE_IGNORE;
    public static final int ROUTEOPTSTATE_USE;
    public static final int ROUTEOPTSTATE_EXCLUDE;
    public static final int ROUTEOPTSTATE_AVOID;
    public static final int ROUTEOPTSTATE_PREFER;
    public static final int ROUTEOPTSTATE_AUTOMATIC;
    public static final int ROUTEOPTSTATE_ENABLE;
    public static final int ROUTEOPTSTATE_DISABLE;
    public static final int ROUTEOPTSTATE_EXCLUDE_EXCEPTLIST;
    public static final int ROUTEOPTSTATE_AVOID_EXCEPTLIST;
    public static final int ROUTEOPTSTATE_MANUAL;
    public static final int ROUTEOPTSTATE_MANUAL_TMC;
    public static final int ROUTEOPTTRAIL_OFF;
    public static final int ROUTEOPTTRAIL_FORWARD;
    public static final int ROUTEOPTTRAIL_FORWARD_ENTER;
    public static final int ROUTEOPTTRAIL_BACKWARD_ENTER;
    public static final int ROUTEOPTTRAIL_BACKWARD;
    public static final int ROUTEOPTWAY_ON;
    public static final int ROUTEOPTWAY_MAP_MATCHER_OFF;
    public static final int ROUTEOPTWAY_OFF;
    public static final int ROUTESTYLEID_DEFAULT;
    public static final int ROUTEOPTHOVLANES_DONT_USE;
    public static final int ROUTEOPTHOVLANES_USE_ALL;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_2;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_3;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_4;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_5;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_6;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_7;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_8;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_9;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_10;
    public static final int GPSSTATE_NOFIX;
    public static final int GPSSTATE_2DFIX;
    public static final int GPSSTATE_3DFIX;
    public static final int GPSSTATE_ANTENNA_NOT_CONNECTED;
    public static final int GPSSTATE_ERROR;
    public static final int RELIABILITY_BIT_CALIBRATED;
    public static final int RELIABILITY_BIT_MATCHED_TO_DIGITAL_MAP;
    public static final int RELIABILITY_BIT_INSIDE_DIGITIZED_AREA;
    public static final int NAV_GPS_TICKS_PER_DEGR;
    public static final int NAV_GPS_TICKS_PER_MIN;
    public static final int NAV_GPS_TICKS_PER_SEC;
    public static final int RGERROR_NOT_EXISTS;
    public static final int RGERROR_POS_AQUISITION;
    public static final int RGERROR_SYSTEM_ERROR;
    public static final int RGEXCEPTION_SPECIAL_ROADCLASS;
    public static final int RGEXCEPTION_ROUTE_CHANGED;
    public static final int RGEXCEPTION_ROUTE_CRITERIA;
    public static final int RGEXCEPTION_DESTINATION_INACCESSIBLE;
    public static final int LOCATIONTYPE_DEFAULT;
    public static final int LOCATIONTYPE_POI;
    public static final int LOCATIONTYPE_GEOGRAPHICAL_POSITION;
    public static final int LOCATIONTYPE_TRACEREFERENCE;
    public static final int LOCATIONTYPE_TPEGPOI;
    public static final int LATEST_VERSION_OF_LOCATION_STRUCTURE;
    public static final int AUDIOMODE_START;
    public static final int AUDIOMODE_REPEAT;
    public static final int AUDIOMODE_ABORT;
    public static final int AUDIOMODE_PROCESSING;
    public static final int AUDIOMODE_STOPPED;
    public static final int AUDIOMODE_ABORTED;
    public static final int AUDIOMODE_ERROR_BUSY;
    public static final int AUDIOMODE_ERROR_NOT_POSSIBLE;
    public static final int AUDIOMODE_ERROR_REGISTRATION_MISSING;
    public static final int AUDIOMODE_ERROR_INTERNAL;
    public static final int AUDIOSTATE_ACTIVE;
    public static final int AUDIOSTATE_IDLE;
    public static final int AUDIOSTATE_REQUEST;
    public static final int AUDIOSTATE_ERROR;
    public static final int MAPSETTYPE_STANDARD;
    public static final int MAPSETTYPE_GOOGLE;
    public static final int MAPSETTYPE_TRAFFIC;
    public static final int MAPSETTYPE_SMALLMAP;
    public static final int SPELLERINPUTFORMAT_NUMERIC;
    public static final int SPELLERINPUTFORMAT_ALPHABETIC;
    public static final int SPELLERINPUTFORMAT_SPECIAL;
    public static final int PERSONALPOISEARCHSTATUS_FULLY_OPERABLE;
    public static final int PERSONALPOISEARCHSTATUS_NOT_OPERABLE;
    public static final int VEHICLEFUELTYPE_REGULAR;
    public static final int VEHICLEFUELTYPE_DIESEL;
    public static final int VEHICLEFUELTYPE_LPG;
    public static final int VEHICLEFUELTYPE_CNG;
    public static final int VEHICLEFUELTYPE_ELECTRIC;
    public static final int CURRENCY_INVALID;
    public static final int CURRENCY_EUR_1000;
    public static final int CURRENCY_CNY_1000;
    public static final int CURRENCY_USD_1000;
    public static final int CURRENCY_GBP_1000;
    public static final int EXTDATATYPE_UNKNOWN;
    public static final int EXTDATATYPE_PINYIN_UF;
    public static final int EXTDATATYPE_CHINESE_UF;
    public static final int EXTDATATYPE_ENGLISH_UF;
    public static final int EXTDATATYPE_FULLSTREETNAME_UF;
    public static final int EXTDATATYPE_BASENAME_UF;
    public static final int EXTDATATYPE_PHONEME;
    public static final int EXTDATATYPE_PHONEMEALPHABET;
    public static final int EXTDATATYPE_BASENAMEAFFIX;
    public static final int EXTDATATYPE_JUNCTIONNAME;
    public static final int EXTDATATYPE_TOWN;
    public static final int EXTDATATYPE_TOWNDISAMBIGUATION;
    public static final int EXTDATATYPE_HOUSENUMBER;
    public static final int EXTDATATYPE_STREETDISAMBIGUATION;
    public static final int EXTDATATYPE_BUILDING_FLOORNUMBER;
    public static final int EXTDATATYPE_POINAME;
    public static final int EXTDATATYPE_COMPLETEADDRESS;
    public static final int TRYMATCHLOCATIONLEVEL_UNKNOWN;
    public static final int TRYMATCHLOCATIONLEVEL_FULL;
    public static final int TRYMATCHLOCATIONLEVEL_COORDINATE;
    public static final int TRYMATCHLOCATIONLEVEL_ADDRESS_FULL;
    public static final int TRYMATCHLOCATIONLEVEL_ADDRESS_PARTIAL;
    public static final int TRYMATCHLOCATIONLEVEL_HOUSENUMBER_INCORRECT;
    public static final int TRYMATCHLOCATIONLEVEL_HOUSENUMBER_INCOMPLETE;
    public static final int TRYMATCHLOCATIONORIGIN_UNDEFINED;
    public static final int TRYMATCHLOCATIONORIGIN_INTERNAL;
    public static final int TRYMATCHLOCATIONORIGIN_EXTERNAL;
    public static final int TRIPTIMESTATUS_UNDEFINED;
    public static final int TRIPTIMESTATUS_AVAILABLEANDVALID;
    public static final int TRIPTIMESTATUS_UNRELIABLE;
    public static final int DBREGIONCHECKRESULT_OK;
    public static final int DBREGIONCHECKRESULT_NOK;
    public static final int DBREGIONCHECKRESULT_UNKNOWN;
    public static final int DBREGIONCHECKRESULT_CUSTOMER_DL;
    public static final int TRDATARESULT_OK;
    public static final int TRDATARESULT_FAILED;
    public static final int TRDATARESULT_MEMOVERFLOW;
    public static final int TRDATARESULT_INVALIDVALUES;
    public static final int TRDATARESULT_NOMEDIUM;
    public static final int TRDATARESULT_WRITEPROTECTED;
    public static final int TRDATARESULT_NOTENOUGHDISKSPACE;
    public static final int TRDATARESULT_TRACKMEMORYFULL;
    public static final int NVCRANGE_DEFAULT;
    public static final int NVCRANGE_EXCLUDE_HANZI;
    public static final int NVCRANGE_INCLUDE_HANZI_TOP;
    public static final int NVCRANGE_HANZI_ONLY;
    public static final int NVCRANGE_INLCUDE_STROKES;
    public static final int NVCRANGE_INCLUDE_STROKES;
    public static final int CATEGORYADDITIONALFLAG_PROXIMITYWARNING;
    public static final int PHONEMEELEMENT_COUNTRY;
    public static final int PHONEMEELEMENT_STATE;
    public static final int PHONEMEELEMENT_TOWN;
    public static final int PHONEMEELEMENT_TOWNREFINEMENT;
    public static final int PHONEMEELEMENT_TOWNCENTER;
    public static final int PHONEMEELEMENT_STREET;
    public static final int PHONEMEELEMENT_STREETREFINEMENT;
    public static final int PHONEMEELEMENT_JUNCTION;
    public static final int PHONEMEELEMENT_POINAME;
    public static final int ROADCLASS_UNKNOWN;
    public static final int ROADCLASS_MOTORWAY;
    public static final int ROADCLASS_CARRIAGEWAY_MULTIPLE;
    public static final int ROADCLASS_CARRIAGEWAY_SINGLE;
    public static final int ROADCLASS_ROAD;
    public static final int ROADCLASS_ROUNDABOUT;
    public static final int ROADCLASS_OTHER;
    public static final int TURNLISTELEMENTTYPE_UNDEFINED;
    public static final int TURNLISTELEMENTTYPE_MANEUVER_NON_CONTROLLED_ACCESS;
    public static final int TURNLISTELEMENTTYPE_MANEUVER_CONTROLLED_ACCESS;
    public static final int TURNLISTELEMENTTYPE_MANEUVER_PASSING_POINT;
    public static final int TURNLISTELEMENTTYPE_TOLLGATE;
    public static final int TURNLISTELEMENTTYPE_FERRY;
    public static final int TURNLISTELEMENTTYPE_TUNNEL;
    public static final int TURNLISTELEMENTTYPE_DESTINATION;
    public static final int TURNLISTELEMENTTYPE_WARNING_OFFROAD;
    public static final int TURNLISTELEMENTTYPE_WARNING_NARROWROAD;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_TIMERESTRICTION;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_SEASONALRESTRICTION;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_MOTORWAY;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_FERRY;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_TOLL;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_SMALLROAD;
    public static final int TURNLISTICONTYPE_UNDEFINED;
    public static final int TURNLISTICONTYPE_MANEUVERMARKER;
    public static final int TURNLISTICONTYPE_TRAFFICLIGHT;
    public static final int TURNLISTICONTYPE_TOLLGATE;
    public static final int TURNLISTICONTYPE_TOLLGATE_ETC;
    public static final int TURNLISTICONTYPE_FERRY;
    public static final int TURNLISTICONTYPE_TUNNEL;
    public static final int TURNLISTICONTYPE_DESTINATION;
    public static final int NAVPOIINFOTYPE_UNDEFINED;
    public static final int NAVPOIINFOTYPE_CONTROLLEDACCESS;
    public static final int NAVPOIINFOTYPE_POIONROUTE;
    public static final int TURNLISTMODE_UNDEFINED;
    public static final int TURNLISTMODE_COMPLETE;
    public static final int TURNLISTMODE_COMPACT;
    public static final int TURNLISTMODE_COMPLETEWITHWARNINGS;
    public static final int TURNLISTMODE_COMPACT2;
    public static final int XT9LDBMODE_COMMON_LDB;
    public static final int XT9LDBMODE_VINCINITY_SEARCH;
    public static final int XT9LDBMODE_ALONG_THE_ROUTE;
    public static final int XT9LDBMODE_AREA_SEARCH;
    public static final int CATEGORYAUDIOWARNING_ALL;
    public static final int CATEGORYAUDIOWARNING_SUPPORTING;
    public static final int POICATEGORYTYPE_UNDEFINED;
    public static final int POICATEGORYTYPE_TOPPOI;
    public static final int POICATEGORYTYPE_GENERIC;
    public static final int POICATEGORYTYPE_PPOI;
    public static final int POICATEGORYTYPE_OTHER;
    public static final int ADDITIONALROUTEDATAKEY_UNDEFINED;
    public static final int ADDITIONALROUTEDATAKEY_FIRST_MOTORWAY_ENTRY;
    public static final int ADDITIONALROUTEDATAKEY_LAST_MOTORWAY_EXIT;
    public static final int LOCATIONDISAMBIGUATION_DEFAULT;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_MOTORWAY;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TUNNEL;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_FERRY;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TOOLLROAD;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_BRIDGE;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_OTHERROAD;
    public static final int MAPINTEGRATIONSTATE_IDLE;
    public static final int MAPINTEGRATIONSTATE_IN_PROGRESS;
    public static final int MAPINTEGRATIONSTATE_FINISHED;
    public static final int RESTARTREASON_MAPINTEGRATION;
    public static final int POISEARCHMODE_OTHER;
    public static final int POISEARCHMODE_PROXIMITY_CCP;
    public static final int POISEARCHMODE_PROXIMITY_COORDINATE;
    public static final int POISEARCHMODE_ADMINISTRATIVE_NATIONWIDE;
    public static final int POISEARCHMODE_ADMINISTRATIVE;
    public static final int ADDITIONALLOCATIONINFO_TOWN_UF;
    public static final int BAPMANEUVERSTATE_NOTACTIVE;
    public static final int BAPMANEUVERSTATE_FOLLOW;
    public static final int BAPMANEUVERSTATE_PREPARE;
    public static final int BAPMANEUVERSTATE_DISTANCE;
    public static final int BAPMANEUVERSTATE_NOW;
    public static final int RMIMPORTSTATUS_IDLE;
    public static final int RMIMPORTSTATUS_INPROGRESS;
    public static final int RMIMPORTSTATUS_SUCCESS;
    public static final int RMIMPORTSTATUS_FAILED;
    public static final int RMIMPORTSTATUS_ABORTED;
    public static final int RMIMPORTSTATUS_ABORTED_POWERDOWN;
    public static final int RT_AFAREPEAT;
    public static final int RT_RGSETROUTEGUIDANCEMODE;
    public static final int RT_ETCSETDEMOMODE;
    public static final int RT_ETCSETMETRICSYSTEM;
    public static final int RT_ETCSETDEMOMODESPEED;
    public static final int RT_DMLASTDESTINATIONSDELETEALL;
    public static final int RT_DMLASTDESTINATIONSDELETE;
    public static final int RT_DMLASTDESTINATIONSGET;
    public static final int RT_DMLASTDESTINATIONSREPLACE;
    public static final int RT_DMRECENTROUTESADD;
    public static final int RT_DMRECENTROUTESDELETEALL;
    public static final int RT_DMRECENTROUTESDELETE;
    public static final int RT_DMRECENTROUTESGET;
    public static final int RT_DMRECENTROUTESREPLACE;
    public static final int RT_LIGETSTATE;
    public static final int RT_LIRESTORESTATE;
    public static final int RT_LISETCURRENTLD;
    public static final int RT_LISPADDCHARACTER;
    public static final int RT_LISPCANCELSPELLER;
    public static final int RT_LISPDELETEALLCHARACTERS;
    public static final int RT_LISPSELECTLISTITEM;
    public static final int RT_LISPSETINPUT;
    public static final int RT_LISPUNDOCHARACTER;
    public static final int RT_LISTARTMULTICRITERIASPELLER;
    public static final int RT_LISTARTSPELLER;
    public static final int RT_RGSETROUTEOPTIONS;
    public static final int RT_RGSTOPGUIDANCE;
    public static final int RT_RGSETPOSITION;
    public static final int RT_LIGETCURRENTSTATE;
    public static final int RT_POISETCONTEXT;
    public static final int RT_POISTARTSPELLERALONGROUTE;
    public static final int RT_POISELECTSELECTIONCRITERIA;
    public static final int RT_LIGETLOCATIONDESCRIPTIONTRANSFORM;
    public static final int RT_RMMAKEROUTEPERSISTENT;
    public static final int RT_POISETSORTORDER2;
    public static final int RT_RGCALCULATEROUTE;
    public static final int RT_RGSTARTGUIDANCECALCULATEDROUTE;
    public static final int RT_LITRYBESTMATCH;
    public static final int RT_ETCGETCOUNTRYABBREVIATION;
    public static final int RT_RRDSTARTCALCULATIONFORPOSITION;
    public static final int RT_TRSTARTTRACERECORDING;
    public static final int RT_TRSTOPTRACERECORDING;
    public static final int RT_TRSTORETRACE;
    public static final int RT_TRRENAMETRACE;
    public static final int RT_TRDELETETRACE;
    public static final int RT_TRDELETEALLTRACES;
    public static final int RT_RMROUTEADD;
    public static final int RT_RMROUTEDELETE;
    public static final int RT_RMROUTEDELETEALL;
    public static final int RT_RMROUTEGET;
    public static final int RT_RMROUTERENAME;
    public static final int RT_SETLANGUAGE;
    public static final int RT_CREATEEXPORTFILE;
    public static final int RT_IMPORTFILE;
    public static final int RT_LANGUAGESPELLABLECHARACTERS;
    public static final int RT_ENABLERGSTREETLISTS;
    public static final int RT_ENABLERGPOIINFO;
    public static final int RT_DMLASTDESTINATIONSADDLIST;
    public static final int RT_TRCREATEWAYPOINT;
    public static final int RT_TRANSLATEROUTE;
    public static final int RT_LOCATIONTOSTREAM;
    public static final int RT_STREAMTOLOCATION;
    public static final int RT_LIVALUELISTFILENAME;
    public static final int RT_LIVALUELISTOUTPUTMETHOD;
    public static final int RT_ENABLERGLANEGUIDANCE;
    public static final int RT_DMFLAGDESTINATIONSET;
    public static final int RT_LISETCOUNTRYFORCITYANDSTREETHISTORY;
    public static final int RT_LIGETLASTCITYHISTORYENTRY;
    public static final int RT_LILASTCITYHISTORYADD;
    public static final int RT_LILASTCITYHISTORYDELETE;
    public static final int RT_LILASTSTREETHISTORYADD;
    public static final int RT_LILASTSTREETHISTORYDELETE;
    public static final int RT_ETCSELECTDATABASE;
    public static final int RT_LISPREQUESTVALUELISTBYLISTINDEX;
    public static final int RT_REQUESTSOPOSPOSITIONDESCRIPTIONVEHICLE;
    public static final int RT_LISTRIPLOCATION;
    public static final int RT_RRDSTARTCALCULATIONBYLISTINDEX;
    public static final int RT_DMFLAGDESTINATIONREMOVE;
    public static final int RT_DMFLAGDESTINATIONSETNAME;
    public static final int RT_ETCSELECTNAVDATABASE;
    public static final int RT_LIGETLASTSTREETHISTORYENTRY;
    public static final int RT_LILASTCITYHISTORYDELETEALL;
    public static final int RT_LILASTSTREETHISTORYDELETEALL;
    public static final int RT_REQUESTAUDIOTRIGGER;
    public static final int RT_LITHESAURUSHISTORYADD;
    public static final int RT_LITHESAURUSHISTORYGETENTRY;
    public static final int RT_LITHESAURUSHISTORYDELETE;
    public static final int RT_LITHESAURUSHISTORYDELETEALL;
    public static final int RT_EHGETALLCATEGORIES;
    public static final int RT_EHGETALLBRANDSOFCATEGORY;
    public static final int RT_EHSETCATEGORYVISIBILITY;
    public static final int RT_EHSETBRANDVISIBILITY;
    public static final int RT_EHSETBRANDPREFERENCE;
    public static final int RT_SETREMAININGRANGEOFVEHICLE;
    public static final int RT_RRDSTOPCALCULATION;
    public static final int RT_SETUSERDEFINEDPOIS;
    public static final int RT_SETTRAILERSTATUS;
    public static final int RT_EHSETCATEGORYAUDIOWARNING;
    public static final int RT_REQUESTCOUNTRYINFO;
    public static final int RT_JUMPTONEXTMANEUVER;
    public static final int RT_LISPSELECTBYCATEGORYUID;
    public static final int RT_LIGETVIAPOINTLIST;
    public static final int RT_LISELECTVIAPOINT;
    public static final int RT_RGSTARTGUIDANCECALCULATEDROUTEBYUID;
    public static final int RT_EHSETCATEGORYMONITORING;
    public static final int RT_LIGETSPELLABLECHARACTERS;
    public static final int RT_LISTOPSPELLER;
    public static final int RT_LIVALUELISTMAXIMUMLENGTH;
    public static final int RT_RGSTOPROUTECALCULATION;
    public static final int RT_SETVEHICLEFUELTYPE;
    public static final int RT_SETPATHSTOPERSONALPOIDATABASES;
    public static final int RT_LISPSELECTLISTITEMBYIDENT;
    public static final int RT_CREATENAVLOCATIONOFPOIUID;
    public static final int RT_RMROUTEREPLACE;
    public static final int RT_DELETEPERSONALPOIDATABASES;
    public static final int RT_RGSWITCHTONEXTPOSSIBLEROAD;
    public static final int RT_LISETHISTORY;
    public static final int RT_LIDELETEHISTORY;
    public static final int RT_LIGETLASTSTATEHISTORYENTRY;
    public static final int RT_LILASTSTATEHISTORYADD;
    public static final int RT_LILASTSTATEHISTORYADDEXTENDED;
    public static final int RT_LILASTSTATEHISTORYDELETE;
    public static final int RT_LILASTSTATEHISTORYDELETEALL;
    public static final int RT_LILASTSTREETHISTORYADDEXTENDED;
    public static final int RT_LILASTCITYHISTORYADDEXTENDED;
    public static final int RT_LISPSELECTITEMFROMLOCATION;
    public static final int RT_LISPSELECTBYMULTIPLECATEGORYUIDS;
    public static final int RT_POISTARTSPELLERALONGROUTEADVANCED;
    public static final int RT_EHSETCATEGORYVISIBILITYTODEFAULT;
    public static final int RT_LIVALUELISTWINDOWSIZE;
    public static final int RT_SETNAVINTERNALDATATOFACTORYSETTINGS;
    public static final int RT_LITRYMATCHLOCATION;
    public static final int RT_LIGETVIAPOINTCOUNTRYLIST;
    public static final int RT_LISETVIAPOINTCOUNTRY;
    public static final int RT_LISETSTREETFORCITYHISTORY;
    public static final int RT_TRIMPORTTRAILS;
    public static final int RT_TREXPORTTRAILS;
    public static final int RT_RGSKIPNEXTWAYPOINTS;
    public static final int RT_RGREVERSETRAILDIRECTION;
    public static final int RT_RGPREPARERUBBERBANDMANIPULATION;
    public static final int RT_RGSTARTRUBBERBANDMANIPULATION;
    public static final int RT_RGSETRUBBERBANDPOSITION;
    public static final int RT_RGGETROUTEBOUNDINGRECTANGLE;
    public static final int RT_RGGETLOCATIONONROUTE;
    public static final int RT_RGSTOPRUBBERBANDMANIPULATION;
    public static final int RT_RGENABLEENHANCEDSIGNPOSTINFO;
    public static final int RT_RGDELETECALCULATEDRUBBERBANDPOINT;
    public static final int RT_RGGETRUBBERBANDPOINTPOSITION;
    public static final int RT_LISETNVCRANGE;
    public static final int RT_LISPGETMATCHINGNVC;
    public static final int RT_LISPGETLOCATIONFROMLIVALUELISTELEMENT;
    public static final int RT_POIGETXT9LDBS;
    public static final int RT_POISETLISTSTYLE;
    public static final int RT_RGTRIGGERRCCIUPDATE;
    public static final int RT_RGSETTURNLISTMODE;
    public static final int RT_LILASTSTREETHISTORYSETCITY;
    public static final int RT_LILASTCITYHISTORYSETSTREET;
    public static final int RT_LIHISTORYADDLOCATION;
    public static final int RT_ENABLERGMOTORWAYINFO;
    public static final int RT_LIGETLOCATIONDESCRIPTIONTRANSFORMNEARBY;
    public static final int RT_ETCGETPOSITIONTIMEINFO;
    public static final int RT_POIGETCATEGORYTYPESFROMUID;
    public static final int RT_RGCALCULATE1STROUTEANDPOSTPONEREMAINING;
    public static final int RT_RGDELETEPERSISTEDROUTEDATA;
    public static final int RT_TRIGGEREVENTAUDIOMESSAGE;
    public static final int RT_LIDISAMBIGUATELOCATION;
    public static final int RT_LISPADDSTROKE;
    public static final int RT_LISPREQUESTNVCLIST;
    public static final int RT_POICONFIGURECONTEXT;
    public static final int RT_ETCTRIGGERNAVIGATIONRESTART;
    public static final int RT_RMIMPORTTOURSFROMGPXFILE;
    public static final int RT_RMABORTIMPORTTOURSFROMGPXFILE;
    public static final int RT_IMPORTROUTEFROMGPXFILE;
    public static final int RT_POIREQUESTEXTENDEDINFO;
    public static final int RT_RGCONFIGUREPOIINFO;
    public static final int RT_TRCLEARRECORDEDTRACECACHE;
    public static final int RT_SETVIRTUALROUTEGUIDANCE;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_RGSETROUTEGUIDANCEMODERESULT;
    public static final int RP_DMLASTDESTINATIONSGETRESULT;
    public static final int RP_DMRECENTROUTESGETRESULT;
    public static final int RP_DMRESULT;
    public static final int RP_LIGETSTATERESULT;
    public static final int RP_LIRESULT;
    public static final int RP_LISPUPDATESPELLERRESULT;
    public static final int RP_LIVALUELIST;
    public static final int RP_LIVALUELISTFILESTATUS;
    public static final int RP_LIVALUELISTOUTPUTMETHOD;
    public static final int RP_POIVALUELIST;
    public static final int RP_LIGETLOCATIONDESCRIPTIONTRANSFORMRESULT;
    public static final int RP_RMMAKEROUTEPERSISTENTRESULT;
    public static final int RP_LITRYBESTMATCHRESULT;
    public static final int RP_ETCGETCOUNTRYABBREVIATIONRESULT;
    public static final int RP_TRSTARTTRACERECORDINGRESULT;
    public static final int RP_TRSTOPTRACERECORDINGRESULT;
    public static final int RP_TRSTORETRACERESULT;
    public static final int RP_TRRENAMETRACERESULT;
    public static final int RP_TRDELETETRACERESULT;
    public static final int RP_TRDELETEALLTRACESRESULT;
    public static final int RP_RMROUTEADDRESULT;
    public static final int RP_RMROUTEDELETERESULT;
    public static final int RP_RMROUTEDELETEALLRESULT;
    public static final int RP_RMROUTEGETRESULT;
    public static final int RP_RMROUTERENAMERESULT;
    public static final int RP_CREATEEXPORTFILERESULT;
    public static final int RP_IMPORTFILERESULT;
    public static final int RP_LANGUAGESPELLABLECHARACTERSRESULT;
    public static final int RP_TRANSLATEROUTERESULT;
    public static final int RP_LOCATIONTOSTREAMRESULT;
    public static final int RP_STREAMTOLOCATIONRESULT;
    public static final int RP_LIGETLASTCITYHISTORYENTRYRESULT;
    public static final int RP_LILASTCITYANDSTREETHISTORYRESULT;
    public static final int RP_SOPOSPOSITIONDESCRIPTIONVEHICLERESULT;
    public static final int RP_LISTRIPLOCATIONRESULT;
    public static final int RP_LIGETLASTSTREETHISTORYENTRYRESULT;
    public static final int RP_LICURRENTSTATE;
    public static final int RP_LISETCOUNTRYFORCITYANDSTREETHISTORYRESULT;
    public static final int RP_RESPONSEAUDIOTRIGGER;
    public static final int RP_RGSTARTGUIDANCECALCULATEDROUTERESULT;
    public static final int RP_LITHESAURUSHISTORYADDRESULT;
    public static final int RP_LITHESAURUSHISTORYGETENTRYRESULT;
    public static final int RP_LITHESAURUSHISTORYDELETERESULT;
    public static final int RP_LITHESAURUSHISTORYDELETEALLRESULT;
    public static final int RP_EHRESULT;
    public static final int RP_EHGETALLCATEGORIESRESULT;
    public static final int RP_EHGETALLBRANDSOFCATEGORYRESULT;
    public static final int RP_SETREMAININGRANGEOFVEHICLERESULT;
    public static final int RP_SETUSERDEFINEDPOISRESULT;
    public static final int RP_SETTRAILERSTATUSRESULT;
    public static final int RP_SETVEHICLECONSUMPTIONINFORESULT;
    public static final int RP_REQUESTCOUNTRYINFORESULT;
    public static final int RP_LIGETVIAPOINTLISTRESULT;
    public static final int RP_LISELECTVIAPOINTRESULT;
    public static final int RP_RGSTARTGUIDANCECALCULATEDROUTEBYUIDRESULT;
    public static final int RP_LIGETSPELLABLECHARACTERSRESULT;
    public static final int RP_SETVEHICLEFUELTYPERESULT;
    public static final int RP_CREATENAVLOCATIONOFPOIUIDRESULT;
    public static final int RP_RMROUTEREPLACERESULT;
    public static final int RP_DELETEPERSONALPOIDATABASESRESULT;
    public static final int RP_RGSWITCHTONEXTPOSSIBLEROADRESULT;
    public static final int RP_LIGETLASTSTATEHISTORYENTRYRESULT;
    public static final int RP_LIHISTORYRESULT;
    public static final int RP_SETNAVINTERNALDATATOFACTORYSETTINGSRESULT;
    public static final int RP_LITRYMATCHLOCATIONRESULT;
    public static final int RP_TRIMPORTTRAILSRESULT;
    public static final int RP_TREXPORTTRAILSRESULT;
    public static final int RP_RGGETLOCATIONONROUTERESULT;
    public static final int RP_RGGETROUTEBOUNDINGRECTANGLERESULT;
    public static final int RP_RGRESULT;
    public static final int RP_RGSTARTRUBBERBANDMANIPULATIONRESULT;
    public static final int RP_RGGETRUBBERBANDPOINTPOSITIONRESULT;
    public static final int RP_LISPGETMATCHINGNVCRESULT;
    public static final int RP_LISPGETLOCATIONFROMLIVALUELISTRESULT;
    public static final int RP_ETCSETDEMOMODERESULT;
    public static final int RP_RGTRIGGERRCCIUPDATERESULT;
    public static final int RP_LIGETLOCATIONDESCRIPTIONTRANSFORMNEARBYRESULT;
    public static final int RP_POIGETXT9LDBSRESULT;
    public static final int RP_ETCGETPOSITIONTIMEINFORESULT;
    public static final int RP_POIGETCATEGORYTYPESFROMUIDRESULT;
    public static final int RP_TRIGGEREVENTAUDIOMESSAGERESULT;
    public static final int RP_LIDISAMBIGUATELOCATIONRESULT;
    public static final int RP_LISPREQUESTNVCLISTRESULT;
    public static final int RP_ETCTRIGGERNAVIGATIONRESTARTRESULT;
    public static final int RP_RMIMPORTTOURSFROMGPXFILERESULT;
    public static final int RP_IMPORTROUTEFROMGPXFILERESULT;
    public static final int RP_POIREQUESTEXTENDEDINFORESULT;
    public static final int RP_TRCLEARRECORDEDTRACECACHERESULT;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int IN_RGEXCEPTION;
    public static final int IN_ETCSENSORDATAREPLAYROUTE;
    public static final int IN_ETCSENSORDATAREPLAYGUIDANCE;
    public static final int IN_RGNOTPOSSIBLE;

    default public void afaRepeat(int n) {
    }

    default public void createExportFile(String string, int n) {
    }

    default public void dmFlagDestinationSet(NavLocation navLocation) {
    }

    default public void dmFlagDestinationRemove() {
    }

    default public void dmFlagDestinationSetName(String string) {
    }

    default public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
    }

    default public void dmLastDestinationsDelete(long l) {
    }

    default public void dmLastDestinationsDeleteAll() {
    }

    default public void dmLastDestinationsGet(long l) {
    }

    default public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
    }

    default public void dmRecentRoutesAdd(Route route, String string) {
    }

    default public void dmRecentRoutesDelete(long l) {
    }

    default public void dmRecentRoutesDeleteAll() {
    }

    default public void dmRecentRoutesGet(long l) {
    }

    default public void dmRecentRoutesReplace(long l, Route route, String string) {
    }

    default public void enableRgStreetLists(boolean bl) {
    }

    default public void enableRgLaneGuidance(boolean bl) {
    }

    default public void enableRgPoiInfo(boolean bl) {
    }

    default public void etcGetCountryAbbreviation(String string) {
    }

    default public void etcSetDemoMode(boolean bl) {
    }

    default public void etcSetDemoModeSpeed(long l) {
    }

    default public void etcSetMetricSystem(int n) {
    }

    default public void etcSelectDatabase(int n) {
    }

    default public void etcSelectNavDataBase(int n) {
    }

    default public void importFile(String string, int n) {
    }

    default public void languageSpellableCharacters(String string) {
    }

    default public void liGetCurrentState() {
    }

    default public void liGetLastCityHistoryEntry(long l) {
    }

    default public void liGetLastStreetHistoryEntry(long l) {
    }

    default public void liGetLocationDescriptionTransform(NavLocation navLocation) {
    }

    default public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
    }

    default public void liGetState() {
    }

    default public void liGetLastStateHistoryEntry(long l) {
    }

    default public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
    }

    default public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
    }

    default public void liLastStateHistoryDelete(long l) {
    }

    default public void liLastStateHistoryDeleteAll() {
    }

    default public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
    }

    default public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
    }

    default public void liLastCityHistoryDelete(long l) {
    }

    default public void liLastCityHistoryDeleteAll() {
    }

    default public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
    }

    default public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
    }

    default public void liLastStreetHistoryDelete(long l) {
    }

    default public void liLastStreetHistoryDeleteAll() {
    }

    default public void liRestoreState(LISpellerData lISpellerData) {
    }

    default public void liSetCountryForCityAndStreetHistory(String string) {
    }

    default public void liSetHistory(String string, String string2) {
    }

    default public void liSetStreetForCityHistory(String string) {
    }

    default public void liDeleteHistory() {
    }

    default public void liSetCurrentLD(NavLocation navLocation) {
    }

    default public void lispAddCharacter(String string) {
    }

    default public void lispCancelSpeller() {
    }

    default public void lispDeleteAllCharacters() {
    }

    default public void lispRequestValueListByListIndex(int n, boolean bl) {
    }

    default public void lispSelectListItem(int n) {
    }

    default public void lispSelectItemFromLocation(NavLocation navLocation) {
    }

    default public void lispSelectByCategoryUid(int n) {
    }

    default public void lispSelectByMultipleCategoryUids(int[] nArray) {
    }

    default public void lispSetInput(String string, boolean bl) {
    }

    default public void lispGetMatchingNVC(String string) {
    }

    default public void lispUndoCharacter() {
    }

    default public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
    }

    default public void liValueListFilename(String string) {
    }

    default public void liValueListOutputMethod(int n) {
    }

    default public void locationToStream(NavLocation navLocation) {
    }

    default public void poiSelectSelectionCriteria(long l) {
    }

    default public void poiSetContext(NavLocation navLocation) {
    }

    default public void poiSetSortOrder2(int n) {
    }

    default public void poiStartSpellerAlongRoute(int n, long l, long l2) {
    }

    default public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
    }

    default public void requestSoPosPositionDescriptionVehicle() {
    }

    default public void rgCalculateRoute(Route route, int n) {
    }

    default public void rgSetPosition(NavLocation navLocation) {
    }

    default public void rgSetRouteGuidanceMode(int n) {
    }

    default public void rgSetRouteOptions(RouteOptions routeOptions) {
    }

    default public void rgStartGuidanceCalculatedRoute(int n) {
    }

    default public void rgStopGuidance() {
    }

    default public void rmMakeRoutePersistent(Route route) {
    }

    default public void rmRouteAdd(int n, Route route, String string) {
    }

    default public void rmRouteDelete(int n, long l) {
    }

    default public void rmRouteDeleteAll(int n) {
    }

    default public void rmRouteGet(int n, long l) {
    }

    default public void rmRouteRename(int n, long l, String string) {
    }

    default public void rrdStartCalculationByListIndex(int n, long l) {
    }

    default public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
    }

    default public void rrdStopCalculation() {
    }

    default public void setLanguage(String string) {
    }

    default public void streamToLocation(byte[] byArray) {
    }

    default public void translateRoute(Route route) {
    }

    default public void trCreateWaypoint() {
    }

    default public void trDeleteAllTraces() {
    }

    default public void trDeleteTrace(NavSegmentID navSegmentID) {
    }

    default public void trRenameTrace(NavSegmentID navSegmentID, String string) {
    }

    default public void trStartTraceRecording(int n) {
    }

    default public void trStopTraceRecording() {
    }

    default public void trStoreTrace(String string) {
    }

    default public void liStripLocation(NavLocation navLocation, int n) {
    }

    default public void liSetNVCRange(int n) {
    }

    default public void liValueListWindowSize(int n) {
    }

    default public void requestAudioTrigger(int n) {
    }

    default public void liThesaurusHistoryAdd(String string) {
    }

    default public void liThesaurusHistoryGetEntry(int n) {
    }

    default public void liThesaurusHistoryDelete(int n) {
    }

    default public void liThesaurusHistoryDeleteAll() {
    }

    default public void ehGetAllCategories(int n) {
    }

    default public void ehGetAllBrandsOfCategory(int n, int n2) {
    }

    default public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryVisibilityToDefault(int n) {
    }

    default public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
    }

    default public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
    }

    default public void setRemainingRangeOfVehicle(int n) {
    }

    default public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
    }

    default public void setTrailerStatus(boolean bl) {
    }

    default public void requestCountryInfo(String string) {
    }

    default public void jumpToNextManeuver() {
    }

    default public void liGetViaPointCountryList() {
    }

    default public void liSetViaPointCountry(String string) {
    }

    default public void liGetViaPointList(int n, int n2, int n3, int n4) {
    }

    default public void liSelectViaPoint(int n) {
    }

    default public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
    }

    default public void liGetSpellableCharacters(NavLocation navLocation, int n) {
    }

    default public void liStopSpeller() {
    }

    default public void liValueListMaximumLength(int n) {
    }

    default public void setPathsToPersonalPOIDataBases(String[] stringArray) {
    }

    default public void deletePersonalPOIDataBases(String[] stringArray) {
    }

    default public void rgStopRouteCalculation() {
    }

    default public void rgSwitchToNextPossibleRoad() {
    }

    default public void setVehicleFuelType(int n) {
    }

    default public void createNavLocationOfPOIUID(long l) {
    }

    default public void lispSelectListItemByIdent(String string) {
    }

    default public void rmRouteReplace(int n, long l, Route route) {
    }

    default public void setNavInternalDataToFactorySettings() {
    }

    default public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
    }

    default public void trImportTrails(String string) {
    }

    default public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
    }

    default public void rgSkipNextWayPoints(int n) {
    }

    default public void rgReverseTrailDirection() {
    }

    default public void rgPrepareRubberbandManipulation(boolean bl) {
    }

    default public void rgStartRubberbandManipulation(int n) {
    }

    default public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void rgGetRouteBoundingRectangle(boolean bl, int n) {
    }

    default public void rgGetLocationOnRoute(long l) {
    }

    default public void rgStopRubberbandManipulation() {
    }

    default public void rgDeleteCalculatedRubberbandPoint() {
    }

    default public void rgGetRubberBandPointPosition() {
    }

    default public void rgEnableEnhancedSignPostInfo(boolean bl) {
    }

    default public void lispGetLocationFromLiValueListElement(int n) {
    }

    default public void rgSetTurnListMode(int n) {
    }

    default public void liHistoryAddLocation(NavLocation navLocation) {
    }

    default public void liLastCityHistorySetStreet(NavLocation navLocation) {
    }

    default public void liLastStreetHistorySetCity(NavLocation navLocation) {
    }

    default public void enableRgMotorwayInfo(boolean bl) {
    }

    default public void rgTriggerRCCIUpdate() {
    }

    default public void poiGetXt9LDBs(NavLocation navLocation, int n) {
    }

    default public void poiSetListStyle(int n) {
    }

    default public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
    }

    default public void poiGetCategoryTypesFromUId(int n) {
    }

    default public void rgDeletePersistedRouteData() {
    }

    default public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
    }

    default public void liDisambiguateLocation(NavLocation navLocation) {
    }

    default public void triggerEventAudioMessage(int n) {
    }

    default public void lispAddStroke(String string) {
    }

    default public void lispRequestNVCList(int n, int n2, int n3) {
    }

    default public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
    }

    default public void etcTriggerNavigationRestart(int n) {
    }

    default public void rmImportToursFromGpxFile(int n, String string) {
    }

    default public void rmAbortImportToursFromGpxFile() {
    }

    default public void importRouteFromGpxFile(String string) {
    }

    default public void poiRequestExtendedInfo(NavLocation navLocation) {
    }

    default public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
    }

    default public void trClearRecordedTraceCache() {
    }

    default public void setVirtualRouteGuidance(boolean bl) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }
}

