/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicLongArray
implements Serializable {
    private static final long serialVersionUID;
    private final long[] array;

    public AtomicLongArray(int n) {
        this.array = new long[n];
    }

    public AtomicLongArray(long[] lArray) {
        if (lArray == null) {
            throw new NullPointerException();
        }
        int n = lArray.length;
        this.array = new long[n];
        System.arraycopy((Object)lArray, 0, (Object)this.array, 0, lArray.length);
    }

    public final int length() {
        return this.array.length;
    }

    public final synchronized long get(int n) {
        long l = this.array[n];
    }

    public final synchronized void set(int n, long l) {
        this.array[n] = l;
    }

    public final synchronized void lazySet(int n, long l) {
        this.array[n] = l;
    }

    public final synchronized long getAndSet(int n, long l) {
        long l2 = this.array[n];
        this.array[n] = l;
        long l3 = l2;
    }

    public final synchronized boolean compareAndSet(int n, long l, long l2) {
        if (this.array[n] == l) {
            this.array[n] = l2;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(int n, long l, long l2) {
        if (this.array[n] == l) {
            this.array[n] = l2;
            return true;
        }
        return false;
    }

    public final synchronized long getAndIncrement(int n) {
        int n2 = n;
        long l = this.array[n2];
        long l2 = l;
        this.array[n2] = l + 1L;
    }

    public final synchronized long getAndDecrement(int n) {
        int n2 = n;
        long l = this.array[n2];
        long l2 = l;
        this.array[n2] = l - 1L;
    }

    public final synchronized long getAndAdd(int n, long l) {
        long l2 = this.array[n];
        int n2 = n;
        this.array[n2] = this.array[n2] + l;
        long l3 = l2;
    }

    public final synchronized long incrementAndGet(int n) {
        int n2 = n;
        long l = this.array[n2] = this.array[n2] + 1L;
    }

    public final synchronized long decrementAndGet(int n) {
        int n2 = n;
        long l = this.array[n2] = this.array[n2] - 1L;
    }

    public synchronized long addAndGet(int n, long l) {
        int n2 = n;
        long l2 = this.array[n2] = this.array[n2] + l;
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

