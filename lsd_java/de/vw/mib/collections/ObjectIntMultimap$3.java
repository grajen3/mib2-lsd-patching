/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntMultimap;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.SyncObjectSet;
import java.util.Collection;
import java.util.Iterator;

class ObjectIntMultimap$3
implements ObjectSet {
    private final /* synthetic */ ObjectIntMultimap this$0;

    ObjectIntMultimap$3(ObjectIntMultimap objectIntMultimap) {
        this.this$0 = objectIntMultimap;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.this$0.keysToArray(objectArray);
    }

    @Override
    public Object[] toArray() {
        return this.this$0.keysToArray();
    }

    @Override
    public int size() {
        return this.this$0.backingMap.size();
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
        return this.this$0.keyIterator();
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
        return this.this$0.backingMap.containsKey(object);
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

    @Override
    public ObjectSet synchronize() {
        return new SyncObjectSet(this);
    }

    @Override
    public Object get(Object object) {
        return this.contains(object) ? object : ObjectIntMultimap.access$000(this.this$0);
    }
}

