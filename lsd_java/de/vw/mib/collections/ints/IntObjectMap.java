/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface IntObjectMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(int n) {
    }

    default public boolean containsValue(Object object) {
    }

    default public Object get(int n) {
    }

    default public Object put(int n, Object object) {
    }

    default public Object remove(int n) {
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

    default public Collection values() {
    }

    default public Iterator valueIterator() {
    }

    default public Object replaceKey(int n, int n2) {
    }

    default public int replaceOneValue(Object object, Object object2) {
    }

    default public int getOneKeyByValue(Object object) {
    }

    default public Object[] valuesToArray() {
    }

    default public Object[] valuesToArray(Object[] objectArray) {
    }

    default public int[] keysToArray() {
    }

    default public int[] keysToArray(int[] nArray) {
    }

    default public IntObjectMap synchronize() {
    }

    default public void putAll(IntObjectMap intObjectMap) {
    }
}

