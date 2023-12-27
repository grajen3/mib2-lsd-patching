/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntMultimap;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ObjectIntMultimap$5
implements IntIterator {
    int currIdx;
    IntArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ ObjectIntMultimap this$0;

    ObjectIntMultimap$5(ObjectIntMultimap objectIntMultimap, Iterator iterator) {
        this.this$0 = objectIntMultimap;
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
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)this.val$iter.next();
            this.currList = (IntArrayList)objectObjectMap$Entry.getValue();
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

