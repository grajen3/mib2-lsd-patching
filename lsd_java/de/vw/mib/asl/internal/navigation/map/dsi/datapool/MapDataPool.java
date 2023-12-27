/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.datapool;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapDataPool {
    public static final int LOCATION_TYPE_BY_LOCATION;
    public static final int LOCATION_TYPE_CAR;
    public static final int LOCATION_TYPE_DESTINATION;
    private int brandIconStyle;
    private int[] brandIconUIDs;
    private Point carPosition;
    private int cityModelMode;
    private MapFlag[] configuredFlags;
    private int drageRouteMarker;
    private short dragMapDeltaX;
    private short dragMapDeltaY;
    private short dragRouteDeltaX;
    private short dragRouteDeltaY;
    private int[] ehCategoryVisibilityCategoryUIDs;
    private boolean[] ehCategoryVisibilityCategoryVisibility;
    private long ensureTMCVisibilityMessageId;
    private ArrayList favoritesList;
    private final boolean feature3DLandmarksEnabled = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(5);
    private final boolean featureShowEnhancedCityModelAllViewtypes = ServiceManager.configManagerDiag.getNaviCommonOptionDefaultBoolean(3);
    private boolean generalPOIVisibility;
    private long gotToTMCMessageId;
    private Point hotPoint;
    private boolean landmarks3DVisible;
    private int locationType;
    private int[] mapLayerVisible;
    private NavLocation mapPosition;
    private final int mapViewerInstanceId;
    private int metricSystem;
    private int mobilityHorizonZoomMode;
    private boolean mobilityHorzionVisible;
    private boolean nightView;
    private int orientation;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private int[] poiCategoryUid;
    private boolean[] poiCategoryVisibility;
    private int poiMapStyleType;
    private int rbSelectAlternativeRouteIndex;
    private short rotation;
    private int routeColoringPolicy;
    private boolean routeVisible;
    private Rect screenViewport;
    private Rect screenViewportMaximum;
    private boolean showSpeedAndFlowCongestions;
    private boolean showSpeedAndFlowFreeFlow;
    private boolean showTmcMessages;
    private boolean softJumpEnabled;
    private boolean softTiltEnalbed;
    private boolean softZoomEnabled;
    private int speedAndFlowRoadClass;
    private int temperatureScale;
    private boolean trafficMapStyle;
    private boolean viewFreeze;
    private NavLocation viewPortByLDLocationSecond;
    private NavRectangle viewPortByWGS84NavRectangle;
    private NavLocation viewProtByLDLocationFirst;
    private int viewType;
    private boolean viewVisible;
    private Rect zoomArea;
    private float zoomLevel;
    private float[] zoomList;
    private int zoomListIndex;
    private int zoomListIndexMax;
    private int zoomListIndexMin;
    private boolean mapReinitRequired;
    private boolean mapTemporarilyInABT = false;

    public MapDataPool(int n) {
        this.mapViewerInstanceId = n;
    }

    public int getBrandIconStyle() {
        return this.brandIconStyle;
    }

    public int[] getBrandIconUIDs() {
        return this.brandIconUIDs;
    }

    public Point getCarPosition() {
        return this.carPosition;
    }

    public int getCityModelMode() {
        return this.cityModelMode;
    }

    public MapFlag[] getConfiguredFlags() {
        return this.configuredFlags;
    }

    public int getDrageRouteMarker() {
        return this.drageRouteMarker;
    }

    public short getDragMapDeltaX() {
        return this.dragMapDeltaX;
    }

    public short getDragMapDeltaY() {
        return this.dragMapDeltaY;
    }

    public short getDragRouteDeltaX() {
        return this.dragRouteDeltaX;
    }

    public short getDragRouteDeltaY() {
        return this.dragRouteDeltaY;
    }

    public int[] getEhCategoryVisibilityCategoryUIDs() {
        return this.ehCategoryVisibilityCategoryUIDs;
    }

    public boolean[] getEhCategoryVisibilityCategoryVisibility() {
        return this.ehCategoryVisibilityCategoryVisibility;
    }

    public long getEnsureTMCVisibilityMessageId() {
        return this.ensureTMCVisibilityMessageId;
    }

    public ArrayList getFavoritesList() {
        return this.favoritesList;
    }

    public long getGotToTMCMessageId() {
        return this.gotToTMCMessageId;
    }

    public Point getHotPoint() {
        return this.hotPoint;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public int[] getMapLayerVisible() {
        return this.mapLayerVisible;
    }

    public int getMapMode() {
        if (this.mapViewerInstanceId == 2) {
            return this.persistedMapSetup.getMapInMapMode();
        }
        return this.persistedMapSetup.getMainMapMapMode();
    }

    public NavLocation getMapPosition() {
        return this.mapPosition;
    }

    public int getMetricSystem() {
        return this.metricSystem;
    }

    public int getMobilityHorizonZoomMode() {
        return this.mobilityHorizonZoomMode;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int[] getPoiCategoryUid() {
        return this.poiCategoryUid;
    }

    public boolean[] getPoiCategoryVisibility() {
        return this.poiCategoryVisibility;
    }

    public int getPoiMapStyleType() {
        return this.poiMapStyleType;
    }

    public int getRbSelectAlternativeRouteIndex() {
        return this.rbSelectAlternativeRouteIndex;
    }

    public int getRouteColoringPolicy() {
        return this.routeColoringPolicy;
    }

    public Rect getScreenViewport() {
        return this.screenViewport;
    }

    public Rect getScreenViewportMaximum() {
        return this.screenViewportMaximum;
    }

    public int getSpeedAndFlowRoadClass() {
        return this.speedAndFlowRoadClass;
    }

    public int getTemperatureScale() {
        return this.temperatureScale;
    }

    public NavLocation getViewPortByLDLocationSecond() {
        return this.viewPortByLDLocationSecond;
    }

    public NavRectangle getViewPortByWGS84NavRectangle() {
        return this.viewPortByWGS84NavRectangle;
    }

    public NavLocation getViewProtByLDLocationFirst() {
        return this.viewProtByLDLocationFirst;
    }

    public int getViewType() {
        return this.viewType;
    }

    public Rect getZoomArea() {
        return this.zoomArea;
    }

    public float getZoomLevel() {
        return this.zoomLevel;
    }

    public float[] getZoomList() {
        return this.zoomList;
    }

    public int getZoomListIndex() {
        return this.zoomListIndex;
    }

    public int getZoomListIndexMax() {
        return this.zoomListIndexMax;
    }

    public int getZoomListIndexMin() {
        return this.zoomListIndexMin;
    }

    public boolean isFeature3DLandmarksEnabled() {
        return this.feature3DLandmarksEnabled;
    }

    public boolean isFeatureShowEnhancedCityModelAllViewtypes() {
        return this.featureShowEnhancedCityModelAllViewtypes;
    }

    public boolean isGeneralPOIVisibility() {
        return this.generalPOIVisibility;
    }

    public boolean isLandmarks3DVisible() {
        return this.landmarks3DVisible;
    }

    public boolean isMobilityHorzionVisible() {
        return this.mobilityHorzionVisible;
    }

    public boolean isNightView() {
        return this.nightView;
    }

    public short isRotation() {
        return this.rotation;
    }

    public boolean isRouteVisible() {
        return this.routeVisible;
    }

    public boolean isShowSpeedAndFlowCongestions() {
        return this.showSpeedAndFlowCongestions;
    }

    public boolean isShowSpeedAndFlowFreeFlow() {
        return this.showSpeedAndFlowFreeFlow;
    }

    public boolean isShowTmcMessages() {
        return this.showTmcMessages;
    }

    public boolean isSoftJumpEnabled() {
        return this.softJumpEnabled;
    }

    public boolean isSoftTiltEnalbed() {
        return this.softTiltEnalbed;
    }

    public boolean isSoftZoomEnabled() {
        return this.softZoomEnabled;
    }

    public boolean isTrafficMapStyle() {
        return this.trafficMapStyle;
    }

    public boolean isViewFreeze() {
        return this.viewFreeze;
    }

    public boolean isViewVisible() {
        return this.viewVisible;
    }

    public void setBrandIconStyle(int n) {
        this.brandIconStyle = n;
    }

    public void setBrandIconUIDs(int[] nArray) {
        this.brandIconUIDs = nArray;
    }

    public void setCarPosition(Point point) {
        this.carPosition = point;
    }

    public void setCityModelMode(int n) {
        this.cityModelMode = n;
    }

    public void setConfiguredFlags(MapFlag[] mapFlagArray) {
        this.configuredFlags = mapFlagArray;
    }

    public void setDrageRouteMarker(int n) {
        this.drageRouteMarker = n;
    }

    public void setDragMapDeltaX(short s) {
        this.dragMapDeltaX = s;
    }

    public void setDragMapDeltaY(short s) {
        this.dragMapDeltaY = s;
    }

    public void setDragRouteDeltaX(short s) {
        this.dragRouteDeltaX = s;
    }

    public void setDragRouteDeltaY(short s) {
        this.dragRouteDeltaY = s;
    }

    public void setEhCategoryVisibilityCategoryUIDs(int[] nArray) {
        this.ehCategoryVisibilityCategoryUIDs = nArray;
    }

    public void setEhCategoryVisibilityCategoryVisibility(boolean[] blArray) {
        this.ehCategoryVisibilityCategoryVisibility = blArray;
    }

    public void setEnsureTMCVisibilityMessageId(long l) {
        this.ensureTMCVisibilityMessageId = l;
    }

    public void setFavoritesList(ArrayList arrayList) {
        this.favoritesList = arrayList;
    }

    public void setGeneralPOIVisibility(boolean bl) {
        this.generalPOIVisibility = bl;
    }

    public void setGotToTMCMessageId(long l) {
        this.gotToTMCMessageId = l;
    }

    public void setHotPoint(Point point) {
        this.hotPoint = point;
    }

    public void setLandmarks3DVisible(boolean bl) {
        this.landmarks3DVisible = bl;
    }

    public void setLocationType(int n) {
        this.locationType = n;
    }

    public void setMapLayerVisible(int[] nArray) {
        this.mapLayerVisible = nArray;
    }

    public void setMapMode(int n) {
        if (this.mapViewerInstanceId == 2) {
            this.persistedMapSetup.setMapInMapMode(n);
        } else {
            this.persistedMapSetup.setMainMapMapMode(n);
        }
    }

    public void setMapPosition(NavLocation navLocation) {
        this.mapPosition = navLocation;
    }

    public void setMetricSystem(int n) {
        this.metricSystem = n;
    }

    public void setMobilityHorizonZoomMode(int n) {
        this.mobilityHorizonZoomMode = n;
    }

    public void setMobilityHorzionVisible(boolean bl) {
        this.mobilityHorzionVisible = bl;
    }

    public void setNightView(boolean bl) {
        this.nightView = bl;
    }

    public void setOrientation(int n) {
        this.orientation = n;
    }

    public void setPoiCategoryUid(int[] nArray) {
        this.poiCategoryUid = nArray;
    }

    public void setPoiCategoryVisibility(boolean[] blArray) {
        this.poiCategoryVisibility = blArray;
    }

    public void setPoiMapStyleType(int n) {
        this.poiMapStyleType = n;
    }

    public void setRbSelectAlternativeRouteIndex(int n) {
        this.rbSelectAlternativeRouteIndex = n;
    }

    public void setRotation(short s) {
        this.rotation = s;
    }

    public void setRouteColoringPolicy(int n) {
        this.routeColoringPolicy = n;
    }

    public void setRouteVisible(boolean bl) {
        this.routeVisible = bl;
    }

    public void setScreenViewport(Rect rect) {
        this.screenViewport = rect;
    }

    public void setScreenViewportMaximum(Rect rect) {
        this.screenViewportMaximum = rect;
    }

    public void setShowSpeedAndFlowCongestions(boolean bl) {
        this.showSpeedAndFlowCongestions = bl;
    }

    public void setShowSpeedAndFlowFreeFlow(boolean bl) {
        this.showSpeedAndFlowFreeFlow = bl;
    }

    public void setShowTmcMessages(boolean bl) {
        this.showTmcMessages = bl;
    }

    public void setSoftJumpEnabled(boolean bl) {
        this.softJumpEnabled = bl;
    }

    public void setSoftTiltEnalbed(boolean bl) {
        this.softTiltEnalbed = bl;
    }

    public void setSoftZoomEnabled(boolean bl) {
        this.softZoomEnabled = bl;
    }

    public void setSpeedAndFlowRoadClass(int n) {
        this.speedAndFlowRoadClass = n;
    }

    public void setTemperatureScale(int n) {
        this.temperatureScale = n;
    }

    public void setTrafficMapStyle(boolean bl) {
        this.trafficMapStyle = bl;
    }

    public void setViewFreeze(boolean bl) {
        this.viewFreeze = bl;
    }

    public void setViewPortByLDLocationSecond(NavLocation navLocation) {
        this.viewPortByLDLocationSecond = navLocation;
    }

    public void setViewPortByWGS84NavRectangle(NavRectangle navRectangle) {
        this.viewPortByWGS84NavRectangle = navRectangle;
    }

    public void setViewProtByLDLocationFirst(NavLocation navLocation) {
        this.viewProtByLDLocationFirst = navLocation;
    }

    public void setViewType(int n) {
        this.viewType = n;
    }

    public void setViewVisible(boolean bl) {
        this.viewVisible = bl;
    }

    public void setZoomArea(Rect rect) {
        this.zoomArea = rect;
    }

    public void setZoomLevel(float f2) {
        this.zoomLevel = f2;
    }

    public void setZoomList(float[] fArray) {
        this.zoomList = fArray;
    }

    public void setZoomListIndex(int n) {
        this.zoomListIndex = n;
    }

    public void setZoomListIndexMax(int n) {
        this.zoomListIndexMax = n;
    }

    public void setZoomListIndexMin(int n) {
        this.zoomListIndexMin = n;
    }

    public void setMapReinitRequired(boolean bl) {
        this.mapReinitRequired = bl;
    }

    public boolean isMapReinitRequired() {
        return this.mapReinitRequired;
    }

    public boolean isMapTemporarilyInABT() {
        return this.mapTemporarilyInABT;
    }

    public void setMapTemporarilyInABT(boolean bl) {
        this.mapTemporarilyInABT = bl;
    }
}

