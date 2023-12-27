/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ReadOnlyIterator;
import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanReadOnlyCollection;
import de.vw.mib.collections.booleans.BooleanReadOnlyIterator;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyIterator;
import de.vw.mib.collections.ints.IntReadOnlySet;
import de.vw.mib.collections.ints.IntSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class IntBooleanReadOnlyMap
implements IntBooleanMap {
    public static final IntBooleanMap EMPTY_READONLY_MAP = new IntBooleanReadOnlyMap(new IntBooleanOptHashMap(0));
    private final IntBooleanMap backing;

    public IntBooleanReadOnlyMap(IntBooleanMap intBooleanMap) {
        this.backing = intBooleanMap;
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
    public boolean containsValue(boolean bl) {
        return this.backing.containsValue(bl);
    }

    @Override
    public boolean get(int n) {
        return this.backing.get(n);
    }

    @Override
    public boolean put(int n, boolean bl) {
        throw this.writeError();
    }

    @Override
    public boolean remove(int n) {
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
    public BooleanCollection values() {
        return new BooleanReadOnlyCollection(this.backing.values());
    }

    @Override
    public BooleanIterator valueIterator() {
        return new BooleanReadOnlyIterator(this.backing.valueIterator());
    }

    @Override
    public boolean replaceKey(int n, int n2) {
        throw this.writeError();
    }

    @Override
    public int replaceOneValue(boolean bl, boolean bl2) {
        throw this.writeError();
    }

    @Override
    public int getOneKeyByValue(boolean bl) {
        return this.backing.getOneKeyByValue(bl);
    }

    @Override
    public boolean[] valuesToArray() {
        return this.backing.valuesToArray();
    }

    @Override
    public boolean[] valuesToArray(boolean[] blArray) {
        return this.backing.valuesToArray(blArray);
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
    public IntBooleanMap synchronize() {
        return new IntBooleanReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(IntBooleanMap intBooleanMap) {
        throw this.writeError();
    }
}

