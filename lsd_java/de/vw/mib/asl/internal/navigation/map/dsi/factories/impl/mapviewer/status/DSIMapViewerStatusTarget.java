/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.diagnosis.config.DashboardDisplayConfig;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusTarget$1;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerControlListener;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerStatusTarget
extends AbstractResettableTarget {
    private static final int[] ATTRIBUTES_MAPVIEWER = new int[]{1, 10};
    private static final Rect SCREEN_VIEW_PORT_MAP_IN_MAP = new Rect(0, 0, 296, 323);
    private static final Rect SCREEN_VIEW_PORT_MAP_IN_MAP_9_2 = new Rect(0, 0, 396, 444);
    private static final Rect SCREEN_VIEW_PORT_MAP_KOMBI = new Rect(0, 0, 800, 480);
    private static final Rect SCREEN_VIEW_PORT_MAP_KOMBI_CHN = new Rect(0, 0, 800, 298);
    private static final Rect SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_STD = new Rect(0, 0, 1010, 480);
    private static final Rect SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH = new Rect(0, 0, 1010, 376);
    private static final Rect SCREEN_VIEW_PORT_MAP_MAIN = new Rect(0, 0, 800, 480);
    private static final Rect SCREEN_VIEW_PORT_MAP_MAIN_9_2 = new Rect(0, 0, 1280, 640);
    private static final Rect SCREEN_VIEW_PORT_MAP_MAIN_PHAETON = new Rect(0, 0, 1680, 760);
    private static final String VARIANT = ServiceManager.configManagerDiag.getPureVariant();
    protected final DSIMapViewerStatusDataPool datapool;
    private DSIMapViewerControl dsiMapViewer;
    protected final IExtLogger logger;
    private final DSIMapViewerStatusListener mapViewerStatusListener;
    private final DSIProxy proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;

    public DSIMapViewerStatusTarget(GenericEvents genericEvents, int n, String string, int n2, MapDataPool mapDataPool, DSIMapViewerStatusListener dSIMapViewerStatusListener) {
        super(genericEvents, n, string);
        StringBuilder stringBuilder = new StringBuilder("[DSIMapViewerStatusTarget - InstanceId=");
        stringBuilder.append(n2);
        stringBuilder.append("]");
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, stringBuilder.toString());
        this.mapViewerStatusListener = dSIMapViewerStatusListener;
        this.datapool = new DSIMapViewerStatusDataPool();
        this.datapool.setServiceInstanceId(n2);
        this.datapool.setMapDataPool(mapDataPool);
        this.initASL();
        this.initServiceStateListener();
    }

    public void dsiMapViewerControlUpdateReady(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateReady(ready=").append(bl).append(")").log();
        }
        if (bl && !this.datapool.isUpdateReadyReceived()) {
            this.logger.info("dsiMapViewerControlUpdateReady( ready=true ) - the MapViewer is ready for the first time");
            this.datapool.setUpdateReadyReceived(true);
            int n2 = this.datapool.getServiceInstanceId();
            if (n2 == 1) {
                this.logger.trace("we set updateZoomListReceived to true on Google Earth, because the MapViewer didn't send this update and we don't need a zoomList for Google Earth, we expect the same zoomList as on the onboard map.");
                this.datapool.setUpdateZoomListReceived(true);
            }
            this.mapViewerReady();
        } else if (bl && this.datapool.isUpdateReadyReceived()) {
            this.logger.error("dsiMapViewerControlUpdateReady( ready=true ) - was send twice, seconde call will be ignored");
        } else if (!bl) {
            this.logger.info("dsiMapViewerControlUpdateReady( ready=false ) - the MapViewer is not ready anymore");
            this.datapool.setMapViewerCompletlyReady(false);
            this.datapool.setUpdateReadyReceived(false);
            this.mapViewerNotReady();
        }
    }

    public HsmState dsiMapViewerControlUpdateZoomList(float[] fArray, int n) {
        if (n == 2) {
            this.logger.warn("dsiMapViewerControlUpdateZoomList() validFlag == ATTRVALIDFLAG_INVALID");
            return null;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomList(zoomList[], length=").append(fArray.length).append(")").log();
        }
        this.datapool.setUpdateZoomListReceived(true);
        int n2 = this.datapool.getServiceInstanceId();
        if (n2 == 1 && n2 != DSIMapViewerControlFactoryVW.getMapViewerInstanceIdCurrentMain()) {
            this.mapViewerReady();
            return null;
        }
        MapDataPool mapDataPool = this.datapool.getMapDataPool();
        mapDataPool.setZoomList(fArray);
        mapDataPool.setZoomListIndexMax(fArray.length - 1);
        mapDataPool.setZoomListIndexMin(0);
        if (n2 == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-655355904, mapDataPool.getZoomListIndexMax());
            if (fArray[0] < -2137647029) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.makeTrace().append("Entering map covered area: Enable google earth button again").log();
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(3702, true);
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.makeTrace().append("Leaving map covered area: Disable google earth button to prevent map viewer switch").log();
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(3702, false);
            }
        }
        this.mapViewerReady();
        return null;
    }

    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        this.logger.trace("ehSetCategoryVisibility()");
        this.dsiMapViewer.ehSetCategoryVisibility(n, nArray, blArray);
    }

    public void ehSetCategoryVisibilityToDefault(int n) {
        this.logger.trace("ehSetCategoryVisibilityToDefault()");
        this.dsiMapViewer.ehSetCategoryVisibilityToDefault(n);
    }

    public void setGeneralPoiVisibility(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setGeneralPoiVisibility(").append(bl).append(")").log();
        }
        this.dsiMapViewer.setGeneralPoiVisibility(bl);
    }

    public void setBrandIconStyle(int[] nArray, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setBrandIconStyle(").append(nArray).append(", ").append(n).append(")").log();
        }
        this.dsiMapViewer.setBrandIconStyle(nArray, n);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 845427968) {
            this.mapViewerReady3UpdateAdaptionAPI(eventGeneric);
        }
    }

    private void initASL() {
        this.logger.trace("gotEventPrepareOn()");
        int n = this.datapool.getServiceInstanceId();
        if (n == 0) {
            this.initASLMapViewer0();
        } else if (n == 1) {
            this.initASLMapViewer1();
        } else if (n == 2) {
            this.initASLMapViewer2();
        } else if (n == 3) {
            this.initASLMapViewer3();
        }
    }

    private void initASLMapViewer0() {
        this.logger.trace("initASLMapVierwer0()");
        ServiceManager.eventMain.getServiceRegister().registerService(107230464, this.getTargetId(), 107230464, true);
        ServiceManager.eventMain.getServiceRegister().registerService(124007680, this.getTargetId(), 124007680, true);
    }

    private void initASLMapViewer1() {
        this.logger.trace("initASLMapViewer1()");
        ServiceManager.eventMain.getServiceRegister().registerService(174339328, this.getTargetId(), 174339328, true);
        ServiceManager.eventMain.getServiceRegister().registerService(191116544, this.getTargetId(), 191116544, true);
    }

    private void initASLMapViewer2() {
        this.logger.trace("initASLMapViewer2()");
        ServiceManager.eventMain.getServiceRegister().registerService(140784896, this.getTargetId(), 140784896, true);
        ServiceManager.eventMain.getServiceRegister().registerService(157562112, this.getTargetId(), 157562112, true);
    }

    private void initASLMapViewer3() {
        this.logger.trace("initASLMapViewer3()");
        ServiceManager.eventMain.getServiceRegister().registerService(73676032, this.getTargetId(), 73676032, true);
        ServiceManager.eventMain.getServiceRegister().registerService(90453248, this.getTargetId(), 90453248, true);
    }

    private void initServiceStateListener() {
        DSIMapViewerStatusTarget$1 dSIMapViewerStatusTarget$1 = new DSIMapViewerStatusTarget$1(this);
        this.proxy.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, this.datapool.getServiceInstanceId(), dSIMapViewerStatusTarget$1);
    }

    protected void mapViewerNotReady() {
        this.logger.trace("mapViewerNotReady()");
        this.mapViewerStatusListener.mapViewerNotReady();
    }

    protected void mapViewerReady() {
        if (!this.datapool.isUpdateReadyReceived()) {
            this.logger.trace("mapViewerReady() - waiting for updateReady( true )");
            return;
        }
        if (!this.datapool.isUpdateZoomListReceived()) {
            this.logger.trace("mapViewerReady() - waiting for updateZoomList( float[] )");
            return;
        }
        if (this.datapool.isMapViewerCompletlyReady()) {
            this.logger.trace("The MapViewer is already in state 'ready', ignoring southside updates of updateReady( true ) or updateZoomList( float[] )");
            return;
        }
        this.logger.trace("mapViewerReady()");
        this.datapool.setMapViewerCompletlyReady(true);
        int n = this.datapool.getServiceInstanceId();
        switch (n) {
            case 0: {
                if (!this.datapool.isMapViewer3ResolutionReceived()) {
                    ServiceManager.adaptionApi.requestConfigManagerPersLoadDashboardDisplayConfig(this.getTargetId(), 845427968);
                }
                this.mapViewerReady0();
                break;
            }
            case 1: {
                this.mapViewerReady1();
                break;
            }
            case 2: {
                this.mapViewerReady2();
                break;
            }
            case 3: {
                this.mapViewerReady3();
                break;
            }
            default: {
                this.logger.makeError().append("mapViewerReady() - instanceId '").append(n).append("' is unknown, the mapviewers screenViewport won't be set.").log();
            }
        }
        if (n != 3) {
            this.dsiMapViewer.setMetricSystem(2);
            this.dsiMapViewer.setRouteVisibility(this.datapool.getMapDataPool().isRouteVisible());
            this.mapViewerStatusListener.mapViewerReady();
        }
    }

    private void mapViewerReady0() {
        this.logger.trace("mapViewerReady0()");
        if (VARIANT.startsWith("PREMIUM")) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN_PHAETON);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN_PHAETON);
        } else if (VARIANT.startsWith("HIGH2")) {
            if (VARIANT.startsWith("HIGH2GP") || VARIANT.startsWith("HIGH2MLB_CHN")) {
                this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN_9_2);
                this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN_9_2);
            } else if (VARIANT.startsWith("HIGH2_")) {
                this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI);
                this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI);
            } else {
                this.logger.error(new StringBuffer().append("mapViewerReady0(): Unknown variant name: ").append(VARIANT).toString());
            }
        } else if (MapViewerDatapoolShared.getInstance().isMapSwitchFunctionAvailableInKombi()) {
            if (this.datapool.isMapViewer3ResolutionReceived()) {
                int n = this.datapool.getMapViewer3Resolution();
                if (2 == n) {
                    this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_STD);
                    if (PersistedMapSetup.getInstance().isMapLocatedInABT() && !PersistedMapSetup.getInstance().isMapLocatedInKombi()) {
                        this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN);
                    } else if (!PersistedMapSetup.getInstance().isMapLocatedInABT() && PersistedMapSetup.getInstance().isMapLocatedInKombi()) {
                        this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH);
                    } else {
                        this.logger.error("mapViewerReady0(): Map not located on ABT nor Kombi");
                    }
                } else {
                    this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN);
                    this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN);
                }
            } else {
                this.logger.error("mapViewerReady0(): Resolution of FPK not avaliable");
            }
        } else {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN);
        }
    }

    private void mapViewerReady1() {
        this.logger.trace("mapViewerReady1()");
        if (VARIANT.startsWith("PREMIUM")) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN_PHAETON);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN_PHAETON);
        } else if (VARIANT.startsWith("HIGH2GP") || VARIANT.startsWith("HIGH2MLB_CHN")) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN_9_2);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN_9_2);
        } else {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_MAIN);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN);
        }
    }

    private void mapViewerReady2() {
        this.logger.trace("mapViewerReady2()");
        if (VARIANT.startsWith("HIGH2GP")) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_IN_MAP_9_2);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_IN_MAP_9_2);
        } else {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_IN_MAP);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_IN_MAP);
        }
    }

    private void mapViewerReady3() {
        this.logger.trace("mapViewerReady3() - requesting adaptionapi for the resolution");
        if (this.datapool.isMapViewer3ResolutionReceived()) {
            this.mapViewerReady3Configure();
            return;
        }
        ServiceManager.adaptionApi.requestConfigManagerPersLoadDashboardDisplayConfig(this.getTargetId(), 845427968);
    }

    private void mapViewerReady3Configure() {
        this.logger.trace("mapViewerReady3Configure");
        int n = this.datapool.getMapViewer3Resolution();
        if (2 == n) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH);
        } else if (1 == n) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI_CHN);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI_CHN);
        } else if (0 == n) {
            this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI);
            this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI);
        } else {
            this.logger.error(new StringBuffer().append("mapViewerReady3UpdateAdaptionAPI: Wrong FPK coding value: ").append(n).toString());
        }
        this.dsiMapViewer.setMetricSystem(2);
        this.dsiMapViewer.setFrameRateMode(5);
        this.mapViewerStatusListener.mapViewerReady();
    }

    private void mapViewerReady3UpdateAdaptionAPI(EventGeneric eventGeneric) {
        this.logger.trace("initASLMapViewer3UpdateAdaptionAPI()");
        if (this.datapool.isMapViewer3ResolutionReceived()) {
            return;
        }
        int n = eventGeneric.getInt(2);
        long l = eventGeneric.getLong(3);
        if (n == -536825343 && l == 0) {
            DashboardDisplayConfig dashboardDisplayConfig = (DashboardDisplayConfig)eventGeneric.getObject(1);
            int n2 = dashboardDisplayConfig.getValue(172);
            this.datapool.setMapViewer3Resolution(n2);
            this.datapool.setMapViewer3ResolutionReceived(true);
            this.logger.makeInfo().append("the adaption api value for the resolution of MapViewer 3 is: ").append(n2).log();
            if (3 == this.datapool.getServiceInstanceId()) {
                if (2 == n2) {
                    this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH);
                    this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH);
                } else if (1 == n2) {
                    this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI_CHN);
                    this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI_CHN);
                } else if (0 == n2) {
                    this.dsiMapViewer.viewSetScreenViewportMaximum(SCREEN_VIEW_PORT_MAP_KOMBI);
                    this.dsiMapViewer.viewSetScreenViewport(SCREEN_VIEW_PORT_MAP_KOMBI);
                } else {
                    this.logger.error(new StringBuffer().append("mapViewerReady3UpdateAdaptionAPI: Wrong FPK coding value: ").append(n2).toString());
                }
                this.dsiMapViewer.setMetricSystem(2);
                this.dsiMapViewer.setFrameRateMode(5);
                this.mapViewerStatusListener.mapViewerReady();
            }
        }
    }

    protected void startMapViewer() {
        this.logger.trace("startMapViewer()");
        this.datapool.setServiceAvailable(true);
        int n = this.datapool.getServiceInstanceId();
        this.dsiMapViewer = (DSIMapViewerControl)this.proxy.getService(this, class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl, n);
        DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener);
        this.proxy.addResponseListener(this, class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener, n, dSIMapViewerControlListener);
        this.dsiMapViewer.setNotification(ATTRIBUTES_MAPVIEWER, (DSIListener)dSIMapViewerControlListener);
    }

    protected void stopMapViewer() {
        this.logger.trace("stopMapViewer()");
        this.datapool.setMapViewerCompletlyReady(false);
        this.datapool.setServiceAvailable(false);
        this.datapool.setUpdateReadyReceived(false);
        this.mapViewerNotReady();
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), this.datapool.getServiceInstanceId())) {
            if (this.datapool.isServiceAvailable()) {
                this.logger.makeError().append("the service 'DSIMapViewerControl' with instance id '").append(this.datapool.getServiceInstanceId()).append("' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.").log();
                return;
            }
            this.logger.info("registered");
            this.startMapViewer();
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

