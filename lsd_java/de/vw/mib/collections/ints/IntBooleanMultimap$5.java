/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.ints.IntBooleanMultimap;
import de.vw.mib.collections.ints.IntObjectMap$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IntBooleanMultimap$5
implements BooleanIterator {
    int currIdx;
    BooleanArrayList currList;
    private final /* synthetic */ Iterator val$iter;
    private final /* synthetic */ IntBooleanMultimap this$0;

    IntBooleanMultimap$5(IntBooleanMultimap intBooleanMultimap, Iterator iterator) {
        this.this$0 = intBooleanMultimap;
        this.val$iter = iterator;
        this.reset();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.currIdx;
        if (this.currIdx >= this.currList.size()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)this.val$iter.next();
            this.currList = (BooleanArrayList)intObjectMap$Entry.getValue();
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

