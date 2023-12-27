/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateDeactivateDemoModeNoGuidance
extends AbstractHsmState {
    private HsmTargetGuidance myTarget;

    StateDeactivateDemoModeNoGuidance(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.myTarget.getDsiNavigation().etcSetDemoMode(false);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public HsmState dsiNavigationUpdateEtcDemoModeState(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateEtcDemoModeState");
        this.myTarget.southsideIsInDemoMode = bl;
        if (this.myTarget.southsideIsInDemoMode) {
            this.myTarget.trace("Deactivating demomode failed!");
        }
        try {
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        catch (Exception exception) {
            this.myTarget.error(new StringBuffer().append("HsmTargetGuidance StateDeactivateDemoModeNoGuidance.dsiNavigationUpdateEtcDemoModeState: ").append(exception.getMessage()).toString());
        }
        return this.myParent;
    }
}

