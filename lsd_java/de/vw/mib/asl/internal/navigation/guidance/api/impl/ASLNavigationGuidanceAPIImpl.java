/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.api.impl;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IOnlineTourImportListener;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.guidance.IPersistedRouteOptionsSetup;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryFactory;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslHsmTargetDelegator;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslTargetDelegator;
import de.vw.mib.asl.api.navigation.startup.NaviResettableTargetDelegator;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.adjustposition.TargetAdjustPosition;
import de.vw.mib.asl.internal.navigation.borderchange.HsmTargetBorderChange;
import de.vw.mib.asl.internal.navigation.destinput.HsmTargetDestList;
import de.vw.mib.asl.internal.navigation.destinput.PersistedDestInputSetup;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.asl.internal.navigation.guidance.congestion.HsmTargetCongestionAhead;
import de.vw.mib.asl.internal.navigation.guidance.info.HsmTargetInfo;
import de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.asl.internal.navigation.guidance.ppoi.proximity.TargetPPOIApproach;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;
import de.vw.mib.asl.internal.navigation.pnav.TargetPredictiveNavigationSplitscreen;
import de.vw.mib.asl.internal.navigation.routeoptions.HsmTargetRouteOptions;
import de.vw.mib.asl.internal.navigation.routeoptions.PersistableRouteOptionsSetup;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.asl.internal.navigation.tourmode.TargetTourMemory;
import de.vw.mib.asl.internal.navigation.tourmode.TargetTourView;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmPersistence;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.util.RouteHelper;

