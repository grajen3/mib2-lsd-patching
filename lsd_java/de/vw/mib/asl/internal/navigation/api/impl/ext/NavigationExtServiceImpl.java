/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.IOverlayData;
import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.api.navigation.NavigationExtService;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceInfo;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceLaneGuidance;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceVZAVZEIcons;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLPnavLikelyDestination;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.api.navigation.map.INavigationPosInfo;
import de.vw.mib.asl.api.navigation.map.NavigationMapListener;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.api.navigation.splitscreen.ASLManeuverViewElement;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListener;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NavStartupStatusListener;
import de.vw.mib.asl.api.navigation.traffic.INavigationTunerData;
import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITrafficSource;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ASLNavigationAPIImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavServiceLockable;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationListElementImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationPosInfoImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationTunerDataImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.ITmcMessageImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.guidance.NavigationGuidanceServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.map.NavigationMapServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.map.instrumentcluster.ICMapServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard.NavigationOnboardPoiServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.online.NavigationOnlinePoiServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.splitscreen.NavigationSplitscreenServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.traffic.INavRectangleImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.traffic.ITrafficSourceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.traffic.NavigationTrafficServiceImpl;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.navigation.internal.logging.LoggingProxy;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TrafficSource;

