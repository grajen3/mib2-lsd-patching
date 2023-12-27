/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.longs.LongIntMultimap;
import de.vw.mib.collections.longs.LongIntMultimap$1$1;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LongIntMultimap$1
implements Iterator {
    int currIdx = 0;
    long currKey = 0L;
    IntArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ LongIntMultimap this$0;

    LongIntMultimap$1(LongIntMultimap longIntMultimap, Iterator iterator) {
        this.this$0 = longIntMultimap;
        this.val$iter = iterator;
        this.currList = this.this$0.empty;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.currIdx;
        if (this.currIdx >= this.currList.size()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)this.val$iter.next();
            this.currKey = longObjectMap$Entry.getKey();
            this.currList = (IntArrayList)longObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new LongIntMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

