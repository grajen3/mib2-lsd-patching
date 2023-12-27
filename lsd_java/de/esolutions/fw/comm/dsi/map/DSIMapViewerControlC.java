/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerControlC {
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

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

