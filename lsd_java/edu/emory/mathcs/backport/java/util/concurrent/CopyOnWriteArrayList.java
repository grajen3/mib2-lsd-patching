/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList$COWIterator;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList$COWSubList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class CopyOnWriteArrayList
implements List,
RandomAccess,
Cloneable,
Serializable {
    private static final long serialVersionUID;
    private volatile transient Object[] array;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public CopyOnWriteArrayList() {
        this.setArray(new Object[0]);
    }

    public CopyOnWriteArrayList(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (super.getClass() != (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            objectArray = Arrays.copyOf(objectArray, objectArray.length, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
        }
        this.setArray(objectArray);
    }

    public CopyOnWriteArrayList(Object[] objectArray) {
        this.setArray(Arrays.copyOf(objectArray, objectArray.length, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object));
    }

    final Object[] getArray() {
        return this.array;
    }

    final void setArray(Object[] objectArray) {
        this.array = objectArray;
    }

    @Override
    public int size() {
        return this.getArray().length;
    }

    @Override
    public boolean isEmpty() {
        return this.getArray().length == 0;
    }

    private static int search(Object[] objectArray, Object object, int n, int n2) {
        if (object == null) {
            while (n < n2) {
                if (objectArray[n] == null) {
                    return n;
                }
                ++n;
            }
        } else {
            while (n < n2) {
                if (object.equals(objectArray[n])) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }

    private static int reverseSearch(Object[] objectArray, Object object, int n, int n2) {
        if (object == null) {
            --n2;
            while (n2 >= n) {
                if (objectArray[n2] == null) {
                    return n2;
                }
                --n2;
            }
        } else {
            --n2;
            while (n2 >= n) {
                if (object.equals(objectArray[n2])) {
                    return n2;
                }
                --n2;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.search(objectArray, object, 0, objectArray.length) >= 0;
    }

    @Override
    public Iterator iterator() {
        return new CopyOnWriteArrayList$COWIterator(this.getArray(), 0);
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = this.getArray();
        return Arrays.copyOf(objectArray, objectArray.length, array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = CopyOnWriteArrayList.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = this.getArray();
        int n = objectArray2.length;
        if (objectArray.length < n) {
            return Arrays.copyOf(objectArray2, n, super.getClass());
        }
        System.arraycopy((Object)objectArray2, 0, (Object)objectArray, 0, n);
        if (objectArray.length > n) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n + 1];
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            objectArray2[n] = object;
            this.setArray(objectArray2);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addIfAbsent(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            if (CopyOnWriteArrayList.search(this.array, object, 0, n) >= 0) {
                return false;
            }
            Object[] objectArray2 = new Object[n + 1];
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            objectArray2[n] = object;
            this.setArray(objectArray2);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int addAllAbsent(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (objectArray.length == 0) {
            return 0;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray2 = this.getArray();
            int n = objectArray2.length;
            Object[] objectArray3 = new Object[objectArray.length];
            int n2 = 0;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object = objectArray[i2];
                if (CopyOnWriteArrayList.search(objectArray2, object, 0, n) >= 0 || CopyOnWriteArrayList.search(objectArray3, object, 0, n2) >= 0) continue;
                objectArray3[n2++] = object;
            }
            if (n2 == 0) {
                return 0;
            }
            Object[] objectArray4 = new Object[n + n2];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray4, 0, n);
            System.arraycopy((Object)objectArray3, 0, (Object)objectArray4, n, n2);
            this.setArray(objectArray4);
            return n2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            int n2 = CopyOnWriteArrayList.search(objectArray, object, 0, n);
            if (n2 < 0) {
                return false;
            }
            Object[] objectArray2 = new Object[n - 1];
            int n3 = n - n2 - 1;
            if (n2 > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n2 + 1, (Object)objectArray2, n2, n3);
            }
            this.setArray(objectArray2);
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        Object[] objectArray = this.getArray();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (CopyOnWriteArrayList.search(objectArray, iterator.next(), 0, objectArray.length) >= 0) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(Collection collection) {
        Object[] objectArray = collection.toArray();
        if (objectArray.length == 0) {
            return false;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray2 = this.getArray();
            int n = objectArray2.length;
            Object[] objectArray3 = new Object[n + objectArray.length];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n);
            int n2 = n;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray3, n2, objectArray.length);
            this.setArray(objectArray3);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(int n, Collection collection) {
        Object[] objectArray = collection.toArray();
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray2 = this.getArray();
            int n2 = objectArray2.length;
            if (n < 0 || n > n2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(n2).toString());
            }
            if (objectArray.length == 0) {
                return false;
            }
            Object[] objectArray3 = new Object[n2 + objectArray.length];
            int n3 = n2 - n;
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n);
            int n4 = n2;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray3, n, objectArray.length);
            if (n3 > 0) {
                System.arraycopy((Object)objectArray2, n, (Object)objectArray3, n + objectArray.length, n3);
            }
            this.setArray(objectArray3);
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
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                Object object = objectArray[i2];
                if (collection.contains(object)) continue;
                objectArray2[n2++] = object;
            }
            if (n2 == n) {
                return false;
            }
            Object[] objectArray3 = new Object[n2];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n2);
            this.setArray(objectArray3);
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(Collection collection) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n = objectArray.length;
            Object[] objectArray2 = new Object[n];
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                Object object = objectArray[i2];
                if (!collection.contains(object)) continue;
                objectArray2[n2++] = object;
            }
            if (n2 == n) {
                return false;
            }
            Object[] objectArray3 = new Object[n2];
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray3, 0, n2);
            this.setArray(objectArray3);
            return true;
        }
    }

    @Override
    public void clear() {
        this.setArray(new Object[0]);
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        ListIterator listIterator = ((List)object).listIterator();
        Object[] objectArray = this.getArray();
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n && listIterator.hasNext()) {
            Object object2;
            Object object3 = listIterator.next();
            if (CopyOnWriteArrayList.eq(object2 = objectArray[n2++], object3)) continue;
            return false;
        }
        return n2 == n && !listIterator.hasNext();
    }

    @Override
    public int hashCode() {
        int n = 1;
        for (Object object : this.getArray()) {
            n = 31 * n + (object == null ? 0 : object.hashCode());
        }
        return n;
    }

    @Override
    public Object get(int n) {
        return this.getArray()[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object set(int n, Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n2 = objectArray.length;
            Object object2 = objectArray[n];
            if (object2 == object) {
                this.setArray(objectArray);
            } else {
                Object[] objectArray2 = new Object[n2];
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n2);
                objectArray2[n] = object;
                this.setArray(objectArray2);
            }
            return object2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void add(int n, Object object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n2 = objectArray.length;
            if (n < 0 || n > n2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(n2).toString());
            }
            Object[] objectArray2 = new Object[n2 + 1];
            int n3 = n2 - n;
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            objectArray2[n] = object;
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n, (Object)objectArray2, n + 1, n3);
            }
            this.setArray(objectArray2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object remove(int n) {
        CopyOnWriteArrayList copyOnWriteArrayList = this;
        synchronized (copyOnWriteArrayList) {
            Object[] objectArray = this.getArray();
            int n2 = objectArray.length;
            if (n < 0 || n >= n2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(n2).toString());
            }
            Object object = objectArray[n];
            Object[] objectArray2 = new Object[n2 - 1];
            int n3 = n2 - n - 1;
            if (n > 0) {
                System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n);
            }
            if (n3 > 0) {
                System.arraycopy((Object)objectArray, n + 1, (Object)objectArray2, n, n3);
            }
            this.setArray(objectArray2);
            return object;
        }
    }

    @Override
    public int indexOf(Object object) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.search(objectArray, object, 0, objectArray.length);
    }

    public int indexOf(Object object, int n) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.search(objectArray, object, n, objectArray.length);
    }

    @Override
    public int lastIndexOf(Object object) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.reverseSearch(objectArray, object, 0, objectArray.length);
    }

    public int lastIndexOf(Object object, int n) {
        Object[] objectArray = this.getArray();
        return CopyOnWriteArrayList.reverseSearch(objectArray, object, 0, n);
    }

    @Override
    public ListIterator listIterator() {
        return new CopyOnWriteArrayList$COWIterator(this.getArray(), 0);
    }

    @Override
    public ListIterator listIterator(int n) {
        Object[] objectArray = this.getArray();
        if (n < 0 || n > objectArray.length) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(objectArray.length).toString());
        }
        return new CopyOnWriteArrayList$COWIterator(objectArray, n);
    }

    @Override
    public List subList(int n, int n2) {
        Object[] objectArray = this.getArray();
        if (n < 0 || n2 > objectArray.length || n > n2) {
            throw new IndexOutOfBoundsException();
        }
        return new CopyOnWriteArrayList$COWSubList(this, n, n2 - n);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Object[] objectArray = this.getArray();
        int n = objectArray.length;
        objectOutputStream.writeInt(n);
        for (int i2 = 0; i2 < n; ++i2) {
            objectOutputStream.writeObject(objectArray[i2]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = objectInputStream.readObject();
        }
        this.setArray(objectArray);
    }

    public String toString() {
        Object[] objectArray = this.getArray();
        int n = objectArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(objectArray[i2]);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    private static boolean eq(Object object, Object object2) {
        return object == null ? object2 == null : object.equals(object2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$000(Object[] objectArray, Object object, int n, int n2) {
        return CopyOnWriteArrayList.search(objectArray, object, n, n2);
    }

    static /* synthetic */ boolean access$100(Object object, Object object2) {
        return CopyOnWriteArrayList.eq(object, object2);
    }

    static /* synthetic */ int access$200(Object[] objectArray, Object object, int n, int n2) {
        return CopyOnWriteArrayList.reverseSearch(objectArray, object, n, n2);
    }
}

