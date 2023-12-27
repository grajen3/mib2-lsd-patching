/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import java.io.Serializable;
import java.util.Collection;

abstract class ReentrantLock$Sync
implements Serializable {
    private static final long serialVersionUID;
    protected transient Thread owner_ = null;
    protected transient int holds_ = 0;

    protected ReentrantLock$Sync() {
    }

    public abstract void lock() {
    }

    public abstract void lockInterruptibly() {
    }

    final void incHolds() {
        int n;
        if ((n = ++this.holds_) < 0) {
            throw new Error("Maximum lock count exceeded");
        }
        this.holds_ = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean tryLock() {
        Thread thread = Thread.currentThread();
        ReentrantLock$Sync reentrantLock$Sync = this;
        synchronized (reentrantLock$Sync) {
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
        return false;
    }

    public abstract boolean tryLock(long l) {
    }

    public abstract void unlock() {
    }

    public synchronized int getHoldCount() {
        return this.isHeldByCurrentThread() ? this.holds_ : 0;
    }

    public synchronized boolean isHeldByCurrentThread() {
        return this.holds_ > 0 && Thread.currentThread() == this.owner_;
    }

    public synchronized boolean isLocked() {
        return this.owner_ != null;
    }

    public abstract boolean isFair() {
    }

    protected synchronized Thread getOwner() {
        return this.owner_;
    }

    public boolean hasQueuedThreads() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    public int getQueueLength() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    public Collection getQueuedThreads() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    public boolean isQueued(Thread thread) {
        throw new UnsupportedOperationException("Use FAIR version");
    }
}

