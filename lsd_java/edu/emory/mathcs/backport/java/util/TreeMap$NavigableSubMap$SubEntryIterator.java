/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$BaseEntryIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeMap$NavigableSubMap$SubEntryIterator
extends TreeMap$BaseEntryIterator
implements Iterator {
    final Object terminalKey;
    private final /* synthetic */ TreeMap$NavigableSubMap this$1;

    TreeMap$NavigableSubMap$SubEntryIterator(TreeMap$NavigableSubMap treeMap$NavigableSubMap) {
        this.this$1 = treeMap$NavigableSubMap;
        super(TreeMap$NavigableSubMap.access$2200(treeMap$NavigableSubMap), treeMap$NavigableSubMap.first());
        TreeMap$Entry treeMap$Entry = treeMap$NavigableSubMap.last();
        this.terminalKey = treeMap$Entry == null ? null : TreeMap$Entry.access$400(treeMap$Entry);
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public Object next() {
        TreeMap$Entry treeMap$Entry = this.cursor;
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        if (this.expectedModCount != TreeMap.access$700(TreeMap$NavigableSubMap.access$2200(this.this$1))) {
            throw new ConcurrentModificationException();
        }
        this.cursor = TreeMap$Entry.access$400(treeMap$Entry) == this.terminalKey ? null : this.this$1.uncheckedHigher(treeMap$Entry);
        this.lastRet = treeMap$Entry;
        return treeMap$Entry;
    }
}

