/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.DelayQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

class DelayQueue$Itr
implements Iterator {
    final Object[] array;
    int cursor;
    int lastRet = -1;
    private final /* synthetic */ DelayQueue this$0;

    DelayQueue$Itr(DelayQueue delayQueue, Object[] objectArray) {
        this.this$0 = delayQueue;
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
        Object object2 = DelayQueue.access$000(this.this$0);
        synchronized (object2) {
            Iterator iterator = DelayQueue.access$100(this.this$0).iterator();
            while (iterator.hasNext()) {
                if (iterator.next() != object) continue;
                iterator.remove();
                return;
            }
        }
    }
}

