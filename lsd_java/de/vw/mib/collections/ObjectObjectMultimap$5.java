/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectMultimap;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ObjectObjectMultimap$5
implements ObjectIterator {
    int currIdx;
    ObjectArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ ObjectObjectMultimap this$0;

    ObjectObjectMultimap$5(ObjectObjectMultimap objectObjectMultimap, Iterator iterator) {
        this.this$0 = objectObjectMultimap;
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
            ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)this.val$iter.next();
            this.currList = (ObjectArrayList)objectObjectMap$Entry.getValue();
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

