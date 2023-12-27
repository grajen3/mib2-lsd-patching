/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class ArrayList
extends AbstractList
implements List,
Cloneable,
Serializable,
RandomAccess {
    private static final long serialVersionUID;
    private transient int firstIndex;
    private transient int lastIndex;
    private transient Object[] array;
    private static final ObjectStreamField[] serialPersistentFields;

    public ArrayList() {
        this(0);
    }

    public ArrayList(int n) {
        this.lastIndex = 0;
        this.firstIndex = 0;
        try {
            this.array = new Object[n];
        }
        catch (NegativeArraySizeException negativeArraySizeException) {
            throw new IllegalArgumentException();
        }
    }

    public ArrayList(Collection collection) {
        int n = collection.size();
        this.lastIndex = 0;
        this.firstIndex = 0;
        this.array = new Object[n + n / 10];
        this.addAll(collection);
    }

    @Override
    public void add(int n, Object object) {
        int n2 = this.size();
        if (0 < n && n < n2) {
            if (this.firstIndex == 0 && this.lastIndex == this.array.length) {
                this.growForInsert(n, 1);
            } else if (n < n2 / 2 && this.firstIndex > 0 || this.lastIndex == this.array.length) {
                System.arraycopy((Object)this.array, this.firstIndex, (Object)this.array, --this.firstIndex, n);
            } else {
                int n3 = n + this.firstIndex;
                System.arraycopy((Object)this.array, n3, (Object)this.array, n3 + 1, n2 - n);
                ++this.lastIndex;
            }
            this.array[n + this.firstIndex] = object;
        } else if (n == 0) {
            if (this.firstIndex == 0) {
                this.growAtFront(1);
            }
            this.array[--this.firstIndex] = object;
        } else if (n == n2) {
            if (this.lastIndex == this.array.length) {
                this.growAtEnd(1);
            }
            this.array[this.lastIndex++] = object;
        } else {
            throw new IndexOutOfBoundsException();
        }
        ++this.modCount;
    }

    @Override
    public boolean add(Object object) {
        if (this.lastIndex == this.array.length) {
            this.growAtEnd(1);
        }
        this.array[this.lastIndex++] = object;
        ++this.modCount;
        return true;
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        int n2;
        int n3 = this.size();
        int n4 = collection.size();
        if (0 < n && n < n3) {
            int n5;
            if (this.array.length - n3 < n4) {
                this.growForInsert(n, n4);
            } else if (n < n3 / 2 && this.firstIndex > 0 || this.lastIndex > this.array.length - n4) {
                n5 = this.firstIndex - n4;
                if (n5 < 0) {
                    n2 = n + this.firstIndex;
                    System.arraycopy((Object)this.array, n2, (Object)this.array, n2 - n5, n3 - n);
                    this.lastIndex -= n5;
                    n5 = 0;
                }
                System.arraycopy((Object)this.array, this.firstIndex, (Object)this.array, n5, n);
                this.firstIndex = n5;
            } else {
                n5 = n + this.firstIndex;
                System.arraycopy((Object)this.array, n5, (Object)this.array, n5 + n4, n3 - n);
                this.lastIndex += n4;
            }
        } else if (n == 0) {
            if (this.firstIndex < n4) {
                this.growAtFront(n4);
            }
            this.firstIndex -= n4;
        } else if (n == n3) {
            if (this.lastIndex > this.array.length - n4) {
                this.growAtEnd(n4);
            }
            this.lastIndex += n4;
        } else {
            throw new IndexOutOfBoundsException();
        }
        if (n4 > 0) {
            Iterator iterator = collection.iterator();
            n2 = n + this.firstIndex;
            int n6 = n2 + n4;
            while (n2 < n6) {
                this.array[n2++] = iterator.next();
            }
            ++this.modCount;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        int n = collection.size();
        if (n > 0) {
            if (this.lastIndex > this.array.length - n) {
                this.growAtEnd(n);
            }
            Iterator iterator = collection.iterator();
            int n2 = this.lastIndex + n;
            while (this.lastIndex < n2) {
                this.array[this.lastIndex++] = iterator.next();
            }
            ++this.modCount;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        if (this.firstIndex != this.lastIndex) {
            Arrays.fill(this.array, this.firstIndex, this.lastIndex, null);
            this.lastIndex = 0;
            this.firstIndex = 0;
            ++this.modCount;
        }
    }

    public Object clone() {
        try {
            ArrayList arrayList = (ArrayList)super.clone();
            arrayList.array = (Object[])this.array.clone();
            return arrayList;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public boolean contains(Object object) {
        if (object != null) {
            for (int i2 = this.firstIndex; i2 < this.lastIndex; ++i2) {
                if (!object.equals(this.array[i2])) continue;
                return true;
            }
        } else {
            for (int i3 = this.firstIndex; i3 < this.lastIndex; ++i3) {
                if (this.array[i3] != null) continue;
                return true;
            }
        }
        return false;
    }

    public void ensureCapacity(int n) {
        if (this.array.length < n) {
            if (this.firstIndex > 0) {
                this.growAtFront(n - this.array.length);
            } else {
                this.growAtEnd(n - this.array.length);
            }
        }
    }

    @Override
    public Object get(int n) {
        if (0 <= n && n < this.size()) {
            return this.array[this.firstIndex + n];
        }
        throw new IndexOutOfBoundsException();
    }

    private void growAtEnd(int n) {
        int n2 = this.size();
        if (this.firstIndex >= n - (this.array.length - this.lastIndex)) {
            int n3 = this.lastIndex - this.firstIndex;
            if (n2 > 0) {
                System.arraycopy((Object)this.array, this.firstIndex, (Object)this.array, 0, n2);
                int n4 = n3 < this.firstIndex ? this.firstIndex : n3;
                Arrays.fill(this.array, n4, this.array.length, null);
            }
            this.firstIndex = 0;
            this.lastIndex = n3;
        } else {
            int n5 = n2 / 2;
            if (n > n5) {
                n5 = n;
            }
            if (n5 < 12) {
                n5 = 12;
            }
            Object[] objectArray = new Object[this.lastIndex + n5];
            if (n2 > 0) {
                System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, this.firstIndex, n2);
            }
            this.array = objectArray;
        }
    }

    private void growAtFront(int n) {
        int n2 = this.size();
        if (this.array.length - this.lastIndex >= n) {
            int n3 = this.array.length - n2;
            if (n2 > 0) {
                System.arraycopy((Object)this.array, this.firstIndex, (Object)this.array, n3, n2);
                int n4 = this.firstIndex + n2 > n3 ? n3 : this.firstIndex + n2;
                Arrays.fill(this.array, this.firstIndex, n4, null);
            }
            this.firstIndex = n3;
            this.lastIndex = this.array.length;
        } else {
            int n5 = n2 / 2;
            if (n > n5) {
                n5 = n;
            }
            if (n5 < 12) {
                n5 = 12;
            }
            Object[] objectArray = new Object[n2 + n5];
            if (n2 > 0) {
                System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, objectArray.length - n2, n2);
            }
            this.firstIndex = objectArray.length - n2;
            this.lastIndex = objectArray.length;
            this.array = objectArray;
        }
    }

    private void growForInsert(int n, int n2) {
        int n3 = this.size();
        int n4 = n3 / 2;
        if (n2 > n4) {
            n4 = n2;
        }
        if (n4 < 12) {
            n4 = 12;
        }
        Object[] objectArray = new Object[n3 + n4];
        if (n < n3 / 2) {
            int n5 = objectArray.length - (n3 + n2);
            System.arraycopy((Object)this.array, this.firstIndex + n, (Object)objectArray, n + n4, n3 - n);
            System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, n5, n);
            this.firstIndex = n5;
            this.lastIndex = objectArray.length;
        } else {
            System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, 0, n);
            System.arraycopy((Object)this.array, this.firstIndex + n, (Object)objectArray, n + n2, n3 - n);
            this.firstIndex = 0;
            this.lastIndex = n3 + n2;
        }
        this.array = objectArray;
    }

    @Override
    public int indexOf(Object object) {
        if (object != null) {
            for (int i2 = this.firstIndex; i2 < this.lastIndex; ++i2) {
                if (!object.equals(this.array[i2])) continue;
                return i2 - this.firstIndex;
            }
        } else {
            for (int i3 = this.firstIndex; i3 < this.lastIndex; ++i3) {
                if (this.array[i3] != null) continue;
                return i3 - this.firstIndex;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.lastIndex == this.firstIndex;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object != null) {
            for (int i2 = this.lastIndex - 1; i2 >= this.firstIndex; --i2) {
                if (!object.equals(this.array[i2])) continue;
                return i2 - this.firstIndex;
            }
        } else {
            for (int i3 = this.lastIndex - 1; i3 >= this.firstIndex; --i3) {
                if (this.array[i3] != null) continue;
                return i3 - this.firstIndex;
            }
        }
        return -1;
    }

    @Override
    public Object remove(int n) {
        Object object;
        int n2 = this.size();
        if (0 <= n && n < n2) {
            if (n == n2 - 1) {
                object = this.array[--this.lastIndex];
                this.array[this.lastIndex] = null;
            } else if (n == 0) {
                object = this.array[this.firstIndex];
                this.array[this.firstIndex++] = null;
            } else {
                int n3 = this.firstIndex + n;
                object = this.array[n3];
                if (n < n2 / 2) {
                    System.arraycopy((Object)this.array, this.firstIndex, (Object)this.array, this.firstIndex + 1, n);
                    this.array[this.firstIndex++] = null;
                } else {
                    System.arraycopy((Object)this.array, n3 + 1, (Object)this.array, n3, n2 - n - 1);
                    this.array[--this.lastIndex] = null;
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        ++this.modCount;
        return object;
    }

    @Override
    protected void removeRange(int n, int n2) {
        if (n >= 0 && n <= n2 && n2 <= this.size()) {
            if (n == n2) {
                return;
            }
            int n3 = this.size();
            if (n2 == n3) {
                Arrays.fill(this.array, this.firstIndex + n, this.lastIndex, null);
                this.lastIndex = this.firstIndex + n;
            } else if (n == 0) {
                Arrays.fill(this.array, this.firstIndex, this.firstIndex + n2, null);
                this.firstIndex += n2;
            } else {
                System.arraycopy((Object)this.array, this.firstIndex + n2, (Object)this.array, this.firstIndex + n, n3 - n2);
                int n4 = this.lastIndex + n - n2;
                Arrays.fill(this.array, n4, this.lastIndex, null);
                this.lastIndex = n4;
            }
            ++this.modCount;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int n, Object object) {
        if (0 <= n && n < this.size()) {
            Object object2 = this.array[this.firstIndex + n];
            this.array[this.firstIndex + n] = object;
            return object2;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return this.lastIndex - this.firstIndex;
    }

    @Override
    public Object[] toArray() {
        int n = this.size();
        Object[] objectArray = new Object[n];
        System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, 0, n);
        return objectArray;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        int n = this.size();
        if (n > objectArray.length) {
            objectArray = (Object[])Array.newInstance(super.getClass().getComponentType(), n);
        }
        System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, 0, n);
        if (n < objectArray.length) {
            objectArray[n] = null;
        }
        return objectArray;
    }

    public void trimToSize() {
        int n = this.size();
        Object[] objectArray = new Object[n];
        System.arraycopy((Object)this.array, this.firstIndex, (Object)objectArray, 0, n);
        this.array = objectArray;
        this.firstIndex = 0;
        this.lastIndex = this.array.length;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("size", this.size());
        objectOutputStream.writeFields();
        objectOutputStream.writeInt(this.array.length);
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.lastIndex = objectInputStream$GetField.get("size", 0);
        this.array = new Object[objectInputStream.readInt()];
        for (int i2 = 0; i2 < this.lastIndex; ++i2) {
            this.array[i2] = objectInputStream.readObject();
        }
    }

    static {
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("size", Integer.TYPE)};
    }
}

