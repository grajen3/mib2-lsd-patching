/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentNavigableMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;

final class ConcurrentSkipListMap$EntrySet
extends AbstractSet {
    private final ConcurrentNavigableMap m;

    ConcurrentSkipListMap$EntrySet(ConcurrentNavigableMap concurrentNavigableMap) {
        this.m = concurrentNavigableMap;
    }

    @Override
    public Iterator iterator() {
        if (this.m instanceof ConcurrentSkipListMap) {
            return ((ConcurrentSkipListMap)this.m).entryIterator();
        }
        return ((ConcurrentSkipListMap$SubMap)this.m).entryIterator();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        Object object2 = this.m.get(map$Entry.getKey());
        return object2 != null && object2.equals(map$Entry.getValue());
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        return this.m.remove(map$Entry.getKey(), map$Entry.getValue());
    }

    @Override
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override
    public int size() {
        return this.m.size();
    }

    @Override
    public void clear() {
        this.m.clear();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Collection collection = (Collection)object;
        try {
            return this.containsAll(collection) && collection.containsAll(this);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        return ConcurrentSkipListMap.toList(this).toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return ConcurrentSkipListMap.toList(this).toArray(objectArray);
    }
}

