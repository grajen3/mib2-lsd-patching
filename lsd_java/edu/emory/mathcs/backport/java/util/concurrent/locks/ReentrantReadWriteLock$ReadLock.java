/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Lock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantReadWriteLock;
import java.io.Serializable;

public class ReentrantReadWriteLock$ReadLock
implements Lock,
Serializable {
    private static final long serialVersionUID;
    final ReentrantReadWriteLock lock;

    protected ReentrantReadWriteLock$ReadLock(ReentrantReadWriteLock reentrantReadWriteLock) {
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
        ReentrantReadWriteLock$ReadLock reentrantReadWriteLock$ReadLock = this;
        synchronized (reentrantReadWriteLock$ReadLock) {
            if (this.lock.sync.startReadFromNewReader()) {
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
                } while (!this.lock.sync.startReadFromWaitingReader());
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
        ReentrantReadWriteLock$ReadLock reentrantReadWriteLock$ReadLock = this;
        synchronized (reentrantReadWriteLock$ReadLock) {
            if (!this.lock.sync.startReadFromNewReader()) {
                try {
                    do {
                        super.wait();
                    } while (!this.lock.sync.startReadFromWaitingReader());
                    return;
                }
                catch (InterruptedException interruptedException2) {
                    this.lock.sync.cancelledWaitingReader();
                    interruptedException = interruptedException2;
                }
            }
        }
        if (interruptedException != null) {
            this.lock.writerLock_.signalWaiters();
            throw interruptedException;
        }
    }

    @Override
    public boolean tryLock() {
        return this.lock.sync.startRead();
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
        ReentrantReadWriteLock$ReadLock reentrantReadWriteLock$ReadLock = this;
        synchronized (reentrantReadWriteLock$ReadLock) {
            block10: {
                if (l2 <= 0L) {
                    return this.lock.sync.startRead();
                }
                if (this.lock.sync.startReadFromNewReader()) {
                    return true;
                }
                long l3 = Utils.nanoTime() + l2;
                do {
                    try {
                        TimeUnit.NANOSECONDS.timedWait(this, l2);
                    }
                    catch (InterruptedException interruptedException2) {
                        this.lock.sync.cancelledWaitingReader();
                        interruptedException = interruptedException2;
                        break block10;
                    }
                    if (!this.lock.sync.startReadFromWaitingReader()) continue;
                    return true;
                } while ((l2 = l3 - Utils.nanoTime()) > 0L);
                this.lock.sync.cancelledWaitingReader();
            }
        }
        this.lock.writerLock_.signalWaiters();
        if (interruptedException != null) {
            throw interruptedException;
        }
        return false;
    }

    @Override
    public void unlock() {
        switch (this.lock.sync.endRead()) {
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
        throw new UnsupportedOperationException();
    }

    synchronized void signalWaiters() {
        super.notifyAll();
    }

    public String toString() {
        int n = this.lock.getReadLockCount();
        return new StringBuffer().append(super.toString()).append("[Read locks = ").append(n).append("]").toString();
    }
}

