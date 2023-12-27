/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIntMultimap;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongSet;

class LongIntMultimap$3
implements LongSet {
    private final /* synthetic */ LongIntMultimap this$0;

    LongIntMultimap$3(LongIntMultimap longIntMultimap) {
        this.this$0 = longIntMultimap;
    }

    @Override
    public long[] toArray(long[] lArray) {
        return this.this$0.keysToArray(lArray);
    }

    @Override
    public long[] toArray() {
        return this.this$0.keysToArray();
    }

    @Override
    public int size() {
        return this.this$0.backingMap.size();
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
        return this.this$0.keyIterator();
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
        return this.this$0.backingMap.containsKey(l);
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

    @Override
    public LongSet synchronize() {
        return new SyncLongSet(this);
    }

    @Override
    public long get(long l) {
        return this.contains(l) ? l : LongIntMultimap.access$000(this.this$0);
    }
}

