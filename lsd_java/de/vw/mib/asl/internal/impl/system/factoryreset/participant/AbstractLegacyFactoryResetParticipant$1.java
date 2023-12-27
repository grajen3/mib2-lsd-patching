/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.AbstractLegacyFactoryResetParticipant;

class AbstractLegacyFactoryResetParticipant$1
implements Runnable {
    private final /* synthetic */ FactoryResetCallback val$callback;
    private final /* synthetic */ AbstractLegacyFactoryResetParticipant this$0;

    AbstractLegacyFactoryResetParticipant$1(AbstractLegacyFactoryResetParticipant abstractLegacyFactoryResetParticipant, FactoryResetCallback factoryResetCallback) {
        this.this$0 = abstractLegacyFactoryResetParticipant;
        this.val$callback = factoryResetCallback;
    }

    @Override
    public void run() {
        this.val$callback.notifyResetDone();
    }
}

