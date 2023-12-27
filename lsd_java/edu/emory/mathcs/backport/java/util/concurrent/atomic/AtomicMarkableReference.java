/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicMarkableReference$ReferenceBooleanPair;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicReference;

public class AtomicMarkableReference {
    private final AtomicReference atomicRef;

    public AtomicMarkableReference(Object object, boolean bl) {
        this.atomicRef = new AtomicReference(new AtomicMarkableReference$ReferenceBooleanPair(object, bl));
    }

    private AtomicMarkableReference$ReferenceBooleanPair getPair() {
        return (AtomicMarkableReference$ReferenceBooleanPair)this.atomicRef.get();
    }

    public Object getReference() {
        return AtomicMarkableReference$ReferenceBooleanPair.access$000(this.getPair());
    }

    public boolean isMarked() {
        return AtomicMarkableReference$ReferenceBooleanPair.access$100(this.getPair());
    }

    public Object get(boolean[] blArray) {
        AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair = this.getPair();
        blArray[0] = AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair);
        return AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair);
    }

    public boolean weakCompareAndSet(Object object, Object object2, boolean bl, boolean bl2) {
        AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair = this.getPair();
        return object == AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair) && bl == AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair) && (object2 == AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair) && bl2 == AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair) || this.atomicRef.weakCompareAndSet(atomicMarkableReference$ReferenceBooleanPair, new AtomicMarkableReference$ReferenceBooleanPair(object2, bl2)));
    }

    public boolean compareAndSet(Object object, Object object2, boolean bl, boolean bl2) {
        AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair = this.getPair();
        return object == AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair) && bl == AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair) && (object2 == AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair) && bl2 == AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair) || this.atomicRef.compareAndSet(atomicMarkableReference$ReferenceBooleanPair, new AtomicMarkableReference$ReferenceBooleanPair(object2, bl2)));
    }

    public void set(Object object, boolean bl) {
        AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair = this.getPair();
        if (object != AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair) || bl != AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair)) {
            this.atomicRef.set(new AtomicMarkableReference$ReferenceBooleanPair(object, bl));
        }
    }

    public boolean attemptMark(Object object, boolean bl) {
        AtomicMarkableReference$ReferenceBooleanPair atomicMarkableReference$ReferenceBooleanPair = this.getPair();
        return object == AtomicMarkableReference$ReferenceBooleanPair.access$000(atomicMarkableReference$ReferenceBooleanPair) && (bl == AtomicMarkableReference$ReferenceBooleanPair.access$100(atomicMarkableReference$ReferenceBooleanPair) || this.atomicRef.compareAndSet(atomicMarkableReference$ReferenceBooleanPair, new AtomicMarkableReference$ReferenceBooleanPair(object, bl)));
    }
}

