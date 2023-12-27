/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.Events;
import de.vw.mib.asl.internal.navigation.guidance.main.GuidanceUtils;
import de.vw.mib.asl.internal.navigation.guidance.main.Services;
import de.vw.mib.asl.internal.navigation.guidance.main.StateCalculationAbortedAndStopped;
import de.vw.mib.asl.internal.navigation.guidance.main.StateCalculationActive;
import de.vw.mib.asl.internal.navigation.guidance.main.StateCalculationDirectToActiveRubberband;
import de.vw.mib.asl.internal.navigation.guidance.main.StateCalculationError;
import de.vw.mib.asl.internal.navigation.guidance.main.StateCalculationPrepare;
import de.vw.mib.asl.internal.navigation.guidance.main.StateDSINotAvailable;
import de.vw.mib.asl.internal.navigation.guidance.main.StateDeactivateDemoModeNoGuidance;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceActive;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceActiveIdle;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceActiveRubberband;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceActiveSdCardEject;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceFinished;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceNotActive;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceResumePending;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceStart;
import de.vw.mib.asl.internal.navigation.guidance.main.StateGuidanceStartPNAV;
import de.vw.mib.asl.internal.navigation.guidance.main.StatePendingGuidanceStop;
import de.vw.mib.asl.internal.navigation.guidance.main.StateWork;
import de.vw.mib.asl.internal.navigation.guidance.main.rc.RCProgressHandling;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.Route;

