/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;

public class MapViewerTouchgesturesDataPool {
    private final MapDataPool datapoolMainMap;
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private final IPersistedDestInputSetup destinputDP;
    private Point hotPoint;
    private final INavigationDP navigationDataPool;
    private int oneFingerClickX;
    private int oneFingerClickY;
    private short oneFingerDeltaX;
    private short oneFingerDeltaY;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private int twoFingerX;
    private int twoFingerY;
    private int twoFingerZDelta;
    private int twoFingerZDistance;
    private float zoomLevelTwoFinger;

    public MapViewerTouchgesturesDataPool() {
        this.datapoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        this.navigationDataPool = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
        this.destinputDP = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
    }

    int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    ArrayList getFavoritesList() {
        return this.datapoolMainMap.getFavoritesList();
    }

    long getHomeFlagId() {
        return this.datapoolShared.getHomeFlagId();
    }

    public NavLocation getHomeLocation() {
        return this.destinputDP.getHomeLocation();
    }

    Point getHotPoint() {
        return this.hotPoint;
    }

    int getMainMapContent() {
        return this.persistedMapSetup.getMainMapContent();
    }

    Point getMainMapHotPoint() {
        return this.datapoolMainMap.getHotPoint();
    }

    int getMapMode() {
        return this.datapoolMainMap.getMapMode();
    }

    public NavLocation getMapPosition() {
        return this.datapoolMainMap.getMapPosition();
    }

    int getOneFingerClickX() {
        return this.oneFingerClickX;
    }

    int getOneFingerClickY() {
        return this.oneFingerClickY;
    }

    short getOneFingerDeltaX() {
        return this.oneFingerDeltaX;
    }

    short getOneFingerDeltaY() {
        return this.oneFingerDeltaY;
    }

    int getTwoFingerX() {
        return this.twoFingerX;
    }

    int getTwoFingerY() {
        return this.twoFingerY;
    }

    int getTwoFingerZDelta() {
        return this.twoFingerZDelta;
    }

    int getTwoFingerZDistance() {
        return this.twoFingerZDistance;
    }

    float getZoomLevel() {
        return this.datapoolMainMap.getZoomLevel();
    }

    float getZoomLevelTwoFinger() {
        return this.zoomLevelTwoFinger;
    }

    float[] getZoomListCurrent() {
        return this.datapoolMainMap.getZoomList();
    }

    int getZoomListIndex() {
        return this.datapoolMainMap.getZoomListIndex();
    }

    boolean isAlternativeRouteMap() {
        return this.datapoolShared.isPerspectiveAlternativeRouteMap();
    }

    boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    boolean isMapInMainScreen() {
        return this.datapoolShared.isMapInMainScreen();
    }

    boolean isMapMoved() {
        return this.datapoolShared.isMapMoved();
    }

    boolean isPerspective25DCarUp() {
        return this.datapoolShared.isPerspective25DCarUp();
    }

    boolean isPerspective2DCarUp() {
        return this.datapoolShared.isPerspective2DCarUp();
    }

    boolean isPerspective2DNorthUp() {
        return this.datapoolShared.isPerspective2DNorthUp();
    }

    boolean isPerspective3DCarUp() {
        return this.datapoolShared.isPerspective3DCarUp();
    }

    boolean isPerspective3DDTM() {
        return this.datapoolShared.isPerspective3DDTM();
    }

    boolean isPerspectiveAlternativeRouteMap() {
        return this.datapoolShared.isPerspectiveAlternativeRouteMap();
    }

    boolean isPerspectiveCountryOverview() {
        return this.datapoolShared.isPerspectiveCountryOverview();
    }

    boolean isPerspectiveDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    boolean isPerspectiveMobilityHorizon() {
        return this.datapoolShared.isPerspectiveMobilityHorizon();
    }

    boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isPerspectivePNavOverview() {
        return this.datapoolShared.isPerspectivePNavOverview();
    }

    public boolean isStreetViewAvailable() {
        return this.datapoolShared.isStreetViewAvailable();
    }

    public boolean isSwitchInProgress() {
        return this.datapoolShared.isSwitchInProgress();
    }

    void setHotPoint(Point point) {
        this.hotPoint = point;
    }

    void setLocationType(int n) {
        this.datapoolMainMap.setLocationType(n);
    }

    public void setMainMapZoomLevel(int n) {
        this.persistedMapSetup.setMainMapZoomLevel(n);
    }

    public void setOverviewMapZoomLevel(int n) {
        this.datapoolShared.setZoomLevelOverviewMapBackup(n);
    }

    void setMapInputLocation(NavLocation navLocation) {
        this.navigationDataPool.setMapInputLocation(navLocation);
    }

    void setMapMoved(boolean bl) {
        this.datapoolShared.setMapMoved(bl);
    }

    void setOneFingerClickX(int n) {
        this.oneFingerClickX = n;
    }

    void setOneFingerClickY(int n) {
        this.oneFingerClickY = n;
    }

    void setOneFingerDeltaX(short s) {
        this.oneFingerDeltaX = s;
    }

    void setOneFingerDeltaY(short s) {
        this.oneFingerDeltaY = s;
    }

    void setTwoFingerX(int n) {
        this.twoFingerX = n;
    }

    void setTwoFingerY(int n) {
        this.twoFingerY = n;
    }

    void setTwoFingerZDelta(int n) {
        this.twoFingerZDelta = n;
    }

    void setTwoFingerZDistance(int n) {
        this.twoFingerZDistance = n;
    }

    void setTwoFingerZoomActive(boolean bl) {
        this.datapoolShared.setTwoFingerZoomActive(bl);
    }

    void setZoomLevelTwoFinger(float f2) {
        this.zoomLevelTwoFinger = f2;
    }

    boolean isStreetViewVisible() {
        return this.datapoolShared.isStreetViewVisible();
    }
}

