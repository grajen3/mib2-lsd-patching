/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentNavigableMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;
import java.util.SortedSet;

final class ConcurrentSkipListMap$KeySet
extends AbstractSet
implements NavigableSet {
    private final ConcurrentNavigableMap m;

    ConcurrentSkipListMap$KeySet(ConcurrentNavigableMap concurrentNavigableMap) {
        this.m = concurrentNavigableMap;
    }

    @Override
    public int size() {
        return this.m.size();
    }

    @Override
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return this.m.containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.m.remove(object) != null;
    }

    @Override
    public void clear() {
        this.m.clear();
    }

    @Override
    public Object lower(Object object) {
        return this.m.lowerKey(object);
    }

    @Override
    public Object floor(Object object) {
        return this.m.floorKey(object);
    }

    @Override
    public Object ceiling(Object object) {
        return this.m.ceilingKey(object);
    }

    @Override
    public Object higher(Object object) {
        return this.m.higherKey(object);
    }

    @Override
    public Comparator comparator() {
        return this.m.comparator();
    }

    @Override
    public Object first() {
        return this.m.firstKey();
    }

    @Override
    public Object last() {
        return this.m.lastKey();
    }

    @Override
    public Object pollFirst() {
        Map$Entry map$Entry = this.m.pollFirstEntry();
        return map$Entry == null ? null : map$Entry.getKey();
    }

    @Override
    public Object pollLast() {
        Map$Entry map$Entry = this.m.pollLastEntry();
        return map$Entry == null ? null : map$Entry.getKey();
    }

    @Override
    public Object[] toArray() {
        return ConcurrentSkipListMap.toList(this).toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return ConcurrentSkipListMap.toList(this).toArray(objectArray);
    }

    @Override
    public Iterator iterator() {
        if (this.m instanceof ConcurrentSkipListMap) {
            return ((ConcurrentSkipListMap)this.m).keyIterator();
        }
        return ((ConcurrentSkipListMap$SubMap)this.m).keyIterator();
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
    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    @Override
    public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
        return new ConcurrentSkipListSet((ConcurrentNavigableMap)this.m.subMap(object, bl, object2, bl2));
    }

    @Override
    public NavigableSet headSet(Object object, boolean bl) {
        return new ConcurrentSkipListSet((ConcurrentNavigableMap)this.m.headMap(object, bl));
    }

    @Override
    public NavigableSet tailSet(Object object, boolean bl) {
        return new ConcurrentSkipListSet((ConcurrentNavigableMap)this.m.tailMap(object, bl));
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    @Override
    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }

    @Override
    public NavigableSet descendingSet() {
        return new ConcurrentSkipListSet((ConcurrentNavigableMap)this.m.descendingMap());
    }
}

