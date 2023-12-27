/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.PriorityQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.DelayQueue$Itr;
import edu.emory.mathcs.backport.java.util.concurrent.Delayed;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.util.Collection;
import java.util.Iterator;

public class DelayQueue
extends AbstractQueue
implements BlockingQueue {
    private final transient Object lock = new Object();
    private final PriorityQueue q = new PriorityQueue();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$concurrent$DelayQueue;

    public DelayQueue() {
    }

    public DelayQueue(Collection collection) {
        this.addAll(collection);
    }

    @Override
    public boolean add(Object object) {
        return this.offer(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object) {
        Object object2 = this.lock;
        synchronized (object2) {
            Object object3 = this.q.peek();
            this.q.offer(object);
            if (object3 == null || ((Delayed)object).compareTo(object3) < 0) {
                this.lock.notifyAll();
            }
            return true;
        }
    }

    @Override
    public void put(Object object) {
        this.offer(object);
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
        Object object = this.lock;
        synchronized (object) {
            Object object2 = this.q.peek();
            if (object2 == null || ((Delayed)object2).getDelay(TimeUnit.NANOSECONDS) > 0L) {
                return null;
            }
            Object object3 = this.q.poll();
            if (!$assertionsDisabled && object3 == null) {
                throw new AssertionError();
            }
            if (this.q.size() != 0) {
                this.lock.notifyAll();
            }
            return object3;
        }
    }

    @Override
    public Object take() {
        Object object = this.lock;
        synchronized (object) {
            while (true) {
                Object object2;
                if ((object2 = this.q.peek()) == null) {
                    this.lock.wait();
                    continue;
                }
                long l = ((Delayed)object2).getDelay(TimeUnit.NANOSECONDS);
                if (l <= 0L) break;
                TimeUnit.NANOSECONDS.timedWait(this.lock, l);
            }
            Object object3 = this.q.poll();
            if (!$assertionsDisabled && object3 == null) {
                throw new AssertionError();
            }
            if (this.q.size() != 0) {
                this.lock.notifyAll();
            }
            return object3;
        }
    }

    @Override
    public Object poll(long l, TimeUnit timeUnit) {
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        Object object = this.lock;
        synchronized (object) {
            while (true) {
                Object object2;
                if ((object2 = this.q.peek()) == null) {
                    if (l2 <= 0L) {
                        return null;
                    }
                    TimeUnit.NANOSECONDS.timedWait(this.lock, l2);
                    l2 = l3 - Utils.nanoTime();
                    continue;
                }
                long l4 = ((Delayed)object2).getDelay(TimeUnit.NANOSECONDS);
                if (l4 <= 0L) break;
                if (l2 <= 0L) {
                    return null;
                }
                if (l4 > l2) {
                    l4 = l2;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, l4);
                l2 = l3 - Utils.nanoTime();
            }
            Object object3 = this.q.poll();
            if (!$assertionsDisabled && object3 == null) {
                throw new AssertionError();
            }
            if (this.q.size() != 0) {
                this.lock.notifyAll();
            }
            return object3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object peek() {
        Object object = this.lock;
        synchronized (object) {
            return this.q.peek();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.lock;
        synchronized (object) {
            return this.q.size();
        }
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
        Object object = this.lock;
        synchronized (object) {
            Object object2;
            int n = 0;
            while ((object2 = this.q.peek()) != null && ((Delayed)object2).getDelay(TimeUnit.NANOSECONDS) <= 0L) {
                collection.add(this.q.poll());
                ++n;
            }
            if (n > 0) {
                this.lock.notifyAll();
            }
            return n;
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
        Object object = this.lock;
        synchronized (object) {
            Object object2;
            int n2;
            for (n2 = 0; n2 < n && (object2 = this.q.peek()) != null && ((Delayed)object2).getDelay(TimeUnit.NANOSECONDS) <= 0L; ++n2) {
                collection.add(this.q.poll());
            }
            if (n2 > 0) {
                this.lock.notifyAll();
            }
            return n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.lock;
        synchronized (object) {
            this.q.clear();
        }
    }

    @Override
    public int remainingCapacity() {
        return -129;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        Object object = this.lock;
        synchronized (object) {
            return this.q.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        Object object = this.lock;
        synchronized (object) {
            return this.q.toArray(objectArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        Object object2 = this.lock;
        synchronized (object2) {
            return this.q.remove(object);
        }
    }

    @Override
    public Iterator iterator() {
        return new DelayQueue$Itr(this, this.toArray());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Object access$000(DelayQueue delayQueue) {
        return delayQueue.lock;
    }

    static /* synthetic */ PriorityQueue access$100(DelayQueue delayQueue) {
        return delayQueue.q;
    }

    static {
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$concurrent$DelayQueue == null ? (class$edu$emory$mathcs$backport$java$util$concurrent$DelayQueue = DelayQueue.class$("edu.emory.mathcs.backport.java.util.concurrent.DelayQueue")) : class$edu$emory$mathcs$backport$java$util$concurrent$DelayQueue).desiredAssertionStatus();
    }
}

