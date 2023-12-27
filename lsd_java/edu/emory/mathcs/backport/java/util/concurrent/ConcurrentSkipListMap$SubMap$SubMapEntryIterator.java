/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap$SubMapIter;

final class ConcurrentSkipListMap$SubMap$SubMapEntryIterator
extends ConcurrentSkipListMap$SubMap$SubMapIter {
    private final /* synthetic */ ConcurrentSkipListMap$SubMap this$0;

    ConcurrentSkipListMap$SubMap$SubMapEntryIterator(ConcurrentSkipListMap$SubMap concurrentSkipListMap$SubMap) {
        this.this$0 = concurrentSkipListMap$SubMap;
        super(concurrentSkipListMap$SubMap);
    }

    @Override
    public Object next() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.next;
        Object object = this.nextValue;
        this.advance();
        return new AbstractMap$SimpleImmutableEntry(concurrentSkipListMap$Node.key, object);
    }
}

