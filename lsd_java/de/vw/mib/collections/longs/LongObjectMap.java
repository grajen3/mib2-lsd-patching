/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface LongObjectMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(long l) {
    }

    default public boolean containsValue(Object object) {
    }

    default public Object get(long l) {
    }

    default public Object put(long l, Object object) {
    }

    default public Object remove(long l) {
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

    default public Collection values() {
    }

    default public Iterator valueIterator() {
    }

    default public Object replaceKey(long l, long l2) {
    }

    default public long replaceOneValue(Object object, Object object2) {
    }

    default public long getOneKeyByValue(Object object) {
    }

    default public Object[] valuesToArray() {
    }

    default public Object[] valuesToArray(Object[] objectArray) {
    }

    default public long[] keysToArray() {
    }

    default public long[] keysToArray(long[] lArray) {
    }

    default public LongObjectMap synchronize() {
    }

    default public void putAll(LongObjectMap longObjectMap) {
    }
}

