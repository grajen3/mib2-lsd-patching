/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedMap;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedMap;

class Collections$CheckedSortedMap
extends Collections$CheckedMap
implements SortedMap,
Serializable {
    final SortedMap map;

    Collections$CheckedSortedMap(SortedMap sortedMap, Class clazz, Class clazz2) {
        super(sortedMap, clazz, clazz2);
        this.map = sortedMap;
    }

    @Override
    public Comparator comparator() {
        return this.map.comparator();
    }

    @Override
    public Object firstKey() {
        return this.map.firstKey();
    }

    @Override
    public Object lastKey() {
        return this.map.lastKey();
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        return new Collections$CheckedSortedMap(this.map.subMap(object, object2), this.keyType, this.valueType);
    }

    @Override
    public SortedMap headMap(Object object) {
        return new Collections$CheckedSortedMap(this.map.headMap(object), this.keyType, this.valueType);
    }

    @Override
    public SortedMap tailMap(Object object) {
        return new Collections$CheckedSortedMap(this.map.tailMap(object), this.keyType, this.valueType);
    }
}

