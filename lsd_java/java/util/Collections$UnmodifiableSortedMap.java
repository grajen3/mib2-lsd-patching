/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableMap;
import java.util.Comparator;
import java.util.SortedMap;

class Collections$UnmodifiableSortedMap
extends Collections$UnmodifiableMap
implements SortedMap {
    private static final long serialVersionUID;
    private final SortedMap sm;

    Collections$UnmodifiableSortedMap(SortedMap sortedMap) {
        super(sortedMap);
        this.sm = sortedMap;
    }

    @Override
    public Comparator comparator() {
        return this.sm.comparator();
    }

    @Override
    public Object firstKey() {
        return this.sm.firstKey();
    }

    @Override
    public SortedMap headMap(Object object) {
        return new Collections$UnmodifiableSortedMap(this.sm.headMap(object));
    }

    @Override
    public Object lastKey() {
        return this.sm.lastKey();
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        return new Collections$UnmodifiableSortedMap(this.sm.subMap(object, object2));
    }

    @Override
    public SortedMap tailMap(Object object) {
        return new Collections$UnmodifiableSortedMap(this.sm.tailMap(object));
    }
}

