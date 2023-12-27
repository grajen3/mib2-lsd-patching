/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectLongMultimap;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ObjectLongMultimap$5
implements LongIterator {
    int currIdx;
    LongArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ ObjectLongMultimap this$0;

    ObjectLongMultimap$5(ObjectLongMultimap objectLongMultimap, Iterator iterator) {
        this.this$0 = objectLongMultimap;
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
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)this.val$iter.next();
            this.currList = (LongArrayList)objectObjectMap$Entry.getValue();
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

