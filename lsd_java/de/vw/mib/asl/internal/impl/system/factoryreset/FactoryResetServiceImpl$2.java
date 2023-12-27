/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceImpl;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback;

class FactoryResetServiceImpl$2
implements FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback {
    private final /* synthetic */ FactoryResetServiceImpl this$0;

    FactoryResetServiceImpl$2(FactoryResetServiceImpl factoryResetServiceImpl) {
        this.this$0 = factoryResetServiceImpl;
    }

    @Override
    public void notificationCompleted() {
        this.this$0.performPostResetActions();
    }
}

