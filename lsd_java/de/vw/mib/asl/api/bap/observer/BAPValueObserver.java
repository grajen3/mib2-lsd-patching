/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.observer;

import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPValueObserver {
    default public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
    }

    default public void bapValueError(BAPValueObserverable bAPValueObserverable, int n, Object object) {
    }
}

