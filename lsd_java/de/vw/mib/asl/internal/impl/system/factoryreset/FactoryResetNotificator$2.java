/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator;

class FactoryResetNotificator$2
implements Runnable {
    private final /* synthetic */ FactoryResetParticipant val$participant;
    private final /* synthetic */ FactoryResetCallback val$callback;
    private final /* synthetic */ int val$trigger;
    private final /* synthetic */ FactoryResetNotificator this$0;

    FactoryResetNotificator$2(FactoryResetNotificator factoryResetNotificator, FactoryResetParticipant factoryResetParticipant, FactoryResetCallback factoryResetCallback, int n) {
        this.this$0 = factoryResetNotificator;
        this.val$participant = factoryResetParticipant;
        this.val$callback = factoryResetCallback;
        this.val$trigger = n;
    }

    @Override
    public void run() {
        this.val$participant.reset(this.val$callback, this.val$trigger);
    }
}

