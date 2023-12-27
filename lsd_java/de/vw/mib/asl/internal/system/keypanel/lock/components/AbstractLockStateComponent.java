/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.internal.system.keypanel.lock.components.KeyLockComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.KeyLockComponentListener;
import de.vw.mib.asl.internal.system.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractLockStateComponent
implements KeyLockComponent {
    private final Set listeners = new HashSet();
    private boolean isLocked;

    @Override
    public final boolean isLocked(int n, int n2) {
        return this.checkIsKeyApplicable(n, n2) && this.isLocked;
    }

    @Override
    public void addListener(KeyLockComponentListener keyLockComponentListener) {
        Preconditions.checkArgumentNotNull(keyLockComponentListener);
        this.listeners.add(keyLockComponentListener);
    }

    @Override
    public void removeListener(KeyLockComponentListener keyLockComponentListener) {
        this.listeners.remove(keyLockComponentListener);
    }

    protected abstract boolean checkIsKeyApplicable(int n, int n2) {
    }

    protected final void setLocked(boolean bl) {
        this.isLocked = bl;
        this.fireOnLockStateChanged();
    }

    private void fireOnLockStateChanged() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            KeyLockComponentListener keyLockComponentListener = (KeyLockComponentListener)iterator.next();
            keyLockComponentListener.onLockStateChanged();
        }
    }
}

