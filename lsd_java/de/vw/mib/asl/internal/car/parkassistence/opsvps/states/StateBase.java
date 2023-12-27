/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps.states;

import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class StateBase
extends AbstractHsmState {
    static final String OPS_VPS_HSM_ENTRY;
    static final String OPS_VPS_HSM_START;
    static final String OPS_VPS_HSM_EXIT;
    OpsVpsHsmTarget target;

    StateBase(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = opsVpsHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_ENTRY in state ").append(this.getName()).log();
                break;
            }
            case 3: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_START in state ").append(this.getName()).log();
                break;
            }
            case 4: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_EXIT in state ").append(this.getName()).log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

