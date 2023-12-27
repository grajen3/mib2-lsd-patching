/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectLongOptHashMap;
import de.vw.mib.collections.ObjectLongOptHashMap$ValueIterator;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import java.lang.reflect.Array;

class ObjectLongOptHashMap$ValueCollection
implements LongCollection {
    private final /* synthetic */ ObjectLongOptHashMap this$0;

    public ObjectLongOptHashMap$ValueCollection(ObjectLongOptHashMap objectLongOptHashMap) {
        this.this$0 = objectLongOptHashMap;
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
    public boolean contains(long l) {
        return this.this$0.containsValue(l);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public LongIterator iterator() {
        return new ObjectLongOptHashMap$ValueIterator(this.this$0);
    }

    @Override
    public boolean remove(long l) {
        int n = this.this$0.findOneValuePos(l);
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
}

