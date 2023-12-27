/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ObjectObjectOptHashMap$Entry;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ObjectObjectOptHashMap$EntryIterator
implements Iterator {
    int where = -1;
    int which = 0;
    int expectedWrites;
    private final /* synthetic */ ObjectObjectOptHashMap this$0;

    public ObjectObjectOptHashMap$EntryIterator(ObjectObjectOptHashMap objectObjectOptHashMap) {
        this.this$0 = objectObjectOptHashMap;
        this.expectedWrites = objectObjectOptHashMap.writes;
    }

    @Override
    public boolean hasNext() {
        if (this.this$0.writes != this.expectedWrites) {
            throw new ConcurrentModificationException();
        }
        return this.which < this.this$0.size;
    }

    @Override
    public Object next() {
        byte by;
        if (this.this$0.writes != this.expectedWrites) {
            throw new ConcurrentModificationException();
        }
        if (this.which >= this.this$0.size) {
            throw new NoSuchElementException();
        }
        do {
            ++this.where;
        } while ((by = this.this$0.valueStates[this.where]) == 0 || by == 1);
        ++this.which;
        return new ObjectObjectOptHashMap$Entry(this.this$0, this.where);
    }

    @Override
    public void remove() {
        if (this.this$0.writes != this.expectedWrites) {
            throw new ConcurrentModificationException();
        }
        if (this.where < 0 || this.this$0.valueStates[this.where] == 1) {
            throw new IllegalStateException();
        }
        this.this$0.removePos(this.where);
        --this.which;
        ++this.expectedWrites;
        this.this$0.onCollectionChanged();
    }
}

