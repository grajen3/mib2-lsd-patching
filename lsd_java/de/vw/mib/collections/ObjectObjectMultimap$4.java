/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectObjectMultimap;
import java.util.Collection;
import java.util.Iterator;

class ObjectObjectMultimap$4
implements ObjectCollection {
    private final /* synthetic */ ObjectObjectMultimap this$0;

    ObjectObjectMultimap$4(ObjectObjectMultimap objectObjectMultimap) {
        this.this$0 = objectObjectMultimap;
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

