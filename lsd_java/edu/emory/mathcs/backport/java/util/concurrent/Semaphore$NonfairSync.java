/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Semaphore$Sync;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.util.Collection;

final class Semaphore$NonfairSync
extends Semaphore$Sync {
    private static final long serialVersionUID;

    protected Semaphore$NonfairSync(int n) {
        super(n);
    }

    private static void checkAgainstMultiacquire(int n) {
        if (n != 1) {
            throw new UnsupportedOperationException("Atomic multi-acquire supported only in FAIR semaphores");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void acquireUninterruptibly(int n) {
        if (n == 0) {
            return;
        }
        Semaphore$NonfairSync.checkAgainstMultiacquire(n);
        Semaphore$NonfairSync semaphore$NonfairSync = this;
        synchronized (semaphore$NonfairSync) {
            if (this.permits_ > 0) {
                --this.permits_;
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
                } while (this.permits_ <= 0);
                --this.permits_;
                return;
            }
            finally {
                if (bl) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void acquire(int n) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (n == 0) {
            return;
        }
        Semaphore$NonfairSync.checkAgainstMultiacquire(n);
        Semaphore$NonfairSync semaphore$NonfairSync = this;
        synchronized (semaphore$NonfairSync) {
            while (this.permits_ <= 0) {
                try {
                    super.wait();
                }
                catch (InterruptedException interruptedException) {
                    super.notify();
                    throw interruptedException;
                }
            }
            --this.permits_;
        }
    }

    @Override
    public boolean attempt(int n, long l) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (n == 0) {
            return true;
        }
        Semaphore$NonfairSync.checkAgainstMultiacquire(n);
        Semaphore$NonfairSync semaphore$NonfairSync = this;
        synchronized (semaphore$NonfairSync) {
            if (this.permits_ > 0) {
                --this.permits_;
                return true;
            }
            if (l <= 0L) {
                return false;
            }
            try {
                long l2 = Utils.nanoTime() + l;
                do {
                    TimeUnit.NANOSECONDS.timedWait(this, l);
                    if (this.permits_ <= 0) continue;
                    --this.permits_;
                    return true;
                } while ((l = l2 - Utils.nanoTime()) > 0L);
                return false;
            }
            catch (InterruptedException interruptedException) {
                super.notify();
                throw interruptedException;
            }
        }
    }

    @Override
    public synchronized void release(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative argument");
        }
        this.permits_ += n;
        for (int i2 = 0; i2 < n; ++i2) {
            super.notify();
        }
    }

    @Override
    public boolean hasQueuedThreads() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    @Override
    public int getQueueLength() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    @Override
    public Collection getQueuedThreads() {
        throw new UnsupportedOperationException("Use FAIR version");
    }
}

