/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.map.TrafficDualListViewConfiguration;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapContentChangerDatapool {
    private float chMapInputZoomLevelBackup;
    private final MapViewerDatapoolShared datapoolShared;
    private final IPersistedDestInputSetup destinputDP;
    private Integer goToLocationType;
    private Point hotPoint;
    private boolean isChMapInputDetailViewZoomSet = false;
    private MapConfiguration mapConfiguration;
    private final MapDataPool mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    private final PersistedMapSetup persistedMapSetup;
    private final Map queuedGotoLocations;
    private final Map storedZoomAreas;
    private Rect zoomArea;
    private TrafficDualListViewConfiguration trafficDualiListViewConfig;
    private int zoomLevelMainMapOverviewBackup;

    public MapContentChangerDatapool() {
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
        this.persistedMapSetup = PersistedMapSetup.getInstance();
        this.destinputDP = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
        this.queuedGotoLocations = new HashMap();
        this.storedZoomAreas = new HashMap();
    }

    public float getChMapInputZoomLevelBackup() {
        return this.chMapInputZoomLevelBackup;
    }

    public Integer getGoToLocationType() {
        return this.goToLocationType;
    }

    public NavLocation getHomeLocation() {
        return this.destinputDP.getHomeLocation();
    }

    public Point getHotPoint() {
        return this.hotPoint;
    }

    public boolean isDriverDistractionPreventionFeatureAvailable() {
        return this.datapoolShared.isDriverDistractionPreventionFeatureAvailable();
    }

    public int getMainMapContent() {
        return this.persistedMapSetup.getMainMapContent();
    }

    public int getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public MapConfiguration getMapConfiguration() {
        return this.mapConfiguration;
    }

    public int[] getMapLayerVisible() {
        return this.mapDataPool.getMapLayerVisible();
    }

    public Map getQueuedGotoLocations() {
        return this.queuedGotoLocations;
    }

    public Map getStoredZoomAreas() {
        return this.storedZoomAreas;
    }

    public Rect getZoomArea() {
        return this.zoomArea;
    }

    public int getZoomLevelMainMapBackup() {
        return this.datapoolShared.getZoomLevelMainMapBackup();
    }

    public boolean isChMapInputDetailViewZoomSet() {
        return this.isChMapInputDetailViewZoomSet;
    }

    public boolean isFeatureShowEnhancedCityModelAllViewtypes() {
        return this.mapDataPool.isFeatureShowEnhancedCityModelAllViewtypes();
    }

    public boolean isGeneralPOIVisibility() {
        return this.mapDataPool.isGeneralPOIVisibility();
    }

    public boolean isMapFPKSwitchRunning() {
        return this.datapoolShared.isMapFPKSwitchRunning();
    }

    public int getMapSwitchState() {
        return this.datapoolShared.getMapSwitchState();
    }

    public boolean isMapLocatedInKombi() {
        return this.persistedMapSetup.isMapLocatedInKombi();
    }

    public boolean isNightView() {
        return this.mapDataPool.isNightView();
    }

    public boolean isPerspectiveFinalDestinationZoom() {
        return this.datapoolShared.isPerspectiveFinalDestinationZoom();
    }

    public boolean isPnavRouteVisibility() {
        return this.datapoolShared.isPnavRouteVisibility();
    }

    public boolean isViewVisible() {
        return this.mapDataPool.isViewVisible();
    }

    public void setChMapInputDetailViewZoomSet(boolean bl) {
        this.isChMapInputDetailViewZoomSet = bl;
    }

    public void setChMapInputZoomLevelBackup(float f2) {
        this.chMapInputZoomLevelBackup = f2;
    }

    public void setGoToLocationType(Integer n) {
        this.goToLocationType = n;
    }

    public void setHotPoint(Point point) {
        this.hotPoint = point;
    }

    public void setMainMapContent(int n) {
        this.persistedMapSetup.setMainMapContent(n);
    }

    public void setMapConfiguration(MapConfiguration mapConfiguration) {
        this.mapConfiguration = mapConfiguration;
    }

    public void setMapInMainScreen(boolean bl) {
        this.datapoolShared.setMapInMainScreen(bl);
    }

    public void setViewVisible(boolean bl) {
        this.mapDataPool.setViewVisible(bl);
    }

    public void setZoomArea(Rect rect) {
        this.zoomArea = rect;
    }

    public void setZoomLevelMainMapBackup(int n) {
        this.datapoolShared.setZoomLevelMainMapBackup(n);
    }

    public boolean showTmcMessages() {
        return this.mapDataPool.isShowTmcMessages();
    }

    public TrafficDualListViewConfiguration getTrafficDualiListViewConfig() {
        return this.trafficDualiListViewConfig;
    }

    public void setTrafficDualiListViewConfig(TrafficDualListViewConfiguration trafficDualListViewConfiguration) {
        this.trafficDualiListViewConfig = trafficDualListViewConfiguration;
    }

    public int getMainMapZoomCurrentLevel() {
        return (int)this.mapDataPool.getZoomLevel();
    }

    public void setZoomLevelOverviewMapBackup(int n) {
        this.datapoolShared.setZoomLevelOverviewMapBackup(n);
    }

    public boolean isPerspectiveAlternativeRouteMap() {
        return this.datapoolShared.isPerspectiveAlternativeRouteMap();
    }

    public boolean isPerspectiveCountryOverview() {
        return this.datapoolShared.isPerspectiveCountryOverview();
    }

    public boolean isPerspectiveDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    public boolean isPerspectiveMobilityHorizon() {
        return this.datapoolShared.isPerspectiveMobilityHorizon();
    }

    boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isPerspectivePNavOverview() {
        return this.datapoolShared.isPerspectivePNavOverview();
    }
}

