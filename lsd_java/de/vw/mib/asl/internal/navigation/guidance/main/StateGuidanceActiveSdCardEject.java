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

public class StateGuidanceActiveSdCardEject
extends AbstractHsmState {
    private final HsmTargetGuidance target;

    StateGuidanceActiveSdCardEject(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.traceState(this, "HSM_START");
                ServiceManager.aslPropertyManager.valueChangedInteger(806, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(803, 0);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive");
        if (bl) {
            this.trans(this.target.stateGuidanceActiveIdle);
        } else {
            this.trans(this.target.stateGuidanceNotActive);
        }
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.target.traceState(this, "dsiNavigationUpdateNavstateOfOperation");
        if (n == 5) {
            this.target.traceState(this, " navstateofoperation is NAVSTATEOFOPERATION_FULLY_OPERABLE. Switching to usual guidance active state NOW.");
            this.trans(this.target.stateGuidanceActiveIdle);
            return null;
        }
        return this.myParent;
    }
}

