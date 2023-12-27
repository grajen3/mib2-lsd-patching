/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.load;

import de.vw.mib.asl.framework.internal.persistence.internal.load.PersistenceLoadNamespaceTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateTop
extends AbstractHsmState {
    private final PersistenceLoadNamespaceTarget mTarget;

    public StateTop(PersistenceLoadNamespaceTarget persistenceLoadNamespaceTarget) {
        super(persistenceLoadNamespaceTarget.getHsm(), "Top", null);
        this.mTarget = persistenceLoadNamespaceTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.trans(this.mTarget.mStateInactive);
                break;
            }
            case 7: {
                this.trans(this.mTarget.mStateInactive);
                break;
            }
            case 40405: {
                eventGeneric.setBlocked(true);
                this.mTarget.storeRequest(eventGeneric);
                break;
            }
        }
        return null;
    }
}

