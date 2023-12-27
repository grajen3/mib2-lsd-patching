/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIntMultimap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntIntMultimap$5
implements IntIterator {
    int currIdx;
    IntArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntIntMultimap this$0;

    IntIntMultimap$5(IntIntMultimap intIntMultimap, Iterator iterator) {
        this.this$0 = intIntMultimap;
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
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)this.val$iter.next();
            this.currList = (IntArrayList)intObjectMap$Entry.getValue();
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

