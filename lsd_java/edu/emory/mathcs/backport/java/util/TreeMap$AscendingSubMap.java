/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$DescendingSubMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap;
import java.util.Comparator;

class TreeMap$AscendingSubMap
extends TreeMap$NavigableSubMap {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$AscendingSubMap(TreeMap treeMap, boolean bl, Object object, boolean bl2, boolean bl3, Object object2, boolean bl4) {
        this.this$0 = treeMap;
        super(treeMap, bl, object, bl2, bl3, object2, bl4);
    }

    @Override
    public Comparator comparator() {
        return TreeMap.access$1500(this.this$0);
    }

    @Override
    protected TreeMap$Entry first() {
        return this.absLowest();
    }

    @Override
    protected TreeMap$Entry last() {
        return this.absHighest();
    }

    @Override
    protected TreeMap$Entry lower(Object object) {
        return this.absLower(object);
    }

    @Override
    protected TreeMap$Entry floor(Object object) {
        return this.absFloor(object);
    }

    @Override
    protected TreeMap$Entry ceiling(Object object) {
        return this.absCeiling(object);
    }

    @Override
    protected TreeMap$Entry higher(Object object) {
        return this.absHigher(object);
    }

    @Override
    protected TreeMap$Entry uncheckedHigher(TreeMap$Entry treeMap$Entry) {
        return TreeMap.access$800(treeMap$Entry);
    }

    @Override
    public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
        if (!this.inRange(object, bl)) {
            throw new IllegalArgumentException("fromKey out of range");
        }
        if (!this.inRange(object2, bl2)) {
            throw new IllegalArgumentException("toKey out of range");
        }
        return new TreeMap$AscendingSubMap(this.this$0, false, object, bl, false, object2, bl2);
    }

    @Override
    public NavigableMap headMap(Object object, boolean bl) {
        if (!this.inRange(object, bl)) {
            throw new IllegalArgumentException("toKey out of range");
        }
        return new TreeMap$AscendingSubMap(this.this$0, this.fromStart, this.fromKey, this.fromInclusive, false, object, bl);
    }

    @Override
    public NavigableMap tailMap(Object object, boolean bl) {
        if (!this.inRange(object, bl)) {
            throw new IllegalArgumentException("fromKey out of range");
        }
        return new TreeMap$AscendingSubMap(this.this$0, false, object, bl, this.toEnd, this.toKey, this.toInclusive);
    }

    @Override
    public NavigableMap descendingMap() {
        if (this.descendingMap == null) {
            this.descendingMap = new TreeMap$DescendingSubMap(this.this$0, this.fromStart, this.fromKey, this.fromInclusive, this.toEnd, this.toKey, this.toInclusive);
        }
        return this.descendingMap;
    }
}

