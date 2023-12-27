/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

final class ConcurrentHashMap$HashEntry {
    final Object key;
    final int hash;
    volatile Object value;
    final ConcurrentHashMap$HashEntry next;

    ConcurrentHashMap$HashEntry(Object object, int n, ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry, Object object2) {
        this.key = object;
        this.hash = n;
        this.next = concurrentHashMap$HashEntry;
        this.value = object2;
    }

    static final ConcurrentHashMap$HashEntry[] newArray(int n) {
        return new ConcurrentHashMap$HashEntry[n];
    }
}

