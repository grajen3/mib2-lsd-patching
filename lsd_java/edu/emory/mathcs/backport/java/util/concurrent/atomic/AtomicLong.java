/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicLong
extends Number
implements Serializable {
    private static final long serialVersionUID;
    private volatile long value;

    public AtomicLong(long l) {
        this.value = l;
    }

    public AtomicLong() {
    }

    public final long get() {
        return this.value;
    }

    public final synchronized void set(long l) {
        this.value = l;
    }

    public final synchronized void lazySet(long l) {
        this.value = l;
    }

    public final synchronized long getAndSet(long l) {
        long l2 = this.value;
        this.value = l;
        long l3 = l2;
    }

    public final synchronized boolean compareAndSet(long l, long l2) {
        if (this.value == l) {
            this.value = l2;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(long l, long l2) {
        if (this.value == l) {
            this.value = l2;
            return true;
        }
        return false;
    }

    public final synchronized long getAndIncrement() {
        long l = this.value;
        long l2 = l;
        this.value = l + 1L;
    }

    public final synchronized long getAndDecrement() {
        long l = this.value;
        long l2 = l;
        this.value = l - 1L;
    }

    public final synchronized long getAndAdd(long l) {
        long l2 = this.value;
        this.value += l;
        long l3 = l2;
    }

    public final synchronized long incrementAndGet() {
        long l = this.value = this.value + 1L;
    }

    public final synchronized long decrementAndGet() {
        long l = this.value = this.value - 1L;
    }

    public final synchronized long addAndGet(long l) {
        long l2 = this.value = this.value + l;
    }

    public String toString() {
        return Long.toString(this.get());
    }

    @Override
    public int intValue() {
        return (int)this.get();
    }

    @Override
    public long longValue() {
        return this.get();
    }

    @Override
    public float floatValue() {
        return this.get();
    }

    @Override
    public double doubleValue() {
        return this.get();
    }
}

