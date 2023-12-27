/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import java.util.Iterator;
import java.util.Set;

public interface IntIntMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(int n) {
    }

    default public boolean containsValue(int n) {
    }

    default public int get(int n) {
    }

    default public int put(int n, int n2) {
    }

    default public int remove(int n) {
    }

    default public void clear() {
    }

    default public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
    }

    default public Iterator entryIterator() {
    }

    default public Set entrySet() {
    }

    default public IntIterator keyIterator() {
    }

    default public IntSet keySet() {
    }

    default public IntCollection values() {
    }

    default public IntIterator valueIterator() {
    }

    default public int replaceKey(int n, int n2) {
    }

    default public int replaceOneValue(int n, int n2) {
    }

    default public int getOneKeyByValue(int n) {
    }

    default public int[] valuesToArray() {
    }

    default public int[] valuesToArray(int[] nArray) {
    }

    default public int[] keysToArray() {
    }

    default public int[] keysToArray(int[] nArray) {
    }

    default public IntIntMap synchronize() {
    }

    default public void putAll(IntIntMap intIntMap) {
    }
}

