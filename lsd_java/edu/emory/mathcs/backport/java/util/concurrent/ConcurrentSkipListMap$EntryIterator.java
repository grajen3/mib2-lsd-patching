/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Iter;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$Node;

final class ConcurrentSkipListMap$EntryIterator
extends ConcurrentSkipListMap$Iter {
    private final /* synthetic */ ConcurrentSkipListMap this$0;

    ConcurrentSkipListMap$EntryIterator(ConcurrentSkipListMap concurrentSkipListMap) {
        this.this$0 = concurrentSkipListMap;
        super(concurrentSkipListMap);
    }

    @Override
    public Object next() {
        ConcurrentSkipListMap$Node concurrentSkipListMap$Node = this.next;
        Object object = this.nextValue;
        this.advance();
        return new AbstractMap$SimpleImmutableEntry(concurrentSkipListMap$Node.key, object);
    }
}

