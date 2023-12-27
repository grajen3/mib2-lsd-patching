/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.multi;

public class LinkedElementList$LinkedElement {
    protected Object payload;
    protected LinkedElementList$LinkedElement prev;
    protected LinkedElementList$LinkedElement next;

    protected LinkedElementList$LinkedElement() {
        this.payload = null;
        this.prev = null;
        this.next = null;
    }

    protected LinkedElementList$LinkedElement(Object object) {
        this.payload = object;
        this.prev = null;
        this.next = null;
    }
}

