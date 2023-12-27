/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class AbstractASLHsmTarget$ASLHsmBaseStateActive
extends AbstractHsmState {
    private final /* synthetic */ AbstractASLHsmTarget this$0;

    public AbstractASLHsmTarget$ASLHsmBaseStateActive(AbstractASLHsmTarget abstractASLHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = abstractASLHsmTarget;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this.this$0.getTextLogger().isTraceEnabled(2)) break;
                this.this$0.getTextLogger().trace(2).append("Context with target ID ").append(this.this$0.getTargetId()).append(" started.").log();
                break;
            }
            case 3: {
                HsmState hsmState2 = this.this$0.getDefaultState();
                if (hsmState2 == null) break;
                this.trans(hsmState2);
                break;
            }
            case 107: {
                this.trans(this.this$0.stateInactive);
                break;
            }
            case 9: {
                this.trans(this.this$0.stateInactive);
                break;
            }
            case 4: {
                if (!this.this$0.getTextLogger().isTraceEnabled(2)) break;
                this.this$0.getTextLogger().trace(2).append("Context with target ID ").append(this.this$0.getTargetId()).append(" stopped.").log();
                break;
            }
            default: {
                hsmState = this.this$0.stateTop;
            }
        }
        return hsmState;
    }
}

