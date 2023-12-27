/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Collections$CheckedCollection;
import edu.emory.mathcs.backport.java.util.Collections$CheckedList$ListItr;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class Collections$CheckedList
extends Collections$CheckedCollection
implements List,
Serializable {
    final List list;

    Collections$CheckedList(List list, Class clazz) {
        super(list, clazz);
        this.list = list;
    }

    @Override
    public Object get(int n) {
        return this.list.get(n);
    }

    @Override
    public Object remove(int n) {
        return this.list.remove(n);
    }

    @Override
    public int indexOf(Object object) {
        return this.list.indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.list.lastIndexOf(object);
    }

    @Override
    public int hashCode() {
        return ((Object)this.list).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object == this || ((Object)this.list).equals(object);
    }

    @Override
    public Object set(int n, Object object) {
        this.typeCheck(object);
        return this.list.set(n, object);
    }

    @Override
    public void add(int n, Object object) {
        this.typeCheck(object);
        this.list.add(n, object);
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        Object[] objectArray;
        try {
            objectArray = collection.toArray(this.getEmptyArr());
        }
        catch (ArrayStoreException arrayStoreException) {
            throw new ClassCastException(new StringBuffer().append("Attempted to insert an element of invalid type  to a list of type ").append(this.type.getName()).toString());
        }
        return this.list.addAll(n, Arrays.asList(objectArray));
    }

    @Override
    public List subList(int n, int n2) {
        return new Collections$CheckedList(this.list.subList(n, n2), this.type);
    }

    @Override
    public ListIterator listIterator() {
        return new Collections$CheckedList$ListItr(this, this.list.listIterator());
    }

    @Override
    public ListIterator listIterator(int n) {
        return new Collections$CheckedList$ListItr(this, this.list.listIterator(n));
    }
}

