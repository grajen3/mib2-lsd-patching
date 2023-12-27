/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$KeyIterator;
import java.util.Iterator;

final class ConcurrentHashMap$KeySet
extends AbstractSet {
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$KeySet(ConcurrentHashMap concurrentHashMap) {
        this.this$0 = concurrentHashMap;
    }

    @Override
    public Iterator iterator() {
        return new ConcurrentHashMap$KeyIterator(this.this$0);
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.this$0.remove(object) != null;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

