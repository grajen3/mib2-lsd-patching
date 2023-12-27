/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import de.vw.mib.collections.ObjectReadOnlySet;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyCollection;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class ObjectIntReadOnlyMap
implements ObjectIntMap {
    public static final ObjectIntMap EMPTY_READONLY_MAP = new ObjectIntReadOnlyMap(new ObjectIntOptHashMap(0));
    private final ObjectIntMap backing;

    public ObjectIntReadOnlyMap(ObjectIntMap objectIntMap) {
        this.backing = objectIntMap;
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
    public boolean containsValue(int n) {
        return this.backing.containsValue(n);
    }

    @Override
    public int get(Object object) {
        return this.backing.get(object);
    }

    @Override
    public int put(Object object, int n) {
        throw this.writeError();
    }

    @Override
    public int remove(Object object) {
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
    public IntCollection values() {
        return new IntReadOnlyCollection(this.backing.values());
    }

    @Override
    public IntIterator valueIterator() {
        return new IntReadOnlyIterator(this.backing.valueIterator());
    }

    @Override
    public int replaceKey(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public Object replaceOneValue(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public Object getOneKeyByValue(int n) {
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
    public Object[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public Object[] keysToArray(Object[] objectArray) {
        return this.backing.keysToArray(objectArray);
    }

    @Override
    public ObjectIntMap synchronize() {
        return new ObjectIntReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(ObjectIntMap objectIntMap) {
        throw this.writeError();
    }
}

