/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue$QueuedSync;

public class WaitQueue$WaitNode {
    boolean waiting = true;
    WaitQueue$WaitNode next = null;
    final Thread owner = Thread.currentThread();

    public Thread getOwner() {
        return this.owner;
    }

    public synchronized boolean signal(WaitQueue$QueuedSync waitQueue$QueuedSync) {
        boolean bl = this.waiting;
        if (bl) {
            this.waiting = false;
            super.notify();
            waitQueue$QueuedSync.takeOver(this);
        }
        return bl;
    }

    public synchronized boolean doTimedWait(WaitQueue$QueuedSync waitQueue$QueuedSync, long l) {
        if (waitQueue$QueuedSync.recheck(this) || !this.waiting) {
            return true;
        }
        if (l <= 0L) {
            this.waiting = false;
            return false;
        }
        long l2 = Utils.nanoTime() + l;
        try {
            do {
                TimeUnit.NANOSECONDS.timedWait(this, l);
                if (this.waiting) continue;
                return true;
            } while ((l = l2 - Utils.nanoTime()) > 0L);
            this.waiting = false;
            return false;
        }
        catch (InterruptedException interruptedException) {
            if (this.waiting) {
                this.waiting = false;
                throw interruptedException;
            }
            Thread.currentThread().interrupt();
            return true;
        }
    }

    public synchronized void doWait(WaitQueue$QueuedSync waitQueue$QueuedSync) {
        if (!waitQueue$QueuedSync.recheck(this)) {
            try {
                while (this.waiting) {
                    super.wait();
                }
            }
            catch (InterruptedException interruptedException) {
                if (this.waiting) {
                    this.waiting = false;
                    throw interruptedException;
                }
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void doWaitUninterruptibly(WaitQueue$QueuedSync waitQueue$QueuedSync) {
        if (!waitQueue$QueuedSync.recheck(this)) {
            boolean bl = Thread.interrupted();
            try {
                while (this.waiting) {
                    try {
                        super.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        bl = true;
                    }
                }
            }
            finally {
                if (bl) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

