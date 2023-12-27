/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.CollectionWithExpansionPoint;
import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.floats.FloatArrayList$1;
import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public class FloatArrayList
implements CollectionWithExpansionPoint {
    private static final float[] EMPTY_ARRAY = new float[0];
    float[] array;
    int first;
    int last;
    private int arraylength;
    protected int writes;
    private int hashCode;
    private int hashWrites;
    int sizeWarningThreshold;

    public FloatArrayList() {
        this(EMPTY_ARRAY);
    }

    public FloatArrayList(int n) {
        this(n == 0 ? EMPTY_ARRAY : new float[n]);
    }

    private FloatArrayList(float[] fArray) {
        this.array = fArray;
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
        this.array = new float[this.arraylength];
    }

    private boolean isResetNecessary(int n) {
        return this.last + n > this.arraylength;
    }

    private void increaseArraysize(int n) {
        int n2 = this.arraylength + n;
        n2 = n2 > 23 ? 3 * n2 / 2 : n2 + 12;
        this.initArray(n2);
        if (this.size() + n > this.sizeWarningThreshold) {
            CollectionsHelper.writeSizeWarning("floatArrayList", this.arraylength, 4);
        }
    }

    private boolean isResizeNecessary(int n) {
        return this.size() + n > this.arraylength;
    }

    public boolean add(float f2) {
        if (this.isResizeNecessary(1)) {
            float[] fArray = this.array;
            this.increaseArraysize(1);
            this.moveArrayContentTo0(fArray);
        } else if (this.isResetNecessary(1)) {
            int n = this.last;
            this.moveArrayContentTo0(this.array);
            Arrays.fill(this.array, this.last, n, 0.0f);
        }
        this.array[this.last] = f2;
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    private void moveArrayContentTo0(float[] fArray) {
        System.arraycopy((Object)fArray, this.first, (Object)this.array, 0, this.size());
        this.last -= this.first;
        this.first = 0;
    }

    public void addFirst(float f2) {
        if (this.first == 0) {
            this.add(0, f2);
            return;
        }
        --this.first;
        this.array[this.first] = f2;
        ++this.writes;
        this.onCollectionChanged();
    }

    public void add(int n, float f2) {
        int n2 = this.first + n;
        if (n == 0) {
            if (this.first > 0) {
                this.addFirst(f2);
                return;
            }
        } else {
            if (n2 == this.last) {
                this.add(f2);
                return;
            }
            if (n < 0 || n2 > this.last) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
            }
        }
        if (this.isResizeNecessary(1)) {
            float[] fArray = this.array;
            this.increaseArraysize(1);
            System.arraycopy((Object)fArray, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = f2;
            System.arraycopy((Object)fArray, n2, (Object)this.array, n + 1, this.last - n);
        } else if (this.isResetNecessary(1)) {
            int n3 = this.last;
            System.arraycopy((Object)this.array, this.first, (Object)this.array, 0, n);
            this.last -= this.first;
            this.first = 0;
            this.array[n] = f2;
            System.arraycopy((Object)this.array, n2, (Object)this.array, n + 1, this.last - n);
            Arrays.fill(this.array, this.last + 1, n3, 0.0f);
        } else {
            System.arraycopy((Object)this.array, n2, (Object)this.array, n2 + 1, this.last - n2);
            this.array[n2] = f2;
        }
        ++this.last;
        ++this.writes;
        this.onCollectionChanged();
    }

    public float set(int n, float f2) {
        int n2 = this.first + n;
        if (n2 < this.first || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        float f3 = this.array[n2];
        this.array[n2] = f2;
        ++this.writes;
        this.onCollectionChanged();
        return f3;
    }

    public void clear() {
        Arrays.fill(this.array, this.first, this.last, 0.0f);
        this.first = 0;
        this.last = 0;
        ++this.writes;
        this.onCollectionChanged();
    }

    public float get(int n) {
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
        this.array[this.first++] = 0.0f;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean removeLast() {
        if (this.isEmpty()) {
            return false;
        }
        this.array[--this.last] = 0.0f;
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public float remove(int n) {
        int n2 = this.first + n;
        if (n < 0 || n2 >= this.last) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("location=").append(n).append(", size=").append(this.size()).toString());
        }
        float f2 = this.array[n2];
        if (n2 == this.last - 1) {
            this.array[--this.last] = 0.0f;
        } else if (n == 0) {
            this.array[this.first++] = 0.0f;
        } else if (n < this.last - n2 - 1) {
            System.arraycopy((Object)this.array, this.first, (Object)this.array, this.first + 1, n);
            this.array[this.first++] = 0.0f;
        } else {
            System.arraycopy((Object)this.array, n2 + 1, (Object)this.array, n2, this.last - n2 - 1);
            this.array[--this.last] = 0.0f;
        }
        ++this.writes;
        this.onCollectionChanged();
        return f2;
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
        Arrays.fill(this.array, n4 + n6, this.last, 0.0f);
        this.last -= n2;
        ++this.writes;
        this.onCollectionChanged();
    }

    public float last() {
        return this.array[this.last - 1];
    }

    public boolean removeValue(float f2) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (f2 != this.array[i2]) continue;
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

    public boolean contains(float f2) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (f2 != this.array[i2]) continue;
            return true;
        }
        return false;
    }

    public FloatIterator iterator() {
        return new FloatArrayList$1(this);
    }

    public boolean addAll(FloatCollection floatCollection) {
        return this.addAll(this.size(), floatCollection);
    }

    public boolean addAll(int n, FloatCollection floatCollection) {
        Object object;
        if (n < 0 || this.size() < n) {
            throw new IndexOutOfBoundsException();
        }
        int n2 = floatCollection.size();
        if (0 == n2) {
            return false;
        }
        if (this.isResizeNecessary(n2)) {
            object = this.array;
            this.increaseArraysize(n2);
            this.moveArrayContentTo0((float[])object);
        } else if (this.isResetNecessary(n2)) {
            this.moveArrayContentTo0(this.array);
        }
        if (this.last > n) {
            System.arraycopy((Object)this.array, n, (Object)this.array, n + n2, this.last - n);
        }
        this.last += n2;
        object = floatCollection.iterator();
        int n3 = n;
        while (object.hasNext()) {
            this.array[n3] = object.next();
            ++n3;
        }
        ++this.writes;
        this.onCollectionChanged();
        return true;
    }

    public boolean containsAll(FloatCollection floatCollection) {
        FloatIterator floatIterator = floatCollection.iterator();
        while (floatIterator.hasNext()) {
            if (this.contains(floatIterator.next())) continue;
            return false;
        }
        return true;
    }

    public boolean removeAll(FloatCollection floatCollection) {
        boolean bl = false;
        FloatIterator floatIterator = this.iterator();
        while (floatIterator.hasNext()) {
            if (!floatCollection.contains(floatIterator.next())) continue;
            floatIterator.remove();
            bl = true;
        }
        return bl;
    }

    public boolean retainAll(FloatCollection floatCollection) {
        boolean bl = false;
        FloatIterator floatIterator = this.iterator();
        while (floatIterator.hasNext()) {
            if (floatCollection.contains(floatIterator.next())) continue;
            floatIterator.remove();
            bl = true;
        }
        return bl;
    }

    public float[] toArray(float[] fArray) {
        if (fArray.length < this.size()) {
            return this.toArray();
        }
        System.arraycopy((Object)this.array, this.first, (Object)fArray, 0, this.size());
        return fArray;
    }

    public float[] toArray() {
        return this.toArray(new float[this.size()]);
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
        FloatArrayList floatArrayList = (FloatArrayList)object;
        if (this.size() != floatArrayList.size()) {
            return false;
        }
        for (int i2 = this.size() - 1; i2 >= 0; --i2) {
            if (this.array[this.first + i2] == floatArrayList.array[floatArrayList.first + i2]) continue;
            return false;
        }
        return true;
    }

    public void sort() {
        CollectionsHelper.sort(this.array, this.first, this.last);
    }

    public int indexOf(float f2) {
        for (int i2 = this.first; i2 < this.last; ++i2) {
            if (f2 != this.array[i2]) continue;
            return i2 - this.first;
        }
        return -1;
    }

    public int lastIndexOf(float f2) {
        for (int i2 = this.last - 1; i2 >= this.first; --i2) {
            if (f2 != this.array[i2]) continue;
            return i2 - this.first;
        }
        return -1;
    }

    @Override
    public void onCollectionChanged() {
    }
}

