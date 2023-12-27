/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection.pool;

import de.vw.mib.pool.PoorMansPool;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.util.Arrays;

public final class SimpleObjArrayPool
extends ObjArrayPool {
    private static final int MAX_ELEMENTS_PER_POOL;
    public static final int DEF_INIT_POOLS_IDX;
    private static final Object[] EMPTY_ARRAY;
    private PoorMansPool[] pools;

    public SimpleObjArrayPool() {
        this(5);
    }

    public SimpleObjArrayPool(int n) {
        this.pools = new PoorMansPool[Math.max(0, n - 1)];
    }

    @Override
    public Object[] borrowArray(int n) {
        PoorMansPool poorMansPool;
        Object[] objectArray;
        if (0 == n) {
            objectArray = EMPTY_ARRAY;
        } else if (n > this.pools.length || null == (poorMansPool = this.pools[n - 1]) || null == (objectArray = (Object[])poorMansPool.borrow())) {
            objectArray = new Object[n];
        }
        return objectArray;
    }

    @Override
    public void returnArray(Object[] objectArray) {
        Object object;
        int n = objectArray.length;
        if (this.pools.length < n) {
            object = new PoorMansPool[n];
            System.arraycopy((Object)this.pools, 0, object, 0, this.pools.length);
            this.pools = object;
        }
        if (0 < n) {
            object = this.pools[n - 1];
            if (null == object) {
                object = new PoorMansPool(new StringBuffer().append("DSIProxy.Object[").append(n).append("]").toString(), 20);
                this.pools[n - 1] = object;
            }
            Arrays.fill(objectArray, null);
            ((PoorMansPool)object).release(objectArray);
        }
    }

    static {
        EMPTY_ARRAY = new Object[0];
    }
}

