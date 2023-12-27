/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectLongMultimap;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;

class ObjectLongMultimap$4
implements LongCollection {
    private final /* synthetic */ ObjectLongMultimap this$0;

    ObjectLongMultimap$4(ObjectLongMultimap objectLongMultimap) {
        this.this$0 = objectLongMultimap;
    }

    @Override
    public long[] toArray(long[] lArray) {
        return this.this$0.valuesToArray(lArray);
    }

    @Override
    public long[] toArray() {
        return this.this$0.valuesToArray();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean retainAll(LongCollection longCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(LongCollection longCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongIterator iterator() {
        return this.this$0.valueIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public boolean containsAll(LongCollection longCollection) {
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            if (this.contains(longIterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(long l) {
        return this.this$0.containsValue(l);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(long l) {
        throw new UnsupportedOperationException();
    }
}

