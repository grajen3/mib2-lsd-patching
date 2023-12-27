/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$EmptyIterator;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$FifoWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$LifoWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$Node;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue$WaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class SynchronousQueue
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private static final long serialVersionUID;
    private final ReentrantLock qlock;
    private final SynchronousQueue$WaitQueue waitingProducers;
    private final SynchronousQueue$WaitQueue waitingConsumers;

    public SynchronousQueue() {
        this(false);
    }

    public SynchronousQueue(boolean bl) {
        if (bl) {
            this.qlock = new ReentrantLock(true);
            this.waitingProducers = new SynchronousQueue$FifoWaitQueue();
            this.waitingConsumers = new SynchronousQueue$FifoWaitQueue();
        } else {
            this.qlock = new ReentrantLock();
            this.waitingProducers = new SynchronousQueue$LifoWaitQueue();
            this.waitingConsumers = new SynchronousQueue$LifoWaitQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void unlinkCancelledConsumer(SynchronousQueue$Node node) {
        if (this.waitingConsumers.shouldUnlink(node)) {
            this.qlock.lock();
            try {
                if (this.waitingConsumers.shouldUnlink(node)) {
                    this.waitingConsumers.unlink(node);
                }
            }
            finally {
                this.qlock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void unlinkCancelledProducer(SynchronousQueue$Node node) {
        if (this.waitingProducers.shouldUnlink(node)) {
            this.qlock.lock();
            try {
                if (this.waitingProducers.shouldUnlink(node)) {
                    this.waitingProducers.unlink(node);
                }
            }
            finally {
                this.qlock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void put(Object object) {
        SynchronousQueue$Node synchronousQueue$Node;
        if (object == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                synchronousQueue$Node = this.waitingConsumers.deq();
                bl = synchronousQueue$Node == null;
                if (bl) {
                    synchronousQueue$Node = this.waitingProducers.enq(object);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                synchronousQueue$Node.waitForTake();
                return;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledProducer(synchronousQueue$Node);
                throw interruptedException;
            }
        } while (!synchronousQueue$Node.setItem(object));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object, long l, TimeUnit timeUnit) {
        SynchronousQueue$Node synchronousQueue$Node;
        if (object == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                synchronousQueue$Node = this.waitingConsumers.deq();
                bl = synchronousQueue$Node == null;
                if (bl) {
                    synchronousQueue$Node = this.waitingProducers.enq(object);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                boolean bl2 = synchronousQueue$Node.waitForTake(l2);
                if (!bl2) {
                    this.unlinkCancelledProducer(synchronousQueue$Node);
                }
                return bl2;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledProducer(synchronousQueue$Node);
                throw interruptedException;
            }
        } while (!synchronousQueue$Node.setItem(object));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object take() {
        SynchronousQueue$Node synchronousQueue$Node;
        Object object;
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                synchronousQueue$Node = this.waitingProducers.deq();
                bl = synchronousQueue$Node == null;
                if (bl) {
                    synchronousQueue$Node = this.waitingConsumers.enq(null);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                object = synchronousQueue$Node.waitForPut();
                return object;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledConsumer(synchronousQueue$Node);
                throw interruptedException;
            }
        } while ((object = synchronousQueue$Node.getItem()) == null);
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object poll(long l, TimeUnit timeUnit) {
        SynchronousQueue$Node synchronousQueue$Node;
        Object object;
        long l2 = timeUnit.toNanos(l);
        ReentrantLock reentrantLock = this.qlock;
        do {
            boolean bl;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            reentrantLock.lock();
            try {
                synchronousQueue$Node = this.waitingProducers.deq();
                bl = synchronousQueue$Node == null;
                if (bl) {
                    synchronousQueue$Node = this.waitingConsumers.enq(null);
                }
            }
            finally {
                reentrantLock.unlock();
            }
            if (!bl) continue;
            try {
                object = synchronousQueue$Node.waitForPut(l2);
                if (object == null) {
                    this.unlinkCancelledConsumer(synchronousQueue$Node);
                }
                return object;
            }
            catch (InterruptedException interruptedException) {
                this.unlinkCancelledConsumer(synchronousQueue$Node);
                throw interruptedException;
            }
        } while ((object = synchronousQueue$Node.getItem()) == null);
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean offer(Object object) {
        SynchronousQueue$Node synchronousQueue$Node;
        if (object == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.qlock;
        do {
            reentrantLock.lock();
            try {
                synchronousQueue$Node = this.waitingConsumers.deq();
            }
            finally {
                reentrantLock.unlock();
            }
            if (synchronousQueue$Node != null) continue;
            return false;
        } while (!synchronousQueue$Node.setItem(object));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object poll() {
        SynchronousQueue$Node synchronousQueue$Node;
        Object object;
        ReentrantLock reentrantLock = this.qlock;
        do {
            reentrantLock.lock();
            try {
                synchronousQueue$Node = this.waitingProducers.deq();
            }
            finally {
                reentrantLock.unlock();
            }
            if (synchronousQueue$Node != null) continue;
            return null;
        } while ((object = synchronousQueue$Node.getItem()) == null);
        return object;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public boolean remove(Object object) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return collection.isEmpty();
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return new SynchronousQueue$EmptyIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        if (objectArray.length > 0) {
            objectArray[0] = null;
        }
        return objectArray;
    }

    @Override
    public int drainTo(Collection collection) {
        Object object;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int n = 0;
        while ((object = this.poll()) != null) {
            collection.add(object);
            ++n;
        }
        return n;
    }

    @Override
    public int drainTo(Collection collection, int n) {
        Object object;
        int n2;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        for (n2 = 0; n2 < n && (object = this.poll()) != null; ++n2) {
            collection.add(object);
        }
        return n2;
    }
}

