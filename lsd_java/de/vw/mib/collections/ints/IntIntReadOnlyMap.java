/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyCollection;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import de.vw.mib.collections.ints.IntReadOnlySet;
import de.vw.mib.collections.ints.IntSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class IntIntReadOnlyMap
implements IntIntMap {
    public static final IntIntMap EMPTY_READONLY_MAP = new IntIntReadOnlyMap(new IntIntOptHashMap(0));
    private final IntIntMap backing;

    public IntIntReadOnlyMap(IntIntMap intIntMap) {
        this.backing = intIntMap;
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
    public boolean containsValue(int n) {
        return this.backing.containsValue(n);
    }

    @Override
    public int get(int n) {
        return this.backing.get(n);
    }

    @Override
    public int put(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int remove(int n) {
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
    public IntCollection values() {
        return new IntReadOnlyCollection(this.backing.values());
    }

    @Override
    public IntIterator valueIterator() {
        return new IntReadOnlyIterator(this.backing.valueIterator());
    }

    @Override
    public int replaceKey(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int replaceOneValue(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int getOneKeyByValue(int n) {
        return this.backing.getOneKeyByValue(n);
    }

    @Override
    public int[] valuesToArray() {
        return this.backing.valuesToArray();
    }

    @Override
    public int[] valuesToArray(int[] nArray) {
        return this.backing.valuesToArray(nArray);
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
    public IntIntMap synchronize() {
        return new IntIntReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(IntIntMap intIntMap) {
        throw this.writeError();
    }
}

