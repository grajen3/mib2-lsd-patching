/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicInteger
extends Number
implements Serializable {
    private static final long serialVersionUID;
    private volatile int value;

    public AtomicInteger(int n) {
        this.value = n;
    }

    public AtomicInteger() {
    }

    public final int get() {
        return this.value;
    }

    public final synchronized void set(int n) {
        this.value = n;
    }

    public final synchronized void lazySet(int n) {
        this.value = n;
    }

    public final synchronized int getAndSet(int n) {
        int n2 = this.value;
        this.value = n;
        return n2;
    }

    public final synchronized boolean compareAndSet(int n, int n2) {
        if (this.value == n) {
            this.value = n2;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(int n, int n2) {
        if (this.value == n) {
            this.value = n2;
            return true;
        }
        return false;
    }

    public final synchronized int getAndIncrement() {
        return this.value++;
    }

    public final synchronized int getAndDecrement() {
        return this.value--;
    }

    public final synchronized int getAndAdd(int n) {
        int n2 = this.value;
        this.value += n;
        return n2;
    }

    public final synchronized int incrementAndGet() {
        return ++this.value;
    }

    public final synchronized int decrementAndGet() {
        return --this.value;
    }

    public final synchronized int addAndGet(int n) {
        return this.value += n;
    }

    public String toString() {
        return Integer.toString(this.get());
    }

    @Override
    public int intValue() {
        return this.get();
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

