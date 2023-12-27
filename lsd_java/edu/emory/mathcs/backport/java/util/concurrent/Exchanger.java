/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;

public class Exchanger {
    private final Object lock = new Object();
    private Object item;
    private int arrivalCount;

    private Object doExchange(Object object, boolean bl, long l) {
        Object object2 = this.lock;
        synchronized (object2) {
            int n;
            long l2;
            long l3 = l2 = bl ? Utils.nanoTime() + l : 0L;
            while (this.arrivalCount == 2) {
                if (!bl) {
                    this.lock.wait();
                    continue;
                }
                if (l > 0L) {
                    TimeUnit.NANOSECONDS.timedWait(this.lock, l);
                    l = l2 - Utils.nanoTime();
                    continue;
                }
                throw new TimeoutException();
            }
            if ((n = ++this.arrivalCount) == 2) {
                Object object3 = this.item;
                this.item = object;
                this.lock.notifyAll();
                return object3;
            }
            this.item = object;
            InterruptedException interruptedException = null;
            try {
                while (this.arrivalCount != 2) {
                    if (!bl) {
                        this.lock.wait();
                        continue;
                    }
                    if (l > 0L) {
                        TimeUnit.NANOSECONDS.timedWait(this.lock, l);
                        l = l2 - Utils.nanoTime();
                        continue;
                    }
                    break;
                }
            }
            catch (InterruptedException interruptedException2) {
                interruptedException = interruptedException2;
            }
            Object object4 = this.item;
            this.item = null;
            n = this.arrivalCount;
            this.arrivalCount = 0;
            this.lock.notifyAll();
            if (n == 2) {
                if (interruptedException != null) {
                    Thread.currentThread().interrupt();
                }
                return object4;
            }
            if (interruptedException != null) {
                throw interruptedException;
            }
            throw new TimeoutException();
        }
    }

    public Object exchange(Object object) {
        try {
            return this.doExchange(object, false, 0L);
        }
        catch (TimeoutException timeoutException) {
            throw new Error(timeoutException);
        }
    }

    public Object exchange(Object object, long l, TimeUnit timeUnit) {
        return this.doExchange(object, true, timeUnit.toNanos(l));
    }
}

