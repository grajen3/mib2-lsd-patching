/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Collections$CheckedCollection$Itr;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

class Collections$CheckedCollection
implements Collection,
Serializable {
    final Collection coll;
    final Class type;
    transient Object[] emptyArr;

    Collections$CheckedCollection(Collection collection, Class clazz) {
        if (collection == null || clazz == null) {
            throw new NullPointerException();
        }
        this.coll = collection;
        this.type = clazz;
    }

    void typeCheck(Object object) {
        if (!this.type.isInstance(object)) {
            throw new ClassCastException(new StringBuffer().append("Attempted to insert an element of type ").append(object.getClass().getName()).append(" to a collection of type ").append(this.type.getName()).toString());
        }
    }

    @Override
    public int size() {
        return this.coll.size();
    }

    @Override
    public void clear() {
        this.coll.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.coll.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return this.coll.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.coll.toArray(objectArray);
    }

    @Override
    public boolean contains(Object object) {
        return this.coll.contains(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.coll.remove(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.coll.containsAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.coll.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.coll.retainAll(collection);
    }

    public String toString() {
        return this.coll.toString();
    }

    @Override
    public boolean add(Object object) {
        this.typeCheck(object);
        return this.coll.add(object);
    }

    @Override
    public boolean addAll(Collection collection) {
        Object[] objectArray;
        try {
            objectArray = collection.toArray(this.getEmptyArr());
        }
        catch (ArrayStoreException arrayStoreException) {
            throw new ClassCastException(new StringBuffer().append("Attempted to insert an element of invalid type  to a collection of type ").append(this.type.getName()).toString());
        }
        return this.coll.addAll(Arrays.asList(objectArray));
    }

    @Override
    public Iterator iterator() {
        return new Collections$CheckedCollection$Itr(this, this.coll.iterator());
    }

    protected Object[] getEmptyArr() {
        if (this.emptyArr == null) {
            this.emptyArr = (Object[])Array.newInstance(this.type, 0);
        }
        return this.emptyArr;
    }
}

