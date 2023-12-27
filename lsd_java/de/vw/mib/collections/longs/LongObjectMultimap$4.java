/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.longs.LongObjectMultimap;
import java.util.Collection;
import java.util.Iterator;

class LongObjectMultimap$4
implements ObjectCollection {
    private final /* synthetic */ LongObjectMultimap this$0;

    LongObjectMultimap$4(LongObjectMultimap longObjectMultimap) {
        this.this$0 = longObjectMultimap;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.this$0.valuesToArray(objectArray);
    }

    @Override
    public Object[] toArray() {
        return this.this$0.valuesToArray();
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
        return this.this$0.valueIterator();
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
        return this.this$0.containsValue(object);
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

