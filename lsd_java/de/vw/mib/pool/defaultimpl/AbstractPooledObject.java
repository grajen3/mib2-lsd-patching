/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool.defaultimpl;

import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;

public abstract class AbstractPooledObject
implements PooledObject {
    protected ObjectPool pool;

    public AbstractPooledObject(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    public void releaseObject() {
        this.pool.releaseObject(this);
    }

    @Override
    public void backToPool() {
    }
}

