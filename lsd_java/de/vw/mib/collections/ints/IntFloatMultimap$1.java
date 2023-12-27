/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.floats.FloatArrayList;
import de.vw.mib.collections.ints.IntFloatMultimap;
import de.vw.mib.collections.ints.IntFloatMultimap$1$1;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntFloatMultimap$1
implements Iterator {
    int currIdx = 0;
    int currKey = 0;
    FloatArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntFloatMultimap this$0;

    IntFloatMultimap$1(IntFloatMultimap intFloatMultimap, Iterator iterator) {
        this.this$0 = intFloatMultimap;
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
            this.currList = (FloatArrayList)intObjectMap$Entry.getValue();
            this.currIdx = 0;
        }
        return new IntFloatMultimap$1$1(this);
    }

    @Override
    public boolean hasNext() {
        return this.val$iter.hasNext() || this.currIdx + 1 < this.currList.size();
    }
}

