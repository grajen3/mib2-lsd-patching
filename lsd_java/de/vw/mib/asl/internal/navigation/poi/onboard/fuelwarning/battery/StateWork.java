/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.Events;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class StateWork
extends AbstractHsmState {
    private HsmTargetBattery target;

    StateWork(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
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
                this.trans(this.target.stateInit);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                Events.removeObservers(this.target);
                break;
            }
            case 1073744392: {
                this.target.traceState(this, "ASLNavigationSetupServiceConstants.SET_DESTINATION_RANGE_WARNING_ENABLED");
                this.target.isDestinationWarning = eventGeneric.getBoolean(0);
                break;
            }
            case 1073744393: {
                this.target.traceState(this, "ASLNavigationSetupServiceConstants.SET_HOME_RANGE_WARNING_ENABLED");
                this.target.isHomeWarning = eventGeneric.getBoolean(0);
                this.target.isHomeWarningCanceled = false;
                break;
            }
            case 3499003: {
                this.target.traceState(this, "EV_DEST_INPUT_HOME_LOCATION_CHANGED");
                this.target.isHomeWarningCanceled = false;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive()");
        this.target.isRgActive = bl;
        if (!bl) {
            this.target.resetGuidanceData();
        }
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgCurrentRoute()");
        this.target.currentRoute = route;
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgInfoForNextDestination()");
        this.target.infoForNextDestination = rgInfoForNextDestination;
    }

    public void dsiCarEcoUpdateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        this.target.traceState(this, "dsiCarEcoUpdateBCmECurrentRange()");
        if (bCmECurrentRange != null) {
            this.target.remainingRange = bCmECurrentRange.rangeValuePrimary;
            if (this.target.isRemainingRangeValid()) {
                this.target.traceState(this, "remaining range is valid.");
                this.target.remainingRange /= 10;
                if (bCmECurrentRange.rangeUnit == 1) {
                    this.target.traceState(this, "Current range unit is miles -> convert to km");
                    this.target.remainingRange = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().milesToKm(this.target.remainingRange);
                }
            } else {
                this.trans(this.target.stateRemainingRangeNotValid);
            }
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = HsmTargetBattery.LOGGER.makeTrace();
                logMessage.append("Remaining range: ").append(this.target.remainingRange);
            }
        }
    }

    public void dsiCarHybridUpdateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.target.traceState(this, "dsiCarHybridUpdateBatteryControlChargeState()");
        if (batteryControlChargeState != null) {
            if (batteryControlChargeState.chargeState == 2 || batteryControlChargeState.chargeState == 3) {
                this.target.traceState(this, "chargeState.chargeState == DSICarHybrid.BATTERYCONTROLCHARGESTATE_RUNNING");
                this.target.isCharging = true;
            } else {
                this.target.traceState(this, "chargeState.chargeState != DSICarHybrid.BATTERYCONTROLCHARGESTATE_RUNNING && chargeState.chargeState != DSICarHybrid.BATTERYCONTROLCHARGESTATE_CONSERVATION_CHARGING");
                this.target.isCharging = false;
            }
        }
    }
}

