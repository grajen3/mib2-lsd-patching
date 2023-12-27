/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.autostore.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

final class StateAutostoreTop
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private Logger logger = ServiceManager.logger;

    StateAutostoreTop(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("StateAutostoreTop - Event-ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.registerObservers();
                break;
            }
            case 3: {
                this.mTarget.registerDSIProxy();
                this.trans(this.mTarget.stateAutostoreIdle);
                break;
            }
            case 4300053: {
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

