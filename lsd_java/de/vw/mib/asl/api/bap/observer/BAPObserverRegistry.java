/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.observer;

import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;

public interface BAPObserverRegistry {
    default public BAPValueObserverable getBapValueObservable(int n) {
    }

    default public void flushAllBapValueObserverables() {
    }
}

