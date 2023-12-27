/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import org.dsi.ifc.map.Point;

public interface ASLNavigationServiceMainMap {
    public static final int EVENT_MAP_CLICK_IN_MAP_RESULT;
    public static final int EVENT_MAP_CLICK_IN_MAP_RESULT__P0_POSINFO_ARRAY;
    public static final int EVENT_MAP_GOTO_LOCATION_MAP_READY;
    public static final int EVENT_MAP_LAYER_AVAILABLE_UPDATE;
    public static final int EVENT_MAP_LAYER_AVAILABLE_UPDATE__P0_INT_ARRAY;
    public static final int EVENT_MAP_LAYER_VISIBLE_UPDATE;
    public static final int EVENT_MAP_LAYER_VISIBLE_UPDATE__P0_INT_ARRAY;
    public static final int EVENT_MAP_LOCKED;
    public static final int EVENT_MAP_POSITION_UPDATE;
    public static final int EVENT_MAP_POSITION_UPDATE__P0_NAV_LOCATION;
    public static final int EVENT_MAP_ZOOM_IN_DONE;
    public static final int EVENT_MAP_ZOOM_LEVEL_UPDATE;
    public static final int EVENT_MAP_ZOOM_LEVEL_UPDATE__P0_INT;
    public static final int EVENT_MAP_ZOOM_LEVEL_UPDATE__P1_INT;
    public static final int EVENT_MAP_ZOOM_LIST_UPDATE;
    public static final int EVENT_MAP_ZOOM_LIST_UPDATE__P0_INT_ARRAY;
    public static final int EVENT_MAP_ZOOM_OUT_DONE;
    public static final int ASL_NAVI_MAP_USED_BY_CLIENT;
    public static final int ASL_NAVI_MAP_USED_BY_CLIENT_P0_TARGET;
    public static final int EVENT_SERVICE_ERROR;
    public static final int EVENT_SERVICE_ERROR__C0_UNDEFIND_ERROR;
    public static final int EVENT_SERVICE_ERROR__C0_UNDEFINED_ERROR;
    public static final int EVENT_SERVICE_ERROR__C1_CUSTOMER_UPDATE_ACTIVE;
    public static final int EVENT_SERVICE_ERROR__C2_DATABASE_ACCESS_NOT_GRANTED;
    public static final int EVENT_SERVICE_ERROR__C3_DATABASE_FAILURE;
    public static final int EVENT_SERVICE_ERROR__C4_DATABASE_REMOVED;
    public static final int EVENT_SERVICE_ERROR__C5_CHECKING_DATABASE;
    public static final int EVENT_SERVICE_ERROR__C6_API_CALL_ERROR;
    public static final int EVENT_SERVICE_ERROR__C7_NAV_DOMAIN_NOT_AVAILABLE;
    public static final int EVENT_SERVICE_ERROR__P0_ERROR_CODE_INT;
    public static final int EVENT_SERVICE_ERROR__P1_REQUEST_TYPE_INT;
    public static final int EVENT_SERVICE_ERROR__P2_REQUEST_ERROR_CODE_INT;
    public static final int EVENT_SERVICE_INIT;
    public static final int EVENT_SERVICE_NOT_READY;
    public static final int EVENT_SERVICE_READY;
    public static final int EVENT_KOMBI_MAP_SWITCH_STATE_UPDATE;
    public static final int EVENT_KOMBI_MAP_SWITCH_STATE_UPDATE_P0_RESULT_INT;

    default public void clickInMap(Point point) {
    }

    default public void dragMap(short s, short s2) {
    }

    default public void dragMapStop() {
    }

    default public void goToLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
    }

    default public void goToLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration, boolean bl) {
    }

    default public void lockMapViewer() {
    }

    default public void setTrafficIncidents(boolean bl) {
    }

    default public void unlockMapViewer() {
    }

    default public void zoomIn() {
    }

    default public void zoomOut() {
    }

    default public void zoomTwoFingers(int n, int n2, int n3, int n4) {
    }

    default public void zoomTwoFingersStop() {
    }

    default public void setMapSwitchState(int n) {
    }

    default public int getMapSwitchState() {
    }

    default public int getHeadingValue() {
    }

    default public boolean getMapVisibilityForFPKSwitch() {
    }

    default public void configureVicsEventNoticeMap(long l) {
    }

    default public void setGeneralPoiVisibility(boolean bl) {
    }

    default public void releaseView() {
    }

    default public int getICMapServiceState() {
    }

    default public boolean isMapSwitchFunctionAvailableInKombi() {
    }

    default public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
    }

    default public int getMainMapZoomLevel() {
    }

    default public void viewSetVisible() {
    }

    default public void viewSetInvisible() {
    }

    default public void ensureTMCVisibility(long l) {
    }

    default public void deactivateOverviewZoom() {
    }

    default public int getMainMapPerspective() {
    }

    default public boolean isMapTemporarilyInABT() {
    }
}

