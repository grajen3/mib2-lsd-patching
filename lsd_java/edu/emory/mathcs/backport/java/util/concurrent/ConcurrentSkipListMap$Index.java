/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;

class ConcurrentSkipListMap$Index {
    final ConcurrentSkipListMap$Node node;
    final ConcurrentSkipListMap$Index down;
    volatile ConcurrentSkipListMap$Index right;

    ConcurrentSkipListMap$Index(ConcurrentSkipListMap$Node concurrentSkipListMap$Node, ConcurrentSkipListMap$Index concurrentSkipListMap$Index, ConcurrentSkipListMap$Index concurrentSkipListMap$Index2) {
        this.node = concurrentSkipListMap$Node;
        this.down = concurrentSkipListMap$Index;
        this.right = concurrentSkipListMap$Index2;
    }

    final synchronized boolean casRight(ConcurrentSkipListMap$Index concurrentSkipListMap$Index, ConcurrentSkipListMap$Index concurrentSkipListMap$Index2) {
        if (this.right == concurrentSkipListMap$Index) {
            this.right = concurrentSkipListMap$Index2;
            return true;
        }
        return false;
    }

    final boolean indexesDeletedNode() {
        return this.node.value == null;
    }

    final boolean link(ConcurrentSkipListMap$Index concurrentSkipListMap$Index, ConcurrentSkipListMap$Index concurrentSkipListMap$Index2) {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.node;
        concurrentSkipListMap$Index2.right = concurrentSkipListMap$Index;
        return concurrentSkipListMap$Node.value != null && this.casRight(concurrentSkipListMap$Index, concurrentSkipListMap$Index2);
    }

    final boolean unlink(ConcurrentSkipListMap$Index concurrentSkipListMap$Index) {
        return !this.indexesDeletedNode() && this.casRight(concurrentSkipListMap$Index, concurrentSkipListMap$Index.right);
    }
}

