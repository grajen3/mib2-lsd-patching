/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.PersonalizationKeyLockComponent;

class PersonalizationKeyLockComponent$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ PersonalizationKeyLockComponent this$0;

    PersonalizationKeyLockComponent$1(PersonalizationKeyLockComponent personalizationKeyLockComponent) {
        this.this$0 = personalizationKeyLockComponent;
    }

    @Override
    public void onProfileChangeStarted() {
        this.this$0.setLocked(true);
    }

    @Override
    public void onProfileChangeCompleted() {
        this.this$0.setLocked(false);
    }
}

