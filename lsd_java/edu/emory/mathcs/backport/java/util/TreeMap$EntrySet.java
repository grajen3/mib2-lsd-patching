/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$EntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;

class TreeMap$EntrySet
extends AbstractSet {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$EntrySet(TreeMap treeMap) {
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
    public Iterator iterator() {
        return new TreeMap$EntryIterator(this.this$0, TreeMap.access$1100(this.this$0));
    }

    @Override
    public boolean contains(Object object) {
        return TreeMap.access$1200(this.this$0, object) != null;
    }

    @Override
    public boolean remove(Object object) {
        TreeMap$Entry treeMap$Entry = TreeMap.access$1200(this.this$0, object);
        if (treeMap$Entry == null) {
            return false;
        }
        TreeMap.access$1000(this.this$0, treeMap$Entry);
        return true;
    }
}

