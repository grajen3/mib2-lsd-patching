/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.io.Serializable;

final class SynchronousQueue$Node
implements Serializable {
    private static final long serialVersionUID;
    private static final int ACK;
    private static final int CANCEL;
    int state = 0;
    Object item;
    SynchronousQueue$Node next;

    SynchronousQueue$Node(Object object) {
        this.item = object;
    }

    SynchronousQueue$Node(Object object, SynchronousQueue$Node synchronousQueue$Node) {
        this.item = object;
        this.next = synchronousQueue$Node;
    }

    private Object extract() {
        Object object = this.item;
        this.item = null;
        return object;
    }

    private void checkCancellationOnInterrupt(InterruptedException interruptedException) {
        if (this.state == 0) {
            this.state = -1;
            super.notify();
            throw interruptedException;
        }
        Thread.currentThread().interrupt();
    }

    synchronized boolean setItem(Object object) {
        if (this.state != 0) {
            return false;
        }
        this.item = object;
        this.state = 1;
        super.notify();
        return true;
    }

    synchronized Object getItem() {
        if (this.state != 0) {
            return null;
        }
        this.state = 1;
        super.notify();
        return this.extract();
    }

    synchronized void waitForTake() {
        try {
            while (this.state == 0) {
                super.wait();
            }
        }
        catch (InterruptedException interruptedException) {
            this.checkCancellationOnInterrupt(interruptedException);
        }
    }

    synchronized Object waitForPut() {
        try {
            while (this.state == 0) {
                super.wait();
            }
        }
        catch (InterruptedException interruptedException) {
            this.checkCancellationOnInterrupt(interruptedException);
        }
        return this.extract();
    }

    private boolean attempt(long l) {
        if (this.state != 0) {
            return true;
        }
        if (l <= 0L) {
            this.state = -1;
            super.notify();
            return false;
        }
        long l2 = Utils.nanoTime() + l;
        do {
            TimeUnit.NANOSECONDS.timedWait(this, l);
            if (this.state == 0) continue;
            return true;
        } while ((l = l2 - Utils.nanoTime()) > 0L);
        this.state = -1;
        super.notify();
        return false;
    }

    synchronized boolean waitForTake(long l) {
        try {
            if (!this.attempt(l)) {
                return false;
            }
        }
        catch (InterruptedException interruptedException) {
            this.checkCancellationOnInterrupt(interruptedException);
        }
        return true;
    }

    synchronized Object waitForPut(long l) {
        try {
            if (!this.attempt(l)) {
                return null;
            }
        }
        catch (InterruptedException interruptedException) {
            this.checkCancellationOnInterrupt(interruptedException);
        }
        return this.extract();
    }
}

