/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractCollection;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentNavigableMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentSkipListMap$SubMap;
import java.util.Iterator;

final class ConcurrentSkipListMap$Values
extends AbstractCollection {
    private final ConcurrentNavigableMap m;

    ConcurrentSkipListMap$Values(ConcurrentNavigableMap concurrentNavigableMap) {
        this.m = concurrentNavigableMap;
    }

    @Override
    public Iterator iterator() {
        if (this.m instanceof ConcurrentSkipListMap) {
            return ((ConcurrentSkipListMap)this.m).valueIterator();
        }
        return ((ConcurrentSkipListMap$SubMap)this.m).valueIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override
    public int size() {
        return this.m.size();
    }

    @Override
    public boolean contains(Object object) {
        return this.m.containsValue(object);
    }

    @Override
    public void clear() {
        this.m.clear();
    }

    @Override
    public Object[] toArray() {
        return ConcurrentSkipListMap.toList(this).toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return ConcurrentSkipListMap.toList(this).toArray(objectArray);
    }
}

