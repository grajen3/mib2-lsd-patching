/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import java.util.Iterator;
import java.util.Set;

public interface ObjectIntMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(Object object) {
    }

    default public boolean containsValue(int n) {
    }

    default public int get(Object object) {
    }

    default public int put(Object object, int n) {
    }

    default public int remove(Object object) {
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

    default public IntCollection values() {
    }

    default public IntIterator valueIterator() {
    }

    default public int replaceKey(Object object, Object object2) {
    }

    default public Object replaceOneValue(int n, int n2) {
    }

    default public Object getOneKeyByValue(int n) {
    }

    default public int[] valuesToArray() {
    }

    default public int[] valuesToArray(int[] nArray) {
    }

    default public Object[] keysToArray() {
    }

    default public Object[] keysToArray(Object[] objectArray) {
    }

    default public ObjectIntMap synchronize() {
    }

    default public void putAll(ObjectIntMap objectIntMap) {
    }
}

