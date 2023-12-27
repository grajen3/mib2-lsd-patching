/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$DescendingKeyIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$KeyIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$KeySet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map$Entry;

class TreeMap$AscendingKeySet
extends TreeMap$KeySet {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$AscendingKeySet(TreeMap treeMap) {
        this.this$0 = treeMap;
        super(treeMap);
    }

    @Override
    public Iterator iterator() {
        return new TreeMap$KeyIterator(this.this$0, TreeMap.access$1100(this.this$0));
    }

    @Override
    public Iterator descendingIterator() {
        return new TreeMap$DescendingKeyIterator(this.this$0, TreeMap.access$1100(this.this$0));
    }

    @Override
    public Object lower(Object object) {
        return this.this$0.lowerKey(object);
    }

    @Override
    public Object floor(Object object) {
        return this.this$0.floorKey(object);
    }

    @Override
    public Object ceiling(Object object) {
        return this.this$0.ceilingKey(object);
    }

    @Override
    public Object higher(Object object) {
        return this.this$0.higherKey(object);
    }

    @Override
    public Object first() {
        return this.this$0.firstKey();
    }

    @Override
    public Object last() {
        return this.this$0.lastKey();
    }

    @Override
    public Comparator comparator() {
        return this.this$0.comparator();
    }

    @Override
    public Object pollFirst() {
        Map$Entry map$Entry = this.this$0.pollFirstEntry();
        return map$Entry == null ? null : map$Entry.getKey();
    }

    @Override
    public Object pollLast() {
        Map$Entry map$Entry = this.this$0.pollLastEntry();
        return map$Entry == null ? null : map$Entry.getKey();
    }

    @Override
    public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
        return (NavigableSet)this.this$0.subMap(object, bl, object2, bl2).keySet();
    }

    @Override
    public NavigableSet headSet(Object object, boolean bl) {
        return (NavigableSet)this.this$0.headMap(object, bl).keySet();
    }

    @Override
    public NavigableSet tailSet(Object object, boolean bl) {
        return (NavigableSet)this.this$0.tailMap(object, bl).keySet();
    }

    @Override
    public NavigableSet descendingSet() {
        return (NavigableSet)this.this$0.descendingMap().keySet();
    }
}

