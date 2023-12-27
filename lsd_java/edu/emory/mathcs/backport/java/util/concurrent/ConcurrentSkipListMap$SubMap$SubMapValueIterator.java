/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap$SubMapIter;

final class ConcurrentSkipListMap$SubMap$SubMapValueIterator
extends ConcurrentSkipListMap$SubMap$SubMapIter {
    private final /* synthetic */ ConcurrentSkipListMap$SubMap this$0;

    ConcurrentSkipListMap$SubMap$SubMapValueIterator(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        this.this$0 = concurrentSkipListMap$SubMap;
        super(concurrentSkipListMap$SubMap);
    }

    @Override
    public Object next() {
        Object object = this.nextValue;
        this.advance();
        return object;
    }
}

