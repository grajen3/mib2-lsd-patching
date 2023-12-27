/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostoreDab
extends AbstractHsmState {
    private final Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;

    StateAutostoreDab(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostoreDab - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                DabMainApi.startAutoStore(this.mTarget.getTargetId(), 75956480);
                break;
            }
            case 100100: {
                if (eventGeneric.getResult() != 0) {
                    this.trans(this.mTarget.stateAutostoreAbort);
                    break;
                }
                this.trans(this.mTarget.stateAutostoreDone);
                break;
            }
            case 4300053: 
            case 1073743062: {
                DabMainApi.cancelAutoStore(this.mTarget.getTargetId(), 75956480);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

