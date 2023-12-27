/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection.pool;

import de.vw.mib.reflection.pool.ObjArrayPool;
import de.vw.mib.reflection.pool.SimpleObjArrayPool;

public final class SynchronizedObjArrayPool
extends ObjArrayPool {
    private final ObjArrayPool pool;

    public SynchronizedObjArrayPool() {
        this.pool = new SimpleObjArrayPool();
    }

    public SynchronizedObjArrayPool(int n, int n2) {
        this(n);
    }

    public SynchronizedObjArrayPool(int n) {
        this.pool = new SimpleObjArrayPool(n);
    }

    public SynchronizedObjArrayPool(ObjArrayPool objArrayPool) {
        this.pool = objArrayPool;
    }

    @Override
    public synchronized Object[] borrowArray(int n) {
        return this.pool.borrowArray(n);
    }

    @Override
    public synchronized void returnArray(Object[] objectArray) {
        this.pool.returnArray(objectArray);
    }
}

