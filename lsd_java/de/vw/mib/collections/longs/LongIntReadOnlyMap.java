/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyCollection;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyIterator;
import de.vw.mib.collections.longs.LongReadOnlySet;
import de.vw.mib.collections.longs.LongSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class LongIntReadOnlyMap
implements LongIntMap {
    public static final LongIntMap EMPTY_READONLY_MAP = new LongIntReadOnlyMap(new LongIntOptHashMap(0));
    private final LongIntMap backing;

    public LongIntReadOnlyMap(LongIntMap longIntMap) {
        this.backing = longIntMap;
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
    public boolean containsKey(long l) {
        return this.backing.containsKey(l);
    }

    @Override
    public boolean containsValue(int n) {
        return this.backing.containsValue(n);
    }

    @Override
    public int get(long l) {
        return this.backing.get(l);
    }

    @Override
    public int put(long l, int n) {
        throw this.writeError();
    }

    @Override
    public int remove(long l) {
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
    public LongIterator keyIterator() {
        return new LongReadOnlyIterator(this.backing.keyIterator());
    }

    @Override
    public LongSet keySet() {
        return new LongReadOnlySet(this.backing.keySet());
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
    public int replaceKey(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public long replaceOneValue(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public long getOneKeyByValue(int n) {
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
    public long[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public long[] keysToArray(long[] lArray) {
        return this.backing.keysToArray(lArray);
    }

    @Override
    public LongIntMap synchronize() {
        return new LongIntReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(LongIntMap longIntMap) {
        throw this.writeError();
    }
}

