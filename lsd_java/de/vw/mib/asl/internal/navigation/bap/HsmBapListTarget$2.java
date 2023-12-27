/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.internal.navigation.bap.HsmBapListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmBapListTarget$2
extends AbstractHsmState {
    private final /* synthetic */ HsmBapListTarget this$0;

    HsmBapListTarget$2(HsmBapListTarget hsmBapListTarget, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmBapListTarget;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.getHsm().trans(this.this$0.stateWork);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

