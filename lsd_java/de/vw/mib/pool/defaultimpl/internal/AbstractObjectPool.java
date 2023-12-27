/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool.defaultimpl.internal;

import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.ObjectPoolMonitor;
import de.vw.mib.pool.PooledObject;

public abstract class AbstractObjectPool
implements ObjectPool {
    protected static final int EMPTY_STACK_INDEX;
    protected ObjectPoolMonitor monitor;
    protected PooledObject[] stack;

    @Override
    public void addObject() {
        this.releaseObject(this.createObjectInternal());
        if (this.monitor != null) {
            this.monitor.createNewObject();
        }
    }

    @Override
    public abstract PooledObject borrowObject() {
    }

    @Override
    public abstract void clear() {
    }

    @Override
    public abstract void releaseObject(PooledObject pooledObject) {
    }

    @Override
    public void setPoolMonitor(ObjectPoolMonitor objectPoolMonitor) {
        this.monitor = objectPoolMonitor;
        if (objectPoolMonitor != null) {
            objectPoolMonitor.init(this.size());
        }
    }

    @Override
    public abstract int size() {
    }

    protected abstract PooledObject createObjectInternal() {
    }

    protected void dropObjectInternal(PooledObject pooledObject) {
    }
}

