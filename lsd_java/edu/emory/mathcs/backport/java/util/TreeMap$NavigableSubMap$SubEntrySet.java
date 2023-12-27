/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap$SubEntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;

class TreeMap$NavigableSubMap$SubEntrySet
extends AbstractSet {
    private final /* synthetic */ TreeMap$NavigableSubMap this$1;

    TreeMap$NavigableSubMap$SubEntrySet(TreeMap$NavigableSubMap treeMap$NavigableSubMap) {
        this.this$1 = treeMap$NavigableSubMap;
    }

    @Override
    public int size() {
        return this.this$1.size();
    }

    @Override
    public boolean isEmpty() {
        return this.this$1.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return TreeMap$NavigableSubMap.access$2100(this.this$1, object) != null;
    }

    @Override
    public boolean remove(Object object) {
        TreeMap$Entry treeMap$Entry = TreeMap$NavigableSubMap.access$2100(this.this$1, object);
        if (treeMap$Entry == null) {
            return false;
        }
        TreeMap.access$1000(TreeMap$NavigableSubMap.access$2200(this.this$1), treeMap$Entry);
        return true;
    }

    @Override
    public Iterator iterator() {
        return new TreeMap$NavigableSubMap$SubEntryIterator(this.this$1);
    }
}

