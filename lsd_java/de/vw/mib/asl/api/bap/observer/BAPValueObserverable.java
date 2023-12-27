/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.observer;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;

public interface BAPValueObserverable {
    default public void addObserver(BAPValueObserver bAPValueObserver, Object object) {
    }

    default public void removeObserver(BAPValueObserver bAPValueObserver) {
    }
}

