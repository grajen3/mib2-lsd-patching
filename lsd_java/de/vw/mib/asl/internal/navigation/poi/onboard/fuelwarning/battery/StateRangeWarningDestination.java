/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class StateRangeWarningDestination
extends AbstractHsmState {
    private HsmTargetBattery target;
    private boolean isTimerActive = false;

    StateRangeWarningDestination(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetBattery;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                if (!this.target.isCurrentRouteValid() || !this.target.isInfoForNextDestValid()) break;
                this.startTimer();
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                this.stopTimer();
                break;
            }
            case 1073744392: {
                this.target.traceState(this, "ASLNavigationSetupServiceConstants.SET_DESTINATION_RANGE_WARNING_ENABLED");
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl) {
                    this.trans(this.target.stateIdleRgActive);
                }
                hsmState = this.myParent;
                break;
            }
            case 1074841884: {
                this.target.traceState(this, "CANCEL_HOME_RANGEWARNING_PRESSED");
                this.trans(this.target.stateRangeWarningCanceled);
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_CHECK_DISTANCE");
                this.checkDistance();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void startTimer() {
        this.target.triggerMe(75956480);
        this.target.startTimer(75956480, (long)0, true);
        this.isTimerActive = true;
    }

    private void stopTimer() {
        this.target.stopTimer(75956480);
        this.isTimerActive = false;
    }

    private void checkDistance() {
        this.target.traceState(this, "guidance is active && destination warning is checked");
        if (!this.target.isCharging) {
            long l = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getNextStopDistance() / 0;
            int n = (int)((double)this.target.remainingRange * 0.95);
            if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("Distance to next destination: ").append(l);
                logMessage.append(" Remaining range: ").append(n);
                logMessage.log();
            }
            if ((long)n < l) {
                this.target.traceState(this, "remaining range < distance to next destination.");
                if (this.target.currentRoute.indexOfCurrentDestination == (long)(this.target.currentRoute.routelist.length - 1)) {
                    this.target.traceState(this, "Show destination range PO.");
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1559236608, false);
                } else {
                    this.target.traceState(this, "Show stopover range PO.");
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1559236608, true);
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(518);
            }
        }
    }

    public HsmState dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive()");
        if (!bl) {
            if (this.target.isHomeWarning) {
                this.target.isPreventFirstHomeWarning = true;
            }
            this.trans(this.target.stateIdleRgNotActive);
        } else if (!this.isTimerActive && this.target.isCurrentRouteValid() && this.target.isInfoForNextDestValid()) {
            this.startTimer();
        }
        return this.myParent;
    }

    public HsmState dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgCurrentRoute()");
        if (route != null && route.routelist != null && route.routelist.length > 0 && !this.isTimerActive && this.target.isInfoForNextDestValid()) {
            this.startTimer();
        }
        return this.myParent;
    }

    public HsmState dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgInfoForNextDestination()");
        if (rgInfoForNextDestination != null && !this.isTimerActive && this.target.isCurrentRouteValid()) {
            this.startTimer();
        }
        return this.myParent;
    }
}

