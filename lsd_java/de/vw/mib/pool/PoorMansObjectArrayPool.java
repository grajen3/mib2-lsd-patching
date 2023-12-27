/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool;

import de.vw.mib.pool.ObjectArrayPool;
import de.vw.mib.pool.PoorMansPool;
import java.util.Arrays;

public class PoorMansObjectArrayPool
implements ObjectArrayPool {
    public static final int DEFAULT_MAX_ELEMENTS_PER_POOL;
    public static final int DEFAULT_MAX_ARRAY_LEN;
    private static final int DEFAULT_INIT_SIZE;
    private static final Object[] EMPTY_ARRAY;
    private final String name;
    private final int maxArrayLen;
    private final int maxElements;
    private PoorMansPool[] pools;

    public PoorMansObjectArrayPool(String string) {
        this(string, 20, 20);
    }

    public PoorMansObjectArrayPool(String string, int n) {
        this(string, n, 20);
    }

    public PoorMansObjectArrayPool(String string, int n, int n2) {
        if (1 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("maxArrayLen=").append(n).append(" < 1").toString());
        }
        this.name = string;
        this.maxArrayLen = n;
        this.maxElements = Math.max(n2, 10);
        this.pools = new PoorMansPool[Math.min(n, 10)];
    }

    @Override
    public synchronized Object[] borrow(int n) {
        PoorMansPool poorMansPool;
        Object[] objectArray;
        if (0 > n) {
            throw new IllegalArgumentException(new StringBuffer().append("len=").append(n).append(" < 0").toString());
        }
        if (0 == n) {
            objectArray = EMPTY_ARRAY;
        } else if (n > this.pools.length || null == (poorMansPool = this.pools[n - 1]) || null == (objectArray = (Object[])poorMansPool.borrow())) {
            objectArray = new Object[n];
        }
        return objectArray;
    }

    @Override
    public synchronized void release(Object[] objectArray) {
        int n;
        int n2 = n = null != objectArray ? objectArray.length : 0;
        if (0 < n && n <= this.maxArrayLen) {
            Object object;
            if (this.pools.length < n) {
                object = new PoorMansPool[n];
                System.arraycopy((Object)this.pools, 0, object, 0, this.pools.length);
                this.pools = object;
            }
            if (null == (object = this.pools[n - 1])) {
                object = new PoorMansPool(new StringBuffer().append(this.name).append(".Object[").append(n).append("]").toString(), this.maxElements);
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

