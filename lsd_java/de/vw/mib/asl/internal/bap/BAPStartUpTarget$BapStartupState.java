/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.bap;

import de.vw.mib.asl.internal.bap.BAPStartUpTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class BAPStartUpTarget$BapStartupState
extends AbstractHsmState {
    private final /* synthetic */ BAPStartUpTarget this$0;

    public BAPStartUpTarget$BapStartupState(BAPStartUpTarget bAPStartUpTarget, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = bAPStartUpTarget;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                BAPStartUpTarget.access$000(this.this$0);
                break;
            }
            default: {
                hsmState = BAPStartUpTarget.access$100(this.this$0);
            }
        }
        return hsmState;
    }
}

