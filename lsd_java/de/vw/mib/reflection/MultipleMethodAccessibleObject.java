/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

public abstract class MultipleMethodAccessibleObject {
    public int getIndex(String string, String string2) {
        return this.getIndex(string, string2, null);
    }

    public abstract int getIndex(String string, String string2, Class[] classArray) {
    }

    public abstract Object invoke(int n, Object object, Object[] objectArray) {
    }

    public Object invoke(String string, String string2, Class[] classArray, Object object, Object[] objectArray) {
        int n = this.getIndex(string, string2, classArray);
        return this.invoke(n, object, objectArray);
    }
}

