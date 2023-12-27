/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.commons.datapool;

import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.debug.commons.datapool.DebugDatapoolObserver;

public interface DebugDatapool {
    default public Object getProperty(int n) {
    }

    default public IntSet getIdsOfCreatedProperties() {
    }

    default public void addDebugDatapoolObserver(DebugDatapoolObserver debugDatapoolObserver) {
    }

    default public void removeDebugDatapoolObserver(DebugDatapoolObserver debugDatapoolObserver) {
    }
}

