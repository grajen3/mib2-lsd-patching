/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.io.Serializable;
import java.util.Collection;

abstract class Semaphore$Sync
implements Serializable {
    private static final long serialVersionUID;
    int permits_;

    protected Semaphore$Sync(int n) {
        this.permits_ = n;
    }

    abstract void acquireUninterruptibly(int n) {
    }

    abstract void acquire(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean attempt(int n) {
        Semaphore$Sync semaphore$Sync = this;
        synchronized (semaphore$Sync) {
            if (this.permits_ >= n) {
                this.permits_ -= n;
                return true;
            }
            return false;
        }
    }

    abstract boolean attempt(int n, long l) {
    }

    abstract void release(int n) {
    }

    public synchronized int getPermits() {
        return this.permits_;
    }

    public synchronized int drain() {
        int n = this.permits_;
        this.permits_ = 0;
        return n;
    }

    public synchronized void reduce(int n) {
        this.permits_ -= n;
    }

    abstract boolean hasQueuedThreads() {
    }

    abstract int getQueueLength() {
    }

    abstract Collection getQueuedThreads() {
    }
}

