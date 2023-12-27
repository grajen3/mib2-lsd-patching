/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongLongMap;
import de.vw.mib.collections.longs.LongLongOptHashMap;
import de.vw.mib.collections.longs.LongReadOnlyCollection;
import de.vw.mib.collections.longs.LongReadOnlyIterator;
import de.vw.mib.collections.longs.LongReadOnlySet;
import de.vw.mib.collections.longs.LongSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class LongLongReadOnlyMap
implements LongLongMap {
    public static final LongLongMap EMPTY_READONLY_MAP = new LongLongReadOnlyMap(new LongLongOptHashMap(0));
    private final LongLongMap backing;

    public LongLongReadOnlyMap(LongLongMap longLongMap) {
        this.backing = longLongMap;
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
    public boolean containsValue(long l) {
        return this.backing.containsValue(l);
    }

    @Override
    public long get(long l) {
        return this.backing.get(l);
    }

    @Override
    public long put(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public long remove(long l) {
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
    public LongCollection values() {
        return new LongReadOnlyCollection(this.backing.values());
    }

    @Override
    public LongIterator valueIterator() {
        return new LongReadOnlyIterator(this.backing.valueIterator());
    }

    @Override
    public long replaceKey(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public long replaceOneValue(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public long getOneKeyByValue(long l) {
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
    public long[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public long[] keysToArray(long[] lArray) {
        return this.backing.keysToArray(lArray);
    }

    @Override
    public LongLongMap synchronize() {
        return new LongLongReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(LongLongMap longLongMap) {
        throw this.writeError();
    }
}

