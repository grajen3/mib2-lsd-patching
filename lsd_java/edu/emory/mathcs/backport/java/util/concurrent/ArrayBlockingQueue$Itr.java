/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ArrayBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayBlockingQueue$Itr
implements Iterator {
    private int nextIndex;
    private Object nextItem;
    private int lastRet = -1;
    private final /* synthetic */ ArrayBlockingQueue this$0;

    ArrayBlockingQueue$Itr(ArrayBlockingQueue arrayBlockingQueue) {
        this.this$0 = arrayBlockingQueue;
        if (ArrayBlockingQueue.access$000(arrayBlockingQueue) == 0) {
            this.nextIndex = -1;
        } else {
            this.nextIndex = ArrayBlockingQueue.access$100(arrayBlockingQueue);
            this.nextItem = ArrayBlockingQueue.access$200(arrayBlockingQueue)[ArrayBlockingQueue.access$100(arrayBlockingQueue)];
        }
    }

    @Override
    public boolean hasNext() {
        return this.nextIndex >= 0;
    }

    private void checkNext() {
        if (this.nextIndex == ArrayBlockingQueue.access$300(this.this$0)) {
            this.nextIndex = -1;
            this.nextItem = null;
        } else {
            this.nextItem = ArrayBlockingQueue.access$200(this.this$0)[this.nextIndex];
            if (this.nextItem == null) {
                this.nextIndex = -1;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object next() {
        ReentrantLock reentrantLock = ArrayBlockingQueue.access$400(this.this$0);
        reentrantLock.lock();
        try {
            if (this.nextIndex < 0) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.nextIndex;
            Object object = this.nextItem;
            this.nextIndex = this.this$0.inc(this.nextIndex);
            this.checkNext();
            Object object2 = object;
            return object2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove() {
        ReentrantLock reentrantLock = ArrayBlockingQueue.access$400(this.this$0);
        reentrantLock.lock();
        try {
            int n = this.lastRet;
            if (n == -1) {
                throw new IllegalStateException();
            }
            this.lastRet = -1;
            int n2 = ArrayBlockingQueue.access$100(this.this$0);
            this.this$0.removeAt(n);
            this.nextIndex = n == n2 ? ArrayBlockingQueue.access$100(this.this$0) : n;
            this.checkNext();
        }
        finally {
            reentrantLock.unlock();
        }
    }
}

