/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Index;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;

final class ConcurrentSkipListMap$HeadIndex
extends ConcurrentSkipListMap$Index {
    final int level;

    ConcurrentSkipListMap$HeadIndex(ConcurrentSkipListMap$Node concurrentSkipListMap$Node, ConcurrentSkipListMap$Index concurrentSkipListMap$Index, ConcurrentSkipListMap$Index concurrentSkipListMap$Index2, int n) {
        super(concurrentSkipListMap$Node, concurrentSkipListMap$Index, concurrentSkipListMap$Index2);
        this.level = n;
    }
}

