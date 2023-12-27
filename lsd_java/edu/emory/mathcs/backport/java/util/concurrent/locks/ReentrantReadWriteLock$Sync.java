/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

abstract class ReentrantReadWriteLock$Sync
implements Serializable {
    private static final int NONE;
    private static final int READER;
    private static final int WRITER;
    transient int activeReaders_ = 0;
    transient Thread activeWriter_ = null;
    transient int waitingReaders_ = 0;
    transient int waitingWriters_ = 0;
    transient int writeHolds_ = 0;
    transient HashMap readers_ = new HashMap();
    static final Integer IONE;

    ReentrantReadWriteLock$Sync() {
    }

    synchronized boolean startReadFromNewReader() {
        boolean bl = this.startRead();
        if (!bl) {
            ++this.waitingReaders_;
        }
        return bl;
    }

    synchronized boolean startWriteFromNewWriter() {
        boolean bl = this.startWrite();
        if (!bl) {
            ++this.waitingWriters_;
        }
        return bl;
    }

    synchronized boolean startReadFromWaitingReader() {
        boolean bl = this.startRead();
        if (bl) {
            --this.waitingReaders_;
        }
        return bl;
    }

    synchronized boolean startWriteFromWaitingWriter() {
        boolean bl = this.startWrite();
        if (bl) {
            --this.waitingWriters_;
        }
        return bl;
    }

    synchronized void cancelledWaitingReader() {
        --this.waitingReaders_;
    }

    synchronized void cancelledWaitingWriter() {
        --this.waitingWriters_;
    }

    boolean allowReader() {
        return this.activeWriter_ == null && this.waitingWriters_ == 0 || this.activeWriter_ == Thread.currentThread();
    }

    synchronized boolean startRead() {
        Thread thread = Thread.currentThread();
        Object object = this.readers_.get(thread);
        if (object != null) {
            this.readers_.put(thread, new Integer((Integer)object + 1));
            ++this.activeReaders_;
            return true;
        }
        if (this.allowReader()) {
            this.readers_.put(thread, IONE);
            ++this.activeReaders_;
            return true;
        }
        return false;
    }

    synchronized boolean startWrite() {
        if (this.activeWriter_ == Thread.currentThread()) {
            ++this.writeHolds_;
            return true;
        }
        if (this.writeHolds_ == 0) {
            if (this.activeReaders_ == 0 || this.readers_.size() == 1 && this.readers_.get(Thread.currentThread()) != null) {
                this.activeWriter_ = Thread.currentThread();
                this.writeHolds_ = 1;
                return true;
            }
            return false;
        }
        return false;
    }

    synchronized int endRead() {
        Thread thread = Thread.currentThread();
        Object object = this.readers_.get(thread);
        if (object == null) {
            throw new IllegalMonitorStateException();
        }
        --this.activeReaders_;
        if (object != IONE) {
            int n = (Integer)object - 1;
            Integer n2 = n == 1 ? IONE : new Integer(n);
            this.readers_.put(thread, n2);
            return 0;
        }
        this.readers_.remove(thread);
        if (this.writeHolds_ > 0) {
            return 0;
        }
        if (this.activeReaders_ == 0 && this.waitingWriters_ > 0) {
            return 2;
        }
        return 0;
    }

    synchronized int endWrite() {
        if (this.activeWriter_ != Thread.currentThread()) {
            throw new IllegalMonitorStateException();
        }
        --this.writeHolds_;
        if (this.writeHolds_ > 0) {
            return 0;
        }
        this.activeWriter_ = null;
        if (this.waitingReaders_ > 0 && this.allowReader()) {
            return 1;
        }
        if (this.waitingWriters_ > 0) {
            return 2;
        }
        return 0;
    }

    synchronized Thread getOwner() {
        return this.activeWriter_;
    }

    synchronized int getReadLockCount() {
        return this.activeReaders_;
    }

    synchronized boolean isWriteLocked() {
        return this.activeWriter_ != null;
    }

    synchronized boolean isWriteLockedByCurrentThread() {
        return this.activeWriter_ == Thread.currentThread();
    }

    synchronized int getWriteHoldCount() {
        return this.isWriteLockedByCurrentThread() ? this.writeHolds_ : 0;
    }

    synchronized int getReadHoldCount() {
        if (this.activeReaders_ == 0) {
            return 0;
        }
        Thread thread = Thread.currentThread();
        Integer n = (Integer)this.readers_.get(thread);
        return n == null ? 0 : n;
    }

    final synchronized boolean hasQueuedThreads() {
        return this.waitingWriters_ > 0 || this.waitingReaders_ > 0;
    }

    final synchronized int getQueueLength() {
        return this.waitingWriters_ + this.waitingReaders_;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        ReentrantReadWriteLock$Sync reentrantReadWriteLock$Sync = this;
        synchronized (reentrantReadWriteLock$Sync) {
            this.readers_ = new HashMap();
        }
    }

    static {
        IONE = new Integer(1);
    }
}

