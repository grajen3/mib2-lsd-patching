/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.map.TrafficDualListViewConfiguration;
import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.organizer.AdbEntry;

public interface ASLNavigationMapAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_MOBILITS_HORIZON_SERVICE_AVAILABLE;
    public static final int EV_MOBILITS_HORIZON_SERVICE_NOT_AVAILABLE;
    public static final int EV_DEST_INPUT_HOME_LOCATION_CHANGED;
    public static final int EV_MAP_MAIN_CONTENT_GOTO_LOCATION;
    public static final int EV_MAP_MAIN_CONTENT_GOTO_LOCATION__P0_TYPE_INT;
    public static final int EV_MAP_MAIN_CONTENT_GOTO_LOCATION__P1_MAP_CONFIGURATION;
    public static final int EV_LIST_VIEW_UPDATE;
    public static final int EV_LIST_VIEW_UPDATE__P0_NAV_LOCATION_ARRAY;
    public static final int EV_LIST_VIEW_UPDATE__P1_FLAGTYPE_INT;
    public static final int EV_LIST_VIEW_UPDATE__C0_FLAGTYPE_PIN_VW;
    public static final int EV_LIST_VIEW_UPDATE__C1_FLAGTYPE_PIN_GOOGLE;
    public static final int EV_LIST_VIEW_START_SCROLL;
    public static final int EV_MAP_MAIN_SHOW_TMC_MESSAGE;
    public static final int EV_MAP_MAIN_SHOW_TMC_MESSAGE__P0_TMC_MESSAGE;
    public static final int EV_MAP_MAIN_ROCKETZOOM_TIMEOUT;
    public static final int EV_MAP_MAIN_SWITCH_MAPVIEWER_TIMEOUT_WAKEUP;
    public static final int EV_MAP_MAIN_SWITCH_MAPVIEWER_TIMEOUT_SUSPEND;
    public static final int EV_POI_SETUP_PREFERRED_BRANDS_HAVE_CHANGED;
    public static final int EV_MAP_INSTANCE_KOMBI_READY;
    public static final int EV_MAP_INSTANCE_KOMBI_NOT_READY;
    public static final int EV_MAP_INSTANCE_MAIN_READY;
    public static final int EV_MAP_INSTANCE_MAIN_NOT_READY;
    public static final int EV_MAP_INSTANCE_MAP_IN_MAP_READY;
    public static final int EV_MAP_INSTANCE_MAP_IN_MAP_NOT_READY;
    public static final int EV_MAP_INSTANCE_GOOGLE_EARTH_READY;
    public static final int EV_MAP_INSTANCE_GOOGLE_EARTH_NOT_READY;
    public static final int EV_API_TRIGGER_ONLINE_DESTINATION_IMPORT_ERROR_RESPONSE;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION__P0_TARGET;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION__P1_POINT;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION_RESULT;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION_RESULT__P0_POSINFO_ARRAY;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY__P1_INT_ARRAY;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY__P2_BOOLEAN_ARRAY;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY_TO_DEFAULT;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY_TO_DEFAULT__P0_INT;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY_RESULT;
    public static final int EV_MAP_MAIN_EH_SET_CATEGORY_VISIBILITY_RESULT__P0_INT_ARRAY;
    public static final int EV_MAP_MAIN_RB_SELECT_ALTERNATIVE_ROUTE;
    public static final int EV_MAP_MAIN_RB_SELECT_ALTERNATIVE_ROUTE__P0_INT;
    public static final int EV_MAP_MAIN_ACTIVATE_FINAL_DESTINATION_ZOOM;
    public static final int EV_MAP_MAIN_ACTIVATE_DESTINATION_ZOOM;
    public static final int EV_MAP_MAIN_TWO_FINGERS_ZOOM_DONE;
    public static final int EV_NAVI_STATUS_CHANGE;
    public static final int EV_ADDRESS_BOOK_ENTRY_CHANGED;
    public static final int EV_ADDRESS_BOOK_ENTRY_CHANGED__PO_ADBENTRY;
    public static final int EV_NAVI_POST_STARTUP;
    public static final int EV_SERVICE_AVAILABLE_CHANGED_GOOGLE_EARTH;
    public static final int EV_SERVICE_AVAILABLE_CHANGED_GOOGLE_EARTH__P0_BOOLEAN;
    public static final int EV_SERVICE_AVAILABLE_CHANGED_GOOGLE_STREETVIEW;
    public static final int EV_SERVICE_AVAILABLE_CHANGED_GOOGLE_STREETVIEW__P0_BOOLEAN;
    public static final int EV_MAP_MAIN_ZOOMINDEX_CHANGED;
    public static final int EV_MAP_MAIN_ZOOMINDEX_CHANGED__P0_ZOOMINDEX_INT;
    public static final int EV_MAP_MAIN_MAP_MOVED_BY_USER;
    public static final int EV_MAP_MAIN_GOOGLE_EARTH_MAP_POSITION_CHANGED;
    public static final int EV_MAP_MAIN_GOOGLE_EARTH_CHECK_CROSSHAIR_VISIBILITY;
    public static final int EV_MAP_MAIN_GOOGLE_EARTH_CLEAR_CACHE;
    public static final int EV_MAP_MAIN_SWITCH_MAPVIEWER_DONE;
    public static final int EV_MAP_MAIN_DRAWN;
    public static final int EV_MAP_MAIN_ZOOMLEVEL_CHANGED;
    public static final int EV_MAP_MAIN_ZOOMLEVEL_CHANGED__P0_ZOOMLEVEL_INT;
    public static final int EV_MAP_MAIN_SWITCH_MAPVIEWER_TIMEOUT_VIEWFREEZE;
    public static final int EV_LICENSE_VALID_CHANGED_GOOGLE_EARTH;
    public static final int EV_LICENSE_VALID_CHANGED_GOOGLE_EARTH__P0_VALID_BOOLEAN;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION_RESULT_ASYNC_EXCEPTION;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION_RESULT_ASYNC_EXCEPTION__P0_REQUEST_TYPE_INT;
    public static final int EV_MAP_MAIN_GET_INFO_FOR_SCREEN_POSITION_RESULT_ASYNC_EXCEPTION__P1_ERROR_CODE_INT;
    public static final int EV_MAP_MAIN_WAYPOINT_MODE_RECORD_DESTINATION_FLAG;
    public static final int EV_MAP_MAIN_WAYPOINT_MODE_RECORD_DESTINATION_FLAG__P0_NAVLOCATION;
    public static final int EV_MAP_MAIN_WAYPOINT_MODE_RECORD_DESTINATION_FLAG__P1_FLAG_STYLETYPE_INT;
    public static final int EV_MAP_MAIN_ROUTE_VISIBILITY;
    public static final int EV_MAP_MAIN_ROUTE_VISIBILITY__P0_ROUTE_VISIBLE_BOOLEAN;
    public static final int EV_MAP_INSTANCE_KOMBI_ADAPTION_API_UPDATE;
    public static final int EV_MAP_IN_MAP_PERSPECTIVE_CHANGED;
    public static final int EV_MAP_IN_MAP_ZOOMLEVEL_CHANGED;
    public static final int EV_DESTINATION_IMPORT_ACTIVE;
    public static final int EV_DESTINATION_IMPORT_ACTIVE_P0_ACTIVE;
    public static final int EV_MAP_MAIN_GOOGLE_STREETVIEW_AVAILABLE;
    public static final int EV_MAP_MAIN_GOOGLE_STREETVIEW_AVAILABLE__P0_AVAILABLE_BOOLEAN;
    public static final int EV_MAP_MAIN_GOOGLE_STREETVIEW_AVAILABLE__P1_LAT_INT;
    public static final int EV_MAP_MAIN_GOOGLE_STREETVIEW_AVAILABLE__P2_LONG_INT;
    public static final int EV_MAP_MAIN_SPEECH_RECOGNIZER_ACTIVE;
    public static final int EV_MAP_MAIN_SPEECH_RECOGNIZER_INACTIVE;
    public static final int EV_MAP_MAIN_DISPLAYABLE_MAP_HIDDEN;
    public static final int EV_MAP_MAIN_DISPLAYABLE_MAP_SHOWN;
    public static final int EV_MAP_MAIN_SWITCH_TO_ABT;
    public static final int EV_MAP_MAIN_SWITCH_TO_KOMBI;
    public static final int EV_MAP_SHOW_TMC_DUAL_LIST;
    public static final int EV_MAP_SHOW_TMC_DUAL_LIST__P0_CONFIG;
    public static final int EV_MAP_MAIN_GUIDANCE_STATE_CHANGED;
    public static final int EV_MAP_MAIN_GUIDANCE_STATE_CHANGED__P0_STATE_INT;
    public static final int EV_MAP_FORWARD_TRAFFIC_VISIBLITY_TO_KOMBI;
    public static final int EV_MAP_FORWARD_TRAFFIC_VISIBLITY_TO_KOMBI__P0_CONGESTION_BOOLEAN;
    public static final int EV_MAP_FORWARD_TRAFFIC_VISIBLITY_TO_KOMBI__P1_FREEFLOW_BOOLEAN;
    public static final int EV_MAP_MAIN_SWITCH_FINISHED;
    public static final int EV_MAP_MAIN_SET_STREETVIEW_POSITION;
    public static final int EV_MAP_MAIN_SET_STREETVIEW_POSITION__P0_POSITION_WGS84;
    public static final int EV_MAP_MAIN_TRIGGER_SWITCH;
    public static final int EV_MAP_MAIN_HEADING_VALUE_CHANGED;
    public static final int EV_MAP_MAIN_HEADING_VALUE_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_ZOOM_VALUE_CHANGED;
    public static final int EV_MAP_MAIN_ZOOM_VALUE_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_ALTITUDE_VALUE_CHANGED;
    public static final int EV_MAP_MAIN_ALTITUDE_VALUE_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_AUTOZOOM_STATUS_CHANGED;
    public static final int EV_MAP_MAIN_AUTOZOOM_STATUS_CHANGED__P0_BOOLEAN;
    public static final int EV_MAP_VISIBLE_IN_ANOTHER_CONTEXT;
    public static final int EV_MAP_VISIBLE_IN_ANOTHER_CONTEXT__P0_BOOLEAN;
    public static final int EV_MAP_MAIN_ORIENTATION_CHANGED;
    public static final int EV_MAP_MAIN_ORIENTATION_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_VIEW_TYPE_CHANGED;
    public static final int EV_MAP_MAIN_VIEW_TYPE_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_MAP_MODE_CHANGED;
    public static final int EV_MAP_MAIN_MAP_MODE_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_MAP_TYPE_CHANGED;
    public static final int EV_MAP_MAIN_MAP_TYPE_CHANGED__P0_INT;
    public static final int EV_MAP_IC_MAP_SERVICE_STATE_CHANGED;
    public static final int EV_MAP_IC_MAP_SERVICE_STATE_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_MAP_PERSPECTIVE_CHANGED;
    public static final int EV_MAP_MAIN_MAP_PERSPECTIVE_CHANGED__P0_INT;
    public static final int EV_AUTOZOOM_FORCED_BY_OTHER_CONTEXT;
    public static final int EV_AUTOZOOM_FORCED_BY_OTHER_CONTEXT__P0_BOOLEAN;
    public static final int EV_SET_ZOOM_AREA;
    public static final int EV_SET_ZOOM_AREA_RECT__P0_INT;
    public static final int EV_SET_ZOOM_AREA_RECT__P1_INT;
    public static final int EV_SET_ZOOM_AREA_RECT__P2_INT;
    public static final int EV_SET_ZOOM_AREA_RECT__P3_INT;
    public static final int EV_MAP_MAIN_MAP_LAST_TYPE_CHANGED;
    public static final int EV_GOOGLE_EARTH_DATA_STATUS_CHANGED;
    public static final int EV_GOOGLE_EARTH_DATA_STATUS_CHANGED__P0_INT;
    public static final int EV_MAP_MAIN_SWITCH_MAPVIEWER_RUNNING;
    public static final int EV_MAP_SWITCHER_READY;
    public static final int DO_GOOGLE_EARTH_SERVICE_REQUEST;

    default public boolean isGoogleEarthActive() {
    }

    default public boolean isSplitScreenGuidance() {
    }

    default public void setSplitScreenGuidance(boolean bl) {
    }

    default public boolean isSplitScreenNoGuidance() {
    }

    default public void setSplitScreenNoGuidance(boolean bl) {
    }

    default public int getSplitScreenContentGuidance() {
    }

    default public void setSplitScreenContentGuidance(int n) {
    }

    default public int getSplitScreenContentNoGuidance() {
    }

    default public void setSplitScreenContentNoGuidance(int n) {
    }

    default public void preRegisterServices() {
    }

    default public ASLNavigationServiceMainMap createMainMapService(AbstractTarget abstractTarget, int[] nArray) {
    }

    default public void sendEvAddressBookEntryChanged(AbstractTarget abstractTarget, AdbEntry adbEntry) {
    }

    default public void sendEvDestInputHomeLocationChanged() {
    }

    default public void sendEvListViewStartScroll() {
    }

    default public void sendEvListViewUpdate(NavLocation[] navLocationArray, int n) {
    }

    default public void sendEvMapInstanceGoogleNotReady() {
    }

    default public void sendEvMapInstanceGoogleReady() {
    }

    default public void sendEvMapInstanceKombiNotReady() {
    }

    default public void sendEvMapInstanceKombiReady() {
    }

    default public void sendEvMapInstanceMainNotReady() {
    }

    default public void sendEvMapInstanceMainNotReadyToNavStartupTarget() {
    }

    default public void sendEvMapInstanceMainReady() {
    }

    default public void sendEvMapInstanceMainReadyToNavStartupTarget() {
    }

    default public void sendEvMapInstanceMapInMapNotReady() {
    }

    default public void sendEvMapInstanceMapInMapNotReadyToNavStartupTarget() {
    }

    default public void sendEvMapInstanceMapInMapReady() {
    }

    default public void sendEvMapInstanceMapInMapReadyToNavStartupTarget() {
    }

    default public void sendEvMapMainActivateDestinationZoom() {
    }

    default public void sendEvMapMainActivateFinalDestinationZoom() {
    }

    default public void sendEvMapMainContentGotoLocation(int n, MapConfiguration mapConfiguration) {
    }

    default public void sendEvMapMainEhSetCategoryVisibility(int[] nArray, boolean[] blArray) {
    }

    default public void sendEvMapMainEhSetCategoryVisibilityResult(int[] nArray) {
    }

    default public void sendEvMapMainEhSetCategoryVisibilityToDefault() {
    }

    default public void sendEvMapMainGetInfoForScreenPosition(AbstractTarget abstractTarget, Point point) {
    }

    default public void sendEvMapMainGetInfoForScreenPositionResult(AbstractTarget abstractTarget, AbstractTarget abstractTarget2, PosInfo[] posInfoArray) {
    }

    default public void sendEvMapMainRbSelectAlternativeRoute(int n) {
    }

    default public void sendEvMapMainServiceAvailableChangedGoogleEarth(boolean bl) {
    }

    default public void sendEvMapMainServiceAvailableChangedGoogleStreetView(boolean bl) {
    }

    default public void sendEvMapMainTwoFingersZoomDone() {
    }

    default public void sendEvMapMainZoomIndexChanged(int n) {
    }

    default public void sendEvMobilityHorizonServiceAvailable() {
    }

    default public void sendEvMobilityHorizonServiceNotAvailable() {
    }

    default public void sendEvNaviPostStartup() {
    }

    default public void sendEvShowTMCMessageInMap(TrafficMessageDetails trafficMessageDetails) {
    }

    default public void sendEvMapMainGoogleEarthMapPositionChanged() {
    }

    default public void sendEvMapMainGoogleEarthCheckCrosshairVisibility() {
    }

    default public void sendEvMapMainGoogleEarthClearCache() {
    }

    default public void sendEvMapMainSwitchMapViewerDone() {
    }

    default public void sendEvMapMainDrawn() {
    }

    default public void sendEvMapMainMapMovedByUser() {
    }

    default public void sendEvMapMainZoomLevelChanged(int n) {
    }

    default public void sendEvLicenseValidChangedGoogleEarth(boolean bl) {
    }

    default public void sendEvMapMainGetInfoForScreenPositionResultAsyncException(AbstractTarget abstractTarget, AbstractTarget abstractTarget2, int n, int n2) {
    }

    default public void sendEvMapMainWaypointModeRecordDestinationFlag(NavLocation navLocation, int n) {
    }

    default public void sendEvMapMainRouteVisibility(boolean bl) {
    }

    default public void sendEvMapInMapPerspectiveChanged() {
    }

    default public void sendEvMapInMapZoomLevelChanged() {
    }

    default public void sendEvMapMainGoogleStreetViewAvailable(boolean bl, int n, int n2) {
    }

    default public void sendEvMapMainSpeechRecognizerActive() {
    }

    default public void sendEvMapMainSpeechRecognizerInactive() {
    }

    default public boolean isMainMapReady() {
    }

    default public void sendEvKombiMapDisplayableMapHidden() {
    }

    default public void sendEvKombiMapDisplayableMapShown() {
    }

    default public void sendEvMapViewSwitchToABT() {
    }

    default public void sendEvMapViewSwitchToKombi() {
    }

    default public void sendEvMapShowTMCDualList(TrafficDualListViewConfiguration trafficDualListViewConfiguration) {
    }

    default public void sendEvMapMainGuidanceStateChanged(int n) {
    }

    default public void sendEvMapForwardTrafficVisibilityToKombi(boolean bl, boolean bl2) {
    }

    default public void sendEvMapForwardTrafficIncidentVisibilityToKombi(boolean bl) {
    }

    default public void sendMapViewMapSwitchFinished() {
    }

    default public void sendMapMainSetStreetViewPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void sendMapViewMapTriggerSwitch() {
    }

    default public void sendEvMapMainHeadingValueChanged(int n) {
    }

    default public void sendEvMapMainZoomValueChanged(int n) {
    }

    default public void sendEvMapMainAltitudeValueChanged(int n) {
    }

    default public void sendEvMapMainAutozoomStatusChanged(boolean bl) {
    }

    default public void sendEvMapVisibleInAnotherContext(boolean bl) {
    }

    default public void sendEvMapMainOrientationChanged(int n) {
    }

    default public void sendEvMapMainViewTypeChanged(int n) {
    }

    default public void sendEvMapMainMapModeChanged(int n) {
    }

    default public void sendEvMapMainActivateOverviewZoom() {
    }

    default public void sendEvMapMainHotPointChanged(int n, int n2) {
    }

    default public void sendEvMapMainCarsorPositionChanged(int n, int n2) {
    }

    default public void sendEvMapMainMapTypeChanged(int n) {
    }

    default public void sendEvMapICMapServiceStateChanged(int n) {
    }

    default public boolean isAutozoomActivated() {
    }

    default public boolean isAutozoomDeactivatedWhileDrag() {
    }

    default public void sendEvAutozoomForcedByOtherContext(boolean bl) {
    }

    default public void sendEvMapMainSetZoomArea(int n, int n2, int n3, int n4) {
    }

    default public void sendEvMapMainMapLastTypeChanged(int n) {
    }

    default public void sendEvMapMainMapPerspectiveStateChanged(int n) {
    }

    default public void sendEvGoogleEarthDataStatusChanged(int n) {
    }

    default public void sendEvMapMainSwitchMapViewerRunning() {
    }

    default public void sendEvMapSwitcherReady() {
    }
}

