/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ScheduledThreadPoolExecutor$DelayedWorkQueue$Itr
implements Iterator {
    final Object[] array;
    int cursor;
    int lastRet = -1;
    private final /* synthetic */ ScheduledThreadPoolExecutor$DelayedWorkQueue this$0;

    ScheduledThreadPoolExecutor$DelayedWorkQueue$Itr(ScheduledThreadPoolExecutor$DelayedWorkQueue scheduledThreadPoolExecutor$DelayedWorkQueue, Object[] objectArray) {
        this.this$0 = scheduledThreadPoolExecutor$DelayedWorkQueue;
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
        return (Runnable)this.array[this.cursor++];
    }

    @Override
    public void remove() {
        if (this.lastRet < 0) {
            throw new IllegalStateException();
        }
        this.this$0.remove(this.array[this.lastRet]);
        this.lastRet = -1;
    }
}

