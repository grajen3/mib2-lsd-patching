/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentNavigableMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$EntrySet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$KeySet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap$SubMapEntryIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap$SubMapKeyIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap$SubMapValueIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Values;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

final class ConcurrentSkipListMap$SubMap
extends AbstractMap
implements ConcurrentNavigableMap,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    private final ConcurrentSkipListMap m;
    private final Object lo;
    private final Object hi;
    private final boolean loInclusive;
    private final boolean hiInclusive;
    private final boolean isDescending;
    private transient ConcurrentSkipListMap$KeySet keySetView;
    private transient Set entrySetView;
    private transient Collection valuesView;

    ConcurrentSkipListMap$SubMap(ConcurrentSkipListMap concurrentSkipListMap, Object object, boolean bl, Object object2, boolean bl2, boolean bl3) {
        if (object != null && object2 != null && concurrentSkipListMap.compare(object, object2) > 0) {
            throw new IllegalArgumentException("inconsistent range");
        }
        this.m = concurrentSkipListMap;
        this.lo = object;
        this.hi = object2;
        this.loInclusive = bl;
        this.hiInclusive = bl2;
        this.isDescending = bl3;
    }

    private boolean tooLow(Object object) {
        int n;
        return this.lo != null && ((n = this.m.compare(object, this.lo)) < 0 || n == 0 && !this.loInclusive);
    }

    private boolean tooHigh(Object object) {
        int n;
        return this.hi != null && ((n = this.m.compare(object, this.hi)) > 0 || n == 0 && !this.hiInclusive);
    }

    private boolean inBounds(Object object) {
        return !this.tooLow(object) && !this.tooHigh(object);
    }

    private void checkKeyBounds(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (!this.inBounds(object)) {
            throw new IllegalArgumentException("key out of range");
        }
    }

    private boolean isBeforeEnd(ConcurrentSkipListMap$Node concurrentSkipListMap$Node) {
        if (concurrentSkipListMap$Node == null) {
            return false;
        }
        if (this.hi == null) {
            return true;
        }
        Object object = concurrentSkipListMap$Node.key;
        if (object == null) {
            return true;
        }
        int n = this.m.compare(object, this.hi);
        return n <= 0 && (n != 0 || this.hiInclusive);
    }

    private ConcurrentSkipListMap$Node loNode() {
        if (this.lo == null) {
            return this.m.findFirst();
        }
        if (this.loInclusive) {
            return this.m.findNear(this.lo, 0 | 1);
        }
        return this.m.findNear(this.lo, 0);
    }

    private ConcurrentSkipListMap$Node hiNode() {
        if (this.hi == null) {
            return this.m.findLast();
        }
        if (this.hiInclusive) {
            return this.m.findNear(this.hi, 2 | 1);
        }
        return this.m.findNear(this.hi, 2);
    }

    private Object lowestKey() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.loNode();
        if (this.isBeforeEnd(concurrentSkipListMap$Node)) {
            return concurrentSkipListMap$Node.key;
        }
        throw new NoSuchElementException();
    }

    private Object highestKey() {
        Object object;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.hiNode();
        if (concurrentSkipListMap$Node != null && this.inBounds(object = concurrentSkipListMap$Node.key)) {
            return object;
        }
        throw new NoSuchElementException();
    }

    private Map$Entry lowestEntry() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry;
        do {
            if (this.isBeforeEnd(concurrentSkipListMap$Node = this.loNode())) continue;
            return null;
        } while ((abstractMap$SimpleImmutableEntry = concurrentSkipListMap$Node.createSnapshot()) == null);
        return abstractMap$SimpleImmutableEntry;
    }

    private Map$Entry highestEntry() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        AbstractMap$SimpleImmutableEntry abstractMap$SimpleImmutableEntry;
        do {
            if ((concurrentSkipListMap$Node = this.hiNode()) != null && this.inBounds(concurrentSkipListMap$Node.key)) continue;
            return null;
        } while ((abstractMap$SimpleImmutableEntry = concurrentSkipListMap$Node.createSnapshot()) == null);
        return abstractMap$SimpleImmutableEntry;
    }

    private Map$Entry removeLowest() {
        Object object;
        Object object2;
        do {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
            if ((concurrentSkipListMap$Node = this.loNode()) == null) {
                return null;
            }
            object = concurrentSkipListMap$Node.key;
            if (this.inBounds(object)) continue;
            return null;
        } while ((object2 = this.m.doRemove(object, null)) == null);
        return new AbstractMap$SimpleImmutableEntry(object, object2);
    }

    private Map$Entry removeHighest() {
        Object object;
        Object object2;
        do {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
            if ((concurrentSkipListMap$Node = this.hiNode()) == null) {
                return null;
            }
            object = concurrentSkipListMap$Node.key;
            if (this.inBounds(object)) continue;
            return null;
        } while ((object2 = this.m.doRemove(object, null)) == null);
        return new AbstractMap$SimpleImmutableEntry(object, object2);
    }

    private Map$Entry getNearEntry(Object object, int n) {
        Object object2;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        Object object3;
        if (this.isDescending) {
            n = (n & 2) == 0 ? (n |= 2) : (n &= ~2);
        }
        if (this.tooLow(object)) {
            return (n & 2) != 0 ? null : this.lowestEntry();
        }
        if (this.tooHigh(object)) {
            return (n & 2) != 0 ? this.highestEntry() : null;
        }
        do {
            if ((concurrentSkipListMap$Node = this.m.findNear(object, n)) == null || !this.inBounds(concurrentSkipListMap$Node.key)) {
                return null;
            }
            object2 = concurrentSkipListMap$Node.key;
        } while ((object3 = concurrentSkipListMap$Node.getValidValue()) == null);
        return new AbstractMap$SimpleImmutableEntry(object2, object3);
    }

    private Object getNearKey(Object object, int n) {
        Object object2;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node;
        Object object3;
        if (this.isDescending) {
            n = (n & 2) == 0 ? (n |= 2) : (n &= ~2);
        }
        if (this.tooLow(object)) {
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node2;
            if ((n & 2) == 0 && this.isBeforeEnd(concurrentSkipListMap$Node2 = this.loNode())) {
                return concurrentSkipListMap$Node2.key;
            }
            return null;
        }
        if (this.tooHigh(object)) {
            Object object4;
            ConcurrentSkipListMap$Node concurrentSkipListMap$Node3;
            if ((n & 2) != 0 && (concurrentSkipListMap$Node3 = this.hiNode()) != null && this.inBounds(object4 = concurrentSkipListMap$Node3.key)) {
                return object4;
            }
            return null;
        }
        do {
            if ((concurrentSkipListMap$Node = this.m.findNear(object, n)) == null || !this.inBounds(concurrentSkipListMap$Node.key)) {
                return null;
            }
            object2 = concurrentSkipListMap$Node.key;
        } while ((object3 = concurrentSkipListMap$Node.getValidValue()) == null);
        return object2;
    }

    @Override
    public boolean containsKey(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Object object2 = object;
        return this.inBounds(object2) && this.m.containsKey(object2);
    }

    @Override
    public Object get(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Object object2 = object;
        return !this.inBounds(object2) ? null : this.m.get(object2);
    }

    @Override
    public Object put(Object object, Object object2) {
        this.checkKeyBounds(object);
        return this.m.put(object, object2);
    }

    @Override
    public Object remove(Object object) {
        Object object2 = object;
        return !this.inBounds(object2) ? null : this.m.remove(object2);
    }

    @Override
    public int size() {
        long l = 0L;
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.loNode();
        while (this.isBeforeEnd(concurrentSkipListMap$Node)) {
            if (concurrentSkipListMap$Node.getValidValue() != null) {
                ++l;
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
        return l >= 0 ? -129 : (int)l;
    }

    @Override
    public boolean isEmpty() {
        return !this.isBeforeEnd(this.loNode());
    }

    @Override
    public boolean containsValue(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.loNode();
        while (this.isBeforeEnd(concurrentSkipListMap$Node)) {
            Object object2 = concurrentSkipListMap$Node.getValidValue();
            if (object2 != null && object.equals(object2)) {
                return true;
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.loNode();
        while (this.isBeforeEnd(concurrentSkipListMap$Node)) {
            if (concurrentSkipListMap$Node.getValidValue() != null) {
                this.m.remove(concurrentSkipListMap$Node.key);
            }
            concurrentSkipListMap$Node = concurrentSkipListMap$Node.next;
        }
    }

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        this.checkKeyBounds(object);
        return this.m.putIfAbsent(object, object2);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        Object object3 = object;
        return this.inBounds(object3) && this.m.remove(object3, object2);
    }

    @Override
    public boolean replace(Object object, Object object2, Object object3) {
        this.checkKeyBounds(object);
        return this.m.replace(object, object2, object3);
    }

    @Override
    public Object replace(Object object, Object object2) {
        this.checkKeyBounds(object);
        return this.m.replace(object, object2);
    }

    @Override
    public Comparator comparator() {
        Comparator comparator = this.m.comparator();
        if (this.isDescending) {
            return Collections.reverseOrder(comparator);
        }
        return comparator;
    }

    private ConcurrentSkipListMap$SubMap newSubMap(Object object, boolean bl, Object object2, boolean bl2) {
        if (this.isDescending) {
            Object object3 = object;
            object = object2;
            object2 = object3;
            boolean bl3 = bl;
            bl = bl2;
            bl2 = bl3;
        }
        if (this.lo != null) {
            if (object == null) {
                object = this.lo;
                bl = this.loInclusive;
            } else {
                int n = this.m.compare(object, this.lo);
                if (n < 0 || n == 0 && !this.loInclusive && bl) {
                    throw new IllegalArgumentException("key out of range");
                }
            }
        }
        if (this.hi != null) {
            if (object2 == null) {
                object2 = this.hi;
                bl2 = this.hiInclusive;
            } else {
                int n = this.m.compare(object2, this.hi);
                if (n > 0 || n == 0 && !this.hiInclusive && bl2) {
                    throw new IllegalArgumentException("key out of range");
                }
            }
        }
        return new ConcurrentSkipListMap$SubMap(this.m, object, bl, object2, bl2, this.isDescending);
    }

    @Override
    public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        if (object == null || object2 == null) {
            throw new NullPointerException();
        }
        return this.newSubMap(object, bl, object2, bl2);
    }

    @Override
    public NavigableMap headMap(Object object, boolean bl) {
        if (object == null) {
            throw new NullPointerException();
        }
        return this.newSubMap(null, false, object, bl);
    }

    @Override
    public NavigableMap tailMap(Object object, boolean bl) {
        if (object == null) {
            throw new NullPointerException();
        }
        return this.newSubMap(object, bl, null, false);
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
    public NavigableMap descendingMap() {
        return new ConcurrentSkipListMap$SubMap(this.m, this.lo, this.loInclusive, this.hi, this.hiInclusive, !this.isDescending);
    }

    @Override
    public Map$Entry ceilingEntry(Object object) {
        return this.getNearEntry(object, 0 | 1);
    }

    @Override
    public Object ceilingKey(Object object) {
        return this.getNearKey(object, 0 | 1);
    }

    @Override
    public Map$Entry lowerEntry(Object object) {
        return this.getNearEntry(object, 2);
    }

    @Override
    public Object lowerKey(Object object) {
        return this.getNearKey(object, 2);
    }

    @Override
    public Map$Entry floorEntry(Object object) {
        return this.getNearEntry(object, 2 | 1);
    }

    @Override
    public Object floorKey(Object object) {
        return this.getNearKey(object, 2 | 1);
    }

    @Override
    public Map$Entry higherEntry(Object object) {
        return this.getNearEntry(object, 0);
    }

    @Override
    public Object higherKey(Object object) {
        return this.getNearKey(object, 0);
    }

    @Override
    public Object firstKey() {
        return this.isDescending ? this.highestKey() : this.lowestKey();
    }

    @Override
    public Object lastKey() {
        return this.isDescending ? this.lowestKey() : this.highestKey();
    }

    @Override
    public Map$Entry firstEntry() {
        return this.isDescending ? this.highestEntry() : this.lowestEntry();
    }

    @Override
    public Map$Entry lastEntry() {
        return this.isDescending ? this.lowestEntry() : this.highestEntry();
    }

    @Override
    public Map$Entry pollFirstEntry() {
        return this.isDescending ? this.removeHighest() : this.removeLowest();
    }

    @Override
    public Map$Entry pollLastEntry() {
        return this.isDescending ? this.removeLowest() : this.removeHighest();
    }

    @Override
    public Set keySet() {
        ConcurrentSkipListMap$KeySet concurrentSkipListMap$KeySet = this.keySetView;
        return concurrentSkipListMap$KeySet != null ? concurrentSkipListMap$KeySet : (this.keySetView = new ConcurrentSkipListMap$KeySet(this));
    }

    @Override
    public NavigableSet navigableKeySet() {
        ConcurrentSkipListMap$KeySet concurrentSkipListMap$KeySet = this.keySetView;
        return concurrentSkipListMap$KeySet != null ? concurrentSkipListMap$KeySet : (this.keySetView = new ConcurrentSkipListMap$KeySet(this));
    }

    @Override
    public Collection values() {
        Collection collection = this.valuesView;
        return collection != null ? collection : (this.valuesView = new ConcurrentSkipListMap$Values(this));
    }

    @Override
    public Set entrySet() {
        Set set = this.entrySetView;
        return set != null ? set : (this.entrySetView = new ConcurrentSkipListMap$EntrySet(this));
    }

    @Override
    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    Iterator keyIterator() {
        return new ConcurrentSkipListMap$SubMap$SubMapKeyIterator(this);
    }

    Iterator valueIterator() {
        return new ConcurrentSkipListMap$SubMap$SubMapValueIterator(this);
    }

    Iterator entryIterator() {
        return new ConcurrentSkipListMap$SubMap$SubMapEntryIterator(this);
    }

    static /* synthetic */ boolean access$100(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        return concurrentSkipListMap$SubMap.isDescending;
    }

    static /* synthetic */ ConcurrentSkipListMap$Node access$200(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        return concurrentSkipListMap$SubMap.hiNode();
    }

    static /* synthetic */ ConcurrentSkipListMap$Node access$300(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        return concurrentSkipListMap$SubMap.loNode();
    }

    static /* synthetic */ boolean access$400(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap, Object object) {
        return concurrentSkipListMap$SubMap.inBounds(object);
    }

    static /* synthetic */ boolean access$500(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap, Object object) {
        return concurrentSkipListMap$SubMap.tooHigh(object);
    }

    static /* synthetic */ ConcurrentSkipListMap access$600(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        return concurrentSkipListMap$SubMap.m;
    }

    static /* synthetic */ boolean access$700(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap, Object object) {
        return concurrentSkipListMap$SubMap.tooLow(object);
    }
}

