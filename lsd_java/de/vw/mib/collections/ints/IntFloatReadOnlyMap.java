/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.floats.FloatReadOnlyCollection;
import de.vw.mib.collections.floats.FloatReadOnlyIterator;
import de.vw.mib.collections.ints.IntFloatMap;
import de.vw.mib.collections.ints.IntFloatOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import de.vw.mib.collections.ints.IntReadOnlySet;
import de.vw.mib.collections.ints.IntSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class IntFloatReadOnlyMap
implements IntFloatMap {
    public static final IntFloatMap EMPTY_READONLY_MAP = new IntFloatReadOnlyMap(new IntFloatOptHashMap(0));
    private final IntFloatMap backing;

    public IntFloatReadOnlyMap(IntFloatMap intFloatMap) {
        this.backing = intFloatMap;
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public boolean containsKey(int n) {
        return this.backing.containsKey(n);
    }

    @Override
    public boolean containsValue(float f2) {
        return this.backing.containsValue(f2);
    }

    @Override
    public float get(int n) {
        return this.backing.get(n);
    }

    @Override
    public float put(int n, float f2) {
        throw this.writeError();
    }

    @Override
    public float remove(int n) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
        throw this.writeError();
    }

    @Override
    public Iterator entryIterator() {
        return new ReadOnlyIterator(this.backing.entryIterator());
    }

    @Override
    public Set entrySet() {
        return Collections.unmodifiableSet(this.backing.entrySet());
    }

    @Override
    public IntIterator keyIterator() {
        return new IntReadOnlyIterator(this.backing.keyIterator());
    }

    @Override
    public IntSet keySet() {
        return new IntReadOnlySet(this.backing.keySet());
    }

    @Override
    public FloatCollection values() {
        return new FloatReadOnlyCollection(this.backing.values());
    }

    @Override
    public FloatIterator valueIterator() {
        return new FloatReadOnlyIterator(this.backing.valueIterator());
    }

    @Override
    public float replaceKey(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int replaceOneValue(float f2, float f3) {
        throw this.writeError();
    }

    @Override
    public int getOneKeyByValue(float f2) {
        return this.backing.getOneKeyByValue(f2);
    }

    @Override
    public float[] valuesToArray() {
        return this.backing.valuesToArray();
    }

    @Override
    public float[] valuesToArray(float[] fArray) {
        return this.backing.valuesToArray(fArray);
    }

    @Override
    public int[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public int[] keysToArray(int[] nArray) {
        return this.backing.keysToArray(nArray);
    }

    @Override
    public IntFloatMap synchronize() {
        return new IntFloatReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(IntFloatMap intFloatMap) {
        throw this.writeError();
    }
}

