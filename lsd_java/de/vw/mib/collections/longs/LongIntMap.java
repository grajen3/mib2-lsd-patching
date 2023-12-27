/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongSet;
import java.util.Iterator;
import java.util.Set;

public interface LongIntMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(long l) {
    }

    default public boolean containsValue(int n) {
    }

    default public int get(long l) {
    }

    default public int put(long l, int n) {
    }

    default public int remove(long l) {
    }

    default public void clear() {
    }

    default public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
    }

    default public Iterator entryIterator() {
    }

    default public Set entrySet() {
    }

    default public LongIterator keyIterator() {
    }

    default public LongSet keySet() {
    }

    default public IntCollection values() {
    }

    default public IntIterator valueIterator() {
    }

    default public int replaceKey(long l, long l2) {
    }

    default public long replaceOneValue(int n, int n2) {
    }

    default public long getOneKeyByValue(int n) {
    }

    default public int[] valuesToArray() {
    }

    default public int[] valuesToArray(int[] nArray) {
    }

    default public long[] keysToArray() {
    }

    default public long[] keysToArray(long[] lArray) {
    }

    default public LongIntMap synchronize() {
    }

    default public void putAll(LongIntMap longIntMap) {
    }
}

