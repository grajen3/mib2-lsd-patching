/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.pool.ObjectArrayPool;
import de.vw.mib.pool.PoorMansObjectArrayPool;
import de.vw.mib.pool.PoorMansPool;
import java.util.IdentityHashMap;

public class Util {
    private static final PoorMansPool IDENTITY_MAP_POOL = new PoorMansPool("ASLClientAPI.IdentityMap", 10);
    private static final ObjectArrayPool OBJECT_ARRAY_POOL = new PoorMansObjectArrayPool("ASLClientAPI", 10, 10);

    private Util() {
    }

    public static IdentityHashMap borrowIdentityMap() {
        IdentityHashMap identityHashMap = (IdentityHashMap)IDENTITY_MAP_POOL.borrow();
        if (null == identityHashMap) {
            identityHashMap = new IdentityHashMap();
        }
        return identityHashMap;
    }

    public static Object[] borrowObjectArray(int n) {
        return OBJECT_ARRAY_POOL.borrow(n);
    }

    public static void release(IdentityHashMap identityHashMap) {
        identityHashMap.clear();
        IDENTITY_MAP_POOL.release(identityHashMap);
    }

    public static void release(Object[] objectArray) {
        OBJECT_ARRAY_POOL.release(objectArray);
    }
}

