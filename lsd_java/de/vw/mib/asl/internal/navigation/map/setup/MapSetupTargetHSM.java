/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.daynight.DayNightListener;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapDatapool;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupDatapool;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupNotifierModel;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupStateEarlyMap;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupStateInit;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupStateMain;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupStateRestart;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.map.MapFlag;

public class MapSetupTargetHSM
extends AbstractResettableAslHsmTarget
implements ReloadPersistedDataListener,
DayNightListener {
    protected final MapSetupDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapSetupTargetHSM]");
    protected final MapSetupNotifierDSI notifierDSI;
    protected final MapSetupNotifierModel notifierModel;
    private final MapSetupStateEarlyMap stateEarlyMap;
    private MapSetupStateRestart stateRestart;
    private final MapSetupStateInit stateInit;
    private final MapSetupStateMain stateMain;
    private ASLSystemAPI systemAPI = ASLSystemFactory.getSystemApi();
    private int SENSOR_MODE_NIGHT = 2;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;

    public MapSetupTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapSetupDatapool();
        this.notifierDSI = new MapSetupNotifierDSI();
        this.notifierModel = new MapSetupNotifierModel();
        this.stateEarlyMap = new MapSetupStateEarlyMap(this, this.getHsm(), "stateEarlyMap", this.getWorkStateParent());
        this.stateRestart = new MapSetupStateRestart(this, this.getHsm(), "stateRestart", this.getWorkStateParent());
        this.stateMain = new MapSetupStateMain(this, this.getHsm(), "stateMain", this.getWorkStateParent());
        this.stateInit = new MapSetupStateInit(this, this.getHsm(), "stateInit", this.stateMain);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    protected void initSystemObserver() {
        this.logger.trace("initSystemObserver()");
        this.systemAPI.addUnitChangeListener(0, this.stateMain);
    }

    protected void configureLaneGuidance(boolean bl) {
        this.datapool.setLaneGuidance(bl);
        this.notifierModel.notifyLaneGuidanceChanged(bl);
        this.notifierDSI.dsiNavigationEnableRgLaneGuidance(bl);
    }

    protected int convertTempUnitSystem2DSI(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        this.logger.makeError().append("Undefined temperature unit=(").append(n).append(")").log();
        return 0;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateEarlyMap;
    }

    protected void setBrandIconstyle() {
        int n = this.datapool.isMainMapShowBrandIcons() ? 0 : 1;
        this.notifierDSI.dsiMapViewerMainSetBrandIconStyle(new int[]{-1}, n);
        int[] nArray = this.datapool.getPreferredBrandUids();
        if (nArray != null && nArray.length > 0) {
            this.notifierDSI.dsiMapViewerMainSetBrandIconStyle(nArray, 0);
        }
    }

    protected void setPersistedModelValues() {
        this.logger.trace("setPersistedModelValues()");
        this.notifierModel.notifyPerspectiveChanged(this.datapool.getMainMapPerspective());
        this.notifierModel.notifyAutoZoomChanged(this.datapool.isAutoZoomMainMap());
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(this.datapool.isAutoZoomMainMap());
        this.notifierModel.notifyAutoZoomMapInMapChanged(this.datapool.isAutoZoomMapInMap());
        this.notifierModel.notifyShowPOIBrandMarkerChanged(this.datapool.isMainMapShowBrandIcons());
        this.notifierModel.notifyShowFavoritesChanged(this.datapool.isMainMapShowFavoritesIcons());
        this.notifierModel.notifyShowPOIsChanged(this.datapool.isMainMapShowPoiIcons());
        this.notifierModel.notifyLaneGuidanceChanged(this.datapool.isLaneGuidance());
        this.notifierModel.notifyLastMapTypeChanged(this.datapool.getMainMapMapTypeLast());
        this.notifierModel.notifyCurrentMapTypeOnboard();
        this.notifierModel.updateListDualScreenMapVisibilities(this.datapool.getDualScreenVisibilities());
        this.notifierModel.notifyDayNightModeChanged(this.datapool.getDayNightModeMainMap());
        this.restorePersistedCurrentDayNightMode();
        this.restorePersistedMapModeMainMap();
        this.restorePersistedMapModeSplitscreenMap();
    }

    private void restorePersistedCurrentDayNightMode() {
        if (this.datapool.isNightView()) {
            this.notifierModel.updateCurrentDayNightMode(1);
        } else {
            this.notifierModel.updateCurrentDayNightMode(0);
        }
    }

    private void restorePersistedMapModeMainMap() {
        int n = this.datapool.getMainMapMapMode();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("Persisted map mode in main map = ").append(n).log();
        }
        this.datapool.setMainMapPersistedPerspective(-1);
        if (n == 10) {
            if (ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceState() == 1) {
                this.setViewModeStati(true, false, false);
                this.logger.trace("Persisted map mode OVERVIEWMAP will be restored in main map.");
            } else {
                this.setViewModeStati(false, false, false);
                AbstractASLHsmTarget.writeIntegerToDatapool(840, this.datapool.getMainMapPerspective());
                ASLNavigationServiceMainMapDatapool.getInstance().setCachedPersistedPerspective(n);
                this.logger.trace("Persisted map mode OVERVIEWMAP will not be restored in main map, because no route guidance is active.");
            }
        } else if (n == 9) {
            if (ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceState() == 1) {
                this.setViewModeStati(false, true, false);
                this.logger.trace("Persisted map mode DESTINATIONMAP will be restored in main map.");
            } else {
                this.setViewModeStati(false, false, false);
                AbstractASLHsmTarget.writeIntegerToDatapool(840, this.datapool.getMainMapPerspective());
                ASLNavigationServiceMainMapDatapool.getInstance().setCachedPersistedPerspective(n);
                this.logger.trace("Persisted map mode DESTINATIONMAP will not be restored in main map, because no route guidance is active.");
            }
        } else if (n == 14) {
            this.setViewModeStati(false, false, true);
            this.datapool.setMainMapPersistedPerspective(7);
            this.logger.trace("Persisted map mode MOBILITY_HORIZON will be restored in main map.");
        } else if (n == 1) {
            this.setViewModeStati(false, false, false);
            AbstractASLHsmTarget.writeIntegerToDatapool(840, this.datapool.getMainMapPerspective());
            this.logger.trace("Persisted map mode MAPMODE_POSITIONMAP will be restored in main map.");
        }
    }

    private void setViewModeStati(boolean bl, boolean bl2, boolean bl3) {
        AbstractASLHsmTarget.writeBooleanToDatapool(876, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(880, bl2);
        AbstractASLHsmTarget.writeBooleanToDatapool(3589, bl3);
    }

    private void restorePersistedMapModeSplitscreenMap() {
        int n = this.datapool.getSplitscreenMapMapMode();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("Persisted map mode in splitscreen map = ").append(n).log();
        }
        if (n == 14) {
            AbstractASLHsmTarget.writeBooleanToDatapool(3588, true);
            this.logger.trace("Persisted map mode MOBILITY_HORIZON will be restored in splitscreen map.");
        }
    }

    protected void showFavorites(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("showFavorites(showFavorites=").append(bl).append(")").log();
        }
        this.datapool.setMainMapShowFavorites(bl);
        this.notifierModel.notifyShowFavoritesChanged(bl);
        if (bl) {
            this.showFavoritesOn();
        } else {
            this.showFavoritesOff();
        }
    }

    private void showFavoritesOff() {
        this.logger.trace("showFavoritesOff()");
        long[] lArray = this.datapool.getConfiguredFlagHandles();
        if (lArray == null) {
            return;
        }
        MapFlag[] mapFlagArray = new MapFlag[lArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            MapFlag mapFlag = new MapFlag();
            mapFlag.handle = lArray[i2];
            mapFlagArray[i2] = mapFlag;
        }
        this.notifierDSI.dsiMapViewerMainConfigureFlags(2, mapFlagArray);
    }

    private void showFavoritesOn() {
        this.logger.trace("showFavoritesOn()");
        if (this.datapool.isAdbEntryChanged()) {
            this.logger.trace("AdbEntry has changed.");
            this.datapool.setAdbEntryChanged(false);
            this.notifierDSI.dsiAdbEditGetEntries(new long[0], 15, 1);
        } else {
            this.logger.trace("AdbEntry has not changed.");
            MapFlag[] mapFlagArray = this.datapool.getMapFlags();
            if (mapFlagArray != null) {
                this.stateMain.setUpdateHomeFavorite(true, mapFlagArray);
                this.notifierDSI.dsiMapViewerMainConfigureFlags(0, mapFlagArray);
            }
        }
    }

    protected void transStateInit() {
        this.logger.trace("transStateInit");
        this.getHsm().trans(this.stateInit);
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain");
        this.getHsm().trans(this.stateMain);
    }

    @Override
    public void reloadPersistedData() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1728708672);
        eventGeneric.setInt(0, this.datapool.getMainMapMapTypeLast());
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1728708672, eventGeneric);
        this.setPersistedModelValues();
        this.changeBrandIconStyle(this.datapool.isMainMapShowBrandIcons());
        this.setDayNightMode(this.datapool.getDayNightModeMainMap());
        this.changePoiVisibility(this.datapool.isMainMapShowPoiIcons());
    }

    public void changeBrandIconStyle(boolean bl) {
        this.datapool.setMainMapShowBrandIcons(bl);
        this.notifierModel.notifyShowPOIBrandMarkerChanged(bl);
        this.setBrandIconstyle();
    }

    public void handleDayNightMode(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.notifierModel.notifyDayNightModeChanged(n);
        this.setDayNightMode(n);
    }

    private void setDayNightMode(int n) {
        this.datapool.setDayNightModeMainMap(n);
        switch (n) {
            case 0: {
                this.changeNightDayViewMode(false);
                break;
            }
            case 1: {
                this.changeNightDayViewMode(true);
                break;
            }
            default: {
                DayNightService dayNightService = ASLSystemFactory.getSystemApi().getDayNightService();
                boolean bl = this.convertDayNightSensorValueToIsNightBoolean(dayNightService.getDayNightModeSensorValue());
                this.changeNightDayViewMode(bl);
            }
        }
    }

    public void changeNightDayViewMode(boolean bl) {
        this.datapool.setNightView(bl);
        if (bl) {
            this.notifierDSI.dsiMapViewerMainSetNightView();
            this.notifierModel.updateCurrentDayNightMode(1);
            if (this.datapool.isMapInMapAvailable()) {
                this.notifierDSI.dsiMapViewerSplitScreenSetNightView();
            }
        } else {
            this.notifierDSI.dsiMapViewerMainSetDayView();
            this.notifierModel.updateCurrentDayNightMode(0);
            if (this.datapool.isMapInMapAvailable()) {
                this.notifierDSI.dsiMapViewerSplitScreenSetDayView();
            }
        }
    }

    public void addDayNightModeListener() {
        DayNightService dayNightService = ASLSystemFactory.getSystemApi().getDayNightService();
        dayNightService.addListener(this);
    }

    public void removeDayNightModeListener() {
        DayNightService dayNightService = ASLSystemFactory.getSystemApi().getDayNightService();
        dayNightService.removeListener(this);
    }

    @Override
    public void onDayNightModeSensorValueChanged(int n) {
        this.logger.trace(new StringBuffer().append("[MapSetupTargetHSM] handle onDayNightModeSensorValueChanged: dayNightMode=").append(n).toString());
        int n2 = this.datapool.getDayNightModeMainMap();
        if (n2 == 2) {
            boolean bl = this.convertDayNightSensorValueToIsNightBoolean(n);
            this.changeNightDayViewMode(bl);
        }
    }

    boolean convertDayNightSensorValueToIsNightBoolean(int n) {
        return n == this.SENSOR_MODE_NIGHT;
    }

    public void changePoiVisibility(boolean bl) {
        this.notifierModel.notifyShowPOIsChanged(bl);
        this.notifierDSI.dsiMapViewerMainSetGeneralPoiVisibility(bl);
    }

    void initDayNightMode() {
        int n = this.datapool.getDayNightModeMainMap();
        switch (n) {
            case 2: {
                DayNightService dayNightService = ASLSystemFactory.getSystemApi().getDayNightService();
                boolean bl = this.convertDayNightSensorValueToIsNightBoolean(dayNightService.getDayNightModeSensorValue());
                this.datapool.setNightView(bl);
                break;
            }
            case 0: {
                this.datapool.setNightView(false);
                break;
            }
            case 1: {
                this.datapool.setNightView(true);
                break;
            }
            default: {
                this.logger.error("Undefined value for day/night mode in main map. Mode is set to day");
                this.datapool.setNightView(false);
            }
        }
    }

    void initMapForFirstRendering() {
        int n;
        this.logger.trace("initMapForFirstRendering()");
        this.datapool.setRenderingOfFirstMapActive(true);
        this.configureLaneGuidance(this.datapool.isLaneGuidance());
        this.notifierDSI.dsiMapViewerMainViewFreeze(true);
        this.notifierDSI.dsiMapViewerMainShowTMCMessages(true);
        this.notifierDSI.dsiMapViewerMainSetEnableSoftZoom(true);
        this.notifierDSI.dsiMapViewerMainSetEnableSoftTilt(true);
        this.notifierDSI.dsiMapViewerMainSetEnableSoftJump(true);
        this.setBrandIconstyle();
        this.notifierDSI.dsiMapViewerMainSetGeneralPoiVisibility(this.datapool.isMainMapShowPoiIcons());
        boolean bl = this.datapool.isNightView();
        if (bl) {
            this.notifierDSI.dsiMapViewerMainSetNightView();
            if (this.datapool.isMapInMapAvailable()) {
                this.notifierDSI.dsiMapViewerSplitScreenSetNightView();
            }
        } else {
            this.notifierDSI.dsiMapViewerMainSetDayView();
            if (this.datapool.isMapInMapAvailable()) {
                this.notifierDSI.dsiMapViewerSplitScreenSetDayView();
            }
        }
        if ((n = this.datapool.getMainMapPerspective()) == 3 || n == 4 || n == 2 || n == 1) {
            this.notifierDSI.dsiMapViewerMainSetOrientation(0, null);
        } else {
            this.notifierDSI.dsiMapViewerMainSetOrientation(2, null);
        }
        if (n == 3 || n == 4) {
            this.notifierDSI.dsiMapViewerMainSetCityModelMode(2);
            this.notifierDSI.dsiMapViewerMainSetViewType(3);
        } else if (n == 2) {
            this.notifierDSI.dsiMapViewerMainSetViewType(1);
        } else {
            if (this.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
                this.notifierDSI.dsiMapViewerMainSetCityModelMode(2);
            } else {
                this.notifierDSI.dsiMapViewerMainSetCityModelMode(0);
            }
            this.notifierDSI.dsiMapViewerMainSetViewType(0);
        }
        this.notifierDSI.dsiMapViewerMainSetCarPosition(this.datapool.getMainMapCarPosition());
        this.notifierDSI.dsiMapViewerMainSetMode(this.datapool.getMainMapMapMode());
        this.notifierDSI.dsiMapViewerMainSetZoomLevel(this.datapool.getMainMapZoomLevel(), -1);
        this.notifierDSI.dsiMapViewerMainSetRouteColoringPolicy(0);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(408)) {
            int n2 = ASLSystemFactory.getSystemApi().getTemperatureUnit();
            int n3 = this.convertTempUnitSystem2DSI(n2);
            this.notifierDSI.dsiMapViewerMainSetTemperatureScale(n3);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
            this.notifierDSI.setSpeedAndFlowRoadClass(this.datapool.getSpeedAndFlowRoadClassDSI());
        }
        this.notifierDSI.dsiMapViewerMainViewSetVisible(false);
        this.notifierDSI.dsiMapViewerMainViewFreeze(false);
    }

    void initMapForRendering() {
        int n;
        this.logger.trace("initMapForRendering()");
        this.configureLaneGuidance(this.datapool.isLaneGuidance());
        this.notifierDSI.dsiMapViewerMainViewFreeze(true);
        this.notifierDSI.dsiMapViewerMainShowTMCMessages(true);
        this.notifierDSI.dsiMapViewerMainSetEnableSoftZoom(true);
        this.notifierDSI.dsiMapViewerMainSetEnableSoftTilt(true);
        this.notifierDSI.dsiMapViewerMainSetEnableSoftJump(true);
        this.setBrandIconstyle();
        this.notifierDSI.dsiMapViewerMainSetGeneralPoiVisibility(this.datapool.isMainMapShowPoiIcons());
        boolean bl = this.datapool.isNightView();
        if (bl) {
            this.notifierDSI.dsiMapViewerMainSetNightView();
            if (this.datapool.isMapInMapAvailable()) {
                this.notifierDSI.dsiMapViewerSplitScreenSetNightView();
            }
        } else {
            this.notifierDSI.dsiMapViewerMainSetDayView();
            if (this.datapool.isMapInMapAvailable()) {
                this.notifierDSI.dsiMapViewerSplitScreenSetDayView();
            }
        }
        if ((n = this.datapool.getMainMapPerspective()) == 3 || n == 4 || n == 2 || n == 1) {
            this.notifierDSI.dsiMapViewerMainSetOrientation(0, null);
        } else {
            this.notifierDSI.dsiMapViewerMainSetOrientation(2, null);
        }
        if (n == 3 || n == 4) {
            this.notifierDSI.dsiMapViewerMainSetCityModelMode(2);
            this.notifierDSI.dsiMapViewerMainSetViewType(3);
        } else if (n == 2) {
            this.notifierDSI.dsiMapViewerMainSetViewType(1);
        } else {
            if (this.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
                this.notifierDSI.dsiMapViewerMainSetCityModelMode(2);
            } else {
                this.notifierDSI.dsiMapViewerMainSetCityModelMode(0);
            }
            this.notifierDSI.dsiMapViewerMainSetViewType(0);
        }
        this.notifierDSI.dsiMapViewerMainSetCarPosition(this.datapool.getMainMapCarPosition());
        this.notifierDSI.dsiMapViewerMainSetMode(1);
        this.notifierDSI.dsiMapViewerMainSetZoomLevel(this.datapool.getMainMapZoomLevel(), -1);
        this.notifierDSI.dsiMapViewerMainSetRouteColoringPolicy(0);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(408)) {
            int n2 = ASLSystemFactory.getSystemApi().getTemperatureUnit();
            int n3 = this.convertTempUnitSystem2DSI(n2);
            this.notifierDSI.dsiMapViewerMainSetTemperatureScale(n3);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
            this.notifierDSI.setSpeedAndFlowRoadClass(this.datapool.getSpeedAndFlowRoadClassDSI());
        }
        this.notifierDSI.dsiMapViewerMainViewSetVisible(false);
        this.notifierDSI.dsiMapViewerMainViewFreeze(false);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapSetupTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapSetupTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 2) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = MapSetupTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = MapSetupTargetHSM.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 2)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("resetting values after DSI restart");
            }
            this.datapool.setMainMapReady(!this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapSetupTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0));
            this.datapool.setMapInMapReady(!this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapSetupTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 2));
            this.resetHsmToState(this.stateRestart);
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

