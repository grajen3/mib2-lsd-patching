/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.PowerStateLockComponent;

class PowerStateLockComponent$1
implements PowerStateListener {
    private final /* synthetic */ PowerStateLockComponent this$0;

    PowerStateLockComponent$1(PowerStateLockComponent powerStateLockComponent) {
        this.this$0 = powerStateLockComponent;
    }

    @Override
    public void onNewPowerState(int n) {
        this.this$0.updateLockStatusForPowerState(n);
    }
}

