/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

abstract class AbstractASLList$AbstractAction {
    AbstractASLList$AbstractAction next;
    protected int index;
    protected Object[] items;
    protected int count;

    protected AbstractASLList$AbstractAction() {
    }

    protected AbstractASLList$AbstractAction init(int n, Object[] objectArray, int n2) {
        this.next = null;
        this.index = n;
        this.items = objectArray;
        this.count = n2;
        return this;
    }

    protected abstract String getName() {
    }

    protected abstract void execute() {
    }

    protected void clear() {
        this.items = null;
    }

    protected void release() {
    }
}

