/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.load;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.internal.load.StateIdle;
import de.vw.mib.asl.framework.internal.persistence.internal.load.StateInactive;
import de.vw.mib.asl.framework.internal.persistence.internal.load.StateTop;
import de.vw.mib.asl.framework.internal.persistence.internal.load.StateWork;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import java.util.LinkedList;
import java.util.List;

public final class PersistenceLoadNamespaceTarget
extends TargetHsmImpl {
    final HsmState mStateTop = new StateTop(this);
    final HsmState mStateInactive = new StateInactive(this, this.mStateTop);
    final HsmState mStateIdle = new StateIdle(this, this.mStateTop);
    final HsmState mStateWork = new StateWork(this, this.mStateTop);
    EventGeneric mCurrentRequest = null;
    private final List mPendingRequests = new LinkedList();

    public PersistenceLoadNamespaceTarget() {
        this.startHsmAndRegisterTarget(ServiceManager.eventMain, 5122, "hsmtask", this.mStateTop);
        this.hsm.verbose = false;
    }

    void storeRequest(EventGeneric eventGeneric) {
        this.mPendingRequests.add(eventGeneric);
    }

    EventGeneric nextRequest() {
        if (!this.mPendingRequests.isEmpty()) {
            return (EventGeneric)this.mPendingRequests.remove(0);
        }
        return null;
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }
}

