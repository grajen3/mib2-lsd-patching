/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap$SubKeyIterator;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.SortedSet;

class TreeMap$NavigableSubMap$SubKeySet
extends AbstractSet
implements NavigableSet {
    private final /* synthetic */ TreeMap$NavigableSubMap this$1;

    TreeMap$NavigableSubMap$SubKeySet(TreeMap$NavigableSubMap treeMap$NavigableSubMap) {
        this.this$1 = treeMap$NavigableSubMap;
    }

    @Override
    public int size() {
        return this.this$1.size();
    }

    @Override
    public boolean isEmpty() {
        return this.this$1.isEmpty();
    }

    @Override
    public void clear() {
        this.this$1.clear();
    }

    @Override
    public boolean contains(Object object) {
        return TreeMap.access$1400(TreeMap$NavigableSubMap.access$2200(this.this$1), object) != null;
    }

    @Override
    public boolean remove(Object object) {
        if (!this.this$1.inRange(object)) {
            return false;
        }
        TreeMap$Entry treeMap$Entry = TreeMap.access$1400(TreeMap$NavigableSubMap.access$2200(this.this$1), object);
        if (treeMap$Entry == null) {
            return false;
        }
        TreeMap.access$1000(TreeMap$NavigableSubMap.access$2200(this.this$1), treeMap$Entry);
        return true;
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
    public Iterator iterator() {
        return new TreeMap$NavigableSubMap$SubKeyIterator(this.this$1, this.this$1.entrySet().iterator());
    }

    @Override
    public Iterator descendingIterator() {
        return new TreeMap$NavigableSubMap$SubKeyIterator(this.this$1, this.this$1.descendingMap().entrySet().iterator());
    }

    @Override
    public Object lower(Object object) {
        return this.this$1.lowerKey(object);
    }

    @Override
    public Object floor(Object object) {
        return this.this$1.floorKey(object);
    }

    @Override
    public Object ceiling(Object object) {
        return this.this$1.ceilingKey(object);
    }

    @Override
    public Object higher(Object object) {
        return this.this$1.higherKey(object);
    }

    @Override
    public Object first() {
        return this.this$1.firstKey();
    }

    @Override
    public Object last() {
        return this.this$1.lastKey();
    }

    @Override
    public Comparator comparator() {
        return this.this$1.comparator();
    }

    @Override
    public Object pollFirst() {
        Map$Entry map$Entry = this.this$1.pollFirstEntry();
        return map$Entry == null ? null : map$Entry.getKey();
    }

    @Override
    public Object pollLast() {
        Map$Entry map$Entry = this.this$1.pollLastEntry();
        return map$Entry == null ? null : map$Entry.getKey();
    }

    @Override
    public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
        return (NavigableSet)this.this$1.subMap(object, bl, object2, bl2).keySet();
    }

    @Override
    public NavigableSet headSet(Object object, boolean bl) {
        return (NavigableSet)this.this$1.headMap(object, bl).keySet();
    }

    @Override
    public NavigableSet tailSet(Object object, boolean bl) {
        return (NavigableSet)this.this$1.tailMap(object, bl).keySet();
    }

    @Override
    public NavigableSet descendingSet() {
        return (NavigableSet)this.this$1.descendingMap().keySet();
    }
}

