/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool;

public interface ObjectArrayPool {
    default public Object[] borrow(int n) {
    }

    default public void release(Object[] objectArray) {
    }
}

