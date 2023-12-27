/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateIdleRgActive
extends AbstractHsmState {
    private HsmTargetBattery target;

    StateIdleRgActive(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
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
                if (!this.target.isDestinationWarning) break;
                this.trans(this.target.stateRangeWarningDestination);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 1073744392: {
                this.target.traceState(this, "ASLNavigationSetupServiceConstants.SET_DESTINATION_RANGE_WARNING_ENABLED");
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) {
                    this.trans(this.target.stateRangeWarningDestination);
                }
                hsmState = this.myParent;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public HsmState dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive()");
        if (!bl) {
            if (this.target.isHomeWarning) {
                this.target.isPreventFirstHomeWarning = true;
            }
            this.trans(this.target.stateIdleRgNotActive);
        }
        return this.myParent;
    }
}

