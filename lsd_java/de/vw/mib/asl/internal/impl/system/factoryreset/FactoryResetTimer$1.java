/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer$TimeoutListener;

class FactoryResetTimer$1
implements Runnable {
    private final /* synthetic */ FactoryResetTimer$TimeoutListener val$listener;
    private final /* synthetic */ FactoryResetTimer this$0;

    FactoryResetTimer$1(FactoryResetTimer factoryResetTimer, FactoryResetTimer$TimeoutListener factoryResetTimer$TimeoutListener) {
        this.this$0 = factoryResetTimer;
        this.val$listener = factoryResetTimer$TimeoutListener;
    }

    @Override
    public void run() {
        this.this$0.stopTimer();
        this.val$listener.notifyTimeout();
    }
}

