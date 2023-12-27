/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.locks.Lock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReadWriteLock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock$NonfairSync;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock$Sync;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock;
import java.io.Serializable;

public class ReentrantReadWriteLock
implements ReadWriteLock,
Serializable {
    private static final long serialVersionUID;
    final ReentrantReadWriteLock$ReadLock readerLock_ = new ReentrantReadWriteLock$ReadLock(this);
    final ReentrantReadWriteLock$WriteLock writerLock_ = new ReentrantReadWriteLock$WriteLock(this);
    final ReentrantReadWriteLock$Sync sync = new ReentrantReadWriteLock$NonfairSync();

    @Override
    public Lock writeLock() {
        return this.writerLock_;
    }

    @Override
    public Lock readLock() {
        return this.readerLock_;
    }

    public final boolean isFair() {
        return false;
    }

    protected Thread getOwner() {
        return this.sync.getOwner();
    }

    public int getReadLockCount() {
        return this.sync.getReadLockCount();
    }

    public boolean isWriteLocked() {
        return this.sync.isWriteLocked();
    }

    public boolean isWriteLockedByCurrentThread() {
        return this.sync.isWriteLockedByCurrentThread();
    }

    public int getWriteHoldCount() {
        return this.sync.getWriteHoldCount();
    }

    public int getReadHoldCount() {
        return this.sync.getReadHoldCount();
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append("[Write locks = ").append(this.getWriteHoldCount()).append(", Read locks = ").append(this.getReadLockCount()).append("]").toString();
    }
}

