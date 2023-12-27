/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.asl.framework.internal.persistence.internal.main.PersistenceMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateFlashOk
extends AbstractHsmState {
    private final PersistenceMainTarget mTarget;

    public StateFlashOk(PersistenceMainTarget persistenceMainTarget, String string, HsmState hsmState) {
        super(persistenceMainTarget.getHsm(), string, hsmState);
        this.mTarget = persistenceMainTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("State Main:FlashOk", true);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), 5122, 6);
                this.mTarget.send(eventGeneric2);
                break;
            }
            case 3: {
                this.trans(this.mTarget.mStateIdle);
                break;
            }
            case 4: {
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), 5122, 7);
                this.mTarget.send(eventGeneric3);
                ApiPersFlush.deactivate();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

