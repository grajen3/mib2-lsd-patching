/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.load;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.load.PersistenceLoadNamespaceTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class StateInactive
extends AbstractHsmState {
    private final PersistenceLoadNamespaceTarget mTarget;

    public StateInactive(PersistenceLoadNamespaceTarget persistenceLoadNamespaceTarget, HsmState hsmState) {
        super(persistenceLoadNamespaceTarget.getHsm(), "Inactive", hsmState);
        this.mTarget = persistenceLoadNamespaceTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("State Load:Inactive", true);
                break;
            }
            case 6: {
                this.trans(this.mTarget.mStateIdle);
                break;
            }
            case 7: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

