/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import java.util.Iterator;
import java.util.Set;

public interface IntFloatMap {
    default public int size() {
    }

    default public boolean isEmpty() {
    }

    default public boolean containsKey(int n) {
    }

    default public boolean containsValue(float f2) {
    }

    default public float get(int n) {
    }

    default public float put(int n, float f2) {
    }

    default public float remove(int n) {
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

    default public FloatCollection values() {
    }

    default public FloatIterator valueIterator() {
    }

    default public float replaceKey(int n, int n2) {
    }

    default public int replaceOneValue(float f2, float f3) {
    }

    default public int getOneKeyByValue(float f2) {
    }

    default public float[] valuesToArray() {
    }

    default public float[] valuesToArray(float[] fArray) {
    }

    default public int[] keysToArray() {
    }

    default public int[] keysToArray(int[] nArray) {
    }

    default public IntFloatMap synchronize() {
    }

    default public void putAll(IntFloatMap intFloatMap) {
    }
}

