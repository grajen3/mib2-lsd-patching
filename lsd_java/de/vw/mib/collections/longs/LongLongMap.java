/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongSet;
import java.util.Iterator;
import java.util.Set;

public interface LongLongMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(long l) {
    }

    default public boolean containsValue(long l) {
    }

    default public long get(long l) {
    }

    default public long put(long l, long l2) {
    }

    default public long remove(long l) {
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

    default public LongCollection values() {
    }

    default public LongIterator valueIterator() {
    }

    default public long replaceKey(long l, long l2) {
    }

    default public long replaceOneValue(long l, long l2) {
    }

    default public long getOneKeyByValue(long l) {
    }

    default public long[] valuesToArray() {
    }

    default public long[] valuesToArray(long[] lArray) {
    }

    default public long[] keysToArray() {
    }

    default public long[] keysToArray(long[] lArray) {
    }

    default public LongLongMap synchronize() {
    }

    default public void putAll(LongLongMap longLongMap) {
    }
}

