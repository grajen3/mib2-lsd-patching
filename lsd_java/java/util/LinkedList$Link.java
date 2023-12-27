/*
 * Decompiled with CFR 0.152.
 */
package java.util;

final class LinkedList$Link {
    Object data;
    LinkedList$Link previous;
    LinkedList$Link next;

    LinkedList$Link(Object object, LinkedList$Link linkedList$Link, LinkedList$Link linkedList$Link2) {
        this.data = object;
        this.previous = linkedList$Link;
        this.next = linkedList$Link2;
    }
}

