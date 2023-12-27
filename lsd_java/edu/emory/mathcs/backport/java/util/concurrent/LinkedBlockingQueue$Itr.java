/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue$Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedBlockingQueue$Itr
implements Iterator {
    private LinkedBlockingQueue$Node current;
    private LinkedBlockingQueue$Node lastRet;
    private Object currentElement;
    private final /* synthetic */ LinkedBlockingQueue this$0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    LinkedBlockingQueue$Itr(LinkedBlockingQueue linkedBlockingQueue) {
        this.this$0 = linkedBlockingQueue;
        Object object = LinkedBlockingQueue.access$100(linkedBlockingQueue);
        synchronized (object) {
            Object object2 = LinkedBlockingQueue.access$200(linkedBlockingQueue);
            synchronized (object2) {
                this.current = LinkedBlockingQueue.access$300((LinkedBlockingQueue)linkedBlockingQueue).next;
                if (this.current != null) {
                    this.currentElement = this.current.item;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object next() {
        Object object = LinkedBlockingQueue.access$100(this.this$0);
        synchronized (object) {
            Object object2 = LinkedBlockingQueue.access$200(this.this$0);
            synchronized (object2) {
                if (this.current == null) {
                    throw new NoSuchElementException();
                }
                Object object3 = this.currentElement;
                this.lastRet = this.current;
                this.current = this.current.next;
                if (this.current != null) {
                    this.currentElement = this.current.item;
                }
                return object3;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove() {
        if (this.lastRet == null) {
            throw new IllegalStateException();
        }
        Object object = LinkedBlockingQueue.access$100(this.this$0);
        synchronized (object) {
            Object object2 = LinkedBlockingQueue.access$200(this.this$0);
            synchronized (object2) {
                LinkedBlockingQueue$Node linkedBlockingQueue$Node = this.lastRet;
                this.lastRet = null;
                LinkedBlockingQueue$Node linkedBlockingQueue$Node2 = LinkedBlockingQueue.access$300(this.this$0);
                LinkedBlockingQueue$Node linkedBlockingQueue$Node3 = LinkedBlockingQueue.access$300((LinkedBlockingQueue)this.this$0).next;
                while (linkedBlockingQueue$Node3 != null && linkedBlockingQueue$Node3 != linkedBlockingQueue$Node) {
                    linkedBlockingQueue$Node2 = linkedBlockingQueue$Node3;
                    linkedBlockingQueue$Node3 = linkedBlockingQueue$Node3.next;
                }
                if (linkedBlockingQueue$Node3 == linkedBlockingQueue$Node) {
                    int n;
                    linkedBlockingQueue$Node3.item = null;
                    linkedBlockingQueue$Node2.next = linkedBlockingQueue$Node3.next;
                    if (LinkedBlockingQueue.access$400(this.this$0) == linkedBlockingQueue$Node3) {
                        LinkedBlockingQueue.access$402(this.this$0, linkedBlockingQueue$Node2);
                    }
                    LinkedBlockingQueue$Itr linkedBlockingQueue$Itr = this;
                    synchronized (linkedBlockingQueue$Itr) {
                        n = LinkedBlockingQueue.access$510(this.this$0);
                    }
                    if (n == LinkedBlockingQueue.access$600(this.this$0)) {
                        LinkedBlockingQueue.access$100(this.this$0).notifyAll();
                    }
                }
            }
        }
    }
}

