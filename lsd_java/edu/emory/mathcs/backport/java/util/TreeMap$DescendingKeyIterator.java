/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$BaseEntryIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import java.util.Iterator;

class TreeMap$DescendingKeyIterator
extends TreeMap$BaseEntryIterator
implements Iterator {
    private final /* synthetic */ TreeMap this$0;

    TreeMap$DescendingKeyIterator(TreeMap treeMap, TreeMap$Entry treeMap$Entry) {
        this.this$0 = treeMap;
        super(treeMap, treeMap$Entry);
    }

    @Override
    public Object next() {
        return TreeMap$Entry.access$400(this.prevEntry());
    }
}

