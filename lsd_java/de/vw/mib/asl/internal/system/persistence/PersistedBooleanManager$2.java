/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanManager;

class PersistedBooleanManager$2
extends AbstractProfileChangeHandler {
    private final /* synthetic */ PersistedBooleanManager this$0;

    PersistedBooleanManager$2(PersistedBooleanManager persistedBooleanManager) {
        this.this$0 = persistedBooleanManager;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistedData();
        this.notifyProfileChanged(true);
    }
}

