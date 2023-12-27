/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyCollection;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import de.vw.mib.collections.ints.IntReadOnlySet;
import de.vw.mib.collections.ints.IntSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class IntObjectReadOnlyMap
implements IntObjectMap {
    public static final IntObjectMap EMPTY_READONLY_MAP = new IntObjectReadOnlyMap(new IntObjectOptHashMap(0));
    private final IntObjectMap backing;

    public IntObjectReadOnlyMap(IntObjectMap intObjectMap) {
        this.backing = intObjectMap;
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
    public boolean containsValue(Object object) {
        return this.backing.containsValue(object);
    }

    @Override
    public Object get(int n) {
        return this.backing.get(n);
    }

    @Override
    public Object put(int n, Object object) {
        throw this.writeError();
    }

    @Override
    public Object remove(int n) {
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
    public Collection values() {
        return new ObjectReadOnlyCollection((ObjectCollection)this.backing.values());
    }

    @Override
    public Iterator valueIterator() {
        return new ObjectReadOnlyIterator((ObjectIterator)this.backing.valueIterator());
    }

    @Override
    public Object replaceKey(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int replaceOneValue(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public int getOneKeyByValue(Object object) {
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
    public int[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public int[] keysToArray(int[] nArray) {
        return this.backing.keysToArray(nArray);
    }

    @Override
    public IntObjectMap synchronize() {
        return new IntObjectReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(IntObjectMap intObjectMap) {
        throw this.writeError();
    }
}

