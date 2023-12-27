/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanManager;

class PersistedBooleanManager$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ PersistedBooleanManager this$0;

    PersistedBooleanManager$1(PersistedBooleanManager persistedBooleanManager) {
        this.this$0 = persistedBooleanManager;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.resetState();
        factoryResetCallback.notifyResetDone();
    }
}

