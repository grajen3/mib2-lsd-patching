/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;

public interface NavigationMapService {
    public static final int MAP_TYPE_UNDEFINED;
    public static final int MAP_TYPE_ONBOARD;
    public static final int MAP_TYPE_GOOGLE;
    public static final int MAP_MODE_OVERVIEW;

    default public void clickInMap(int n, int n2) {
    }

    default public void dragMap(short s, short s2) {
    }

    default public void dragMapStop() {
    }

    default public void goToLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
    }

    default public void goToLocationWithoutLocking(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
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

    default public boolean isMapServiceReady() {
    }

    default public boolean isMapServiceLocked() {
    }

    default public boolean isMapServiceLockedByMe() {
    }

    default public void freeService() {
    }

    default public void configureVicsEventNoticeMap(long l) {
    }

    default public void setGeneralPoiVisibility(boolean bl) {
    }

    default public void releaseView() {
    }

    default public void mapVisibleInOtherContext(boolean bl) {
    }

    default public void activateOverviewZoom() {
    }

    default public void deactivateOverviewZoom() {
    }

    default public void setHotPoint(int n, int n2) {
    }

    default public void setCarsorPosition(int n, int n2) {
    }

    default public void setManeuverViewStyle(int n) {
    }

    default public int getMapType() {
    }

    default public int getLastMapType() {
    }

    default public int getMainMapZoomLevel() {
    }

    default public void viewSetVisible() {
    }

    default public void viewSetInvisible() {
    }

    default public void ensureTMCVisibility(long l) {
    }

    default public boolean isAutozoomActivated() {
    }

    default public void autozoomForcedByOtherContext(boolean bl) {
    }

    default public void setZoomArea(int n, int n2, int n3, int n4) {
    }

    default public int getHeadingValue() {
    }

    default public int getMainMapPerspective() {
    }

    default public boolean isAutozoomDeactivatedWhileDrag() {
    }
}

