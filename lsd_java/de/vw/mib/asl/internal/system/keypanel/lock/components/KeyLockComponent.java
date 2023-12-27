/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.internal.system.keypanel.lock.components.KeyLockComponentListener;

public interface KeyLockComponent {
    default public boolean isLocked(int n, int n2) {
    }

    default public void addListener(KeyLockComponentListener keyLockComponentListener) {
    }

    default public void removeListener(KeyLockComponentListener keyLockComponentListener) {
    }
}

