/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList$COWSubIterator;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class CopyOnWriteArrayList$COWSubList
implements Serializable,
List {
    private static final long serialVersionUID;
    final int offset;
    int length;
    transient Object[] expectedArray;
    private final /* synthetic */ CopyOnWriteArrayList this$0;

    CopyOnWriteArrayList$COWSubList(CopyOnWriteArrayList copyOnWriteArrayList, int n, int n2) {
        this.this$0 = copyOnWriteArrayList;
        this.offset = n;
        this.length = n2;
        this.expectedArray = copyOnWriteArrayList.getArray();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public boolean contains(Object object) {
        return CopyOnWriteArrayList.access$000(this.this$0.getArray(), object, this.offset, this.offset + this.length) >= 0;
    }

    @Override
    public Iterator iterator() {
        return this.listIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = this.this$0.getArray();
        Object[] objectArray2 = new Object[this.length];
        System.arraycopy((Object)objectArray, this.offset, (Object)objectArray2, 0, this.length);
        return objectArray2;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = this.this$0.getArray();
        if (objectArray.length < this.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), this.length);
            System.arraycopy((Object)objectArray2, this.offset, (Object)objectArray, 0, this.length);
        } else {
            System.arraycopy((Object)objectArray2, this.offset, (Object)objectArray, 0, this.length);
            if (objectArray.length > this.length) {
                objectArray[this.length] = null;
            }
        }
        return objectArray;
    }

    @Override
    public boolean add(Object object) {
        this.add(this.length, object);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n = objectArray.length;
            int n2 = CopyOnWriteArrayList.access$000(objectArray, object, this.offset, this.length);
            if (n2 < 0) {
                return false;
            }
            Object[] objectArray2 = new Object[n - 1];
            int n3 = this.length - n2 - 1;
            if (n2 > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n2 + 1, (Object)objectArray2, n2, n3);
            }
            this.this$0.setArray(objectArray2);
            this.expectedArray = objectArray2;
            --this.length;
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        Object[] objectArray = this.this$0.getArray();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (CopyOnWriteArrayList.access$000(objectArray, iterator.next(), this.offset, this.length) >= 0) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.addAll(this.length, collection);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(int n, Collection collection) {
        int n2 = collection.size();
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            int n3;
            if (n < 0 || n >= this.length) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
            }
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            if (n2 == 0) {
                return false;
            }
            int n4 = objectArray.length;
            Object[] objectArray2 = new Object[n4 + n2];
            int n5 = n3 = this.offset + n;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n3);
            int n6 = n4 - n3;
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                objectArray2[n5++] = iterator.next();
            }
            if (n6 > 0) {
                System.arraycopy((Object)objectArray, n3, (Object)objectArray2, n5, n6);
            }
            this.this$0.setArray(objectArray2);
            this.expectedArray = objectArray2;
            this.length += n2;
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n = objectArray.length;
            Object[] objectArray2 = new Object[this.length];
            int n2 = 0;
            for (int i2 = this.offset; i2 < this.offset + this.length; ++i2) {
                Object object = objectArray[i2];
                if (collection.contains(object)) continue;
                objectArray2[n2++] = object;
            }
            if (n2 == this.length) {
                return false;
            }
            Object[] objectArray3 = new Object[n + n2 - this.length];
            int n3 = n - this.offset - this.length;
            if (this.offset > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray3, 0, this.offset);
            }
            if (n2 > 0) {
                System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, this.offset, n2);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, this.offset + this.length, (Object)objectArray3, this.offset + n2, n3);
            }
            this.this$0.setArray(objectArray3);
            this.expectedArray = objectArray3;
            this.length = n2;
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(Collection collection) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n = objectArray.length;
            Object[] objectArray2 = new Object[this.length];
            int n2 = 0;
            for (int i2 = this.offset; i2 < this.offset + this.length; ++i2) {
                Object object = objectArray[i2];
                if (!collection.contains(object)) continue;
                objectArray2[n2++] = object;
            }
            if (n2 == this.length) {
                return false;
            }
            Object[] objectArray3 = new Object[n + n2 - this.length];
            int n3 = n - this.offset - this.length;
            if (this.offset > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray3, 0, this.offset);
            }
            if (n2 > 0) {
                System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, this.offset, n2);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, this.offset + this.length, (Object)objectArray3, this.offset + n2, n3);
            }
            this.this$0.setArray(objectArray3);
            this.expectedArray = objectArray3;
            this.length = n2;
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n - this.length];
            int n2 = n - this.offset - this.length;
            if (this.offset > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, this.offset);
            }
            if (n2 > 0) {
                System.arraycopy((Object)objectArray, this.offset + this.length, (Object)objectArray2, this.offset, n2);
            }
            this.this$0.setArray(objectArray2);
            this.expectedArray = objectArray2;
            this.length = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object object) {
        int n;
        Object[] objectArray;
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        Object object2 = this.this$0;
        synchronized (object2) {
            objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            n = this.offset + this.length;
        }
        object2 = ((List)object).listIterator();
        int n2 = this.offset;
        while (n2 < n && object2.hasNext()) {
            Object object3 = objectArray[n2];
            Object object4 = object2.next();
            if (CopyOnWriteArrayList.access$100(object3, object4)) continue;
            return false;
        }
        return n2 == n && !object2.hasNext();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int hashCode() {
        int n;
        Object[] objectArray;
        int n2 = 1;
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            n = this.offset + this.length;
        }
        for (int i2 = this.offset; i2 < n; ++i2) {
            Object object = objectArray[i2];
            n2 = 31 * n2 + (object == null ? 0 : object.hashCode());
        }
        return n2;
    }

    @Override
    public Object get(int n) {
        return this.this$0.getArray()[this.offset + n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object set(int n, Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            if (n < 0 || n >= this.length) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
            }
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n2 = objectArray.length;
            Object object2 = objectArray[this.offset + n];
            if (object2 == object) {
                this.this$0.setArray(objectArray);
            } else {
                Object[] objectArray2 = new Object[n2];
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
                objectArray2[this.offset + n] = object;
                this.this$0.setArray(objectArray2);
                this.expectedArray = objectArray2;
            }
            return object2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void add(int n, Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            if (n < 0 || n > this.length) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
            }
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n2 = objectArray.length;
            Object[] objectArray2 = new Object[n2 + 1];
            int n3 = this.offset + n;
            int n4 = n2 - n3;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n3);
            objectArray2[n3] = object;
            if (n4 > 0) {
                System.arraycopy((Object)objectArray, n3, (Object)objectArray2, n3 + 1, n4);
            }
            this.this$0.setArray(objectArray2);
            this.expectedArray = objectArray2;
            ++this.length;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object remove(int n) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            if (n < 0 || n >= this.length) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
            }
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            int n2 = objectArray.length;
            int n3 = this.offset + n;
            Object object = objectArray[n3];
            Object[] objectArray2 = new Object[n2 - 1];
            int n4 = n2 - n3 - 1;
            if (n > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n3);
            }
            if (n4 > 0) {
                System.arraycopy((Object)objectArray, n3 + 1, (Object)objectArray2, n3, n4);
            }
            this.this$0.setArray(objectArray2);
            this.expectedArray = objectArray2;
            --this.length;
            return object;
        }
    }

    @Override
    public int indexOf(Object object) {
        int n = CopyOnWriteArrayList.access$000(this.this$0.getArray(), object, this.offset, this.offset + this.length);
        return n >= 0 ? n - this.offset : -1;
    }

    public int indexOf(Object object, int n) {
        int n2 = CopyOnWriteArrayList.access$000(this.this$0.getArray(), object, this.offset + n, this.offset + this.length) - this.offset;
        return n2 >= 0 ? n2 - this.offset : -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int n = CopyOnWriteArrayList.access$200(this.this$0.getArray(), object, this.offset, this.offset + this.length) - this.offset;
        return n >= 0 ? n - this.offset : -1;
    }

    public int lastIndexOf(Object object, int n) {
        int n2 = CopyOnWriteArrayList.access$200(this.this$0.getArray(), object, this.offset, this.offset + n) - this.offset;
        return n2 >= 0 ? n2 - this.offset : -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ListIterator listIterator() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            return new CopyOnWriteArrayList$COWSubIterator(objectArray, this.offset, this.offset + this.length, this.offset);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ListIterator listIterator(int n) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            if (n < 0 || n >= this.length) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.length).toString());
            }
            Object[] objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            return new CopyOnWriteArrayList$COWSubIterator(objectArray, this.offset, this.offset + this.length, this.offset + n);
        }
    }

    @Override
    public List subList(int n, int n2) {
        if (n < 0 || n2 > this.length || n > n2) {
            throw new IndexOutOfBoundsException();
        }
        return new CopyOnWriteArrayList$COWSubList(this.this$0, this.offset + n, n2 - n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        int n;
        Object[] objectArray;
        Serializable serializable = this.this$0;
        synchronized (serializable) {
            objectArray = this.this$0.getArray();
            if (objectArray != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            n = this.offset + this.length;
        }
        serializable = new StringBuffer();
        ((StringBuffer)serializable).append('[');
        for (int i2 = this.offset; i2 < n; ++i2) {
            if (i2 > this.offset) {
                ((StringBuffer)serializable).append(", ");
            }
            ((StringBuffer)serializable).append(objectArray[i2]);
        }
        ((StringBuffer)serializable).append(']');
        return ((StringBuffer)serializable).toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            if (this.this$0.getArray() != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
        }
        objectOutputStream.defaultWriteObject();
        copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            if (this.this$0.getArray() != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        CopyOnWriteArrayList copyOnWriteArrayList = this.this$0;
        synchronized (copyOnWriteArrayList) {
            this.expectedArray = this.this$0.getArray();
        }
    }
}

