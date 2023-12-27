/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

public abstract class ConstructorAccessibleObject {
    public abstract int getIndex(Class[] classArray) {
    }

    public abstract Object newInstance(int n, Object[] objectArray) {
    }

    public Object newInstance(Class[] classArray, Object[] objectArray) {
        int n = this.getIndex(classArray);
        return this.newInstance(n, objectArray);
    }
}

