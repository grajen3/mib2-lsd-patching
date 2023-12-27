/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.DsiReadyForProfileChangesObserver;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine$DsiStateChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;

class DsiReadyForProfileChangesObserver$1
implements DsiStateMachine$DsiStateChangeListener {
    int countDown;
    private final /* synthetic */ int val$numberOfDsiAdapters;
    private final /* synthetic */ DsiReadyForProfileChangesObserver this$0;

    DsiReadyForProfileChangesObserver$1(DsiReadyForProfileChangesObserver dsiReadyForProfileChangesObserver, int n) {
        this.this$0 = dsiReadyForProfileChangesObserver;
        this.val$numberOfDsiAdapters = n;
        this.countDown = this.val$numberOfDsiAdapters;
    }

    @Override
    public void onStateChanged(State state) {
        if (!state.isFinalState()) {
            return;
        }
        --this.countDown;
        if (this.countDown == 0) {
            this.this$0.onAllModulDsisReady();
        }
    }
}

