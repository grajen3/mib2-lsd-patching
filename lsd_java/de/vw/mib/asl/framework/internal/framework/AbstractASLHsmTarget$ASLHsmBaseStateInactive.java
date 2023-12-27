/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class AbstractASLHsmTarget$ASLHsmBaseStateInactive
extends AbstractHsmState {
    private final /* synthetic */ AbstractASLHsmTarget this$0;

    public AbstractASLHsmTarget$ASLHsmBaseStateInactive(AbstractASLHsmTarget abstractASLHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = abstractASLHsmTarget;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.trans(this.this$0.stateActive);
                break;
            }
            default: {
                hsmState = this.this$0.stateTop;
            }
        }
        return hsmState;
    }
}

