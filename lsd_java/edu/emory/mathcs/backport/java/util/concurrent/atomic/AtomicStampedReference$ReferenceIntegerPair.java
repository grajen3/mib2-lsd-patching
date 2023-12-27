/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

class AtomicStampedReference$ReferenceIntegerPair {
    private final Object reference;
    private final int integer;

    AtomicStampedReference$ReferenceIntegerPair(Object object, int n) {
        this.reference = object;
        this.integer = n;
    }

    static /* synthetic */ Object access$000(AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair) {
        return atomicStampedReference$ReferenceIntegerPair.reference;
    }

    static /* synthetic */ int access$100(AtomicStampedReference$ReferenceIntegerPair atomicStampedReference$ReferenceIntegerPair) {
        return atomicStampedReference$ReferenceIntegerPair.integer;
    }
}

