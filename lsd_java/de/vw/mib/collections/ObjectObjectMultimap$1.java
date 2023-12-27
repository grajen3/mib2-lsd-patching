/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectMultimap;
import de.vw.mib.collections.ObjectObjectMultimap$1$1;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ObjectObjectMultimap$1
implements Iterator {
    int currIdx = 0;
    Object currKey = null;
    ObjectArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ ObjectObjectMultimap this$0;

    ObjectObjectMultimap$1(ObjectObjectMultimap objectObjectMultimap, Iterator iterator) {
        this.this$0 = objectObjectMultimap;
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
            this.currList = (ObjectArrayList)objectObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new ObjectObjectMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

