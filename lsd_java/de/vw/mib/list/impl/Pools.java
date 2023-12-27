/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.pool.ObjectArrayPool;
import de.vw.mib.pool.PoorMansObjectArrayPool;
import de.vw.mib.pool.PoorMansPool;
import java.util.ArrayList;
import java.util.Collection;

class Pools {
    private static final int MAX_ARRAYLIST_POOL_SIZE;
    private static final PoorMansPool ARRAYLIST_POOL;
    private static final int MAX_OBJECT_ARRAY_LEN;
    private static final int MAX_OBJECT_ARRAY_POOL_SIZE;
    private static final ObjectArrayPool OBJECT_ARRAY_POOL;

    Pools() {
    }

    static ArrayList borrowArrayList() {
        ArrayList arrayList = (ArrayList)ARRAYLIST_POOL.borrow();
        if (null == arrayList) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    static void releaseArrayList(ArrayList arrayList) {
        if (null != arrayList) {
            arrayList.clear();
            ARRAYLIST_POOL.release(arrayList);
        }
    }

    static Object[] toArray(Collection collection) {
        int n = collection.size();
        Object[] objectArray = Pools.borrowObjectArray(n);
        return collection.toArray(objectArray);
    }

    static Object[] borrowObjectArray(int n) {
        return OBJECT_ARRAY_POOL.borrow(n);
    }

    static void releaseObjectArray(Object[] objectArray) {
        OBJECT_ARRAY_POOL.release(objectArray);
    }

    static {
        ARRAYLIST_POOL = new PoorMansPool("HMIList.Pools.ArrayList", 20);
        OBJECT_ARRAY_POOL = new PoorMansObjectArrayPool("HMIList.Pools", 40, 10);
    }
}

