/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Semaphore$FairSync$Node;
import edu.emory.mathcs.backport.java.util.concurrent.Semaphore$Sync;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.FIFOWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$QueuedSync;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;
import java.io.ObjectInputStream;
import java.util.Collection;

final class Semaphore$FairSync
extends Semaphore$Sync
implements WaitQueue$QueuedSync {
    private static final long serialVersionUID;
    private transient WaitQueue wq_ = new FIFOWaitQueue();

    Semaphore$FairSync(int n) {
        super(n);
    }

    @Override
    public void acquireUninterruptibly(int n) {
        if (this.precheck(n)) {
            return;
        }
        Semaphore$FairSync$Node semaphore$FairSync$Node = new Semaphore$FairSync$Node(n);
        semaphore$FairSync$Node.doWaitUninterruptibly(this);
    }

    @Override
    public void acquire(int n) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.precheck(n)) {
            return;
        }
        Semaphore$FairSync$Node semaphore$FairSync$Node = new Semaphore$FairSync$Node(n);
        semaphore$FairSync$Node.doWait(this);
    }

    @Override
    public boolean attempt(int n, long l) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.precheck(n)) {
            return true;
        }
        if (l <= 0L) {
            return false;
        }
        Semaphore$FairSync$Node semaphore$FairSync$Node = new Semaphore$FairSync$Node(n);
        return semaphore$FairSync$Node.doTimedWait(this, l);
    }

    protected synchronized boolean precheck(int n) {
        boolean bl;
        boolean bl2 = bl = this.permits_ >= n;
        if (bl) {
            this.permits_ -= n;
        }
        return bl;
    }

    @Override
    public synchronized boolean recheck(WaitQueue$WaitNode waitQueue$WaitNode) {
        boolean bl;
        Semaphore$FairSync$Node semaphore$FairSync$Node = (Semaphore$FairSync$Node)waitQueue$WaitNode;
        boolean bl2 = bl = this.permits_ >= semaphore$FairSync$Node.requests;
        if (bl) {
            this.permits_ -= semaphore$FairSync$Node.requests;
        } else {
            this.wq_.insert(waitQueue$WaitNode);
        }
        return bl;
    }

    @Override
    public void takeOver(WaitQueue$WaitNode waitQueue$WaitNode) {
    }

    protected synchronized Semaphore$FairSync$Node getSignallee(int n) {
        Semaphore$FairSync$Node semaphore$FairSync$Node = (Semaphore$FairSync$Node)this.wq_.extract();
        this.permits_ += n;
        if (semaphore$FairSync$Node == null) {
            return null;
        }
        if (semaphore$FairSync$Node.requests > this.permits_) {
            this.wq_.putBack(semaphore$FairSync$Node);
            return null;
        }
        this.permits_ -= semaphore$FairSync$Node.requests;
        return semaphore$FairSync$Node;
    }

    @Override
    public void release(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative argument");
        }
        Semaphore$FairSync$Node semaphore$FairSync$Node;
        while ((semaphore$FairSync$Node = this.getSignallee(n)) != null) {
            if (semaphore$FairSync$Node.signal(this)) {
                return;
            }
            n = semaphore$FairSync$Node.requests;
        }
        return;
    }

    @Override
    public synchronized boolean hasQueuedThreads() {
        return this.wq_.hasNodes();
    }

    @Override
    public synchronized int getQueueLength() {
        return this.wq_.getLength();
    }

    @Override
    public synchronized Collection getQueuedThreads() {
        return this.wq_.getWaitingThreads();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Semaphore$FairSync semaphore$FairSync = this;
        synchronized (semaphore$FairSync) {
            this.wq_ = new FIFOWaitQueue();
        }
    }
}

