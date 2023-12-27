/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.careco.BCmECurrentRange;

public class StateRemainingRangeNotValid
extends AbstractHsmState {
    private HsmTargetBattery target;

    StateRemainingRangeNotValid(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
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
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public HsmState dsiCarEcoUpdateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        this.target.traceState(this, "dsiCarEcoUpdateBCmECurrentRange()");
        if (bCmECurrentRange != null) {
            this.target.remainingRange = bCmECurrentRange.rangeValuePrimary;
            if (this.target.isRemainingRangeValid()) {
                if (this.target.isRgActive) {
                    this.trans(this.target.stateIdleRgActive);
                } else {
                    this.trans(this.target.stateIdleRgNotActive);
                }
            }
        }
        return null;
    }
}

