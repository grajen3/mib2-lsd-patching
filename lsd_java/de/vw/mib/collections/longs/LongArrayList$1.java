/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongIterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

class LongArrayList$1
implements LongIterator {
    int pos;
    int expectedWrites;
    boolean canRemove;
    private final /* synthetic */ LongArrayList this$0;

    LongArrayList$1(LongArrayList longArrayList) {
        this.this$0 = longArrayList;
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
    public long next() {
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

