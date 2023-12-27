/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentHashMap$EntryIterator;
import java.util.Iterator;
import java.util.Map$Entry;

final class ConcurrentHashMap$EntrySet
extends AbstractSet {
    private final /* synthetic */ ConcurrentHashMap this$0;

    ConcurrentHashMap$EntrySet(ConcurrentHashMap concurrentHashMap) {
        this.this$0 = concurrentHashMap;
    }

    @Override
    public Iterator iterator() {
        return new ConcurrentHashMap$EntryIterator(this.this$0);
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        Object object2 = this.this$0.get(map$Entry.getKey());
        return object2 != null && object2.equals(map$Entry.getValue());
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        return this.this$0.remove(map$Entry.getKey(), map$Entry.getValue());
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

