/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import java.util.Collection;
import java.util.Iterator;

public class ObjectReadOnlyCollection
implements ObjectCollection {
    protected final ObjectCollection backing;

    public ObjectReadOnlyCollection(ObjectCollection objectCollection) {
        this.backing = objectCollection;
    }

    @Override
    public boolean add(Object object) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(Object object) {
        return this.backing.contains(object);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new ObjectReadOnlyIterator((ObjectIterator)this.backing.iterator());
    }

    @Override
    public boolean remove(Object object) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.backing.containsAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw this.writeError();
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw this.writeError();
    }

    @Override
    public Object[] toArray() {
        return this.backing.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.backing.toArray(objectArray);
    }

    protected UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

