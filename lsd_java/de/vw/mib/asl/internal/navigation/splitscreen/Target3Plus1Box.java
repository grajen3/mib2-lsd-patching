/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.IOverlayData;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.splitscreen.ASLManeuverViewElement;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.map.ss.transformer.ManeuverViewDataCollector;
import de.vw.mib.asl.internal.navigation.splitscreen.OverlayData;
import de.vw.mib.asl.internal.navigation.splitscreen.Target3Plus1Box$1;
import de.vw.mib.collections.SortedList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSManeuverExitViewDataCollector;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.TmcMessage;

public class Target3Plus1Box
extends AbstractResettableAslTarget
implements CacheClient,
DSIServiceStateListener {
    public static final int EV_ASL_INT_UPDATE3PLUS1;
    public static final int EV_ASL_INT_UPDATE3PLUS1_INTERVAL_MS;
    public static final int EV_ASL_INT_MAP_MANEUVERVIEW_ON;
    public static final int EV_ASL_INT_MAP_MANEUVERVIEW_OFF;
    protected DSINavigation navigationService;
    private DSIListener dsiNavigationListener;
    protected DSITmcOnRoute tmcOnRouteService;
    protected DSIListener tmcOnRouteServiceListener;
    protected DSIMapViewerManeuverView mapViewerManeuverView;
    protected DSIListener mapViewerManeuverViewListener;
    private boolean isServiceStateListenerAdded = false;
    private static final int[] OBSERVER_DSINAV;
    private static final int[] OBSERVER_DSIMAP;
    private static final int[] OBSERVER_DSITMC;
    private static final int[] OBSERVERS;
    private boolean isRgActive;
    static final int MAX_LIST_SIZE;
    static final int MAX_POI_ICONS;
    private BapTurnToInfo[] bapTurnList = new BapTurnToInfo[0];
    private NavigationMapSSManeuverExitViewDataCollector exitViewCollector = new NavigationMapSSManeuverExitViewDataCollector();
    private boolean isExitView = false;
    private SortedList maneuverElementList = new SortedList();
    private Route rgCurrentRoute;
    private boolean isTimerActive;
    private boolean isManeuverView;
    private static IExtLogger LOGGER;
    private final int NAV_LOCATION_SELCRIT_DEST_MEM_ENTRY_ON_TARGET_PCC;
    private final int NAV_LOCATION_SELCRIT_DEST_MEM_ENTRY_ON_TARGET_ESO_AND_DELPHI;
    private final int NAV_LOCATION_SELCRIT_POI_NAME_ON_TARGET_ESO;
    private final int NAV_LOCATION_SELCRIT_POI_NAME_ON_TARGET_PCC;
    private final int NAV_LOCATION_SELCRIT_POI_NAME_ON_TARGET_DELPHI;
    ICMapListener icl = new Target3Plus1Box$1(this);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public Target3Plus1Box(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.NAV_LOCATION_SELCRIT_DEST_MEM_ENTRY_ON_TARGET_PCC = 768;
        this.NAV_LOCATION_SELCRIT_DEST_MEM_ENTRY_ON_TARGET_ESO_AND_DELPHI = 768;
        this.NAV_LOCATION_SELCRIT_POI_NAME_ON_TARGET_ESO = 4097;
        this.NAV_LOCATION_SELCRIT_POI_NAME_ON_TARGET_PCC = 512;
        this.NAV_LOCATION_SELCRIT_POI_NAME_ON_TARGET_DELPHI = 16641;
    }

    public static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[Target3Plus1Box] ");
        }
        return LOGGER;
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    private void traceList(Object[] objectArray, String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass().getName());
            logMessage.append(string);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                logMessage.append(objectArray[i2]);
            }
            logMessage.log();
        }
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
            this.initDsiNavigation();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[59]) {
            this.initDsiMapViewer();
        } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[142]) {
            this.initDsiTmcOnRoute();
        }
        if (this.mapViewerManeuverView != null && this.tmcOnRouteService != null && this.navigationService != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        Target3Plus1Box.getLogger().trace("DSI_NAVIGATION service registered");
        this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target3Plus1Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Target3Plus1Box.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Target3Plus1Box.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.navigationService.setNotification(OBSERVER_DSINAV, this.dsiNavigationListener);
    }

    private void initDsiMapViewer() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        Target3Plus1Box.getLogger().trace("DSI_MAP_VIEWER_MANEUVER_VIEW service registered");
        this.mapViewerManeuverView = (DSIMapViewerManeuverView)dSIProxy.getService(this, class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target3Plus1Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView);
        this.mapViewerManeuverViewListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = Target3Plus1Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = Target3Plus1Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener, this.mapViewerManeuverViewListener);
        this.mapViewerManeuverView.setNotification(OBSERVER_DSIMAP, this.mapViewerManeuverViewListener);
    }

    private void initDsiTmcOnRoute() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        Target3Plus1Box.getLogger().trace("DSI_TMC_ON_ROUTE service registered");
        this.tmcOnRouteService = (DSITmcOnRoute)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target3Plus1Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
        this.tmcOnRouteServiceListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = Target3Plus1Box.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = Target3Plus1Box.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener, this.tmcOnRouteServiceListener);
        this.tmcOnRouteService.setNotification(OBSERVER_DSITMC, this.tmcOnRouteServiceListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("Target3Plus1Box tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            String string2 = string.intern();
            if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[59]) {
                this.unregisterDsiMapViewerManeuverView(string, dSIProxy);
            } else if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[142]) {
                this.unregisterDsiTmcOnRoute(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiTmcOnRoute(String string, DSIProxy dSIProxy) {
        if (this.tmcOnRouteServiceListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = Target3Plus1Box.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener, this.tmcOnRouteServiceListener);
            this.tmcOnRouteServiceListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiMapViewerManeuverView(String string, DSIProxy dSIProxy) {
        if (this.mapViewerManeuverViewListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = Target3Plus1Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener, this.mapViewerManeuverViewListener);
            this.mapViewerManeuverViewListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Target3Plus1Box.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("Target3Plus1Box unregistered from ").append(string).log();
        }
    }

    public void initDSI() {
        if (!this.isServiceStateListenerAdded) {
            this.isServiceStateListenerAdded = true;
            ServiceManager.dsiServiceLocator.addServiceStateListener(this);
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceState("POWER_ON");
                this.initDSI();
                this.addObservers(OBSERVERS);
                this.isTimerActive = false;
                this.isManeuverView = ASLNavigationMapFactory.getNavigationMapApi().getSplitScreenContentGuidance() == 5 && ASLNavigationMapFactory.getNavigationMapApi().isSplitScreenGuidance();
                break;
            }
            case 107: {
                this.traceState("POWER_OFF");
                break;
            }
            case 3499057: {
                this.traceState("EV_SPLITSCREEN_MANEUVERVIEW_VISIBLE");
                this.isManeuverView = eventGeneric.getBoolean(0);
                if (this.isManeuverView) {
                    if (!this.isRgActive) break;
                    this.startTimer();
                    break;
                }
                if (!this.isTimerActive) break;
                this.stopTimer();
                break;
            }
            case 100101: {
                this.traceState("EV_ASL_INT_MAP_MANEUVERVIEW_ON");
                this.isManeuverView = true;
                if (!this.isRgActive) break;
                this.startTimer();
                break;
            }
            case 100102: {
                this.traceState("EV_ASL_INT_MAP_MANEUVERVIEW_OFF");
                this.isManeuverView = false;
                if (!this.isTimerActive) break;
                this.stopTimer();
                break;
            }
            case 1074841913: {
                this.traceState("SELECT_POI_OR_TMC_ELEMENT_FROM_RML");
                this.handleSelectListElement(eventGeneric);
                break;
            }
            case 100666: {
                this.traceState("EV_ASL_INT_UPDATE3PLUS1");
                this.updateModel();
                break;
            }
        }
    }

    private void startTimer() {
        this.triggerMe(982057216);
        this.startTimer(982057216, (long)0, true);
        this.isTimerActive = true;
    }

    private void stopTimer() {
    }

    public void dsiMapViewerManeuverViewUpdateManoeuvreViewsAvailable(short[] sArray, int n) {
        this.traceState("dsiMapViewerManeuverViewUpdateManoeuvreViewsAvailable");
        if (sArray != null && sArray.length > 0 && n == 1) {
            if (sArray[0] == 3) {
                this.mapViewerManeuverView.selectManoeuvreView(3, true);
            } else if (sArray[0] == 4) {
                this.mapViewerManeuverView.selectManoeuvreView(4, true);
            } else {
                this.mapViewerManeuverView.hideManoeuvreView();
                ServiceManager.aslPropertyManager.valueChangedInteger(849, 0);
                this.isExitView = false;
                this.updateOverlayContent(1);
                this.updateOverlayCount(1);
                this.updateOverlayIndex(0);
            }
        }
    }

    public void dsiMapViewerManeuverViewUpdateManoeuvreViewActive(int n, int n2) {
        this.traceState("dsiMapViewerManeuverViewUpdateManoeuvreViewActive");
        if (n2 == 1) {
            this.selectDisplay(n);
        }
    }

    private void selectDisplay(int n) {
        this.traceState("selectDisplay");
        switch (n) {
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(849, 2);
                this.isExitView = true;
                this.updateOverlayContent(2);
                this.updateOverlayCount(1);
                this.updateOverlayIndex(0);
                this.updateExitViewCollector();
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(849, 1);
                this.isExitView = true;
                this.updateOverlayContent(3);
                this.updateOverlayCount(1);
                this.updateOverlayIndex(0);
                this.updateExitViewCollector();
                break;
            }
            case 255: {
                ServiceManager.aslPropertyManager.valueChangedInteger(849, 0);
                this.isExitView = false;
                this.updateOverlayContent(1);
                this.updateOverlayCount(1);
                this.updateOverlayIndex(0);
                break;
            }
        }
    }

    private void updateExitViewCollector() {
        ManeuverViewDataCollector maneuverViewDataCollector = this.getFirstTurnListElement();
        if (maneuverViewDataCollector != null) {
            if (this.isTraceEnabled()) {
                this.trace().append(super.getClass().getName()).append(" Updating Exit View Collector.").log();
            }
            this.exitViewCollector = new NavigationMapSSManeuverExitViewDataCollector();
            this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_dtm = maneuverViewDataCollector.dtm;
            this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_rttm = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().convertRTTHM2RTTM(maneuverViewDataCollector.rtth, maneuverViewDataCollector.rttm);
            this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street = maneuverViewDataCollector.name;
            this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_maneuver_main_element = maneuverViewDataCollector.mainElement;
            this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_maneuver_direction = maneuverViewDataCollector.direction;
            this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_number = "";
            if (this.bapTurnList != null && this.bapTurnList.length > 0) {
                this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_sign_post = maneuverViewDataCollector.signPost;
            }
            if (this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_sign_post == null) {
                this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_sign_post = "";
            }
            ListManager.getGenericASLList(863).updateList(new NavigationMapSSManeuverExitViewDataCollector[]{this.exitViewCollector});
            OverlayData overlayData = new OverlayData();
            overlayData.setDistanceToManeuver(this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_dtm);
            overlayData.setExitNumber(this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_number);
            overlayData.setExitNumberVisibility(this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_number != null || !this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_number.equals(""));
            overlayData.setName(this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street);
            overlayData.setSignPostInfo(this.exitViewCollector.navigation_map_ss_maneuver_exit_view_data_street_sign_post);
            this.updateOverlayData(overlayData);
        } else {
            if (this.isTraceEnabled()) {
                this.trace().append(super.getClass().getName()).append(" Updating Exit View Collector called but no Turnlist element available..").log();
            }
            OverlayData overlayData = new OverlayData();
            this.updateOverlayData(overlayData);
        }
    }

    void updateOverlayData(IOverlayData iOverlayData) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1086049024);
        eventGeneric.setObject(0, iOverlayData);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void updateOverlayIndex(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1035717376);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void updateOverlayContent(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1069271808);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void updateOverlayCount(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1052494592);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private boolean isManeuverView() {
        try {
            return ASLNavigationMapFactory.getNavigationMapApi().getSplitScreenContentGuidance() == 5 && (ASLNavigationMapFactory.getNavigationMapApi().isSplitScreenGuidance() || ASLNavigationFactory.getNavigationApi().getICMapService(this.icl).getMapSwitchState() == 2);
        }
        catch (NavigationServiceException navigationServiceException) {
            return false;
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.isRgActive = bl;
        if (!this.isRgActive) {
            if (this.isTimerActive) {
                this.stopTimer();
            }
            this.navigationService.enableRgPoiInfo(false);
            this.maneuverElementList = new SortedList();
            ListManager.getGenericASLList(862).updateList(new ManeuverViewDataCollector[0]);
        } else {
            if (this.isManeuverView) {
                this.startTimer();
            }
            this.navigationService.enableRgPoiInfo(true);
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.traceState("dsiNavigationUpdateRgInfoForNextDestination()");
        this.updateTimeAndDistance();
        if (this.isExitView) {
            this.updateExitViewCollector();
        }
    }

    public void dsiNavigationUpdateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        this.traceState("dsiNavigationUpdateBapTurnToInfo()");
        this.bapTurnList = bapTurnToInfoArray;
    }

    public void dsiNavigationUpdateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        this.traceState("dsiNavigationUpdateRgTurnList()");
        this.maneuverElementList = this.getCleanList(0);
        if (turnListElementArray != null) {
            for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
                if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(turnListElementArray[i2])) continue;
                this.maneuverElementList.add(this.createManeuverListElement(turnListElementArray[i2]));
            }
            if (turnListElementArray.length >= 4) {
                this.stopTimer();
                this.startTimer();
            }
        }
    }

    public void dsiNavigationUpdateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        this.traceState("dsiNavigationUpdateRgPoiInfo()");
        this.maneuverElementList = this.getCleanList(1);
        if (navPoiInfoArray != null) {
            for (int i2 = 0; i2 < navPoiInfoArray.length; ++i2) {
                ManeuverViewDataCollector maneuverViewDataCollector;
                if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(navPoiInfoArray[i2]) || this.maneuverElementList.contains(maneuverViewDataCollector = this.createManeuverListElement(navPoiInfoArray[i2]))) continue;
                this.maneuverElementList.add(maneuverViewDataCollector);
            }
        }
    }

    public void dsiTmcOnRouteUpdateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        this.traceState("dsiTmcOnRouteUpdateTmcMessagesAhead()");
        this.maneuverElementList = this.getCleanList(2);
        if (tmcMessageArray != null) {
            for (int i2 = 0; i2 < tmcMessageArray.length; ++i2) {
                if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(tmcMessageArray[i2])) continue;
                this.maneuverElementList.add(this.createManeuverListElement(tmcMessageArray[i2]));
            }
        }
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.traceState("dsiNavigationUpdateRgCurrentRoute()");
        this.rgCurrentRoute = route;
    }

    private SortedList getCleanList(int n) {
        SortedList sortedList = new SortedList();
        Iterator iterator = this.maneuverElementList.iterator();
        while (iterator.hasNext()) {
            ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)iterator.next();
            if (maneuverViewDataCollector.type == n) continue;
            sortedList.add(maneuverViewDataCollector);
        }
        return sortedList;
    }

    private ManeuverViewDataCollector[] createManeuverElementListForModel() {
        ManeuverViewDataCollector maneuverViewDataCollector;
        ManeuverViewDataCollector[] maneuverViewDataCollectorArray = this.maneuverElementList.size() < 3 ? new ManeuverViewDataCollector[this.maneuverElementList.size()] : new ManeuverViewDataCollector[3];
        boolean bl = false;
        int n = maneuverViewDataCollectorArray.length - 1;
        for (int i2 = 0; i2 < maneuverViewDataCollectorArray.length; ++i2) {
            maneuverViewDataCollectorArray[i2] = (ManeuverViewDataCollector)this.maneuverElementList.get(n - i2);
            if (maneuverViewDataCollectorArray[i2].type != 0) continue;
            bl = true;
        }
        if (!bl && (maneuverViewDataCollector = this.getFirstTurnListElement()) != null) {
            maneuverViewDataCollectorArray[0] = maneuverViewDataCollector;
        }
        return maneuverViewDataCollectorArray;
    }

    private ManeuverViewDataCollector getFirstTurnListElement() {
        ManeuverViewDataCollector maneuverViewDataCollector = null;
        Iterator iterator = this.maneuverElementList.iterator();
        while (iterator.hasNext()) {
            ManeuverViewDataCollector maneuverViewDataCollector2 = (ManeuverViewDataCollector)iterator.next();
            if (maneuverViewDataCollector2.type != 0) continue;
            maneuverViewDataCollector = maneuverViewDataCollector2;
            break;
        }
        return maneuverViewDataCollector;
    }

    private void updateModel() {
        Object[] objectArray = this.createManeuverElementListForModel();
        ListManager.getGenericASLList(862).updateList(objectArray);
        this.traceList(this.maneuverElementList.toArray(new ManeuverViewDataCollector[0]), " updateModel(): Complete list");
        this.traceList(objectArray, " updateModel(): List scope for model");
        this.updateInternalAPI();
    }

    private void updateInternalAPI() {
        if (this.maneuverElementList != null) {
            ManeuverViewDataCollector[] maneuverViewDataCollectorArray = (ManeuverViewDataCollector[])this.maneuverElementList.toArray(new ManeuverViewDataCollector[0]);
            ASLManeuverViewElement[] aSLManeuverViewElementArray = new ASLManeuverViewElement[maneuverViewDataCollectorArray.length];
            for (int i2 = 0; i2 < aSLManeuverViewElementArray.length; ++i2) {
                aSLManeuverViewElementArray[i2] = new ASLManeuverViewElement();
                aSLManeuverViewElementArray[i2].destinationIndex = maneuverViewDataCollectorArray[i2].destinationIndex;
                aSLManeuverViewElementArray[i2].direction = maneuverViewDataCollectorArray[i2].direction;
                aSLManeuverViewElementArray[i2].distanceToNextDestination = maneuverViewDataCollectorArray[i2].distanceToNextDestination;
                aSLManeuverViewElementArray[i2].dtm = maneuverViewDataCollectorArray[i2].dtm;
                aSLManeuverViewElementArray[i2].mainElement = maneuverViewDataCollectorArray[i2].mainElement;
                aSLManeuverViewElementArray[i2].name = maneuverViewDataCollectorArray[i2].name;
                aSLManeuverViewElementArray[i2].numberOfPoiIcons = maneuverViewDataCollectorArray[i2].numberOfPoiIcons;
                aSLManeuverViewElementArray[i2].poiIcons = maneuverViewDataCollectorArray[i2].poiIcons;
                aSLManeuverViewElementArray[i2].poiNavLocation = maneuverViewDataCollectorArray[i2].poiNavLocation;
                aSLManeuverViewElementArray[i2].rtt = maneuverViewDataCollectorArray[i2].rtt;
                aSLManeuverViewElementArray[i2].rtth = maneuverViewDataCollectorArray[i2].rtth;
                aSLManeuverViewElementArray[i2].rttm = maneuverViewDataCollectorArray[i2].rttm;
                aSLManeuverViewElementArray[i2].signPost = maneuverViewDataCollectorArray[i2].signPost;
                aSLManeuverViewElementArray[i2].symbolId = maneuverViewDataCollectorArray[i2].symbolId;
                aSLManeuverViewElementArray[i2].tmcEndLocation = maneuverViewDataCollectorArray[i2].tmcEndLocation;
                aSLManeuverViewElementArray[i2].tmcListIcon = maneuverViewDataCollectorArray[i2].tmcListIcon;
                aSLManeuverViewElementArray[i2].tmcMessageID = maneuverViewDataCollectorArray[i2].tmcMessageID;
                aSLManeuverViewElementArray[i2].tmcMessageText = maneuverViewDataCollectorArray[i2].tmcMessageText;
                aSLManeuverViewElementArray[i2].tmcRoadName = maneuverViewDataCollectorArray[i2].tmcRoadName;
                aSLManeuverViewElementArray[i2].tmcStartLocation = maneuverViewDataCollectorArray[i2].tmcStartLocation;
                aSLManeuverViewElementArray[i2].type = maneuverViewDataCollectorArray[i2].type;
            }
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1119603456);
            eventGeneric.setObject(0, aSLManeuverViewElementArray);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        }
    }

    private void updateTimeAndDistance() {
        for (int i2 = 0; i2 < this.maneuverElementList.size(); ++i2) {
            ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)this.maneuverElementList.get(i2);
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(maneuverViewDataCollector.destinationIndex, maneuverViewDataCollector.distanceToNextDestination)) continue;
            maneuverViewDataCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(maneuverViewDataCollector.distanceToNextDestination, maneuverViewDataCollector.destinationIndex);
            if (maneuverViewDataCollector.type == 2) continue;
            int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(maneuverViewDataCollector.rtt, maneuverViewDataCollector.destinationIndex);
            maneuverViewDataCollector.rtth = nArray[0];
            maneuverViewDataCollector.rttm = nArray[1];
        }
    }

    private ManeuverViewDataCollector createManeuverListElement(TurnListElement turnListElement) {
        boolean bl;
        this.traceState("createManeuverListElement()");
        ManeuverViewDataCollector maneuverViewDataCollector = new ManeuverViewDataCollector();
        maneuverViewDataCollector.destinationIndex = turnListElement.destinationIndex;
        maneuverViewDataCollector.distanceToNextDestination = turnListElement.distance;
        maneuverViewDataCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(turnListElement);
        maneuverViewDataCollector.numberOfPoiIcons = 0;
        int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(turnListElement);
        maneuverViewDataCollector.rtt = turnListElement.eta * 0;
        maneuverViewDataCollector.rtth = nArray[0];
        maneuverViewDataCollector.rttm = nArray[1];
        if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0) {
            maneuverViewDataCollector.direction = turnListElement.maneuver[0].direction;
            maneuverViewDataCollector.mainElement = turnListElement.maneuver[0].element;
        }
        boolean bl2 = this.rgCurrentRoute != null && this.rgCurrentRoute.getRoutelist() != null && this.rgCurrentRoute.getRoutelist().length > 0;
        boolean bl3 = bl = maneuverViewDataCollector.mainElement == 3 || maneuverViewDataCollector.mainElement == 5;
        if (bl2 && bl) {
            int n;
            Object object;
            this.traceState("createManeuverListElement() - update name for POI / Destination memory entry");
            NavLocation navLocation = this.rgCurrentRoute.routelist[(int)this.rgCurrentRoute.indexOfCurrentDestination].routeLocation;
            if (navLocation != null && navLocation.proprietaryData != null) {
                for (int i2 = 0; i2 < navLocation.proprietaryData.length; ++i2) {
                    object = navLocation.proprietaryData[i2];
                    if (this.isNaviLocationSelectionCriterion4DestinationMemoryEntry(((NavLocationDescriptor)object).selectionCriterion)) {
                        n = ((NavLocationDescriptor)object).data.indexOf("[[1]]=", 0);
                        int n2 = ((NavLocationDescriptor)object).data.indexOf("[[", n + 2);
                        maneuverViewDataCollector.name = ((NavLocationDescriptor)object).data.substring(n + 6, n2 == -1 ? ((NavLocationDescriptor)object).data.length() : n2);
                        this.traceState("createManeuverListElement() - NavLocationDescriptor - Destination memory entry");
                        break;
                    }
                    if (!this.isNaviLocationSelectionCriterion4POIName(((NavLocationDescriptor)object).selectionCriterion)) continue;
                    maneuverViewDataCollector.name = ((NavLocationDescriptor)object).data;
                    this.traceState("createManeuverListElement() - NavLocationDescriptor - POI");
                }
            }
            if (maneuverViewDataCollector.name == "") {
                this.traceState("createManeuverListElement() - update name for Address destination using NavLocation fields");
                if (!Target3Plus1Box.isNullOrEmpty(navLocation.street)) {
                    if (!Target3Plus1Box.isNullOrEmpty(navLocation.housenumber)) {
                        maneuverViewDataCollector.name = ServiceManager.configManagerDiag.isFeatureFlagSet(140) ? new StringBuffer().append(navLocation.housenumber).append(" ").append(navLocation.street).toString() : new StringBuffer().append(navLocation.street).append(" ").append(navLocation.housenumber).toString();
                        this.traceState("createManeuverListElement() - street and housenumber available");
                    } else {
                        maneuverViewDataCollector.name = navLocation.street;
                        this.traceState("createManeuverListElement() - street but no housenumber available");
                    }
                } else if (!Target3Plus1Box.isNullOrEmpty(navLocation.town)) {
                    maneuverViewDataCollector.name = navLocation.town;
                    this.traceState("createManeuverListElement() - city but no street available");
                } else if (navLocation.latitude != 0 && navLocation.longitude != 0) {
                    ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation.latitude, navLocation.longitude);
                    object = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
                    n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
                    maneuverViewDataCollector.name = ServiceManager.fixFormat4Asl.fmtRulesetBasedString(10 + n, (FixFormatterFieldData)object);
                    this.traceState("createManeuverListElement() - no city or street available, provide orientation in current system language");
                }
            }
        } else {
            maneuverViewDataCollector.name = this.handleNullStrings(turnListElement.turnToStreet);
            this.traceState("createManeuverListElement() - turnToStreet");
        }
        maneuverViewDataCollector.signPost = this.handleNullStrings(turnListElement.signPostInfo);
        maneuverViewDataCollector.type = 0;
        return maneuverViewDataCollector;
    }

    private boolean isNaviLocationSelectionCriterion4DestinationMemoryEntry(int n) {
        return n == 768 || n == 768;
    }

    private boolean isNaviLocationSelectionCriterion4POIName(int n) {
        return n == 4097 || n == 512 || n == 16641;
    }

    private String handleNullStrings(String string) {
        return string == null ? "" : string;
    }

    private ManeuverViewDataCollector createManeuverListElement(NavPoiInfo navPoiInfo) {
        Object object;
        ManeuverViewDataCollector maneuverViewDataCollector = new ManeuverViewDataCollector();
        maneuverViewDataCollector.destinationIndex = navPoiInfo.destinationIndex;
        maneuverViewDataCollector.distanceToNextDestination = navPoiInfo.distance;
        maneuverViewDataCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(navPoiInfo);
        maneuverViewDataCollector.numberOfPoiIcons = navPoiInfo.poiLocations.length;
        if (navPoiInfo.poiLocations.length > 0) {
            maneuverViewDataCollector.poiIcons = new ResourceLocator[5];
            maneuverViewDataCollector.poiNavLocation = navPoiInfo.getPoiLocations()[0];
            for (int i2 = 0; i2 < navPoiInfo.poiLocations.length; ++i2) {
                object = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navPoiInfo.poiLocations[i2]);
                if (i2 == 0) {
                    maneuverViewDataCollector.name = object.getPoiName();
                }
                maneuverViewDataCollector.poiIcons[i2] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(object.getIconIndex(), object.getSubIconIndex(), 0, this, new Object[]{maneuverViewDataCollector, new Integer(i2)});
                if (i2 == 5) break;
            }
        }
        maneuverViewDataCollector.rtt = navPoiInfo.remainingTime;
        object = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(navPoiInfo);
        maneuverViewDataCollector.rtth = object[0];
        maneuverViewDataCollector.rttm = object[1];
        maneuverViewDataCollector.type = 1;
        return maneuverViewDataCollector;
    }

    private ManeuverViewDataCollector createManeuverListElement(TmcMessage tmcMessage) {
        ManeuverViewDataCollector maneuverViewDataCollector = new ManeuverViewDataCollector();
        maneuverViewDataCollector.destinationIndex = tmcMessage.destinationIndex;
        maneuverViewDataCollector.distanceToNextDestination = tmcMessage.distanceToEvent;
        maneuverViewDataCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(tmcMessage);
        maneuverViewDataCollector.tmcEndLocation = tmcMessage.endLocation;
        maneuverViewDataCollector.tmcListIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcMessage.iconListId[0], 0, 1, this, maneuverViewDataCollector);
        if (tmcMessage.eventText != null && tmcMessage.eventText.length > 0) {
            maneuverViewDataCollector.tmcMessageText = tmcMessage.eventText[0];
        }
        maneuverViewDataCollector.tmcRoadName = this.handleNullStrings(tmcMessage.roadName);
        maneuverViewDataCollector.tmcStartLocation = this.handleNullStrings(tmcMessage.startLocation);
        maneuverViewDataCollector.type = 2;
        maneuverViewDataCollector.tmcMessageID = tmcMessage.messageID;
        return maneuverViewDataCollector;
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (object.getClass() == (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Target3Plus1Box.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            Object[] objectArray = (Object[])object;
            ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)objectArray[0];
            Integer n = (Integer)objectArray[1];
            block0: for (int i2 = 0; i2 < this.maneuverElementList.size(); ++i2) {
                ManeuverViewDataCollector maneuverViewDataCollector2 = (ManeuverViewDataCollector)this.maneuverElementList.get(i2);
                if (maneuverViewDataCollector2 != maneuverViewDataCollector) continue;
                for (int i3 = 0; i3 < maneuverViewDataCollector2.poiIcons.length; ++i3) {
                    if (i3 != n) continue;
                    maneuverViewDataCollector2.poiIcons[i3] = resourceLocator;
                    continue block0;
                }
            }
        } else {
            ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)object;
            for (int i4 = 0; i4 < this.maneuverElementList.size(); ++i4) {
                ManeuverViewDataCollector maneuverViewDataCollector3 = (ManeuverViewDataCollector)this.maneuverElementList.get(i4);
                if (maneuverViewDataCollector3 != maneuverViewDataCollector) continue;
                maneuverViewDataCollector3.tmcListIcon = resourceLocator;
                break;
            }
        }
    }

    private void handleSelectListElement(EventGeneric eventGeneric) {
        this.traceState(new StringBuffer("handleSelectListElement (").append(eventGeneric.getInt(0)).append(")").toString());
        int n = eventGeneric.getInt(0);
        ManeuverViewDataCollector[] maneuverViewDataCollectorArray = this.createManeuverElementListForModel();
        ManeuverViewDataCollector maneuverViewDataCollector = maneuverViewDataCollectorArray[n];
        switch (maneuverViewDataCollector.type) {
            case 1: {
                this.traceState("POI ELEMENT SELECTED");
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 1598755840, 1155609344);
                eventGeneric2.setObject(0, maneuverViewDataCollector.poiNavLocation);
                this.sendEventSelectedPOIorTMC(eventGeneric2);
                break;
            }
            case 2: {
                this.traceState("TMC ELEMENT SELECTED");
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 1883968512, 1138832128);
                eventGeneric3.setLong(0, maneuverViewDataCollector.tmcMessageID);
                this.sendEventSelectedPOIorTMC(eventGeneric3);
                break;
            }
            default: {
                this.traceState("ERROR: ELEMENT SELECTED NOT RECOGNISED AS POI OR TMC");
            }
        }
    }

    private void sendEventSelectedPOIorTMC(EventGeneric eventGeneric) {
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error(genericEventException);
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.wasDsiNavigationResettet(hashMap);
        boolean bl2 = this.wasDsiTmcOnRouteResettet(hashMap);
        boolean bl3 = this.wasDsiMapViewerResettet(hashMap);
        if (bl || bl2 || bl3) {
            if (this.isTraceEnabled()) {
                this.trace("Target3Plus1Box: resetting values after DSI restart");
            }
            if (bl) {
                this.initLocalVariablesDsiNavigation();
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiTmcOnRoute();
            }
            if (bl3) {
                this.initLocalVariablesDsiMapViewer();
                this.initDsiMapViewer();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("Target3Plus1Box: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariablesDsiNavigation() {
        this.isRgActive = false;
        this.stopTimer();
        this.maneuverElementList = new SortedList();
        this.bapTurnList = new BapTurnToInfo[0];
        this.isManeuverView = false;
    }

    private void initLocalVariablesDsiMapViewer() {
        this.exitViewCollector = new NavigationMapSSManeuverExitViewDataCollector();
        this.isExitView = false;
    }

    private boolean wasDsiNavigationResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target3Plus1Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
    }

    private boolean wasDsiTmcOnRouteResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target3Plus1Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0);
    }

    private boolean wasDsiMapViewerResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target3Plus1Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName(), 0);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVER_DSINAV = new int[]{25, 11, 75, 54, 85, 13};
        OBSERVER_DSIMAP = new int[]{2, 1};
        OBSERVER_DSITMC = new int[]{1};
        OBSERVERS = new int[]{969478208, 828650752};
        LOGGER = null;
    }
}

