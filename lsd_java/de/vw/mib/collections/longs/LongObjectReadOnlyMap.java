/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyCollection;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongReadOnlyIterator;
import de.vw.mib.collections.longs.LongReadOnlySet;
import de.vw.mib.collections.longs.LongSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class LongObjectReadOnlyMap
implements LongObjectMap {
    public static final LongObjectMap EMPTY_READONLY_MAP = new LongObjectReadOnlyMap(new LongObjectOptHashMap(0));
    private final LongObjectMap backing;

    public LongObjectReadOnlyMap(LongObjectMap longObjectMap) {
        this.backing = longObjectMap;
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
    public boolean containsValue(Object object) {
        return this.backing.containsValue(object);
    }

    @Override
    public Object get(long l) {
        return this.backing.get(l);
    }

    @Override
    public Object put(long l, Object object) {
        throw this.writeError();
    }

    @Override
    public Object remove(long l) {
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
    public Collection values() {
        return new ObjectReadOnlyCollection((ObjectCollection)this.backing.values());
    }

    @Override
    public Iterator valueIterator() {
        return new ObjectReadOnlyIterator((ObjectIterator)this.backing.valueIterator());
    }

    @Override
    public Object replaceKey(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public long replaceOneValue(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public long getOneKeyByValue(Object object) {
        return this.backing.getOneKeyByValue(object);
    }

    @Override
    public Object[] valuesToArray() {
        return this.backing.valuesToArray();
    }

    @Override
    public Object[] valuesToArray(Object[] objectArray) {
        return this.backing.valuesToArray(objectArray);
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
    public LongObjectMap synchronize() {
        return new LongObjectReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(LongObjectMap longObjectMap) {
        throw this.writeError();
    }
}

