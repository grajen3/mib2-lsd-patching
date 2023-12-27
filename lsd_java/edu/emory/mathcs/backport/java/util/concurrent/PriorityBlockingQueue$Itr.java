/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.PriorityBlockingQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

class PriorityBlockingQueue$Itr
implements Iterator {
    final Object[] array;
    int cursor;
    int lastRet = -1;
    private final /* synthetic */ PriorityBlockingQueue this$0;

    PriorityBlockingQueue$Itr(PriorityBlockingQueue priorityBlockingQueue, Object[] objectArray) {
        this.this$0 = priorityBlockingQueue;
        this.array = objectArray;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.array.length;
    }

    @Override
    public Object next() {
        if (this.cursor >= this.array.length) {
            throw new NoSuchElementException();
        }
        this.lastRet = this.cursor;
        return this.array[this.cursor++];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove() {
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        Object object = this.array[this.lastRet];
        this.lastRet = -1;
        PriorityBlockingQueue.access$000(this.this$0).lock();
        try {
            Iterator iterator = PriorityBlockingQueue.access$100(this.this$0).iterator();
            while (iterator.hasNext()) {
                if (iterator.next() != object) continue;
                iterator.remove();
                return;
            }
        }
        finally {
            PriorityBlockingQueue.access$000(this.this$0).unlock();
        }
    }
}

