/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractCollection;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$ValueIterator;
import java.util.Iterator;

final class ConcurrentHashMap$Values
extends AbstractCollection {
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$Values(ConcurrentHashMap concurrentHashMap) {
        this.this$0 = concurrentHashMap;
    }

    @Override
    public Iterator iterator() {
        return new ConcurrentHashMap$ValueIterator(this.this$0);
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

