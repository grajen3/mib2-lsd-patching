/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerControlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.osgi.framework.BundleContext;

public class DSIMapViewerControlProvider
extends AbstractProvider
implements DSIMapViewerControl {
    private static final int[] attributeIDs = new int[]{1, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private DSIMapViewerControlProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public DSIMapViewerControlProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerControlProvider.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMapViewerControlProxy(this.instance, (DSIMapViewerControlReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        try {
            this.proxy.configureFlags(n, mapFlagArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dragMap(short s, short s2) {
        try {
            this.proxy.dragMap(s, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ensureTMCVisibility(long l) {
        try {
            this.proxy.ensureTMCVisibility(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getInfoForPosition() {
        try {
            this.proxy.getInfoForPosition();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getInfoForScreenPosition(Point point) {
        try {
            this.proxy.getInfoForScreenPosition(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getNumberOfPOIs() {
        try {
            this.proxy.getNumberOfPOIs();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void goToTMCMessage(long l) {
        try {
            this.proxy.goToTMCMessage(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void packPOIContainer() {
        try {
            this.proxy.packPOIContainer();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rbSelectAlternativeRoute(int n) {
        try {
            this.proxy.rbSelectAlternativeRoute(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rbSelectNextSegment() {
        try {
            this.proxy.rbSelectNextSegment();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rbSelectPreviousSegment() {
        try {
            this.proxy.rbSelectPreviousSegment();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rbSetPosition(int n) {
        try {
            this.proxy.rbSetPosition(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void scrollToDirection(short s, int n, short s2) {
        try {
            this.proxy.scrollToDirection(s, n, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectNextPOI() {
        try {
            this.proxy.selectNextPOI();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectPrevPOI() {
        try {
            this.proxy.selectPrevPOI();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void set3DLandmarksVisible(boolean bl) {
        try {
            this.proxy.set3DLandmarksVisible(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCarPosition(Point point) {
        try {
            this.proxy.setCarPosition(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDayView() {
        try {
            this.proxy.setDayView();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEnableRouteCalcMode(boolean bl) {
        try {
            this.proxy.setEnableRouteCalcMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEnableSoftJump(boolean bl) {
        try {
            this.proxy.setEnableSoftJump(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEnableSoftRotation(boolean bl) {
        try {
            this.proxy.setEnableSoftRotation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEnableSoftTilt(boolean bl) {
        try {
            this.proxy.setEnableSoftTilt(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEnableSoftZoom(boolean bl) {
        try {
            this.proxy.setEnableSoftZoom(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHotPoint(Point point) {
        try {
            this.proxy.setHotPoint(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLocation(int n, short s) {
        try {
            this.proxy.setLocation(n, s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLocationByLocation(NavLocation navLocation) {
        try {
            this.proxy.setLocationByLocation(navLocation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLocationByLocationAndView(NavLocation navLocation, short s, int n) {
        try {
            this.proxy.setLocationByLocationAndView(navLocation, s, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapPosition(NavLocationWgs84 navLocationWgs84) {
        try {
            this.proxy.setMapPosition(navLocationWgs84);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapViewPort(NavLocationWgs84 navLocationWgs84, short s, int n) {
        try {
            this.proxy.setMapViewPort(navLocationWgs84, s, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapViewPortByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
        try {
            this.proxy.setMapViewPortByLD(navLocation, navLocation2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMode(int n) {
        try {
            this.proxy.setMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNightView() {
        try {
            this.proxy.setNightView();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setOrientation(int n, Point point) {
        try {
            this.proxy.setOrientation(n, point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRotation(short s) {
        try {
            this.proxy.setRotation(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setViewType(int n) {
        try {
            this.proxy.setViewType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setZoomArea(Rect rect) {
        try {
            this.proxy.setZoomArea(rect);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setZoomLevel(float f2, int n) {
        try {
            this.proxy.setZoomLevel(f2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCountryOverviewCountry(String string) {
        try {
            this.proxy.setCountryOverviewCountry(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showTMCMessages(boolean bl) {
        try {
            this.proxy.showTMCMessages(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startScrollToDirection(int n) {
        try {
            this.proxy.startScrollToDirection(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopScrollToDirection() {
        try {
            this.proxy.stopScrollToDirection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unpackPOIContainer(long l) {
        try {
            this.proxy.unpackPOIContainer(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void viewFreeze(boolean bl) {
        try {
            this.proxy.viewFreeze(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void viewSetScreenViewport(Rect rect) {
        try {
            this.proxy.viewSetScreenViewport(rect);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void viewSetScreenViewportMaximum(Rect rect) {
        try {
            this.proxy.viewSetScreenViewportMaximum(rect);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void viewSetVisible(boolean bl) {
        try {
            this.proxy.viewSetVisible(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMetricSystem(int n) {
        try {
            this.proxy.setMetricSystem(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setViewFocusOnBlock(long[] lArray) {
        try {
            this.proxy.setViewFocusOnBlock(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setViewFocusOnPoi(PoiListElement[] poiListElementArray) {
        try {
            this.proxy.setViewFocusOnPoi(poiListElementArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startToDrawNewRectangleInMap() {
        try {
            this.proxy.startToDrawNewRectangleInMap();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void editRectangleInMap(long l) {
        try {
            this.proxy.editRectangleInMap(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSouthWestCornerOfRectangleInMap(Point point) {
        try {
            this.proxy.setSouthWestCornerOfRectangleInMap(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNorthEastCornerOfRectangleInMap(Point point) {
        try {
            this.proxy.setNorthEastCornerOfRectangleInMap(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void finishDrawRectangleInMap() {
        try {
            this.proxy.finishDrawRectangleInMap();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCityModelMode(int n) {
        try {
            this.proxy.setCityModelMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void displayRemainingRangeOfVehicle(boolean bl) {
        try {
            this.proxy.displayRemainingRangeOfVehicle(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void touchApproach(boolean bl) {
        try {
            this.proxy.touchApproach(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrandIconStyle(int[] nArray, int n) {
        try {
            this.proxy.setBrandIconStyle(nArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startScrollByVector(int n, int n2) {
        try {
            this.proxy.startScrollByVector(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setGuidanceSymbol(int n) {
        try {
            this.proxy.setGuidanceSymbol(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHOVLaneVisibility(boolean bl) {
        try {
            this.proxy.setHOVLaneVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rbGetIDOfSelectedSegment() {
        try {
            this.proxy.rbGetIDOfSelectedSegment();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void rbGetRRDToSelectedSegment(long l) {
        try {
            this.proxy.rbGetRRDToSelectedSegment(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTollRoadHighLighting(boolean bl) {
        try {
            this.proxy.setTollRoadHighLighting(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMountainPeakMarker(boolean bl) {
        try {
            this.proxy.setMountainPeakMarker(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setViewFocusOnCombinedRouteListElements(long[] lArray) {
        try {
            this.proxy.setViewFocusOnCombinedRouteListElements(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFrameRateMode(int n) {
        try {
            this.proxy.setFrameRateMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setScrollByCrossHairs(boolean bl) {
        try {
            this.proxy.setScrollByCrossHairs(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setScrollByCrossHairsBoundingBox(Rect rect) {
        try {
            this.proxy.setScrollByCrossHairsBoundingBox(rect);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRouteColoringPolicy(int n) {
        try {
            this.proxy.setRouteColoringPolicy(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWeatherVisualization(boolean bl) {
        try {
            this.proxy.setWeatherVisualization(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPictureNavigationIconVisibility(boolean bl, int n) {
        try {
            this.proxy.setPictureNavigationIconVisibility(bl, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMobilityHorizonVisibility(boolean bl) {
        try {
            this.proxy.setMobilityHorizonVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTrafficMapStyle(boolean bl) {
        try {
            this.proxy.setTrafficMapStyle(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showSpeedAndFlowFreeFlow(boolean bl) {
        try {
            this.proxy.showSpeedAndFlowFreeFlow(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showSpeedAndFlowCongestions(boolean bl) {
        try {
            this.proxy.showSpeedAndFlowCongestions(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showRichContent(boolean bl) {
        try {
            this.proxy.showRichContent(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setGeneralPoiVisibility(boolean bl) {
        try {
            this.proxy.setGeneralPoiVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCrossHairsColor(int n) {
        try {
            this.proxy.setCrossHairsColor(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setViewPortBorder(int n) {
        try {
            this.proxy.setViewPortBorder(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTerrainElevation(boolean bl) {
        try {
            this.proxy.setTerrainElevation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ensurePoiVisibility(NavLocation[] navLocationArray) {
        try {
            this.proxy.ensurePoiVisibility(navLocationArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void suspendMapViewer() {
        try {
            this.proxy.suspendMapViewer();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void wakeupMapViewer() {
        try {
            this.proxy.wakeupMapViewer();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMobilityHorizonZoomMode(int n) {
        try {
            this.proxy.setMobilityHorizonZoomMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84) {
        try {
            this.proxy.isDetailedMapMaterialAvailable(navLocationWgs84);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHorizonMarkerVisibility(boolean bl) {
        try {
            this.proxy.setHorizonMarkerVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ensureTrafficEventIconsVisibility(long[] lArray) {
        try {
            this.proxy.ensureTrafficEventIconsVisibility(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
        try {
            this.proxy.setMapViewPortByWGS84Rectangle(navRectangle, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
        try {
            this.proxy.startRouteDragging(navLocationWgs84);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dragRoute(short s, short s2) {
        try {
            this.proxy.dragRoute(s, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDragRouteMarker(int n) {
        try {
            this.proxy.setDragRouteMarker(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void highlightRouteBasedOnLength(long l, long l2, int n) {
        try {
            this.proxy.highlightRouteBasedOnLength(l, l2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        try {
            this.proxy.ehSetCategoryVisibility(n, nArray, blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        try {
            this.proxy.ehSetCategoryVisibilityToDefault(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapOverlays(int n, MapOverlay[] mapOverlayArray, int n2, int n3) {
        try {
            this.proxy.setMapOverlays(n, mapOverlayArray, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapLayerVisible(int[] nArray) {
        try {
            this.proxy.setMapLayerVisible(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTemperatureScale(int n) {
        try {
            this.proxy.setTemperatureScale(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSoftAnimationSpeed(int n) {
        try {
            this.proxy.setSoftAnimationSpeed(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpeedAndFlowRoadClass(int n) {
        try {
            this.proxy.setSpeedAndFlowRoadClass(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRouteVisibility(boolean bl) {
        try {
            this.proxy.setRouteVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
        try {
            this.proxy.setVisibleRoutes(navSegmentIDArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showTrafficEventListView(long[] lArray, boolean bl, boolean bl2) {
        try {
            this.proxy.showTrafficEventListView(lArray, bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

