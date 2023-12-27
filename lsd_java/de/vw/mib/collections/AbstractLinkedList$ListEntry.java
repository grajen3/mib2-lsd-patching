/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.util.StringBuilder;

public abstract class AbstractLinkedList$ListEntry {
    public AbstractLinkedList$ListEntry next;
    public AbstractLinkedList$ListEntry previous;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[next=").append(this.next);
        stringBuilder.append(",previous=").append(this.previous);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final AbstractLinkedList$ListEntry next() {
        return this.next;
    }

    public final AbstractLinkedList$ListEntry previous() {
        return this.previous;
    }

    public final boolean isFirst() {
        return this.previous == null;
    }

    public final boolean isLast() {
        return this.next == null;
    }
}