public class HsmTargetGuidance
extends AbstractResettableAslHsmTarget
implements PowerStateListener {
    boolean southsideIsInDemoMode = false;
    protected Route myPersistentRoute;
    protected Route myRoute;
    protected boolean isGuidanceRestartAfterDemo = false;
    protected boolean isResumeGuidance = false;
    protected int dsiRouteIndex = 0;
    protected Services services;
    protected INavigationDP navigationDp;
    protected RCProgressHandling rcProgressHandling = new RCProgressHandling();
    boolean isFeatHigh = false;
    private boolean isFFNavRouteCalcAdjustRoute = false;
    protected boolean isRubberbandStartFromRC = false;
    ASLNavGuidanceDP aslNavGuidanceDP = ASLNavGuidanceDP.getInstance();
    NavSegmentID pnavDestination;
    int powerState = -1;
    public final StateWork stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
    public final StateGuidanceActive stateGuidanceActive = new StateGuidanceActive(this, this.hsm, "stateGuidanceActive", this.stateWork);
    public final StateGuidanceActiveIdle stateGuidanceActiveIdle = new StateGuidanceActiveIdle(this, this.hsm, "stateGuidanceActiveIdle", this.stateGuidanceActive);
    public final StateGuidanceActiveRubberband stateGuidanceActiveRubberband = new StateGuidanceActiveRubberband(this, this.hsm, "stateGuidanceActiveRubberband", this.stateGuidanceActive);
    public final StateGuidanceActiveSdCardEject stateGuidanceActiveSdCardEject = new StateGuidanceActiveSdCardEject(this, this.hsm, "stateGuidanceActiveSdCardEject", this.stateGuidanceActive);
    public final StateGuidanceNotActive stateGuidanceNotActive = new StateGuidanceNotActive(this, this.hsm, "stateGuidanceNotActive", this.stateWork);
    public final StateDeactivateDemoModeNoGuidance stateDeactivateDemoModeNoGuidance = new StateDeactivateDemoModeNoGuidance(this, this.hsm, "stateDeactivateDemoModeNoGuidance", this.stateWork);
    public final StatePendingGuidanceStop statePendingGuidanceStop = new StatePendingGuidanceStop(this, this.hsm, "statePendingGuidanceStop", this.stateWork);
    public final StateGuidanceFinished stateGuidanceFinished = new StateGuidanceFinished(this, this.hsm, "stateGuidanceFinished", this.stateWork);
    public final StateCalculationAbortedAndStopped stateCalculationAbortedAndStopped = new StateCalculationAbortedAndStopped(this, this.hsm, "stateCalculationAbortedAndStopped", this.stateWork);
    public final StateCalculationError stateCalculationError = new StateCalculationError(this, this.hsm, "stateCalculationError", this.stateWork);
    public final StateCalculationPrepare stateCalculationPrepare = new StateCalculationPrepare(this, this.hsm, "stateCalculationPrepare", this.stateWork);
    public final StateCalculationActive stateCalculationActive = new StateCalculationActive(this, this.hsm, "stateCalculationActive", this.stateWork);
    public final StateGuidanceStart stateGuidanceStart = new StateGuidanceStart(this, this.hsm, "stateGuidanceStart", this.stateWork);
    public final StateGuidanceStartPNAV stateGuidanceStartPNAV = new StateGuidanceStartPNAV(this, this.hsm, "stateGuidanceStartPNAV", this.stateWork);
    public final StateCalculationDirectToActiveRubberband stateCalculationDirectToActiveRubberband = new StateCalculationDirectToActiveRubberband(this, this.hsm, "stateCalculationActiveRubberband", this.stateWork);
    public final StateGuidanceResumePending stateGuidanceResumePending = new StateGuidanceResumePending(this, this.hsm, "stateGuidanceResumePending", this.stateWork);
    public final StateDSINotAvailable stateDSINotAvailable = new StateDSINotAvailable(this, this.hsm, "stateDSINotAvailable", this.stateWork);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;

    @Override
    public int getSubClassifier() {
        return 32;
    }

    public HsmTargetGuidance(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        Events.registerASLServices(this);
    }

    protected void initDSI() {
        this.services = new Services(this);
    }

    public void traceState(AbstractHsmState abstractHsmState, String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void infoState(AbstractHsmState abstractHsmState, String string) {
        LogMessage logMessage = ServiceManager.logger2.info(this.getSubClassifier());
        logMessage.append(super.getClass());
        logMessage.append(".");
        logMessage.append(super.getClass());
        logMessage.append(": ");
        logMessage.append(string);
        logMessage.log();
    }

    public void logInfo(String string) {
        LogMessage logMessage = ServiceManager.logger2.info(this.getSubClassifier());
        logMessage.append(super.getClass());
        logMessage.append(": ");
        logMessage.append(string);
        logMessage.log();
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

    boolean isPersistentRouteValid() {
        return this.myPersistentRoute != null && this.myPersistentRoute.routelist != null && this.myPersistentRoute.routelist.length > 0;
    }

    boolean isRouteValid() {
        return this.myRoute != null && this.myRoute.routelist != null && this.myRoute.routelist.length > 0;
    }

    DSINavigation getDsiNavigation() {
        return this.services.getNavigation();
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    boolean isSouthsideInDemoMode() {
        return this.southsideIsInDemoMode;
    }

    public boolean isTour() {
        int n = PersistedGuidanceSetup.getInstance().getLastGuidanceMode();
        return n == 587333696 || n == 0x74070040 || n == 553779264 || n == 1963393088;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetGuidance.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetGuidance.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName(), 0);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetGuidance.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement).getName(), 0);
        boolean bl4 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = HsmTargetGuidance.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection).getName(), 0);
        if (bl || bl2 || bl3 || bl4) {
            this.trace("HsmTargetGuidance: resetting values after DSI restart");
            this.initLocalVariables();
            this.resetHsmToState(this.stateGuidanceNotActive);
            if (bl) {
                this.services.initDsiNavigation();
            }
            if (bl2) {
                this.services.initDsiGeneralVehicleStates();
            }
            if (bl3) {
                this.services.initDsiPowerManagement();
            }
            if (bl4) {
                this.services.initDsiSwdlSelection();
            }
        } else {
            this.trace("HsmTargetGuidance: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.southsideIsInDemoMode = false;
        this.myPersistentRoute = null;
        this.myRoute = null;
        this.isGuidanceRestartAfterDemo = false;
        this.isResumeGuidance = false;
        this.dsiRouteIndex = 0;
        this.rcProgressHandling.resetDefaults();
        this.isRubberbandStartFromRC = false;
        this.pnavDestination = null;
    }

    public boolean isModelInDemoMode() {
        int n = PersistedGuidanceSetup.getInstance().getLastGuidanceMode();
        return n == 520224832 || n == 553779264 || n == 0x20020040 || n == 1963393088;
    }

    public boolean isRecalculation() {
        int n = PersistedGuidanceSetup.getInstance().getLastGuidanceMode();
        return n == 0x20020040 || n == 1963393088 || n == 503447616 || n == 0x74070040;
    }

    public boolean isSingleRouteCalculation() {
        return this.isWPMCalculation() || this.isRecalculation() || this.isGuidanceRestartAfterDemo || this.isResumeGuidance || !RouteOptionServices.ROUTE_OPTIONS_PROVIDER.isAlternativeRouteCalculation();
    }

    public boolean isWPMCalculation() {
        int n = PersistedGuidanceSetup.getInstance().getLastGuidanceMode();
        return n == 986255424 || n == 1003032640 || n == 1036587072 || n == 1019809856;
    }

    public void updateErrorState(int n) {
        this.aslNavGuidanceDP.setErrorState(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(794572032);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void updateGuidanceState(int n) {
        this.aslNavGuidanceDP.setGuidanceState(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(777794816);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGuidanceStateChanged(n);
    }

    public void updateCalculationState(ASLCalculationState[] aSLCalculationStateArray) {
        this.aslNavGuidanceDP.setCalculationState(aSLCalculationStateArray);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(761017600);
        eventGeneric.setObject(0, aSLCalculationStateArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void updateGuidanceMode(int n) {
        this.aslNavGuidanceDP.setGuidanceMode(n);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(811349248);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    void setFinalDestinationReached() {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1180448000);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void setIsFFNavRouteCalcAdjustRoute() {
        this.isFFNavRouteCalcAdjustRoute = ServiceManager.configManagerDiag.isFeatureFlagSet(149);
    }

    public boolean isFFNavRouteCalcAdjustRoute() {
        return this.isFFNavRouteCalcAdjustRoute;
    }

    @Override
    public void onNewPowerState(int n) {
        this.logInfo(new StringBuffer("onNewPowerState: powerState -> ").append(n).toString());
        int n2 = this.powerState;
        this.powerState = n;
        if (n2 == 2 && n != 2) {
            this.logInfo("oldPowerState == PowerStateService.POWER_STATE_ON && powerState != PowerStateService.POWER_STATE_ON");
            if (this.getHsm().getState() != this.stateGuidanceResumePending) {
                this.logInfo("Store last hmi on time");
                this.storeTimestamp();
            } else {
                this.logInfo("Resume guidance is still pending -> last hmi on time will not be stored");
            }
        } else if (n == 2 && this.getHsm().getState() == this.stateGuidanceResumePending) {
            try {
                this.stateGuidanceResumePending.powerStateSwitchedOn();
            }
            catch (Exception exception) {
                this.logInfo(exception.getMessage());
            }
        }
    }

    void storeTimestamp() {
        this.logInfo("storeTimestamp");
        long l = ASLSystemFactory.getSystemApi().getCurrentTimestamp();
        if (GuidanceUtils.isSystemTimestampValid(l)) {
            this.logInfo(new StringBuffer("currentTimestamp is valid: ").append(l).toString());
            PersistedGuidanceSetup.getInstance().setLastTimeStampBeforeHmiOff(l);
        } else {
            this.logInfo("currentTimestamp is not valid");
            PersistedGuidanceSetup.getInstance().setLastTimeStampBeforeHmiOff(-1L);
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

