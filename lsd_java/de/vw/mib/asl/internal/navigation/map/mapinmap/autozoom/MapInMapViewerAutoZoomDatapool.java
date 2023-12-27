/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom;

import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerDatapoolShared;

public class MapInMapViewerAutoZoomDatapool {
    private final MapInMapViewerDatapoolShared datapoolShared = MapInMapViewerDatapoolShared.getInstance();

    public int getAutoZoomRecommendedZoomLast() {
        return this.datapoolShared.getAutoZoomRecommendedZoomLast();
    }

    public boolean isAutoZoomMapInMap() {
        return this.datapoolShared.isAutoZoomMapInMap();
    }

    public boolean isPerspective2DCarUpActive() {
        return this.datapoolShared.isPerspective2DCarUpActive();
    }

    public boolean isPerspective2DNorthUpActive() {
        return this.datapoolShared.isPerspective2DNorthUpActive();
    }

    public boolean isPerspective3DCarUpActive() {
        return this.datapoolShared.isPerspective3DCarUpActive();
    }

    public void setAutoZoomMapInMap(boolean bl) {
        this.datapoolShared.setAutoZoomMapInMap(bl);
    }
}

