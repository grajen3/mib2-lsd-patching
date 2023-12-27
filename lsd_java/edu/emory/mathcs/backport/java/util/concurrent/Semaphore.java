/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Semaphore$FairSync;
import edu.emory.mathcs.backport.java.util.concurrent.Semaphore$NonfairSync;
import edu.emory.mathcs.backport.java.util.concurrent.Semaphore$Sync;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.io.Serializable;
import java.util.Collection;

public class Semaphore
implements Serializable {
    private static final long serialVersionUID;
    private final Semaphore$Sync sync;

    public Semaphore(int n) {
        this.sync = new Semaphore$NonfairSync(n);
    }

    public Semaphore(int n, boolean bl) {
        this.sync = bl ? new Semaphore$FairSync(n) : new Semaphore$NonfairSync(n);
    }

    public void acquire() {
        this.sync.acquire(1);
    }

    public void acquireUninterruptibly() {
        this.sync.acquireUninterruptibly(1);
    }

    public boolean tryAcquire() {
        return this.sync.attempt(1);
    }

    public boolean tryAcquire(long l, TimeUnit timeUnit) {
        return this.sync.attempt(1, timeUnit.toNanos(l));
    }

    public void release() {
        this.sync.release(1);
    }

    public void acquire(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.acquire(n);
    }

    public void acquireUninterruptibly(int n) {
        this.sync.acquireUninterruptibly(n);
    }

    public boolean tryAcquire(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        return this.sync.attempt(n);
    }

    public boolean tryAcquire(int n, long l, TimeUnit timeUnit) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        return this.sync.attempt(n, timeUnit.toNanos(l));
    }

    public void release(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.release(n);
    }

    public int availablePermits() {
        return this.sync.getPermits();
    }

    public int drainPermits() {
        return this.sync.drain();
    }

    protected void reducePermits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.reduce(n);
    }

    public boolean isFair() {
        return this.sync instanceof Semaphore$FairSync;
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append("[Permits = ").append(this.sync.getPermits()).append("]").toString();
    }
}

