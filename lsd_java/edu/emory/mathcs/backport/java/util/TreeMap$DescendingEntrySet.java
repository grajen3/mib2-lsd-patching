/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$DescendingEntryIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$EntrySet;
import java.util.Iterator;

class TreeMap$DescendingEntrySet
extends TreeMap$EntrySet {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$DescendingEntrySet(TreeMap treeMap) {
        this.this$0 = treeMap;
        super(treeMap);
    }

    @Override
    public Iterator iterator() {
        return new TreeMap$DescendingEntryIterator(this.this$0, TreeMap.access$1300(this.this$0));
    }
}

