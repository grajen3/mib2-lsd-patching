/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.FullFactoryResetParticipant;

class FullFactoryResetParticipant$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ FullFactoryResetParticipant this$0;

    FullFactoryResetParticipant$1(FullFactoryResetParticipant fullFactoryResetParticipant) {
        this.this$0 = fullFactoryResetParticipant;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistence();
        this.notifyProfileChanged(true);
    }
}

