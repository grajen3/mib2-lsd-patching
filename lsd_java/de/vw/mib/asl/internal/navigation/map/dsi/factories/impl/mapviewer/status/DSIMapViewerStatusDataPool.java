/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;

public class DSIMapViewerStatusDataPool {
    private MapDataPool mapDataPool;
    private boolean updateReadyReceived = false;
    private boolean serviceAvailable;
    private int serviceInstanceId;
    private boolean updateZoomListReceived;
    private boolean mapViewerCompletlyReady;
    private boolean mapViewer3ResolutionReceived;
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();

    public MapDataPool getMapDataPool() {
        return this.mapDataPool;
    }

    public int getMapViewer3Resolution() {
        return this.datapoolShared.getMapViewer3Resolution();
    }

    public int getServiceInstanceId() {
        return this.serviceInstanceId;
    }

    public boolean isMapViewer3ResolutionReceived() {
        return this.mapViewer3ResolutionReceived;
    }

    public boolean isMapViewerCompletlyReady() {
        return this.mapViewerCompletlyReady;
    }

    public boolean isServiceAvailable() {
        return this.serviceAvailable;
    }

    public boolean isUpdateReadyReceived() {
        return this.updateReadyReceived;
    }

    public boolean isUpdateZoomListReceived() {
        return this.updateZoomListReceived;
    }

    public void setMapDataPool(MapDataPool mapDataPool) {
        this.mapDataPool = mapDataPool;
    }

    public void setMapViewer3Resolution(int n) {
        this.datapoolShared.setMapViewer3Resolution(n);
    }

    public void setMapViewer3ResolutionReceived(boolean bl) {
        this.mapViewer3ResolutionReceived = bl;
    }

    public void setMapViewerCompletlyReady(boolean bl) {
        this.mapViewerCompletlyReady = bl;
    }

    public void setServiceAvailable(boolean bl) {
        this.serviceAvailable = bl;
    }

    public void setServiceInstanceId(int n) {
        this.serviceInstanceId = n;
    }

    public void setUpdateReadyReceived(boolean bl) {
        this.updateReadyReceived = bl;
    }

    public void setUpdateZoomListReceived(boolean bl) {
        this.updateZoomListReceived = bl;
    }
}

