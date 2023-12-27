/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool.defaultimpl;

import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.internal.AbstractObjectPool;
import java.util.Arrays;

public abstract class AbstractUnsynchronizedObjectPool
extends AbstractObjectPool {
    private int currentIndex = -1;
    private int limitIndex;

    public AbstractUnsynchronizedObjectPool(int n) {
        this.stack = new PooledObject[n];
        this.limitIndex = n - 1;
    }

    @Override
    public PooledObject borrowObject() {
        PooledObject pooledObject;
        if (this.currentIndex >= 0) {
            pooledObject = this.stack[this.currentIndex];
            this.stack[this.currentIndex--] = null;
            if (this.monitor != null) {
                this.monitor.removeObjectFromPool();
            }
        } else {
            pooledObject = this.createObjectInternal();
            if (this.monitor != null) {
                this.monitor.createNewObject();
            }
        }
        return pooledObject;
    }

    @Override
    public void clear() {
        Arrays.fill(this.stack, null);
        this.currentIndex = -1;
        if (this.monitor != null) {
            this.monitor.clearObjectPool();
        }
    }

    @Override
    public void releaseObject(PooledObject pooledObject) {
        pooledObject.backToPool();
        if (this.currentIndex < this.limitIndex) {
            this.stack[++this.currentIndex] = pooledObject;
            if (this.monitor != null) {
                this.monitor.addObjectToPool();
            }
        } else {
            this.dropObjectInternal(pooledObject);
            if (this.monitor != null) {
                this.monitor.dropObject();
            }
        }
    }

    @Override
    public int size() {
        return this.currentIndex + 1;
    }
}

