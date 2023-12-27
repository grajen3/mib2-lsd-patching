/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import java.util.Iterator;
import java.util.Set;

public interface ObjectLongMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(Object object) {
    }

    default public boolean containsValue(long l) {
    }

    default public long get(Object object) {
    }

    default public long put(Object object, long l) {
    }

    default public long remove(Object object) {
    }

    default public void clear() {
    }

    default public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
    }

    default public Iterator entryIterator() {
    }

    default public Set entrySet() {
    }

    default public Iterator keyIterator() {
    }

    default public Set keySet() {
    }

    default public LongCollection values() {
    }

    default public LongIterator valueIterator() {
    }

    default public long replaceKey(Object object, Object object2) {
    }

    default public Object replaceOneValue(long l, long l2) {
    }

    default public Object getOneKeyByValue(long l) {
    }

    default public long[] valuesToArray() {
    }

    default public long[] valuesToArray(long[] lArray) {
    }

    default public Object[] keysToArray() {
    }

    default public Object[] keysToArray(Object[] objectArray) {
    }

    default public ObjectLongMap synchronize() {
    }

    default public void putAll(ObjectLongMap objectLongMap) {
    }
}

