/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentLinkedQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentLinkedQueue$Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ConcurrentLinkedQueue$Itr
implements Iterator {
    private ConcurrentLinkedQueue$Node nextNode;
    private Object nextItem;
    private ConcurrentLinkedQueue$Node lastRet;
    private final /* synthetic */ ConcurrentLinkedQueue this$0;

    ConcurrentLinkedQueue$Itr(ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.this$0 = concurrentLinkedQueue;
        this.advance();
    }

    private Object advance() {
        ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node;
        this.lastRet = this.nextNode;
        Object object = this.nextItem;
        ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node2 = concurrentLinkedQueue$Node = this.nextNode == null ? this.this$0.first() : this.nextNode.getNext();
        while (true) {
            if (concurrentLinkedQueue$Node == null) {
                this.nextNode = null;
                this.nextItem = null;
                return object;
            }
            Object object2 = concurrentLinkedQueue$Node.getItem();
            if (object2 != null) {
                this.nextNode = concurrentLinkedQueue$Node;
                this.nextItem = object2;
                return object;
            }
            concurrentLinkedQueue$Node = concurrentLinkedQueue$Node.getNext();
        }
    }

    @Override
    public boolean hasNext() {
        return this.nextNode != null;
    }

    @Override
    public Object next() {
        if (this.nextNode == null) {
            throw new NoSuchElementException();
        }
        return this.advance();
    }

    @Override
    public void remove() {
        ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node = this.lastRet;
        if (concurrentLinkedQueue$Node == null) {
            throw new IllegalStateException();
        }
        concurrentLinkedQueue$Node.setItem(null);
        this.lastRet = null;
    }
}

