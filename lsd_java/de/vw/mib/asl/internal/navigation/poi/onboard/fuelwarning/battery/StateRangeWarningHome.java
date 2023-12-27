/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class StateRangeWarningHome
extends AbstractHsmState {
    private HsmTargetBattery target;

    StateRangeWarningHome(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
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
                if (this.target.isHomeWarningCanceled) {
                    this.trans(this.target.stateRangeWarningCanceled);
                    break;
                }
                this.startTimer();
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                this.target.stopTimer(75956480);
                break;
            }
            case 1073744393: {
                this.target.traceState(this, "ASLNavigationSetupServiceConstants.SET_HOME_RANGE_WARNING_ENABLED");
                boolean bl = eventGeneric.getBoolean(0);
                if (!bl) {
                    this.trans(this.target.stateIdleRgNotActive);
                }
                hsmState = this.myParent;
                break;
            }
            case 1074841884: {
                this.target.traceState(this, "CANCEL_HOME_RANGEWARNING_PRESSED");
                this.target.isHomeWarningCanceled = true;
                this.trans(this.target.stateRangeWarningCanceled);
                break;
            }
            case 3499003: {
                this.target.traceState(this, "EV_DEST_INPUT_HOME_LOCATION_CHANGED");
                this.target.stopTimer(75956480);
                this.startTimer();
                hsmState = this.myParent;
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
        this.target.traceState(this, "startTimer()");
        if (this.target.isPreventFirstHomeWarning) {
            this.target.traceState(this, "First range check prevented!");
            this.target.isPreventFirstHomeWarning = false;
        } else {
            this.target.triggerMe(75956480);
        }
        this.target.startTimer(75956480, (long)0, true);
    }

    private void checkDistance() {
        this.target.traceState(this, "guidance is not active && home warning is checked");
        this.target.preventValueInconsistence(this);
        if (!this.target.isCharging) {
            NavLocation navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation();
            if (navLocation != null && navLocation.isPositionValid()) {
                PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
                if (posPosition != null && (posPosition.latitude != 0 || posPosition.longitude != 0)) {
                    int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(posPosition, navLocation) / 1000;
                    n = (int)((double)n * 1.25);
                    int n2 = (int)((double)this.target.remainingRange * 0.95);
                    if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
                        LogMessage logMessage = this.target.trace();
                        logMessage.append("Distance to home location: ").append(n);
                        logMessage.append(" Remaining range: ").append(n2);
                        logMessage.log();
                    }
                    if (n2 < n) {
                        this.target.traceState(this, "remaining range < distance to home address.");
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(519);
                    }
                } else {
                    if (posPosition == null) {
                        this.target.traceState(this, "Current posPosition is null!");
                    } else {
                        this.target.error().append("illegal current position: ").append(posPosition).log();
                    }
                    this.trans(this.target.stateIdleRgNotActive);
                }
            } else {
                if (navLocation == null) {
                    this.target.traceState(this, "Home address is null!");
                } else {
                    this.target.error().append("illegal home position: ").append(navLocation).log();
                }
                this.trans(this.target.stateIdleRgNotActive);
            }
        }
    }

    public HsmState dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive()");
        if (bl) {
            this.trans(this.target.stateIdleRgActive);
        }
        return this.myParent;
    }
}

