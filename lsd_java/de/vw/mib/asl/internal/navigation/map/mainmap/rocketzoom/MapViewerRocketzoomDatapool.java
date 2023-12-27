/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;

public class MapViewerRocketzoomDatapool {
    private final MapDataPool datapoolMapMain;
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();

    public MapViewerRocketzoomDatapool() {
        this.datapoolMapMain = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public int getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public int getMapMode() {
        return this.datapoolMapMain.getMapMode();
    }

    float getZoomLevel() {
        return this.datapoolMapMain.getZoomLevel();
    }

    public int getZoomLevelSwitchToNorthUp() {
        return this.datapoolShared.getZoomLevelSwitchToNorthUp();
    }

    public int getZoomListIndexCurrent() {
        return this.datapoolMapMain.getZoomListIndex();
    }

    public int getZoomListIndexMax() {
        return this.datapoolMapMain.getZoomListIndexMax();
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
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

    public boolean isZoomLevelSwitchTo2DNorthOvershoot() {
        return this.datapoolShared.isZoomLevelSwitchTo2DNorthOvershoot();
    }

    public boolean isZoomLevelSwitchTo2DNorthUndershoot() {
        return this.datapoolShared.isZoomLevelSwitchTo2DNorthUndershoot();
    }

    public void setAutoZoomMainMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMainMap(bl);
    }

    public boolean isMapInMainScreen() {
        return this.datapoolShared.isMapInMainScreen();
    }

    public int getMainMapPerspective() {
        return this.persistedMapSetup.getMainMapPerspective();
    }

    public void setMainMapZoomLevel(int n) {
        this.persistedMapSetup.setMainMapZoomLevel(n);
    }

    public void setPerspectiveRocketZoom(boolean bl) {
        this.datapoolShared.setPerspectiveRocketZoom(bl);
    }

    public void setZoomLevelMainMapBackup(int n) {
        this.datapoolShared.setZoomLevelMainMapBackup(n);
    }

    public void setZoomLevelSwitchTo2DNorthOvershoot(boolean bl) {
        this.datapoolShared.setZoomLevelSwitchTo2DNorthOvershoot(bl);
    }

    public void setZoomLevelSwitchTo2DNorthUndershoot(boolean bl) {
        this.datapoolShared.setZoomLevelSwitchTo2DNorthUndershoot(bl);
    }
}

