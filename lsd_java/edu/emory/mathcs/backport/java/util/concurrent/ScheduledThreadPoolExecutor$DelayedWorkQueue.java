/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.util.Collection;
import java.util.Iterator;

class ScheduledThreadPoolExecutor$DelayedWorkQueue
extends AbstractQueue
implements BlockingQueue {
    private static final int INITIAL_CAPACITY;
    private transient RunnableScheduledFuture[] queue = new RunnableScheduledFuture[64];
    private final transient ReentrantLock lock = new ReentrantLock();
    private final transient Condition available = this.lock.newCondition();
    private int size = 0;

    ScheduledThreadPoolExecutor$DelayedWorkQueue() {
    }

    private void setIndex(Object object, int n) {
        if (object instanceof ScheduledThreadPoolExecutor$ScheduledFutureTask) {
            ((ScheduledThreadPoolExecutor$ScheduledFutureTask)object).heapIndex = n;
        }
    }

    private void siftUp(int n, RunnableScheduledFuture runnableScheduledFuture) {
        int n2;
        RunnableScheduledFuture runnableScheduledFuture2;
        while (n > 0 && runnableScheduledFuture.compareTo(runnableScheduledFuture2 = this.queue[n2 = n - 1 >>> 1]) < 0) {
            this.queue[n] = runnableScheduledFuture2;
            this.setIndex(runnableScheduledFuture2, n);
            n = n2;
        }
        this.queue[n] = runnableScheduledFuture;
        this.setIndex(runnableScheduledFuture, n);
    }

    private void siftDown(int n, RunnableScheduledFuture runnableScheduledFuture) {
        int n2 = this.size >>> 1;
        while (n < n2) {
            int n3 = (n << 1) + 1;
            RunnableScheduledFuture runnableScheduledFuture2 = this.queue[n3];
            int n4 = n3 + 1;
            if (n4 < this.size && runnableScheduledFuture2.compareTo(this.queue[n4]) > 0) {
                n3 = n4;
                runnableScheduledFuture2 = this.queue[n3];
            }
            if (runnableScheduledFuture.compareTo(runnableScheduledFuture2) <= 0) break;
            this.queue[n] = runnableScheduledFuture2;
            this.setIndex(runnableScheduledFuture2, n);
            n = n3;
        }
        this.queue[n] = runnableScheduledFuture;
        this.setIndex(runnableScheduledFuture, n);
    }

    private RunnableScheduledFuture finishPoll(RunnableScheduledFuture runnableScheduledFuture) {
        int n = --this.size;
        RunnableScheduledFuture runnableScheduledFuture2 = this.queue[n];
        this.queue[n] = null;
        if (n != 0) {
            this.siftDown(0, runnableScheduledFuture2);
            this.available.signalAll();
        }
        this.setIndex(runnableScheduledFuture, -1);
        return runnableScheduledFuture;
    }

    private void grow() {
        int n = this.queue.length;
        int n2 = n + (n >> 1);
        if (n2 < 0) {
            n2 = -129;
        }
        RunnableScheduledFuture[] runnableScheduledFutureArray = new RunnableScheduledFuture[n2];
        System.arraycopy((Object)this.queue, 0, (Object)runnableScheduledFutureArray, 0, this.queue.length);
        this.queue = runnableScheduledFutureArray;
    }

    private int indexOf(Object object) {
        if (object != null) {
            for (int i2 = 0; i2 < this.size; ++i2) {
                if (!object.equals(this.queue[i2])) continue;
                return i2;
            }
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        boolean bl;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int n = object instanceof ScheduledThreadPoolExecutor$ScheduledFutureTask ? ((ScheduledThreadPoolExecutor$ScheduledFutureTask)object).heapIndex : this.indexOf(object);
            bl = n >= 0 && n < this.size && this.queue[n] == object;
            if (bl) {
                this.setIndex(object, -1);
                int n2 = --this.size;
                RunnableScheduledFuture runnableScheduledFuture = this.queue[n2];
                this.queue[n2] = null;
                if (n2 != n) {
                    this.siftDown(n, runnableScheduledFuture);
                    if (this.queue[n] == runnableScheduledFuture) {
                        this.siftUp(n, runnableScheduledFuture);
                    }
                }
            }
        }
        finally {
            reentrantLock.unlock();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        int n;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            n = this.size;
        }
        finally {
            reentrantLock.unlock();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int remainingCapacity() {
        return -129;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            RunnableScheduledFuture runnableScheduledFuture = this.queue[0];
            return runnableScheduledFuture;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        RunnableScheduledFuture runnableScheduledFuture = (RunnableScheduledFuture)object;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean bl;
            int n = this.size;
            if (n >= this.queue.length) {
                this.grow();
            }
            this.size = n + 1;
            if (n == 0) {
                bl = true;
                this.queue[0] = runnableScheduledFuture;
                this.setIndex(runnableScheduledFuture, 0);
            } else {
                bl = runnableScheduledFuture.compareTo(this.queue[0]) < 0;
                this.siftUp(n, runnableScheduledFuture);
            }
            if (bl) {
                this.available.signalAll();
            }
        }
        finally {
            reentrantLock.unlock();
        }
        return true;
    }

    @Override
    public void put(Object object) {
        this.offer(object);
    }

    public boolean add(Runnable runnable) {
        return this.offer(runnable);
    }

    @Override
    public boolean offer(Object object, long l, TimeUnit timeUnit) {
        return this.offer(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            RunnableScheduledFuture runnableScheduledFuture = this.queue[0];
            if (runnableScheduledFuture == null || runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS) > 0L) {
                Object var3_3 = null;
                return var3_3;
            }
            RunnableScheduledFuture runnableScheduledFuture2 = this.finishPoll(runnableScheduledFuture);
            return runnableScheduledFuture2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Object take() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        try {
            while (true) {
                RunnableScheduledFuture runnableScheduledFuture;
                if ((runnableScheduledFuture = this.queue[0]) == null) {
                    this.available.await();
                    continue;
                }
                long l = runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS);
                if (l > 0L) {
                    this.available.await(l, TimeUnit.NANOSECONDS);
                    continue;
                }
                RunnableScheduledFuture runnableScheduledFuture2 = this.finishPoll(runnableScheduledFuture);
                return runnableScheduledFuture2;
            }
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Object poll(long l, TimeUnit timeUnit) {
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        try {
            while (true) {
                RunnableScheduledFuture runnableScheduledFuture;
                if ((runnableScheduledFuture = this.queue[0]) == null) {
                    if (l2 <= 0L) {
                        Object var10_8 = null;
                        return var10_8;
                    }
                    this.available.await(l2, TimeUnit.NANOSECONDS);
                    l2 = l3 - Utils.nanoTime();
                    continue;
                }
                long l4 = runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS);
                if (l4 > 0L) {
                    if (l2 <= 0L) {
                        Object var12_9 = null;
                        return var12_9;
                    }
                    if (l4 > l2) {
                        l4 = l2;
                    }
                    this.available.await(l4, TimeUnit.NANOSECONDS);
                    l2 = l3 - Utils.nanoTime();
                    continue;
                }
                RunnableScheduledFuture runnableScheduledFuture2 = this.finishPoll(runnableScheduledFuture);
                return runnableScheduledFuture2;
            }
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (int i2 = 0; i2 < this.size; ++i2) {
                RunnableScheduledFuture runnableScheduledFuture = this.queue[i2];
                if (runnableScheduledFuture == null) continue;
                this.queue[i2] = null;
                this.setIndex(runnableScheduledFuture, -1);
            }
            this.size = 0;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    private RunnableScheduledFuture pollExpired() {
        RunnableScheduledFuture runnableScheduledFuture = this.queue[0];
        if (runnableScheduledFuture == null || runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS) > 0L) {
            return null;
        }
        this.setIndex(runnableScheduledFuture, -1);
        int n = --this.size;
        RunnableScheduledFuture runnableScheduledFuture2 = this.queue[n];
        this.queue[n] = null;
        if (n != 0) {
            this.siftDown(0, runnableScheduledFuture2);
        }
        return runnableScheduledFuture;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            RunnableScheduledFuture runnableScheduledFuture;
            int n = 0;
            while ((runnableScheduledFuture = this.pollExpired()) != null) {
                collection.add(runnableScheduledFuture);
                ++n;
            }
            if (n > 0) {
                this.available.signalAll();
            }
            int n2 = n;
            return n2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int drainTo(Collection collection, int n) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (n <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            RunnableScheduledFuture runnableScheduledFuture;
            int n2;
            for (n2 = 0; n2 < n && (runnableScheduledFuture = this.pollExpired()) != null; ++n2) {
                collection.add(runnableScheduledFuture);
            }
            if (n2 > 0) {
                this.available.signalAll();
            }
            int n3 = n2;
            return n3;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objectArray = Arrays.copyOf(this.queue, this.size);
            return objectArray;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (objectArray.length < this.size) {
                Object[] objectArray2 = Arrays.copyOf(this.queue, this.size, super.getClass());
                return objectArray2;
            }
            System.arraycopy((Object)this.queue, 0, (Object)objectArray, 0, this.size);
            if (objectArray.length > this.size) {
                objectArray[this.size] = null;
            }
            Object[] objectArray3 = objectArray;
            return objectArray3;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Iterator iterator() {
        return new ScheduledThreadPoolExecutor$DelayedWorkQueue$Itr(this, this.toArray());
    }
}

