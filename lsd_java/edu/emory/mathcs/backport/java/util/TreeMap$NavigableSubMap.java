/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap$SubEntrySet;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap$SubKeySet;
import java.io.Serializable;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

abstract class TreeMap$NavigableSubMap
extends AbstractMap
implements NavigableMap,
Serializable {
    private static final long serialVersionUID;
    final Object fromKey;
    final Object toKey;
    final boolean fromStart;
    final boolean toEnd;
    final boolean fromInclusive;
    final boolean toInclusive;
    transient int cachedSize = -1;
    transient int cacheVersion;
    transient TreeMap$NavigableSubMap$SubEntrySet entrySet;
    transient NavigableMap descendingMap;
    transient NavigableSet navigableKeySet;
    private final /* synthetic */ TreeMap this$0;

    TreeMap$NavigableSubMap(TreeMap treeMap, boolean bl, Object object, boolean bl2, boolean bl3, Object object2, boolean bl4) {
        this.this$0 = treeMap;
        if (!bl && !bl3) {
            if (TreeMap.access$1600(object, object2, TreeMap.access$1500(treeMap)) > 0) {
                throw new IllegalArgumentException("fromKey > toKey");
            }
        } else {
            if (!bl) {
                TreeMap.access$1600(object, object, TreeMap.access$1500(treeMap));
            }
            if (!bl3) {
                TreeMap.access$1600(object2, object2, TreeMap.access$1500(treeMap));
            }
        }
        this.fromStart = bl;
        this.toEnd = bl3;
        this.fromKey = object;
        this.toKey = object2;
        this.fromInclusive = bl2;
        this.toInclusive = bl4;
    }

    final TreeMap$Entry checkLoRange(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry == null || this.absTooLow(TreeMap$Entry.access$400(treeMap$Entry)) ? null : treeMap$Entry;
    }

    final TreeMap$Entry checkHiRange(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry == null || this.absTooHigh(TreeMap$Entry.access$400(treeMap$Entry)) ? null : treeMap$Entry;
    }

    final boolean inRange(Object object) {
        return !this.absTooLow(object) && !this.absTooHigh(object);
    }

    final boolean inRangeExclusive(Object object) {
        return !(!this.fromStart && TreeMap.access$1600(object, this.fromKey, TreeMap.access$1500(this.this$0)) < 0 || !this.toEnd && TreeMap.access$1600(this.toKey, object, TreeMap.access$1500(this.this$0)) < 0);
    }

    final boolean inRange(Object object, boolean bl) {
        return bl ? this.inRange(object) : this.inRangeExclusive(object);
    }

    private boolean absTooHigh(Object object) {
        if (this.toEnd) {
            return false;
        }
        int n = TreeMap.access$1600(object, this.toKey, TreeMap.access$1500(this.this$0));
        return n > 0 || n == 0 && !this.toInclusive;
    }

    private boolean absTooLow(Object object) {
        if (this.fromStart) {
            return false;
        }
        int n = TreeMap.access$1600(object, this.fromKey, TreeMap.access$1500(this.this$0));
        return n < 0 || n == 0 && !this.fromInclusive;
    }

    protected abstract TreeMap$Entry first() {
    }

    protected abstract TreeMap$Entry last() {
    }

    protected abstract TreeMap$Entry lower(Object object) {
    }

    protected abstract TreeMap$Entry floor(Object object) {
    }

    protected abstract TreeMap$Entry ceiling(Object object) {
    }

    protected abstract TreeMap$Entry higher(Object object) {
    }

    protected abstract TreeMap$Entry uncheckedHigher(TreeMap$Entry treeMap$Entry) {
    }

    final TreeMap$Entry absLowest() {
        return this.checkHiRange(this.fromStart ? TreeMap.access$1100(this.this$0) : (this.fromInclusive ? TreeMap.access$1700(this.this$0, this.fromKey) : TreeMap.access$1800(this.this$0, this.fromKey)));
    }

    final TreeMap$Entry absHighest() {
        return this.checkLoRange(this.toEnd ? TreeMap.access$1300(this.this$0) : (this.toInclusive ? TreeMap.access$1900(this.this$0, this.toKey) : TreeMap.access$2000(this.this$0, this.toKey)));
    }

    final TreeMap$Entry absLower(Object object) {
        return this.absTooHigh(object) ? this.absHighest() : this.checkLoRange(TreeMap.access$2000(this.this$0, object));
    }

    final TreeMap$Entry absFloor(Object object) {
        return this.absTooHigh(object) ? this.absHighest() : this.checkLoRange(TreeMap.access$1900(this.this$0, object));
    }

    final TreeMap$Entry absCeiling(Object object) {
        return this.absTooLow(object) ? this.absLowest() : this.checkHiRange(TreeMap.access$1700(this.this$0, object));
    }

    final TreeMap$Entry absHigher(Object object) {
        return this.absTooLow(object) ? this.absLowest() : this.checkHiRange(TreeMap.access$1800(this.this$0, object));
    }

    @Override
    public Map$Entry firstEntry() {
        TreeMap$Entry treeMap$Entry = this.first();
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object firstKey() {
        TreeMap$Entry treeMap$Entry = this.first();
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        return TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry lastEntry() {
        TreeMap$Entry treeMap$Entry = this.last();
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object lastKey() {
        TreeMap$Entry treeMap$Entry = this.last();
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        return TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry pollFirstEntry() {
        TreeMap$Entry treeMap$Entry = this.first();
        if (treeMap$Entry == null) {
            return null;
        }
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry = new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
        TreeMap.access$1000(this.this$0, treeMap$Entry);
        return abstractMap$SimpleImmutableEntry;
    }

    @Override
    public Map$Entry pollLastEntry() {
        TreeMap$Entry treeMap$Entry = this.last();
        if (treeMap$Entry == null) {
            return null;
        }
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry = new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
        TreeMap.access$1000(this.this$0, treeMap$Entry);
        return abstractMap$SimpleImmutableEntry;
    }

    @Override
    public Map$Entry lowerEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.lower(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object lowerKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.lower(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry floorEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.floor(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object floorKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.floor(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry ceilingEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.ceiling(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object ceilingKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.ceiling(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public Map$Entry higherEntry(Object object) {
        TreeMap$Entry treeMap$Entry = this.higher(object);
        return treeMap$Entry == null ? null : new AbstractMap$SimpleImmutableEntry(treeMap$Entry);
    }

    @Override
    public Object higherKey(Object object) {
        TreeMap$Entry treeMap$Entry = this.higher(object);
        return treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    @Override
    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    @Override
    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    @Override
    public int size() {
        if (this.cachedSize < 0 || this.cacheVersion != TreeMap.access$700(this.this$0)) {
            this.cachedSize = this.recalculateSize();
            this.cacheVersion = TreeMap.access$700(this.this$0);
        }
        return this.cachedSize;
    }

    private int recalculateSize() {
        TreeMap$Entry treeMap$Entry = this.absHighest();
        Object object = treeMap$Entry != null ? TreeMap$Entry.access$400(treeMap$Entry) : null;
        int n = 0;
        TreeMap$Entry treeMap$Entry2 = this.absLowest();
        while (treeMap$Entry2 != null) {
            ++n;
            treeMap$Entry2 = TreeMap$Entry.access$400(treeMap$Entry2) == object ? null : TreeMap.access$800(treeMap$Entry2);
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.absLowest() == null;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.inRange(object) && this.this$0.containsKey(object);
    }

    @Override
    public Object get(Object object) {
        if (!this.inRange(object)) {
            return null;
        }
        return this.this$0.get(object);
    }

    @Override
    public Object put(Object object, Object object2) {
        if (!this.inRange(object)) {
            throw new IllegalArgumentException("Key out of range");
        }
        return this.this$0.put(object, object2);
    }

    @Override
    public Object remove(Object object) {
        if (!this.inRange(object)) {
            return null;
        }
        return this.this$0.remove(object);
    }

    @Override
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new TreeMap$NavigableSubMap$SubEntrySet(this);
        }
        return this.entrySet;
    }

    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }

    @Override
    public NavigableSet navigableKeySet() {
        if (this.navigableKeySet == null) {
            this.navigableKeySet = new TreeMap$NavigableSubMap$SubKeySet(this);
        }
        return this.navigableKeySet;
    }

    private TreeMap$Entry getMatchingSubEntry(Object object) {
        if (!(object instanceof Map$Entry)) {
            return null;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        Object object2 = map$Entry.getKey();
        if (!this.inRange(object2)) {
            return null;
        }
        TreeMap$Entry treeMap$Entry = TreeMap.access$1400(this.this$0, object2);
        return treeMap$Entry != null && TreeMap.access$300(treeMap$Entry.getValue(), map$Entry.getValue()) ? treeMap$Entry : null;
    }

    static /* synthetic */ TreeMap$Entry access$2100(TreeMap$NavigableSubMap treeMap$NavigableSubMap, Object object) {
        return treeMap$NavigableSubMap.getMatchingSubEntry(object);
    }

    static /* synthetic */ TreeMap access$2200(TreeMap$NavigableSubMap treeMap$NavigableSubMap) {
        return treeMap$NavigableSubMap.this$0;
    }
}

