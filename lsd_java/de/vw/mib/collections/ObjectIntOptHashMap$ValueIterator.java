/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

class ObjectIntOptHashMap$ValueIterator
implements IntIterator {
    int where;
    int which;
    int expectedWrites;
    private final /* synthetic */ ObjectIntOptHashMap this$0;

    public ObjectIntOptHashMap$ValueIterator(ObjectIntOptHashMap objectIntOptHashMap) {
        this.this$0 = objectIntOptHashMap;
        this.reset();
    }

    @Override
    public void reset() {
        this.where = -1;
        this.which = 0;
        this.expectedWrites = this.this$0.writes;
    }

    @Override
    public boolean hasNext() {
        this.checkModifications();
        return this.which < this.this$0.size;
    }

    private void checkModifications() {
        if (this.this$0.writes != this.expectedWrites) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public int next() {
        byte by;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        do {
            ++this.where;
        } while ((by = this.this$0.valueStates[this.where]) == 0 || by == 1);
        ++this.which;
        this.this$0.lastFoundWhere = this.where;
        return this.this$0.values[this.where];
    }

    @Override
    public void remove() {
        this.checkModifications();
        if (this.where < 0 || this.this$0.valueStates[this.where] == 1) {
            throw new IllegalStateException();
        }
        this.this$0.removePos(this.where);
        --this.which;
        ++this.expectedWrites;
        this.this$0.onCollectionChanged();
    }
}

