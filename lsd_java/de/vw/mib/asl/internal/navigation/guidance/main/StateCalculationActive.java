/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateCalculationActive
extends AbstractHsmState {
    private HsmTargetGuidance myTarget;
    private boolean isAbort;

    StateCalculationActive(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
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
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                this.myTarget.traceState(this, "Sending internal event to the sound target to disable special announcement for alternative route calculation!");
                this.myTarget.triggerIt(1665864704, 92733696);
                break;
            }
            case 0x40000222: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_START_SELECTED_ROUTE");
                this.startSelectedRoute(eventGeneric.getInt(0));
                break;
            }
            case 1073744350: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_SELECT_ROUTE_PROFILE");
                this.selectRouteProfile(eventGeneric.getInt(0));
                break;
            }
            case 1074841917: {
                this.myTarget.traceState(this, "START_WPM_ROUTE");
                this.startWPMRoute();
                break;
            }
            case 1074841915: 
            case 1074841916: {
                this.myTarget.traceState(this, "START_WPM_REVERSE_DIRECTION/START_WPM_TO_NEAREST_WAY_POINT");
                PersistedGuidanceSetup.getInstance().setLastGuidanceMode(eventGeneric.getReceiverEventId());
                this.myTarget.getDsiNavigation().rgStopGuidance();
                this.trans(this.myTarget.stateCalculationPrepare);
                break;
            }
            case 1073742342: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_ABORT");
                this.myTarget.getDsiNavigation().rgStopGuidance();
                ServiceManager.aslPropertyManager.valueChangedInteger(803, 3);
                this.isAbort = true;
                break;
            }
            case 0x40000224: 
            case 1073743954: {
                this.myTarget.traceState(this, "STOP/ABORT_AND_STOP");
                if (!this.isAbort) {
                    this.myTarget.getDsiNavigation().rgStopGuidance();
                }
                this.myTarget.triggerIt(1397429248, 75956480);
                this.trans(this.myTarget.stateGuidanceNotActive);
                break;
            }
            case 1074841950: {
                this.myTarget.traceState(this, "ASLNavigationGuidanceServiceConstants.START_SELECTED_ROUTE_FOR_RUBBERBAND");
                if (this.myTarget.isFFNavRouteCalcAdjustRoute()) {
                    this.myTarget.isRubberbandStartFromRC = true;
                    this.startSelectedRoute(eventGeneric.getInt(0));
                    break;
                }
                this.myTarget.traceState(this, "Down Event, Feature Flag Mismatch: ASLNavigationGuidanceServiceConstants.START_SELECTED_ROUTE_FOR_RUBBERBAND");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void start() {
        this.isAbort = false;
        if (this.myTarget.isSingleRouteCalculation()) {
            this.myTarget.getDsiNavigation().rgCalculateRoute(this.myTarget.myRoute, 1);
        } else {
            this.myTarget.getDsiNavigation().rgCalculateRoute(this.myTarget.myRoute, RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes());
        }
    }

    private void selectRouteProfile(int n) {
        if (ServiceManager.logger2.isTraceEnabled(this.myTarget.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.myTarget.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(".");
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append("selectRouteProfile(): Selected index = ");
            logMessage.append(n);
            logMessage.log();
        }
        int n2 = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getDSIIndexFromModelIndex(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainRbSelectAlternativeRoute(n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(3530, n);
    }

    private void startSelectedRoute(int n) {
        int n2 = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getRouteCalcTypeFromModelIndex(n);
        this.myTarget.dsiRouteIndex = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getDsiIndexFromRouteCalcType(n2);
        RouteOptionServices.ROUTE_OPTIONS_PROVIDER.setRouteCalcType(n2);
        if (!this.isAbort) {
            this.trans(this.myTarget.stateGuidanceStart);
        }
    }

    private void startWPMRoute() {
        this.myTarget.dsiRouteIndex = 0;
        if (!this.isAbort) {
            this.trans(this.myTarget.stateGuidanceStart);
        }
    }

    public void dsiNavigationUpdateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgCalculatedRoutes");
        int n2 = calculatedRouteListElementArray != null ? calculatedRouteListElementArray.length : 0;
        this.myTarget.traceState(this, new StringBuffer("Total calculated routes: ").append(n2).toString());
        this.myTarget.traceState(this, new StringBuffer("myTarget.navigationDp.getGuidanceOptions().getLastGuidanceMode() = ").append(PersistedGuidanceSetup.getInstance().getLastGuidanceMode()).toString());
        if (!this.isAbort && n2 > 0) {
            this.myTarget.rcProgressHandling.updateRouteCalculation(calculatedRouteListElementArray);
            this.updateInternalGuidanceAPIStates(calculatedRouteListElementArray);
            if (this.myTarget.rcProgressHandling.isCalculationError()) {
                this.myTarget.traceState(this, "An error ocurred");
            } else if (this.myTarget.rcProgressHandling.isCalculationFinished()) {
                this.myTarget.traceState(this, "Calculation finished");
                if (this.myTarget.isWPMCalculation() && !this.myTarget.isResumeGuidance) {
                    this.myTarget.traceState(this, "WPM Calculation finished -> waiting for user interaction");
                    ServiceManager.aslPropertyManager.valueChangedBoolean(4121, true);
                } else if (RouteOptionServices.ROUTE_OPTIONS_PROVIDER.isAlternativeRouteCalculation() && !this.myTarget.isRecalculation() && !this.myTarget.isResumeGuidance && !this.myTarget.isGuidanceRestartAfterDemo) {
                    this.myTarget.traceState(this, "Sending internal event to the sound target to trigger special announcement for alternative route calculation!");
                    this.myTarget.triggerIt(1665864704, 75956480);
                } else {
                    this.myTarget.traceState(this, "Starting guidance now!");
                    if (this.myTarget.isSingleRouteCalculation()) {
                        this.myTarget.dsiRouteIndex = 0;
                        this.trans(this.myTarget.stateGuidanceStart);
                    }
                }
            }
        }
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.myTarget.traceState(this, "dsiNavigationUpdateNavstateOfOperation");
        if (n == 3) {
            this.myTarget.traceState(this, " navstateofoperation is diskrequest eject.");
            this.myTarget.getDsiNavigation().rgStopGuidance();
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        return this.myParent;
    }

    public HsmState dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.myTarget.traceState(this, "dsiPowerManagementUpdateClampSignal");
        if (n == 1 && clampSignal.isClampS() && !clampSignal.isClamp15() && this.myTarget.isSouthsideInDemoMode()) {
            this.myTarget.getDsiNavigation().rgStopGuidance();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNavigationModel();
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        return this.myParent;
    }

    private void updateInternalGuidanceAPIStates(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        int n = 1;
        if (!this.myTarget.isSingleRouteCalculation()) {
            n = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getNumberOfAlternativeRoutes();
        }
        if (calculatedRouteListElementArray.length == n) {
            ASLCalculationState[] aSLCalculationStateArray = new ASLCalculationState[n];
            for (int i2 = 0; i2 < aSLCalculationStateArray.length; ++i2) {
                aSLCalculationStateArray[i2] = new ASLCalculationState();
                aSLCalculationStateArray[i2].setCalculationState(1);
                if (calculatedRouteListElementArray[i2].calculationState == 1) {
                    aSLCalculationStateArray[i2].setCalculationState(1);
                    aSLCalculationStateArray[i2].setProgress(calculatedRouteListElementArray[i2].calculationPercentage);
                    continue;
                }
                if (calculatedRouteListElementArray[i2].calculationState != 3) continue;
                aSLCalculationStateArray[i2].setCalculationState(2);
                aSLCalculationStateArray[i2].setProgress(calculatedRouteListElementArray[i2].calculationPercentage);
            }
            this.myTarget.updateCalculationState(aSLCalculationStateArray);
        }
    }
}

