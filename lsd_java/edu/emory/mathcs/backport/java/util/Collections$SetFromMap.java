/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractSet;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Collections$SetFromMap
extends AbstractSet
implements Serializable {
    private static final Object PRESENT = Boolean.TRUE;
    final Map map;
    transient Set keySet;

    Collections$SetFromMap(Map map) {
        this.map = map;
        this.keySet = map.keySet();
    }

    @Override
    public int hashCode() {
        return ((Object)this.keySet).hashCode();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean add(Object object) {
        return this.map.put(object, PRESENT) == null;
    }

    @Override
    public boolean contains(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean equals(Object object) {
        return object == this || ((Object)this.keySet).equals(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.map.remove(object) == PRESENT;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.keySet.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.keySet.retainAll(collection);
    }

    @Override
    public Iterator iterator() {
        return this.keySet.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.keySet.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.keySet.toArray(objectArray);
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl |= this.map.put(iterator.next(), PRESENT) == null;
        }
        return bl;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keySet = this.map.keySet();
    }
}

