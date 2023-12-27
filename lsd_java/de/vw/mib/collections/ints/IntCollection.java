/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntIterator;

public interface IntCollection {
    default public boolean add(int n) {
    }

    default public void clear() {
    }

    default public boolean contains(int n) {
    }

    default public boolean isEmpty() {
    }

    default public IntIterator iterator() {
    }

    default public boolean remove(int n) {
    }

    default public int size() {
    }

    default public boolean addAll(IntCollection intCollection) {
    }

    default public boolean containsAll(IntCollection intCollection) {
    }

    default public boolean removeAll(IntCollection intCollection) {
    }

    default public boolean retainAll(IntCollection intCollection) {
    }

    default public int[] toArray() {
    }

    default public int[] toArray(int[] nArray) {
    }
}

