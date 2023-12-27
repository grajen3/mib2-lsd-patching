/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntArrayList$1;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public class IntArrayList
implements CollectionWithExpansionPoint {
    private static final int[] EMPTY_ARRAY = new int[0];
    int[] array;
    int first;
    int last;
    private int arraylength;
    protected int writes;
    private int hashCode;
    private int hashWrites;
    int sizeWarningThreshold;

    public IntArrayList() {
        this(EMPTY_ARRAY);
    }

    public IntArrayList(int n) {
        this(n == 0 ? EMPTY_ARRAY : new int[n]);
    }

    private IntArrayList(int[] nArray) {
        this.array = nArray;
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
        this.array = new int[this.arraylength];
    }

    private boolean isResetNecessary(int n) {
        return this.last + n > this.arraylength;
    }

    private void increaseArraysize(int n) {
        int n2 = this.arraylength + n;
        n2 = n2 > 23 ? 3 * n2 / 2 : n2 + 12;
        this.initArray(n2);
        if (this.size() + n > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("intArrayList", this.arraylength, 4);
        }
    }

    private boolean isResizeNecessary(int n) {
        return this.size() + n > this.arraylength;
    }

    public boolean add(int n) {
        if (this.isResizeNecessary(1)) {
            int[] nArray = this.array;
            this.increaseArraysize(1);
            this.moveArrayContentTo0(nArray);
        } else if (this.isResetNecessary(1)) {
            int n2 = this.last;
            this.moveArrayContentTo0(this.array);
            Arrays.fill(this.array, this.last, n2, 0);
        }
        this.array[this.last] = n;
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    private void moveArrayContentTo0(int[] nArray) {
        System.arraycopy((Object)nArray, this.first, (Object)this.array, 0, this.size());
        this.last -= this.first;
        this.first = 0;
    }

    public void addFirst(int n) {
        if (this.first == 0) {
            this.add(0, n);
            return;
        }
        --this.first;
        this.array[this.first] = n;
        ++this.writes;
        this.onCollectionChanged();
    }

    public void add(int n, int n2) {
        int n3 = this.first + n;
        if (n == 0) {
            if (this.first > 0) {
                this.addFirst(n2);
                return;
            }
        } else {
            if (n3 == this.last) {
                this.add(n2);
                return;
            }
            if (n < 0 || n3 > this.last) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
            }
        }
        if (this.isResizeNecessary(1)) {
            int[] nArray = this.array;
            this.increaseArraysize(1);
            System.arraycopy((Object)nArray, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = n2;
            System.arraycopy((Object)nArray, n3, (Object)this.array, n + 1, this.last - n);
        } else if (this.isResetNecessary(1)) {
            int n4 = this.last;
            System.arraycopy((Object)this.array, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = n2;
            System.arraycopy((Object)this.array, n3, (Object)this.array, n + 1, this.last - n);
            Arrays.fill(this.array, this.last + 1, n4, 0);
        } else {
            System.arraycopy((Object)this.array, n3, (Object)this.array, n3 + 1, this.last - n3);
            this.array[n3] = n2;
        }
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
    }

    public int set(int n, int n2) {
        int n3 = this.first + n;
        if (n3 < this.first || n3 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        int n4 = this.array[n3];
        this.array[n3] = n2;
        ++this.writes;
        this.onCollectionChanged();
        return n4;
    }

    public void clear() {
        Arrays.fill(this.array, this.first, this.last, 0);
        this.first = 0;
        this.last = 0;
        ++this.writes;
        this.onCollectionChanged();
    }

    public int get(int n) {
        int n2 = this.first + n;
        if (n < 0 || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        return this.array[n2];
    }

    public boolean isEmpty() {
        return this.last <= this.first;
    }

    public int size() {
        return this.last - this.first;
    }

    public boolean removeFirst() {
        if (this.isEmpty()) {
            return false;
        }
        this.array[this.first++] = 0;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean removeLast() {
        if (this.isEmpty()) {
            return false;
        }
        this.array[--this.last] = 0;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public int remove(int n) {
        int n2 = this.first + n;
        if (n < 0 || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        int n3 = this.array[n2];
        if (n2 == this.last - 1) {
            this.array[--this.last] = 0;
        } else if (n == 0) {
            this.array[this.first++] = 0;
        } else if (n < this.last - n2 - 1) {
            System.arraycopy((Object)this.array, this.first, (Object)this.array, this.first + 1, n);
            this.array[this.first++] = 0;
        } else {
            System.arraycopy((Object)this.array, n2 + 1, (Object)this.array, n2, this.last - n2 - 1);
            this.array[--this.last] = 0;
        }
        ++this.writes;
        this.onCollectionChanged();
        return n3;
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
        Arrays.fill(this.array, n4 + n6, this.last, 0);
        this.last -= n2;
        ++this.writes;
        this.onCollectionChanged();
    }

    public int last() {
        return this.array[this.last - 1];
    }

    public boolean removeValue(int n) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (n != this.array[i2]) continue;
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

    public boolean contains(int n) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (n != this.array[i2]) continue;
            return true;
        }
        return false;
    }

    public IntIterator iterator() {
        return new IntArrayList$1(this);
    }

    public boolean addAll(IntCollection intCollection) {
        return this.addAll(this.size(), intCollection);
    }

    public boolean addAll(int n, IntCollection intCollection) {
        Object object;
        if (n < 0 || this.size() < n) {
            throw new IndexOutOfBoundsException();
        }
        int n2 = intCollection.size();
        if (0 == n2) {
            return false;
        }
        if (this.isResizeNecessary(n2)) {
            object = this.array;
            this.increaseArraysize(n2);
            this.moveArrayContentTo0((int[])object);
        } else if (this.isResetNecessary(n2)) {
            this.moveArrayContentTo0(this.array);
        }
        if (this.last > n) {
            System.arraycopy((Object)this.array, n, (Object)this.array, n + n2, this.last - n);
        }
        this.last += n2;
        object = intCollection.iterator();
        int n3 = n;
        while (object.hasNext()) {
            this.array[n3] = object.next();
            ++n3;
        }
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean containsAll(IntCollection intCollection) {
        IntIterator intIterator = intCollection.iterator();
        while (intIterator.hasNext()) {
            if (this.contains(intIterator.next())) continue;
            return false;
        }
        return true;
    }

    public boolean removeAll(IntCollection intCollection) {
        boolean bl = false;
        IntIterator intIterator = this.iterator();
        while (intIterator.hasNext()) {
            if (!intCollection.contains(intIterator.next())) continue;
            intIterator.remove();
            bl = true;
        }
        return bl;
    }

    public boolean retainAll(IntCollection intCollection) {
        boolean bl = false;
        IntIterator intIterator = this.iterator();
        while (intIterator.hasNext()) {
            if (intCollection.contains(intIterator.next())) continue;
            intIterator.remove();
            bl = true;
        }
        return bl;
    }

    public int[] toArray(int[] nArray) {
        if (nArray.length < this.size()) {
            return this.toArray();
        }
        System.arraycopy((Object)this.array, this.first, (Object)nArray, 0, this.size());
        return nArray;
    }

    public int[] toArray() {
        return this.toArray(new int[this.size()]);
    }

    public int hashCode() {
        if (this.writes != this.hashWrites) {
            this.calcHashCode();
            this.hashWrites = this.writes;
        }
        return this.hashCode;
    }

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
        IntArrayList intArrayList = (IntArrayList)object;
        if (this.size() != intArrayList.size()) {
            return false;
        }
        for (int i2 = this.size() - 1; i2 >= 0; --i2) {
            if (this.array[this.first + i2] == intArrayList.array[intArrayList.first + i2]) continue;
            return false;
        }
        return true;
    }

    public void sort() {
        CollectionsHelper.sort(this.array, this.first, this.last);
    }

    public int indexOf(int n) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (n != this.array[i2]) continue;
            return i2 - this.first;
        }
        return -1;
    }

    public int lastIndexOf(int n) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (n != this.array[i2]) continue;
            return i2 - this.first;
        }
        return -1;
    }

    @Override
    public void onCollectionChanged() {
    }
}

