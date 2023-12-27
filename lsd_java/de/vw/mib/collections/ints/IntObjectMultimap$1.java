/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.collections.ints.IntObjectMultimap$1$1;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntObjectMultimap$1
implements Iterator {
    int currIdx = 0;
    int currKey = 0;
    ObjectArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntObjectMultimap this$0;

    IntObjectMultimap$1(IntObjectMultimap intObjectMultimap, Iterator iterator) {
        this.this$0 = intObjectMultimap;
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
            this.currList = (ObjectArrayList)intObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new IntObjectMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

