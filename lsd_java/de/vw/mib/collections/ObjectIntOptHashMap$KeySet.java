/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ObjectIntOptHashMap$KeyIterator;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.ObjectSet;
import de.vw.mib.collections.SyncObjectSet;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class ObjectIntOptHashMap$KeySet
implements ObjectSet {
    private final /* synthetic */ ObjectIntOptHashMap this$0;

    public ObjectIntOptHashMap$KeySet(ObjectIntOptHashMap objectIntOptHashMap) {
        this.this$0 = objectIntOptHashMap;
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public Object get(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new ObjectIntOptHashMap$KeyIterator(this.this$0);
    }

    @Override
    public boolean remove(Object object) {
        if (this.this$0.containsKey(object)) {
            this.this$0.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection collection) {
        ObjectIterator objectIterator = (ObjectIterator)collection.iterator();
        while (objectIterator.hasNext()) {
            if (this.contains(objectIterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean bl = false;
        ObjectIterator objectIterator = (ObjectIterator)collection.iterator();
        while (objectIterator.hasNext()) {
            bl |= this.remove(objectIterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean bl = false;
        ObjectIterator objectIterator = (ObjectIterator)this.iterator();
        while (objectIterator.hasNext()) {
            if (collection.contains(objectIterator.next())) continue;
            objectIterator.remove();
            bl = true;
        }
        return bl;
    }

    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.this$0.size]);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (objectArray.length < this.this$0.size) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.this$0.size);
        }
        ObjectIterator objectIterator = (ObjectIterator)this.iterator();
        for (int i2 = 0; i2 < this.this$0.size; ++i2) {
            objectArray2[i2] = objectIterator.next();
        }
        return objectArray2;
    }

    @Override
    public ObjectSet synchronize() {
        return new SyncObjectSet(this, this.this$0);
    }
}

