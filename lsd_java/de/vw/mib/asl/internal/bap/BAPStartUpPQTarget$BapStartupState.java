/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.bap;

import de.vw.mib.asl.internal.bap.BAPStartUpPQTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class BAPStartUpPQTarget$BapStartupState
extends AbstractHsmState {
    private final /* synthetic */ BAPStartUpPQTarget this$0;

    public BAPStartUpPQTarget$BapStartupState(BAPStartUpPQTarget bAPStartUpPQTarget, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = bAPStartUpPQTarget;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                BAPStartUpPQTarget.access$000(this.this$0);
                break;
            }
            default: {
                hsmState = BAPStartUpPQTarget.access$100(this.this$0);
            }
        }
        return hsmState;
    }
}

