/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import de.vw.mib.collections.ints.IntReadOnlySet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyCollection;
import de.vw.mib.collections.longs.LongReadOnlyIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class IntLongReadOnlyMap
implements IntLongMap {
    public static final IntLongMap EMPTY_READONLY_MAP = new IntLongReadOnlyMap(new IntLongOptHashMap(0));
    private final IntLongMap backing;

    public IntLongReadOnlyMap(IntLongMap intLongMap) {
        this.backing = intLongMap;
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
    public boolean containsValue(long l) {
        return this.backing.containsValue(l);
    }

    @Override
    public long get(int n) {
        return this.backing.get(n);
    }

    @Override
    public long put(int n, long l) {
        throw this.writeError();
    }

    @Override
    public long remove(int n) {
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
    public LongCollection values() {
        return new LongReadOnlyCollection(this.backing.values());
    }

    @Override
    public LongIterator valueIterator() {
        return new LongReadOnlyIterator(this.backing.valueIterator());
    }

    @Override
    public long replaceKey(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int replaceOneValue(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public int getOneKeyByValue(long l) {
        return this.backing.getOneKeyByValue(l);
    }

    @Override
    public long[] valuesToArray() {
        return this.backing.valuesToArray();
    }

    @Override
    public long[] valuesToArray(long[] lArray) {
        return this.backing.valuesToArray(lArray);
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
    public IntLongMap synchronize() {
        return new IntLongReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(IntLongMap intLongMap) {
        throw this.writeError();
    }
}

