/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool;

import de.vw.mib.pool.ObjectPoolMonitor;
import de.vw.mib.pool.PooledObject;

public interface ObjectPool {
    default public void addObject() {
    }

    default public PooledObject borrowObject() {
    }

    default public void clear() {
    }

    default public void releaseObject(PooledObject pooledObject) {
    }

    default public void setPoolMonitor(ObjectPoolMonitor objectPoolMonitor) {
    }

    default public int size() {
    }
}

