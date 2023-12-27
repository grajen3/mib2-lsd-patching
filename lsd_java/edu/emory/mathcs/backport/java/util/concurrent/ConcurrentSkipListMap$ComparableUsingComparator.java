/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.util.Comparator;

final class ConcurrentSkipListMap$ComparableUsingComparator
implements Comparable {
    final Object actualKey;
    final Comparator cmp;

    ConcurrentSkipListMap$ComparableUsingComparator(Object object, Comparator comparator) {
        this.actualKey = object;
        this.cmp = comparator;
    }

    @Override
    public int compareTo(Object object) {
        return this.cmp.compare(this.actualKey, object);
    }
}

