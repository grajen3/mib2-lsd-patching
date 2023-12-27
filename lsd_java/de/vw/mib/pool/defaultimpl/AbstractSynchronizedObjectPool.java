/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool.defaultimpl;

import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.internal.AbstractObjectPool;
import java.util.Arrays;

public abstract class AbstractSynchronizedObjectPool
extends AbstractObjectPool {
    private volatile int currentIndex = -1;
    private final int limitIndex;

    public AbstractSynchronizedObjectPool(int n) {
        this.stack = new PooledObject[n];
        this.limitIndex = n - 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public PooledObject borrowObject() {
        PooledObject pooledObject = null;
        AbstractSynchronizedObjectPool abstractSynchronizedObjectPool = this;
        synchronized (abstractSynchronizedObjectPool) {
            if (this.currentIndex >= 0) {
                pooledObject = this.stack[this.currentIndex];
                this.stack[this.currentIndex--] = null;
            }
        }
        if (pooledObject == null) {
            pooledObject = this.createObjectInternal();
            if (this.monitor != null) {
                this.monitor.createNewObject();
            }
        } else if (this.monitor != null) {
            this.monitor.removeObjectFromPool();
        }
        return pooledObject;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        AbstractSynchronizedObjectPool abstractSynchronizedObjectPool = this;
        synchronized (abstractSynchronizedObjectPool) {
            Arrays.fill(this.stack, null);
            this.currentIndex = -1;
        }
        if (this.monitor != null) {
            this.monitor.clearObjectPool();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releaseObject(PooledObject pooledObject) {
        boolean bl;
        pooledObject.backToPool();
        AbstractSynchronizedObjectPool abstractSynchronizedObjectPool = this;
        synchronized (abstractSynchronizedObjectPool) {
            if (this.currentIndex < this.limitIndex) {
                this.stack[++this.currentIndex] = pooledObject;
                bl = true;
            } else {
                this.dropObjectInternal(pooledObject);
                bl = false;
            }
        }
        if (this.monitor != null) {
            if (bl) {
                this.monitor.addObjectToPool();
            } else {
                this.monitor.dropObject();
            }
        }
    }

    @Override
    public int size() {
        return this.currentIndex + 1;
    }
}

