/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectMultimap;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class IntObjectMultimap$2
implements Set {
    private final /* synthetic */ IntObjectMultimap this$0;

    IntObjectMultimap$2(IntObjectMultimap intObjectMultimap) {
        this.this$0 = intObjectMultimap;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (objectArray.length < this.size()) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.size());
        }
        Iterator iterator = this.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            objectArray2[n] = iterator.next();
            ++n;
        }
        return objectArray2;
    }

    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object object) {
        if (object instanceof IntObjectMap$Entry) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)object;
            return this.this$0.containsKeyValuePair(intObjectMap$Entry.getKey(), intObjectMap$Entry.getValue());
        }
        return false;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }
}

