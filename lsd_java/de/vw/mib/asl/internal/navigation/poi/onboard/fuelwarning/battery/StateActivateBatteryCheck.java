/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateActivateBatteryCheck
extends AbstractHsmState {
    private HsmTargetBattery target;

    StateActivateBatteryCheck(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
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
            case 101001: {
                this.target.traceState(this, "NAVI_TARGET_GO_ON");
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(524)) {
                    this.trans(this.target.stateWork);
                    break;
                }
                this.target.traceState(this, "BEV range check disabled!");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

