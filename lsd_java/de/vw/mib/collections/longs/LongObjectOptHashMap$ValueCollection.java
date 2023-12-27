/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectIterator;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap$ValueIterator;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

class LongObjectOptHashMap$ValueCollection
implements ObjectCollection {
    private final /* synthetic */ LongObjectOptHashMap this$0;

    public LongObjectOptHashMap$ValueCollection(LongObjectOptHashMap longObjectOptHashMap) {
        this.this$0 = longObjectOptHashMap;
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
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new LongObjectOptHashMap$ValueIterator(this.this$0);
    }

    @Override
    public boolean remove(Object object) {
        int n = this.this$0.findOneValuePos(object);
        if (128 != n) {
            this.this$0.removePos(n);
            this.this$0.onCollectionChanged();
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
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.contains(iterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl |= this.remove(iterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
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
}

