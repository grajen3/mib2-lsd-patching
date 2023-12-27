/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$HashEntry;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$HashIterator;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$WriteThroughEntry;
import java.util.Iterator;

final class ConcurrentHashMap$EntryIterator
extends ConcurrentHashMap$HashIterator
implements Iterator {
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$EntryIterator(ConcurrentHashMap concurrentHashMap) {
        this.this$0 = concurrentHashMap;
        super(concurrentHashMap);
    }

    @Override
    public Object next() {
        ConcurrentHashMap$HashEntry concurrentHashMap$HashEntry = super.nextEntry();
        return new ConcurrentHashMap$WriteThroughEntry(this.this$0, concurrentHashMap$HashEntry.key, concurrentHashMap$HashEntry.value);
    }
}

