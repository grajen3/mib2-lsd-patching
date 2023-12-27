/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntLongMultimap;
import de.vw.mib.collections.ints.IntLongMultimap$1$1;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.longs.LongArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntLongMultimap$1
implements Iterator {
    int currIdx = 0;
    int currKey = 0;
    LongArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntLongMultimap this$0;

    IntLongMultimap$1(IntLongMultimap intLongMultimap, Iterator iterator) {
        this.this$0 = intLongMultimap;
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
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)this.val$iter.next();
            this.currKey = intObjectMap$Entry.getKey();
            this.currList = (LongArrayList)intObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new IntLongMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

