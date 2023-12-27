/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateAwaitDsiReadyForProfileChanges;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.StateAwaitDsiStarted;

class StateAwaitDsiStarted$1
extends DSIServiceStateListenerAdapter {
    private final /* synthetic */ Context val$stateContext;
    private final /* synthetic */ StateAwaitDsiStarted this$0;

    StateAwaitDsiStarted$1(StateAwaitDsiStarted stateAwaitDsiStarted, Context context) {
        this.this$0 = stateAwaitDsiStarted;
        this.val$stateContext = context;
    }

    @Override
    public void registered(String string, int n) {
        this.val$stateContext.transitionToState(new StateAwaitDsiReadyForProfileChanges());
    }
}

