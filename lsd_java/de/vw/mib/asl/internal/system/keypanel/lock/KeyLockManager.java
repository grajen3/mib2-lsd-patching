/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager$1;
import de.vw.mib.asl.internal.system.keypanel.lock.LockStateListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.KeyLockComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.KeyLockComponentListener;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyLockManager {
    private final List lockStateComponents = new ArrayList();
    private final List listeners = new ArrayList();
    private final Logger logger;
    private final KeyLockComponentListener componentListener = new KeyLockManager$1(this);

    public KeyLockManager(Logger logger) {
        Preconditions.checkArgumentNotNull(logger);
        this.logger = logger;
    }

    public boolean isLocked(int n, int n2) {
        if (this.lockStateComponents.isEmpty()) {
            this.logger.warn(2048, "The key lock components are not registered.");
        }
        Iterator iterator = this.lockStateComponents.iterator();
        while (iterator.hasNext()) {
            KeyLockComponent keyLockComponent = (KeyLockComponent)iterator.next();
            if (!keyLockComponent.isLocked(n, n2)) continue;
            return true;
        }
        return false;
    }

    public void addComponent(KeyLockComponent keyLockComponent) {
        if (keyLockComponent == null) {
            throw new IllegalArgumentException("A new keyLockComponent must not be null.");
        }
        this.lockStateComponents.add(keyLockComponent);
        keyLockComponent.addListener(this.componentListener);
    }

    public void removeComponent(KeyLockComponent keyLockComponent) {
        this.lockStateComponents.remove(keyLockComponent);
    }

    public void addListener(LockStateListener lockStateListener) {
        this.verifyListener(lockStateListener);
        this.listeners.add(lockStateListener);
    }

    public void removeListener(LockStateListener lockStateListener) {
        this.listeners.remove(lockStateListener);
    }

    void onComponentChanged() {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ((LockStateListener)this.listeners.get(i2)).onComponentChanged();
        }
    }

    private void verifyListener(LockStateListener lockStateListener) {
        if (lockStateListener == null) {
            throw new IllegalArgumentException("LockStateListener must not be null.");
        }
        if (this.listeners.contains(lockStateListener)) {
            throw new IllegalArgumentException("The given lock state listener was added before.");
        }
    }
}

