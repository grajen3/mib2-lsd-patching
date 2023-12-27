/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicReferenceArray
implements Serializable {
    private static final long serialVersionUID;
    private final Object[] array;

    public AtomicReferenceArray(int n) {
        this.array = new Object[n];
    }

    public AtomicReferenceArray(Object[] objectArray) {
        if (objectArray == null) {
            throw new NullPointerException();
        }
        int n = objectArray.length;
        this.array = new Object[n];
        System.arraycopy((Object)objectArray, 0, (Object)this.array, 0, objectArray.length);
    }

    public final int length() {
        return this.array.length;
    }

    public final synchronized Object get(int n) {
        return this.array[n];
    }

    public final synchronized void set(int n, Object object) {
        this.array[n] = object;
    }

    public final synchronized void lazySet(int n, Object object) {
        this.array[n] = object;
    }

    public final synchronized Object getAndSet(int n, Object object) {
        Object object2 = this.array[n];
        this.array[n] = object;
        return object2;
    }

    public final synchronized boolean compareAndSet(int n, Object object, Object object2) {
        if (this.array[n] == object) {
            this.array[n] = object2;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(int n, Object object, Object object2) {
        if (this.array[n] == object) {
            this.array[n] = object2;
            return true;
        }
        return false;
    }

    public synchronized String toString() {
        if (this.array.length == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.array.length; ++i2) {
            if (i2 == 0) {
                stringBuffer.append('[');
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.valueOf(this.array[i2]));
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

