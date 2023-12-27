/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

public abstract class MethodAccessibleObject {
    public int getIndex(String string) {
        return this.getIndex(string, null);
    }

    public abstract int getIndex(String string, Class[] classArray) {
    }

    public abstract Object invoke(int n, Object object, Object[] objectArray) {
    }

    public Object invoke(String string, Class[] classArray, Object object, Object[] objectArray) {
        int n = this.getIndex(string, classArray);
        return this.invoke(n, object, objectArray);
    }
}

