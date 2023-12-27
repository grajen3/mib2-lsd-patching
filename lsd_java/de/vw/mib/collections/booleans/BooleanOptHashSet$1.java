/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanOptHashSet;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

class BooleanOptHashSet$1
implements BooleanIterator {
    int curr;
    int expectedMods;
    int lastRemoved;
    private final /* synthetic */ BooleanOptHashSet this$0;

    BooleanOptHashSet$1(BooleanOptHashSet booleanOptHashSet) {
        this.this$0 = booleanOptHashSet;
        this.reset();
    }

    @Override
    public void reset() {
        this.curr = 0;
        this.lastRemoved = 0;
        this.expectedMods = this.this$0.writesCount;
        this.this$0.onCollectionChanged();
    }

    @Override
    public void remove() {
        this.checkConcurrentModification();
        if (this.lastRemoved == this.curr) {
            throw new IllegalStateException();
        }
        this.lastRemoved = this.curr;
        this.this$0.remove(this.this$0.getBool(this.curr));
        ++this.expectedMods;
    }

    @Override
    public boolean next() {
        this.checkHasNext();
        if (this.curr < 1 && (this.this$0.bools & 1) != 0) {
            this.curr = 1;
        } else if (this.curr < 2 && (this.this$0.bools & 2) != 0) {
            this.curr = 2;
        }
        return this.this$0.getBool(this.curr);
    }

    private void checkHasNext() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        this.checkConcurrentModification();
        return this.curr < this.this$0.bools && this.curr < 2;
    }

    private void checkConcurrentModification() {
        if (this.this$0.writesCount != this.expectedMods) {
            throw new ConcurrentModificationException();
        }
    }
}

