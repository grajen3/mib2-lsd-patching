/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIntOptHashMap$ValueIterator;
import de.vw.mib.collections.ints.IntIterator;
import java.lang.reflect.Array;

class IntIntOptHashMap$ValueCollection
implements IntCollection {
    private final /* synthetic */ IntIntOptHashMap this$0;

    public IntIntOptHashMap$ValueCollection(IntIntOptHashMap intIntOptHashMap) {
        this.this$0 = intIntOptHashMap;
    }

    @Override
    public boolean add(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(int n) {
        return this.this$0.containsValue(n);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public IntIterator iterator() {
        return new IntIntOptHashMap$ValueIterator(this.this$0);
    }

    @Override
    public boolean remove(int n) {
        int n2 = this.this$0.findOneValuePos(n);
        if (128 != n2) {
            this.this$0.removePos(n2);
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
    public boolean addAll(IntCollection intCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(IntCollection intCollection) {
        IntIterator intIterator = intCollection.iterator();
        while (intIterator.hasNext()) {
            if (this.contains(intIterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(IntCollection intCollection) {
        boolean bl = false;
        IntIterator intIterator = intCollection.iterator();
        while (intIterator.hasNext()) {
            bl |= this.remove(intIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(IntCollection intCollection) {
        boolean bl = false;
        IntIterator intIterator = this.iterator();
        while (intIterator.hasNext()) {
            if (intCollection.contains(intIterator.next())) continue;
            intIterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public int[] toArray() {
        return this.toArray(new int[this.this$0.size]);
    }

    @Override
    public int[] toArray(int[] nArray) {
        int[] nArray2 = nArray;
        if (nArray.length < this.this$0.size) {
            nArray2 = (int[])Array.newInstance(super.getClass().getComponentType(), this.this$0.size);
        }
        IntIterator intIterator = this.iterator();
        for (int i2 = 0; i2 < this.this$0.size; ++i2) {
            nArray2[i2] = intIterator.next();
        }
        return nArray2;
    }
}

