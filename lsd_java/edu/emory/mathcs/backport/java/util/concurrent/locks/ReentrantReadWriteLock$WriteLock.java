/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar$ExclusiveLock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Lock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock;
import java.io.Serializable;

public class ReentrantReadWriteLock$WriteLock
implements Lock,
CondVar$ExclusiveLock,
Serializable {
    private static final long serialVersionUID;
    final ReentrantReadWriteLock lock;

    protected ReentrantReadWriteLock$WriteLock(ReentrantReadWriteLock reentrantReadWriteLock) {
        if (reentrantReadWriteLock == null) {
            throw new NullPointerException();
        }
        this.lock = reentrantReadWriteLock;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lock() {
        ReentrantReadWriteLock$WriteLock reentrantReadWriteLock$WriteLock = this;
        synchronized (reentrantReadWriteLock$WriteLock) {
            if (this.lock.sync.startWriteFromNewWriter()) {
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
                } while (!this.lock.sync.startWriteFromWaitingWriter());
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
    public void lockInterruptibly() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        InterruptedException interruptedException = null;
        ReentrantReadWriteLock$WriteLock reentrantReadWriteLock$WriteLock = this;
        synchronized (reentrantReadWriteLock$WriteLock) {
            if (!this.lock.sync.startWriteFromNewWriter()) {
                try {
                    do {
                        super.wait();
                    } while (!this.lock.sync.startWriteFromWaitingWriter());
                    return;
                }
                catch (InterruptedException interruptedException2) {
                    this.lock.sync.cancelledWaitingWriter();
                    super.notify();
                    interruptedException = interruptedException2;
                }
            }
        }
        if (interruptedException != null) {
            this.lock.readerLock_.signalWaiters();
            throw interruptedException;
        }
    }

    @Override
    public boolean tryLock() {
        return this.lock.sync.startWrite();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean tryLock(long l, TimeUnit timeUnit) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        InterruptedException interruptedException = null;
        long l2 = timeUnit.toNanos(l);
        ReentrantReadWriteLock$WriteLock reentrantReadWriteLock$WriteLock = this;
        synchronized (reentrantReadWriteLock$WriteLock) {
            block10: {
                if (l2 <= 0L) {
                    return this.lock.sync.startWrite();
                }
                if (this.lock.sync.startWriteFromNewWriter()) {
                    return true;
                }
                long l3 = Utils.nanoTime() + l2;
                do {
                    try {
                        TimeUnit.NANOSECONDS.timedWait(this, l2);
                    }
                    catch (InterruptedException interruptedException2) {
                        this.lock.sync.cancelledWaitingWriter();
                        super.notify();
                        interruptedException = interruptedException2;
                        break block10;
                    }
                    if (!this.lock.sync.startWriteFromWaitingWriter()) continue;
                    return true;
                } while ((l2 = l3 - Utils.nanoTime()) > 0L);
                this.lock.sync.cancelledWaitingWriter();
                super.notify();
            }
        }
        this.lock.readerLock_.signalWaiters();
        if (interruptedException != null) {
            throw interruptedException;
        }
        return false;
    }

    @Override
    public void unlock() {
        switch (this.lock.sync.endWrite()) {
            case 0: {
                return;
            }
            case 1: {
                this.lock.readerLock_.signalWaiters();
                return;
            }
            case 2: {
                this.lock.writerLock_.signalWaiters();
                return;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return new CondVar(this);
    }

    synchronized void signalWaiters() {
        super.notify();
    }

    public String toString() {
        Thread thread = this.lock.getOwner();
        return new StringBuffer().append(super.toString()).append(thread == null ? "[Unlocked]" : new StringBuffer().append("[Locked by thread ").append(thread.getName()).append("]").toString()).toString();
    }

    @Override
    public boolean isHeldByCurrentThread() {
        return this.lock.sync.isWriteLockedByCurrentThread();
    }

    @Override
    public int getHoldCount() {
        return this.lock.sync.getWriteHoldCount();
    }
}

