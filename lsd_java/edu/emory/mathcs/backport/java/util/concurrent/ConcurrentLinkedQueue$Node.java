/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

class ConcurrentLinkedQueue$Node {
    private volatile Object item;
    private volatile ConcurrentLinkedQueue$Node next;

    ConcurrentLinkedQueue$Node(Object object) {
        this.item = object;
    }

    ConcurrentLinkedQueue$Node(Object object, ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node) {
        this.item = object;
        this.next = concurrentLinkedQueue$Node;
    }

    Object getItem() {
        return this.item;
    }

    synchronized boolean casItem(Object object, Object object2) {
        if (this.item == object) {
            this.item = object2;
            return true;
        }
        return false;
    }

    synchronized void setItem(Object object) {
        this.item = object;
    }

    ConcurrentLinkedQueue$Node getNext() {
        return this.next;
    }

    synchronized boolean casNext(ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node, ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node2) {
        if (this.next == concurrentLinkedQueue$Node) {
            this.next = concurrentLinkedQueue$Node2;
            return true;
        }
        return false;
    }

    synchronized void setNext(ConcurrentLinkedQueue$Node concurrentLinkedQueue$Node) {
        this.next = concurrentLinkedQueue$Node;
    }
}

