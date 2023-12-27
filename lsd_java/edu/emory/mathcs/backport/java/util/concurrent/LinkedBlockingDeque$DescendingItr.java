/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque$1;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque$AbstractItr;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;

class LinkedBlockingDeque$DescendingItr
extends LinkedBlockingDeque$AbstractItr {
    private final /* synthetic */ LinkedBlockingDeque this$0;

    private LinkedBlockingDeque$DescendingItr(LinkedBlockingDeque linkedBlockingDeque) {
        this.this$0 = linkedBlockingDeque;
        super(linkedBlockingDeque);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void advance() {
        ReentrantLock reentrantLock = LinkedBlockingDeque.access$200(this.this$0);
        reentrantLock.lock();
        try {
            this.next = this.next == null ? LinkedBlockingDeque.access$400(this.this$0) : this.next.prev;
            this.nextItem = this.next == null ? null : this.next.item;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /* synthetic */ LinkedBlockingDeque$DescendingItr(LinkedBlockingDeque linkedBlockingDeque, LinkedBlockingDeque$1 linkedBlockingDeque$1) {
        this(linkedBlockingDeque);
    }
}

