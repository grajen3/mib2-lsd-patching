/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.ints.IntFloatOptHashMap;
import de.vw.mib.collections.ints.IntFloatOptHashMap$ValueIterator;
import java.lang.reflect.Array;

class IntFloatOptHashMap$ValueCollection
implements FloatCollection {
    private final /* synthetic */ IntFloatOptHashMap this$0;

    public IntFloatOptHashMap$ValueCollection(IntFloatOptHashMap intFloatOptHashMap) {
        this.this$0 = intFloatOptHashMap;
    }

    @Override
    public boolean add(float f2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(float f2) {
        return this.this$0.containsValue(f2);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public FloatIterator iterator() {
        return new IntFloatOptHashMap$ValueIterator(this.this$0);
    }

    @Override
    public boolean remove(float f2) {
        int n = this.this$0.findOneValuePos(f2);
        if (128 != n) {
            this.this$0.removePos(n);
            this.this$0.onCollectionChanged();
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }

    @Override
    public boolean addAll(FloatCollection floatCollection) {
        throw new UnsupportedOperationException();
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
    public boolean removeAll(FloatCollection floatCollection) {
        boolean bl = false;
        FloatIterator floatIterator = floatCollection.iterator();
        while (floatIterator.hasNext()) {
            bl |= this.remove(floatIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(FloatCollection floatCollection) {
        boolean bl = false;
        FloatIterator floatIterator = this.iterator();
        while (floatIterator.hasNext()) {
            if (floatCollection.contains(floatIterator.next())) continue;
            floatIterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public float[] toArray() {
        return this.toArray(new float[this.this$0.size]);
    }

    @Override
    public float[] toArray(float[] fArray) {
        float[] fArray2 = fArray;
        if (fArray.length < this.this$0.size) {
            fArray2 = (float[])Array.newInstance(super.getClass().getComponentType(), this.this$0.size);
        }
        FloatIterator floatIterator = this.iterator();
        for (int i2 = 0; i2 < this.this$0.size; ++i2) {
            fArray2[i2] = floatIterator.next();
        }
        return fArray2;
    }
}

