/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

final class LinkedBlockingDeque$Node {
    Object item;
    LinkedBlockingDeque$Node prev;
    LinkedBlockingDeque$Node next;

    LinkedBlockingDeque$Node(Object object, LinkedBlockingDeque$Node linkedBlockingDeque$Node, LinkedBlockingDeque$Node linkedBlockingDeque$Node2) {
        this.item = object;
        this.prev = linkedBlockingDeque$Node;
        this.next = linkedBlockingDeque$Node2;
    }
}

