/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode;

import de.vw.mib.asl.framework.internal.diagnosis.diagmode.TargetDiagModeGeneric;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class TargetDiagModeGeneric$StateTop
extends AbstractHsmState {
    private final /* synthetic */ TargetDiagModeGeneric this$0;

    TargetDiagModeGeneric$StateTop(TargetDiagModeGeneric targetDiagModeGeneric, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = targetDiagModeGeneric;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.registerObservers();
                break;
            }
            case 3: {
                this.trans(this.this$0.stateInitial);
                break;
            }
        }
        return hsmState;
    }
}

