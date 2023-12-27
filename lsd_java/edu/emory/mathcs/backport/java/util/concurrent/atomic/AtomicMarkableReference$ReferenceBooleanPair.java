/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

class AtomicMarkableReference$ReferenceBooleanPair {
    private final Object reference;
    private final boolean bit;

    AtomicMarkableReference$ReferenceBooleanPair(Object object, boolean bl) {
        this.reference = object;
        this.bit = bl;
    }

    static /* synthetic */ Object access$000(AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair) {
        return atomicMarkableReference$ReferenceBooleanPair.reference;
    }

    static /* synthetic */ boolean access$100(AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair) {
        return atomicMarkableReference$ReferenceBooleanPair.bit;
    }
}

