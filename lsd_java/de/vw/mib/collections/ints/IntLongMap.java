/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import java.util.Iterator;
import java.util.Set;

public interface IntLongMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(int n) {
    }

    default public boolean containsValue(long l) {
    }

    default public long get(int n) {
    }

    default public long put(int n, long l) {
    }

    default public long remove(int n) {
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

    default public LongCollection values() {
    }

    default public LongIterator valueIterator() {
    }

    default public long replaceKey(int n, int n2) {
    }

    default public int replaceOneValue(long l, long l2) {
    }

    default public int getOneKeyByValue(long l) {
    }

    default public long[] valuesToArray() {
    }

    default public long[] valuesToArray(long[] lArray) {
    }

    default public int[] keysToArray() {
    }

    default public int[] keysToArray(int[] nArray) {
    }

    default public IntLongMap synchronize() {
    }

    default public void putAll(IntLongMap intLongMap) {
    }
}

