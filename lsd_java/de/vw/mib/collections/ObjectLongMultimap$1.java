/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectLongMultimap;
import de.vw.mib.collections.ObjectLongMultimap$1$1;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.longs.LongArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ObjectLongMultimap$1
implements Iterator {
    int currIdx = 0;
    Object currKey = null;
    LongArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ ObjectLongMultimap this$0;

    ObjectLongMultimap$1(ObjectLongMultimap objectLongMultimap, Iterator iterator) {
        this.this$0 = objectLongMultimap;
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
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)this.val$iter.next();
            this.currKey = objectObjectMap$Entry.getKey();
            this.currList = (LongArrayList)objectObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new ObjectLongMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

