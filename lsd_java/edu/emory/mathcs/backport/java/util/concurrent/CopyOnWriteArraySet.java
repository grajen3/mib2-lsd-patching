/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CopyOnWriteArraySet
extends AbstractSet
implements Serializable {
    private static final long serialVersionUID;
    private final CopyOnWriteArrayList al = new CopyOnWriteArrayList();

    public CopyOnWriteArraySet() {
    }

    public CopyOnWriteArraySet(Collection collection) {
        this.al.addAllAbsent(collection);
    }

    @Override
    public int size() {
        return this.al.size();
    }

    @Override
    public boolean isEmpty() {
        return this.al.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return this.al.contains(object);
    }

    @Override
    public Object[] toArray() {
        return this.al.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.al.toArray(objectArray);
    }

    @Override
    public void clear() {
        this.al.clear();
    }

    @Override
    public boolean remove(Object object) {
        return this.al.remove(object);
    }

    @Override
    public boolean add(Object object) {
        return this.al.addIfAbsent(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.al.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.al.addAllAbsent(collection) > 0;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.al.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.al.retainAll(collection);
    }

    @Override
    public Iterator iterator() {
        return this.al.iterator();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set set = (Set)object;
        Iterator iterator = set.iterator();
        Object[] objectArray = this.al.getArray();
        int n = objectArray.length;
        boolean[] blArray = new boolean[n];
        int n2 = 0;
        block0: while (iterator.hasNext()) {
            if (++n2 > n) {
                return false;
            }
            Object object2 = iterator.next();
            for (int i2 = 0; i2 < n; ++i2) {
                if (blArray[i2] || !CopyOnWriteArraySet.eq(object2, objectArray[i2])) continue;
                blArray[i2] = true;
                continue block0;
            }
            return false;
        }
        return n2 == n;
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }
}

