/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectReadOnlyIterator;
import java.util.Collection;
import java.util.Iterator;

public class ObjectReadOnlyArrayList
implements ObjectCollection {
    public static final ObjectCollection EMPTY = new ObjectReadOnlyArrayList();
    private final ObjectArrayList backingList;

    public ObjectReadOnlyArrayList(ObjectArrayList objectArrayList) {
        this.backingList = objectArrayList;
    }

    private ObjectReadOnlyArrayList() {
        this.backingList = new ObjectArrayList(0);
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
        return this.backingList.contains(object);
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new ObjectReadOnlyIterator((ObjectIterator)this.backingList.iterator());
    }

    @Override
    public boolean remove(Object object) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.backingList.containsAll(collection);
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
        return this.backingList.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.backingList.toArray(objectArray);
    }

    private RuntimeException writeError() {
        return new UnsupportedOperationException(new StringBuffer().append("No write to ").append(super.getClass()).append(" allowed.").toString());
    }

    public String toString() {
        return this.backingList.toString();
    }

    @Override
    public int hashCode() {
        return (int)HashCodeBuilder.hash(this.backingList);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ObjectReadOnlyArrayList objectReadOnlyArrayList = (ObjectReadOnlyArrayList)object;
        return !(this.backingList == null ? objectReadOnlyArrayList.backingList != null : !this.backingList.equals(objectReadOnlyArrayList.backingList));
    }
}

