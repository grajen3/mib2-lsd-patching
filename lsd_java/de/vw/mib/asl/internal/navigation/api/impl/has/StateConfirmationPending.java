/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateConfirmationPending
extends AbstractHsmState {
    private HsmTargetHas target;

    StateConfirmationPending(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetHas;
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
            case 3497006: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_GUIDANCE_STATE");
                int n = eventGeneric.getInt(0);
                if (n == 1) {
                    this.trans(this.target.stateGuidance);
                    break;
                }
                if (n != 0) break;
                this.trans(this.target.stateNoGuidance);
                break;
            }
            case 1074841942: {
                this.target.traceState(this, "STOP_ROUTE_IMPORT");
                this.target.startGuidanceResult.setResult(1);
                this.trans(this.target.stateNoGuidance);
                break;
            }
            case 100104: {
                this.target.startGuidanceResult.setResult(2);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

