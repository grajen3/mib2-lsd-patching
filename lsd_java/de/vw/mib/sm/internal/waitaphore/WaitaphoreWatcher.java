/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.waitaphore;

import de.vw.mib.sm.internal.waitaphore.WaitaphoreObserver;

public interface WaitaphoreWatcher {
    default public void lockWaitaphore(int n, int n2) {
    }

    default public void enterPropertyWaitaphore(int n, WaitaphoreObserver waitaphoreObserver) {
    }

    default public void leavePropertyWaitaphore(int n, WaitaphoreObserver waitaphoreObserver) {
    }
}

