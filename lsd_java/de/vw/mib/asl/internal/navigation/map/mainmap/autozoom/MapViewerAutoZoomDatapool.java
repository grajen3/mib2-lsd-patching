/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.autozoom;

import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;

public class MapViewerAutoZoomDatapool {
    private final MapViewerDatapoolShared datapoolMapViewer;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();

    public MapViewerAutoZoomDatapool() {
        this.datapoolMapViewer = MapViewerDatapoolShared.getInstance();
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public int getMainMapContent() {
        return this.persistedMapSetup.getMainMapContent();
    }

    public int getMainMapMapMode() {
        return this.persistedMapSetup.getMainMapMapMode();
    }

    public int getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public boolean isFocusCCPZoom() {
        return this.datapoolMapViewer.isFocusCCPZoom();
    }

    public boolean isMapLocatedInKombi() {
        return this.persistedMapSetup.isMapLocatedInKombi();
    }

    public boolean isMapMoved() {
        return this.datapoolMapViewer.isMapMoved();
    }

    public boolean isContinuousZoomActive() {
        return this.datapoolMapViewer.isContinuousZoomActive();
    }

    public boolean isPerspective25DCarUp() {
        return this.datapoolMapViewer.isPerspective25DCarUp();
    }

    public boolean isPerspective2DCarUp() {
        return this.datapoolMapViewer.isPerspective2DCarUp();
    }

    public boolean isPerspective2DNorthUp() {
        return this.datapoolMapViewer.isPerspective2DNorthUp();
    }

    public boolean isPerspective3DCarUp() {
        return this.datapoolMapViewer.isPerspective3DCarUp();
    }

    public boolean isPerspective3DDTM() {
        return this.datapoolMapViewer.isPerspective3DDTM();
    }

    boolean isPerspectiveCountryOverview() {
        return this.datapoolMapViewer.isPerspectiveCountryOverview();
    }

    public boolean isPerspectiveRocketZoom() {
        return this.datapoolMapViewer.isPerspectiveRocketZoom();
    }

    public void setAutozoomDeactivatedWhileDrag(boolean bl) {
        this.datapoolMapViewer.setAutozoomDeactivatedWhileDrag(bl);
    }

    public boolean isMapExternalConfigured() {
        return this.datapoolMapViewer.isMapExternalConfigured();
    }

    public void setAutoZoomMainMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMainMap(bl);
    }

    public void setAutozoomRecommendedZoomLast(int n) {
        this.persistedMapSetup.setAutozoomRecommendedZoomLast(n);
    }

    public void setMainMapZoomLevel(int n) {
        this.persistedMapSetup.setMainMapZoomLevel(n);
    }
}

