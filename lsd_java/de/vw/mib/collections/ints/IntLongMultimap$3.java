/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongMultimap;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.ints.SyncIntSet;

class IntLongMultimap$3
implements IntSet {
    private final /* synthetic */ IntLongMultimap this$0;

    IntLongMultimap$3(IntLongMultimap intLongMultimap) {
        this.this$0 = intLongMultimap;
    }

    @Override
    public int[] toArray(int[] nArray) {
        return this.this$0.keysToArray(nArray);
    }

    @Override
    public int[] toArray() {
        return this.this$0.keysToArray();
    }

    @Override
    public int size() {
        return this.this$0.backingMap.size();
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
        return this.this$0.keyIterator();
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
        return this.this$0.backingMap.containsKey(n);
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

    @Override
    public IntSet synchronize() {
        return new SyncIntSet(this);
    }

    @Override
    public int get(int n) {
        return this.contains(n) ? n : IntLongMultimap.access$000(this.this$0);
    }
}

