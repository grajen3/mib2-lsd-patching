/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public interface DSIMapViewerControlListener
extends DSIListener {
    default public void updateReady(boolean bl, int n) {
    }

    default public void updateCurrentViewType(int n, int n2) {
    }

    default public void updateDayNightView(boolean bl, int n) {
    }

    default public void updateViewScreenViewPort(Rect rect, int n) {
    }

    default public void updateViewScreenViewPortMaximum(Rect rect, int n) {
    }

    default public void updateViewVisible(boolean bl, int n) {
    }

    default public void updateViewFreeze(boolean bl, int n) {
    }

    default public void updateZoomLevel(float f2, int n) {
    }

    default public void updateZoomList(float[] fArray, int n) {
    }

    default public void updateZoomListIndex(int n, int n2) {
    }

    default public void updateMapRotation(short s, int n) {
    }

    default public void updateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
    }

    default public void updateMapOrientation(int n, int n2) {
    }

    default public void updateCarPosition(Point point, int n) {
    }

    default public void updateTmcVisible(boolean bl, int n) {
    }

    default public void updateMapMode(int n, int n2) {
    }

    default public void updateSelectedPoi(PosInfo posInfo, int n) {
    }

    default public void updateSpeedAndFlowVisible(boolean bl, int n) {
    }

    default public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
    }

    default public void updateViewPort(ViewPort viewPort, int n) {
    }

    default public void updateSoftJumpEnabled(boolean bl, int n) {
    }

    default public void updateSoftRotationEnabled(boolean bl, int n) {
    }

    default public void updateSoftTiltEnabled(boolean bl, int n) {
    }

    default public void updateSoftZoomEnabled(boolean bl, int n) {
    }

    default public void updateSoftJumpRunning(boolean bl, int n) {
    }

    default public void updateSoftRotationRunning(boolean bl, int n) {
    }

    default public void updateSoftTiltRunning(boolean bl, int n) {
    }

    default public void updateSoftZoomRunning(boolean bl, int n) {
    }

    default public void updateRouteCalcModeEnabled(boolean bl, int n) {
    }

    default public void updateRBInfoOfSelectedSegments(RouteBrowserInfo routeBrowserInfo, int n) {
    }

    default public void configureFlags(long[] lArray) {
    }

    default public void getInfoForPosition(PosInfo[] posInfoArray) {
    }

    default public void getNumberOfPOIs(long l) {
    }

    default public void unpackPOIContainerResult(boolean bl) {
    }

    default public void updateCurrentLanduseStyle(int n, int n2) {
    }

    default public void updateCurrentMetricSystem(int n, int n2) {
    }

    default public void setViewFocusOnBlockResult(int n) {
    }

    default public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    default public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
    }

    default public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
    }

    default public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    default public void updateCityModelMode(int n, int n2) {
    }

    default public void displayRemainingRangeOfVehicleResult(boolean bl) {
    }

    default public void touchApproachResult(boolean bl) {
    }

    default public void setBrandIconStyleResult(int n) {
    }

    default public void setGuidanceSymbolResult(int n) {
    }

    default public void setHOVLaneVisibilityResult(int n) {
    }

    default public void rbGetIDOfSelectedSegmentResult(long l, int n) {
    }

    default public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
    }

    default public void setTollRoadHighLightingResult(boolean bl, int n) {
    }

    default public void setMountainPeakMarkerResult(boolean bl, int n) {
    }

    default public void suspendMapViewerResult(int n) {
    }

    default public void wakeupMapViewerResult(int n) {
    }

    default public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    default public void updateMapViewerRunLevel(int n, int n2) {
    }

    default public void updateMapViewerSuspensionSupported(int n, int n2) {
    }

    default public void updateMapViewerSuspensionAndWakeUpProgress(int n, int n2) {
    }

    default public void updateAvailableCountryOverviews(String[] stringArray, int n) {
    }

    default public void updateGeneralPoiVisibility(boolean bl, int n) {
    }

    default public void updateHorizonMarkerVisibility(boolean bl, int n) {
    }

    default public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84, int n) {
    }

    default public void updateEhCategoryVisibility(int[] nArray, int n) {
    }

    default public void setMapOverlaysResult(int n, int n2) {
    }

    default public void updateMapLayerAvailable(int[] nArray, int n) {
    }

    default public void updateMapLayerVisible(int[] nArray, int n) {
    }

    default public void updateTemperatureScale(int n, int n2) {
    }

    default public void updateSpeedAndFlowRoadClass(int n, int n2) {
    }

    default public void updateRouteVisibility(boolean bl, int n) {
    }

    default public void updateSoftAnimationSpeed(int n, int n2) {
    }
}

