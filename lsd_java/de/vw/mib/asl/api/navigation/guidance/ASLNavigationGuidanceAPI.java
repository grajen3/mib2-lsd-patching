/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.guidance.IOnlineTourImportListener;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.guidance.IPersistedRouteOptionsSetup;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

public interface ASLNavigationGuidanceAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_MAP_MAIN_RUBBERBAND_MANIPULATION_CANCEL;
    public static final int EV_MAP_MAIN_RUBBERBAND_MANIPULATION_START_CALCULATED_ROUTE;
    public static final int EV_NAVI_GUIDANCE_SETUP_STATUS_LINE_INFORMATION;
    public static final int EV_NAVI_GUIDANCE_SETUP_STATUS_LINE_INFORMATION__P0_BOOLEAN;
    public static final int EV_MAP_MAIN_RUBBERBAND_MANIPULATION_START;
    public static final int EV_MAP_MAIN_RUBBERBAND_MANIPULATION_START_CALCULATED_ROUTE__P0_INT;
    public static final int EV_NAVI_GUIDANCE_CALCULATION_STATE;
    public static final int EV_NAVI_GUIDANCE_CALCULATION_STATE__P0_ASLCALCULATIONSTATE_ARRAY;
    public static final int EV_NAVI_GUIDANCE_GUIDANCE_STATE;
    public static final int EV_NAVI_GUIDANCE_GUIDANCE_STATE__P0_INT;
    public static final int EV_NAVI_GUIDANCE_ERROR_STATE;
    public static final int EV_NAVI_GUIDANCE_ERROR_STATE__P0_INT;
    public static final int EV_NAVI_GUIDANCE_GUIDANCE_MODE;
    public static final int EV_NAVI_GUIDANCE_GUIDANCE_MODE__P0_INT;
    public static final int EV_NAVI_GUIDANCE_GUIDANCE_INFO;
    public static final int EV_NAVI_GUIDANCE_GUIDANCE_INFO__P0_ASLGUIDANCEINFO_ARRAY;
    public static final int EV_EXTERNAL_STOP_GUIDANCE;
    public static final int EV_GUIDANCE_WPM_ENTER;
    public static final int EV_GUIDANCE_WPM_LEAVE;
    public static final int EV_GUIDANCE_RESUME_GUIDANCE;
    public static final int EV_GUIDANCE_WPM_RECORD_STARTED;
    public static final int EV_GUIDANCE_IMPORT_TOUR_FROM_GPX;
    public static final int EV_NAVI_WPM_MODE;
    public static final int EV_NAVI_WPM_MODE__P0_INT;
    public static final int EV_NAVI_WPM_DISTANCE_TO_NEXT_WAYPOINT;
    public static final int EV_NAVI_WPM_DISTANCE_TO_NEXT_WAYPOINT__P0_INT;
    public static final int EV_NAVI_WPM_DIRECTION_TO_NEXT_WAYPOINT;
    public static final int EV_NAVI_WPM_DIRECTION_TO_NEXT_WAYPOINT__P0_INT;
    public static final int EV_NAVI_WPM_IS_RECORDMODE_DEST_SET;
    public static final int EV_NAVI_WPM_IS_RECORDMODE_DEST_SET__P0_BOOLEAN;
    public static final int EV_NAVI_WPM_NUMBER_OF_FREE_POINTS_IN_MEMORY;
    public static final int EV_NAVI_WPM_NUMBER_OF_FREE_POINTS_IN_MEMORY__P0_INT;
    public static final int EV_NAVI_WPM_NUMBER_OF_MAX_POINTS_IN_MEMORY;
    public static final int EV_NAVI_WPM_NUMBER_OF_MAX_POINTS_IN_MEMORY__P0_INT;
    public static final int EV_NAVI_WPM_NUMBER_OF_POINTS_IN_CURRENT_RECORD;
    public static final int EV_NAVI_WPM_NUMBER_OF_POINTS_IN_CURRENT_RECORD__P0_INT;
    public static final int EV_NAVI_GUIDANCE_SETUP_TIME_DISPLAY_SET;
    public static final int EV_NAVI_GUIDANCE_SETUP_TIME_DISPLAY_SET__P0_INT;
    public static final int EV_NAVI_GUIDANCE_TRIGGER_EVENT_AUDIO_MESSAGE;
    public static final int EV_NAVI_GUIDANCE_TRIGGER_EVENT_AUDIO_MESSAGE__P0_INT;
    public static final int EV_NAVI_PNAV_LIKELY_DESTINATIONS;
    public static final int EV_NAVI_PNAV_LIKELY_DESTINATIONS__P0_ASLLIKELYDESTINATION_ARRAY;
    public static final int EV_NAVI_PNAV_SELECTED_DESTINATION;
    public static final int EV_NAVI_PNAV_SELECTED_DESTINATION__P0_ASLLIKELYDESTINATION;
    public static final int EV_NAVI_PNAV_STATUS;
    public static final int EV_NAVI_PNAV_STATUS__P0_INT;
    public static final int EV_NAVI_PNAV_IS_ENABLED;
    public static final int EV_NAVI_PNAV_IS_ENABLED__P0_BOOLEAN;
    public static final int EV_NAVI_PNAV_COMBINED_CALC_STATE;
    public static final int EV_NAVI_PNAV_COMBINED_CALC_STATE__P0_INT;
    public static final int EV_NAVI_GUIDANCE_FINAL_DEST_REACHED;
    public static final int EV_NAVI_GUIDANCE_VZA_VZE;
    public static final int EV_NAVI_GUIDANCE_VZA_VZE__P0_ARRAY;
    public static final int EV_NAVI_GUIDANCE_LANE_GUIDANCE;
    public static final int EV_NAVI_GUIDANCE_LANE_GUIDANCE__P0_ARRAY;
    public static final int EV_NAVI_GUIDANCE_SPEED_CAMERA_ICON;
    public static final int EV_NAVI_GUIDANCE_SPEED_CAMERA_ICON__P0_BOOLEAN;
    public static final int EV_NAVI_GUIDANCE_SATELLITE_SYSTEM;
    public static final int EV_NAVI_GUIDANCE_SATELLITE_SYSTEM__P0_INT;
    public static final int EV_NAVI_GUIDANCE_SETUP_TRAFFIC_SIGN_MODE;
    public static final int EV_NAVI_GUIDANCE_PNAV_VISIBILITY;
    public static final int EV_NAVI_GUIDANCE_PNAV_VISIBLE;
    public static final int EV_NAVI_GUIDANCE_SETUP_TRAFFIC_SIGN_MODE__P0_INT;
    public static final int EV_ASL_INT_DELETE_CONGESTION_AHEAD;
    public static final int PNAV_COMBINED_CALC_STATE_NOT_CALCULATED;
    public static final int PNAV_COMBINED_CALC_STATE_CALCULATING;
    public static final int PNAV_COMBINED_CALC_STATE_RECALCULATING;
    public static final int PNAV_COMBINED_CALC_STATE_CALCULATED;
    public static final int PNAV_STATUS_OFF;
    public static final int PNAV_STATUS_ACTIVE;
    public static final int PNAV_STATUS_PASSIVE;
    public static final int TIME_DISPLAY_SET_RTT;
    public static final int TIME_DISPLAY_SET_ETA;
    public static final int CALCULATION_STATE_IDLE;
    public static final int CALCULATION_STATE_CALCULATING;
    public static final int CALCULATION_STATE_CALC_FINISHED;
    public static final int GUIDANCE_STATE_IDLE;
    public static final int GUIDANCE_STATE_GUIDING;
    public static final int ERROR_STATE_OK;
    public static final int ERROR_STATE_CALC_ALREADY_ACTIVE;
    public static final int ERROR_STATE_NO_DESTINATIONS_AVAILABLE;
    public static final int ERROR_STATE_CALCULATION_NOT_FINISHED;
    public static final int ERROR_STATE_CALCULATION_NOT_STARTED;
    public static final int ERROR_STATE_CALCULATION_SOUTHSIDE_ERROR;
    public static final int ERROR_STATE_CALCULATION_WPM_MODE_ACTIVE;
    public static final int GUIDANCE_MODE_NORMAL;
    public static final int GUIDANCE_MODE_WAYPOINT;
    public static final int GUIDANCE_MODE_PNAV;
    public static final int GUIDANCE_MODE_RUBBERBAND;
    public static final int GUIDANCE_INFO_DESTINATION_TYPE_NEXT_DESTINATION;
    public static final int GUIDANCE_INFO_DESTINATION_TYPE_FINAL_DESTINATION;
    public static final int TIME_FORMAT_ETA;
    public static final int TIME_FORMAT_RTT;
    public static final int WPM_MODE_DEFAULT;
    public static final int WPM_MODE_RECORD;
    public static final int WPM_MODE_DRIVE;
    public static final int TRAFFIC_SIGN_MODE_OFF;
    public static final int TRAFFIC_SIGN_MODE_ON;
    public static final int SRC_UNDEFINED;
    public static final int SRC_ONLINE;
    public static final int SRC_PHONE;
    public static final int SRC_OCU;
    public static final int SRC_MESSAGING;
    public static final int SRC_TRAVELLINK;
    public static final int SRC_SPEECH;
    public static final int SRC_ROUTE_IMPORT;

    default public int getSetupTrafficSignMode() {
    }

    default public boolean isDemomodeActive() {
    }

    default public void setDemoDest(NavLocation navLocation) {
    }

    default public NavLocation getDemoDest() {
    }

    default public IPersistedDestInputSetup getDestInputSetup() {
    }

    default public IPersistedGuidanceSetup getGuidanceSetup() {
    }

    default public IPersistedRouteOptionsSetup getRouteOptionsSetup() {
    }

    default public RouteOptions[] getSingleRouteOptions() {
    }

    default public void setHmiAlternativeRouteCalculation(boolean bl) {
    }

    default public boolean isAlternativeRouteCalculation() {
    }

    default public void sendEvNaviMapMainGuidanceSetupStatusLineInformation(boolean bl) {
    }

    default public void sendEvMapMainRubberbandManipulationCancel() {
    }

    default public void sendEvMapMainRubberbandManipulationStart() {
    }

    default public void sendEvMapMainRubberbandManipulationStartCalculatedRoute(int n) {
    }

    default public void calculateRoute(NavLocation[] navLocationArray, boolean bl) {
    }

    default public void calculateRoute(Route route, boolean bl) {
    }

    default public void recalculateRoute(Route route, boolean bl) {
    }

    default public void calculateRouteWithConfirmation(Route route, int n) {
    }

    default public void startGuidanceCalculatedRoute(int n) {
    }

    default public void stopGuidance() {
    }

    default public int getGuidanceState() {
    }

    default public int getGuidanceMode() {
    }

    default public ASLCalculationState[] getCalculationState() {
    }

    default public Route getCurrentRoute() {
    }

    default public void leaveWaypointMode() {
    }

    default public int getTimeFormat() {
    }

    default public int getMaxNumberOfDestinations() {
    }

    default public int getNumberOfDestinations() {
    }

    default public int getExecutionMode() {
    }

    default public void setExecutionMode(int n) {
    }

    default public NavRmRouteListArrayData getNavRmRouteList() {
    }

    default public void importToursFromGpx(String string) {
    }

    default public void sendEvTourModeOnlineImportMemFull() {
    }

    default public void sendEvTourModeOnlineImportAvailable() {
    }

    default public void registerListener(IOnlineTourImportListener iOnlineTourImportListener) {
    }

    default public void unregisterListener(IOnlineTourImportListener iOnlineTourImportListener) {
    }

    default public void triggerEventAudioMessage(int n) {
    }

    default public void startGuidancePNAVRoute(int n) {
    }

    default public void setPNAVStatus(int n) {
    }

    default public int getPnavStatus() {
    }

    default public Integer getCalculatedTourMemoryCapacity() {
    }
}

