/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine$ContextImpl;

class DsiStateMachine$ContextImpl$1
implements Runnable {
    private final /* synthetic */ DsiStateMachine$ContextImpl this$1;

    DsiStateMachine$ContextImpl$1(DsiStateMachine$ContextImpl dsiStateMachine$ContextImpl) {
        this.this$1 = dsiStateMachine$ContextImpl;
    }

    @Override
    public void run() {
        if (this.this$1.isActive) {
            DsiStateMachine$ContextImpl.access$000(this.this$1).getCurrentState().onTimeout(this.this$1);
        }
    }
}

