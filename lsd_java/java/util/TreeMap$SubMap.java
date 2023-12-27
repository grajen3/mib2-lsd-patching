/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeMap$1;
import java.util.TreeMap$2;
import java.util.TreeMap$3;
import java.util.TreeMap$4;
import java.util.TreeMap$5;
import java.util.TreeMap$Entry;
import java.util.TreeMap$SubMap$SubMapSet;

final class TreeMap$SubMap
extends AbstractMap
implements SortedMap {
    private final TreeMap backingMap;
    private boolean hasStart;
    private boolean hasEnd;
    private Object startKey;
    private Object endKey;

    TreeMap$SubMap(Object object, TreeMap treeMap) {
        this.backingMap = treeMap;
        this.hasStart = true;
        this.startKey = object;
    }

    TreeMap$SubMap(Object object, TreeMap treeMap, Object object2) {
        this.backingMap = treeMap;
        this.hasEnd = true;
        this.hasStart = true;
        this.startKey = object;
        this.endKey = object2;
    }

    TreeMap$SubMap(TreeMap treeMap, Object object) {
        this.backingMap = treeMap;
        this.hasEnd = true;
        this.endKey = object;
    }

    private void checkRange(Object object) {
        if (this.backingMap.comparator() == null) {
            Comparable comparable = (Comparable)object;
            if (this.hasStart && comparable.compareTo(this.startKey) < 0) {
                throw new IllegalArgumentException();
            }
            if (this.hasEnd && comparable.compareTo(this.endKey) >= 0) {
                throw new IllegalArgumentException();
            }
        } else {
            if (this.hasStart && this.backingMap.comparator().compare(object, this.startKey) < 0) {
                throw new IllegalArgumentException();
            }
            if (this.hasEnd && this.backingMap.comparator().compare(object, this.endKey) >= 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean checkRange(Object object, boolean bl, boolean bl2) {
        if (this.backingMap.comparator() == null) {
            Comparable comparable = (Comparable)object;
            if (bl && comparable.compareTo(this.startKey) < 0) {
                return false;
            }
            if (bl2 && comparable.compareTo(this.endKey) >= 0) {
                return false;
            }
        } else {
            if (bl && this.backingMap.comparator().compare(object, this.startKey) < 0) {
                return false;
            }
            if (bl2 && this.backingMap.comparator().compare(object, this.endKey) >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Comparator comparator() {
        return this.backingMap.comparator();
    }

    @Override
    public boolean containsKey(Object object) {
        if (this.checkRange(object, this.hasStart, this.hasEnd)) {
            return this.backingMap.containsKey(object);
        }
        return false;
    }

    @Override
    public Set entrySet() {
        return new TreeMap$2(this, this.hasStart, this.startKey, this.backingMap, this.hasEnd, this.endKey, new TreeMap$1(this));
    }

    @Override
    public Object firstKey() {
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
    public Object get(Object object) {
        if (this.checkRange(object, this.hasStart, this.hasEnd)) {
            return this.backingMap.get(object);
        }
        return null;
    }

    @Override
    public SortedMap headMap(Object object) {
        this.checkRange(object);
        if (this.hasStart) {
            return new TreeMap$SubMap(this.startKey, this.backingMap, object);
        }
        return new TreeMap$SubMap(this.backingMap, object);
    }

    @Override
    public boolean isEmpty() {
        if (this.hasStart) {
            TreeMap$Entry treeMap$Entry = this.backingMap.findAfter(this.startKey);
            return treeMap$Entry == null || !this.checkRange(treeMap$Entry.key, false, this.hasEnd);
        }
        return this.backingMap.findBefore(this.endKey) == null;
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new TreeMap$4(this, this.hasStart, this.startKey, this.backingMap, this.hasEnd, this.endKey, new TreeMap$3(this));
        }
        return this.keySet;
    }

    @Override
    public Object lastKey() {
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
    public Object put(Object object, Object object2) {
        if (this.checkRange(object, this.hasStart, this.hasEnd)) {
            return this.backingMap.put(object, object2);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Object remove(Object object) {
        if (this.checkRange(object, this.hasStart, this.hasEnd)) {
            return this.backingMap.remove(object);
        }
        return null;
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        this.checkRange(object);
        this.checkRange(object2);
        Comparator comparator = this.backingMap.comparator();
        if (comparator == null ? ((Comparable)object).compareTo(object2) <= 0 : comparator.compare(object, object2) <= 0) {
            return new TreeMap$SubMap(object, this.backingMap, object2);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public SortedMap tailMap(Object object) {
        this.checkRange(object);
        if (this.hasEnd) {
            return new TreeMap$SubMap(object, this.backingMap, this.endKey);
        }
        return new TreeMap$SubMap(object, this.backingMap);
    }

    @Override
    public Collection values() {
        return new TreeMap$SubMap$SubMapSet(this.hasStart, this.startKey, this.backingMap, this.hasEnd, this.endKey, new TreeMap$5(this));
    }
}

