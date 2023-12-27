/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.longs.LongIntMultimap;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LongIntMultimap$5
implements IntIterator {
    int currIdx;
    IntArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ LongIntMultimap this$0;

    LongIntMultimap$5(LongIntMultimap longIntMultimap, Iterator iterator) {
        this.this$0 = longIntMultimap;
        this.val$iter = iterator;
        this.reset();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.currIdx;
        if (this.currIdx >= this.currList.size()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)this.val$iter.next();
            this.currList = (IntArrayList)longObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return this.currList.get(this.currIdx);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }

    @Override
    public void reset() {
        this.currIdx = 0;
        this.currList = this.this$0.empty;
    }
}

