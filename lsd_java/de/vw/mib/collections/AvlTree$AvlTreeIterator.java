/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.AvlTree;
import java.util.Iterator;
import java.util.NoSuchElementException;

class AvlTree$AvlTreeIterator
implements Iterator {
    private int nextIdx;
    private final Object[] values;
    private int mods;
    private final /* synthetic */ AvlTree this$0;

    public AvlTree$AvlTreeIterator(AvlTree avlTree) {
        this.this$0 = avlTree;
        this.values = avlTree.toArray();
        this.mods = avlTree.modifications;
    }

    @Override
    public boolean hasNext() {
        this.this$0.checkConcurrentModification(this.mods);
        return this.nextIdx < this.values.length;
    }

    @Override
    public Object next() {
        this.ensureHasNext();
        Object object = this.values[this.nextIdx];
        ++this.nextIdx;
        return object;
    }

    private void ensureHasNext() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        this.this$0.checkConcurrentModification(this.mods);
        if (this.nextIdx < 1) {
            throw new IllegalStateException();
        }
        int n = this.nextIdx - 1;
        if (this.values[n] == AvlTree.NO_VALUE) {
            throw new IllegalStateException();
        }
        this.this$0.remove(this.values[n]);
        this.values[n] = AvlTree.NO_VALUE;
        ++this.mods;
    }
}

