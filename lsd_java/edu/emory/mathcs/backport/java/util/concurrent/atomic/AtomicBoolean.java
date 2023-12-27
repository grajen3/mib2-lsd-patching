/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicBoolean
implements Serializable {
    private static final long serialVersionUID;
    private volatile int value;

    public AtomicBoolean(boolean bl) {
        this.value = bl ? 1 : 0;
    }

    public AtomicBoolean() {
    }

    public final boolean get() {
        return this.value != 0;
    }

    public final synchronized boolean compareAndSet(boolean bl, boolean bl2) {
        if (bl == (this.value != 0)) {
            this.value = bl2 ? 1 : 0;
            return true;
        }
        return false;
    }

    public synchronized boolean weakCompareAndSet(boolean bl, boolean bl2) {
        if (bl == (this.value != 0)) {
            this.value = bl2 ? 1 : 0;
            return true;
        }
        return false;
    }

    public final synchronized void set(boolean bl) {
        this.value = bl ? 1 : 0;
    }

    public final synchronized void lazySet(boolean bl) {
        this.value = bl ? 1 : 0;
    }

    public final synchronized boolean getAndSet(boolean bl) {
        int n = this.value;
        this.value = bl ? 1 : 0;
        return n != 0;
    }

    public String toString() {
        return Boolean.toString(this.get());
    }
}

