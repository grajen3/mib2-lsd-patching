/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.asl.internal.navigation.routeoptions.util.RouteOptionsHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateCalculationPrepare
extends AbstractHsmState {
    private final HsmTargetGuidance myTarget;
    private boolean isAbort;
    private int lastWPMMode = 1;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$guidance$main$HsmTargetGuidance;

    StateCalculationPrepare(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.start();
                break;
            }
            case 1073742342: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_ABORT");
                ServiceManager.aslPropertyManager.valueChangedInteger(803, 3);
                this.isAbort = true;
                break;
            }
            case 0x40000224: 
            case 1073743954: {
                this.myTarget.traceState(this, "STOP/ABORT_AND_STOP");
                this.myTarget.triggerIt(1397429248, 75956480);
                this.trans(this.myTarget.stateGuidanceNotActive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void start() {
        int n;
        this.isAbort = false;
        this.configureRoute();
        if (this.myTarget.myRoute != null) {
            boolean bl = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isIntermediateDestInWholeRoute(this.myTarget.myRoute);
            ServiceManager.aslPropertyManager.valueChangedBoolean(794, bl);
            n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isIntermediateDestInRoute(this.myTarget.myRoute) ? 1 : 0;
            ServiceManager.aslPropertyManager.valueChangedBoolean(-571469824, n != 0);
        }
        ASLCalculationState[] aSLCalculationStateArray = this.myTarget.isSingleRouteCalculation() ? new ASLCalculationState[1] : new ASLCalculationState[RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes()];
        for (n = 0; n < aSLCalculationStateArray.length; ++n) {
            aSLCalculationStateArray[n] = new ASLCalculationState();
            aSLCalculationStateArray[n].setCalculationState(1);
        }
        this.myTarget.updateCalculationState(aSLCalculationStateArray);
        ServiceManager.aslPropertyManager.valueChangedInteger(803, 1);
        if (this.myTarget.isWPMCalculation()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(4121, false);
        }
        n = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getModelIndexOfCurrentRouteCalcType();
        ServiceManager.aslPropertyManager.valueChangedInteger(3530, n);
        this.myTarget.rcProgressHandling.resetDefaults();
        this.setTourModeGuidance();
        this.configureRouteOptions();
        if (this.myTarget.isModelInDemoMode()) {
            this.myTarget.traceState(this, "Setting demo address now.");
            this.setDemoPosition();
        }
        if (this.myTarget.isModelInDemoMode() && !this.myTarget.isSouthsideInDemoMode()) {
            this.myTarget.getDsiNavigation().etcSetDemoMode(true);
        } else if (!this.myTarget.isModelInDemoMode() && this.myTarget.isSouthsideInDemoMode()) {
            this.myTarget.getDsiNavigation().etcSetDemoMode(false);
        } else if (!this.isAbort) {
            this.trans(this.myTarget.stateCalculationActive);
        }
    }

    private void configureRoute() {
        if (!this.myTarget.isGuidanceRestartAfterDemo) {
            if (this.myTarget.isResumeGuidance) {
                this.myTarget.traceState(this, "Use persistent route");
                this.myTarget.myRoute = this.myTarget.myPersistentRoute;
            } else {
                this.myTarget.traceState(this, "Use tour mode route");
                this.myTarget.myRoute = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getTourmodeRoute();
                this.myTarget.myRoute.routeID = this.myTarget.isWPMCalculation() ? (long)0 : 0L;
            }
        } else {
            this.myTarget.traceState(this, "Use the last prepared route for demo guidance");
        }
        if (!this.myTarget.isRouteValid()) {
            this.myTarget.error("[HsmTargtetGuidance] statePendingGuidanceStart.startGuidance() -> route is null or has no destinations -> switch to nav main screen! ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("Calculation cannot be started because route has no destinations!");
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
    }

    private void configureRouteOptions() {
        if (this.myTarget.isRouteValid()) {
            RouteOptions[] routeOptionsArray;
            if (this.myTarget.isWPMCalculation()) {
                routeOptionsArray = this.configureWPMOptions(RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getSingleRouteOptions());
            } else if (this.myTarget.isSingleRouteCalculation()) {
                this.myTarget.traceState(this, "Use single route calculation options");
                routeOptionsArray = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getSingleRouteOptions();
            } else {
                this.myTarget.traceState(this, "Use alternative route calculation options");
                routeOptionsArray = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getAlternativeRouteOptions();
            }
            for (int i2 = 0; i2 < this.myTarget.myRoute.routelist.length; ++i2) {
                this.myTarget.myRoute.routelist[i2].routeOptions = routeOptionsArray;
            }
        }
    }

    private RouteOptions[] configureWPMOptions(RouteOptions[] routeOptionsArray) {
        this.myTarget.traceState(this, "Configure options for WPM");
        RouteOptions routeOptions = RouteOptionsHelper.copyRouteOptions(routeOptionsArray[0]);
        routeOptions.routeType = 4;
        routeOptions.waypointMode = 0;
        int n = PersistedGuidanceSetup.getInstance().getLastGuidanceMode();
        block0 : switch (n) {
            case 1074841914: {
                routeOptions.trail = 1;
                break;
            }
            case 1074841915: {
                switch (this.lastWPMMode) {
                    case 1: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_FORWARD -> ROUTEOPTTRAIL_BACKWARD");
                        routeOptions.trail = 4;
                        break block0;
                    }
                    case 2: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_FORWARD_ENTER -> ROUTEOPTTRAIL_BACKWARD_ENTER");
                        routeOptions.trail = 3;
                        break block0;
                    }
                    case 4: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_BACKWARD -> ROUTEOPTTRAIL_FORWARD");
                        routeOptions.trail = 1;
                        break block0;
                    }
                    case 3: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_BACKWARD_ENTER -> ROUTEOPTTRAIL_FORWARD_ENTER");
                        routeOptions.trail = 2;
                        break block0;
                    }
                }
                break;
            }
            case 1074841916: {
                switch (this.lastWPMMode) {
                    case 1: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_FORWARD -> ROUTEOPTTRAIL_FORWARD_ENTER");
                        routeOptions.trail = 2;
                        break block0;
                    }
                    case 2: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_FORWARD_ENTER -> ROUTEOPTTRAIL_FORWARD");
                        routeOptions.trail = 1;
                        break block0;
                    }
                    case 4: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_BACKWARD -> ROUTEOPTTRAIL_BACKWARD_ENTER");
                        routeOptions.trail = 3;
                        break block0;
                    }
                    case 3: {
                        this.myTarget.traceState(this, "ROUTEOPTTRAIL_BACKWARD_ENTER -> ROUTEOPTTRAIL_BACKWARD");
                        routeOptions.trail = 4;
                        break block0;
                    }
                }
                break;
            }
        }
        this.lastWPMMode = routeOptions.trail;
        return new RouteOptions[]{routeOptions};
    }

    private void setDemoPosition() {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDemoLocation();
        if (navLocation != null) {
            this.myTarget.getDsiNavigation().rgSetPosition(navLocation);
            this.myTarget.traceState(this, new StringBuffer("Demo start position was set to ").append(navLocation.toString()).toString());
        } else {
            this.myTarget.warn(new StringBuffer((class$de$vw$mib$asl$internal$navigation$guidance$main$HsmTargetGuidance == null ? (class$de$vw$mib$asl$internal$navigation$guidance$main$HsmTargetGuidance = StateCalculationPrepare.class$("de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance")) : class$de$vw$mib$asl$internal$navigation$guidance$main$HsmTargetGuidance).getName()).append(" Demo start position was not defined, this can cause route calculation errors!").toString());
        }
    }

    private void setTourModeGuidance() {
        if (this.myTarget.isTour()) {
            this.myTarget.traceState(this, "Tour mode is active!");
            ServiceManager.aslPropertyManager.valueChangedInteger(997, 1);
        } else {
            this.myTarget.traceState(this, "Tour mode is inactive!");
            ServiceManager.aslPropertyManager.valueChangedInteger(997, 0);
        }
    }

    public HsmState dsiNavigationUpdateEtcDemoModeState(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateEtcDemoModeState");
        if (!this.isAbort) {
            this.trans(this.myTarget.stateCalculationActive);
        }
        return this.myParent;
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.myTarget.traceState(this, "dsiNavigationUpdateNavstateOfOperation");
        if (n == 3) {
            this.myTarget.traceState(this, " navstateofoperation is diskrequest eject.");
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        return this.myParent;
    }

    public HsmState dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.myTarget.traceState(this, "dsiPowerManagementUpdateClampSignal");
        if (n == 1 && clampSignal.isClampS() && !clampSignal.isClamp15() && this.myTarget.isSouthsideInDemoMode()) {
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        return this.myParent;
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

