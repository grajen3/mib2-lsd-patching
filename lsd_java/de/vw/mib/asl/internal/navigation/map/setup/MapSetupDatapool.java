/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.PersistedTrafficSetup;
import de.vw.mib.genericevents.EventGeneric;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;

public class MapSetupDatapool {
    public static final boolean MAPINMAP_AVAILABLE = ServiceManager.configManagerDiag.isFeatureFlagSet(163);
    private boolean adbEntryChanged = true;
    private long[] configuredFlagHandles;
    private final MapDataPool dataPoolMainMap;
    private final MapViewerDatapoolShared datapoolShared;
    private boolean earlyMapGoOnReceived;
    private boolean earlyMapUpdateViewFreezeFalseReceived;
    private MapFlag[] mapFlags;
    private MapFlag mapFlagWayPointMode;
    private final INavigationDP navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private final IPersistedDestInputSetup persistanceDestinputSetup;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private final PersistedTrafficSetup persistedTrafficSetup = PersistedTrafficSetup.getInstance();
    private EventGeneric prepareOnEvent;
    private boolean renderingOfFirstMapActive;
    private boolean viewFreezeTrueReceived;
    private int[] visibleCategoryUids;
    private boolean mainMapReady;
    private boolean mapInMapReady;

    public MapSetupDatapool() {
        this.persistanceDestinputSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
        this.dataPoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
    }

    public void clear() {
        this.persistedMapSetup.clear();
    }

    public long[] getConfiguredFlagHandles() {
        return this.configuredFlagHandles;
    }

    MapFlag[] getConfiguredFlags() {
        return this.dataPoolMainMap.getConfiguredFlags();
    }

    public int getDayNightModeMainMap() {
        return this.persistedMapSetup.getDayNightModeMainMap();
    }

    public int[] getDualScreenVisibilities() {
        return this.persistedMapSetup.getDualScreenVisibilities();
    }

    public ArrayList getFavoritesList() {
        return this.dataPoolMainMap.getFavoritesList();
    }

    public NavLocation getHomeLocation() {
        return this.persistanceDestinputSetup.getHomeLocation();
    }

    long getHomeLocationID() {
        return this.datapoolShared.getHomeFlagId();
    }

    public Point getMainMapCarPosition() {
        return this.persistedMapSetup.getMainMapCarPosition();
    }

    public int getMainMapMapMode() {
        return this.persistedMapSetup.getMainMapMapMode();
    }

    public int getMainMapMapTypeLast() {
        return this.persistedMapSetup.getMainMapMapTypeLast();
    }

    public int getMainMapPerspective() {
        return this.persistedMapSetup.getMainMapPerspective();
    }

    public int getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public MapFlag[] getMapFlags() {
        return this.mapFlags;
    }

    public MapFlag getMapFlagWayPointMode() {
        return this.mapFlagWayPointMode;
    }

    public int[] getPreferredBrandUids() {
        return this.navigationDP.getPreferredBrandUids();
    }

    public EventGeneric getPrepareOnEvent() {
        return this.prepareOnEvent;
    }

    public int getSpeedAndFlowRoadClass() {
        return this.persistedTrafficSetup.getSpeedAndFlowRoadClass();
    }

    public int getSpeedAndFlowRoadClassDSI() {
        return this.persistedTrafficSetup.getSpeedAndFlowRoadClassDSI();
    }

    public int getSplitscreenMapMapMode() {
        return this.persistedMapSetup.getMapInMapMode();
    }

    public int[] getVisibleCategoryUids() {
        return this.visibleCategoryUids;
    }

