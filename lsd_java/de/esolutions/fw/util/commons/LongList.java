/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

public class LongList
implements Cloneable {
    private static final int DEFAULT_CAPACITY;
    private static final int DEFAULT_CHUNK_SIZE;
    private int chunkSize;
    private long[] elementData;
    private int elementCount = 0;

    public LongList() {
        this(16, 16);
    }

    public LongList(int n) {
        this(n, 16);
    }

    public LongList(int n, int n2) {
        this.elementData = new long[n];
        this.chunkSize = n2;
    }

    public boolean add(long l) {
        this.ensureCapacity(this.elementCount);
        this.elementData[this.elementCount] = l;
        ++this.elementCount;
        return true;
    }

    public void add(int n, long l) {
        if (n < 0 || n > this.elementCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("invalid index ").append(n).append(" of ").append(this.elementCount).toString());
        }
        if (n == this.elementCount) {
            this.add(l);
        } else if (this.elementCount == this.elementData.length) {
            long[] lArray = new long[this.elementData.length + this.chunkSize];
            System.arraycopy((Object)this.elementData, 0, (Object)lArray, 0, n);
            lArray[n] = l;
            System.arraycopy((Object)this.elementData, n, (Object)lArray, n + 1, this.elementCount - n);
            this.elementData = lArray;
            ++this.elementCount;
        } else {
            System.arraycopy((Object)this.elementData, n, (Object)this.elementData, n + 1, this.elementCount - n);
            ++this.elementCount;
            this.elementData[n] = l;
        }
    }

    public void clear() {
        this.elementCount = 0;
    }

    public boolean contains(long l) {
        for (int i2 = 0; i2 < this.elementCount; ++i2) {
            if (this.elementData[i2] != l) continue;
            return true;
        }
        return false;
    }

    public long get(int n) {
        this.validateIndex(n);
        return this.elementData[n];
    }

    public int indexOf(long l) {
        for (int i2 = 0; i2 < this.elementCount; ++i2) {
            if (this.elementData[i2] != l) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(long l) {
        for (int i2 = this.elementCount - 1; i2 >= 0; --i2) {
            if (this.elementData[i2] != l) continue;
            return i2;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public int remove(int n) {
        this.validateIndex(n);
        System.arraycopy((Object)this.elementData, n + 1, (Object)this.elementData, n, this.elementCount - (n + 1));
        --this.elementCount;
        return 0;
    }

    public boolean removeElement(long l) {
        int n = this.indexOf(l);
        if (n == -1) {
            return false;
        }
        this.remove(n);
        return true;
    }

    public long set(int n, long l) {
        this.validateIndex(n);
        long l2 = this.elementData[n];
        this.elementData[n] = l;
        return l2;
    }

    public int size() {
        return this.elementCount;
    }

    public void ensureCapacity(int n) {
        if (n >= this.elementData.length) {
            int n2 = this.elementData.length + this.chunkSize;
            if (n > n2) {
                n2 = n;
            }
            long[] lArray = new long[n2];
            System.arraycopy((Object)this.elementData, 0, (Object)lArray, 0, this.elementCount);
            this.elementData = lArray;
        }
    }

    public void trimToSize() {
        long[] lArray = new long[this.elementCount];
        System.arraycopy((Object)this.elementData, 0, (Object)lArray, 0, this.elementCount);
        this.elementData = lArray;
    }

    public long[] toArray() {
        long[] lArray = new long[this.elementCount];
        System.arraycopy((Object)this.elementData, 0, (Object)lArray, 0, this.elementCount);
        return lArray;
    }

    public long[] toArray(long[] lArray) {
        long[] lArray2 = lArray.length < this.elementData.length ? new long[this.elementCount] : lArray;
        System.arraycopy((Object)this.elementData, 0, (Object)lArray2, 0, this.elementCount);
        return lArray2;
    }

    protected Object clone() {
        LongList longList = (LongList)super.clone();
        longList.elementData = new long[this.elementData.length];
        longList.chunkSize = this.chunkSize;
        System.arraycopy((Object)this.elementData, 0, (Object)longList.elementData, 0, this.elementCount);
        longList.elementCount = this.elementCount;
        return longList;
    }

    private void validateIndex(int n) {
        if (n < 0 || n >= this.elementCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.elementCount).toString());
        }
    }
}

