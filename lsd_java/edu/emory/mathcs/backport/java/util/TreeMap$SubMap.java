/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$AscendingSubMap;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map$Entry;
import java.util.Set;
import java.util.SortedMap;

class TreeMap$SubMap
extends AbstractMap
implements Serializable,
NavigableMap {
    private static final long serialVersionUID;
    final Object fromKey = null;
    final Object toKey = null;
    private final /* synthetic */ TreeMap this$0;

    TreeMap$SubMap(TreeMap treeMap) {
        this.this$0 = treeMap;
    }

    private Object readResolve() {
        return new TreeMap$AscendingSubMap(this.this$0, this.fromKey == null, this.fromKey, true, this.toKey == null, this.toKey, false);
    }

    @Override
    public Map$Entry lowerEntry(Object object) {
        throw new Error();
    }

    @Override
    public Object lowerKey(Object object) {
        throw new Error();
    }

    @Override
    public Map$Entry floorEntry(Object object) {
        throw new Error();
    }

    @Override
    public Object floorKey(Object object) {
        throw new Error();
    }

    @Override
    public Map$Entry ceilingEntry(Object object) {
        throw new Error();
    }

    @Override
    public Object ceilingKey(Object object) {
        throw new Error();
    }

    @Override
    public Map$Entry higherEntry(Object object) {
        throw new Error();
    }

    @Override
    public Object higherKey(Object object) {
        throw new Error();
    }

    @Override
    public Map$Entry firstEntry() {
        throw new Error();
    }

    @Override
    public Map$Entry lastEntry() {
        throw new Error();
    }

    @Override
    public Map$Entry pollFirstEntry() {
        throw new Error();
    }

    @Override
    public Map$Entry pollLastEntry() {
        throw new Error();
    }

    @Override
    public NavigableMap descendingMap() {
        throw new Error();
    }

    @Override
    public NavigableSet navigableKeySet() {
        throw new Error();
    }

    @Override
    public NavigableSet descendingKeySet() {
        throw new Error();
    }

    @Override
    public Set entrySet() {
        throw new Error();
    }

    @Override
    public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        throw new Error();
    }

    @Override
    public NavigableMap headMap(Object object, boolean bl) {
        throw new Error();
    }

    @Override
    public NavigableMap tailMap(Object object, boolean bl) {
        throw new Error();
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        throw new Error();
    }

    @Override
    public SortedMap headMap(Object object) {
        throw new Error();
    }

    @Override
    public SortedMap tailMap(Object object) {
        throw new Error();
    }

    @Override
    public Comparator comparator() {
        throw new Error();
    }

    @Override
    public Object firstKey() {
        throw new Error();
    }

    @Override
    public Object lastKey() {
        throw new Error();
    }
}

