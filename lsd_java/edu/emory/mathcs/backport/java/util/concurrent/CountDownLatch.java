/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;

public class CountDownLatch {
    private int count_;

    public CountDownLatch(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        this.count_ = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void await() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        CountDownLatch countDownLatch = this;
        synchronized (countDownLatch) {
            while (this.count_ > 0) {
                super.wait();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean await(long l, TimeUnit timeUnit) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        long l2 = timeUnit.toNanos(l);
        CountDownLatch countDownLatch = this;
        synchronized (countDownLatch) {
            if (this.count_ <= 0) {
                return true;
            }
            if (l2 <= 0L) {
                return false;
            }
            long l3 = Utils.nanoTime() + l2;
            do {
                TimeUnit.NANOSECONDS.timedWait(this, l2);
                if (this.count_ > 0) continue;
                return true;
            } while ((l2 = l3 - Utils.nanoTime()) > 0L);
            return false;
        }
    }

    public synchronized void countDown() {
        if (this.count_ == 0) {
            return;
        }
        if (--this.count_ == 0) {
            super.notifyAll();
        }
    }

    public long getCount() {
        return this.count_;
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append("[Count = ").append(this.getCount()).append("]").toString();
    }
}

