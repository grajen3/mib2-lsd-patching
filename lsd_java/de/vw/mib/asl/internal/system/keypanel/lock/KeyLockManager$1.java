/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager;
import de.vw.mib.asl.internal.system.keypanel.lock.components.KeyLockComponentListener;

class KeyLockManager$1
implements KeyLockComponentListener {
    private final /* synthetic */ KeyLockManager this$0;

    KeyLockManager$1(KeyLockManager keyLockManager) {
        this.this$0 = keyLockManager;
    }

    @Override
    public void onLockStateChanged() {
        this.this$0.onComponentChanged();
    }
}

