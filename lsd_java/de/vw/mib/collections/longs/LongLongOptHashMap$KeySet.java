/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongLongOptHashMap;
import de.vw.mib.collections.longs.LongLongOptHashMap$KeyIterator;
import de.vw.mib.collections.longs.LongSet;
import de.vw.mib.collections.longs.SyncLongSet;
import java.lang.reflect.Array;

public class LongLongOptHashMap$KeySet
implements LongSet {
    private final /* synthetic */ LongLongOptHashMap this$0;

    public LongLongOptHashMap$KeySet(LongLongOptHashMap longLongOptHashMap) {
        this.this$0 = longLongOptHashMap;
    }

    @Override
    public boolean add(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public long get(long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(long l) {
        return this.this$0.containsKey(l);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public LongIterator iterator() {
        return new LongLongOptHashMap$KeyIterator(this.this$0);
    }

    @Override
    public boolean remove(long l) {
        if (this.this$0.containsKey(l)) {
            this.this$0.remove(l);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        throw new UnsupportedOperationException();
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
    public boolean removeAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            bl |= this.remove(longIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = this.iterator();
        while (longIterator.hasNext()) {
            if (longCollection.contains(longIterator.next())) continue;
            longIterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public long[] toArray() {
        return this.toArray(new long[this.this$0.size]);
    }

    @Override
    public long[] toArray(long[] lArray) {
        long[] lArray2 = lArray;
        if (lArray.length < this.this$0.size) {
            lArray2 = (long[])Array.newInstance(super.getClass().getComponentType(), this.this$0.size);
        }
        LongIterator longIterator = this.iterator();
        for (int i2 = 0; i2 < this.this$0.size; ++i2) {
            lArray2[i2] = longIterator.next();
        }
        return lArray2;
    }

    @Override
    public LongSet synchronize() {
        return new SyncLongSet(this, this.this$0);
    }
}

