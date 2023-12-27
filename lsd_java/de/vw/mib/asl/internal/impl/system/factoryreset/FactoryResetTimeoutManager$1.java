/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator$FactoryResetNotificatorCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer;

class FactoryResetTimeoutManager$1
implements FactoryResetNotificator$FactoryResetNotificatorCallback {
    private final /* synthetic */ FactoryResetTimer val$currentTimer;
    private final /* synthetic */ FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback val$currentCallback;
    private final /* synthetic */ FactoryResetTimeoutManager this$0;

    FactoryResetTimeoutManager$1(FactoryResetTimeoutManager factoryResetTimeoutManager, FactoryResetTimer factoryResetTimer, FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback) {
        this.this$0 = factoryResetTimeoutManager;
        this.val$currentTimer = factoryResetTimer;
        this.val$currentCallback = factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback;
    }

    @Override
    public void notificationCompleted() {
        this.val$currentTimer.stopTimer();
        this.this$0.clearNotificator();
        this.val$currentCallback.notificationCompleted();
    }
}

