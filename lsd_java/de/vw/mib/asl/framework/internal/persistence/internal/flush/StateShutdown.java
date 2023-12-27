/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.flush;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.FlushController;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateShutdown
extends AbstractHsmState {
    private final FlushController mTarget;

    StateShutdown(FlushController flushController, HsmState hsmState) {
        super(flushController.getHsm(), "Shutdown", hsmState);
        this.mTarget = flushController;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("FlushContoller StateShutdown event HSM_ENTRY startTimer EV_TIMER_SHUTDOWN", true);
                this.mTarget.startTimer(-1517944576, (long)0, false);
                break;
            }
            case 100005: {
                PersDebug.trace("FlushContoller StateShutdown event EV_TIMER_SHUTDOWN initiate flush", true);
                this.mTarget.forceFlush();
                this.mTarget.incomingFlushRequest();
                this.mTarget.setShutdownFlushPerformed(true);
                break;
            }
            case 100008: {
                PersDebug.trace("FlushContoller StateShutdown event EV_ABORT_SHUTDOWN stopTimer EV_TIMER_SHUTDOWN", true);
                this.mTarget.stopTimer(-1517944576);
                this.mTarget.setShutdownFlushPerformed(false);
                this.mTarget.transStateActive();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

