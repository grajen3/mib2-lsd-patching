/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ObjectIntOptHashMap$Entry;
import de.vw.mib.collections.ObjectIntOptHashMap$EntryIterator;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class ObjectIntOptHashMap$EntrySet
implements Set {
    private final /* synthetic */ ObjectIntOptHashMap this$0;

    public ObjectIntOptHashMap$EntrySet(ObjectIntOptHashMap objectIntOptHashMap) {
        this.this$0 = objectIntOptHashMap;
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(Object object) {
        return this.containsWhere(object) != 128;
    }

    private int containsWhere(Object object) {
        if (!(object instanceof ObjectIntOptHashMap$Entry)) {
            return 128;
        }
        ObjectIntOptHashMap$Entry objectIntOptHashMap$Entry = (ObjectIntOptHashMap$Entry)object;
        int n = this.this$0.findKey(objectIntOptHashMap$Entry.getKey());
        int n2 = objectIntOptHashMap$Entry.getValue();
        if (n != 128 && this.this$0.values[n] == n2) {
            return n;
        }
        return 128;
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
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new ObjectIntOptHashMap$EntryIterator(this.this$0);
    }

    @Override
    public boolean remove(Object object) {
        int n = this.containsWhere(object);
        if (128 != n) {
            this.this$0.removePos(n);
            this.this$0.onCollectionChanged();
            return true;
        }
        return false;
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
    public int size() {
        return this.this$0.size();
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
        Iterator iterator = this.iterator();
        for (int i2 = 0; i2 < this.this$0.size; ++i2) {
            objectArray2[i2] = iterator.next();
        }
        return objectArray2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(string).append(iterator.next().toString());
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }
}

