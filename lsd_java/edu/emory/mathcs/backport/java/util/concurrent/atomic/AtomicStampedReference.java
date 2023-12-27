/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicReference;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicStampedReference$ReferenceIntegerPair;

public class AtomicStampedReference {
    private final AtomicReference atomicRef;

    public AtomicStampedReference(Object object, int n) {
        this.atomicRef = new AtomicReference(new AtomicStampedReference$ReferenceIntegerPair(object, n));
    }

    public Object getReference() {
        return AtomicStampedReference$ReferenceIntegerPair.access$000(this.getPair());
    }

    public int getStamp() {
        return AtomicStampedReference$ReferenceIntegerPair.access$100(this.getPair());
    }

    public Object get(int[] nArray) {
        AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair = this.getPair();
        nArray[0] = AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair);
        return AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair);
    }

    public boolean weakCompareAndSet(Object object, Object object2, int n, int n2) {
        AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair = this.getPair();
        return object == AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair) && n == AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair) && (object2 == AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair) && n2 == AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair) || this.atomicRef.weakCompareAndSet(atomicStampedReference$ReferenceIntegerPair, new AtomicStampedReference$ReferenceIntegerPair(object2, n2)));
    }

    public boolean compareAndSet(Object object, Object object2, int n, int n2) {
        AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair = this.getPair();
        return object == AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair) && n == AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair) && (object2 == AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair) && n2 == AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair) || this.atomicRef.compareAndSet(atomicStampedReference$ReferenceIntegerPair, new AtomicStampedReference$ReferenceIntegerPair(object2, n2)));
    }

    public void set(Object object, int n) {
        AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair = this.getPair();
        if (object != AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair) || n != AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair)) {
            this.atomicRef.set(new AtomicStampedReference$ReferenceIntegerPair(object, n));
        }
    }

    public boolean attemptStamp(Object object, int n) {
        AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair = this.getPair();
        return object == AtomicStampedReference$ReferenceIntegerPair.access$000(atomicStampedReference$ReferenceIntegerPair) && (n == AtomicStampedReference$ReferenceIntegerPair.access$100(atomicStampedReference$ReferenceIntegerPair) || this.atomicRef.compareAndSet(atomicStampedReference$ReferenceIntegerPair, new AtomicStampedReference$ReferenceIntegerPair(object, n)));
    }

    private AtomicStampedReference$ReferenceIntegerPair getPair() {
        return (AtomicStampedReference$ReferenceIntegerPair)this.atomicRef.get();
    }
}

