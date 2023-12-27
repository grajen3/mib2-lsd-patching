/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntMultimap;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;

class ObjectIntMultimap$4
implements IntCollection {
    private final /* synthetic */ ObjectIntMultimap this$0;

    ObjectIntMultimap$4(ObjectIntMultimap objectIntMultimap) {
        this.this$0 = objectIntMultimap;
    }

    @Override
    public int[] toArray(int[] nArray) {
        return this.this$0.valuesToArray(nArray);
    }

    @Override
    public int[] toArray() {
        return this.this$0.valuesToArray();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean retainAll(IntCollection intCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(IntCollection intCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntIterator iterator() {
        return this.this$0.valueIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
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
    public boolean contains(int n) {
        return this.this$0.containsValue(n);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(IntCollection intCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(int n) {
        throw new UnsupportedOperationException();
    }
}

