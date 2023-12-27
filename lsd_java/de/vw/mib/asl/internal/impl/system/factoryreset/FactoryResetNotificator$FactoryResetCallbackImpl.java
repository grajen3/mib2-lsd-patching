/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator;

class FactoryResetNotificator$FactoryResetCallbackImpl
implements FactoryResetCallback {
    private final FactoryResetParticipant participant;
    private final /* synthetic */ FactoryResetNotificator this$0;

    public FactoryResetNotificator$FactoryResetCallbackImpl(FactoryResetNotificator factoryResetNotificator, FactoryResetParticipant factoryResetParticipant) {
        this.this$0 = factoryResetNotificator;
        this.participant = factoryResetParticipant;
    }

    @Override
    public void notifyResetDone() {
        this.this$0.markAsFinished(this);
    }

    FactoryResetParticipant getParticipant() {
        return this.participant;
    }
}