    public boolean isAdbEntryChanged() {
        return this.adbEntryChanged;
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public boolean isAutoZoomMapInMap() {
        return this.persistedMapSetup.isAutoZoomMapInMap();
    }

    public boolean isEarlyMapGoOnReceived() {
        return this.earlyMapGoOnReceived;
    }

    public boolean isEarlyMapUpdateViewFreezeFalseReceived() {
        return this.earlyMapUpdateViewFreezeFalseReceived;
    }

    public boolean isFeatureShowEnhancedCityModelAllViewtypes() {
        return this.dataPoolMainMap.isFeatureShowEnhancedCityModelAllViewtypes();
    }

    public boolean isLaneGuidance() {
        return this.persistedMapSetup.isLaneGuidance();
    }

    public boolean isMainMapShowBrandIcons() {
        return this.persistedMapSetup.isMainMapShowBrandIcons();
    }

    public boolean isMainMapShowFavoritesIcons() {
        return this.persistedMapSetup.isMainMapShowFavoritesIcons();
    }

    public boolean isMainMapShowPoiIcons() {
        return this.persistedMapSetup.isMainMapShowPoiIcons();
    }

    public boolean isMapInMapAvailable() {
        return MAPINMAP_AVAILABLE;
    }

    public boolean isNightView() {
        return this.dataPoolMainMap.isNightView();
    }

    public boolean isRenderingOfFirstMapActive() {
        return this.renderingOfFirstMapActive;
    }

    public boolean isViewFreezeTrueReceived() {
        return this.viewFreezeTrueReceived;
    }

    public void setAdbEntryChanged(boolean bl) {
        this.adbEntryChanged = bl;
    }

    public void setConfiguredFlagHandles(long[] lArray) {
        this.configuredFlagHandles = lArray;
    }

    public void setDayNightModeMainMap(int n) {
        this.persistedMapSetup.setDayNightModeMainMap(n);
    }

    public void setDualScreenVisibilities(int[] nArray) {
        this.persistedMapSetup.setDualScreenVisibilities(nArray);
    }

    public void setEarlyMapGoOnReceived(boolean bl) {
        this.earlyMapGoOnReceived = bl;
    }

    public void setEarlyMapUpdateViewFreezeFalseReceived(boolean bl) {
        this.earlyMapUpdateViewFreezeFalseReceived = bl;
    }

    public void setFavoritesList(ArrayList arrayList) {
        this.dataPoolMainMap.setFavoritesList(arrayList);
    }

    void setHomeLocationID(long l) {
        this.datapoolShared.setHomeFlagId(l);
    }

    public void setLaneGuidance(boolean bl) {
        this.persistedMapSetup.setLaneGuidance(bl);
    }

    public void setMainMapShowBrandIcons(boolean bl) {
        this.persistedMapSetup.setMainMapShowBrandIcons(bl);
    }

    public void setMainMapShowFavorites(boolean bl) {
        this.persistedMapSetup.setMainMapShowFavorites(bl);
    }

    public void setMainMapShowPoiIcons(boolean bl) {
        this.persistedMapSetup.setMainMapShowPoiIcons(bl);
    }

    public void setMapFlags(MapFlag[] mapFlagArray) {
        this.mapFlags = mapFlagArray;
    }

    public void setMapFlagWayPointMode(MapFlag mapFlag) {
        this.mapFlagWayPointMode = mapFlag;
    }

    public void setNightView(boolean bl) {
        this.dataPoolMainMap.setNightView(bl);
    }

    public void setPnavRouteVisibility(boolean bl) {
        this.datapoolShared.setPnavRouteVisibility(bl);
    }

    public void setPrepareOnEvent(EventGeneric eventGeneric) {
        this.prepareOnEvent = eventGeneric;
    }

    public void setRenderingOfFirstMapActive(boolean bl) {
        this.renderingOfFirstMapActive = bl;
    }

    public void setViewFreezeTrueReceived(boolean bl) {
        this.viewFreezeTrueReceived = bl;
    }

    public void setVisibleCategoryUids(int[] nArray) {
        this.visibleCategoryUids = nArray;
    }

    public void setMainMapPersistedPerspective(int n) {
        this.datapoolShared.setPersistedPerspective(n);
    }

    public boolean isMainMapReady() {
        return this.mainMapReady;
    }

    public void setMainMapReady(boolean bl) {
        this.mainMapReady = bl;
    }

    public boolean isMapInMapReady() {
        return this.mapInMapReady;
    }

    public void setMapInMapReady(boolean bl) {
        this.mapInMapReady = bl;
    }
}

