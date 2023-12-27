/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.load;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.load.PersistenceLoadNamespaceTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateIdle
extends AbstractHsmState {
    private final PersistenceLoadNamespaceTarget mTarget;

    public StateIdle(PersistenceLoadNamespaceTarget persistenceLoadNamespaceTarget, HsmState hsmState) {
        super(persistenceLoadNamespaceTarget.getHsm(), "Idle", hsmState);
        this.mTarget = persistenceLoadNamespaceTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                PersDebug.trace("State Load:Idle", true);
                this.mTarget.mCurrentRequest = this.mTarget.nextRequest();
                if (this.mTarget.mCurrentRequest == null) break;
                this.trans(this.mTarget.mStateWork);
                break;
            }
            case 40405: {
                this.mTarget.mCurrentRequest = eventGeneric;
                this.trans(this.mTarget.mStateWork);
                break;
            }
            case 7: {
                this.trans(this.mTarget.mStateInactive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

