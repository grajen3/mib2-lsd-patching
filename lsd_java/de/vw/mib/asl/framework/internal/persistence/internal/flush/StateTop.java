/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.flush;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.FlushController;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateTop
extends AbstractHsmState {
    private final FlushController mTarget;

    StateTop(FlushController flushController, HsmState hsmState) {
        super(flushController.getHsm(), "Top", hsmState);
        this.mTarget = flushController;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.mTarget.transStateInactive();
                int n = this.mTarget.createNextTimeout() * 1000;
                this.mTarget.nextTimeout(n);
                this.mTarget.startTimer(-1568276224, (long)n, false);
                this.mTarget.startTimer(-1551499008, (long)0, true);
                break;
            }
            case 100003: {
                this.mTarget.stat();
                break;
            }
            case 100002: {
                this.mTarget.nextTimeoutReached();
                int n = this.mTarget.createNextTimeout() * 1000;
                this.mTarget.nextTimeout(n);
                this.mTarget.startTimer(-1568276224, (long)n, false);
                break;
            }
            case 100007: {
                PersDebug.trace("FlushContoller StateTop startTimer EV_TIMER_DELAY", true);
                this.mTarget.startTimer(-1501167360, (long)0, false);
                break;
            }
            case 100001: 
            case 100006: {
                this.mTarget.incomingFlushRequest();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

