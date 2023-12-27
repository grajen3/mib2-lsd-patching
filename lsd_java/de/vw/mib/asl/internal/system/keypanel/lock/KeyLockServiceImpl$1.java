/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockServiceImpl;
import de.vw.mib.asl.internal.system.keypanel.lock.LockStateListener;

class KeyLockServiceImpl$1
implements LockStateListener {
    private final /* synthetic */ KeyLockServiceImpl this$0;

    KeyLockServiceImpl$1(KeyLockServiceImpl keyLockServiceImpl) {
        this.this$0 = keyLockServiceImpl;
    }

    @Override
    public void onComponentChanged() {
        this.this$0.updateKeyLockState();
    }
}

