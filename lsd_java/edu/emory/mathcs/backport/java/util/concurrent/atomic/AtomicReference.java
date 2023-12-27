/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicReference
implements Serializable {
    private static final long serialVersionUID;
    private volatile Object value;

    public AtomicReference(Object object) {
        this.value = object;
    }

    public AtomicReference() {
    }

    public final Object get() {
        return this.value;
    }

    public final synchronized void set(Object object) {
        this.value = object;
    }

    public final synchronized void lazySet(Object object) {
        this.value = object;
    }

    public final synchronized boolean compareAndSet(Object object, Object object2) {
        if (this.value == object) {
            this.value = object2;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(Object object, Object object2) {
        if (this.value == object) {
            this.value = object2;
            return true;
        }
        return false;
    }

    public final synchronized Object getAndSet(Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    public String toString() {
        return String.valueOf(this.get());
    }
}

