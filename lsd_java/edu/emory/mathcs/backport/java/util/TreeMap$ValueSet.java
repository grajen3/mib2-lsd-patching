/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$ValueIterator;
import java.util.AbstractSet;
import java.util.Iterator;

class TreeMap$ValueSet
extends AbstractSet {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$ValueSet(TreeMap treeMap) {
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
        TreeMap$Entry treeMap$Entry = TreeMap.access$1100(this.this$0);
        while (treeMap$Entry != null) {
            if (TreeMap.access$300(object, TreeMap$Entry.access$600(treeMap$Entry))) {
                return true;
            }
            treeMap$Entry = TreeMap.access$800(treeMap$Entry);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new TreeMap$ValueIterator(this.this$0, TreeMap.access$1100(this.this$0));
    }

    @Override
    public boolean remove(Object object) {
        TreeMap$Entry treeMap$Entry = TreeMap.access$1100(this.this$0);
        while (treeMap$Entry != null) {
            if (TreeMap.access$300(object, TreeMap$Entry.access$600(treeMap$Entry))) {
                TreeMap.access$1000(this.this$0, treeMap$Entry);
                return true;
            }
            treeMap$Entry = TreeMap.access$800(treeMap$Entry);
        }
        return false;
    }
}

