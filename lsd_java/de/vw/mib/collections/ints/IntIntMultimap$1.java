/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIntMultimap;
import de.vw.mib.collections.ints.IntIntMultimap$1$1;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntIntMultimap$1
implements Iterator {
    int currIdx = 0;
    int currKey = 0;
    IntArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntIntMultimap this$0;

    IntIntMultimap$1(IntIntMultimap intIntMultimap, Iterator iterator) {
        this.this$0 = intIntMultimap;
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
            this.currList = (IntArrayList)intObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new IntIntMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

