/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

import de.vw.mib.collections.multi.LinkedElementList$LinkedElement;

public class LinkedElementList {
    protected LinkedElementList$LinkedElement first;
    protected LinkedElementList$LinkedElement last;
    protected int size;

    public LinkedElementList() {
        this.clear();
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(Object object) {
        this.add(new LinkedElementList$LinkedElement(object));
    }

    protected void add(LinkedElementList$LinkedElement linkedElementList$LinkedElement) {
        if (this.isEmpty()) {
            this.first = linkedElementList$LinkedElement;
            this.last = linkedElementList$LinkedElement;
        } else {
            this.last.next = linkedElementList$LinkedElement;
            linkedElementList$LinkedElement.prev = this.last;
            this.last = linkedElementList$LinkedElement;
        }
        ++this.size;
    }

    protected LinkedElementList$LinkedElement getLast() {
        return this.last;
    }

    protected LinkedElementList$LinkedElement getFirst() {
        return this.first;
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Object removeLast() {
        Object object = this.last.payload;
        if (this.size == 1) {
            this.clear();
        } else {
            this.last.prev.next = null;
            this.last.prev = null;
            --this.size;
        }
        return object;
    }

    public Object removeFirst() {
        Object object = this.first.payload;
        if (this.size == 1) {
            this.clear();
        } else {
            this.first.next.prev = null;
            this.first.next = null;
            --this.size;
        }
        return object;
    }

    protected void remove(LinkedElementList$LinkedElement linkedElementList$LinkedElement) {
        if (linkedElementList$LinkedElement == this.first) {
            this.removeFirst();
        } else if (linkedElementList$LinkedElement == this.last) {
            this.removeLast();
        } else {
            linkedElementList$LinkedElement.prev.next = linkedElementList$LinkedElement.next;
            linkedElementList$LinkedElement.next.prev = linkedElementList$LinkedElement.prev;
            linkedElementList$LinkedElement.next = null;
            linkedElementList$LinkedElement.prev = null;
            --this.size;
        }
    }
}

