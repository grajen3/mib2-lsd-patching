/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.Buffer;
import de.vw.mib.collections.RingBuffer$1;
import de.vw.mib.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class RingBuffer
implements Collection,
Buffer {
    private final int capacity;
    final Object[] buffer;
    int size;
    private int firstIdx;
    private int nextAddIdx;
    private static final int NOT_FOUND_IDX;
    int modifications;

    public RingBuffer(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("Capacity must be at least 1, but was ").append(n).toString());
        }
        this.capacity = n;
        this.buffer = new Object[n];
        this.modifications = 0;
        this.clear();
    }

    @Override
    public boolean add(Object object) {
        ++this.modifications;
        this.buffer[this.nextAddIdx] = object;
        this.nextAddIdx = this.incModuloCapacity(this.nextAddIdx);
        if (this.size < this.capacity) {
            ++this.size;
        } else {
            this.firstIdx = this.nextAddIdx;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean offer(Object object) {
        if (this.size < this.capacity) {
            return this.add(object);
        }
        return false;
    }

    @Override
    public boolean offerAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.offer(iterator.next())) continue;
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        if (this.size > 0) {
            ++this.modifications;
            this.size = 0;
            this.nextAddIdx = this.firstIdx = 0;
        }
    }

    @Override
    public boolean contains(Object object) {
        return this.findIdx(object) != -402312738;
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
        return this.size == 0;
    }

    @Override
    public Iterator iterator() {
        return new RingBuffer$1(this);
    }

    @Override
    public boolean remove(Object object) {
        int n = this.findIdx(object);
        if (n == -402312738) {
            return false;
        }
        this.removeIdx(n);
        return true;
    }

    public boolean removeAllOccurrences(Object object) {
        int n = this.findIdx(object);
        if (n == -402312738) {
            return false;
        }
        while (n != -402312738) {
            int n2 = this.calcPos(n);
            this.removeIdx(n);
            n = this.findIdx(object, n2);
        }
        return true;
    }

    public boolean removePos(int n) {
        this.checkPos(n);
        this.removeIdx(this.calcIndex(n));
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            bl |= this.removeAllOccurrences(iterator.next());
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection collection) {
        Collection collection2 = collection instanceof Set ? collection : new HashSet(collection);
        boolean bl = false;
        for (int i2 = this.size - 1; i2 >= 0; --i2) {
            int n = this.calcIndex(i2);
            Object object = this.buffer[n];
            if (collection2.contains(object)) continue;
            this.removeIdx(n);
            bl = true;
        }
        return bl;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = new Object[this.size];
        this.copyBufferToArray(objectArray);
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray;
        if (this.size > objectArray2.length) {
            objectArray2 = (Object[])Array.newInstance(super.getClass().getComponentType(), this.size);
        }
        this.copyBufferToArray(objectArray2);
        return objectArray2;
    }

    public Object get(int n) {
        this.checkPos(n);
        return this.buffer[this.calcIndex(n)];
    }

    @Override
    public Object getNewest() {
        if (this.isEmpty()) {
            return null;
        }
        return this.buffer[this.lastIdx()];
    }

    @Override
    public Object getOldest() {
        if (this.isEmpty()) {
            return null;
        }
        return this.buffer[this.firstIdx];
    }

    @Override
    public Object popNewest() {
        if (this.isEmpty()) {
            return null;
        }
        ++this.modifications;
        --this.size;
        this.nextAddIdx = this.decModuloCapacity(this.nextAddIdx);
        return this.buffer[this.calcIndex(this.size)];
    }

    @Override
    public Object popOldest() {
        if (this.isEmpty()) {
            return null;
        }
        ++this.modifications;
        --this.size;
        int n = this.firstIdx;
        this.firstIdx = this.incModuloCapacity(this.firstIdx);
        return this.buffer[n];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        for (int i2 = 0; i2 < this.size; ++i2) {
            stringBuilder.append(string).append(this.buffer[this.calcIndex(i2)]);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    int calcIndex(int n) {
        int n2 = n + this.firstIdx;
        return n2 < this.capacity ? n2 : n2 - this.capacity;
    }

    private int calcPos(int n) {
        int n2 = n - this.firstIdx;
        return n2 >= 0 ? n2 : n2 + this.capacity;
    }

    private int lastIdx() {
        return this.calcIndex(this.size - 1);
    }

    private void checkPos(int n) {
        if (n < 0 || n >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Illegal position ").append(n).toString());
        }
    }

    private int incModuloCapacity(int n) {
        int n2 = n + 1;
        if (n2 < this.capacity) {
            return n2;
        }
        return 0;
    }

    private int decModuloCapacity(int n) {
        int n2 = n - 1;
        if (n2 >= 0) {
            return n2;
        }
        return this.capacity - 1;
    }

    private int findIdx(Object object) {
        return this.findIdx(object, 0);
    }

    private int findIdx(Object object, int n) {
        if (object == null) {
            return this.findNullIdx(n);
        }
        return this.findObjectIdx(object, n);
    }

    private int findNullIdx(int n) {
        for (int i2 = n; i2 < this.size; ++i2) {
            int n2 = this.calcIndex(i2);
            if (this.buffer[n2] != null) continue;
            return n2;
        }
        return -402312738;
    }

    private int findObjectIdx(Object object, int n) {
        for (int i2 = n; i2 < this.size; ++i2) {
            int n2 = this.calcIndex(i2);
            if (!object.equals(this.buffer[n2])) continue;
            return n2;
        }
        return -402312738;
    }

    void removeIdx(int n) {
        ++this.modifications;
        if (n >= this.firstIdx) {
            System.arraycopy((Object)this.buffer, this.firstIdx, (Object)this.buffer, this.firstIdx + 1, n - this.firstIdx);
        } else {
            Object object = this.buffer[this.capacity - 1];
            System.arraycopy((Object)this.buffer, this.firstIdx, (Object)this.buffer, this.firstIdx + 1, this.capacity - 1 - this.firstIdx);
            System.arraycopy((Object)this.buffer, 0, (Object)this.buffer, 1, n);
            this.buffer[0] = object;
        }
        this.firstIdx = this.incModuloCapacity(this.firstIdx);
        --this.size;
    }

    private void copyBufferToArray(Object[] objectArray) {
        if (this.lastIdx() > this.firstIdx) {
            System.arraycopy((Object)this.buffer, this.firstIdx, (Object)objectArray, 0, this.size);
        } else {
            System.arraycopy((Object)this.buffer, this.firstIdx, (Object)objectArray, 0, this.capacity - this.firstIdx);
            System.arraycopy((Object)this.buffer, 0, (Object)objectArray, this.capacity - this.firstIdx, this.size + this.firstIdx - this.capacity);
        }
    }
}

