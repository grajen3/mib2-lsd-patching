/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Iter;

final class ConcurrentSkipListMap$ValueIterator
extends ConcurrentSkipListMap$Iter {
    private final /* synthetic */ ConcurrentSkipListMap this$0;

    ConcurrentSkipListMap$ValueIterator(ConcurrentSkipListMap concurrentSkipListMap) {
        this.this$0 = concurrentSkipListMap;
        super(concurrentSkipListMap);
    }

    @Override
    public Object next() {
        Object object = this.nextValue;
        this.advance();
        return object;
    }
}

