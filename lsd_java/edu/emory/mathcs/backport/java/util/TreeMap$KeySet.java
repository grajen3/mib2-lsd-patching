/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import java.util.AbstractSet;
import java.util.SortedSet;

abstract class TreeMap$KeySet
extends AbstractSet
implements NavigableSet {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$KeySet(TreeMap treeMap) {
        this.this$0 = treeMap;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(Object object) {
        return TreeMap.access$1400(this.this$0, object) != null;
    }

    @Override
    public boolean remove(Object object) {
        TreeMap$Entry treeMap$Entry = TreeMap.access$1400(this.this$0, object);
        if (treeMap$Entry == null) {
            return false;
        }
        TreeMap.access$1000(this.this$0, treeMap$Entry);
        return true;
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    @Override
    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }
}

