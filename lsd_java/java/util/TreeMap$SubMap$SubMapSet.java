/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.MapEntry$Type;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeMap$Entry;
import java.util.TreeMap$TreeMapIterator;

class TreeMap$SubMap$SubMapSet
extends AbstractSet
implements Set {
    final TreeMap backingMap;
    boolean hasStart;
    boolean hasEnd;
    Object startKey;
    Object endKey;
    final MapEntry$Type type;

    TreeMap$SubMap$SubMapSet(TreeMap treeMap, MapEntry$Type mapEntry$Type) {
        this.backingMap = treeMap;
        this.type = mapEntry$Type;
    }

    TreeMap$SubMap$SubMapSet(boolean bl, Object object, TreeMap treeMap, boolean bl2, Object object2, MapEntry$Type mapEntry$Type) {
        this(treeMap, mapEntry$Type);
        this.hasStart = bl;
        this.startKey = object;
        this.hasEnd = bl2;
        this.endKey = object2;
    }

    void checkRange(Object object) {
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

    boolean checkRange(Object object, boolean bl, boolean bl2) {
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
    public boolean isEmpty() {
        if (this.hasStart) {
            TreeMap$Entry treeMap$Entry = this.backingMap.findAfter(this.startKey);
            return treeMap$Entry == null || !this.checkRange(treeMap$Entry.key, false, this.hasEnd);
        }
        return this.backingMap.findBefore(this.endKey) == null;
    }

    @Override
    public Iterator iterator() {
        TreeMap$Entry treeMap$Entry;
        if (this.hasStart) {
            treeMap$Entry = this.backingMap.findAfter(this.startKey);
            if (treeMap$Entry != null && !this.checkRange(treeMap$Entry.key, false, this.hasEnd)) {
                treeMap$Entry = null;
            }
        } else {
            treeMap$Entry = this.backingMap.findBefore(this.endKey);
            if (treeMap$Entry != null) {
                treeMap$Entry = TreeMap.minimum(this.backingMap.root);
            }
        }
        return new TreeMap$TreeMapIterator(this.backingMap, this.type, treeMap$Entry, this.hasEnd, this.endKey);
    }

    @Override
    public int size() {
        int n = 0;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ++n;
            iterator.next();
        }
        return n;
    }
}

