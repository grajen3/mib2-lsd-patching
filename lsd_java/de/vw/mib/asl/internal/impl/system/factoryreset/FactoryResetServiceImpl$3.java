/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceImpl;
import de.vw.mib.asl.internal.system.util.AsyncServiceListeners$Notificator;

class FactoryResetServiceImpl$3
implements AsyncServiceListeners$Notificator {
    private final /* synthetic */ int val$newState;
    private final /* synthetic */ FactoryResetServiceImpl this$0;

    FactoryResetServiceImpl$3(FactoryResetServiceImpl factoryResetServiceImpl, int n) {
        this.this$0 = factoryResetServiceImpl;
        this.val$newState = n;
    }

    @Override
    public void notifyListener(Object object) {
        FactoryResetListener factoryResetListener = (FactoryResetListener)object;
        factoryResetListener.onFactoryResetStateChanged(this.val$newState);
    }
}

