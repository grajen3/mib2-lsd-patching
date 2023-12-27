/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationRoute;

public interface NavigationGuidanceService {
    public static final int GUIDANCE_DESTINATION_NEXT_STOPOVER;
    public static final int GUIDANCE_DESTINATION_FINAL;
    public static final int GUIDANCE_RESULT_SUCCESS;
    public static final int GUIDANCE_RESULT_ERROR;
    public static final int RC_STATE_INVALID;
    public static final int RC_STATE_IDLE;
    public static final int RC_STATE_CALCULATING;
    public static final int RC_STATE_FINISHED;
    public static final int GUIDANCE_STATE_INVALID;
    public static final int GUIDANCE_STATE_IDLE;
    public static final int GUIDANCE_STATE_GUIDING;
    public static final int GUIDANCE_MODE_NORMAL;
    public static final int GUIDANCE_MODE_WAYPOINT;
    public static final int GUIDANCE_MODE_PNAV;
    public static final int GUIDANCE_MODE_RUBBERBAND;
    public static final int WPM_MODE_DEFAULT;
    public static final int WPM_MODE_DRIVE;
    public static final int WPM_MODE_RECORD;
    public static final int PNAV_STATUS_OFF;
    public static final int PNAV_STATUS_ACTIVE;
    public static final int PNAV_STATUS_PASSIVE;
    public static final int TRAFFIC_SIGN_MODE_OFF;
    public static final int TRAFFIC_SIGN_MODE_ON;

    default public void calculateRoute(INavigationLocation[] iNavigationLocationArray) {
    }

    default public void calculateRoute(INavigationRoute iNavigationRoute, boolean bl) {
    }

    default public void reCalculateRoute(INavigationRoute iNavigationRoute, boolean bl) {
    }

    default public INavigationRoute getCurrentRoute() {
    }

    default public INavigationRoute getNewRoute() {
    }

    default public void startGuidanceCalculatedRoute(int n) {
    }

    default public int[] getCalculationStates() {
    }

    default public int[] getCalculationRouteIds() {
    }

    default public int getGuidanceState() {
    }

    default public void stopGuidance() {
    }

    default public boolean isRgActive() {
    }

    default public int getGuidanceMode() {
    }

    default public void leaveWaypointMode() {
    }

    default public void setAlternativeRouteCalculation(boolean bl) {
    }

    default public boolean isAlternativeRouteCalculation() {
    }

    default public boolean isDemomodeActive() {
    }

    default public void setDemomodeActive(boolean bl) {
    }

    default public void setDemoDest(INavigationLocation iNavigationLocation) {
    }

    default public INavigationLocation getDemoDest() {
    }

    default public IGuidanceInfo[] getGuidanceInfo() {
    }

    default public boolean isStatusNextStopover() {
    }

    default public boolean isEtaSelected() {
    }

    default public void freeService() {
    }

    default public void triggerEventAudioMessage(int n) {
    }

    default public void startGuidancePNAVRoute(int n) {
    }

    default public void setPNAVStatus(int n) {
    }

    default public int getPnavStatus() {
    }

    default public int getSetupTrafficSignMode() {
    }

    default public int getExecutionMode() {
    }
}

