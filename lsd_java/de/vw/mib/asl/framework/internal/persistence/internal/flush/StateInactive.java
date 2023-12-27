/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.flush;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.FlushController;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateInactive
extends AbstractHsmState {
    private final FlushController mTarget;

    StateInactive(FlushController flushController, HsmState hsmState) {
        super(flushController.getHsm(), "Inactive", hsmState);
        this.mTarget = flushController;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("Persistence flush state is now inactive!", true);
                this.mTarget.goingInactive();
                break;
            }
            case 6: {
                this.mTarget.transStateActive();
                break;
            }
            case 100004: {
                PersDebug.trace("FlushContoller StateInactive: transition to StateShutdown", true);
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

