/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock$Sync;

final class ReentrantLock$NonfairSync
extends ReentrantLock$Sync {
    private static final long serialVersionUID;

    ReentrantLock$NonfairSync() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lock() {
        Thread thread = Thread.currentThread();
        ReentrantLock$NonfairSync reentrantLock$NonfairSync = this;
        synchronized (reentrantLock$NonfairSync) {
            if (this.owner_ == null) {
                this.owner_ = thread;
                this.holds_ = 1;
                return;
            }
            if (thread == this.owner_) {
                this.incHolds();
                return;
            }
            boolean bl = Thread.interrupted();
            try {
                do {
                    try {
                        super.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        bl = true;
                    }
                } while (this.owner_ != null);
                this.owner_ = thread;
                this.holds_ = 1;
                return;
            }
            finally {
                if (bl) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override
    public void lockInterruptibly() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Thread thread = Thread.currentThread();
        ReentrantLock$NonfairSync reentrantLock$NonfairSync = this;
        synchronized (reentrantLock$NonfairSync) {
            if (this.owner_ == null) {
                this.owner_ = thread;
                this.holds_ = 1;
                return;
            }
            if (thread == this.owner_) {
                this.incHolds();
                return;
            }
            try {
                do {
                    super.wait();
                } while (this.owner_ != null);
                this.owner_ = thread;
                this.holds_ = 1;
                return;
            }
            catch (InterruptedException interruptedException) {
                if (this.owner_ == null) {
                    super.notify();
                }
                throw interruptedException;
            }
        }
    }

    @Override
    public boolean tryLock(long l) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Thread thread = Thread.currentThread();
        ReentrantLock$NonfairSync reentrantLock$NonfairSync = this;
        synchronized (reentrantLock$NonfairSync) {
            if (this.owner_ == null) {
                this.owner_ = thread;
                this.holds_ = 1;
                return true;
            }
            if (thread == this.owner_) {
                this.incHolds();
                return true;
            }
            if (l <= 0L) {
                return false;
            }
            long l2 = Utils.nanoTime() + l;
            try {
                do {
                    TimeUnit.NANOSECONDS.timedWait(this, l);
                    if (thread == this.owner_) {
                        this.incHolds();
                        return true;
                    }
                    if (this.owner_ != null) continue;
                    this.owner_ = thread;
                    this.holds_ = 1;
                    return true;
                } while ((l = l2 - Utils.nanoTime()) > 0L);
                return false;
            }
            catch (InterruptedException interruptedException) {
                if (this.owner_ == null) {
                    super.notify();
                }
                throw interruptedException;
            }
        }
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() != this.owner_) {
            throw new IllegalMonitorStateException("Not owner");
        }
        if (--this.holds_ == 0) {
            this.owner_ = null;
            super.notify();
        }
    }

    @Override
    public final boolean isFair() {
        return false;
    }
}

