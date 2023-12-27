/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.RingBuffer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RingBuffer$1
implements Iterator {
    private int pos = -1;
    private int idx = -1;
    private int expectedMods;
    private final /* synthetic */ RingBuffer this$0;

    RingBuffer$1(RingBuffer ringBuffer) {
        this.this$0 = ringBuffer;
        this.expectedMods = this.this$0.modifications;
    }

    @Override
    public void remove() {
        this.checkRemovePossible();
        this.this$0.removeIdx(this.idx);
        ++this.expectedMods;
        --this.pos;
        this.idx = -1;
        this.checkConcurrentModification();
    }

    @Override
    public Object next() {
        this.checkNextElementExisting();
        ++this.pos;
        this.idx = this.this$0.calcIndex(this.pos);
        Object object = this.this$0.buffer[this.idx];
        this.checkConcurrentModification();
        return object;
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.hasNextInternal();
        this.checkConcurrentModification();
        return bl;
    }

    private boolean hasNextInternal() {
        return this.pos + 1 < this.this$0.size;
    }

    private void checkRemovePossible() {
        if (this.idx < 0) {
            throw new IllegalStateException();
        }
    }

    private void checkNextElementExisting() {
        if (!this.hasNextInternal()) {
            throw new NoSuchElementException();
        }
    }

    private void checkConcurrentModification() {
        if (this.this$0.modifications != this.expectedMods) {
            throw new ConcurrentModificationException();
        }
    }
}

