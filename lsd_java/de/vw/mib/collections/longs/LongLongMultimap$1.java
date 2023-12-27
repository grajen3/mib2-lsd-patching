/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongLongMultimap;
import de.vw.mib.collections.longs.LongLongMultimap$1$1;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LongLongMultimap$1
implements Iterator {
    int currIdx = 0;
    long currKey = 0L;
    LongArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ LongLongMultimap this$0;

    LongLongMultimap$1(LongLongMultimap longLongMultimap, Iterator iterator) {
        this.this$0 = longLongMultimap;
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
            this.currList = (LongArrayList)longObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new LongLongMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