public class ASLNavigationGuidanceAPIImpl
extends ValetParkingListenerAdapter
implements ASLNavigationGuidanceAPI,
ASLNavigationContainer {
    private IExtLogger LOGGER = null;
    ASLNavGuidanceDP aslNavGuidanceDP = ASLNavGuidanceDP.getInstance();
    INavigationDP navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private boolean isRecalculation = false;
    private TargetTourMemory targetTourMemory;

    public ASLNavigationGuidanceAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
        ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(1, new HsmTargetRouteOptions(genericEvents, 1716196352, string));
        this.targetTourMemory = new TargetTourMemory(genericEvents, -2075454464, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, this.targetTourMemory);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetTourView(genericEvents, -2092231680, string), string));
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(109)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new HsmTargetBorderChange(genericEvents, 2135626752, string), string));
        } else if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ASL_NAVI_BORDER_CHANGE target not started, because feature flag is disabled.");
            logMessage.log();
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslHsmTargetDelegator(new HsmTargetDestList(genericEvents, 1531646976, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetGuidance(genericEvents, 1917522944, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslHsmTargetDelegator(new HsmTargetLaneGuidance(genericEvents, 1951077376, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetWayPointMode(genericEvents, 1397429248, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslHsmTargetDelegator(new HsmTargetAudio(genericEvents, 1665864704, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetInfo(genericEvents, 1682641920, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetVZA(genericEvents, 1766528000, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableTargetDelegator(new TargetAdjustPosition(genericEvents, -1924459520, string), string));
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(148) || ServiceManager.configManagerDiag.isFeatureFlagSet(158)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetPPOIApproach(genericEvents, -968158208, string), string));
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetCongestionAhead(genericEvents, -2008345600, string));
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(144)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new TargetPredictiveNavigationSplitscreen(genericEvents, -934603776, string));
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(159) || ServiceManager.configManagerDiag.isFeatureFlagSet(166)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new JPNWarningSetupHsmTarget(genericEvents, -733277184, string));
        }
        this.updateCalculationState(new ASLCalculationState[]{new ASLCalculationState()});
        this.updateErrorState(0);
        this.updateGuidanceState(0);
        this.updateGuidanceMode(0);
    }

    @Override
    public int getPnavStatus() {
        return ASLNavGuidanceDP.getInstance().getPnavStatus();
    }

    @Override
    public boolean isDemomodeActive() {
        return PersistedGuidanceSetup.getInstance().isDemoMode();
    }

    @Override
    public void setDemoDest(NavLocation navLocation) {
        PersistedDestInputSetup.getInstance().setDemoDest(navLocation);
    }

    @Override
    public NavLocation getDemoDest() {
        return PersistedDestInputSetup.getInstance().getDemoDest();
    }

    @Override
    public IPersistedDestInputSetup getDestInputSetup() {
        return PersistedDestInputSetup.getInstance();
    }

    @Override
    public IPersistedGuidanceSetup getGuidanceSetup() {
        return PersistedGuidanceSetup.getInstance();
    }

    @Override
    public RouteOptions[] getSingleRouteOptions() {
        return RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getSingleRouteOptions();
    }

    @Override
    public void setHmiAlternativeRouteCalculation(boolean bl) {
        RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getPersistableRouteOptionsAccessor().setHmiAlternativeRouteCalculation(PersistableRouteOptionsSetup.getInstance(), bl);
    }

    @Override
    public boolean isAlternativeRouteCalculation() {
        return RouteOptionServices.ROUTE_OPTIONS_PROVIDER.isAlternativeRouteCalculation();
    }

    @Override
    public void sendEvNaviMapMainGuidanceSetupStatusLineInformation(boolean bl) {
        this.getLOGGER().trace("sendEvNaviGuidanceSetupStatusLineInformation()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(727463168);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainRubberbandManipulationCancel() {
        this.getLOGGER().trace("sendEvMapMainRubberbandManipulationCancel()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(693908736);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainRubberbandManipulationStart() {
        this.getLOGGER().trace("sendEvMapMainRubberbandManipulationStart()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(744240384);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainRubberbandManipulationStartCalculatedRoute(int n) {
        this.getLOGGER().trace("sendEvMapMainRubberbandManipulationStartCalculatedRoute()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(710685952);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[ASLNavigationGuidanceAPIImpl]");
        }
        return this.LOGGER;
    }

    private boolean isCalculating() {
        ASLCalculationState[] aSLCalculationStateArray = this.aslNavGuidanceDP.getCalculationState();
        return aSLCalculationStateArray != null && aSLCalculationStateArray.length > 0 && aSLCalculationStateArray[0].getCalculationState() != 0;
    }

    @Override
    public void calculateRoute(NavLocation[] navLocationArray, boolean bl) {
        this.getLOGGER().trace("calculateRoute(NavLocation[], isDemo)");
        if (!this.isCalculating() && this.aslNavGuidanceDP.getGuidanceState() == 0) {
            if (!this.navigationDP.isWpmActive()) {
                if (navLocationArray != null && navLocationArray.length > 0) {
                    Route route = new Route();
                    for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
                        if (!navLocationArray[i2].isPositionValid()) continue;
                        RouteDestination routeDestination = new RouteDestination();
                        routeDestination.setRouteLocation(navLocationArray[i2]);
                        RouteHelper.addDestinationAtPosition(route, routeDestination, i2);
                    }
                    this.calculateRoute(route, bl);
                } else {
                    this.updateErrorState(2);
                }
            } else {
                this.updateErrorState(6);
            }
        } else {
            this.updateErrorState(1);
        }
    }

    @Override
    public void calculateRoute(Route route, boolean bl) {
        this.getLOGGER().trace("calculateRoute(Route, isDemo)");
        if (!this.isCalculating() && this.aslNavGuidanceDP.getGuidanceState() == 0) {
            if (!this.navigationDP.isWpmActive()) {
                if (route.getRoutelist() != null && route.getRoutelist().length > 0) {
                    this.navigationDP.setTourmodeRoute(route);
                    EventGeneric eventGeneric = !bl ? (this.isRecalculation ? ASLNavigationEventFactory.createEvent(176619776) : ASLNavigationEventFactory.createEvent(126288128)) : (this.isRecalculation ? ASLNavigationEventFactory.createEvent(193396992) : ASLNavigationEventFactory.createEvent(143065344));
                    ASLNavigationEventFactory.sendEventToTarget(1917522944, 1917522944, eventGeneric);
                } else {
                    this.updateErrorState(2);
                }
            } else {
                this.updateErrorState(6);
            }
        } else {
            this.updateErrorState(1);
        }
        this.isRecalculation = false;
    }

    @Override
    public void calculateRouteWithConfirmation(Route route, int n) {
        this.getLOGGER().trace(new StringBuffer().append("calculateRouteWithConfirmation(route =").append(route).append(", source = ").append(n).append(")").toString());
        if (n == 7 || n == 2 || n == 5 || n == 3 || !this.navigationDP.isWpmActive()) {
            if (n == 7 || n == 2 || n == 5 || n == 3 || !this.isCalculating() && this.aslNavGuidanceDP.getGuidanceState() == 0) {
                if (route != null && route.routelist != null && route.routelist.length > 0) {
                    NavLocation navLocation = route.routelist[route.routelist.length - 1].getRouteLocation();
                    if (navLocation != null && navLocation.isPositionValid()) {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(-1678766080, true);
                        ASLNavGuidanceDP.getInstance().setTourBackup(route);
                        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                        INavigationDP iNavigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
                        iNavigationDP.setTourmodeRoute(route);
                        iNavigationDP.setMemoryLocation(iLocationWrapper.getLocation());
                        iNavigationDP.setMemoryLocationIsTopDest(false);
                        iNavigationDP.setSaveCorrectedAddressToEntry(false);
                        int n2 = 25;
                        MapConfiguration mapConfiguration = new MapConfiguration(iLocationWrapper.getLocation(), n2, 0);
                        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(5, mapConfiguration);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(891, false);
                        ServiceManager.aslPropertyManager.valueChangedInteger(1542459392, this.getSourceContext(n));
                        ServiceManager.aslPropertyManager.valueChangedBoolean(895, false);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(896, false);
                        int n3 = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
                        String string = ServiceManager.fixFormat4Asl.fmtRulesetBasedString(10 + n3, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper));
                        ServiceManager.aslPropertyManager.valueChangedString(887, string);
                        ASLNavigationMemoryFactory.getNavigationMemoryApi().setDestinationDetails(iLocationWrapper, string);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(902, !iLocationWrapper.isNavigable());
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-235991040);
                    } else {
                        this.getLOGGER().trace("no final destination available");
                        INavigationDP iNavigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
                        if (navLocation != null) {
                            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                            iNavigationDP.setMemoryLocation(iLocationWrapper.getLocation());
                        } else {
                            iNavigationDP.setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
                        }
                        ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-235991040);
                        this.updateErrorState(2);
                    }
                } else {
                    this.getLOGGER().trace("no destinations available");
                    INavigationDP iNavigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
                    iNavigationDP.setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
                    ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-235991040);
                    this.updateErrorState(2);
                }
            } else {
                this.getLOGGER().trace("Calculation or guidance already active -> needs to be stopped before");
                this.updateErrorState(1);
            }
        } else {
            this.getLOGGER().trace("Waypoint mode is active and must be left before another guidance can be started");
            this.updateErrorState(6);
        }
    }

    private int getSourceContext(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
        }
        return 0;
    }

    @Override
    public void recalculateRoute(Route route, boolean bl) {
        this.isRecalculation = true;
        this.calculateRoute(route, bl);
    }

    @Override
    public void startGuidanceCalculatedRoute(int n) {
        this.getLOGGER().trace("startGuidanceCalculatedRoute()");
        ASLCalculationState[] aSLCalculationStateArray = this.aslNavGuidanceDP.getCalculationState();
        if (this.isCalculating()) {
            if (n < aSLCalculationStateArray.length) {
                if (aSLCalculationStateArray[n].getCalculationState() == 2) {
                    EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(0x22020040);
                    eventGeneric.setInt(0, n);
                    ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
                } else {
                    this.updateErrorState(3);
                }
            } else {
                this.updateErrorState(4);
            }
        } else {
            this.updateErrorState(4);
        }
    }

    @Override
    public void stopGuidance() {
        this.getLOGGER().trace("stopGuidance()");
        if (this.aslNavGuidanceDP.getGuidanceState() == 1) {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(0x24020040);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        } else {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(100794432);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        }
    }

    @Override
    public int getGuidanceState() {
        return this.aslNavGuidanceDP.getGuidanceState();
    }

    @Override
    public ASLCalculationState[] getCalculationState() {
        return this.aslNavGuidanceDP.getCalculationState();
    }

    @Override
    public int getGuidanceMode() {
        return this.aslNavGuidanceDP.getGuidanceMode();
    }

    @Override
    public Route getCurrentRoute() {
        return this.aslNavGuidanceDP.getCurrentRoute();
    }

    private void updateErrorState(int n) {
        this.aslNavGuidanceDP.setErrorState(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(794572032);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void updateGuidanceState(int n) {
        this.aslNavGuidanceDP.setGuidanceState(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(777794816);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void updateCalculationState(ASLCalculationState[] aSLCalculationStateArray) {
        this.aslNavGuidanceDP.setCalculationState(aSLCalculationStateArray);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(761017600);
        eventGeneric.setObject(0, aSLCalculationStateArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void updateGuidanceMode(int n) {
        this.aslNavGuidanceDP.setGuidanceMode(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(811349248);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void leaveWaypointMode() {
        if (this.aslNavGuidanceDP.getGuidanceMode() == 1) {
            this.setExecutionMode(0);
        }
    }

    @Override
    public int getExecutionMode() {
        return WpmPersistence.getInstance().getExecutionMode();
    }

    @Override
    public void setExecutionMode(int n) {
        this.getLOGGER().trace("setExecutionMode()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1493893184);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public int getTimeFormat() {
        this.getLOGGER().trace("getTimeFormat()");
        return PersistedGuidanceSetup.getInstance().getDpGuidanceTimeFormat();
    }

    @Override
    public int getMaxNumberOfDestinations() {
        this.getLOGGER().trace("getMaxNumberOfDestinations()");
        return ServiceManager.configManagerDiag.getNaviCommonOptionDefault(3);
    }

    @Override
    public int getNumberOfDestinations() {
        this.getLOGGER().trace("getNumberOfDestinations()");
        Route route = this.getCurrentRoute();
        if (route != null && route.routelist != null) {
            return route.routelist.length;
        }
        return 0;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.getLOGGER().trace("notifyValetParkingStateChanged()");
        if (bl) {
            this.getLOGGER().trace("Valet parking is active -> stop guidance if active");
            this.stopGuidance();
        }
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }

    @Override
    public IPersistedRouteOptionsSetup getRouteOptionsSetup() {
        return PersistableRouteOptionsSetup.getInstance();
    }

    @Override
    public NavRmRouteListArrayData getNavRmRouteList() {
        return ASLNavGuidanceDP.getInstance().getNavRmRouteList();
    }

    @Override
    public void importToursFromGpx(String string) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(92733696);
        eventGeneric.setString(0, string);
        this.targetTourMemory.triggerMe(eventGeneric, 92733696);
    }

    @Override
    public void sendEvTourModeOnlineImportMemFull() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(109510912);
        this.targetTourMemory.triggerMe(eventGeneric, 109510912);
    }

    @Override
    public void sendEvTourModeOnlineImportAvailable() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(126288128);
        this.targetTourMemory.triggerMe(eventGeneric, 126288128);
    }

    @Override
    public void registerListener(IOnlineTourImportListener iOnlineTourImportListener) {
        TargetTourMemory.registerListener(iOnlineTourImportListener);
    }

    @Override
    public void unregisterListener(IOnlineTourImportListener iOnlineTourImportListener) {
        TargetTourMemory.unregisterListener(iOnlineTourImportListener);
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(210174208);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToTarget(1917522944, 1917522944, eventGeneric);
    }

    @Override
    public Integer getCalculatedTourMemoryCapacity() {
        return this.targetTourMemory.getCalculatedTourMemoryCapacity();
    }

    @Override
    public void startGuidancePNAVRoute(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(868814912);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void setPNAVStatus(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(75956480);
        eventGeneric.setInt(TargetPredictiveNavigationSplitscreen.EV_NAVI_GUIDANCE_SET_PNAV_STATUS_EXTERNAL__P0_INT, n);
        ASLNavigationEventFactory.sendEventToTarget(-934603776, -934603776, eventGeneric);
    }

    @Override
    public int getSetupTrafficSignMode() {
        int n = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup().getHmiTrafficSignMode();
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
        return n;
    }
}

