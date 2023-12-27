/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections$6;
import java.util.Iterator;

class Collections$UnmodifiableCollection
implements Collection,
Serializable {
    private static final long serialVersionUID;
    final Collection c;

    Collections$UnmodifiableCollection(Collection collection) {
        this.c = collection;
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object object) {
        return this.c.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.c.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new Collections$6(this);
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.c.size();
    }

    @Override
    public Object[] toArray() {
        return this.c.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.c.toArray(objectArray);
    }
}

