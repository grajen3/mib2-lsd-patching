/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque$Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class LinkedBlockingDeque$AbstractItr
implements Iterator {
    LinkedBlockingDeque$Node next;
    Object nextItem;
    private LinkedBlockingDeque$Node lastRet;
    private final /* synthetic */ LinkedBlockingDeque this$0;

    LinkedBlockingDeque$AbstractItr(LinkedBlockingDeque linkedBlockingDeque) {
        this.this$0 = linkedBlockingDeque;
        this.advance();
    }

    abstract void advance() {
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public Object next() {
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        this.lastRet = this.next;
        Object object = this.nextItem;
        this.advance();
        return object;
    }

    @Override
    public void remove() {
        LinkedBlockingDeque$Node linkedBlockingDeque$Node = this.lastRet;
        if (linkedBlockingDeque$Node == null) {
            throw new IllegalStateException();
        }
        this.lastRet = null;
        this.this$0.removeNode(linkedBlockingDeque$Node);
    }
}

