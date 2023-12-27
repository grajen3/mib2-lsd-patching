/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.FIFOWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$QueuedSync;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$WaitNode;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar$ExclusiveLock;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.FIFOCondVar$1;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

class FIFOCondVar
extends CondVar
implements Condition,
Serializable {
    private static final WaitQueue$QueuedSync sync = new FIFOCondVar$1();
    private final WaitQueue wq = new FIFOWaitQueue();

    FIFOCondVar(CondVar$ExclusiveLock condVar$ExclusiveLock) {
        super(condVar$ExclusiveLock);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void awaitUninterruptibly() {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        WaitQueue$WaitNode waitQueue$WaitNode = new WaitQueue$WaitNode();
        this.wq.insert(waitQueue$WaitNode);
        for (int i2 = n; i2 > 0; --i2) {
            this.lock.unlock();
        }
        try {
            waitQueue$WaitNode.doWaitUninterruptibly(sync);
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void await() {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        WaitQueue$WaitNode waitQueue$WaitNode = new WaitQueue$WaitNode();
        this.wq.insert(waitQueue$WaitNode);
        for (int i2 = n; i2 > 0; --i2) {
            this.lock.unlock();
        }
        try {
            waitQueue$WaitNode.doWait(sync);
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean await(long l, TimeUnit timeUnit) {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        long l2 = timeUnit.toNanos(l);
        WaitQueue$WaitNode waitQueue$WaitNode = new WaitQueue$WaitNode();
        this.wq.insert(waitQueue$WaitNode);
        boolean bl = false;
        for (int i2 = n; i2 > 0; --i2) {
            this.lock.unlock();
        }
        try {
            bl = waitQueue$WaitNode.doTimedWait(sync, l2);
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
        return bl;
    }

    @Override
    public boolean awaitUntil(Date date) {
        if (date == null) {
            throw new NullPointerException();
        }
        long l = date.getTime();
        long l2 = System.currentTimeMillis();
        long l3 = l - l2;
        return this.await(l3, TimeUnit.MILLISECONDS);
    }

    @Override
    public void signal() {
        WaitQueue$WaitNode waitQueue$WaitNode;
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        do {
            if ((waitQueue$WaitNode = this.wq.extract()) != null) continue;
            return;
        } while (!waitQueue$WaitNode.signal(sync));
    }

    @Override
    public void signalAll() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        WaitQueue$WaitNode waitQueue$WaitNode;
        while ((waitQueue$WaitNode = this.wq.extract()) != null) {
            waitQueue$WaitNode.signal(sync);
        }
        return;
    }

    @Override
    protected boolean hasWaiters() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.wq.hasNodes();
    }

    @Override
    protected int getWaitQueueLength() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.wq.getLength();
    }

    @Override
    protected Collection getWaitingThreads() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.wq.getWaitingThreads();
    }
}

