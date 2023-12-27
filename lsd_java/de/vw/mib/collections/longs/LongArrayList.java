/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongArrayList$1;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public class LongArrayList
implements CollectionWithExpansionPoint {
    private static final long[] EMPTY_ARRAY = new long[0];
    long[] array;
    int first;
    int last;
    private int arraylength;
    protected int writes;
    private int hashCode;
    private int hashWrites;
    int sizeWarningThreshold;

    public LongArrayList() {
        this(EMPTY_ARRAY);
    }

    public LongArrayList(int n) {
        this(n == 0 ? EMPTY_ARRAY : new long[n]);
    }

    private LongArrayList(long[] lArray) {
        this.array = lArray;
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
        this.array = new long[this.arraylength];
    }

    private boolean isResetNecessary(int n) {
        return this.last + n > this.arraylength;
    }

    private void increaseArraysize(int n) {
        int n2 = this.arraylength + n;
        n2 = n2 > 23 ? 3 * n2 / 2 : n2 + 12;
        this.initArray(n2);
        if (this.size() + n > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("longArrayList", this.arraylength, 4);
        }
    }

    private boolean isResizeNecessary(int n) {
        return this.size() + n > this.arraylength;
    }

    public boolean add(long l) {
        if (this.isResizeNecessary(1)) {
            long[] lArray = this.array;
            this.increaseArraysize(1);
            this.moveArrayContentTo0(lArray);
        } else if (this.isResetNecessary(1)) {
            int n = this.last;
            this.moveArrayContentTo0(this.array);
            Arrays.fill(this.array, this.last, n, 0L);
        }
        this.array[this.last] = l;
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    private void moveArrayContentTo0(long[] lArray) {
        System.arraycopy((Object)lArray, this.first, (Object)this.array, 0, this.size());
        this.last -= this.first;
        this.first = 0;
    }

    public void addFirst(long l) {
        if (this.first == 0) {
            this.add(0, l);
            return;
        }
        --this.first;
        this.array[this.first] = l;
        ++this.writes;
        this.onCollectionChanged();
    }

    public void add(int n, long l) {
        int n2 = this.first + n;
        if (n == 0) {
            if (this.first > 0) {
                this.addFirst(l);
                return;
            }
        } else {
            if (n2 == this.last) {
                this.add(l);
                return;
            }
            if (n < 0 || n2 > this.last) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
            }
        }
        if (this.isResizeNecessary(1)) {
            long[] lArray = this.array;
            this.increaseArraysize(1);
            System.arraycopy((Object)lArray, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = l;
            System.arraycopy((Object)lArray, n2, (Object)this.array, n + 1, this.last - n);
        } else if (this.isResetNecessary(1)) {
            int n3 = this.last;
            System.arraycopy((Object)this.array, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = l;
            System.arraycopy((Object)this.array, n2, (Object)this.array, n + 1, this.last - n);
            Arrays.fill(this.array, this.last + 1, n3, 0L);
        } else {
            System.arraycopy((Object)this.array, n2, (Object)this.array, n2 + 1, this.last - n2);
            this.array[n2] = l;
        }
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
    }

    public long set(int n, long l) {
        int n2 = this.first + n;
        if (n2 < this.first || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        long l2 = this.array[n2];
        this.array[n2] = l;
        ++this.writes;
        this.onCollectionChanged();
        return l2;
    }

    public void clear() {
        Arrays.fill(this.array, this.first, this.last, 0L);
        this.first = 0;
        this.last = 0;
        ++this.writes;
        this.onCollectionChanged();
    }

    public long get(int n) {
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
        this.array[this.first++] = 0L;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean removeLast() {
        if (this.isEmpty()) {
            return false;
        }
        this.array[--this.last] = 0L;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public long remove(int n) {
        int n2 = this.first + n;
        if (n < 0 || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        long l = this.array[n2];
        if (n2 == this.last - 1) {
            this.array[--this.last] = 0L;
        } else if (n == 0) {
            this.array[this.first++] = 0L;
        } else if (n < this.last - n2 - 1) {
            System.arraycopy((Object)this.array, this.first, (Object)this.array, this.first + 1, n);
            this.array[this.first++] = 0L;
        } else {
            System.arraycopy((Object)this.array, n2 + 1, (Object)this.array, n2, this.last - n2 - 1);
            this.array[--this.last] = 0L;
        }
        ++this.writes;
        this.onCollectionChanged();
        return l;
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
        Arrays.fill(this.array, n4 + n6, this.last, 0L);
        this.last -= n2;
        ++this.writes;
        this.onCollectionChanged();
    }

    public long last() {
        return this.array[this.last - 1];
    }

    public boolean removeValue(long l) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (l != this.array[i2]) continue;
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

    public boolean contains(long l) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (l != this.array[i2]) continue;
            return true;
        }
        return false;
    }

    public LongIterator iterator() {
        return new LongArrayList$1(this);
    }

    public boolean addAll(LongCollection longCollection) {
        return this.addAll(this.size(), longCollection);
    }

    public boolean addAll(int n, LongCollection longCollection) {
        Object object;
        if (n < 0 || this.size() < n) {
            throw new IndexOutOfBoundsException();
        }
        int n2 = longCollection.size();
        if (0 == n2) {
            return false;
        }
        if (this.isResizeNecessary(n2)) {
            object = this.array;
            this.increaseArraysize(n2);
            this.moveArrayContentTo0((long[])object);
        } else if (this.isResetNecessary(n2)) {
            this.moveArrayContentTo0(this.array);
        }
        if (this.last > n) {
            System.arraycopy((Object)this.array, n, (Object)this.array, n + n2, this.last - n);
        }
        this.last += n2;
        object = longCollection.iterator();
        int n3 = n;
        while (object.hasNext()) {
            this.array[n3] = object.next();
            ++n3;
        }
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean containsAll(LongCollection longCollection) {
        LongIterator longIterator = longCollection.iterator();
        while (longIterator.hasNext()) {
            if (this.contains(longIterator.next())) continue;
            return false;
        }
        return true;
    }

    public boolean removeAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = this.iterator();
        while (longIterator.hasNext()) {
            if (!longCollection.contains(longIterator.next())) continue;
            longIterator.remove();
            bl = true;
        }
        return bl;
    }

    public boolean retainAll(LongCollection longCollection) {
        boolean bl = false;
        LongIterator longIterator = this.iterator();
        while (longIterator.hasNext()) {
            if (longCollection.contains(longIterator.next())) continue;
            longIterator.remove();
            bl = true;
        }
        return bl;
    }

    public long[] toArray(long[] lArray) {
        if (lArray.length < this.size()) {
            return this.toArray();
        }
        System.arraycopy((Object)this.array, this.first, (Object)lArray, 0, this.size());
        return lArray;
    }

    public long[] toArray() {
        return this.toArray(new long[this.size()]);
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
        LongArrayList longArrayList = (LongArrayList)object;
        if (this.size() != longArrayList.size()) {
            return false;
        }
        for (int i2 = this.size() - 1; i2 >= 0; --i2) {
            if (this.array[this.first + i2] == longArrayList.array[longArrayList.first + i2]) continue;
            return false;
        }
        return true;
    }

    public void sort() {
        CollectionsHelper.sort(this.array, this.first, this.last);
    }

    public int indexOf(long l) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (l != this.array[i2]) continue;
            return i2 - this.first;
        }
        return -1;
    }

    public int lastIndexOf(long l) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (l != this.array[i2]) continue;
            return i2 - this.first;
        }
        return -1;
    }

    @Override
    public void onCollectionChanged() {
    }
}

