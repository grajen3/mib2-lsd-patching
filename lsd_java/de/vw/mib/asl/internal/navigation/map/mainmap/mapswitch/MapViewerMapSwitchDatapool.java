/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;

public class MapViewerMapSwitchDatapool {
    private MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private final MapDataPool mapDataPool;
    private int nextSwitchTo;
    private PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();

    public MapViewerMapSwitchDatapool() {
        this.mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        this.setNextSwitchTo(2);
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public int getMainMapCurrentContent() {
        return this.persistedMapSetup.getMainMapContent();
    }

    public int getMainMapPerspective() {
        return this.persistedMapSetup.getMainMapPerspective();
    }

    public float getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public int getNextSwitchTo() {
        return this.nextSwitchTo;
    }

    public boolean isAutozoomDeactivatedWhileDrag() {
        return this.datapoolShared.isAutozoomDeactivatedWhileDrag();
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public boolean isMapFPKSwitchRunning() {
        return this.datapoolShared.isMapFPKSwitchRunning();
    }

    public boolean isMapLocatedInABT() {
        return this.persistedMapSetup.isMapLocatedInABT();
    }

    public boolean isMapLocatedInKombi() {
        return this.persistedMapSetup.isMapLocatedInKombi();
    }

    public boolean isMapMoved() {
        return this.datapoolShared.isMapMoved();
    }

    public boolean isMapSwitchFunctionAvailableInKombi() {
        return this.datapoolShared.isMapSwitchFunctionAvailableInKombi();
    }

    public boolean isPerspectiveDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    public boolean isPerspectiveFinalDestinationZoom() {
        return this.datapoolShared.isPerspectiveFinalDestinationZoom();
    }

    public boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isSwitchDoneAtLockMapViewer() {
        return this.datapoolShared.isSwitchDoneAtLockMapViewer();
    }

    public boolean isTouchApproximated() {
        return this.datapoolShared.getLatestTouchApproach();
    }

    public void setAutoZoomMainMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMainMap(bl);
    }

    public void setICMapServiceState(int n) {
        this.datapoolShared.setICMapServiceState(n);
    }

    public void setMainMapLocatedInAbt(boolean bl) {
        this.persistedMapSetup.setMainMapLocatedInAbt(bl);
    }

    public void setMainMapLocatedInKombi(boolean bl) {
        this.persistedMapSetup.setMainMapLocatedInKombi(bl);
    }

    public void setMapFPKSwitchRunning(boolean bl) {
        this.datapoolShared.setMapFPKSwitchRunning(bl);
    }

    public void setMapMoved(boolean bl) {
        this.datapoolShared.setMapMoved(bl);
    }

    public void setMapSwitchState(int n) {
        this.datapoolShared.setMapSwitchState(n);
    }

    public void setMapVisibilityForFPKSwitch(boolean bl) {
        this.datapoolShared.setMapVisibilityForFPKSwitch(bl);
    }

    public void setNextSwitchTo(int n) {
        this.nextSwitchTo = n;
    }

    public void setViewVisible(boolean bl) {
        this.mapDataPool.setViewVisible(bl);
    }

    public boolean isMapTemporarilyInABT() {
        return this.mapDataPool.isMapTemporarilyInABT();
    }

    public void setMapTemporarilyInABT(boolean bl) {
        this.mapDataPool.setMapTemporarilyInABT(bl);
    }
}

