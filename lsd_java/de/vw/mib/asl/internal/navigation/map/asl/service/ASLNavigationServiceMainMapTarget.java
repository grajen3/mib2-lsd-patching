/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapDatapool;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapEvents;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapFactory;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapNotifierModel;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapStateInit;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapStateWork;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapTarget$1;
import de.vw.mib.asl.internal.navigation.map.dsi.DSINavigationVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSINavigationFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class ASLNavigationServiceMainMapTarget
extends AbstractResettableAslHsmTarget
implements ASLNavigationServiceMainMap {
    protected final IExtLogger LOGGER;
    private final ASLNavigationServiceMainMapStateInit stateInit;
    private final ASLNavigationServiceMainMapStateWork stateWork;
    private ASLNavigationServiceMainMapNotifierDSI notifierDSI;
    private ASLNavigationServiceMainMapNotifierModel notifierModel;
    protected ASLNavigationServiceMainMapDatapool datapool;
    private MapViewerDatapoolShared datapoolShared;
    private AbstractTarget clientTarget;
    protected int targetId;
    private int[] subscribedEventIds;
    private static final int ACTION_GOTO_NAV_LOCATION;
    private static final int ACTION_FOCUS_CARSOR;
    private static final int ACTION_CHANGE_LAYER;
    private static final int ACTION_CHANGE_PERSPECTIVE;
    private static final int ACTION_CHANGE_ZOOM_AREA;
    private static final int ACTION_CHANGE_ZOOM_LEVEL;
    private static final int ACTION_TOGGLE_AUTOZOOM;
    private static final int ACTION_CHANGE_FLAG_STYLE;
    private static final int ACTION_CHANGE_MAP_VIEW_TYPE;
    private static final int ACTION_CHANGE_MAP_MODE;
    private static final int ACTION_CHANGE_ORIENTATION;
    private static final int ACTION_CHANGE_SCREEN_VIEWPORT;
    private static final int ACTION_CHANGE_SCREEN_VIEWPORT_MAXIMUM;
    private static final int ACTION_CHANGE_MAPVIEWPORT_BY_WGS84_RECTANGLE;
    private static final int ACTION_CHANGE_HOTPOINT;
    private ArrayList queuedActions;
    private boolean forceFullConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public ASLNavigationServiceMainMapTarget(GenericEvents genericEvents, int n, String string, AbstractTarget abstractTarget, int[] nArray) {
        super(genericEvents, n, string);
        String string2 = new StringBuilder("[ASLNavigationServiceMainMapTarget-").append(n).append("]").toString();
        this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, string2);
        this.clientTarget = abstractTarget;
        this.targetId = n;
        this.subscribedEventIds = nArray;
        this.datapool = ASLNavigationServiceMainMapDatapool.getInstance();
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
        this.stateWork = new ASLNavigationServiceMainMapStateWork(this, "stateWork", this.getWorkStateParent());
        this.stateInit = new ASLNavigationServiceMainMapStateInit(this, "stateInit", (HsmState)this.stateWork);
    }

    @Override
    public void clickInMap(Point point) {
        this.LOGGER.trace("clickInMap()");
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("clickInMap() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        this.datapool.setSelectedX(point.xPos);
        this.datapool.setSelectedY(point.yPos);
        this.notifierDSI.getInfoForScreenPosition(point);
    }

    @Override
    public void dragMap(short s, short s2) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("dragMap(x=").append(s).append(",y=").append(s2).append(")").log();
        }
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("dragMap() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (!MapViewerUtils.isMapModeDraggable(this.datapool.getMapMode())) {
            this.LOGGER.warn("dragMap() - Map not draggable, switching to FREEMAP map mode!");
            this.datapool.getMapConfig().setMapMode(2);
            this.notifierDSI.setMode(this.datapool.getMapConfig().getMapMode());
        }
        if (!this.datapool.isDragActive()) {
            this.datapool.setSelectedX(s);
            this.datapool.setSelectedY(s2);
            this.datapool.setDragActive(true);
            this.forceFullConfiguration = true;
            return;
        }
        short s3 = (short)(s - this.datapool.getSelectedX());
        short s4 = (short)(s2 - this.datapool.getSelectedY());
        this.datapool.setSelectedX(s);
        this.datapool.setSelectedY(s2);
        this.notifierDSI.dragMap(s3, s4);
    }

    @Override
    public void dragMapStop() {
        this.LOGGER.trace("dragMapStop()");
        if (!this.datapool.isMapViewerLocked()) {
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        this.datapool.setDragActive(false);
        this.notifierDSI.stopScrollToDirection();
    }

    AbstractTarget getClientTarget() {
        return this.clientTarget;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public void goToLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        this.goToLocation(aSLNavigationMapConfiguration, true);
    }

    @Override
    public void goToLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration, boolean bl) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("goToLocation(ASLNavigationMapConfiguration=").append(aSLNavigationMapConfiguration.toString()).append(")").log();
        }
        if (bl && !this.datapool.isMapViewerLocked()) {
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (!bl) {
            this.queuedActions = new ArrayList();
            this.datapool.setMapConfig(null);
        }
        if (!this.queuedActions.isEmpty()) {
            this.queuedActions.clear();
            this.datapool.setMapConfig(null);
        }
        if (!this.processMapConfig(aSLNavigationMapConfiguration, this.forceFullConfiguration)) {
            if (this.isSubscribed(1306604288)) {
                ASLNavigationServiceMainMapEvents.sendEventMapGoToLocationMapReady(this.clientTarget);
            }
            return;
        }
        this.performActions();
        this.forceFullConfiguration = false;
        if (!bl) {
            this.datapool.setMapConfig(null);
        }
    }

    protected void initTarget() {
        this.LOGGER.trace("initTarget()");
        this.initASL();
        this.initDSI();
    }

    private void initDSI() {
        this.LOGGER.trace("initDSI()");
        this.notifierDSI = new ASLNavigationServiceMainMapNotifierDSI(DSIMapViewerControlFactoryVW.createMapViewerMain(this, ASLNavigationServiceMainMapEvents.ATTRIBUTES_MAPVIEWERCONTROL), this);
        this.notifierModel = new ASLNavigationServiceMainMapNotifierModel();
        DSINavigationVW dSINavigationVW = DSINavigationFactoryVW.createNavigation(this, ASLNavigationServiceMainMapEvents.ATTRITBUTES_NAVIGATION);
        this.notifierDSI.setDsiNavigation(dSINavigationVW);
    }

    private void initASL() {
        this.LOGGER.trace("initASL()");
        this.addObservers(ASLNavigationServiceMainMapEvents.ASL_OBSERVERS);
        this.initASLAPIListener();
    }

    private void initASLAPIListener() {
        ASLNavigationFactory.getNavigationApi().getASLNavigationServices(new ASLNavigationServiceMainMapTarget$1(this));
    }

    protected boolean isSubscribed(int n) {
        for (int i2 = 0; i2 < this.subscribedEventIds.length; ++i2) {
            if (this.subscribedEventIds[i2] != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public void lockMapViewer() {
        this.LOGGER.trace("lockMapViewer()");
        if (ASLNavigationServiceMainMapFactory.INSTANCE.isAnyServiceLocked()) {
            this.LOGGER.error("Map Viewer already locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(139) && this.datapool.isMapLocatedInKombi()) {
            this.datapool.setSwitchDoneAtLockMapViewer(true);
            ASLNavigationMapFactory.getNavigationMapApi().sendMapViewMapTriggerSwitch();
            this.datapool.setRestoreZoom();
            this.datapool.setRestorePerspective();
            this.datapool.setRestoreOrientation();
        }
        this.datapool.setASLServiceActive(true);
        this.datapool.setMapViewerLocked(true);
        this.datapool.setASLServiceProximityActive(true);
        this.queuedActions = new ArrayList();
        this.forceFullConfiguration = true;
        this.datapool.setRestoreShowTmc();
        this.datapool.setRestoreShowSpeedAndFlowCongestions();
        this.datapool.setRestoreShowSpeedAndFlowFreeFlow();
        this.datapool.setRestoreShowPOI();
        this.datapool.setRestoreAutozoom();
        this.notifierDSI.setGeneralPoiVisibility(false);
        this.notifierDSI.viewSetVisible();
        this.datapool.setMapExternalConfigured(true);
        this.datapool.setMapSetToVisibleByClient(true);
        ASLNavigationServiceMainMapEvents.sendEventMapLocked(this.clientTarget);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1591816960);
        eventGeneric.setObject(0, this.clientTarget);
        ASLNavigationServiceMainMapFactory.INSTANCE.sentToAllMapServiceTargets(eventGeneric);
    }

    private void performActionChangeFlagStyle() {
        this.LOGGER.trace("performActionChangeFlagStyle()");
        NavLocation navLocation = this.datapool.getMapConfig().getNavLocation();
        this.notifierDSI.clearFlags();
        if (navLocation != null) {
            MapFlag[] mapFlagArray = new MapFlag[]{new MapFlag(navLocation.longitude, navLocation.latitude, this.datapool.getMapConfig().getFlagStyleType(), 1L)};
            this.notifierDSI.configureFlags(0, mapFlagArray);
        }
    }

    private void performActionChangeLayer() {
        this.LOGGER.trace("performActionChangeLayer()");
        this.notifierDSI.setMapLayerVisible(this.datapool.getMapConfig().getMapLayerVisible());
    }

    private void performActionChangeMapMode() {
        this.LOGGER.trace("performActionChangeMapMode()");
        this.notifierDSI.setMode(this.datapool.getMapConfig().getMapMode());
        if (this.datapool.getMapConfig().getMapMode() == 14) {
            this.notifierDSI.setMobilityHorizonVisibility(true);
        }
    }

    private void performActionChangeMapViewType() {
        this.LOGGER.trace("performActionChangeMapViewType()");
        this.notifierDSI.setViewType(this.datapool.getMapConfig().getMapViewType());
    }

    private void performActionChangeOrientation() {
        this.LOGGER.trace("performActionChangeOrientation()");
        this.notifierDSI.setOrientation(this.datapool.getMapConfig().getOrientation());
    }

    private void performActionChangePerspective() {
        this.LOGGER.trace("performActionChangePerspective()");
        switch (this.datapool.getMapConfig().getPerspective()) {
            case 1: {
                ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainActivateDestinationZoom();
                break;
            }
            case 2: {
                ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainActivateFinalDestinationZoom();
                break;
            }
            case 3: {
                ASLNavigationServiceMainMapEvents.sendEventToggleOverviewZoom();
                break;
            }
            case 7: {
                this.notifierDSI.setMobilityHorizonVisibility(true);
                break;
            }
            default: {
                this.LOGGER.error("performActionChangePerspective() - wrong parameter!");
            }
        }
    }

    private void performActionChangeZoomArea() {
        this.LOGGER.trace("performActionChangeZoomArea()");
        Rect rect = this.datapool.getMapConfig().getZoomArea();
        if (rect.diffX == 0 || rect.diffY == 0) {
            this.LOGGER.error("Invalid zoom area dimensions. NOT setting the new parameters!");
            return;
        }
        this.notifierDSI.setZoomArea(rect);
        if (!this.queuedActions.contains(new Integer(15))) {
            Point point = MapViewerUtils.calculateHotPointByZoomArea(rect);
            this.notifierDSI.setHotPoint(point);
        }
    }

    private void performActionChangeScreenViewport() {
        this.LOGGER.trace("performActionChangeScreenViewport()");
        Rect rect = this.datapool.getMapConfig().getScreenViewport();
        if (rect != null) {
            this.notifierDSI.setScreenViewport(rect);
        }
    }

    private void performActionChangeScreenViewportMaximum() {
        this.LOGGER.trace("performActionChangeScreenViewportMaximum()");
        Rect rect = this.datapool.getMapConfig().getScreenViewportMaximum();
        if (rect != null) {
            this.notifierDSI.setScreenViewportMaximum(rect);
        }
    }

    private void performActionChangeMapViewPortByWGS84Rectangle() {
        this.LOGGER.trace("performActionChangeMapViewPortByWGS84Rectangle()");
        INavRectangle iNavRectangle = this.datapool.getMapConfig().getMapViewPortByWGS84Rectangle();
        NavRectangle navRectangle = new NavRectangle(iNavRectangle.getxLeft(), iNavRectangle.getxRight(), iNavRectangle.getyBottom(), iNavRectangle.getyUp(), iNavRectangle.isRectangleInvalid());
        if (navRectangle != null) {
            this.notifierDSI.setMapViewPortByWGS84Rectangle(navRectangle, -1);
        }
    }

    private void performActionChangeHotPoint() {
        this.LOGGER.trace("performActionChangeHotPoint()");
        Point point = this.datapool.getMapConfig().getHotPoint();
        if (point != null) {
            this.notifierDSI.setHotPoint(point);
        }
    }

    private void performActionChangeZoomLevel() {
        this.LOGGER.trace("performActionChangeZoomLevel()");
        this.notifierDSI.setZoomLevel(this.datapool.getMapConfig().getZoomLevel() * 100);
    }

    private void performActionGotoNavLocation() {
        this.LOGGER.trace("performActionGotoNavLocation()");
        NavLocation navLocation = this.datapool.getMapConfig().getNavLocation();
        if (!MapViewerUtils.isPositionValid(navLocation.latitude, navLocation.longitude)) {
            this.LOGGER.error("Invalid Map Position, NOT setting the new location!");
            return;
        }
        this.notifierDSI.setLocationByLocation(navLocation);
    }

    private void performActions() {
        this.notifierDSI.viewFreeze();
        while (!this.queuedActions.isEmpty()) {
            int n = (Integer)this.queuedActions.remove(0);
            switch (n) {
                case 1: {
                    this.performActionGotoNavLocation();
                    break;
                }
                case 2: {
                    this.performFocusCarsor();
                    break;
                }
                case 3: {
                    this.performActionChangeLayer();
                    break;
                }
                case 4: {
                    this.performActionChangePerspective();
                    break;
                }
                case 5: {
                    this.performActionChangeZoomArea();
                    break;
                }
                case 6: {
                    this.performActionChangeZoomLevel();
                    break;
                }
                case 7: {
                    this.performActionToggleAutozoom();
                    break;
                }
                case 8: {
                    this.performActionChangeFlagStyle();
                    break;
                }
                case 9: {
                    this.performActionChangeMapViewType();
                    break;
                }
                case 10: {
                    this.performActionChangeMapMode();
                    break;
                }
                case 11: {
                    this.performActionChangeOrientation();
                    break;
                }
                case 12: {
                    this.performActionChangeScreenViewport();
                    break;
                }
                case 13: {
                    this.performActionChangeScreenViewportMaximum();
                    break;
                }
                case 14: {
                    this.performActionChangeMapViewPortByWGS84Rectangle();
                    break;
                }
                case 15: {
                    this.performActionChangeHotPoint();
                    break;
                }
            }
        }
        this.notifierDSI.viewUnfreeze();
    }

    private void performActionToggleAutozoom() {
        this.LOGGER.trace("performActionToggleAutozoom()");
        if (this.datapool.isAutoZoomMainMap()) {
            this.datapool.setAutoZoomMainMap(false);
        } else {
            this.datapool.setAutoZoomMainMap(true);
        }
    }

    private void performFocusCarsor() {
        this.LOGGER.trace("performFocusCarsor()");
        if (this.datapool.getMapConfig().getCarPosition() == null) {
            if (this.queuedActions.contains(new Integer(15))) {
                this.datapool.getMapConfig().setCarPosition(this.datapool.getMapConfig().getHotPoint());
            } else {
                Point point = MapViewerUtils.calculateHotPointByZoomArea(this.datapool.getMapConfig().getZoomArea());
                this.datapool.getMapConfig().setCarPosition(point);
            }
        }
        this.notifierDSI.setCarPosition(this.datapool.getMapConfig().getCarPosition());
    }

    private boolean processMapConfig(ASLNavigationMapConfiguration aSLNavigationMapConfiguration, boolean bl) {
        Point point;
        INavRectangle iNavRectangle;
        Rect rect;
        Object object;
        int n;
        int n2;
        int n3;
        Rect rect2;
        int n4;
        int n5;
        int n6;
        boolean bl2;
        if (this.datapool.getMapConfig() == null) {
            bl2 = this.datapool.isMapSwitchFunctionAvailableInKombi();
            if (bl2) {
                String string = ServiceManager.configManagerDiag.getPureVariant();
                n6 = this.datapoolShared.getMapViewer3Resolution();
                if (string.startsWith("STD2") && PersistedMapSetup.getInstance().isMapLocatedInKombi() && 2 == n6) {
                    this.datapool.setMapConfig(new ASLNavigationMapConfiguration(bl2, n6));
                } else {
                    this.datapool.setMapConfig(new ASLNavigationMapConfiguration());
                }
            } else {
                this.datapool.setMapConfig(new ASLNavigationMapConfiguration());
            }
            bl = true;
        }
        if ((bl2 = aSLNavigationMapConfiguration.isAutozoom()) != this.datapool.isAutoZoomMainMap()) {
            this.datapool.getMapConfig().setAutozoom(bl2);
            this.queuedActions.add(new Integer(7));
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(408) && ((n5 = aSLNavigationMapConfiguration.getMapLayerVisible()) != this.datapool.getMapLayerVisible() || bl)) {
            this.datapool.getMapConfig().setMapLayerVisible(n5);
            this.queuedActions.add(new Integer(3));
        }
        if ((n4 = aSLNavigationMapConfiguration.getPerspective()) != this.datapool.getMapConfig().getPerspective() || bl) {
            this.datapool.getMapConfig().setPerspective(n4);
            if (this.datapool.getMapConfig().getPerspective() != -1) {
                this.queuedActions.add(new Integer(4));
            }
        }
        n6 = aSLNavigationMapConfiguration.getMapMode();
        if (n4 != 3 && (n6 != this.datapool.getMapMode() || bl)) {
            this.datapool.getMapConfig().setMapMode(n6);
            this.queuedActions.add(new Integer(10));
        }
        if ((rect2 = aSLNavigationMapConfiguration.getZoomArea()) != this.datapool.getMapConfig().getZoomArea() || bl) {
            this.datapool.getMapConfig().setZoomArea(rect2);
            if (rect2 != null) {
                this.queuedActions.add(new Integer(5));
            }
        }
        int n7 = aSLNavigationMapConfiguration.getZoomLevel();
        if (n4 != 3 && !bl2 && (n7 != this.datapool.getZoomLevel() || bl)) {
            n3 = this.datapool.getZoomLevelMax();
            n2 = this.datapool.getZoomLevelMin();
            if (n7 >= n2 && n7 <= n3) {
                this.datapool.getMapConfig().setZoomLevel(n7);
                this.queuedActions.add(new Integer(6));
            } else {
                this.LOGGER.error("processMapConfig() - zoom level out of range, NOT setting!");
            }
        }
        n3 = aSLNavigationMapConfiguration.getOrientation();
        if (n4 != 3 && n3 != this.datapool.getMapOrientation() || bl) {
            this.datapool.getMapConfig().setOrientation(n3);
            this.queuedActions.add(new Integer(11));
        }
        n2 = aSLNavigationMapConfiguration.getFlagStyleType();
        NavLocation navLocation = aSLNavigationMapConfiguration.getNavLocation();
        if (MapViewerUtils.isPositionValid(navLocation)) {
            MapFlag[] mapFlagArray = this.datapool.getConfiguredFlags();
            if (mapFlagArray == null || mapFlagArray.length == 0 || bl) {
                this.datapool.getMapConfig().setFlagStyleType(n2);
                this.queuedActions.add(new Integer(8));
            } else if (mapFlagArray[0].getStyleIndex() != n2 || mapFlagArray[0].getGeoY() != navLocation.latitude || mapFlagArray[0].getGeoX() != navLocation.longitude) {
                this.datapool.getMapConfig().setFlagStyleType(n2);
                this.queuedActions.add(new Integer(8));
            }
        }
        if ((n = aSLNavigationMapConfiguration.getMapViewType()) != this.datapool.getMapConfig().getMapViewType() || bl) {
            this.datapool.getMapConfig().setViewType(n);
            this.queuedActions.add(new Integer(9));
        }
        if (aSLNavigationMapConfiguration.getNavLocation() != null) {
            object = aSLNavigationMapConfiguration.getNavLocation();
            if (object != this.datapool.getMapConfig().getNavLocation() || bl) {
                if (MapViewerUtils.isPositionValid((NavLocation)object)) {
                    this.datapool.getMapConfig().setNavLocation((NavLocation)object);
                    this.queuedActions.add(new Integer(1));
                } else {
                    this.LOGGER.error("processMapConfig() - invalid location, NOT setting!");
                }
            }
        } else {
            this.datapool.getMapConfig().setNavLocation(null);
            object = aSLNavigationMapConfiguration.getCarPosition();
            if (object != this.datapool.getMapConfig().getCarPosition() || bl) {
                this.datapool.getMapConfig().setCarPosition((Point)object);
                this.queuedActions.add(new Integer(2));
            }
        }
        object = aSLNavigationMapConfiguration.getScreenViewportMaximum();
        if (object != this.datapool.getMapConfig().getScreenViewportMaximum() || bl) {
            this.datapool.getMapConfig().setScreenViewportMaximum((Rect)object);
            if (object != null) {
                this.queuedActions.add(new Integer(13));
            }
        }
        if ((rect = aSLNavigationMapConfiguration.getScreenViewport()) != this.datapool.getMapConfig().getScreenViewport() || bl) {
            this.datapool.getMapConfig().setScreenViewport(rect);
            if (rect != null) {
                this.queuedActions.add(new Integer(12));
            }
        }
        if ((iNavRectangle = aSLNavigationMapConfiguration.getMapViewPortByWGS84Rectangle()) != this.datapool.getMapConfig().getMapViewPortByWGS84Rectangle() || bl) {
            this.datapool.getMapConfig().setMapViewPortByWGS84Rectangle(iNavRectangle);
            if (iNavRectangle != null) {
                this.queuedActions.add(new Integer(14));
            }
        }
        if ((point = aSLNavigationMapConfiguration.getHotPoint()) != this.datapool.getMapConfig().getHotPoint()) {
            this.datapool.getMapConfig().setHotPoint(point);
            if (point != null) {
                this.queuedActions.add(new Integer(15));
            }
        }
        return !this.queuedActions.isEmpty();
    }

    protected void transStateWork() {
        this.LOGGER.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    @Override
    public void unlockMapViewer() {
        this.LOGGER.trace("unlockMapViewer() ");
        this.datapool.setMapConfig(null);
        this.queuedActions = null;
        this.notifierDSI.viewSetInvisible();
        this.datapool.setMapSetToVisibleByClient(false);
        this.datapool.setMapExternalConfigured(false);
        this.notifierDSI.showTMCMessages(this.datapool.isRestoreShowTmc());
        this.notifierDSI.showSpeedAndFlowCongestion(this.datapool.isRestoreShowSpeedAndFlowCongestions());
        this.notifierDSI.showSpeedAndFlowFreeFlow(this.datapool.isRestoreShowSpeedAndFlowFreeFlow());
        if (this.datapool.isRestoreShowPOI()) {
            this.notifierDSI.setGeneralPoiVisibility(true);
        }
        if (this.datapool.isRestoreAutozoom()) {
            this.datapool.setAutoZoomMainMap(true);
        }
        this.datapool.setASLServiceProximityActive(false);
        this.datapool.setMapViewerLocked(false);
        boolean bl = ASLNavigationServiceMainMapFactory.INSTANCE.isAnyServiceLocked();
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("ASLServiceActive=").append(bl).log();
        }
        this.datapool.setASLServiceActive(bl);
        this.notifierDSI.viewSetVisible();
    }

    @Override
    public void zoomIn() {
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("zoomIn() - Map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (!MapViewerUtils.isMainMapModeCurrentZoomable()) {
            this.LOGGER.warn("zoomIn() - Map not zoomable. Changing the map mode to freemap!");
            this.datapool.getMapConfig().setMapMode(2);
            this.notifierDSI.setMode(this.datapool.getMapConfig().getMapMode());
        }
        int n = MapViewerUtils.calculateZoomListIndexNew(-1);
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n) / 100;
        int n3 = this.datapool.getMapLayerVisible();
        ASLNavigationServiceMainMapEvents.sendEventZoomIn();
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("zoomIn(levelInMeters=").append(n2).append(", layer=").append(n3).append(")").log();
        }
        ASLNavigationServiceMainMapEvents.sendEventMapZoomLevelUpdate(this.getClientTarget(), n2, n3);
        this.forceFullConfiguration = true;
    }

    @Override
    public void zoomOut() {
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("zoomOut() - Map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (!MapViewerUtils.isMainMapModeCurrentZoomable()) {
            this.LOGGER.warn("zoomOut() - Map not zoomable. Changing the map mode to freemap!");
            this.datapool.getMapConfig().setMapMode(2);
            this.notifierDSI.setMode(this.datapool.getMapConfig().getMapMode());
        }
        int n = MapViewerUtils.calculateZoomListIndexNew(1);
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n) / 100;
        int n3 = this.datapool.getMapLayerVisible();
        ASLNavigationServiceMainMapEvents.sendEventZoomOut();
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("zoomOut(levelInMeters=").append(n2).append(", layer=").append(n3).append(")").log();
        }
        ASLNavigationServiceMainMapEvents.sendEventMapZoomLevelUpdate(this.getClientTarget(), n2, n3);
        this.forceFullConfiguration = true;
    }

    @Override
    public void zoomTwoFingers(int n, int n2, int n3, int n4) {
        this.LOGGER.trace("zoomTwoFingers()");
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("zoomTwoFingers() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (!MapViewerUtils.isMainMapModeCurrentZoomable()) {
            this.LOGGER.error("zoomTwoFingers() - Map not zoomable, switching to FREEMAP mode!");
            this.datapool.getMapConfig().setMapMode(2);
            this.notifierDSI.setMode(this.datapool.getMapConfig().getMapMode());
        }
        ASLNavigationServiceMainMapEvents.sendEventTwoFingerZoomed(n, n2, n3, n4);
        this.forceFullConfiguration = true;
    }

    @Override
    public void zoomTwoFingersStop() {
        this.LOGGER.trace("zoomTwoFingersStop()");
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("zoomTwoFingersStop() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        ASLNavigationServiceMainMapEvents.sendEventClickInMap(0, 0, 2);
    }

    @Override
    public void setTrafficIncidents(boolean bl) {
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("setTrafficIncidents() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("setTrafficIncidents(").append(bl).append(")").log();
        }
        this.notifierDSI.showTMCMessages(bl);
        this.notifierDSI.showSpeedAndFlowCongestion(bl);
        this.notifierDSI.showSpeedAndFlowFreeFlow(bl);
    }

    @Override
    public void setMapSwitchState(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("setMapSwitchState(").append(n).append(")").log();
        }
        this.datapool.setMapSwitchState(n);
        switch (n) {
            case 3: {
                this.notifierModel.notifyMapSwitchButtonDisabled();
                ASLNavigationServiceMainMapEvents.sendEventKombiMapSwitchState(n);
                break;
            }
            case 4: {
                ASLNavigationServiceMainMapEvents.sendEventKombiMapSwitchState(n);
                this.datapool.setMainMapLocatedInKombi(false);
                this.notifierModel.notifyMainMapShownInABT();
                if (this.datapool.getMainMapContent() == 255) {
                    this.datapool.setMainMapLocatedInAbt(true);
                    this.datapool.setMapVisibilityForFPKSwitch(true);
                    this.notifierDSI.touchApproach(this.datapool.isTouchApproximated());
                    ASLNavigationMapFactory.getNavigationMapApi().sendEvKombiMapDisplayableMapShown();
                }
                if (this.datapool.isSwitchDoneAtLockMapViewer()) break;
                this.sendHMIEvent(200282112);
                break;
            }
            case 1: {
                this.notifierModel.notifyMapSwitchButtonEnabled();
                ASLNavigationServiceMainMapEvents.sendEventKombiMapSwitchState(n);
                ASLNavigationMapFactory.getNavigationMapApi().sendMapViewMapSwitchFinished();
                break;
            }
            case 5: {
                this.notifierModel.notifyMapSwitchButtonDisabled();
                ASLNavigationServiceMainMapEvents.sendEventKombiMapSwitchState(n);
                this.notifierModel.notifyMainMapNotShownInABT();
                if (ASLDisplaymanagementFactory.getDisplaymanagementApi().getDisplayableService().isDisplayableShown(3)) break;
                this.datapool.setMainMapLocatedInAbt(false);
                this.datapool.setMapVisibilityForFPKSwitch(false);
                this.notifierDSI.touchApproach(false);
                ASLNavigationMapFactory.getNavigationMapApi().sendEvKombiMapDisplayableMapHidden();
                break;
            }
            case 2: {
                this.notifierModel.notifyMapSwitchButtonEnabled();
                this.datapool.setMainMapLocatedInKombi(true);
                ASLNavigationServiceMainMapEvents.sendEventKombiMapSwitchState(n);
                ASLNavigationMapFactory.getNavigationMapApi().sendMapViewMapSwitchFinished();
                break;
            }
        }
    }

    @Override
    public int getMapSwitchState() {
        return this.datapool.getMapSwitchState();
    }

    @Override
    public boolean getMapVisibilityForFPKSwitch() {
        return this.datapool.getMapVisibilityForFPKSwitch();
    }

    @Override
    public void configureVicsEventNoticeMap(long l) {
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("configureVicsEventNoticeMap() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("configureVicsEventNoticeMap(").append(l).append(")").log();
        }
        this.notifierDSI.viewFreeze();
        this.notifierDSI.showTMCMessages(true);
        this.notifierDSI.ensureTMCVisibility(l);
        this.notifierDSI.goToTMCMessage(l);
        this.notifierDSI.viewUnfreeze();
    }

    @Override
    public void ensureTMCVisibility(long l) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("ensureTMCVisibility( id = ").append(l).append(" )").log();
        }
        this.notifierDSI.ensureTMCVisibility(l);
    }

    @Override
    public void setGeneralPoiVisibility(boolean bl) {
        if (!this.datapool.isMapViewerLocked()) {
            this.LOGGER.error("setGeneralPoiVisibility() - map Controller not locked!");
            ASLNavigationServiceMainMapEvents.sendEventServiceError(this.clientTarget, 6);
            return;
        }
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("setGeneralPoiVisibility(").append(bl).append(")").log();
        }
        this.notifierDSI.setGeneralPoiVisibility(bl);
    }

    @Override
    public void releaseView() {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("releaseView() - fire EV_REINIT_MAPVIEW").log();
        }
        this.sendHMIEvent(200282112);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(139) && this.datapool.isSwitchDoneAtLockMapViewer()) {
            this.datapool.setSwitchDoneAtLockMapViewer(false);
            ASLNavigationMapFactory.getNavigationMapApi().sendMapViewMapTriggerSwitch();
            this.notifierDSI.viewFreeze();
            this.notifierDSI.setViewType(this.datapool.getRestoreViewType());
            this.notifierDSI.setOrientation(this.datapool.getRestoreOrientation());
            this.notifierDSI.setZoomLevel(this.datapool.getRestoreZoom());
            this.notifierDSI.viewUnfreeze();
        }
        this.datapool.setMapExternalConfigured(false);
        this.notifierDSI.configureFlags(1, null);
    }

    @Override
    public int getICMapServiceState() {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("getICMapServiceState()").log();
        }
        return this.datapool.getICMapServiceState();
    }

    @Override
    public boolean isMapSwitchFunctionAvailableInKombi() {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("isMapSwitchFunctionAvailableInKombi()").log();
        }
        return this.datapool.isMapSwitchFunctionAvailableInKombi();
    }

    @Override
    public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("setMapSwitchFunctionAvailableInKombi(").append(bl).append(" )").log();
        }
        this.datapool.setMapSwitchFunctionAvailableInKombi(bl);
        if (bl) {
            this.notifierModel.notifyMapSwitchButtonEnabled();
        } else if (!bl && !this.datapool.isMapLocatedInKombi()) {
            this.notifierModel.notifyMapSwitchButtonDisabled();
        }
    }

    @Override
    public int getMainMapZoomLevel() {
        int n = this.datapool.getZoomLevelMainMapBackup();
        int n2 = this.datapool.getMainMapZoomLevel();
        if (n != 0) {
            n2 = n;
        }
        int n3 = MapViewerUtils.calculateZoomIndexByZoomLevel(n2);
        int n4 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n3);
        return n4 / 100;
    }

    @Override
    public void viewSetVisible() {
        this.notifierDSI.viewSetVisible();
        this.datapool.setMapSetToVisibleByClient(true);
        this.LOGGER.trace("Client sets view to visible, set touch approach to false to avoid big POI icons.");
        this.notifierDSI.touchApproach(false);
    }

    @Override
    public void viewSetInvisible() {
        this.datapool.setMapSetToVisibleByClient(false);
        if (this.datapool.getMainMapContent() == 255) {
            this.notifierDSI.viewSetInvisible();
        } else {
            this.LOGGER.warn("Navigation context shows a map, viewSetInvisible will be ignored!");
        }
    }

    @Override
    public void deactivateOverviewZoom() {
        this.notifierModel.notifyOverviewZoomOff();
    }

    @Override
    public int getMainMapPerspective() {
        return this.datapool.getMainMapPerspective();
    }

    @Override
    public int getHeadingValue() {
        return this.datapool.getHeadingValue();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = ASLNavigationServiceMainMapTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.LOGGER.isTraceEnabled()) {
                this.LOGGER.trace("no restart neccessary");
            }
        } else if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.trace("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    @Override
    public boolean isMapTemporarilyInABT() {
        return this.datapool.isMapTemporarilyInABT();
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

