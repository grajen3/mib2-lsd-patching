/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.MultiIntegerTupleList;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public final class MultiIntegerTupleList$Iterator {
    private int chainId;
    private int successorId;
    private int currentBlockId;
    private int predecessorId;
    private int expectedModifications;
    private final /* synthetic */ MultiIntegerTupleList this$0;

    MultiIntegerTupleList$Iterator(MultiIntegerTupleList multiIntegerTupleList, int n) {
        this.this$0 = multiIntegerTupleList;
        this.reset(n);
    }

    public void reset(int n) {
        this.this$0.checkBlockId(n);
        this.chainId = n;
        this.successorId = -1;
        this.currentBlockId = n;
        this.predecessorId = this.this$0.getPredecessorId(n);
        this.expectedModifications = this.this$0.getModifications();
    }

    private void checkConcurrentModification() {
        if (this.expectedModifications != this.this$0.getModifications()) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean hasNext() {
        this.checkConcurrentModification();
        return this.predecessorId != -1;
    }

    public void next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.successorId = this.currentBlockId;
        this.currentBlockId = this.predecessorId;
        this.predecessorId = this.this$0.getPredecessorId(this.currentBlockId);
    }

    public int getValueAt(int n) {
        this.this$0.checkBlockId(this.currentBlockId);
        this.checkConcurrentModification();
        return this.this$0.getValueAt(this.currentBlockId, n);
    }

    public void setValueAt(int n, int n2) {
        this.this$0.checkBlockId(this.currentBlockId);
        this.checkConcurrentModification();
        this.this$0.setValueAt(this.currentBlockId, n, n2);
        ++this.expectedModifications;
    }

    public void remove() {
        this.chainId = this.this$0.removeBlock(this.chainId, this.successorId);
        ++this.expectedModifications;
        this.currentBlockId = -1;
    }
}

