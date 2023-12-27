/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ObjectArrayList$1;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ObjectArrayList
implements CollectionWithExpansionPoint,
List {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    Object[] array;
    int first;
    int last;
    private int arraylength;
    protected int writes;
    private int hashCode;
    private int hashWrites;
    int sizeWarningThreshold;

    public ObjectArrayList() {
        this(EMPTY_ARRAY);
    }

    public ObjectArrayList(int n) {
        this(n == 0 ? EMPTY_ARRAY : new Object[n]);
    }

    private ObjectArrayList(Object[] objectArray) {
        this.array = objectArray;
        this.arraylength = this.array.length;
        this.sizeWarningThreshold = this.arraylength * 2 > CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD ? this.arraylength * 2 : CollectionsHelper.DEFAULT_SIZE_WARNING_THRESHOLD;
        this.last = 0;
        this.first = 0;
        this.calcHashCode();
        this.hashWrites = 0;
        this.writes = 0;
    }

    private void calcHashCode() {
        this.hashCode = HashCodeBuilder.toInt(HashCodeBuilder.hash(this.array, this.first, this.last - this.first));
    }

    public void setSizeWarningThreshold(int n) {
        this.sizeWarningThreshold = n;
    }

    private void initArray(int n) {
        this.arraylength = n;
        this.array = new Object[this.arraylength];
    }

    private boolean isResetNecessary(int n) {
        return this.last + n > this.arraylength;
    }

    private void increaseArraysize(int n) {
        int n2 = this.arraylength + n;
        n2 = n2 > 23 ? 3 * n2 / 2 : n2 + 12;
        this.initArray(n2);
        if (this.size() + n > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("ObjectArrayList", this.arraylength, 4);
        }
    }

    private boolean isResizeNecessary(int n) {
        return this.size() + n > this.arraylength;
    }

    @Override
    public boolean add(Object object) {
        if (this.isResizeNecessary(1)) {
            Object[] objectArray = this.array;
            this.increaseArraysize(1);
            this.moveArrayContentTo0(objectArray);
        } else if (this.isResetNecessary(1)) {
            int n = this.last;
            this.moveArrayContentTo0(this.array);
            Arrays.fill(this.array, this.last, n, null);
        }
        this.array[this.last] = object;
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    private void moveArrayContentTo0(Object[] objectArray) {
        System.arraycopy((Object)objectArray, this.first, (Object)this.array, 0, this.size());
        this.last -= this.first;
        this.first = 0;
    }

    public void addFirst(Object object) {
        if (this.first == 0) {
            this.add(0, object);
            return;
        }
        --this.first;
        this.array[this.first] = object;
        ++this.writes;
        this.onCollectionChanged();
    }

    @Override
    public void add(int n, Object object) {
        int n2 = this.first + n;
        if (n == 0) {
            if (this.first > 0) {
                this.addFirst(object);
                return;
            }
        } else {
            if (n2 == this.last) {
                this.add(object);
                return;
            }
            if (n < 0 || n2 > this.last) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
            }
        }
        if (this.isResizeNecessary(1)) {
            Object[] objectArray = this.array;
            this.increaseArraysize(1);
            System.arraycopy((Object)objectArray, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = object;
            System.arraycopy((Object)objectArray, n2, (Object)this.array, n + 1, this.last - n);
        } else if (this.isResetNecessary(1)) {
            int n3 = this.last;
            System.arraycopy((Object)this.array, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = object;
            System.arraycopy((Object)this.array, n2, (Object)this.array, n + 1, this.last - n);
            Arrays.fill(this.array, this.last + 1, n3, null);
        } else {
            System.arraycopy((Object)this.array, n2, (Object)this.array, n2 + 1, this.last - n2);
            this.array[n2] = object;
        }
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
    }

    @Override
    public Object set(int n, Object object) {
        int n2 = this.first + n;
        if (n2 < this.first || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        Object object2 = this.array[n2];
        this.array[n2] = object;
        ++this.writes;
        this.onCollectionChanged();
        return object2;
    }

    @Override
    public void clear() {
        Arrays.fill(this.array, this.first, this.last, null);
        this.first = 0;
        this.last = 0;
        ++this.writes;
        this.onCollectionChanged();
    }

    @Override
    public Object get(int n) {
        int n2 = this.first + n;
        if (n < 0 || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        return this.array[n2];
    }

    @Override
    public boolean isEmpty() {
        return this.last <= this.first;
    }

    @Override
    public int size() {
        return this.last - this.first;
    }

    public boolean removeFirst() {
        if (this.isEmpty()) {
            return false;
        }
        this.array[this.first++] = null;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean removeLast() {
        if (this.isEmpty()) {
            return false;
        }
        this.array[--this.last] = null;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    @Override
    public Object remove(int n) {
        int n2 = this.first + n;
        if (n < 0 || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        Object object = this.array[n2];
        if (n2 == this.last - 1) {
            this.array[--this.last] = null;
        } else if (n == 0) {
            this.array[this.first++] = null;
        } else if (n < this.last - n2 - 1) {
            System.arraycopy((Object)this.array, this.first, (Object)this.array, this.first + 1, n);
            this.array[this.first++] = null;
        } else {
            System.arraycopy((Object)this.array, n2 + 1, (Object)this.array, n2, this.last - n2 - 1);
            this.array[--this.last] = null;
        }
        ++this.writes;
        this.onCollectionChanged();
        return object;
    }

    public void removeRange(int n, int n2) {
        if (n < 0 || n >= this.size()) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("index=").append(n).append(", size=").append(this.size()).toString());
        }
        if (n2 < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("length must be at least 1, but is ").append(n2).toString());
        }
        int n3 = n + n2 - 1;
        if (n3 < 0 || n3 >= this.size()) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("index=").append(n3).append(", size=").append(this.size()).toString());
        }
        int n4 = this.first + n;
        int n5 = n4 + n2;
        int n6 = this.size() - n2 - n;
        System.arraycopy((Object)this.array, n5, (Object)this.array, n4, n6);
        Arrays.fill(this.array, n4 + n6, this.last, null);
        this.last -= n2;
        ++this.writes;
        this.onCollectionChanged();
    }

    public Object last() {
        return this.array[this.last - 1];
    }

    public boolean removeValue(Object object) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (object != this.array[i2] && (object == null || !object.equals(this.array[i2]))) continue;
            this.remove(i2 - this.first);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String string = "";
        for (int i2 = this.first; i2 < this.last; ++i2) {
            stringBuilder.append(string).append(this.array[i2]);
            string = ", ";
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public boolean contains(Object object) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (object != this.array[i2] && (object == null || !object.equals(this.array[i2]))) continue;
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ObjectArrayList$1(this);
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.addAll(this.size(), collection);
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        Object object;
        if (n < 0 || this.size() < n) {
            throw new IndexOutOfBoundsException();
        }
        int n2 = collection.size();
        if (0 == n2) {
            return false;
        }
        if (this.isResizeNecessary(n2)) {
            object = this.array;
            this.increaseArraysize(n2);
            this.moveArrayContentTo0((Object[])object);
        } else if (this.isResetNecessary(n2)) {
            this.moveArrayContentTo0(this.array);
        }
        if (this.last > n) {
            System.arraycopy((Object)this.array, n, (Object)this.array, n + n2, this.last - n);
        }
        this.last += n2;
        object = collection.iterator();
        int n3 = n;
        while (object.hasNext()) {
            this.array[n3] = object.next();
            ++n3;
        }
        ++this.writes;
        this.onCollectionChanged();
        return true;
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
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) continue;
            iterator.remove();
            bl = true;
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
    public Object[] toArray(Object[] objectArray) {
        if (objectArray.length < this.size()) {
            return this.toArray();
        }
        System.arraycopy((Object)this.array, this.first, (Object)objectArray, 0, this.size());
        return objectArray;
    }

    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    @Override
    public int hashCode() {
        if (this.writes != this.hashWrites) {
            this.calcHashCode();
            this.hashWrites = this.writes;
        }
        return this.hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ObjectArrayList objectArrayList = (ObjectArrayList)object;
        if (this.size() != objectArrayList.size()) {
            return false;
        }
        for (int i2 = this.size() - 1; i2 >= 0; --i2) {
            if (this.array[this.first + i2] == objectArrayList.array[objectArrayList.first + i2]) continue;
            return false;
        }
        return true;
    }

    public void sort() {
        CollectionsHelper.sort(this.array, this.first, this.last);
    }

    public void sort(Comparator comparator) {
        CollectionsHelper.sort(this.array, this.first, this.last, comparator);
    }

    @Override
    public int indexOf(Object object) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (object != this.array[i2] && (object == null || !object.equals(this.array[i2]))) continue;
            return i2 - this.first;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (object != this.array[i2] && (object == null || !object.equals(this.array[i2]))) continue;
            return i2 - this.first;
        }
        return -1;
    }

    @Override
    public boolean remove(Object object) {
        int n = this.indexOf(object);
        if (n < 0) {
            return false;
        }
        this.remove(n);
        return true;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int n, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void onCollectionChanged() {
    }
}

