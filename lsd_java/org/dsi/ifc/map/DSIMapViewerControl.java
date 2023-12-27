/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerControl
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_READY;
    public static final int ATTR_CURRENTVIEWTYPE;
    public static final int ATTR_DAYNIGHTVIEW;
    public static final int ATTR_VIEWSCREENVIEWPORT;
    public static final int ATTR_VIEWVISIBLE;
    public static final int ATTR_VIEWFREEZE;
    public static final int ATTR_ZOOMLEVEL;
    public static final int ATTR_ZOOMLIST;
    public static final int ATTR_ZOOMLISTINDEX;
    public static final int ATTR_MAPROTATION;
    public static final int ATTR_MAPPOSITION;
    public static final int ATTR_MAPORIENTATION;
    public static final int ATTR_CARPOSITION;
    public static final int ATTR_TMCVISIBLE;
    public static final int ATTR_MAPMODE;
    public static final int ATTR_SELECTEDPOI;
    public static final int ATTR_SPEEDANDFLOWVISIBLE;
    public static final int ATTR_AVAILABLEROUTES;
    public static final int ATTR_VIEWPORT;
    public static final int ATTR_SOFTJUMPENABLED;
    public static final int ATTR_SOFTROTATIONENABLED;
    public static final int ATTR_SOFTTILTENABLED;
    public static final int ATTR_SOFTZOOMENABLED;
    public static final int ATTR_ROUTECALCMODEENABLED;
    public static final int ATTR_RBINFOOFSELECTEDSEGMENTS;
    public static final int ATTR_CURRENTLANDUSESTYLE;
    public static final int ATTR_CURRENTMETRICSYSTEM;
    public static final int ATTR_SOFTJUMPRUNNING;
    public static final int ATTR_SOFTROTATIONRUNNING;
    public static final int ATTR_SOFTTILTRUNNING;
    public static final int ATTR_SOFTZOOMRUNNING;
    public static final int ATTR_CITYMODELMODE;
    public static final int ATTR_MAPVIEWERRUNLEVEL;
    public static final int ATTR_MAPVIEWERSUSPENSIONSUPPORTED;
    public static final int ATTR_MAPVIEWERSUSPENSIONANDWAKEUPPROGRESS;
    public static final int ATTR_GENERALPOIVISIBILITY;
    public static final int ATTR_AVAILABLECOUNTRYOVERVIEWS;
    public static final int ATTR_HORIZONMARKERVISIBILITY;
    public static final int ATTR_VIEWSCREENVIEWPORTMAXIMUM;
    public static final int ATTR_DRAGROUTEPOSITION;
    public static final int ATTR_EHCATEGORYVISIBILITY;
    public static final int ATTR_MAPLAYERAVAILABLE;
    public static final int ATTR_MAPLAYERVISIBLE;
    public static final int ATTR_TEMPERATURESCALE;
    public static final int ATTR_SPEEDANDFLOWROADCLASS;
    public static final int ATTR_ROUTEVISIBILITY;
    public static final int ATTR_SOFTANIMATIONSPEED;
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
    public static final int RT_CONFIGUREFLAGS;
    public static final int RT_DRAGMAP;
    public static final int RT_ENSURETMCVISIBILITY;
    public static final int RT_GETINFOFORPOSITION;
    public static final int RT_GETINFOFORSCREENPOSITION;
    public static final int RT_GETNUMBEROFPOIS;
    public static final int RT_GOTOTMCMESSAGE;
    public static final int RT_PACKPOICONTAINER;
    public static final int RT_RBSELECTALTERNATIVEROUTE;
    public static final int RT_RBSELECTNEXTSEGMENT;
    public static final int RT_RBSELECTPREVIOUSSEGMENT;
    public static final int RT_RBSETPOSITION;
    public static final int RT_SCROLLTODIRECTION;
    public static final int RT_SELECTNEXTPOI;
    public static final int RT_SELECTPREVPOI;
    public static final int RT_SET3DLANDMARKSVISIBLE;
    public static final int RT_SETCARPOSITION;
    public static final int RT_SETDAYVIEW;
    public static final int RT_SETNIGHTVIEW;
    public static final int RT_SETENABLEROUTECALCMODE;
    public static final int RT_SETENABLESOFTJUMP;
    public static final int RT_SETENABLESOFTROTATION;
    public static final int RT_SETENABLESOFTTILT;
    public static final int RT_SETENABLESOFTZOOM;
    public static final int RT_SETLOCATION;
    public static final int RT_SETLOCATIONBYLOCATION;
    public static final int RT_SETLOCATIONBYLOCATIONANDVIEW;
    public static final int RT_SETMAPPOSITION;
    public static final int RT_SETMAPVIEWPORT;
    public static final int RT_SETMAPVIEWPORTBYLD;
    public static final int RT_SETMODE;
    public static final int RT_SETORIENTATION;
    public static final int RT_SETROTATION;
    public static final int RT_SETVIEWTYPE;
    public static final int RT_SETZOOMAREA;
    public static final int RT_SETZOOMLEVEL;
    public static final int RT_SHOWTMCMESSAGES;
    public static final int RT_STARTSCROLLTODIRECTION;
    public static final int RT_STOPSCROLLTODIRECTION;
    public static final int RT_UNPACKPOICONTAINER;
    public static final int RT_VIEWFREEZE;
    public static final int RT_VIEWSETSCREENVIEWPORT;
    public static final int RT_VIEWSETVISIBLE;
    public static final int RT_SETHOTPOINT;
    public static final int RT_SETMETRICSYSTEM;
    public static final int RT_SETVIEWFOCUSONBLOCK;
    public static final int RT_STARTTODRAWNEWRECTANGLEINMAP;
    public static final int RT_SETSOUTHWESTCORNEROFRECTANGLEINMAP;
    public static final int RT_SETNORTHEASTCORNEROFRECTANGLEINMAP;
    public static final int RT_FINISHDRAWRECTANGLEINMAP;
    public static final int RT_EDITRECTANGLEINMAP;
    public static final int RT_SETCITYMODELMODE;
    public static final int RT_SETVIEWFOCUSONPOI;
    public static final int RT_DISPLAYREMAININGRANGEOFVEHICLE;
    public static final int RT_TOUCHAPPROACH;
    public static final int RT_SETBRANDICONSTYLE;
    public static final int RT_STARTSCROLLBYVECTOR;
    public static final int RT_SETGUIDANCESYMBOL;
    public static final int RT_SETHOVLANEVISIBILITY;
    public static final int RT_RBGETIDOFSELECTEDSEGMENT;
    public static final int RT_RBGETRRDTOSELECTEDSEGMENT;
    public static final int RT_SETTOLLROADHIGHLIGHTING;
    public static final int RT_SETMOUNTAINPEAKMARKER;
    public static final int RT_SETVIEWFOCUSONCOMBINEDROUTELISTELEMENTS;
    public static final int RT_SETFRAMERATEMODE;
    public static final int RT_SETSCROLLBYCROSSHAIRS;
    public static final int RT_SETSCROLLBYCROSSHAIRSBOUNDINGBOX;
    public static final int RT_SETROUTECOLORINGPOLICY;
    public static final int RT_SETWEATHERVISUALIZATION;
    public static final int RT_SETPICTURENAVIGATIONICONVISIBILITY;
    public static final int RT_SETMOBILITYHORIZONVISIBILITY;
    public static final int RT_SETTRAFFICMAPSTYLE;
    public static final int RT_SHOWSPEEDANDFLOWFREEFLOW;
    public static final int RT_SHOWSPEEDANDFLOWCONGESTIONS;
    public static final int RT_SETCROSSHAIRSCOLOR;
    public static final int RT_SETVIEWPORTBORDER;
    public static final int RT_SETTERRAINELEVATION;
    public static final int RT_ENSUREPOIVISIBILITY;
    public static final int RT_SUSPENDMAPVIEWER;
    public static final int RT_WAKEUPMAPVIEWER;
    public static final int RT_SETCOUNTRYOVERVIEWCOUNTRY;
    public static final int RT_SETGENERALPOIVISIBILITY;
    public static final int RT_SHOWRICHCONTENT;
    public static final int RT_SETMOBILITYHORIZONZOOMMODE;
    public static final int RT_ISDETAILEDMAPMATERIALAVAILABLE;
    public static final int RT_SETHORIZONMARKERVISIBILITY;
    public static final int RT_VIEWSETSCREENVIEWPORTMAXIMUM;
    public static final int RT_SETMAPVIEWPORTBYWGS84RECTANGLE;
    public static final int RT_ENSURETRAFFICEVENTICONSVISIBILITY;
    public static final int RT_STARTROUTEDRAGGING;
    public static final int RT_DRAGROUTE;
    public static final int RT_SETDRAGROUTEMARKER;
    public static final int RT_HIGHLIGHTROUTEBASEDONLENGTH;
    public static final int RT_EHSETCATEGORYVISIBILITY;
    public static final int RT_EHSETCATEGORYVISIBILITYTODEFAULT;
    public static final int RT_SETMAPOVERLAYS;
    public static final int RT_SETMAPLAYERVISIBLE;
    public static final int RT_SETTEMPERATURESCALE;
    public static final int RT_SETSOFTANIMATIONSPEED;
    public static final int RT_SETSPEEDANDFLOWROADCLASS;
    public static final int RT_SETROUTEVISIBILITY;
    public static final int RT_SETVISIBLEROUTES;
    public static final int RT_SHOWTRAFFICEVENTLISTVIEW;
    public static final int RP_CONFIGUREFLAGS;
    public static final int RP_GETINFOFORPOSITION;
    public static final int RP_GETNUMBEROFPOIS;
    public static final int RP_UNPACKPOICONTAINERRESULT;
    public static final int RP_SETVIEWFOCUSONBLOCKRESULT;
    public static final int RP_STARTTODRAWNEWRECTANGLEINMAPRESULT;
    public static final int RP_SETSOUTHWESTCORNEROFRECTANGLEINMAPRESULT;
    public static final int RP_SETNORTHEASTCORNEROFRECTANGLEINMAPRESULT;
    public static final int RP_FINISHDRAWRECTANGLEINMAPRESULT;
    public static final int RP_DISPLAYREMAININGRANGEOFVEHICLERESULT;
    public static final int RP_TOUCHAPPROACHRESULT;
    public static final int RP_SETBRANDICONSTYLERESULT;
    public static final int RP_SETGUIDANCESYMBOLRESULT;
    public static final int RP_SETHOVLANEVISIBILITYRESULT;
    public static final int RP_RBGETIDOFSELECTEDSEGMENTRESULT;
    public static final int RP_RBGETRRDTOSELECTEDSEGMENTRESULT;
    public static final int RP_SETTOLLROADHIGHLIGHTINGRESULT;
    public static final int RP_SETMOUNTAINPEAKMARKERRESULT;
    public static final int RP_SUSPENDMAPVIEWERRESULT;
    public static final int RP_WAKEUPMAPVIEWERRESULT;
    public static final int RP_ISDETAILEDMAPMATERIALAVAILABLE;
    public static final int RP_SETMAPOVERLAYSRESULT;

    default public void configureFlags(int n, MapFlag[] mapFlagArray) {
    }

    default public void dragMap(short s, short s2) {
    }

    default public void ensureTMCVisibility(long l) {
    }

    default public void getInfoForPosition() {
    }

    default public void getInfoForScreenPosition(Point point) {
    }

    default public void getNumberOfPOIs() {
    }

    default public void goToTMCMessage(long l) {
    }

    default public void packPOIContainer() {
    }

    default public void rbSelectAlternativeRoute(int n) {
    }

    default public void rbSelectNextSegment() {
    }

    default public void rbSelectPreviousSegment() {
    }

    default public void rbSetPosition(int n) {
    }

    default public void scrollToDirection(short s, int n, short s2) {
    }

    default public void selectNextPOI() {
    }

    default public void selectPrevPOI() {
    }

    default public void set3DLandmarksVisible(boolean bl) {
    }

    default public void setCarPosition(Point point) {
    }

    default public void setDayView() {
    }

    default public void setEnableRouteCalcMode(boolean bl) {
    }

    default public void setEnableSoftJump(boolean bl) {
    }

    default public void setEnableSoftRotation(boolean bl) {
    }

    default public void setEnableSoftTilt(boolean bl) {
    }

    default public void setEnableSoftZoom(boolean bl) {
    }

    default public void setHotPoint(Point point) {
    }

    default public void setLocation(int n, short s) {
    }

    default public void setLocationByLocation(NavLocation navLocation) {
    }

    default public void setLocationByLocationAndView(NavLocation navLocation, short s, int n) {
    }

    default public void setMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void setMapViewPort(NavLocationWgs84 navLocationWgs84, short s, int n) {
    }

    default public void setMapViewPortByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
    }

    default public void setMode(int n) {
    }

    default public void setNightView() {
    }

    default public void setOrientation(int n, Point point) {
    }

    default public void setRotation(short s) {
    }

    default public void setViewType(int n) {
    }

    default public void setZoomArea(Rect rect) {
    }

    default public void setZoomLevel(float f2, int n) {
    }

    default public void setCountryOverviewCountry(String string) {
    }

    default public void showTMCMessages(boolean bl) {
    }

    default public void startScrollToDirection(int n) {
    }

    default public void stopScrollToDirection() {
    }

    default public void unpackPOIContainer(long l) {
    }

    default public void viewFreeze(boolean bl) {
    }

    default public void viewSetScreenViewport(Rect rect) {
    }

    default public void viewSetScreenViewportMaximum(Rect rect) {
    }

    default public void viewSetVisible(boolean bl) {
    }

    default public void setMetricSystem(int n) {
    }

    default public void setViewFocusOnBlock(long[] lArray) {
    }

    default public void setViewFocusOnPoi(PoiListElement[] poiListElementArray) {
    }

    default public void startToDrawNewRectangleInMap() {
    }

    default public void editRectangleInMap(long l) {
    }

    default public void setSouthWestCornerOfRectangleInMap(Point point) {
    }

    default public void setNorthEastCornerOfRectangleInMap(Point point) {
    }

    default public void finishDrawRectangleInMap() {
    }

    default public void setCityModelMode(int n) {
    }

    default public void displayRemainingRangeOfVehicle(boolean bl) {
    }

    default public void touchApproach(boolean bl) {
    }

    default public void setBrandIconStyle(int[] nArray, int n) {
    }

    default public void startScrollByVector(int n, int n2) {
    }

    default public void setGuidanceSymbol(int n) {
    }

    default public void setHOVLaneVisibility(boolean bl) {
    }

    default public void rbGetIDOfSelectedSegment() {
    }

    default public void rbGetRRDToSelectedSegment(long l) {
    }

    default public void setTollRoadHighLighting(boolean bl) {
    }

    default public void setMountainPeakMarker(boolean bl) {
    }

    default public void setViewFocusOnCombinedRouteListElements(long[] lArray) {
    }

    default public void setFrameRateMode(int n) {
    }

    default public void setScrollByCrossHairs(boolean bl) {
    }

    default public void setScrollByCrossHairsBoundingBox(Rect rect) {
    }

    default public void setRouteColoringPolicy(int n) {
    }

    default public void setWeatherVisualization(boolean bl) {
    }

    default public void setPictureNavigationIconVisibility(boolean bl, int n) {
    }

    default public void setMobilityHorizonVisibility(boolean bl) {
    }

    default public void setTrafficMapStyle(boolean bl) {
    }

    default public void showSpeedAndFlowFreeFlow(boolean bl) {
    }

    default public void showSpeedAndFlowCongestions(boolean bl) {
    }

    default public void showRichContent(boolean bl) {
    }

    default public void setGeneralPoiVisibility(boolean bl) {
    }

    default public void setCrossHairsColor(int n) {
    }

    default public void setViewPortBorder(int n) {
    }

    default public void setTerrainElevation(boolean bl) {
    }

    default public void ensurePoiVisibility(NavLocation[] navLocationArray) {
    }

    default public void suspendMapViewer() {
    }

    default public void wakeupMapViewer() {
    }

    default public void setMobilityHorizonZoomMode(int n) {
    }

    default public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
    }

    default public void setHorizonMarkerVisibility(boolean bl) {
    }

    default public void ensureTrafficEventIconsVisibility(long[] lArray) {
    }

    default public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
    }

    default public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
    }

    default public void dragRoute(short s, short s2) {
    }

    default public void setDragRouteMarker(int n) {
    }

    default public void highlightRouteBasedOnLength(long l, long l2, int n) {
    }

    default public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryVisibilityToDefault(int n) {
    }

    default public void setMapOverlays(int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
    }

    default public void setMapLayerVisible(int[] nArray) {
    }

    default public void setTemperatureScale(int n) {
    }

    default public void setSoftAnimationSpeed(int n) {
    }

    default public void setSpeedAndFlowRoadClass(int n) {
    }

    default public void setRouteVisibility(boolean bl) {
    }

    default public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
    }

    default public void showTrafficEventListView(long[] lArray, boolean bl, boolean bl2) {
    }
}

