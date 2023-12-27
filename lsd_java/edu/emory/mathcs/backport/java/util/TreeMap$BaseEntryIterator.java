/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import edu.emory.mathcs.backport.java.util.TreeMap$Entry;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

class TreeMap$BaseEntryIterator {
    TreeMap$Entry cursor;
    TreeMap$Entry lastRet;
    int expectedModCount;
    private final /* synthetic */ TreeMap this$0;

    TreeMap$BaseEntryIterator(TreeMap treeMap, TreeMap$Entry treeMap$Entry) {
        this.this$0 = treeMap;
        this.cursor = treeMap$Entry;
        this.expectedModCount = TreeMap.access$700(treeMap);
    }

    public boolean hasNext() {
        return this.cursor != null;
    }

    TreeMap$Entry nextEntry() {
        TreeMap$Entry treeMap$Entry = this.cursor;
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        if (this.expectedModCount != TreeMap.access$700(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        this.cursor = TreeMap.access$800(treeMap$Entry);
        this.lastRet = treeMap$Entry;
        return treeMap$Entry;
    }

    TreeMap$Entry prevEntry() {
        TreeMap$Entry treeMap$Entry = this.cursor;
        if (treeMap$Entry == null) {
            throw new NoSuchElementException();
        }
        if (this.expectedModCount != TreeMap.access$700(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        this.cursor = TreeMap.access$900(treeMap$Entry);
        this.lastRet = treeMap$Entry;
        return treeMap$Entry;
    }

    public void remove() {
        if (this.lastRet == null) {
            throw new IllegalStateException();
        }
        if (this.expectedModCount != TreeMap.access$700(this.this$0)) {
            throw new ConcurrentModificationException();
        }
        if (TreeMap$Entry.access$000(this.lastRet) != null && TreeMap$Entry.access$200(this.lastRet) != null && this.cursor != null) {
            this.cursor = this.lastRet;
        }
        TreeMap.access$1000(this.this$0, this.lastRet);
        this.lastRet = null;
        ++this.expectedModCount;
    }
}

