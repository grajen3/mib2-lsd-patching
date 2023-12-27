/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.focus;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.global.NavLocation;

public class MapViewerFocusDatapool {
    private final MapDataPool datapoolMainMap;
    private final MapViewerDatapoolShared datapoolShared;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();

    public MapViewerFocusDatapool() {
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
        this.datapoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public int getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public int getOverviewMapZoomLevel() {
        return this.datapoolShared.getZoomLevelOverviewMapBackup();
    }

    public NavLocation getMapPosition() {
        return this.datapoolMainMap.getMapPosition();
    }

    public short getMapRotation() {
        return this.datapoolShared.getMapRotation();
    }

    public boolean isAutozoomDeactivatedWhileDrag() {
        return this.datapoolShared.isAutozoomDeactivatedWhileDrag();
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public boolean isMapMoved() {
        return this.datapoolShared.isMapMoved();
    }

    public void setAutozoomDeactivatedWhileDrag(boolean bl) {
        this.datapoolShared.setAutozoomDeactivatedWhileDrag(bl);
    }

    public void setAutoZoomMainMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMainMap(bl);
    }

    public void setCcpZoom(boolean bl) {
        this.datapoolShared.setFocusCCPZoom(bl);
    }

    public void setMainMapZoomLevel(int n) {
        this.persistedMapSetup.setMainMapZoomLevel(n);
    }

    public void setMapMoved(boolean bl) {
        this.datapoolShared.setMapMoved(bl);
    }

    public void setSurroundingZoom(boolean bl) {
        this.datapoolShared.setFocusSurroundingZoom(bl);
    }

    public boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isPerspectiveDestinationZoom() {
        return this.datapoolShared.isPerspectiveDestinationZoom();
    }

    public boolean isPerspectiveMobilityHorizon() {
        return this.datapoolShared.isPerspectiveMobilityHorizon();
    }

    public boolean isIgnoreNextFocusMode() {
        return this.datapoolShared.isIgnoreNextFocusMode();
    }

    public void setIgnoreNextFocusMode(boolean bl) {
        this.datapoolShared.setIgnoreNextFocusMode(bl);
    }

    public void setMapReinitRequired(boolean bl) {
        this.datapoolMainMap.setMapReinitRequired(bl);
    }

    public boolean isMapReinitRequired() {
        return this.datapoolMainMap.isMapReinitRequired();
    }

    public boolean isPerspectiveAlternativeRouteMap() {
        return this.datapoolShared.isPerspectiveAlternativeRouteMap();
    }

    public boolean isPerspectiveCountryOverview() {
        return this.datapoolShared.isPerspectiveCountryOverview();
    }

    public boolean isPerspectivePNavOverview() {
        return this.datapoolShared.isPerspectivePNavOverview();
    }

    public boolean isPerspectiveFinalDestinationZoom() {
        return this.datapoolShared.isPerspectiveFinalDestinationZoom();
    }
}

