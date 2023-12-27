/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

public abstract class MultipleConstructorAccessibleObject {
    public int getIndex(String string) {
        return this.getIndex(string, null);
    }

    public abstract int getIndex(String string, Class[] classArray) {
    }

    public abstract Object newInstance(int n, Object[] objectArray) {
    }

    public Object newInstance(String string, Class[] classArray, Object[] objectArray) {
        int n = this.getIndex(string, classArray);
        return this.newInstance(n, objectArray);
    }
}

