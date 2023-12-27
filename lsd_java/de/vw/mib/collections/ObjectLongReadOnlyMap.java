/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectLongMap;
import de.vw.mib.collections.ObjectLongOptHashMap;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import de.vw.mib.collections.ObjectReadOnlySet;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyCollection;
import de.vw.mib.collections.longs.LongReadOnlyIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class ObjectLongReadOnlyMap
implements ObjectLongMap {
    public static final ObjectLongMap EMPTY_READONLY_MAP = new ObjectLongReadOnlyMap(new ObjectLongOptHashMap(0));
    private final ObjectLongMap backing;

    public ObjectLongReadOnlyMap(ObjectLongMap objectLongMap) {
        this.backing = objectLongMap;
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
    public boolean containsKey(Object object) {
        return this.backing.containsKey(object);
    }

    @Override
    public boolean containsValue(long l) {
        return this.backing.containsValue(l);
    }

    @Override
    public long get(Object object) {
        return this.backing.get(object);
    }

    @Override
    public long put(Object object, long l) {
        throw this.writeError();
    }

    @Override
    public long remove(Object object) {
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
    public Iterator keyIterator() {
        return new ObjectReadOnlyIterator((ObjectIterator)this.backing.keyIterator());
    }

    @Override
    public Set keySet() {
        return new ObjectReadOnlySet((ObjectSet)this.backing.keySet());
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
    public long replaceKey(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public Object replaceOneValue(long l, long l2) {
        throw this.writeError();
    }

    @Override
    public Object getOneKeyByValue(long l) {
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
    public Object[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public Object[] keysToArray(Object[] objectArray) {
        return this.backing.keysToArray(objectArray);
    }

    @Override
    public ObjectLongMap synchronize() {
        return new ObjectLongReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(ObjectLongMap objectLongMap) {
        throw this.writeError();
    }
}

