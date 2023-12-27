/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.longs.LongObjectMap$Entry;
import de.vw.mib.collections.longs.LongObjectMultimap;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LongObjectMultimap$5
implements ObjectIterator {
    int currIdx;
    ObjectArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ LongObjectMultimap this$0;

    LongObjectMultimap$5(LongObjectMultimap longObjectMultimap, Iterator iterator) {
        this.this$0 = longObjectMultimap;
        this.val$iter = iterator;
        this.reset();
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
            this.currList = (ObjectArrayList)longObjectMap$Entry.getValue();
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

