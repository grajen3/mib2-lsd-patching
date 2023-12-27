/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class PriorityQueue$Itr
implements Iterator {
    int cursor = 0;
    List percolatedElems;
    int cursorPercolated = 0;
    int expectedModCount = PriorityQueue.access$000(this.this$0);
    int lastRet;
    Object lastRetPercolated;
    private final /* synthetic */ PriorityQueue this$0;

    PriorityQueue$Itr(PriorityQueue priorityQueue) {
        this.this$0 = priorityQueue;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < PriorityQueue.access$100(this.this$0) || this.percolatedElems != null;
    }

    @Override
    public Object next() {
        this.checkForComodification();
        if (this.cursor < PriorityQueue.access$100(this.this$0)) {
            this.lastRet = this.cursor++;
            return PriorityQueue.access$200(this.this$0)[this.lastRet];
        }
        if (this.percolatedElems != null) {
            this.lastRet = -1;
            this.lastRetPercolated = this.percolatedElems.remove(this.percolatedElems.size() - 1);
            if (this.percolatedElems.isEmpty()) {
                this.percolatedElems = null;
            }
            return this.lastRetPercolated;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        if (this.lastRet >= 0) {
            Object object = PriorityQueue.access$300(this.this$0, this.lastRet);
            this.lastRet = -1;
            if (object == null) {
                --this.cursor;
            } else {
                if (this.percolatedElems == null) {
                    this.percolatedElems = new ArrayList();
                }
                this.percolatedElems.add(object);
            }
        } else if (this.lastRetPercolated != null) {
            this.this$0.remove(this.lastRetPercolated);
            this.lastRetPercolated = null;
        } else {
            throw new IllegalStateException();
        }
        this.expectedModCount = PriorityQueue.access$000(this.this$0);
    }

    private void checkForComodification() {
        if (this.expectedModCount != PriorityQueue.access$000(this.this$0)) {
            throw new ConcurrentModificationException();
        }
    }
}

