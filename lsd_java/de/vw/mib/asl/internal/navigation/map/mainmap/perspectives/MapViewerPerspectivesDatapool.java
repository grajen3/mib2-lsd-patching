/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.Route;

public class MapViewerPerspectivesDatapool {
    private final MapDataPool datapoolMapMain;
    private final MapViewerDatapoolShared datapoolShared;
    protected final INavigationDP navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private final IPersistedGuidanceSetup persistedGuidanceSetup;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private boolean rangeViewBeforePNav = false;
    private NavLocationWgs84 mapPositionDestinationView;
    private NavLocationWgs84 mapPositionOverviewZoom;

    public MapViewerPerspectivesDatapool() {
        this.datapoolMapMain = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
        this.persistedGuidanceSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup();
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public Route getCurrentRoute() {
        return this.navigationDP.getCurrentRoute();
    }

    public int getMapMode() {
        return this.datapoolMapMain.getMapMode();
    }

    public NavLocation getMapPosition() {
        return this.datapoolMapMain.getMapPosition();
    }

    public NavLocationWgs84 getMapPositionDestinationView() {
        return this.mapPositionDestinationView;
    }

    public NavLocationWgs84 getMapPositionOverviewZoom() {
        return this.mapPositionOverviewZoom;
    }

    public int getZoomLevelSwitchToNorthUp() {
        return this.datapoolShared.getZoomLevelSwitchToNorthUp();
    }

    public float[] getZoomListCurrent() {
        return this.datapoolMapMain.getZoomList();
    }

    public int getZoomListIndexCurrent() {
        return this.datapoolMapMain.getZoomListIndex();
    }

    public int getZoomListIndexMax() {
        return this.datapoolMapMain.getZoomListIndexMax();
    }

    public int getZoomListIndexMin() {
        return this.datapoolMapMain.getZoomListIndexMin();
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public boolean isFocusCcpZoom() {
        return this.datapoolShared.isFocusCCPZoom();
    }

    public boolean isMapInMainScreen() {
        return this.datapoolShared.isMapInMainScreen();
    }

    public boolean isMapMoved() {
        return this.datapoolShared.isMapMoved();
    }

    public boolean isMobilityHorzionVisible() {
        return this.datapoolMapMain.isMobilityHorzionVisible();
    }

    public boolean isPerspectiveAlternativeRouteMap() {
        return this.datapoolShared.isPerspectiveAlternativeRouteMap();
    }

    public boolean isPerspectiveDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    public boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isPerspectiveRocketZoom() {
        return this.datapoolShared.isPerspectiveRocketZoom();
    }

    public boolean isPerspectiveMobilityHorizon() {
        return this.datapoolShared.isPerspectiveMobilityHorizon();
    }

    public boolean isPerspectiveFinalDestinationZoom() {
        return this.datapoolShared.isPerspectiveFinalDestinationZoom();
    }

    public boolean isPerspectiveWayPointOverviewZoomActive() {
        return this.datapoolShared.isPerspectiveWayPointOverviewZoomActive();
    }

    public boolean isRangeViewBeforePNav() {
        return this.rangeViewBeforePNav;
    }

    public boolean isStatusLineInfo() {
        return this.persistedGuidanceSetup.isStatusLineInfo();
    }

    public boolean isZoomLevelSwitchTo2DNorthOvershoot() {
        return this.datapoolShared.isZoomLevelSwitchTo2DNorthOvershoot();
    }

    public boolean isZoomLevelSwitchTo2DNorthUndershoot() {
        return this.datapoolShared.isZoomLevelSwitchTo2DNorthUndershoot();
    }

    public void setFocusCCPZoom(boolean bl) {
        this.datapoolShared.setFocusCCPZoom(bl);
    }

    public void setFocusSurroundingZoom(boolean bl) {
        this.datapoolShared.setFocusSurroundingZoom(bl);
    }

    public void setMainMapPerspective(int n) {
        this.persistedMapSetup.setMainMapOrientation(n);
    }

    public void setMainMapZoomLevel(int n) {
        this.persistedMapSetup.setMainMapZoomLevel(n);
    }

    public void setMapMoved(boolean bl) {
        this.datapoolShared.setMapMoved(bl);
    }

    public void setMapPosition(NavLocation navLocation) {
        this.datapoolMapMain.setMapPosition(navLocation);
    }

    public void setMapPositionDestinationView(NavLocationWgs84 navLocationWgs84) {
        this.mapPositionDestinationView = navLocationWgs84;
    }

    public void setMapPositionOverviewZoom(NavLocationWgs84 navLocationWgs84) {
        this.mapPositionOverviewZoom = navLocationWgs84;
    }

    public void setPerspective25DCarUp(boolean bl) {
        this.datapoolShared.setPerspective25DCarUp(bl);
    }

    public void setPerspective2DCarUp(boolean bl) {
        this.datapoolShared.setPerspective2DCarUp(bl);
    }

    public void setPerspective2DNorthUp(boolean bl) {
        this.datapoolShared.setPerspective2DNorthUp(bl);
    }

    public void setPerspective3DCarUp(boolean bl) {
        this.datapoolShared.setPerspective3DCarUp(bl);
    }

    public void setPerspective3DDTM(boolean bl) {
        this.datapoolShared.setPerspective3DDTM(bl);
    }

    public void setPerspectiveAlternativeRouteMap(boolean bl) {
        this.datapoolShared.setPerspectiveAlternativeRouteMap(bl);
    }

    public boolean isFeatureShowEnhancedCityModelAllViewtypes() {
        return this.datapoolMapMain.isFeatureShowEnhancedCityModelAllViewtypes();
    }

    public void setPerspectiveCountryOverview(boolean bl) {
        this.datapoolShared.setPerspectiveCountryOverview(bl);
    }

    public void setPerspectiveDestinationZoom(boolean bl) {
        this.datapoolShared.setPerspectiveDestinationZoom(bl);
    }

    public void setPerspectiveFinalDestinationZoom(boolean bl) {
        this.datapoolShared.setPerspectiveFinalDestinationZoom(bl);
    }

    public void setPerspectiveMobilityHorizon(boolean bl) {
        this.datapoolShared.setPerspectiveMobilityHorizon(bl);
    }

    public void setPerspectiveOverviewZoom(boolean bl) {
        this.datapoolShared.setPerspectiveOverviewZoom(bl);
    }

    public void setPerspectivePNavOverview(boolean bl) {
        this.datapoolShared.setPerspectivePNavOverview(bl);
    }

    public void setPerspectiveRouteOverviewActive(boolean bl) {
        this.datapoolShared.setPerspectiveRouteOverviewActive(bl);
    }

    public void setPerspectiveWayPointOverviewZoomActive(boolean bl) {
        this.datapoolShared.setPerspectiveWayPointOverviewZoomActive(bl);
    }

    public void setRangeViewBeforePNav(boolean bl) {
        this.rangeViewBeforePNav = bl;
    }

    public void setZoomLevelSwitchTo2DNorth(int n) {
        this.datapoolShared.setZoomLevelSwitchToNorthUp(n);
    }

    public void setZoomLevelSwitchTo2DNorthOvershoot(boolean bl) {
        this.datapoolShared.setZoomLevelSwitchTo2DNorthOvershoot(bl);
    }

    public void setZoomLevelSwitchTo2DNorthUndershoot(boolean bl) {
        this.datapoolShared.setZoomLevelSwitchTo2DNorthUndershoot(bl);
    }

    public boolean isDriverDistractionPreventionFeatureAvailable() {
        return this.datapoolShared.isDriverDistractionPreventionFeatureAvailable();
    }

    public void setDriverDistractionPreventionFeatureAvailable(boolean bl) {
        this.datapoolShared.setDriverDistractionPreventionFeatureAvailable(bl);
    }
}

