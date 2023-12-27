/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateCalculationError
extends AbstractHsmState {
    private final HsmTargetGuidance myTarget;

    StateCalculationError(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.myTarget.updateErrorState(5);
                ServiceManager.aslPropertyManager.valueChangedInteger(803, 4);
                break;
            }
            case 0x40000224: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_STOP");
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

    public HsmState dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.myTarget.traceState(this, "dsiPowerManagementUpdateClampSignal");
        if (n == 1 && clampSignal.isClampS() && !clampSignal.isClamp15() && this.myTarget.isSouthsideInDemoMode()) {
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        return this.myParent;
    }
}

