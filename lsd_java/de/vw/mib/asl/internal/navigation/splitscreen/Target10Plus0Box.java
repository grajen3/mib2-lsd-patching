/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.maneuverviewtenitems.transformer.NavigationManeuverViewDataTenItemsCollector;
import de.vw.mib.asl.internal.navigation.splitscreen.Handler2Plus0CHNJPN;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.PersistedOverlaysSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.TmcMessage;

public class Target10Plus0Box
extends AbstractResettableAslTarget
implements CacheClient,
DSIServiceStateListener,
TargetForResetNavigation {
    protected DSINavigation navigationService;
    protected DSITmcOnRoute tmcOnRouteService;
    protected DSIMapViewerManeuverView mapViewerManeuverView;
    private boolean isRgActive;
    private NavRouteListData[] rgDestinationInfo;
    public static final int MAX_LIST_SIZE;
    static final int MAX_POI_ICONS;
    private NavPoiInfo[] poiList = new NavPoiInfo[0];
    private TmcMessage[] tmcList = new TmcMessage[0];
    private TurnListElement[] turnList = new TurnListElement[0];
    private NavigationManeuverViewDataTenItemsCollector[] elementList = new NavigationManeuverViewDataTenItemsCollector[0];
    private Route rgCurrentRoute;
    private static final int[] OBSERVERS;
    public static final int EV_ASL_INT_MAP_SPLITSCREEN_ON;
    public static final int EV_ASL_INT_MAP_SPLITSCREEN_OFF;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_POI_ICONS;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_TMC_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_ROAD_SIGN_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_TRAFFIC_LIGHT_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_COLOR_INDICATOR_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_EXIT_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_FERRY_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_TUNNEL_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_TOLLGATE_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_TOLLGATE_ETC_ICON;
    private static final int ICON_CACHE_ID_10PLUS0_BOX_ICON_TYPE_STOPOVER_ICON;
    private static final int LANE_TYPE_ETC;
    private boolean uTurnEnabled = Target10Plus0Box.getSystemConstantB("NAV_UTURN_MAPPING", true);
    private final int uTurnLeftValue = Target10Plus0Box.getSystemConstant("NAV_UTURN_LEFT_DIRECTION", 114);
    private final int uTurnRightValue = Target10Plus0Box.getSystemConstant("NAV_UTURN_RIGHT_DIRECTION", 146);
    private boolean isServiceStateListenerAdded = false;
    private DSIListener navListener;
    private DSIListener tmcOnRouteListener;
    private DSIListener maneuverViewListener;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private Handler2Plus0CHNJPN handler2Plus0 = new Handler2Plus0CHNJPN(this);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public Target10Plus0Box(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
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

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target10Plus0Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.initDsiNavigation();
        } else if (string2 == (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target10Plus0Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().intern()) {
            this.initDsiTmcOnRoute();
        } else if (string2 == (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target10Plus0Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName().intern()) {
            this.initDsiMapViewer();
        }
        if (this.mapViewerManeuverView != null && this.tmcOnRouteService != null && this.navigationService != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiNavigation() {
        if (this.isTraceEnabled()) {
            this.trace().append("DSINavigation registered").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target10Plus0Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = Target10Plus0Box.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.navigationService.setNotification(new int[]{25, 11, 75, 54, 85, 23, 13}, this.navListener);
    }

    private void initDsiMapViewer() {
        if (this.isTraceEnabled()) {
            this.trace().append("DSIMapViewerManeuerView registered").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mapViewerManeuverView = (DSIMapViewerManeuverView)dSIProxy.getService(this, class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target10Plus0Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView);
        this.maneuverViewListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = Target10Plus0Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener);
        this.mapViewerManeuverView.setNotification(new int[]{2}, this.maneuverViewListener);
    }

    private void initDsiTmcOnRoute() {
        if (this.isTraceEnabled()) {
            this.trace().append("DSITmcOnRoute registered").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.tmcOnRouteService = (DSITmcOnRoute)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target10Plus0Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
        this.tmcOnRouteListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = Target10Plus0Box.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener);
        this.tmcOnRouteService.setNotification(new int[]{1}, this.tmcOnRouteListener);
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            if (this.isTraceEnabled()) {
                this.trace().append("Target10Plus0Box tries to unregistered from ").append(string).append("...").log();
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target10Plus0Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string);
            } else if (string.intern() == (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target10Plus0Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().intern()) {
                this.unregisterDsiTmcOnRoute(string);
            } else if (string.intern() == (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target10Plus0Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName().intern()) {
                this.unregisterDsiMapViewerManeuverView(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiMapViewerManeuverView(String string) {
        this.maneuverViewListener = null;
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiTmcOnRoute(String string) {
        this.tmcOnRouteListener = null;
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string) {
        this.navListener = null;
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("Target10Plus0Box unregistered from ").append(string).log();
        }
    }

    private void traceList(Object[] objectArray, String string) {
        if (this.isTraceEnabled() && objectArray != null) {
            LogMessage logMessage = this.trace();
            logMessage.append(super.getClass().getName());
            logMessage.append(string);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                logMessage.append(objectArray[i2]);
            }
            logMessage.log();
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(super.getClass().getName()).append(" POWER_ON").log();
                }
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target10Plus0Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target10Plus0Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target10Plus0Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView, this);
                }
                this.handlePersistedValues();
                this.addObservers(OBSERVERS);
                if (this.navigationResetParticipant == null) {
                    this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                }
                this.handler2Plus0.setInternalAPINotifier(new SplitscreenInternalAPINotifier());
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(super.getClass().getName()).append(" POWER_OFF").log();
                }
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 1073742393: {
                this.traceState(new StringBuffer().append("SET_CURRENT_CONTENT_G (").append(eventGeneric.getInt(0)).append(")").toString());
                if (eventGeneric.getInt(0) != 5) break;
                this.updateAllLists();
                break;
            }
            case 1074841855: {
                this.handleRouteInfoDisplayMode(eventGeneric);
                break;
            }
            case 1074841863: {
                this.handleSelectListElement(eventGeneric);
                break;
            }
        }
    }

    private void handleSelectListElement(EventGeneric eventGeneric) {
        this.traceState(new StringBuffer().append("SELECT_LIST_ELEMENT (").append(eventGeneric.getInt(0)).append(")").toString());
        int n = eventGeneric.getInt(0);
        if (n < this.elementList.length) {
            switch (this.elementList[n].type) {
                case 11: 
                case 12: {
                    NavLocation navLocation = this.elementList[n].poiNavLocation;
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1706355712, 1598755840, 1155609344);
                    eventGeneric2.setObject(0, navLocation);
                    try {
                        this.send(eventGeneric2);
                    }
                    catch (GenericEventException genericEventException) {
                        this.error(genericEventException);
                    }
                    ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setCrosshairLocation(navLocation);
                    break;
                }
                case 13: {
                    EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(-1706355712, 1883968512, 1138832128);
                    eventGeneric3.setLong(0, this.elementList[n].messageID);
                    try {
                        this.send(eventGeneric3);
                    }
                    catch (GenericEventException genericEventException) {
                        this.error(genericEventException);
                    }
                    break;
                }
            }
        }
    }

    private void handleRouteInfoDisplayMode(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.traceState(new StringBuffer().append("handleRouteInfoDisplayMode(").append(n).append(")").toString());
        this.sendRouteInfoDisplayModeToModel(n);
        this.sendRouteInfoDisplayModeToDSI(n);
        PersistedOverlaysSetup.getInstance().setRouteinfoDisplayMode(n);
    }

    private void sendRouteInfoDisplayModeToModel(int n) {
        this.traceState(new StringBuffer().append("sendRouteInfoDisplayModeToModel(").append(n).append(")").toString());
        ServiceManager.aslPropertyManager.valueChangedInteger(586158080, n);
    }

    private void handlePersistedValues() {
        int n = PersistedOverlaysSetup.getInstance().getRouteinfoDisplayMode();
        this.traceState(new StringBuffer().append("handlePersistedValues(").append(n).append(")").toString());
        this.sendRouteInfoDisplayModeToModel(n);
        this.sendRouteInfoDisplayModeToDSI(n);
    }

    private void sendRouteInfoDisplayModeToDSI(int n) {
        this.traceState(new StringBuffer().append("sendRouteInfoDisplayModeToDSI(").append(n).append(")").toString());
        if (n == 0) {
            this.navigationService.enableRgPoiInfo(false);
            this.navigationService.rgSetTurnListMode(2);
        } else {
            this.navigationService.enableRgPoiInfo(this.isRgActive);
            this.navigationService.rgSetTurnListMode(1);
        }
    }

    private boolean isManeuverView() {
        return System.getProperty("TenPlusOneBoxAvailable") != null || ASLNavigationMapFactory.getNavigationMapApi().getSplitScreenContentGuidance() == 5;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.isRgActive = bl;
        if (!this.isRgActive) {
            this.navigationService.enableRgPoiInfo(false);
            this.elementList = new NavigationManeuverViewDataTenItemsCollector[0];
            ListManager.getGenericASLList(-168882176).updateList(this.elementList);
            this.turnList = new TurnListElement[0];
            this.poiList = new NavPoiInfo[0];
            this.tmcList = new TmcMessage[0];
            this.handler2Plus0.updateCurrentTurnList(this.turnList);
            this.handler2Plus0.updateCurrentTMCList(this.tmcList);
            this.handler2Plus0.disposeAndRefreshTurnListElements2Plus0List();
            this.handler2Plus0.disposeAndRefreshTMCElements2Plus0List();
        } else {
            this.navigationService.enableRgPoiInfo(PersistedOverlaysSetup.getInstance().getRouteinfoDisplayMode() == 1);
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        if (this.isManeuverView()) {
            this.updateAllLists();
        }
        this.handler2Plus0.updateAllLists();
    }

    public void dsiNavigationUpdateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        this.rgDestinationInfo = navRouteListDataArray;
        if (this.isManeuverView()) {
            this.updateAllLists();
        }
        this.handler2Plus0.updateAllLists();
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.rgCurrentRoute = route;
        if (this.isManeuverView()) {
            this.updateAllLists();
        }
        this.handler2Plus0.updateAllLists();
    }

    public void dsiNavigationUpdateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        if (n == 1) {
            this.turnList = turnListElementArray;
            this.traceList(this.turnList, ".dsiNavigationUpdateRgTurnList: ");
            this.handler2Plus0.updateCurrentTurnList(this.turnList);
            this.handler2Plus0.disposeAndRefreshTurnListElements2Plus0List();
            if (this.isManeuverView()) {
                this.updateTurnListElements();
                this.ensureManeuverExistenceInList();
                this.updateModel();
            }
        }
    }

    public void dsiNavigationUpdateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        this.poiList = navPoiInfoArray;
        this.traceList(this.poiList, ".dsiNavigationUpdateRgPoiInfo: ");
        if (this.isManeuverView()) {
            this.updatePoiInfoElements();
            this.ensureManeuverExistenceInList();
            this.updateModel();
        }
    }

    public void dsiTmcOnRouteUpdateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        this.tmcList = tmcMessageArray;
        this.traceList(tmcMessageArray, ".dsiNavigationUpdateTmcMessagesAhead: ");
        this.handler2Plus0.updateCurrentTMCList(this.tmcList);
        this.handler2Plus0.disposeAndRefreshTMCElements2Plus0List();
        if (this.isManeuverView()) {
            this.updateTMCElements();
            this.ensureManeuverExistenceInList();
            this.updateModel();
        }
    }

    private void updateAllLists() {
        this.updateTurnListElements();
        this.updatePoiInfoElements();
        this.updateTMCElements();
        this.ensureManeuverExistenceInList();
        this.updateTimeAndDistance();
        this.updateModel();
    }

    private void updateTimeAndDistance() {
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < this.elementList.length; ++i2) {
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.elementList[i2].destinationIndex, this.elementList[i2].distanceToNextDestination)) continue;
            this.elementList[i2].dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList[i2].distanceToNextDestination, this.elementList[i2].destinationIndex);
            if (this.elementList[i2].type != 13) {
                int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(this.elementList[i2].rtt * 0, this.elementList[i2].destinationIndex);
                this.elementList[i2].rtth = nArray[0];
                this.elementList[i2].rttm = nArray[1];
            }
            linkedList.add(this.elementList[i2]);
        }
        this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    private void updateTurnListElements() {
        int n;
        int n2;
        LinkedList linkedList = new LinkedList();
        if (this.elementList != null) {
            LinkedList linkedList2 = new LinkedList();
            for (n2 = 0; n2 < this.elementList.length; ++n2) {
                if (this.elementList[n2].type != 11 && this.elementList[n2].type != 12 && this.elementList[n2].type != 13) continue;
                linkedList2.add(this.elementList[n2]);
            }
            this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList2.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
        }
        for (n = 0; n < this.turnList.length && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.turnList[n]); ++n) {
        }
        n2 = this.elementList.length - 1;
        while ((n2 >= 0 || n < this.turnList.length) && linkedList.size() < 10) {
            if (n >= this.turnList.length) {
                linkedList.addFirst(this.elementList[n2]);
                --n2;
                continue;
            }
            if (n2 < 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.turnList[n]) < ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList[n2].distanceToNextDestination, this.elementList[n2].destinationIndex)) {
                NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.createManeuverListElement(this.turnList[n]);
                if (navigationManeuverViewDataTenItemsCollector.type != 255) {
                    linkedList.addFirst(navigationManeuverViewDataTenItemsCollector);
                }
                ++n;
                continue;
            }
            if (this.elementList[n2].type != 11 && this.elementList[n2].type != 12 && this.elementList[n2].type != 13 && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.turnList[n]) == ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList[n2].distanceToNextDestination, this.elementList[n2].destinationIndex)) {
                ++n;
            }
            linkedList.addFirst(this.elementList[n2]);
            --n2;
        }
        this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    private void updatePoiInfoElements() {
        int n;
        int n2;
        LinkedList linkedList = new LinkedList();
        this.traceState("updatePoiInfoElements");
        if (this.elementList != null) {
            LinkedList linkedList2 = new LinkedList();
            for (n2 = 0; n2 < this.elementList.length; ++n2) {
                if (this.elementList[n2].type == 11 || this.elementList[n2].type == 12) continue;
                linkedList2.add(this.elementList[n2]);
            }
            this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList2.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
        }
        for (n = 0; n < this.poiList.length && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.poiList[n]); ++n) {
        }
        n2 = this.elementList.length - 1;
        while ((n2 >= 0 || n < this.poiList.length) && linkedList.size() < 10) {
            if (n >= this.poiList.length) {
                linkedList.addFirst(this.elementList[n2]);
                --n2;
                continue;
            }
            if (n2 < 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.poiList[n]) <= ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList[n2].distanceToNextDestination, this.elementList[n2].destinationIndex) && !this.isPoiElementEqual(this.poiList[n], this.elementList[n2])) {
                NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.createManeuverListElement(this.poiList[n]);
                if (navigationManeuverViewDataTenItemsCollector.type != 255) {
                    linkedList.addFirst(navigationManeuverViewDataTenItemsCollector);
                }
                ++n;
                continue;
            }
            if (n2 < 0) continue;
            if (this.isPoiElementEqual(this.poiList[n], this.elementList[n2])) {
                ++n;
            }
            linkedList.addFirst(this.elementList[n2]);
            --n2;
        }
        this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    private boolean isPoiElementEqual(NavPoiInfo navPoiInfo, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        this.traceState("isPoiElementEqual()");
        boolean bl = false;
        if (navigationManeuverViewDataTenItemsCollector.type == 11 || navigationManeuverViewDataTenItemsCollector.type == 12) {
            this.traceState("Element is a POI");
            if (navPoiInfo != null && navPoiInfo.poiLocations != null && navPoiInfo.poiLocations.length > 0) {
                ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navPoiInfo.poiLocations[0]);
                if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(navPoiInfo) == ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(navigationManeuverViewDataTenItemsCollector.distanceToNextDestination, navigationManeuverViewDataTenItemsCollector.destinationIndex)) {
                    this.traceState("Distance to destination is equal");
                    bl = true;
                } else if (iLocationWrapper.getPoiName().equals(navigationManeuverViewDataTenItemsCollector.name)) {
                    this.traceState("POI name is equal");
                    bl = true;
                }
            }
        }
        return bl;
    }

    private void updateTMCElements() {
        int n;
        int n2;
        LinkedList linkedList = new LinkedList();
        if (this.elementList != null) {
            LinkedList linkedList2 = new LinkedList();
            for (n2 = 0; n2 < this.elementList.length; ++n2) {
                if (this.elementList[n2].type == 13) continue;
                linkedList2.add(this.elementList[n2]);
            }
            this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList2.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
        }
        for (n = 0; n < this.tmcList.length && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.tmcList[n]); ++n) {
        }
        n2 = this.elementList.length - 1;
        while ((n2 >= 0 || n < this.tmcList.length) && linkedList.size() < 10) {
            if (n >= this.tmcList.length) {
                linkedList.addFirst(this.elementList[n2]);
                --n2;
                continue;
            }
            if (n2 < 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.tmcList[n]) < ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList[n2].distanceToNextDestination, this.elementList[n2].destinationIndex)) {
                NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.createManeuverListElement(this.tmcList[n]);
                linkedList.addFirst(navigationManeuverViewDataTenItemsCollector);
                ++n;
                continue;
            }
            if (this.elementList[n2].type == 13 && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.tmcList[n]) == ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList[n2].distanceToNextDestination, this.elementList[n2].destinationIndex)) {
                ++n;
            }
            linkedList.addFirst(this.elementList[n2]);
            --n2;
        }
        this.elementList = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    public NavigationManeuverViewDataTenItemsCollector createManeuverListElement(TurnListElement turnListElement) {
        this.traceState(new StringBuffer().append("createManeuverListElement(type = ").append(turnListElement.type).append(")").toString());
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = new NavigationManeuverViewDataTenItemsCollector();
        navigationManeuverViewDataTenItemsCollector.destinationIndex = turnListElement.destinationIndex;
        navigationManeuverViewDataTenItemsCollector.distanceToNextDestination = turnListElement.distance;
        navigationManeuverViewDataTenItemsCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(turnListElement);
        navigationManeuverViewDataTenItemsCollector.name = turnListElement.turnToStreet;
        navigationManeuverViewDataTenItemsCollector.numberOfPoiIcons = 0;
        int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(turnListElement);
        navigationManeuverViewDataTenItemsCollector.rtt = turnListElement.eta;
        navigationManeuverViewDataTenItemsCollector.rtth = nArray[0];
        navigationManeuverViewDataTenItemsCollector.rttm = nArray[1];
        switch (turnListElement.getType()) {
            case 1: {
                this.createManeuverListElementNonControlledAccess(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 2: {
                this.createManeuverListElementControlledAccess(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 3: {
                this.createManeuverListElementPassingPoint(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 4: {
                this.createManeuverListElementTollgate(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 5: {
                this.createManeuverListElementFerry(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 6: {
                this.createManeuverListElementTunnel(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 7: {
                this.createManeuverListElementDestination(turnListElement, navigationManeuverViewDataTenItemsCollector);
                break;
            }
            default: {
                navigationManeuverViewDataTenItemsCollector.type = 255;
            }
        }
        return navigationManeuverViewDataTenItemsCollector;
    }

    private void createManeuverListElementDestination(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0 && turnListElement.maneuver[0] != null && (turnListElement.maneuver[0].getElement() == 3 || turnListElement.maneuver[0].getElement() == 5) && this.rgCurrentRoute != null && this.rgCurrentRoute.routelist != null && this.rgCurrentRoute.routelist.length > turnListElement.destinationIndex && this.rgDestinationInfo != null) {
            this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
            NavLocation navLocation = this.rgCurrentRoute.routelist[turnListElement.destinationIndex].getRouteLocation();
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            if (iLocationWrapper.getLocationDSIType() == 1) {
                navigationManeuverViewDataTenItemsCollector.name = iLocationWrapper.getPoiName();
                navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
                navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, new Object[]{new Integer(0), navigationManeuverViewDataTenItemsCollector, new Integer(0)});
            } else {
                navigationManeuverViewDataTenItemsCollector.poiIcons = null;
                navigationManeuverViewDataTenItemsCollector.name = "";
            }
            navigationManeuverViewDataTenItemsCollector.fixFormatterFieldForAddressData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            navigationManeuverViewDataTenItemsCollector.type = turnListElement.destinationIndex < this.rgDestinationInfo.length - 1 ? 9 : 10;
        } else {
            navigationManeuverViewDataTenItemsCollector.type = 255;
        }
    }

    private void createManeuverListElementTunnel(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        if (turnListElement.maneuver == null || turnListElement.maneuver.length == 0) {
            this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
            navigationManeuverViewDataTenItemsCollector.length = (int)turnListElement.length;
            navigationManeuverViewDataTenItemsCollector.type = 8;
        } else {
            navigationManeuverViewDataTenItemsCollector.type = 255;
        }
    }

    private void createManeuverListElementFerry(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0 && turnListElement.maneuver[0] != null && turnListElement.maneuver[0].getElement() == 137) {
            this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
            navigationManeuverViewDataTenItemsCollector.length = (int)turnListElement.length;
            navigationManeuverViewDataTenItemsCollector.type = 7;
        } else {
            navigationManeuverViewDataTenItemsCollector.type = 255;
        }
    }

    private void createManeuverListElementTollgate(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
        navigationManeuverViewDataTenItemsCollector.length = (int)turnListElement.length;
        navigationManeuverViewDataTenItemsCollector.tollGateCost = 0;
        navigationManeuverViewDataTenItemsCollector.tollGateCostCurrency = 0;
        if (turnListElement.tollcost != null) {
            navigationManeuverViewDataTenItemsCollector.tollGateCost = turnListElement.tollcost.getAmount();
            navigationManeuverViewDataTenItemsCollector.tollGateCostCurrency = turnListElement.tollcost.getCurrency();
        }
        if (turnListElement.laneGuidance != null && turnListElement.laneGuidance.length > 0) {
            this.extractETCLaneGuidance(turnListElement, navigationManeuverViewDataTenItemsCollector, turnListElement.laneGuidance.length);
            navigationManeuverViewDataTenItemsCollector.type = 6;
        } else {
            navigationManeuverViewDataTenItemsCollector.type = 5;
        }
    }

    private void createManeuverListElementPassingPoint(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        int n;
        navigationManeuverViewDataTenItemsCollector.signPost = turnListElement.getSignPostInfo();
        this.addRoadIcon(turnListElement, navigationManeuverViewDataTenItemsCollector);
        this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
        if (turnListElement.laneGuidance != null && (n = turnListElement.laneGuidance.length) > 0) {
            this.extractLaneGuidance(turnListElement, navigationManeuverViewDataTenItemsCollector, n);
        }
        navigationManeuverViewDataTenItemsCollector.type = 4;
    }

    private void addRoadIcon(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        IconDescriptor iconDescriptor;
        navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon = new LabeledIconValue();
        int n = 0;
        if (turnListElement.streetIconText != null) {
            n = turnListElement.streetIconText.length();
        }
        if ((iconDescriptor = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForRoadIcon(turnListElement.streetIconId, n, 0, this, new Object[]{new Integer(2), navigationManeuverViewDataTenItemsCollector})) != null) {
            navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon.setResourceLocator(iconDescriptor.getResourceLocator());
            navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon.setTextRenderingInfo(iconDescriptor.getTextRenderingInfo());
        }
        navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon.setText(turnListElement.streetIconText);
    }

    private void createManeuverListElementControlledAccess(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        navigationManeuverViewDataTenItemsCollector.signPost = turnListElement.getSignPostInfo();
        this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
        String string = turnListElement.exitNumber;
        if (string == null) {
            string = "";
        }
        IconDescriptor iconDescriptor = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForExitIcon(turnListElement.exitIconId, string.length(), 0, this, new Object[]{new Integer(5), navigationManeuverViewDataTenItemsCollector});
        navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
        navigationManeuverViewDataTenItemsCollector.poiIcons[0] = iconDescriptor.getResourceLocator();
        navigationManeuverViewDataTenItemsCollector.exitNumber = string;
        if (turnListElement.laneGuidance != null && turnListElement.laneGuidance.length > 0) {
            this.extractLaneGuidance(turnListElement, navigationManeuverViewDataTenItemsCollector, turnListElement.laneGuidance.length);
            navigationManeuverViewDataTenItemsCollector.type = 2;
        } else {
            if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0) {
                navigationManeuverViewDataTenItemsCollector.direction = turnListElement.maneuver[0].direction;
                navigationManeuverViewDataTenItemsCollector.mainElement = turnListElement.maneuver[0].element;
            }
            navigationManeuverViewDataTenItemsCollector.type = 3;
        }
    }

    private void createManeuverListElementNonControlledAccess(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        navigationManeuverViewDataTenItemsCollector.signPost = turnListElement.getSignPostInfo();
        this.addRoadIcon(turnListElement, navigationManeuverViewDataTenItemsCollector);
        this.extractAdditionalIcons(turnListElement, navigationManeuverViewDataTenItemsCollector);
        if (turnListElement.laneGuidance != null && turnListElement.laneGuidance.length > 0) {
            this.extractLaneGuidance(turnListElement, navigationManeuverViewDataTenItemsCollector, turnListElement.laneGuidance.length);
            navigationManeuverViewDataTenItemsCollector.type = 0;
        } else {
            if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0) {
                navigationManeuverViewDataTenItemsCollector.direction = turnListElement.maneuver[0].direction;
                navigationManeuverViewDataTenItemsCollector.mainElement = turnListElement.maneuver[0].element;
            }
            navigationManeuverViewDataTenItemsCollector.type = 1;
        }
    }

    private void extractLaneGuidance(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector, int n) {
        navigationManeuverViewDataTenItemsCollector.laneDirections = new int[n];
        navigationManeuverViewDataTenItemsCollector.laneInfos = new int[n];
        navigationManeuverViewDataTenItemsCollector.laneMarkingsLeft = new int[n];
        navigationManeuverViewDataTenItemsCollector.laneMarkingsRight = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            navigationManeuverViewDataTenItemsCollector.laneDirections[i2] = this.uTurnEnabled && turnListElement.laneGuidance[i2].laneDirection == this.uTurnLeftValue ? 180 : (this.uTurnEnabled && turnListElement.laneGuidance[i2].laneDirection == this.uTurnRightValue ? 181 : (8 - (turnListElement.laneGuidance[i2].laneDirection >> 5)) % 8 * 45);
            navigationManeuverViewDataTenItemsCollector.laneInfos[i2] = turnListElement.laneGuidance[i2].guidanceInfo;
            navigationManeuverViewDataTenItemsCollector.laneMarkingsLeft[i2] = turnListElement.laneGuidance[i2].laneMarkingLeft;
            navigationManeuverViewDataTenItemsCollector.laneMarkingsRight[i2] = turnListElement.laneGuidance[i2].laneMarkingRight;
        }
    }

    private void extractETCLaneGuidance(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector, int n) {
        navigationManeuverViewDataTenItemsCollector.tollGateDirections = new int[n];
        navigationManeuverViewDataTenItemsCollector.tollGateInfos = new int[n];
        navigationManeuverViewDataTenItemsCollector.tollGateMarkingsLeft = new int[n];
        navigationManeuverViewDataTenItemsCollector.tollGateMarkingsRight = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            navigationManeuverViewDataTenItemsCollector.tollGateDirections[i2] = turnListElement.laneGuidance[i2].laneDirection;
            navigationManeuverViewDataTenItemsCollector.tollGateInfos[i2] = turnListElement.laneGuidance[i2].laneType == 22 ? 1 : 0;
            navigationManeuverViewDataTenItemsCollector.tollGateMarkingsLeft[i2] = turnListElement.laneGuidance[i2].laneMarkingLeft;
            navigationManeuverViewDataTenItemsCollector.tollGateMarkingsRight[i2] = turnListElement.laneGuidance[i2].laneMarkingRight;
        }
    }

    private void extractAdditionalIcons(TurnListElement turnListElement, NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        navigationManeuverViewDataTenItemsCollector.trafficLightIconVisibility = false;
        AdditionalTurnListIcon[] additionalTurnListIconArray = turnListElement.getAdditionalIcons();
        if (additionalTurnListIconArray != null) {
            block9: for (int i2 = 0; i2 < additionalTurnListIconArray.length; ++i2) {
                if (additionalTurnListIconArray[i2] == null) continue;
                switch (additionalTurnListIconArray[i2].getType()) {
                    case 1: {
                        navigationManeuverViewDataTenItemsCollector.colorIndicatorIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(4), navigationManeuverViewDataTenItemsCollector});
                        continue block9;
                    }
                    case 2: {
                        navigationManeuverViewDataTenItemsCollector.trafficLightIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(3), navigationManeuverViewDataTenItemsCollector});
                        navigationManeuverViewDataTenItemsCollector.trafficLightIconVisibility = true;
                        continue block9;
                    }
                    case 5: {
                        navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
                        navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(6), navigationManeuverViewDataTenItemsCollector});
                        continue block9;
                    }
                    case 6: {
                        navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
                        navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(7), navigationManeuverViewDataTenItemsCollector});
                        continue block9;
                    }
                    case 3: {
                        navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
                        navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(8), navigationManeuverViewDataTenItemsCollector});
                        continue block9;
                    }
                    case 4: {
                        navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
                        navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(9), navigationManeuverViewDataTenItemsCollector});
                        continue block9;
                    }
                    case 7: {
                        navigationManeuverViewDataTenItemsCollector.stopoverFlagIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(additionalTurnListIconArray[i2].getIconId(), additionalTurnListIconArray[i2].getType(), -1, 0, this, new Object[]{new Integer(10), navigationManeuverViewDataTenItemsCollector});
                        navigationManeuverViewDataTenItemsCollector.trafficLightIconVisibility = true;
                        continue block9;
                    }
                }
            }
        }
    }

    private NavigationManeuverViewDataTenItemsCollector createManeuverListElement(NavPoiInfo navPoiInfo) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = new NavigationManeuverViewDataTenItemsCollector();
        navigationManeuverViewDataTenItemsCollector.distanceToNextDestination = navPoiInfo.distance;
        navigationManeuverViewDataTenItemsCollector.destinationIndex = navPoiInfo.destinationIndex;
        navigationManeuverViewDataTenItemsCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(navPoiInfo.distance, navPoiInfo.destinationIndex);
        navigationManeuverViewDataTenItemsCollector.rtt = navPoiInfo.remainingTime / 0;
        int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(navPoiInfo);
        navigationManeuverViewDataTenItemsCollector.rtth = nArray[0];
        navigationManeuverViewDataTenItemsCollector.rttm = nArray[1];
        if (navPoiInfo.getPoiIcons() != null) {
            navigationManeuverViewDataTenItemsCollector.numberOfPoiIcons = navPoiInfo.getPoiIcons().length;
            navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1 + navPoiInfo.getPoiIcons().length];
            for (int i2 = 0; i2 < navPoiInfo.getPoiIcons().length; ++i2) {
                navigationManeuverViewDataTenItemsCollector.poiIcons[i2 + 1] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(navPoiInfo.getPoiIcons()[i2].criteria1, navPoiInfo.getPoiIcons()[i2].criteria2, 0, this, new Object[]{new Integer(0), navigationManeuverViewDataTenItemsCollector, new Integer(i2 + 1)});
            }
        } else {
            navigationManeuverViewDataTenItemsCollector.numberOfPoiIcons = 0;
            navigationManeuverViewDataTenItemsCollector.poiIcons = new ResourceLocator[1];
        }
        if (navPoiInfo.type == 1 && navigationManeuverViewDataTenItemsCollector.numberOfPoiIcons > 0) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navPoiInfo.exitPoiLocation);
            navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, new Object[]{new Integer(0), navigationManeuverViewDataTenItemsCollector, new Integer(0)});
            navigationManeuverViewDataTenItemsCollector.exitNumber = navPoiInfo.exitNumber;
            navigationManeuverViewDataTenItemsCollector.name = navPoiInfo.signpostInfo;
            navigationManeuverViewDataTenItemsCollector.poiNavLocation = navPoiInfo.exitPoiLocation;
            navigationManeuverViewDataTenItemsCollector.type = 11;
        } else if (navPoiInfo.type == 2) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navPoiInfo.getPoiLocations()[0]);
            navigationManeuverViewDataTenItemsCollector.poiIcons[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, new Object[]{new Integer(0), navigationManeuverViewDataTenItemsCollector, new Integer(0)});
            navigationManeuverViewDataTenItemsCollector.name = iLocationWrapper.getPoiName();
            navigationManeuverViewDataTenItemsCollector.poiNavLocation = navPoiInfo.getPoiLocations()[0];
            navigationManeuverViewDataTenItemsCollector.type = 12;
        } else {
            navigationManeuverViewDataTenItemsCollector.type = 255;
        }
        return navigationManeuverViewDataTenItemsCollector;
    }

    public NavigationManeuverViewDataTenItemsCollector createManeuverListElement(TmcMessage tmcMessage) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = new NavigationManeuverViewDataTenItemsCollector();
        navigationManeuverViewDataTenItemsCollector.messageID = tmcMessage.messageID;
        navigationManeuverViewDataTenItemsCollector.distanceToNextDestination = tmcMessage.distanceToEvent;
        navigationManeuverViewDataTenItemsCollector.destinationIndex = tmcMessage.destinationIndex;
        navigationManeuverViewDataTenItemsCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(tmcMessage.distanceToEvent, tmcMessage.destinationIndex);
        int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(tmcMessage);
        navigationManeuverViewDataTenItemsCollector.rtth = nArray[0];
        navigationManeuverViewDataTenItemsCollector.rttm = nArray[1];
        navigationManeuverViewDataTenItemsCollector.tmcEndLocation = tmcMessage.endLocation;
        navigationManeuverViewDataTenItemsCollector.tmcListIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcMessage.iconListId[0], 0, 1, this, new Object[]{new Integer(1), navigationManeuverViewDataTenItemsCollector});
        navigationManeuverViewDataTenItemsCollector.tmcMessageText = tmcMessage.eventText != null && tmcMessage.eventText.length > 0 ? tmcMessage.eventText[0] : "";
        navigationManeuverViewDataTenItemsCollector.tmcRoadName = tmcMessage.roadName;
        navigationManeuverViewDataTenItemsCollector.tmcRoadNumber = tmcMessage.roadNumber;
        navigationManeuverViewDataTenItemsCollector.tmcStartLocation = tmcMessage.startLocation;
        navigationManeuverViewDataTenItemsCollector.tmcEndLocation = tmcMessage.endLocation;
        navigationManeuverViewDataTenItemsCollector.tmcDelay = (int)(tmcMessage.eventDelay / 0);
        navigationManeuverViewDataTenItemsCollector.length = (int)tmcMessage.affectedRoadLength;
        navigationManeuverViewDataTenItemsCollector.type = 13;
        return navigationManeuverViewDataTenItemsCollector;
    }

    private void ensureManeuverExistenceInList() {
        this.traceState("ensureManeuverExistenceInList");
        if (!this.isManeuverElementInList()) {
            this.traceState("No maneuver in list found.");
            if (this.elementList != null && this.elementList.length > 0 && this.turnList != null && this.turnList.length > 0) {
                boolean bl = false;
                for (int i2 = 0; i2 < this.turnList.length && !bl; ++i2) {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.createManeuverListElement(this.turnList[i2]);
                    if (navigationManeuverViewDataTenItemsCollector.type == 255) continue;
                    this.elementList[0] = navigationManeuverViewDataTenItemsCollector;
                    this.traceState(new StringBuffer().append("Turnlist element No. ").append(i2).append(" added maneuver to list.").toString());
                    bl = true;
                }
                if (!bl) {
                    this.traceState("No turnlist could be added maneuver to list.");
                }
            }
        }
    }

    private boolean isManeuverElementInList() {
        this.traceState("isManeuverElementInList");
        if (this.elementList != null) {
            for (int i2 = 0; i2 < this.elementList.length; ++i2) {
                if (this.elementList[i2].type == 11 || this.elementList[i2].type == 12 || this.elementList[i2].type == 13 || this.elementList[i2].type == 255) continue;
                return true;
            }
        }
        return false;
    }

    private void updateModel() {
        if (this.isRgActive) {
            this.traceList(this.elementList, ".updateModel: ");
            ServiceManager.aslPropertyManager.valueChangedBoolean(552603648, this.elementList == null || this.elementList.length == 0 || this.elementList[0].type != 10 && this.elementList.length < 10);
            ListManager.getGenericASLList(-168882176).updateList(this.elementList);
            ServiceManager.aslPropertyManager.valueChangedInteger(1324355584, this.elementList.length);
            this.sendHMIEvent(-17887232);
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (object.getClass() == (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Target10Plus0Box.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            Object[] objectArray = (Object[])object;
            int n = (Integer)objectArray[0];
            switch (n) {
                case 0: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    Integer n2 = (Integer)objectArray[2];
                    if (n2 >= navigationManeuverViewDataTenItemsCollector.poiIcons.length) break;
                    navigationManeuverViewDataTenItemsCollector.poiIcons[n2.intValue()] = resourceLocator;
                    break;
                }
                case 1: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    navigationManeuverViewDataTenItemsCollector.tmcListIcon = resourceLocator;
                    break;
                }
                case 2: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon.setResourceLocator(resourceLocator);
                    navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon.setTextRenderingInfo(ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().getTextRenderingInfo(iconKey));
                    break;
                }
                case 4: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    navigationManeuverViewDataTenItemsCollector.colorIndicatorIcon = resourceLocator;
                    break;
                }
                case 3: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    navigationManeuverViewDataTenItemsCollector.trafficLightIcon = resourceLocator;
                    break;
                }
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    navigationManeuverViewDataTenItemsCollector.poiIcons[0] = resourceLocator;
                    break;
                }
                case 10: {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)objectArray[1];
                    navigationManeuverViewDataTenItemsCollector.stopoverFlagIcon = resourceLocator;
                    break;
                }
            }
        }
        this.updateModel();
    }

    private static int getSystemConstant(String string, int n) {
        String string2 = System.getProperty(string);
        if (string2 != null) {
            int n2 = Integer.parseInt(string2);
            return n2;
        }
        return n;
    }

    private static boolean getSystemConstantB(String string, boolean bl) {
        String string2 = System.getProperty(string);
        if (string2 != null) {
            boolean bl2 = Boolean.getBoolean(string2);
            return bl2;
        }
        return bl;
    }

    @Override
    public void handleNavigationSettingsReset() {
        int n = 1;
        this.sendRouteInfoDisplayModeToModel(n);
        this.sendRouteInfoDisplayModeToDSI(n);
        this.navigationResetParticipant.notifyResetDone();
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.wasDsiNavigationResettet(hashMap);
        boolean bl2 = this.wasDsiTmcOnRouteResettet(hashMap);
        boolean bl3 = this.wasDsiMapViewerResettet(hashMap);
        if (bl || bl2 || bl3) {
            if (this.isTraceEnabled()) {
                this.trace("Target10Plus0Box: resetting values after DSI restart");
            }
            this.initLocalVariables();
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiTmcOnRoute();
            }
            if (bl3) {
                this.initDsiMapViewer();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("Target10Plus0Box: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private boolean wasDsiNavigationResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = Target10Plus0Box.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
    }

    private boolean wasDsiTmcOnRouteResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = Target10Plus0Box.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0);
    }

    private boolean wasDsiMapViewerResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = Target10Plus0Box.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView).getName(), 0);
    }

    private void initLocalVariables() {
        this.isRgActive = false;
        this.poiList = new NavPoiInfo[0];
        this.turnList = new TurnListElement[0];
        this.tmcList = new TmcMessage[0];
        this.elementList = new NavigationManeuverViewDataTenItemsCollector[0];
        this.rgDestinationInfo = new NavRouteListData[0];
        this.handler2Plus0.updateCurrentTurnList(this.turnList);
        this.handler2Plus0.disposeAndRefreshTurnListElements2Plus0List();
        this.handler2Plus0.updateCurrentTMCList(this.tmcList);
        this.handler2Plus0.disposeAndRefreshTMCElements2Plus0List();
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
        OBSERVERS = new int[]{956432448, -3665856, 130617408};
    }
}

