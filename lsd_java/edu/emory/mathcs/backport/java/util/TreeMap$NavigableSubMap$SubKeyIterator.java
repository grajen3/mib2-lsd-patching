/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap$NavigableSubMap;
import java.util.Iterator;
import java.util.Map$Entry;

class TreeMap$NavigableSubMap$SubKeyIterator
implements Iterator {
    final Iterator itr;
    private final /* synthetic */ TreeMap$NavigableSubMap this$1;

    TreeMap$NavigableSubMap$SubKeyIterator(TreeMap$NavigableSubMap treeMap$NavigableSubMap, Iterator iterator) {
        this.this$1 = treeMap$NavigableSubMap;
        this.itr = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.itr.hasNext();
    }

    @Override
    public Object next() {
        return ((Map$Entry)this.itr.next()).getKey();
    }

    @Override
    public void remove() {
        this.itr.remove();
    }
}

