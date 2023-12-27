/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.PersistedTrafficSetup;

public class MapViewerKombiDataPool {
    private int autoZoomLimit;
    private boolean autozoomRaserizing;
    private boolean autozoomActive;
    private final MapDataPool dataPoolMainMap;
    private MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private boolean mapViewerVisibleAfterRecognizerFinished;
    private boolean mapViewerVisibleAfterKombiRestartFinished;
    private PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private PersistedTrafficSetup persistedTrafficSetup = PersistedTrafficSetup.getInstance();
    private float recommendedZoom;
    private boolean serviceMapViewerRegistred;
    private int zoomLevelDownwards;
    private int zoomLevelLow;
    private int zoomLevelUpwards;

    public MapViewerKombiDataPool() {
        this.dataPoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    }

    public boolean isDriverDistractionPreventionFeatureAvailable() {
        return this.datapoolShared.isDriverDistractionPreventionFeatureAvailable();
    }

    public int getAutoZoomLimit() {
        return this.autoZoomLimit;
    }

    public int getDayNightModeMainMap() {
        return this.persistedMapSetup.getDayNightModeMainMap();
    }

    public int getMapInKombiPerspective() {
        return this.persistedMapSetup.getMapInKombiPerspective();
    }

    public int getMapViewer3Resolution() {
        return this.datapoolShared.getMapViewer3Resolution();
    }

    public int getMetricSystem() {
        return DSIMapViewerControlFactoryVW.getMapDatapoolMain().getMetricSystem();
    }

    public float getRecommendedZoom() {
        return this.recommendedZoom;
    }

    public int getSpeedAndFlowRoadClass() {
        return this.persistedTrafficSetup.getSpeedAndFlowRoadClass();
    }

    public int getSpeedAndFlowRoadClassDSI() {
        return this.persistedTrafficSetup.getSpeedAndFlowRoadClassDSI();
    }

    public int getZoomLevelDownwards() {
        return this.zoomLevelDownwards;
    }

    public int getZoomLevelLow() {
        return this.zoomLevelLow;
    }

    public int getZoomLevelUpwards() {
        return this.zoomLevelUpwards;
    }

    public boolean isAutozoomRaserizing() {
        return this.autozoomRaserizing;
    }

    public boolean isFeatureShowEnhancedCityModelAllViewtypes() {
        return this.dataPoolMainMap.isFeatureShowEnhancedCityModelAllViewtypes();
    }

    public boolean isMapViewerVisibleAfterRecognizerFinished() {
        return this.mapViewerVisibleAfterRecognizerFinished;
    }

    public boolean isMapViewerVisibleAfterKombiRestartFinished() {
        return this.mapViewerVisibleAfterKombiRestartFinished;
    }

    public boolean isNightView() {
        return DSIMapViewerControlFactoryVW.getMapDatapoolMain().isNightView();
    }

    public boolean isServiceMapViewerRegistred() {
        return this.serviceMapViewerRegistred;
    }

    public boolean isTrafficShowIncidents() {
        return this.persistedTrafficSetup.getTrafficShowIncidents();
    }

    public void setAutoZoomLimit(int n) {
        this.autoZoomLimit = n;
    }

    public void setAutozoomRaserizing(boolean bl) {
        this.autozoomRaserizing = bl;
    }

    public void setDayNightModeMainMap(int n) {
        this.persistedMapSetup.setDayNightModeMainMap(n);
    }

    public void setMapInKombiPerspective(int n) {
        this.persistedMapSetup.setMapInKombiPerspective(n);
    }

    public void setMapViewerVisibleAfterRecognizerFinished(boolean bl) {
        this.mapViewerVisibleAfterRecognizerFinished = bl;
    }

    public void setMapViewerVisibleAfterKombiRestartFinished(boolean bl) {
        this.mapViewerVisibleAfterKombiRestartFinished = bl;
    }

    public void setRecommendedZoom(float f2) {
        this.recommendedZoom = f2;
    }

    public void setServiceMapViewerRegistred(boolean bl) {
        this.serviceMapViewerRegistred = bl;
    }

    public void setZoomLevelDownwards(int n) {
        this.zoomLevelDownwards = n;
    }

    public void setZoomLevelLow(int n) {
        this.zoomLevelLow = n;
    }

    public void setZoomLevelUpwards(int n) {
        this.zoomLevelUpwards = n;
    }

    public boolean isAutozoomActive() {
        return this.persistedMapSetup.getKombiMapAutoZoom();
    }

    public void setAutozoomActive(boolean bl) {
        this.persistedMapSetup.setKombiMapAutoZoom(bl);
    }

    public int getZoomLevel() {
        return this.persistedMapSetup.getKombiMapZoomLevel();
    }

    public void setZoomLevel(int n) {
        this.persistedMapSetup.setKombiMapZoomLevel(n);
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }
}

