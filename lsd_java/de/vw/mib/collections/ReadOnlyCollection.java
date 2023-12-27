/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ReadOnlyIterator;
import java.util.Collection;
import java.util.Iterator;

public class ReadOnlyCollection
implements Collection {
    private final Collection backingCollection;

    public ReadOnlyCollection(Collection collection) {
        this.backingCollection = collection;
    }

    @Override
    public boolean add(Object object) {
        throw this.writeError();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(Object object) {
        return this.backingCollection.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.backingCollection.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.backingCollection.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new ReadOnlyIterator(this.backingCollection.iterator());
    }

    @Override
    public boolean remove(Object object) {
        throw this.writeError();
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
    public int size() {
        return this.backingCollection.size();
    }

    @Override
    public Object[] toArray() {
        return this.backingCollection.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.backingCollection.toArray(objectArray);
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

