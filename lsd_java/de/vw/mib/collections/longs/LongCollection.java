/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongIterator;

public interface LongCollection {
    default public boolean add(long l) {
    }

    default public void clear() {
    }

    default public boolean contains(long l) {
    }

    default public boolean isEmpty() {
    }

    default public LongIterator iterator() {
    }

    default public boolean remove(long l) {
    }

    default public int size() {
    }

    default public boolean addAll(LongCollection longCollection) {
    }

    default public boolean containsAll(LongCollection longCollection) {
    }

    default public boolean removeAll(LongCollection longCollection) {
    }

    default public boolean retainAll(LongCollection longCollection) {
    }

    default public long[] toArray() {
    }

    default public long[] toArray(long[] lArray) {
    }
}

