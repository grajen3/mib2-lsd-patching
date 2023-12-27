/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongLongMultimap;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LongLongMultimap$5
implements LongIterator {
    int currIdx;
    LongArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ LongLongMultimap this$0;

    LongLongMultimap$5(LongLongMultimap longLongMultimap, Iterator iterator) {
        this.this$0 = longLongMultimap;
        this.val$iter = iterator;
        this.reset();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.currIdx;
        if (this.currIdx >= this.currList.size()) {
            LongObjectMap$Entry longObjectMap$Entry = (LongObjectMap$Entry)this.val$iter.next();
            this.currList = (LongArrayList)longObjectMap$Entry.getValue();
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

