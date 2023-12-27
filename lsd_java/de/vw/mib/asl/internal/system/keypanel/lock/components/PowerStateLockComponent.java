/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.api.system.powerstate.PowerStateService;
import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.PowerStateLockComponent$1;

public class PowerStateLockComponent
extends AbstractLockStateComponent {
    public PowerStateLockComponent(PowerStateService powerStateService) {
        this.updateLockStatusForPowerState(powerStateService.getPowerState());
        powerStateService.addListener(this.createPowerStateListener());
    }

    void updateLockStatusForPowerState(int n) {
        boolean bl = n == 0 || n == 1;
        this.setLocked(bl);
    }

    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        return n2 != 79;
    }

    private PowerStateListener createPowerStateListener() {
        return new PowerStateLockComponent$1(this);
    }
}

