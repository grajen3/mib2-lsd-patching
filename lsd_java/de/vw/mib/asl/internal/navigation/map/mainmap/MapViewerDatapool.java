/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;

public class MapViewerDatapool {
    private final MapDataPool datapoolMainMap;
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private final INavigationDP navigationDP;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private boolean speechActive;

    public MapViewerDatapool() {
        this.datapoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        this.navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    }

    public NavLocation getDefaultLocation() {
        return this.navigationDP.getDefaultLocation();
    }

    public Point getMainMapCarPosition() {
        return this.persistedMapSetup.getMainMapCarPosition();
    }

    public int getMainMapContent() {
        return this.persistedMapSetup.getMainMapContent();
    }

    public NavLocation getMapPosition() {
        return this.datapoolMainMap.getMapPosition();
    }

    public float[] getZoomListCurrent() {
        return this.datapoolMainMap.getZoomList();
    }

    public int getZoomListIndexMax() {
        return this.datapoolMainMap.getZoomListIndexMax();
    }

    public int getZoomListIndexMin() {
        return this.datapoolMainMap.getZoomListIndexMin();
    }

    public boolean isASLServiceActive() {
        return this.datapoolShared.isASLServiceActive();
    }

    public boolean isClickInMapMenuActive() {
        return this.datapoolShared.isClickInMapMenuActive();
    }

    public boolean isDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    public boolean isMapLocatedInKombi() {
        return this.persistedMapSetup.isMapLocatedInKombi();
    }

    public boolean isMapFPKSwitchRunning() {
        return this.datapoolShared.isMapFPKSwitchRunning();
    }

    public boolean isMapMoved() {
        return this.datapoolShared.isMapMoved();
    }

    public boolean isOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isPerspective25DCarUp() {
        return this.datapoolShared.isPerspective25DCarUp();
    }

    public boolean isPerspective2DCarUp() {
        return this.datapoolShared.isPerspective2DCarUp();
    }

    public boolean isPerspective2DNorthUp() {
        return this.datapoolShared.isPerspective2DNorthUp();
    }

    public boolean isPerspective3DCarUp() {
        return this.datapoolShared.isPerspective3DCarUp();
    }

    public boolean isPerspective3DDTM() {
        return this.datapoolShared.isPerspective3DDTM();
    }

    public boolean isPerspectiveAlternativeRouteMap() {
        return this.datapoolShared.isPerspectiveAlternativeRouteMap();
    }

    public boolean isPerspectiveMobilityHorizon() {
        return this.datapoolShared.isPerspectiveMobilityHorizon();
    }

    public boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isPerspectiveDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    public boolean isPerspectiveRocketZoom() {
        return this.datapoolShared.isPerspectiveRocketZoom();
    }

    public boolean isSpeechActive() {
        return this.speechActive;
    }

    public boolean isSurroundingZoom() {
        return this.datapoolShared.isFocusSurroundingZoom();
    }

    public void setMainMapCarPosition(Point point) {
        this.persistedMapSetup.setMainMapCarPosition(point);
    }

    public void setMapPosition(NavLocation navLocation) {
        this.datapoolMainMap.setMapPosition(navLocation);
    }

    public void setMapRotation(short s) {
        this.datapoolShared.setMapRotation(s);
    }

    public void setSpeechActive(boolean bl) {
        this.speechActive = bl;
    }

    public void setZoomLevel(float f2) {
        this.datapoolMainMap.setZoomLevel(f2);
    }

    public void setZoomListIndex(int n) {
        this.datapoolMainMap.setZoomListIndex(n);
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public void setHeadingValue(int n) {
        this.datapoolShared.setHeadingValue(n);
    }
}

