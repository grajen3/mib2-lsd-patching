/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer$TimeoutListener;

class FactoryResetNotificator$1
implements FactoryResetTimer$TimeoutListener {
    private final /* synthetic */ FactoryResetNotificator this$0;

    FactoryResetNotificator$1(FactoryResetNotificator factoryResetNotificator) {
        this.this$0 = factoryResetNotificator;
    }

    @Override
    public void notifyTimeout() {
        this.this$0.processTimeoutNotification();
    }
}

