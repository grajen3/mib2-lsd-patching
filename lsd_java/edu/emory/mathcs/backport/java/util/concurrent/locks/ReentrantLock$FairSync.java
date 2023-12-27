/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.FIFOWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$QueuedSync;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock$Sync;
import java.io.ObjectInputStream;
import java.util.Collection;

final class ReentrantLock$FairSync
extends ReentrantLock$Sync
implements WaitQueue$QueuedSync {
    private static final long serialVersionUID;
    private transient WaitQueue wq_ = new FIFOWaitQueue();

    ReentrantLock$FairSync() {
    }

    @Override
    public synchronized boolean recheck(WaitQueue$WaitNode waitQueue$WaitNode) {
        Thread thread = Thread.currentThread();
        if (this.owner_ == null) {
            this.owner_ = thread;
            this.holds_ = 1;
            return true;
        }
        if (thread == this.owner_) {
            this.incHolds();
            return true;
        }
        this.wq_.insert(waitQueue$WaitNode);
        return false;
    }

    @Override
    public synchronized void takeOver(WaitQueue$WaitNode waitQueue$WaitNode) {
        this.owner_ = waitQueue$WaitNode.getOwner();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lock() {
        Thread thread = Thread.currentThread();
        Object object = this;
        synchronized (object) {
            if (this.owner_ == null) {
                this.owner_ = thread;
                this.holds_ = 1;
                return;
            }
            if (thread == this.owner_) {
                this.incHolds();
                return;
            }
        }
        object = new WaitQueue$WaitNode();
        ((WaitQueue$WaitNode)object).doWaitUninterruptibly(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lockInterruptibly() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Thread thread = Thread.currentThread();
        Object object = this;
        synchronized (object) {
            if (this.owner_ == null) {
                this.owner_ = thread;
                this.holds_ = 1;
                return;
            }
            if (thread == this.owner_) {
                this.incHolds();
                return;
            }
        }
        object = new WaitQueue$WaitNode();
        ((WaitQueue$WaitNode)object).doWait(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean tryLock(long l) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Thread thread = Thread.currentThread();
        Object object = this;
        synchronized (object) {
            if (this.owner_ == null) {
                this.owner_ = thread;
                this.holds_ = 1;
                return true;
            }
            if (thread == this.owner_) {
                this.incHolds();
                return true;
            }
        }
        object = new WaitQueue$WaitNode();
        return ((WaitQueue$WaitNode)object).doTimedWait(this, l);
    }

    protected synchronized WaitQueue$WaitNode getSignallee(Thread thread) {
        if (thread != this.owner_) {
            throw new IllegalMonitorStateException("Not owner");
        }
        if (this.holds_ >= 2) {
            --this.holds_;
            return null;
        }
        WaitQueue$WaitNode waitQueue$WaitNode = this.wq_.extract();
        if (waitQueue$WaitNode == null) {
            this.owner_ = null;
            this.holds_ = 0;
        }
        return waitQueue$WaitNode;
    }

    @Override
    public void unlock() {
        WaitQueue$WaitNode waitQueue$WaitNode;
        Thread thread = Thread.currentThread();
        do {
            if ((waitQueue$WaitNode = this.getSignallee(thread)) != null) continue;
            return;
        } while (!waitQueue$WaitNode.signal(this));
    }

    @Override
    public final boolean isFair() {
        return true;
    }

    @Override
    public synchronized boolean hasQueuedThreads() {
        return this.wq_.hasNodes();
    }

    @Override
    public synchronized int getQueueLength() {
        return this.wq_.getLength();
    }

    @Override
    public synchronized Collection getQueuedThreads() {
        return this.wq_.getWaitingThreads();
    }

    @Override
    public synchronized boolean isQueued(Thread thread) {
        return this.wq_.isWaiting(thread);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        ReentrantLock$FairSync reentrantLock$FairSync = this;
        synchronized (reentrantLock$FairSync) {
            this.wq_ = new FIFOWaitQueue();
        }
    }
}

