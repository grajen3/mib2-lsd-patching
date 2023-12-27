/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.internal.navigation.util.IdentityHashSet$1;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class IdentityHashSet
implements Set {
    private static final Object VALUE = new Object();
    IdentityHashMap backingMap = new IdentityHashMap();

    @Override
    public synchronized boolean add(Object object) {
        return this.backingMap.put(object, VALUE) == null;
    }

    @Override
    public boolean addAll(Collection collection) {
        Iterator iterator = collection.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            Object object = iterator.next();
            bl |= this.backingMap.put(object, VALUE) == null;
        }
        return bl;
    }

    @Override
    public synchronized void clear() {
        this.backingMap.clear();
    }

    @Override
    public synchronized boolean contains(Object object) {
        return this.backingMap.containsKey(object);
    }

    @Override
    public synchronized boolean containsAll(Collection collection) {
        boolean bl = true;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            bl &= this.backingMap.containsKey(object);
        }
        return bl;
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public synchronized Iterator iterator() {
        Object[] objectArray = this.toArray();
        return new IdentityHashSet$1(this, objectArray);
    }

    @Override
    public synchronized boolean remove(Object object) {
        return this.backingMap.remove(object) != null;
    }

    @Override
    public synchronized boolean removeAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            bl |= this.backingMap.remove(object) != null;
        }
        return bl;
    }

    @Override
    public synchronized boolean retainAll(Collection collection) {
        return this.backingMap.keySet().retainAll(collection);
    }

    @Override
    public synchronized int size() {
        return this.backingMap.size();
    }

    @Override
    public synchronized Object[] toArray() {
        return this.backingMap.keySet().toArray();
    }

    @Override
    public synchronized Object[] toArray(Object[] objectArray) {
        return this.backingMap.keySet().toArray(objectArray);
    }
}

