/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.ints.IntFloatMultimap;

class IntFloatMultimap$4
implements FloatCollection {
    private final /* synthetic */ IntFloatMultimap this$0;

    IntFloatMultimap$4(IntFloatMultimap intFloatMultimap) {
        this.this$0 = intFloatMultimap;
    }

    @Override
    public float[] toArray(float[] fArray) {
        return this.this$0.valuesToArray(fArray);
    }

    @Override
    public float[] toArray() {
        return this.this$0.valuesToArray();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean retainAll(FloatCollection floatCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(FloatCollection floatCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(float f2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FloatIterator iterator() {
        return this.this$0.valueIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public boolean containsAll(FloatCollection floatCollection) {
        FloatIterator floatIterator = floatCollection.iterator();
        while (floatIterator.hasNext()) {
            if (this.contains(floatIterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(float f2) {
        return this.this$0.containsValue(f2);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(FloatCollection floatCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(float f2) {
        throw new UnsupportedOperationException();
    }
}

