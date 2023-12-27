/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntLongMultimap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntLongMultimap$5
implements LongIterator {
    int currIdx;
    LongArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntLongMultimap this$0;

    IntLongMultimap$5(IntLongMultimap intLongMultimap, Iterator iterator) {
        this.this$0 = intLongMultimap;
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
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)this.val$iter.next();
            this.currList = (LongArrayList)intObjectMap$Entry.getValue();
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

