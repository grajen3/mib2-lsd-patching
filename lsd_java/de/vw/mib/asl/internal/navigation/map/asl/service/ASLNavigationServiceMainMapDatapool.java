/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.map.MapFlag;

public class ASLNavigationServiceMainMapDatapool {
    private static ASLNavigationServiceMainMapDatapool INSTANCE = new ASLNavigationServiceMainMapDatapool();
    private ASLNavigationMapConfiguration currentNaviMapConfig;
    private boolean isDragActive;
    private boolean isMapViewerLocked;
    private final MapDataPool mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    private final MapViewerDatapoolShared mapDataPoolShared = MapViewerDatapoolShared.getInstance();
    private int[] mapLayerAvailable;
    private boolean mapReady;
    private int navStateOfOperation;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private boolean restoreAutozoom;
    private int restoreOrientation;
    private boolean restoreShowPOI;
    private boolean restoreShowTmc;
    private int restoreViewType;
    private int restoreZoom;
    private int selectedX;
    private int selectedY;
    private INavigationDP navigationDatapool = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private boolean restoreShowSpeedAndFlowFreeFlow;
    private boolean restoreShowSpeedAndFlowCongestions;

    public static ASLNavigationServiceMainMapDatapool getInstance() {
        return INSTANCE;
    }

    private ASLNavigationServiceMainMapDatapool() {
        this.setMapConfig(null);
        this.selectedX = 0;
        this.selectedY = 0;
        this.isDragActive = false;
        this.isMapViewerLocked = false;
        this.restoreAutozoom = false;
        this.restoreShowPOI = false;
        this.restoreShowTmc = false;
    }

    MapFlag[] getConfiguredFlags() {
        return this.mapDataPool.getConfiguredFlags();
    }

    public int getICMapServiceState() {
        return this.mapDataPoolShared.getICMapServiceState();
    }

    public int getHeadingValue() {
        return this.mapDataPoolShared.getHeadingValue();
    }

    public int getMainMapContent() {
        return this.persistedMapSetup.getMainMapContent();
    }

    ASLNavigationMapConfiguration getMapConfig() {
        return this.currentNaviMapConfig;
    }

    int[] getMapLayerAvailable() {
        return this.mapLayerAvailable;
    }

    int getMapLayerVisible() {
        int[] nArray = this.mapDataPool.getMapLayerVisible();
        if (nArray != null && nArray.length > 0) {
            return nArray[0];
        }
        return -1;
    }

    int getMapMode() {
        return this.mapDataPool.getMapMode();
    }

    int getMainMapPerspective() {
        int n = this.mapDataPoolShared.getPersistedPerspective();
        if (n == 7) {
            return 7;
        }
        int n2 = this.persistedMapSetup.getMainMapPerspective();
        if (n2 == 3) {
            return 6;
        }
        if (n2 == 4) {
            return 6;
        }
        if (n2 == 2) {
            return 4;
        }
        if (n2 == 1) {
            return 4;
        }
        return 5;
    }

    int getMapOrientation() {
        return this.mapDataPool.getOrientation();
    }

    public int getMapSwitchState() {
        return this.mapDataPoolShared.getMapSwitchState();
    }

    public boolean getMapVisibilityForFPKSwitch() {
        return this.mapDataPoolShared.getMapVisibilityForFPKSwitch();
    }

    public int getNavStateOfOperation() {
        return this.navStateOfOperation;
    }

    public int getRestoreOrientation() {
        return this.restoreOrientation;
    }

    public int getRestoreViewType() {
        return this.restoreViewType;
    }

    public int getRestoreZoom() {
        return this.restoreZoom;
    }

    int getSelectedX() {
        return this.selectedX;
    }

    int getSelectedY() {
        return this.selectedY;
    }

    int getZoomLevel() {
        return (int)(this.mapDataPool.getZoomLevel() / 51266);
    }

    int getZoomLevelMax() {
        return (int)(this.mapDataPool.getZoomList()[this.mapDataPool.getZoomListIndexMax()] / 51266);
    }

    int getZoomLevelMin() {
        return (int)(this.mapDataPool.getZoomList()[this.mapDataPool.getZoomListIndexMin()] / 51266);
    }

    boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    boolean isDragActive() {
        return this.isDragActive;
    }

    public boolean isMapLocatedInKombi() {
        return this.persistedMapSetup.isMapLocatedInKombi();
    }

    public boolean isMapReady() {
        return this.mapReady;
    }

    public boolean isMapSwitchFunctionAvailableInKombi() {
        return this.mapDataPoolShared.isMapSwitchFunctionAvailableInKombi();
    }

    boolean isMapViewerLocked() {
        return this.isMapViewerLocked;
    }

    boolean isRestoreAutozoom() {
        return this.restoreAutozoom;
    }

    boolean isRestoreShowPOI() {
        return this.restoreShowPOI;
    }

    boolean isRestoreShowTmc() {
        return this.restoreShowTmc;
    }

