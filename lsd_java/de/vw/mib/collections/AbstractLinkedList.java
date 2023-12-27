/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.AbstractLinkedList$ListEntry;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractLinkedList {
    private AbstractLinkedList$ListEntry first;
    private AbstractLinkedList$ListEntry last;
    private int size;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[first=").append(this.first);
        stringBuilder.append(",last=").append(this.last);
        stringBuilder.append(",size=").append(this.size);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public final int size() {
        return this.size;
    }

    public final AbstractLinkedList$ListEntry getFirst() {
        return this.first;
    }

    public final AbstractLinkedList$ListEntry getLast() {
        return this.last;
    }

    public final void addFirst(AbstractLinkedList$ListEntry abstractLinkedList$ListEntry) {
        if (this.first != null) {
            this.first.previous = abstractLinkedList$ListEntry;
        } else {
            this.last = abstractLinkedList$ListEntry;
        }
        abstractLinkedList$ListEntry.previous = null;
        abstractLinkedList$ListEntry.next = this.first;
        this.first = abstractLinkedList$ListEntry;
        ++this.size;
    }

    public final void addLast(AbstractLinkedList$ListEntry abstractLinkedList$ListEntry) {
        if (this.last != null) {
            this.last.next = abstractLinkedList$ListEntry;
        } else {
            this.first = abstractLinkedList$ListEntry;
        }
        abstractLinkedList$ListEntry.next = null;
        abstractLinkedList$ListEntry.previous = this.last;
        this.last = abstractLinkedList$ListEntry;
        ++this.size;
    }

    public void add(AbstractLinkedList$ListEntry abstractLinkedList$ListEntry) {
        this.addLast(abstractLinkedList$ListEntry);
    }

    public final void insert(AbstractLinkedList$ListEntry abstractLinkedList$ListEntry, AbstractLinkedList$ListEntry abstractLinkedList$ListEntry2) {
        abstractLinkedList$ListEntry2.next = abstractLinkedList$ListEntry;
        abstractLinkedList$ListEntry2.previous = abstractLinkedList$ListEntry.previous;
        abstractLinkedList$ListEntry.previous = abstractLinkedList$ListEntry2;
        if (abstractLinkedList$ListEntry2.previous != null) {
            abstractLinkedList$ListEntry2.previous.next = abstractLinkedList$ListEntry2;
        } else {
            this.first = abstractLinkedList$ListEntry2;
        }
        ++this.size;
    }

    public final void remove(AbstractLinkedList$ListEntry abstractLinkedList$ListEntry) {
        if (abstractLinkedList$ListEntry.previous != null) {
            abstractLinkedList$ListEntry.previous.next = abstractLinkedList$ListEntry.next;
        } else {
            this.first = abstractLinkedList$ListEntry.next;
            if (this.first != null) {
                this.first.previous = null;
            }
        }
        if (abstractLinkedList$ListEntry.next != null) {
            abstractLinkedList$ListEntry.next.previous = abstractLinkedList$ListEntry.previous;
        } else {
            this.last = abstractLinkedList$ListEntry.previous;
            if (this.last != null) {
                this.last.next = null;
            }
        }
        abstractLinkedList$ListEntry.next = null;
        abstractLinkedList$ListEntry.previous = null;
        --this.size;
    }

    public final void removeFirst() {
        this.remove(this.first);
    }

    public final void removeLast() {
        this.remove(this.last);
    }

    public final AbstractLinkedList$ListEntry[] toArray() {
        AbstractLinkedList$ListEntry[] abstractLinkedList$ListEntryArray = new AbstractLinkedList$ListEntry[this.size];
        int n = 0;
        AbstractLinkedList$ListEntry abstractLinkedList$ListEntry = this.first;
        while (abstractLinkedList$ListEntry != null) {
            abstractLinkedList$ListEntryArray[n++] = abstractLinkedList$ListEntry;
            abstractLinkedList$ListEntry = abstractLinkedList$ListEntry.next;
        }
        return abstractLinkedList$ListEntryArray;
    }
}

