/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.routeoptions.Events;
import de.vw.mib.asl.internal.navigation.routeoptions.HsmTargetRouteOptions;
import de.vw.mib.asl.internal.navigation.routeoptions.PersistableRouteOptionsSetup;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionsProvider;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessor;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.RouteOptions;

public class StateRouteOptionsWork
extends AbstractHsmState
implements DSIServiceStateListener,
ReloadPersistedDataListener,
TargetForResetNavigation {
    private HsmTargetRouteOptions target;
    private PersistableRouteOptionsSetup persistableRouteOptionsSetup;
    private PersistableRouteOptionsAccessor routeOptionsAccessor;
    private boolean isRouteOptionsChanged = false;
    private boolean stoppingGuidanceOngoing = false;
    private boolean isServiceStateListenerAdded = false;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private boolean trailerDetectionAvailable = false;
    private boolean considerTrailer = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;

    StateRouteOptionsWork(HsmTargetRouteOptions hsmTargetRouteOptions, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetRouteOptions;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState("HSM_ENTRY");
                if (this.navigationResetParticipant != null) break;
                this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                break;
            }
            case 3: {
                this.target.traceState("HSM_START");
                break;
            }
            case 4: {
                this.target.traceState("HSM_EXIT");
                Events.removeObservers(this.target);
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 101001: {
                this.target.traceState("NAVI_TARGET_GO_ON");
                this.init();
                Events.addObservers(this.target);
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StateRouteOptionsWork.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = StateRouteOptionsWork.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc, this);
                }
                this.sendRouteOptionsToDsi();
                this.sendTmcStatisticalDataToDsi();
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
                break;
            }
            case 1073742531: {
                this.target.traceState("ALTERNATIVE_ROUTE_CALC_TOGGLE");
                this.setAltenativeRouteCalculation(!this.persistableRouteOptionsSetup.getAlternativeRouteCalculation());
                break;
            }
            case 1073742270: {
                this.target.traceState("SET_ALTERNATIVE_ROUTE_CALC_SETTING");
                this.setAltenativeRouteCalculation(eventGeneric.getBoolean(0));
                break;
            }
            case 1073742533: {
                this.target.traceState("DYN_ROUTE_SET");
                this.setDynamicRouteCalculation(eventGeneric.getInt(0));
                break;
            }
            case 1073742535: {
                this.target.traceState("ROAD_TYPES_TOGGLE");
                this.toggleRoadType(eventGeneric.getInt(0));
                break;
            }
            case 0x40000222: {
                this.target.traceState("START_SELECTED_ROUTE");
                break;
            }
            case 1073742536: {
                this.target.traceState("ROUTE_CALC_SET");
                int n = eventGeneric.getInt(0);
                this.setRouteCalculationType(n, true);
                break;
            }
            case 1073742539: {
                this.target.traceState("VOICE_PROMPTS_DYN_ROUTE");
                break;
            }
            case 1073742559: {
                this.target.traceState("ROUTE_OPTIONS_SAVE");
                this.handleRouteOptionsSave();
                break;
            }
            case 1073742534: {
                this.target.traceState("INIT_VIGNETTE_COUNTRY_LIST");
                this.persistableRouteOptionsSetup.dsiVignetteList.startDSISpeller();
                break;
            }
            case 1073742538: {
                this.target.traceState("TOGGLE_VIGNETTE_COUNTRY_ENTRY");
                this.persistableRouteOptionsSetup.dsiVignetteList.toggleIndex(eventGeneric.getInt(0));
                this.isRouteOptionsChanged = true;
                break;
            }
            case 1074841931: {
                this.target.traceState("SET_USE_HOV_LANES");
                this.setHOVUsage(eventGeneric.getBoolean(0));
                break;
            }
            case 2100010: {
                this.target.traceState("ASL_CAR_TRAFFIC_SIGN_TRAILER_ASSIST");
                this.handleTrafficSignTrailerAssist(eventGeneric);
                break;
            }
            case 1074841938: {
                this.target.traceState("SET_CONSIDER_TRAILER");
                this.handleSetConsiderTrailer(eventGeneric);
                break;
            }
            case 2100019: {
                this.target.traceState("ASL_CAR_TRAFFIC_SIGN_TRAILER_DETECTION_AVAILABLE");
                this.trailerDetectionAvailable = eventGeneric.getBoolean(0);
                this.setTrailerStatusInRouteOptions();
                break;
            }
            case 1074841948: {
                this.target.traceState("SET_CONSIDER_SEASONAL_RESTRICTIONS");
                this.handleSeasonalRestrictions(eventGeneric);
                break;
            }
            case 1074841949: {
                this.target.traceState("SET_CONSIDER_STATISTICAL_DATA");
                this.handleStatisticalData(eventGeneric);
                break;
            }
            default: {
                if (this.target.isTraceEnabled()) {
                    this.target.traceState(new StringBuffer().append("Target Navigation.RouteOptions entered DEFAULT event with ID:").append(eventGeneric.getReceiverEventId()).toString());
                }
                hsmState = this.target.getWorkStateParent();
            }
        }
        return hsmState;
    }

    private void handleStatisticalData(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        this.routeOptionsAccessor.setStatisticalData(this.persistableRouteOptionsSetup, bl);
        this.sendTmcStatisticalDataToDsi();
        this.isRouteOptionsChanged = true;
    }

    private void handleSeasonalRestrictions(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        this.routeOptionsAccessor.setSeasonalRestrictions(this.persistableRouteOptionsSetup, bl);
        this.isRouteOptionsChanged = true;
    }

    @Override
    public void registered(String string, int n) {
        this.target.registerDsiServices(string, n);
    }

    @Override
    public void unregistered(String string, int n) {
        this.target.unregisterDsiServices(string, n);
    }

    private void handleTrafficSignTrailerAssist(EventGeneric eventGeneric) {
        this.considerTrailer = eventGeneric.getBoolean(0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1796206592, this.considerTrailer);
        this.setTrailerStatusInRouteOptions();
    }

    private void handleSetConsiderTrailer(EventGeneric eventGeneric) {
        this.considerTrailer = eventGeneric.getBoolean(0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1796206592, this.considerTrailer);
        this.setTrailerStatusInRouteOptions();
        EventGeneric eventGeneric2 = ASLNavigationEventFactory.createEvent(1558262528);
        eventGeneric2.setBoolean(0, this.considerTrailer);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric2);
    }

    private void setTrailerStatusInRouteOptions() {
        boolean bl;
        boolean bl2 = this.routeOptionsAccessor.getTrailerMode(this.persistableRouteOptionsSetup);
        boolean bl3 = bl = this.considerTrailer && this.trailerDetectionAvailable;
        if (bl != bl2) {
            this.target.traceState("Set trailer status.");
            this.routeOptionsAccessor.setTrailerMode(this.persistableRouteOptionsSetup, bl);
            this.isRouteOptionsChanged = true;
            this.handleRouteOptionsSave();
        } else {
            this.target.traceState("Trailer status will not be set, because the value hasn't changed.");
        }
    }

    public void dsiNavigationLiResult(long l) {
        this.target.traceState("dsiNavigationLiResult()");
        if (l != 0L) {
            this.target.warn("Target Navigation.Routeoptions - Country Vignette could not be loaded, recieved NOK from speller.");
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState("dsiNavigationUpdateRgActive()");
        if (this.stoppingGuidanceOngoing && !bl) {
            this.target.trace("Target Navigation.RouteOptions guidance was active and is now stopped. Sending RouteOptions to DSI.");
            this.stoppingGuidanceOngoing = false;
            this.sendRouteOptionsToDsi();
        }
    }

    void init() {
        this.target.traceState("init()");
        RouteOptionServices.ROUTE_OPTIONS_PROVIDER = new RouteOptionsProvider();
        this.routeOptionsAccessor = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getPersistableRouteOptionsAccessor();
        this.persistableRouteOptionsSetup = PersistableRouteOptionsSetup.getInstance();
        this.routeOptionsAccessor.setAvoidRoadTypes(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getAvoidRoadTypes());
        this.routeOptionsAccessor.setDynamic(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getDynamicRouteCalculation());
        this.routeOptionsAccessor.setRouteCalcType(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getRouteCalculationType());
        this.routeOptionsAccessor.setHmiAlternativeRouteCalculation(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getAlternativeRouteCalculation());
        this.routeOptionsAccessor.setSelectedVignetteCountries(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getVignetteAvailableCountryIDs());
        this.routeOptionsAccessor.setHOV(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getHOVUsage());
        this.routeOptionsAccessor.setSeasonalRestrictions(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getSeasonalRestrictions());
        this.routeOptionsAccessor.setStatisticalData(this.persistableRouteOptionsSetup, this.persistableRouteOptionsSetup.getStatisticalData());
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("Target Navigation.RouteOptions - Dump of all values restored from persistence.").append(this.persistableRouteOptionsSetup.toString()).toString());
        }
    }

    private void resetRouteOptions() {
        this.target.traceState("resetRouteOptions()");
        this.routeOptionsAccessor.clearSettings(this.persistableRouteOptionsSetup);
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            this.target.traceState("StateRouteOptionsWork#resetRouteOptions -> Guidance ongoing stopping guidance.");
            this.target.getMainObject().getServiceRegister().triggerObserver(0x24020040);
            this.stoppingGuidanceOngoing = true;
        } else {
            this.target.traceState("StateRouteOptionsWork#resetRouteOptions -> No Guidance ongoing sending RouteOptions to DSI.");
            this.sendRouteOptionsToDsi();
        }
        this.sendTmcStatisticalDataToDsi();
    }

    void sendTmcStatisticalDataToDsi() {
        this.target.traceState("sendTmcStatisticalDataToDsi()");
        if (this.target.dsiTmc != null) {
            boolean bl = this.routeOptionsAccessor.getStatisticalData(this.persistableRouteOptionsSetup);
            this.target.dsiTmc.enableTrafficFlowStatistics(bl);
        } else {
            this.target.traceState("dsiTmc == null");
        }
    }

    private void handleRouteOptionsSave() {
        this.target.traceState("handleRouteOptionsSave()");
        if (this.isRouteOptionsChanged) {
            this.sendRouteOptionsToDsi();
            this.isRouteOptionsChanged = false;
        }
    }

    void sendRouteOptionsToDsi() {
        this.target.traceState("sendRouteOptionsToDsi()");
        RouteOptions routeOptions = this.routeOptionsAccessor.getRouteOptions(this.persistableRouteOptionsSetup);
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSI | ").append(routeOptions).toString());
        }
        this.target.getDsiNavigation().rgSetRouteOptions(routeOptions);
    }

    private void toggleRoadType(int n) {
        this.target.traceState("toggleRoadType()");
        this.routeOptionsAccessor.toggleAvoidRoadType(this.persistableRouteOptionsSetup, n);
        this.isRouteOptionsChanged = true;
    }

    private void setAltenativeRouteCalculation(boolean bl) {
        this.target.traceState("setAltenativeRouteCalculation()");
        this.routeOptionsAccessor.setHmiAlternativeRouteCalculation(this.persistableRouteOptionsSetup, bl);
    }

    private void setRouteCalculationType(int n, boolean bl) {
        this.target.traceState("setRouteCalculationType()");
        this.routeOptionsAccessor.setRouteCalcType(this.persistableRouteOptionsSetup, n);
        if (bl) {
            this.isRouteOptionsChanged = true;
        }
    }

    private void setDynamicRouteCalculation(int n) {
        this.target.traceState("setDynamicRouteCalculation()");
        this.routeOptionsAccessor.setDynamic(this.persistableRouteOptionsSetup, n);
        this.isRouteOptionsChanged = true;
    }

    private void setHOVUsage(boolean bl) {
        this.target.traceState("toggleHOV()");
        this.routeOptionsAccessor.setHOV(this.persistableRouteOptionsSetup, bl);
        this.isRouteOptionsChanged = true;
    }

    @Override
    public void reloadPersistedData() {
        this.target.traceState("reloadPersistedData()");
        this.sendRouteOptionsToDsi();
        this.sendTmcStatisticalDataToDsi();
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.resetRouteOptions();
        this.navigationResetParticipant.notifyResetDone();
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

