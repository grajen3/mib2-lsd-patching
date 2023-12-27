/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.flush;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.FlushController;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateActive
extends AbstractHsmState {
    private final FlushController mTarget;

    StateActive(FlushController flushController, HsmState hsmState) {
        super(flushController.getHsm(), "Active", hsmState);
        this.mTarget = flushController;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("Persistence flush state is now active!", true);
                this.mTarget.goingActive();
                break;
            }
            case 7: {
                this.mTarget.transStateInactive();
                break;
            }
            case 100004: {
                PersDebug.trace("FlushContoller StateActive EV_SHUTDOWN", true);
                this.mTarget.transStateShutdown();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

