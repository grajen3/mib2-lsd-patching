/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar$ExclusiveLock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.FIFOCondVar;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Lock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock$FairSync;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock$NonfairSync;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock$Sync;
import java.io.Serializable;
import java.util.Collection;

public class ReentrantLock
implements Lock,
Serializable,
CondVar$ExclusiveLock {
    private static final long serialVersionUID;
    private final ReentrantLock$Sync sync;

    public ReentrantLock() {
        this.sync = new ReentrantLock$NonfairSync();
    }

    public ReentrantLock(boolean bl) {
        this.sync = bl ? new ReentrantLock$FairSync() : new ReentrantLock$NonfairSync();
    }

    @Override
    public void lock() {
        this.sync.lock();
    }

    @Override
    public void lockInterruptibly() {
        this.sync.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        return this.sync.tryLock();
    }

    @Override
    public boolean tryLock(long l, TimeUnit timeUnit) {
        return this.sync.tryLock(timeUnit.toNanos(l));
    }

    @Override
    public void unlock() {
        this.sync.unlock();
    }

    @Override
    public Condition newCondition() {
        return this.isFair() ? new FIFOCondVar(this) : new CondVar(this);
    }

    @Override
    public int getHoldCount() {
        return this.sync.getHoldCount();
    }

    @Override
    public boolean isHeldByCurrentThread() {
        return this.sync.isHeldByCurrentThread();
    }

    public boolean isLocked() {
        return this.sync.isLocked();
    }

    public final boolean isFair() {
        return this.sync.isFair();
    }

    protected Thread getOwner() {
        return this.sync.getOwner();
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public final boolean hasQueuedThread(Thread thread) {
        return this.sync.isQueued(thread);
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    public boolean hasWaiters(Condition condition) {
        return this.asCondVar(condition).hasWaiters();
    }

    public int getWaitQueueLength(Condition condition) {
        return this.asCondVar(condition).getWaitQueueLength();
    }

    protected Collection getWaitingThreads(Condition condition) {
        return this.asCondVar(condition).getWaitingThreads();
    }

    public String toString() {
        Thread thread = this.getOwner();
        return new StringBuffer().append(super.toString()).append(thread == null ? "[Unlocked]" : new StringBuffer().append("[Locked by thread ").append(thread.getName()).append("]").toString()).toString();
    }

    private CondVar asCondVar(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (!(condition instanceof CondVar)) {
            throw new IllegalArgumentException("not owner");
        }
        CondVar condVar = (CondVar)condition;
        if (condVar.lock != this) {
            throw new IllegalArgumentException("not owner");
        }
        return condVar;
    }
}

