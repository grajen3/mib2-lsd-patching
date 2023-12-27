/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicIntegerArray
implements Serializable {
    private static final long serialVersionUID;
    private final int[] array;

    public AtomicIntegerArray(int n) {
        this.array = new int[n];
    }

    public AtomicIntegerArray(int[] nArray) {
        if (nArray == null) {
            throw new NullPointerException();
        }
        int n = nArray.length;
        this.array = new int[n];
        System.arraycopy((Object)nArray, 0, (Object)this.array, 0, nArray.length);
    }

    public final int length() {
        return this.array.length;
    }

    public final synchronized int get(int n) {
        return this.array[n];
    }

    public final synchronized void set(int n, int n2) {
        this.array[n] = n2;
    }

    public final synchronized void lazySet(int n, int n2) {
        this.array[n] = n2;
    }

    public final synchronized int getAndSet(int n, int n2) {
        int n3 = this.array[n];
        this.array[n] = n2;
        return n3;
    }

    public final synchronized boolean compareAndSet(int n, int n2, int n3) {
        if (this.array[n] == n2) {
            this.array[n] = n3;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(int n, int n2, int n3) {
        if (this.array[n] == n2) {
            this.array[n] = n3;
            return true;
        }
        return false;
    }

    public final synchronized int getAndIncrement(int n) {
        int n2 = n;
        int n3 = this.array[n2];
        this.array[n2] = n3 + 1;
        return n3;
    }

    public final synchronized int getAndDecrement(int n) {
        int n2 = n;
        int n3 = this.array[n2];
        this.array[n2] = n3 - 1;
        return n3;
    }

    public final synchronized int getAndAdd(int n, int n2) {
        int n3 = this.array[n];
        int n4 = n;
        this.array[n4] = this.array[n4] + n2;
        return n3;
    }

    public final synchronized int incrementAndGet(int n) {
        int n2 = n;
        int n3 = this.array[n2] + 1;
        this.array[n2] = n3;
        return n3;
    }

    public final synchronized int decrementAndGet(int n) {
        int n2 = n;
        int n3 = this.array[n2] - 1;
        this.array[n2] = n3;
        return n3;
    }

    public final synchronized int addAndGet(int n, int n2) {
        int n3 = n;
        int n4 = this.array[n3] + n2;
        this.array[n3] = n4;
        return n4;
    }

    public synchronized String toString() {
        if (this.array.length == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        stringBuffer.append(this.array[0]);
        for (int i2 = 1; i2 < this.array.length; ++i2) {
            stringBuffer.append(", ");
            stringBuffer.append(this.array[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