    public boolean isSwitchDoneAtLockMapViewer() {
        return this.mapDataPoolShared.isSwitchDoneAtLockMapViewer();
    }

    public boolean isTouchApproximated() {
        return this.mapDataPoolShared.getLatestTouchApproach();
    }

    void setASLServiceActive(boolean bl) {
        this.mapDataPoolShared.setASLServiceActive(bl);
    }

    void setASLServiceProximityActive(boolean bl) {
        this.mapDataPoolShared.setASLServiceProximityActive(bl);
    }

    void setAutoZoomMainMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMainMap(bl);
    }

    void setDragActive(boolean bl) {
        this.isDragActive = bl;
    }

    public void setMainMapLocatedInAbt(boolean bl) {
        this.persistedMapSetup.setMainMapLocatedInAbt(bl);
    }

    public void setMainMapLocatedInKombi(boolean bl) {
        this.persistedMapSetup.setMainMapLocatedInKombi(bl);
    }

    void setMapConfig(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        this.currentNaviMapConfig = aSLNavigationMapConfiguration;
    }

    void setMapLayerAvailable(int[] nArray) {
        this.mapLayerAvailable = nArray;
    }

    public void setMapReady(boolean bl) {
        this.mapReady = bl;
    }

    public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
        this.mapDataPoolShared.setMapSwitchFunctionAvailableInKombi(bl);
    }

    public void setMapSwitchState(int n) {
        this.mapDataPoolShared.setMapSwitchState(n);
    }

    void setMapViewerLocked(boolean bl) {
        this.isMapViewerLocked = bl;
    }

    public void setMapVisibilityForFPKSwitch(boolean bl) {
        this.mapDataPoolShared.setMapVisibilityForFPKSwitch(bl);
    }

    public void setNavStateOfOperation(int n) {
        this.navStateOfOperation = n;
    }

    void setRestoreAutozoom() {
        this.restoreAutozoom = this.isAutoZoomMainMap();
    }

    public void setRestoreOrientation() {
        this.restoreOrientation = this.mapDataPool.getOrientation();
    }

    public void setRestorePerspective() {
        this.restoreViewType = this.mapDataPool.getViewType();
    }

    void setRestoreShowPOI() {
        this.restoreShowPOI = this.mapDataPool.isGeneralPOIVisibility();
    }

    void setRestoreShowTmc() {
        this.restoreShowTmc = this.mapDataPool.isShowTmcMessages();
    }

    void setRestoreShowSpeedAndFlowFreeFlow() {
        this.restoreShowSpeedAndFlowFreeFlow = this.mapDataPool.isShowSpeedAndFlowFreeFlow();
    }

    void setRestoreShowSpeedAndFlowCongestions() {
        this.restoreShowSpeedAndFlowCongestions = this.mapDataPool.isShowSpeedAndFlowCongestions();
    }

    public void setRestoreZoom() {
        this.restoreZoom = this.persistedMapSetup.getMainMapZoomLevel();
    }

    void setSelectedX(int n) {
        this.selectedX = n;
    }

    void setSelectedY(int n) {
        this.selectedY = n;
    }

    public void setSwitchDoneAtLockMapViewer(boolean bl) {
        this.mapDataPoolShared.setSwitchDoneAtLockMapViewer(bl);
    }

    public int getMainMapZoomLevel() {
        return this.persistedMapSetup.getMainMapZoomLevel();
    }

    public void setMapSetToVisibleByClient(boolean bl) {
        this.mapDataPoolShared.setMapSetToVisibleByClient(bl);
    }

    public void setMapExternalConfigured(boolean bl) {
        this.mapDataPoolShared.setMapExternalConfigured(bl);
        this.navigationDatapool.setMapExternalConfigured(bl);
    }

    public int getZoomLevelMainMapBackup() {
        return this.mapDataPoolShared.getZoomLevelMainMapBackup();
    }

    public boolean isRestoreShowSpeedAndFlowFreeFlow() {
        return this.restoreShowSpeedAndFlowFreeFlow;
    }

    public boolean isRestoreShowSpeedAndFlowCongestions() {
        return this.restoreShowSpeedAndFlowCongestions;
    }

    public void setCachedPersistedPerspective(int n) {
        this.mapDataPoolShared.setCachedPersistedPerspective(n);
    }

    public int getCachedPersistedPerspective() {
        return this.mapDataPoolShared.getCachedPersistedPerspective();
    }

    public void setIgnoreNextPerspectiveSet(boolean bl) {
        this.mapDataPoolShared.setIgnoreNextPerspectiveSet(bl);
    }

    public boolean isIgnoreNextPerspectiveSet() {
        return this.mapDataPoolShared.isIgnoreNextPerspectiveSet();
    }

    public void setIgnoreNextFocusMode(boolean bl) {
        this.mapDataPoolShared.setIgnoreNextFocusMode(bl);
    }

    public boolean isMapTemporarilyInABT() {
        return this.mapDataPool.isMapTemporarilyInABT();
    }
}