public class NavigationExtServiceImpl
extends AbstractResettableNavGatewayTarget
implements NavigationExtService,
DSIServiceStateListener,
NavStartupStatusListener {
    private int extServiceState = 0;
    private int guidanceState = -1;
    private int[] guidanceRcRouteIds;
    private int[] guidanceRcStates;
    private int[] guidanceRcProgress;
    public ASLNavigationServiceMainMap mainMapService;
    public INavServiceLockable locationInputLockOwner = null;
    public NavigationGuidanceServiceImpl activeGuidanceService;
    private NavigationMapServiceImpl lockedMapService;
    private DSINavigation dsiNavigation = null;
    private DSITmc dsiTmc = null;
    private DSITmcOnRoute dsiTmcOnRoute = null;
    private DSIListener dsiListnerTmcOnRoute = null;
    private DSIAsiaTrafficInfoMenu dsiAsiaTrafficInfoMenu = null;
    public INavigationListElement[] lastDestinations;
    private int lastNavigationServiceState;
    private boolean isWeakLock;
    private static final int EV_LOCATION_INPUT_LOCK_TIMEOUT;
    private static final int EV_LOCATION_INPUT_LOCK_RESULT;
    private static final int[] ATTRIBUTES_TMC;
    private static final int[] ATTRIBUTES_TMC_ON_ROUTE;
    private static final int[] MAIN_MAP_SERVICE_IDS;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$map$NavigationMapListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$map$NavigationMapService;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapService;

    @Override
    public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
        if (cmdDmLastDestinationsGet.getBlindArgument("listener") instanceof NavigationMemoryListener) {
            ((NavigationMemoryListener)cmdDmLastDestinationsGet.getBlindArgument("listener")).getLastDestinationResult((INavigationListElement)cmdDmLastDestinationsGet.getBlindArgument("req"), new INavigationLocationImpl(cmdDmLastDestinationsGet.dmLastDestinationsGetResult_destination), (int)cmdDmLastDestinationsGet.dmLastDestinationsGetResult_resultCode);
        }
    }

    public NavigationExtServiceImpl(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu, this);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc, this);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute, this);
        this.addObservers(MAIN_MAP_SERVICE_IDS);
        this.addObserver(1146893568);
        this.addObserver(1130116352);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.extServiceState = 1;
                ASLNavigationStartupFactory.getNavigationStartupApi().registerNavStartupStatusListener(this);
                this.navStartupStatusChanged();
                break;
            }
            case 101001: {
                this.addObserver(828126464);
                this.addObserver(761017600);
                this.addObserver(777794816);
                this.addObserver(794572032);
                this.addObserver(811349248);
                this.addObserver(1079784704);
                this.addObserver(979121408);
                this.addObserver(962344192);
                this.addObserver(995898624);
                this.addObserver(945566976);
                this.addObserver(1012675840);
                this.addObserver(1029453056);
                this.addObserver(1046230272);
                this.addObserver(1163670784);
                this.addObserver(1096561920);
                this.addObserver(1113339136);
                this.addObserver(1197225216);
                this.addObserver(1214002432);
                this.addObserver(1230779648);
                this.addObserver(1247556864);
                this.addObserver(1264334080);
                this.extServiceState = 100;
                this.guidanceState = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceState();
                this.addObserver(-1186712320);
                this.addObserver(-1169935104);
                this.addObserver(-1153157888);
                this.addObserver(-1136380672);
                this.addObserver(-1102826240);
                this.addObserver(-1119603456);
                this.addObserver(-1052494592);
                this.addObserver(-1069271808);
                this.addObserver(-1086049024);
                this.addObserver(-1035717376);
                this.mainMapService = ASLNavigationMapFactory.getNavigationMapApi().createMainMapService(this, MAIN_MAP_SERVICE_IDS);
                this.navStartupStatusChanged();
                break;
            }
            case 101002: {
                this.extServiceState = 1;
                this.navStartupStatusChanged();
                break;
            }
            case 101000: {
                this.extServiceState = 0;
                this.navStartupStatusChanged();
                break;
            }
            case 100101: {
                if (this.locationInputLockOwner == null) break;
                this.locationInputLockOwner.updateLock(true);
                break;
            }
            case 100100: {
                if (this.locationInputLockOwner == null) break;
                this.locationInputLockOwner.updateLock(false);
                this.locationInputLockOwner = null;
                break;
            }
            case 3497009: {
                IGuidanceInfo[] iGuidanceInfoArray = (ASLGuidanceInfo[])eventGeneric.getObject(0);
                NavigationGuidanceServiceImpl.notifyGuidanceInfo(iGuidanceInfoArray);
                break;
            }
            case 3497005: {
                ASLCalculationState[] aSLCalculationStateArray = (ASLCalculationState[])eventGeneric.getObject(0);
                this.guidanceRcRouteIds = new int[aSLCalculationStateArray.length];
                this.guidanceRcStates = new int[aSLCalculationStateArray.length];
                this.guidanceRcProgress = new int[aSLCalculationStateArray.length];
                for (int i2 = 0; i2 < aSLCalculationStateArray.length; ++i2) {
                    this.guidanceRcRouteIds[i2] = i2;
                    this.guidanceRcStates[i2] = aSLCalculationStateArray[i2].getCalculationState();
                    this.guidanceRcProgress[i2] = aSLCalculationStateArray[i2].getProgress();
                }
                NavigationGuidanceServiceImpl.notifyCalculationStates(this.guidanceRcRouteIds, this.guidanceRcStates, this.guidanceRcProgress);
                break;
            }
            case 3497008: {
                int n = eventGeneric.getInt(0);
                this.guidanceState = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceState();
                NavigationGuidanceServiceImpl.notifyGuidanceState(n, this.guidanceState);
                break;
            }
            case 3497006: {
                this.guidanceState = eventGeneric.getInt(0);
                int n = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceMode();
                NavigationGuidanceServiceImpl.notifyGuidanceState(n, this.guidanceState);
                break;
            }
            case 3497007: {
                this.guidanceState = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceState();
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyGuidanceErrorState(n);
                break;
            }
            case 3497024: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyTriggerEventAudioMessageResult(n);
                break;
            }
            case 3497018: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyWPMInfoDirection(n);
                break;
            }
            case 3497017: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyWPMDistanceToNextWaypoint(n);
                break;
            }
            case 3497019: {
                boolean bl = eventGeneric.getBoolean(0);
                NavigationGuidanceServiceImpl.notifyWPMIsRecordModeDestinationSet(bl);
                break;
            }
            case 3497016: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyWPMCurrentMode(n);
                break;
            }
            case 0x355C3C: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyWPMNumberOfFreePointsInMemory(n);
                break;
            }
            case 3497021: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyWPMNumberOfMaxPointsInMemory(n);
                break;
            }
            case 3497022: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifyWPMNumberOfPointsForCurrentRecord(n);
                break;
            }
            case 3400013: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.updateGoToLocationMapReady();
                break;
            }
            case 3400017: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.lockMapViewerResult(true);
                break;
            }
            case 3400022: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.handleMapServiceError(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                this.lockedMapService.listener.lockMapViewerResult(false);
                this.lockedMapService = null;
                break;
            }
            case 3400011: {
                if (this.lockedMapService == null) break;
                PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
                INavigationPosInfo[] iNavigationPosInfoArray = new INavigationPosInfo[posInfoArray != null ? posInfoArray.length : 0];
                for (int i3 = 0; i3 < iNavigationPosInfoArray.length && posInfoArray != null; ++i3) {
                    iNavigationPosInfoArray[i3] = new INavigationPosInfoImpl(posInfoArray[i3]);
                }
                this.lockedMapService.listener.clickInMapResult(iNavigationPosInfoArray);
                break;
            }
            case 3400014: {
                if (this.lockedMapService == null) break;
                int[] nArray = (int[])eventGeneric.getObject(0);
                this.lockedMapService.listener.updateMapLayerAvailable(nArray);
                break;
            }
            case 3400015: {
                if (this.lockedMapService == null) break;
                int[] nArray = (int[])eventGeneric.getObject(0);
                this.lockedMapService.listener.updateMapLayerVisible(nArray);
                break;
            }
            case 3400016: {
                if (this.lockedMapService == null) break;
                NavLocationWgs84 navLocationWgs84 = (NavLocationWgs84)eventGeneric.getObject(0);
                this.lockedMapService.listener.updateMapPosition(new INavigationLocationImpl(ASLNavigationUtilFactory.getNavigationUtilApi().constructNavLocation(navLocationWgs84.latitude, navLocationWgs84.longitude)));
                break;
            }
            case 3400018: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.zoomInDone();
                break;
            }
            case 3400019: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.updateZoomLevel(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 3400020: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.updateZoomList((int[])eventGeneric.getObject(0));
                break;
            }
            case 3400021: {
                if (this.lockedMapService == null) break;
                this.lockedMapService.listener.zoomInDone();
                break;
            }
            case 3400025: 
            case 3400026: {
                break;
            }
            case 3400024: {
                break;
            }
            case 3400030: {
                Object object = eventGeneric.getObject(0);
                if (object == this) {
                    NavigationMapServiceImpl.notifyClientUsedMapService(this.lockedMapService);
                    break;
                }
                NavigationMapServiceImpl.notifyClientUsedMapService(object);
                break;
            }
            case 3499093: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyGoogleEarthDataStatusChanged(n);
                break;
            }
            case 3499094: {
                NavigationMapServiceImpl.notifyMapViewerSwitchRunning(true);
                break;
            }
            case 3499045: {
                NavigationMapServiceImpl.notifyMapViewerSwitchRunning(false);
                break;
            }
            case 3400029: {
                int n = eventGeneric.getInt(0);
                ICMapServiceImpl.notifyUpdateMapSwitchState(n);
                break;
            }
            case 3499067: {
                ICMapServiceImpl.notifySwitchMapToAbt();
                break;
            }
            case 3499068: {
                ICMapServiceImpl.notifySwitchMapToKombi();
                break;
            }
            case 3499066: {
                ICMapServiceImpl.notifyUpdateNavigationMapInAbtVisibility(1);
                break;
            }
            case 3499065: {
                ICMapServiceImpl.notifyUpdateNavigationMapInAbtVisibility(0);
                break;
            }
            case 3499084: {
                int n = eventGeneric.getInt(0);
                ICMapServiceImpl.notifyUpdateICMapServiceState(n);
                break;
            }
            case 3491001: {
                int n = eventGeneric.getInt(0);
                NavigationSplitscreenServiceImpl.setCompassDegree(n);
                break;
            }
            case 3491002: {
                String string = eventGeneric.getString(0);
                NavigationSplitscreenServiceImpl.setCompassStreet(string);
                break;
            }
            case 3491003: {
                NavLocation navLocation = (NavLocation)eventGeneric.getObject(0);
                NavigationSplitscreenServiceImpl.setLocationInfo(navLocation);
                break;
            }
            case 3491004: {
                PosPosition posPosition = (PosPosition)eventGeneric.getObject(0);
                NavigationSplitscreenServiceImpl.setPositionInfo(posPosition);
                break;
            }
            case 3491006: {
                ASLManeuverViewElement[] aSLManeuverViewElementArray = (ASLManeuverViewElement[])eventGeneric.getObject(0);
                NavigationSplitscreenServiceImpl.setRMLInformation(aSLManeuverViewElementArray);
                break;
            }
            case 3491005: {
                ASLManeuverViewElement[] aSLManeuverViewElementArray = (ASLManeuverViewElement[])eventGeneric.getObject(0);
                NavigationSplitscreenServiceImpl.setRMLInformation(aSLManeuverViewElementArray);
                break;
            }
            case 3496009: {
                boolean bl = eventGeneric.getBoolean(0);
                NavigationMemoryServiceImpl.updateHomeAddressSetToCcpDone(bl);
                break;
            }
            case 3496010: {
                boolean bl = eventGeneric.getBoolean(0);
                NavigationMemoryServiceImpl.updateHomeAddressSetDone(bl);
                break;
            }
            case 3497029: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifysPNavCombinedCalculationState(n);
                break;
            }
            case 3497028: {
                boolean bl = eventGeneric.getBoolean(0);
                NavigationGuidanceServiceImpl.notifysPNavIsEnabled(bl);
                break;
            }
            case 3497025: {
                IPnavLikelyDestination[] iPnavLikelyDestinationArray = (ASLPnavLikelyDestination[])eventGeneric.getObject(0);
                NavigationGuidanceServiceImpl.notifysPNavLikelyDestinations(iPnavLikelyDestinationArray);
                break;
            }
            case 3497026: {
                ASLPnavLikelyDestination aSLPnavLikelyDestination = (ASLPnavLikelyDestination)eventGeneric.getObject(0);
                NavigationGuidanceServiceImpl.notifysPNavSelectedDestination(aSLPnavLikelyDestination);
                break;
            }
            case 3497027: {
                int n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifysPNavStatus(n);
                break;
            }
            case 3499075: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyHeadingValueChanged(n);
                break;
            }
            case 3499076: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyZoomValueChanged(n);
                break;
            }
            case 3491009: {
                int n = eventGeneric.getInt(0);
                NavigationSplitscreenServiceImpl.setOverlayCount(n);
                break;
            }
            case 3491008: {
                int n = eventGeneric.getInt(0);
                NavigationSplitscreenServiceImpl.setOverlayCurrentContent(n);
                break;
            }
            case 3491007: {
                IOverlayData iOverlayData = (IOverlayData)eventGeneric.getObject(0);
                NavigationSplitscreenServiceImpl.setOverlayData(iOverlayData);
                break;
            }
            case 3491010: {
                int n = eventGeneric.getInt(0);
                NavigationSplitscreenServiceImpl.setOverlayIndex(n);
                break;
            }
            case 3499077: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyAltitudeValueChanged(n);
                break;
            }
            case 3499078: {
                boolean bl = eventGeneric.getBoolean(0);
                NavigationMapServiceImpl.notifyAutozoomStatusChanged(bl);
                break;
            }
            case 3499080: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyOrientationChanged(n);
                break;
            }
            case 3499081: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyViewTypeChanged(n);
                break;
            }
            case 3499082: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyMapModeChanged(n);
                break;
            }
            case 3499085: {
                int n = eventGeneric.getInt(0);
                NavigationMapServiceImpl.notifyMapPerspectiveChanged(n);
                break;
            }
            case 3499083: {
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    NavigationMapServiceImpl.notifyMapType(1);
                    break;
                }
                NavigationMapServiceImpl.notifyMapType(2);
                break;
            }
            case 3497031: {
                ASLGuidanceVZAVZEIcons[] aSLGuidanceVZAVZEIconsArray = (ASLGuidanceVZAVZEIcons[])eventGeneric.getObject(0);
                NavigationGuidanceServiceImpl.notifyVZAVZEIcons(aSLGuidanceVZAVZEIconsArray);
                break;
            }
            case 3497032: {
                ASLGuidanceLaneGuidance[] aSLGuidanceLaneGuidanceArray = (ASLGuidanceLaneGuidance[])eventGeneric.getObject(0);
                NavigationGuidanceServiceImpl.notifyLaneGuidance(aSLGuidanceLaneGuidanceArray);
                break;
            }
            case 3497033: {
                boolean bl = eventGeneric.getBoolean(0);
                NavigationGuidanceServiceImpl.notifySpeedCameraWarningIcon(bl);
                break;
            }
            case 3497034: {
                int n;
                NavigationGuidanceServiceImpl.lastSatelliteSystem = n = eventGeneric.getInt(0);
                NavigationGuidanceServiceImpl.notifySatelliteSystem(n);
                break;
            }
            case 3499092: {
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    NavigationMapServiceImpl.notifyLastMapType(1);
                    break;
                }
                NavigationMapServiceImpl.notifyLastMapType(2);
                break;
            }
            case 3497035: {
                int n = eventGeneric.getInt(0);
                switch (n) {
                    case 0: {
                        n = 0;
                        break;
                    }
                    case 1: {
                        n = 1;
                        break;
                    }
                    default: {
                        n = 0;
                    }
                }
                NavigationGuidanceServiceImpl.notifySetupTrafficSignMode(n);
                break;
            }
        }
    }

    public boolean isMapServiceLockedByMe(NavigationMapServiceImpl navigationMapServiceImpl) {
        return navigationMapServiceImpl == this.lockedMapService;
    }

    public boolean isMapServiceLocked() {
        return this.lockedMapService != null;
    }

    public boolean isLocationinputServiceLockedByMe(NavigationLocationinputServiceImpl navigationLocationinputServiceImpl) {
        return navigationLocationinputServiceImpl == this.locationInputLockOwner;
    }

    public boolean isLocationinputServiceLocked() {
        return this.locationInputLockOwner != null;
    }

    public void acquireLocationinputLock(int n, INavServiceLockable iNavServiceLockable, boolean bl) {
        if (this.locationInputLockOwner == null) {
            this.locationInputLockOwner = iNavServiceLockable;
            this.isWeakLock = bl;
            if (!bl) {
                this.startTimer(75956480, (long)n, false);
            }
            iNavServiceLockable.updateLock(true);
        } else if (iNavServiceLockable == this.locationInputLockOwner) {
            if (!this.isWeakLock) {
                this.stopTimer(75956480);
            }
            this.isWeakLock = bl;
            if (!bl) {
                this.startTimer(75956480, (long)n, false);
            }
            iNavServiceLockable.updateLock(true);
        } else if (this.isWeakLock) {
            try {
                this.locationInputLockOwner.updateLock(false);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            this.locationInputLockOwner = iNavServiceLockable;
            try {
                iNavServiceLockable.updateLock(true);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            this.stopTimer(75956480);
            if (!bl) {
                this.startTimer(75956480, (long)n, false);
            }
            this.isWeakLock = bl;
        } else {
            iNavServiceLockable.updateLock(false);
            throw new NavigationServiceException("lock strong owned by other client");
        }
    }

    public void releaseLocationinputLock(INavServiceLockable iNavServiceLockable) {
        if (iNavServiceLockable == this.locationInputLockOwner) {
            this.locationInputLockOwner = null;
            if (!this.isWeakLock) {
                this.stopTimer(75956480);
            }
        } else {
            iNavServiceLockable.updateLock(false);
            throw new NavigationServiceException("lock not owned by this client");
        }
        iNavServiceLockable.updateLock(false);
    }

    @Override
    public int getNavigationServiceState() {
        return ASLNavigationStartupFactory.getNavigationStartupApi().isNaviRunning() ? this.extServiceState : 1;
    }

    @Override
    public NavigationGuidanceService getNavigationGuidanceService(NavigationGuidanceListener navigationGuidanceListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationGuidanceListener navigationGuidanceListener2 = (NavigationGuidanceListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceListener == null ? (class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListener")) : class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceListener, navigationGuidanceListener);
            NavigationGuidanceServiceImpl navigationGuidanceServiceImpl = new NavigationGuidanceServiceImpl(navigationGuidanceListener2, this);
            return (NavigationGuidanceService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceService == null ? (class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService")) : class$de$vw$mib$asl$api$navigation$guidance$NavigationGuidanceService, navigationGuidanceServiceImpl);
        }
        return new NavigationGuidanceServiceImpl(navigationGuidanceListener, this);
    }

    @Override
    public NavigationMemoryService getNavigationMemoryService(NavigationMemoryListener navigationMemoryListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationMemoryListener navigationMemoryListener2 = (NavigationMemoryListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryListener == null ? (class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener")) : class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryListener, navigationMemoryListener);
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = new NavigationMemoryServiceImpl(navigationMemoryListener2, this);
            return (NavigationMemoryService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryService == null ? (class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.memory.NavigationMemoryService")) : class$de$vw$mib$asl$api$navigation$memory$NavigationMemoryService, navigationMemoryServiceImpl);
        }
        return new NavigationMemoryServiceImpl(navigationMemoryListener, this);
    }

    @Override
    public NavigationLocationinputService getNavigationLocationinputService(NavigationLocationinputListener navigationLocationinputListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationLocationinputListener navigationLocationinputListener2 = (NavigationLocationinputListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputListener == null ? (class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener")) : class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputListener, navigationLocationinputListener);
            NavigationLocationinputServiceImpl navigationLocationinputServiceImpl = new NavigationLocationinputServiceImpl(navigationLocationinputListener2, this);
            return (NavigationLocationinputService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputService == null ? (class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService")) : class$de$vw$mib$asl$api$navigation$locationinput$NavigationLocationinputService, navigationLocationinputServiceImpl);
        }
        return new NavigationLocationinputServiceImpl(navigationLocationinputListener, this);
    }

    public NavigationMapService getNavigationMapService(NavigationMapListener navigationMapListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationMapListener navigationMapListener2 = (NavigationMapListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$map$NavigationMapListener == null ? (class$de$vw$mib$asl$api$navigation$map$NavigationMapListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.map.NavigationMapListener")) : class$de$vw$mib$asl$api$navigation$map$NavigationMapListener, navigationMapListener);
            NavigationMapServiceImpl navigationMapServiceImpl = new NavigationMapServiceImpl(navigationMapListener2, this);
            return (NavigationMapService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$map$NavigationMapService == null ? (class$de$vw$mib$asl$api$navigation$map$NavigationMapService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.map.NavigationMapService")) : class$de$vw$mib$asl$api$navigation$map$NavigationMapService, navigationMapServiceImpl);
        }
        return new NavigationMapServiceImpl(navigationMapListener, this);
    }

    public int getGuidanceState() {
        return this.guidanceState;
    }

    public int[] getCalculationStates() {
        return this.guidanceRcStates;
    }

    public int[] getCalculationProgress() {
        return this.guidanceRcProgress;
    }

    public int[] getCalculationRouteIds() {
        return this.guidanceRcRouteIds;
    }

    public void tryLockMapViwer(NavigationMapServiceImpl navigationMapServiceImpl) {
        if (!this.isMapServiceReady()) {
            throw new NavigationServiceException("map service not ready");
        }
        if (this.lockedMapService == null) {
            this.lockedMapService = navigationMapServiceImpl;
            this.mainMapService.lockMapViewer();
            return;
        }
        if (this.lockedMapService == navigationMapServiceImpl) {
            return;
        }
        throw new NavigationServiceException("map service already locked");
    }

    public void checkLockMapViewer(NavigationMapServiceImpl navigationMapServiceImpl) {
        if (!this.isMapServiceReady()) {
            throw new NavigationServiceException("map service not ready");
        }
        if (this.lockedMapService == navigationMapServiceImpl) {
            return;
        }
        throw new NavigationServiceException("map service not locked by you");
    }

    public void unlockMapViewer(NavigationMapServiceImpl navigationMapServiceImpl) {
        if (this.lockedMapService == navigationMapServiceImpl) {
            this.mainMapService.unlockMapViewer();
            if (this.lockedMapService.listener != null) {
                this.lockedMapService.listener.lockMapViewerResult(false);
            }
            this.lockedMapService = null;
            return;
        }
        throw new NavigationServiceException("map service not locked by you");
    }

    @Override
    public void registered(String string, int n) {
        if ((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().equals(string)) {
            if (!this.isFirstStartupDone) {
                this.initDsiNavigation();
            }
        } else if ((class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName().equals(string)) {
            if (!this.isFirstStartupDone) {
                this.initDsiAsiaTrafficInfoMenu();
            }
        } else if ((class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().equals(string)) {
            if (!this.isFirstStartupDone) {
                this.initDsiTmc();
            }
        } else if ((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().equals(string) && !this.isFirstStartupDone) {
            this.initDsiTmcOnRoute();
        }
        if (this.dsiNavigation != null && this.dsiAsiaTrafficInfoMenu != null && this.dsiTmc != null && this.dsiTmcOnRoute != null) {
            this.isFirstStartupDone = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        int n2 = this.extServiceState;
        if ((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().equals(string)) {
            n2 = 1;
        } else if ((class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName().equals(string)) {
            n2 = 1;
        } else if ((class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().equals(string)) {
            n2 = 1;
        } else if ((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName().equals(string)) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener, this.dsiListnerTmcOnRoute);
            n2 = 1;
        }
        if (this.extServiceState != n2) {
            this.extServiceState = n2;
            ASLNavigationAPIImpl.notifyNavServiceStateListeners();
        }
    }

    public void initDsiTmcOnRoute() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTmcOnRoute = (DSITmcOnRoute)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute);
        this.dsiListnerTmcOnRoute = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener);
        this.dsiTmcOnRoute.setNotification(ATTRIBUTES_TMC_ON_ROUTE, this.dsiListnerTmcOnRoute);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener, this.dsiListnerTmcOnRoute);
    }

    public void initDsiTmc() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTmc = (DSITmc)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener);
        this.dsiTmc.setNotification(ATTRIBUTES_TMC, dSIListener);
    }

    public void initDsiAsiaTrafficInfoMenu() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAsiaTrafficInfoMenu = (DSIAsiaTrafficInfoMenu)dSIProxy.getService(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener);
        this.dsiAsiaTrafficInfoMenu.setNotification(7, dSIListener);
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiNavigation.setNotification(8, dSIListener);
    }

    public void dsiNavigationUpdateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        if (lDListElementArray == null) {
            lDListElementArray = new LDListElement[]{};
        }
        if (n == 1) {
            INavigationListElement[] iNavigationListElementArray = new INavigationListElement[lDListElementArray.length];
            for (int i2 = 0; i2 < lDListElementArray.length; ++i2) {
                iNavigationListElementArray[i2] = new INavigationListElementImpl(lDListElementArray[i2]);
            }
            this.lastDestinations = iNavigationListElementArray;
            NavigationMemoryServiceImpl.notifyLastDestinations(this.lastDestinations);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateReceivableStations(TunerData[] tunerDataArray, int n) {
        INavigationTunerData[] iNavigationTunerDataArray;
        INavigationTunerData[] iNavigationTunerDataArray2 = iNavigationTunerDataArray = tunerDataArray != null ? new INavigationTunerData[tunerDataArray.length] : new INavigationTunerData[]{};
        if (tunerDataArray != null) {
            for (int i2 = 0; i2 < iNavigationTunerDataArray.length; ++i2) {
                iNavigationTunerDataArray[i2] = new INavigationTunerDataImpl(tunerDataArray[i2].getStationName(), tunerDataArray[i2].getFrequency());
            }
        }
        NavigationTrafficServiceImpl.updateReceivableStations(iNavigationTunerDataArray, n == 1);
    }

    public void dsiTmcUpdateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
        ITrafficSource[] iTrafficSourceArray;
        if (n != 1) {
            return;
        }
        ITrafficSource[] iTrafficSourceArray2 = iTrafficSourceArray = trafficSourceArray != null ? new ITrafficSource[trafficSourceArray.length] : new ITrafficSource[]{};
        if (trafficSourceArray != null) {
            for (int i2 = 0; i2 < iTrafficSourceArray.length; ++i2) {
                iTrafficSourceArray[i2] = new ITrafficSourceImpl(trafficSourceArray[i2].getTrafficSourceName(), trafficSourceArray[i2].getTrafficSourceState(), trafficSourceArray[i2].getTrafficSourceType());
            }
        }
        NavigationTrafficServiceImpl.updateTrafficSourceInformation(iTrafficSourceArray, n == 1);
    }

    public void dsiTmcOnRouteUpdateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
        ITmcMessage[] iTmcMessageArray;
        if (n != 1) {
            ServiceManager.logger.warn(16, "dsiTmcOnRouteUpdateUrgentMessages() - Invalid DSI update.");
            return;
        }
        ITmcMessage[] iTmcMessageArray2 = iTmcMessageArray = tmcMessageArray != null ? new ITmcMessage[tmcMessageArray.length] : new ITmcMessage[]{};
        if (tmcMessageArray != null) {
            for (int i2 = 0; i2 < iTmcMessageArray.length; ++i2) {
                iTmcMessageArray[i2] = new ITmcMessageImpl(tmcMessageArray[i2]);
            }
        }
        NavigationTrafficServiceImpl.updateUrgentMessages(iTmcMessageArray, n == 1);
    }

    public void dsiTmcOnRouteIndicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        if (tmcMessage != null) {
            ITmcMessageImpl iTmcMessageImpl = new ITmcMessageImpl(tmcMessage);
            INavRectangleImpl iNavRectangleImpl = new INavRectangleImpl(navRectangle.getXLeft(), navRectangle.getXRight(), navRectangle.getYBottom(), navRectangle.getYUp(), navRectangle.isRectangleInvalid());
            NavigationTrafficServiceImpl.indicateTrafficEventNoticeMap(iTmcMessageImpl, iNavRectangleImpl, n);
        } else {
            ServiceManager.logger.warn(16, "dsiTmcOnRouteIndicateTrafficEventNoticeMap() - Message was null.");
        }
    }

    public boolean isMapServiceReady() {
        return ASLNavigationMapFactory.getNavigationMapApi().isMainMapReady();
    }

    public NavigationTrafficService getNavigationTrafficService(NavigationTrafficListener navigationTrafficListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationTrafficListener navigationTrafficListener2 = (NavigationTrafficListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficListener == null ? (class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener")) : class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficListener, navigationTrafficListener);
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = new NavigationTrafficServiceImpl(navigationTrafficListener2, this);
            return (NavigationTrafficService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficService == null ? (class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService")) : class$de$vw$mib$asl$api$navigation$traffic$NavigationTrafficService, navigationTrafficServiceImpl);
        }
        return new NavigationTrafficServiceImpl(navigationTrafficListener, this);
    }

    public NavigationOnlinePoiService getNavigationOnlinePoiService(NavigationOnlinePoiListener navigationOnlinePoiListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationOnlinePoiListener navigationOnlinePoiListener2 = (NavigationOnlinePoiListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiListener == null ? (class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener")) : class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiListener, navigationOnlinePoiListener);
            NavigationOnlinePoiServiceImpl navigationOnlinePoiServiceImpl = new NavigationOnlinePoiServiceImpl(navigationOnlinePoiListener2, this);
            return (NavigationOnlinePoiService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiService == null ? (class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService")) : class$de$vw$mib$asl$api$navigation$poi$online$NavigationOnlinePoiService, navigationOnlinePoiServiceImpl);
        }
        return new NavigationOnlinePoiServiceImpl(navigationOnlinePoiListener, this);
    }

    public NavigationOnboardPoiService getNavigationOnboardPoiService(NavigationOnboardPoiListener navigationOnboardPoiListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationOnboardPoiListener navigationOnboardPoiListener2 = (NavigationOnboardPoiListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiListener == null ? (class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener")) : class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiListener, navigationOnboardPoiListener);
            NavigationOnboardPoiServiceImpl navigationOnboardPoiServiceImpl = new NavigationOnboardPoiServiceImpl(navigationOnboardPoiListener2, this);
            return (NavigationOnboardPoiService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiService == null ? (class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService")) : class$de$vw$mib$asl$api$navigation$poi$onboard$NavigationOnboardPoiService, navigationOnboardPoiServiceImpl);
        }
        return new NavigationOnboardPoiServiceImpl(navigationOnboardPoiListener, this);
    }

    public NavigationSplitscreenService getNavigationSplitscreenService(NavigationSplitscreenListener navigationSplitscreenListener) {
        if (LoggingProxy.useLoggingProxy()) {
            NavigationSplitscreenListener navigationSplitscreenListener2 = (NavigationSplitscreenListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenListener == null ? (class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListener")) : class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenListener, navigationSplitscreenListener);
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = new NavigationSplitscreenServiceImpl(navigationSplitscreenListener2, this);
            return (NavigationSplitscreenService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenService == null ? (class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService")) : class$de$vw$mib$asl$api$navigation$splitscreen$NavigationSplitscreenService, navigationSplitscreenServiceImpl);
        }
        return new NavigationSplitscreenServiceImpl(navigationSplitscreenListener, this);
    }

    public void checkLockLocationInput(INavServiceLockable iNavServiceLockable) {
        if (this.locationInputLockOwner == iNavServiceLockable) {
            return;
        }
        throw new NavigationServiceException("li service not locked by you");
    }

    @Override
    public void navStartupStatusChanged() {
        if (this.getNavigationServiceState() != this.lastNavigationServiceState) {
            ASLNavigationAPIImpl.notifyNavServiceStateListeners();
            this.lastNavigationServiceState = this.getNavigationServiceState();
        }
    }

    public ICMapService getICMapService(ICMapListener iCMapListener) {
        if (LoggingProxy.useLoggingProxy()) {
            ICMapListener iCMapListener2 = (ICMapListener)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapListener == null ? (class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapListener = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener")) : class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapListener, iCMapListener);
            ICMapServiceImpl iCMapServiceImpl = new ICMapServiceImpl(iCMapListener2, this);
            return (ICMapService)LoggingProxy.createLoggingProxyInstance(class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapService == null ? (class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapService = NavigationExtServiceImpl.class$("de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService")) : class$de$vw$mib$asl$api$navigation$map$instrumentcluster$ICMapService, iCMapServiceImpl);
        }
        return new ICMapServiceImpl(iCMapListener, this);
    }

    public int getMapSwitchState() {
        return this.mainMapService == null ? 0 : this.mainMapService.getMapSwitchState();
    }

    public boolean getMapVisibilityForFPKSwitch() {
        return this.mainMapService == null ? false : this.mainMapService.getMapVisibilityForFPKSwitch();
    }

    public int getICMapServiceState() {
        return this.mainMapService == null ? 0 : this.mainMapService.getICMapServiceState();
    }

    public boolean isMapSwitchFunctionAvailableInKombi() {
        return this.mainMapService == null ? false : this.mainMapService.isMapSwitchFunctionAvailableInKombi();
    }

    public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
        this.mainMapService.setMapSwitchFunctionAvailableInKombi(bl);
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName(), 0) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), 0) || this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("NavigationExtServiceImpl: resetting values after DSI restart");
            }
            this.releaseAllLocks();
            this.initLocalVariables();
            if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavigationExtServiceImpl.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
                this.initDsiNavigation();
            }
            if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = NavigationExtServiceImpl.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName(), 0)) {
                this.initDsiAsiaTrafficInfoMenu();
            }
            if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), 0)) {
                this.initDsiTmc();
            }
            if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = NavigationExtServiceImpl.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0)) {
                this.initDsiTmcOnRoute();
            }
            this.extServiceState = 100;
            ASLNavigationAPIImpl.notifyNavServiceStateListeners();
        } else if (this.isTraceEnabled()) {
            this.trace("NavigationExtServiceImpl: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.guidanceState = 0;
        this.guidanceRcRouteIds = null;
        this.guidanceRcStates = null;
        this.guidanceRcProgress = null;
    }

    private void releaseAllLocks() {
        if (this.locationInputLockOwner != null) {
            try {
                this.releaseLocationinputLock(this.locationInputLockOwner);
            }
            catch (NavigationServiceException navigationServiceException) {
                this.error("NavigationExtServiceImpl: error releaseing the lock for current location input lock owner");
            }
        }
        if (this.lockedMapService != null) {
            try {
                this.unlockMapViewer(this.lockedMapService);
            }
            catch (NavigationServiceException navigationServiceException) {
                this.error("NavigationExtServiceImpl: error releaseing the lock for current map lock owner");
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public boolean isMapTemporarilyInABT() {
        return this.mainMapService.isMapTemporarilyInABT();
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
        ATTRIBUTES_TMC = new int[]{16};
        ATTRIBUTES_TMC_ON_ROUTE = new int[]{2};
        MAIN_MAP_SERVICE_IDS = new int[]{1273049856, 1306604288, 1323381504, 1340158720, 1373713152, 1356935936, 1390490368, 1407267584, 1424044800, 1440822016, 1457599232, 1524708096, 1507930880, 1491153664, 1575039744, 996422912, 1013200128, 962868480, 979645696, 1147417856, 1130640640, 1180972288, 1164195072, 1231303936, 1214526720, 1298412800, 1248081152, 1230517504, 1247294720, 1591816960, 1264858368, 1415853312, 1281635584, 1432630528, 1449407744, 627324160};
    }
}

