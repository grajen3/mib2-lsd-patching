/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections$SynchronizedRandomAccessList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Vector$1;

public class Vector
extends AbstractList
implements List,
RandomAccess,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    protected int elementCount = 0;
    protected Object[] elementData;
    protected int capacityIncrement;
    private static final int DEFAULT_SIZE;

    public Vector() {
        this(10, 0);
    }

    public Vector(int n) {
        this(n, 0);
    }

    public Vector(int n, int n2) {
        try {
            this.elementData = new Object[n];
        }
        catch (NegativeArraySizeException negativeArraySizeException) {
            throw new IllegalArgumentException();
        }
        this.capacityIncrement = n2;
    }

    public Vector(Collection collection) {
        this(collection.size(), 0);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.elementData[this.elementCount++] = iterator.next();
        }
    }

    @Override
    public void add(int n, Object object) {
        this.insertElementAt(object, n);
    }

    @Override
    public boolean add(Object object) {
        this.addElement(object);
        return true;
    }

    @Override
    public synchronized boolean addAll(int n, Collection collection) {
        if (n >= 0 && n <= this.elementCount) {
            int n2;
            int n3 = collection.size();
            if (n3 == 0) {
                return false;
            }
            int n4 = n3 - (this.elementData.length - this.elementCount);
            if (n4 > 0) {
                this.growBy(n4);
            }
            if ((n2 = this.elementCount - n) > 0) {
                System.arraycopy((Object)this.elementData, n, (Object)this.elementData, n + n3, n2);
            }
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                this.elementData[n++] = iterator.next();
            }
            this.elementCount += n3;
            ++this.modCount;
            return true;
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    @Override
    public synchronized boolean addAll(Collection collection) {
        return this.addAll(this.elementCount, collection);
    }

    public synchronized void addElement(Object object) {
        if (this.elementCount == this.elementData.length) {
            this.growByOne();
        }
        this.elementData[this.elementCount++] = object;
        ++this.modCount;
    }

    public synchronized int capacity() {
        return this.elementData.length;
    }

    @Override
    public void clear() {
        this.removeAllElements();
    }

    public synchronized Object clone() {
        try {
            Vector vector = (Vector)super.clone();
            vector.elementData = (Object[])this.elementData.clone();
            return vector;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean contains(Object object) {
        return this.indexOf(object, 0) != -1;
    }

    @Override
    public synchronized boolean containsAll(Collection collection) {
        return super.containsAll(collection);
    }

    public synchronized void copyInto(Object[] objectArray) {
        System.arraycopy((Object)this.elementData, 0, (Object)objectArray, 0, this.elementCount);
    }

    public synchronized Object elementAt(int n) {
        if (n < this.elementCount) {
            return this.elementData[n];
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    public Enumeration elements() {
        return new Vector$1(this);
    }

    public synchronized void ensureCapacity(int n) {
        if (this.elementData.length < n) {
            int n2 = (this.capacityIncrement <= 0 ? this.elementData.length : this.capacityIncrement) + this.elementData.length;
            this.grow(n > n2 ? n : n2);
        }
    }

    @Override
    public synchronized boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof List) {
            List list = (List)object;
            if (list.size() != this.size()) {
                return false;
            }
            int n = 0;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Object object2 = this.elementData[n++];
                Object object3 = iterator.next();
                if (!(object2 == null ? object3 != null : !object2.equals(object3))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public synchronized Object firstElement() {
        if (this.elementCount > 0) {
            return this.elementData[0];
        }
        throw new NoSuchElementException();
    }

    @Override
    public Object get(int n) {
        return this.elementAt(n);
    }

    private void grow(int n) {
        Object[] objectArray = new Object[n];
        System.arraycopy((Object)this.elementData, 0, (Object)objectArray, 0, this.elementCount);
        this.elementData = objectArray;
    }

    private void growByOne() {
        int n = 0;
        if (this.capacityIncrement <= 0) {
            n = this.elementData.length;
            if (n == 0) {
                n = 1;
            }
        } else {
            n = this.capacityIncrement;
        }
        Object[] objectArray = new Object[this.elementData.length + n];
        System.arraycopy((Object)this.elementData, 0, (Object)objectArray, 0, this.elementCount);
        this.elementData = objectArray;
    }

    private void growBy(int n) {
        int n2 = 0;
        if (this.capacityIncrement <= 0) {
            n2 = this.elementData.length;
            if (n2 == 0) {
                n2 = n;
            }
            while (n2 < n) {
                n2 += n2;
            }
        } else {
            n2 = n / this.capacityIncrement * this.capacityIncrement;
            if (n2 < n) {
                n2 += this.capacityIncrement;
            }
        }
        Object[] objectArray = new Object[this.elementData.length + n2];
        System.arraycopy((Object)this.elementData, 0, (Object)objectArray, 0, this.elementCount);
        this.elementData = objectArray;
    }

    @Override
    public synchronized int hashCode() {
        int n = 1;
        int n2 = 0;
        while (n2 < this.elementCount) {
            n = 31 * n + (this.elementData[n2] == null ? 0 : this.elementData[n2].hashCode());
            ++n2;
        }
        return n;
    }

    @Override
    public int indexOf(Object object) {
        return this.indexOf(object, 0);
    }

    public synchronized int indexOf(Object object, int n) {
        if (object != null) {
            int n2 = n;
            while (n2 < this.elementCount) {
                if (object.equals(this.elementData[n2])) {
                    return n2;
                }
                ++n2;
            }
        } else {
            int n3 = n;
            while (n3 < this.elementCount) {
                if (this.elementData[n3] == null) {
                    return n3;
                }
                ++n3;
            }
        }
        return -1;
    }

    public synchronized void insertElementAt(Object object, int n) {
        if (n >= 0 && n <= this.elementCount) {
            int n2;
            if (this.elementCount == this.elementData.length) {
                this.growByOne();
            }
            if ((n2 = this.elementCount - n) > 0) {
                System.arraycopy((Object)this.elementData, n, (Object)this.elementData, n + 1, n2);
            }
            this.elementData[n] = object;
            ++this.elementCount;
            ++this.modCount;
        } else {
            throw new ArrayIndexOutOfBoundsException(n);
        }
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized Object lastElement() {
        try {
            return this.elementData[this.elementCount - 1];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public synchronized int lastIndexOf(Object object) {
        return this.lastIndexOf(object, this.elementCount - 1);
    }

    public synchronized int lastIndexOf(Object object, int n) {
        if (n < this.elementCount) {
            if (object != null) {
                int n2 = n;
                while (n2 >= 0) {
                    if (object.equals(this.elementData[n2])) {
                        return n2;
                    }
                    --n2;
                }
            } else {
                int n3 = n;
                while (n3 >= 0) {
                    if (this.elementData[n3] == null) {
                        return n3;
                    }
                    --n3;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    @Override
    public synchronized Object remove(int n) {
        if (n < this.elementCount) {
            Object object = this.elementData[n];
            --this.elementCount;
            int n2 = this.elementCount - n;
            if (n2 > 0) {
                System.arraycopy((Object)this.elementData, n + 1, (Object)this.elementData, n, n2);
            }
            this.elementData[this.elementCount] = null;
            ++this.modCount;
            return object;
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    @Override
    public boolean remove(Object object) {
        return this.removeElement(object);
    }

    @Override
    public synchronized boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public synchronized void removeAllElements() {
        Arrays.fill(this.elementData, 0, this.elementCount, null);
        ++this.modCount;
        this.elementCount = 0;
    }

    public synchronized boolean removeElement(Object object) {
        int n = this.indexOf(object, 0);
        if (n == -1) {
            return false;
        }
        this.removeElementAt(n);
        return true;
    }

    public synchronized void removeElementAt(int n) {
        if (n >= 0 && n < this.elementCount) {
            --this.elementCount;
            int n2 = this.elementCount - n;
            if (n2 > 0) {
                System.arraycopy((Object)this.elementData, n + 1, (Object)this.elementData, n, n2);
            }
            this.elementData[this.elementCount] = null;
            ++this.modCount;
        } else {
            throw new ArrayIndexOutOfBoundsException(n);
        }
    }

    @Override
    protected void removeRange(int n, int n2) {
        if (n >= 0 && n <= n2 && n2 <= this.size()) {
            if (n == n2) {
                return;
            }
            if (n2 != this.elementCount) {
                System.arraycopy((Object)this.elementData, n2, (Object)this.elementData, n, this.elementCount - n2);
                int n3 = this.elementCount - (n2 - n);
                Arrays.fill(this.elementData, n3, this.elementCount, null);
                this.elementCount = n3;
            } else {
                Arrays.fill(this.elementData, n, this.elementCount, null);
                this.elementCount = n;
            }
            ++this.modCount;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public synchronized boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override
    public synchronized Object set(int n, Object object) {
        if (n < this.elementCount) {
            Object object2 = this.elementData[n];
            this.elementData[n] = object;
            return object2;
        }
        throw new ArrayIndexOutOfBoundsException(n);
    }

    public synchronized void setElementAt(Object object, int n) {
        if (n >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(n);
        }
        this.elementData[n] = object;
    }

    public synchronized void setSize(int n) {
        if (n == this.elementCount) {
            return;
        }
        this.ensureCapacity(n);
        if (this.elementCount > n) {
            Arrays.fill(this.elementData, n, this.elementCount, null);
        }
        this.elementCount = n;
        ++this.modCount;
    }

    @Override
    public synchronized int size() {
        return this.elementCount;
    }

    @Override
    public synchronized List subList(int n, int n2) {
        return new Collections$SynchronizedRandomAccessList(super.subList(n, n2), (Object)this);
    }

    @Override
    public synchronized Object[] toArray() {
        Object[] objectArray = new Object[this.elementCount];
        System.arraycopy((Object)this.elementData, 0, (Object)objectArray, 0, this.elementCount);
        return objectArray;
    }

    @Override
    public synchronized Object[] toArray(Object[] objectArray) {
        if (this.elementCount > objectArray.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), this.elementCount);
        }
        System.arraycopy((Object)this.elementData, 0, (Object)objectArray, 0, this.elementCount);
        if (this.elementCount < objectArray.length) {
            objectArray[this.elementCount] = null;
        }
        return objectArray;
    }

    @Override
    public synchronized String toString() {
        if (this.elementCount == 0) {
            return "[]";
        }
        int n = this.elementCount - 1;
        StringBuffer stringBuffer = new StringBuffer(this.size() * 16);
        stringBuffer.append('[');
        int n2 = 0;
        while (n2 < n) {
            if (this.elementData[n2] == this) {
                stringBuffer.append("(this Collection)");
            } else {
                stringBuffer.append(this.elementData[n2]);
            }
            stringBuffer.append(", ");
            ++n2;
        }
        if (this.elementData[n] == this) {
            stringBuffer.append("(this Collection)");
        } else {
            stringBuffer.append(this.elementData[n]);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public synchronized void trimToSize() {
        if (this.elementData.length != this.elementCount) {
            this.grow(this.elementCount);
        }
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }
}

