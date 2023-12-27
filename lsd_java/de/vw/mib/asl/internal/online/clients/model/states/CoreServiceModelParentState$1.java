/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.states;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.internal.online.clients.model.states.CoreServiceModelParentState;

class CoreServiceModelParentState$1
implements StartupStateListener {
    private final /* synthetic */ CoreServiceModelParentState this$0;

    CoreServiceModelParentState$1(CoreServiceModelParentState coreServiceModelParentState) {
        this.this$0 = coreServiceModelParentState;
    }

    @Override
    public void onStartupStateChanged(int n) {
        boolean bl;
        boolean bl2 = bl = n == 2;
        if (bl) {
            // empty if block
        }
    }
}

