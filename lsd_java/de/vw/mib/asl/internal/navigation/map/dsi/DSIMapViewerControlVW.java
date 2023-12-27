/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi;

import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerControlVW {
    default public void configureFlags(int n, MapFlag[] mapFlagArray) {
    }

    default public void dragMap(short s, short s2) {
    }

    default public void dragRoute(short s, short s2) {
    }

    default public void ehSetCategoryVisibility(int[] nArray, boolean[] blArray) {
    }

    default public void ehSetCategoryVisibilityToDefault() {
    }

    default public void ensurePoiVisibility(NavLocation[] navLocationArray) {
    }

    default public void ensureTMCVisibility(long l) {
    }

    default public void getInfoForScreenPosition(AbstractTarget abstractTarget, Point point) {
    }

    default public void goToTMCMessage(long l) {
    }

    default public void rbSelectAlternativeRoute(int n) {
    }

    default public void set3DLandmarksVisible(boolean bl) {
    }

    default public void setBrandIconStyle(int[] nArray, int n) {
    }

    default public void setCarPosition(Point point) {
    }

    default public void setCityModelMode(int n) {
    }

    default public void setDayView() {
    }

    default public void setDragRouteMarker(int n) {
    }

    default public void setEnableSoftJump(boolean bl) {
    }

    default public void setEnableSoftTilt(boolean bl) {
    }

    default public void setEnableSoftZoom(boolean bl) {
    }

    default public void setGeneralPoiVisibility(boolean bl) {
    }

    default public void setHotPoint(Point point) {
    }

    default public void setLocation(int n, short s) {
    }

    default public void setLocationByLocation(NavLocation navLocation) {
    }

    default public void setMapLayerVisible(int[] nArray) {
    }

    default public void setMapViewPortByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
    }

    default public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
    }

    default public void setMetricSystem(int n) {
    }

    default public void setMobilityHorizonVisibility(boolean bl) {
    }

    default public void setMobilityHorizonZoomMode(int n) {
    }

    default public void setMode(int n) {
    }

    default public void setNightView() {
    }

    default public void setOrientation(int n, Point point) {
    }

    default public void setRotation(short s) {
    }

    default public void setRouteColoringPolicy(int n) {
    }

    default public void setRouteVisibility(boolean bl) {
    }

    default public void setScreenViewport(Rect rect) {
    }

    default public void setScreenViewportMaximum(Rect rect) {
    }

    default public void setSpeedAndFlowRoadClass(int n) {
    }

    default public void setTemperatureScale(int n) {
    }

    default public void setTrafficMapStyle(boolean bl) {
    }

    default public void setViewType(int n) {
    }

    default public void setZoomArea(Rect rect) {
    }

    default public void setZoomLevel(float f2, int n) {
    }

    default public void showSpeedAndFlowCongestions(boolean bl) {
    }

    default public void showSpeedAndFlowFreeFlow(boolean bl) {
    }

    default public void showTMCMessages(boolean bl) {
    }

    default public void showTrafficEventListView(long[] lArray, boolean bl, boolean bl2) {
    }

    default public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
    }

    default public void stopScrollToDirection() {
    }

    default public void touchApproach(boolean bl) {
    }

    default public void viewFreeze(boolean bl) {
    }

    default public void viewSetVisible(boolean bl) {
    }
}

