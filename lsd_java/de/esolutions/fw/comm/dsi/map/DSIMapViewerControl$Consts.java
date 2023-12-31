/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

public interface DSIMapViewerControl$Consts {
    public static final String VERSION;
    public static final int MAPLAYER_SDARS_RADAR;
    public static final int MAPLAYER_SDARS_WEATHER;
    public static final int MAPLAYER_SDARS_ISOBARE;
    public static final int MAPMODE_ROUTEMAP;
    public static final int MAPMODE_POSITIONMAP;
    public static final int MAPMODE_FREEMAP;
    public static final int MAPMODE_CROSSHAIRMAP;
    public static final int MAPMODE_POIMAP;
    public static final int MAPMODE_ROUTESCROLLMAP;
    public static final int MAPMODE_ALTERNATIVEROUTEMAP;
    public static final int MAPMODE_RCCIMAP;
    public static final int MAPMODE_ROUTEBROWSERMAP;
    public static final int MAPMODE_DESTINATIONMAP;
    public static final int MAPMODE_OVERVIEWMAP;
    public static final int MAPMODE_ALTERNATIVEROUTEMAP_DIFFERENTCOLORS;
    public static final int MAPMODE_ROUTEBRIEFING;
    public static final int MAPMODE_COUNTRY_OVERVIEW;
    public static final int MAPMODE_MOBILITY_HORIZON;
    public static final int MAPMODE_MAPOVERLAY;
    public static final int MAPMODE_PREDICTIVE_NAV_OVERVIEW;
    public static final int MAPMODE_PREDICTIVE_OVERLAY;
    public static final int MAPMODE_ROUTEOVERVIEWMAP;
    public static final int MAPMODE_INVALID_MAPMODE;
    public static final int LOCATION_CAR;
    public static final int LOCATION_DESTINATION;
    public static final int LOCATION_STOPOVER;
    public static final int LOCATION_INVALID_LOCATION;
    public static final int MAPVIEWTYPE_VIEW2D;
    public static final int MAPVIEWTYPE_BIRDVIEW;
    public static final int MAPVIEWTYPE_VIEW3D;
    public static final int MAPVIEWTYPE_INVALID_MAPVIEWTYPE;
    public static final int POSITIONINFOTYPE_LOCATION;
    public static final int POSITIONINFOTYPE_POI;
    public static final int POSITIONINFOTYPE_POI_3D;
    public static final int POSITIONINFOTYPE_POI_CONTAINER;
    public static final int POSITIONINFOTYPE_TMC_MESSAGE;
    public static final int POSITIONINFOTYPE_PERSONAL_DEST;
    public static final int POSITIONINFOTYPE_INVALID_POSITION;
    public static final int POSITIONINFOTYPE_AREA;
    public static final int POSITIONINFOTYPE_XT_REPRESENTATION;
    public static final int POSITIONINFOTYPE_PICTURE_DESTINATION;
    public static final int POSITIONINFOTYPE_PICTURE_DESTINATION_STACK;
    public static final int POSITIONINFOTYPE_POI_BY_UID;
    public static final int POSITIONINFOTYPE_POI_STACK_BY_UID;
    public static final int POSITIONINFOTYPE_ROUTESEGMENT;
    public static final int POSITIONINFOTYPE_WEATHERINFORMATION;
    public static final int POSITIONINFOTYPE_CURRENT_CAR_POSITION;
    public static final int POSITIONINFOTYPE_LANDMARK;
    public static final int POSITIONINFOTYPE_SDARS_WEATHERSTATION;
    public static final int POSITIONINFOTYPE_SDARS_SKIRESORT;
    public static final int POSITIONINFOTYPE_SDARS_STORMINFO;
    public static final int POSITIONINFOTYPE_POI_BUILDINGLIST;
    public static final int POSITIONINFOTYPE_INVALID_POSITIONINFOTYPE;
    public static final int MAPTYPE_CITYMAPREAL;
    public static final int MAPTYPE_CITYMAPDRAWING;
    public static final int MAPTYPE_TERRAINMAP;
    public static final int MAPTYPE_IMAGEMAP;
    public static final int MAPTYPE_INVALID_MAPTYPE;
    public static final int ROUTETYPE_NOTYPE;
    public static final int ROUTETYPE_CURRENT;
    public static final int ROUTETYPE_BLOCKED;
    public static final int ROUTETYPE_PLANNED;
    public static final int ROUTETYPE_ALTERNATIVE;
    public static final int ROUTETYPE_TRAVELLED;
    public static final int ROUTETYPE_TRAIL;
    public static final int ROUTETYPE_INVALID_ROUTETYPE;
    public static final int COMMAND_ADD;
    public static final int COMMAND_CLEAR;
    public static final int COMMAND_REMOVE;
    public static final int COMMAND_REPLACE;
    public static final int COMMAND_INVALID_COMMAND;
    public static final int STARTPOS_START_AT_DESTINATION;
    public static final int STARTPOS_START_AT_CARPOSITION;
    public static final int STARTPOS_INVALID_STARTPOS;
    public static final int SCROLLRAMP_RAMP_1;
    public static final int SCROLLRAMP_RAMP_2;
    public static final int SCROLLRAMP_RAMP_3;
    public static final int SCROLLRAMP_RAMP_4;
    public static final int SCROLLRAMP_ABSOLUTE_PIXELS;
    public static final int SCROLLRAMP_INVALID_SCROLLRAMP;
    public static final int METRICSYSTEM_RESERVED;
    public static final int METRICSYSTEM_DEFAULT;
    public static final int METRICSYSTEM_KILOMETERS_METERS;
    public static final int METRICSYSTEM_IMPERIAL_GB_MILES_YARDS;
    public static final int METRICSYSTEM_IMPERIAL_US_MILES_FEET;
    public static final int CITYMODELMODE_OFF;
    public static final int CITYMODELMODE_STANDARD;
    public static final int CITYMODELMODE_ENHANCED;
    public static final int RESULTCODE_OK;
    public static final int RESULTCODE_FAIL;
    public static final int RESULTCODE_UNSUPPORTED;
    public static final int BRANDICONSTYLE_ACTUALBRANDICON;
    public static final int BRANDICONSTYLE_GENERIC;
    public static final int GUIDANCESYMBOL_NONE;
    public static final int GUIDANCESYMBOL_ARROW;
    public static final int FRAMERATEMODE_IMAGE_FROZEN;
    public static final int FRAMERATEMODE_NORMAL_FRAMERATE;
    public static final int FRAMERATEMODE_BACKGROUND_RENDERING;
    public static final int FRAMERATEMODE_BOOST_FRAMERATE;
    public static final int FRAMERATEMODE_THROTTELED_FRAMERATE;
    public static final int FRAMERATEMODE_LIMITED_CLUSTER_INSTRUMENT;
    public static final int ROUTECOLORINGPOLICY_COLOR_BY_ROUTETOPTION;
    public static final int ROUTECOLORINGPOLICY_COLOR_BY_ROUTEALTERNATIVE;
    public static final int CROSSHAIRSCOLOR_BLUE;
    public static final int CROSSHAIRSCOLOR_GREEN;
    public static final int VIEWPORTBORDER_NONE;
    public static final int VIEWPORTBORDER_STYLE1;
    public static final int VIEWPORTBORDER_STYLE2;
    public static final int MAPVIEWERRUNLEVEL_SUSPENSION_IN_PROGRESS;
    public static final int MAPVIEWERRUNLEVEL_SUSPENDED;
    public static final int MAPVIEWERRUNLEVEL_WAKEUP_IN_PROGRESS;
    public static final int MAPVIEWERRUNLEVEL_AWAKE;
    public static final int MAPVIEWERRUNLEVEL_ERROR_SUSPENSION_NOT_POSSIBLE;
    public static final int MAPVIEWERRUNLEVEL_ERROR_WAKEUP_NOT_POSSIBLE;
    public static final int MAPVIEWERSUSPENSIONSUPPORTED_NO;
    public static final int MAPVIEWERSUSPENSIONSUPPORTED_YES;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON_CARPOS;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON_ROUTE;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON_ALLPOLYGONS;
    public static final int DRAGROUTEMARKERSTYLE_NOMARKER;
    public static final int DRAGROUTEMARKERSTYLE_SMALLMARKER;
    public static final int DRAGROUTEMARKERSTYLE_BIGMARKER;
    public static final int ROUTEHIGHLIGHTSTYLE_NONE;
    public static final int ROUTEHIGHLIGHTSTYLE_SIMPLE;
    public static final int ROUTEHIGHLIGHTSTYLE_BLOCKPREVIEW;
    public static final int MAPSTYLETYPE_STANDARD;
    public static final int MAPSTYLETYPE_SATELLITE;
    public static final int MAPSTYLETYPE_TRAFFIC;
    public static final int MAPOVERLAYTYPE_UNDEFINED;
    public static final int MAPOVERLAYTYPE_WEATHERRADAR;
    public static final int TEMPERATURESCALE_UNDEFINED;
    public static final int TEMPERATURESCALE_CELSIUS;
    public static final int TEMPERATURESCALE_FAHRENHEIT;
    public static final int SPEEDANDFLOWROADCLASS_UNDEFINED;
    public static final int SPEEDANDFLOWROADCLASS_EXPRESSWAY;
    public static final int SPEEDANDFLOWROADCLASS_NORMALROAD;
    public static final int SPEEDANDFLOWROADCLASS_AUTO;
    public static final int SPEEDANDFLOWROADCLASS_ALL;
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;
}

