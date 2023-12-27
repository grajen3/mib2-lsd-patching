/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerDatapoolShared;
import org.dsi.ifc.global.NavLocation;

public class MapInMapViewerPerspectivesDatapool {
    private final MapInMapViewerDatapoolShared datapoolShared = MapInMapViewerDatapoolShared.getInstance();

    public int getAutoZoomRecommendedZoomLast() {
        return this.datapoolShared.getAutoZoomRecommendedZoomLast();
    }

    public NavLocation getHomeLocation() {
        return this.datapoolShared.getHomeLocation();
    }

    public int getLastZoomLevelRangeview() {
        return this.datapoolShared.getLastZoomLevelRangeview();
    }

    public int getMapInMapPerspective() {
        return this.datapoolShared.getMapInMapPerspective();
    }

    public int getMapInMapZoomLevel() {
        return this.datapoolShared.getMapInMapZoomLevel();
    }

    public boolean isAutoZoomMapInMap() {
        return this.datapoolShared.isAutoZoomMapInMap();
    }

    public boolean isPerspectiveOverviewZoomActive() {
        return this.datapoolShared.isPerspectiveOverviewZoomActive();
    }

    public boolean isPerspectiveRangeViewActive() {
        return this.datapoolShared.isPerspectiveRangeViewActive();
    }

    public void setMapInMapMode(int n) {
        this.datapoolShared.setMapInMapMode(n);
    }

    public void setMapInMapPersepctive(int n) {
        this.datapoolShared.setMapInMapPerspective(n);
    }

    public void setPerspective2DCarUpActive(boolean bl) {
        this.datapoolShared.setPerspective2DCarUpActive(bl);
    }

    public void setPerspective2DNorthUpActive(boolean bl) {
        this.datapoolShared.setPerspective2DNorthUpActive(bl);
    }

    public void setPerspective3DCarUpActive(boolean bl) {
        this.datapoolShared.setPerspective3DCarUpActive(bl);
    }

    public void setPerspectiveOverviewZoomActive(boolean bl) {
        this.datapoolShared.setPerspectiveOverviewZoomActive(bl);
    }

    public void setPerspectiveRangeViewActive(boolean bl) {
        this.datapoolShared.setPerspectiveRangeViewActive(bl);
    }
}

