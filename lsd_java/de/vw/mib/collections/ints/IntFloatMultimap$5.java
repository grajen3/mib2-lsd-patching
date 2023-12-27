/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.floats.FloatArrayList;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.ints.IntFloatMultimap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntFloatMultimap$5
implements FloatIterator {
    int currIdx;
    FloatArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntFloatMultimap this$0;

    IntFloatMultimap$5(IntFloatMultimap intFloatMultimap, Iterator iterator) {
        this.this$0 = intFloatMultimap;
        this.val$iter = iterator;
        this.reset();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public float next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.currIdx;
        if (this.currIdx >= this.currList.size()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)this.val$iter.next();
            this.currList = (FloatArrayList)intObjectMap$Entry.getValue();
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

