/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

class IntArrayList$1
implements IntIterator {
    int pos;
    int expectedWrites;
    boolean canRemove;
    private final /* synthetic */ IntArrayList this$0;

    IntArrayList$1(IntArrayList intArrayList) {
        this.this$0 = intArrayList;
        this.reset();
    }

    @Override
    public void reset() {
        this.pos = -1;
        this.expectedWrites = this.this$0.writes;
        this.canRemove = false;
    }

    @Override
    public void remove() {
        this.checkConcurrentModification();
        if (!this.canRemove) {
            throw new IllegalStateException();
        }
        this.this$0.removeRange(this.pos, 1);
        ++this.expectedWrites;
        this.canRemove = false;
        --this.pos;
    }

    @Override
    public int next() {
        this.checkHasNext();
        this.canRemove = true;
        ++this.pos;
        return this.this$0.array[this.this$0.first + this.pos];
    }

    private void checkHasNext() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        this.checkConcurrentModification();
        return this.pos + 1 < this.this$0.size();
    }

    private void checkConcurrentModification() {
        if (this.expectedWrites != this.this$0.writes) {
            throw new ConcurrentModificationException();
        }
    }
}

