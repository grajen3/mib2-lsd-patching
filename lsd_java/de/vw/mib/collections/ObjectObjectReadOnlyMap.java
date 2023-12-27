/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ObjectReadOnlyCollection;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import de.vw.mib.collections.ObjectReadOnlySet;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.ReadOnlyIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ObjectObjectReadOnlyMap
implements ObjectObjectMap {
    public static final ObjectObjectMap EMPTY_READONLY_MAP = new ObjectObjectReadOnlyMap(new ObjectObjectOptHashMap(0));
    private final ObjectObjectMap backing;

    public ObjectObjectReadOnlyMap(ObjectObjectMap objectObjectMap) {
        this.backing = objectObjectMap;
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
    public boolean containsValue(Object object) {
        return this.backing.containsValue(object);
    }

    @Override
    public Object get(Object object) {
        return this.backing.get(object);
    }

    @Override
    public Object put(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public Object remove(Object object) {
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
    public Collection values() {
        return new ObjectReadOnlyCollection((ObjectCollection)this.backing.values());
    }

    @Override
    public Iterator valueIterator() {
        return new ObjectReadOnlyIterator((ObjectIterator)this.backing.valueIterator());
    }

    @Override
    public Object replaceKey(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public Object replaceOneValue(Object object, Object object2) {
        throw this.writeError();
    }

    @Override
    public Object getOneKeyByValue(Object object) {
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
    public Object[] keysToArray() {
        return this.backing.keysToArray();
    }

    @Override
    public Object[] keysToArray(Object[] objectArray) {
        return this.backing.keysToArray(objectArray);
    }

    @Override
    public ObjectObjectMap synchronize() {
        return new ObjectObjectReadOnlyMap(this.backing.synchronize());
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a map: operation not allowed.");
    }

    @Override
    public void putAll(Map map) {
        throw this.writeError();
    }
}

