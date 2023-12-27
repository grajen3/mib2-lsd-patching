/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection.pool;

import de.vw.mib.reflection.pool.ObjArrayPool;

public final class DefaultObjArrayPool
extends ObjArrayPool {
    @Override
    public Object[] borrowArray(int n) {
        return new Object[n];
    }

    @Override
    public void returnArray(Object[] objectArray) {
    }
}

