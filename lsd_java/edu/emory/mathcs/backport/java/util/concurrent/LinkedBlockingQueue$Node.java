/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

class LinkedBlockingQueue$Node {
    volatile Object item;
    LinkedBlockingQueue$Node next;

    LinkedBlockingQueue$Node(Object object) {
        this.item = object;
    }
}

