/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection.pool;

public abstract class ObjArrayPool {
    public abstract Object[] borrowArray(int n) {
    }

    public abstract void returnArray(Object[] objectArray) {
    }
}

