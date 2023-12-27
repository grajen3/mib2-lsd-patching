/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import java.util.Iterator;
import java.util.Set;

public interface IntBooleanMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(int n) {
    }

    default public boolean containsValue(boolean bl) {
    }

    default public boolean get(int n) {
    }

    default public boolean put(int n, boolean bl) {
    }

    default public boolean remove(int n) {
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

    default public BooleanCollection values() {
    }

    default public BooleanIterator valueIterator() {
    }

    default public boolean replaceKey(int n, int n2) {
    }

    default public int replaceOneValue(boolean bl, boolean bl2) {
    }

    default public int getOneKeyByValue(boolean bl) {
    }

    default public boolean[] valuesToArray() {
    }

    default public boolean[] valuesToArray(boolean[] blArray) {
    }

    default public int[] keysToArray() {
    }

    default public int[] keysToArray(int[] nArray) {
    }

    default public IntBooleanMap synchronize() {
    }

    default public void putAll(IntBooleanMap intBooleanMap) {
    }
}

