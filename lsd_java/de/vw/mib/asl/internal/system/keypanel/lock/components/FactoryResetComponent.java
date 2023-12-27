/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;

public class FactoryResetComponent
extends AbstractLockStateComponent
implements FactoryResetListener {
    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        return true;
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        switch (n) {
            case 1: {
                this.setLocked(true);
                break;
            }
            case 0: {
                this.setLocked(false);
                break;
            }
        }
    }
}

