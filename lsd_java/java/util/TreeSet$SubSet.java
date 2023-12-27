/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeMap$Entry;
import java.util.TreeMap$SubMap$SubMapSet;
import java.util.TreeSet$1;

final class TreeSet$SubSet
extends TreeMap$SubMap$SubMapSet
implements SortedSet {
    TreeSet$SubSet(TreeMap treeMap) {
        super(treeMap, new TreeSet$1());
    }

    TreeSet$SubSet(Object object, TreeMap treeMap) {
        this(treeMap);
        this.hasStart = true;
        this.startKey = object;
    }

    TreeSet$SubSet(Object object, TreeMap treeMap, Object object2) {
        this(treeMap);
        this.hasEnd = true;
        this.hasStart = true;
        this.startKey = object;
        this.endKey = object2;
    }

    TreeSet$SubSet(TreeMap treeMap, Object object) {
        this(treeMap);
        this.hasEnd = true;
        this.endKey = object;
    }

    @Override
    public boolean add(Object object) {
        this.checkRange(object);
        return this.backingMap.put(object, object) != null;
    }

    @Override
    public Comparator comparator() {
        return this.backingMap.comparator();
    }

    @Override
    public boolean contains(Object object) {
        if (this.checkRange(object, this.hasStart, this.hasEnd)) {
            return this.backingMap.containsKey(object);
        }
        return false;
    }

    @Override
    public Object first() {
        if (!this.hasStart) {
            return this.backingMap.firstKey();
        }
        TreeMap$Entry treeMap$Entry = this.backingMap.findAfter(this.startKey);
        if (treeMap$Entry != null && this.checkRange(treeMap$Entry.key, false, this.hasEnd)) {
            return treeMap$Entry.key;
        }
        throw new NoSuchElementException();
    }

    @Override
    public SortedSet headSet(Object object) {
        this.checkRange(object);
        if (this.hasStart) {
            return new TreeSet$SubSet(this.startKey, this.backingMap, object);
        }
        return new TreeSet$SubSet(this.backingMap, object);
    }

    @Override
    public Object last() {
        if (!this.hasEnd) {
            return this.backingMap.lastKey();
        }
        TreeMap$Entry treeMap$Entry = this.backingMap.findBefore(this.endKey);
        if (treeMap$Entry != null && this.checkRange(treeMap$Entry.key, this.hasStart, false)) {
            return treeMap$Entry.key;
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean remove(Object object) {
        if (this.checkRange(object, this.hasStart, this.hasEnd)) {
            return this.backingMap.remove(object) != null;
        }
        return false;
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        this.checkRange(object);
        this.checkRange(object2);
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null ? ((Comparable)this.startKey).compareTo(this.endKey) <= 0 : comparator.compare(this.startKey, this.endKey) <= 0) {
            return new TreeSet$SubSet(object, this.backingMap, object2);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public SortedSet tailSet(Object object) {
        this.checkRange(object);
        if (this.hasEnd) {
            return new TreeSet$SubSet(object, this.backingMap, this.endKey);
        }
        return new TreeSet$SubSet(object, this.backingMap);
    }
}

