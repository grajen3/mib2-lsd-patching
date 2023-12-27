/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

public class IntList
implements Cloneable {
    private static final int DEFAULT_CAPACITY;
    private static final int DEFAULT_CHUNK_SIZE;
    private int chunkSize;
    private int[] elementData;
    private int elementCount = 0;

    public IntList() {
        this(16, 16);
    }

    public IntList(int n) {
        this(n, 16);
    }

    public IntList(int n, int n2) {
        this.elementData = new int[n];
        this.chunkSize = n2;
    }

    public boolean add(int n) {
        this.ensureCapacity(this.elementCount);
        this.elementData[this.elementCount] = n;
        ++this.elementCount;
        return true;
    }

    public void add(int n, int n2) {
        if (n < 0 || n > this.elementCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("invalid index ").append(n).append(" of ").append(this.elementCount).toString());
        }
        if (n == this.elementCount) {
            this.add(n2);
        } else if (this.elementCount == this.elementData.length) {
            int[] nArray = new int[this.elementData.length + this.chunkSize];
            System.arraycopy((Object)this.elementData, 0, (Object)nArray, 0, n);
            nArray[n] = n2;
            System.arraycopy((Object)this.elementData, n, (Object)nArray, n + 1, this.elementCount - n);
            this.elementData = nArray;
            ++this.elementCount;
        } else {
            System.arraycopy((Object)this.elementData, n, (Object)this.elementData, n + 1, this.elementCount - n);
            ++this.elementCount;
            this.elementData[n] = n2;
        }
    }

    public void addAll(int[] nArray) {
        this.ensureCapacity(this.elementCount + nArray.length);
        System.arraycopy((Object)nArray, 0, (Object)this.elementData, this.elementCount, nArray.length);
        this.elementCount += nArray.length;
    }

    public void addAll(int n, int[] nArray) {
        if (n < 0 || n > this.elementCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("invalid index ").append(n).append(" of ").append(this.elementCount).toString());
        }
        if (n == this.elementCount) {
            this.addAll(nArray);
        } else {
            this.ensureCapacity(this.elementCount + nArray.length);
            System.arraycopy((Object)this.elementData, n, (Object)this.elementData, n + nArray.length, this.elementCount - n);
            System.arraycopy((Object)nArray, n, (Object)this.elementData, this.elementCount, nArray.length);
            this.elementCount += nArray.length;
        }
    }

    public void addAll(IntList intList) {
        this.ensureCapacity(this.elementCount + intList.elementCount);
        System.arraycopy((Object)intList.elementData, 0, (Object)this.elementData, this.elementCount, intList.elementCount);
        this.elementCount += intList.elementCount;
    }

    public void addAll(int n, IntList intList) {
        if (n < 0 || n > this.elementCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("invalid index ").append(n).append(" of ").append(this.elementCount).toString());
        }
        if (n == this.elementCount) {
            this.addAll(intList);
        } else {
            this.ensureCapacity(this.elementCount + intList.elementCount);
            System.arraycopy((Object)this.elementData, n, (Object)this.elementData, n + intList.elementCount, this.elementCount - n);
            System.arraycopy((Object)intList.elementData, n, (Object)this.elementData, this.elementCount, intList.elementCount);
            this.elementCount += intList.elementCount;
        }
    }

    public void removeAll(int[] nArray) {
        int n = this.elementCount;
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = false;
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (this.elementData[i2] != nArray[i3]) continue;
                bl = true;
                break;
            }
            if (bl) {
                --this.elementCount;
                continue;
            }
            if (i2 != n2) {
                this.elementData[n2] = this.elementData[i2];
            }
            ++n2;
        }
    }

    public void removeAll(IntList intList) {
        int n = this.elementCount;
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            boolean bl = intList.contains(this.elementData[i2]);
            if (bl) {
                --this.elementCount;
                continue;
            }
            if (i2 != n2) {
                this.elementData[n2] = this.elementData[i2];
            }
            ++n2;
        }
    }

    public void clear() {
        this.elementCount = 0;
    }

    public boolean contains(int n) {
        for (int i2 = 0; i2 < this.elementCount; ++i2) {
            if (this.elementData[i2] != n) continue;
            return true;
        }
        return false;
    }

    public int get(int n) {
        this.validateIndex(n);
        return this.elementData[n];
    }

    public int indexOf(int n) {
        for (int i2 = 0; i2 < this.elementCount; ++i2) {
            if (this.elementData[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    public int lastIndexOf(int n) {
        for (int i2 = this.elementCount - 1; i2 >= 0; --i2) {
            if (this.elementData[i2] != n) continue;
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

    public boolean removeElement(int n) {
        int n2 = this.indexOf(n);
        if (n2 == -1) {
            return false;
        }
        this.remove(n2);
        return true;
    }

    public int set(int n, int n2) {
        this.validateIndex(n);
        int n3 = this.elementData[n];
        this.elementData[n] = n2;
        return n3;
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
            int[] nArray = new int[n2];
            System.arraycopy((Object)this.elementData, 0, (Object)nArray, 0, this.elementCount);
            this.elementData = nArray;
        }
    }

    public void trimToSize() {
        int[] nArray = new int[this.elementCount];
        System.arraycopy((Object)this.elementData, 0, (Object)nArray, 0, this.elementCount);
        this.elementData = nArray;
    }

    public int[] toArray() {
        int[] nArray = new int[this.elementCount];
        System.arraycopy((Object)this.elementData, 0, (Object)nArray, 0, this.elementCount);
        return nArray;
    }

    public int[] toArray(int[] nArray) {
        int[] nArray2 = nArray.length < this.elementData.length ? new int[this.elementCount] : nArray;
        System.arraycopy((Object)this.elementData, 0, (Object)nArray2, 0, this.elementCount);
        return nArray2;
    }

    protected Object clone() {
        IntList intList = (IntList)super.clone();
        intList.elementData = new int[this.elementData.length];
        intList.chunkSize = this.chunkSize;
        System.arraycopy((Object)this.elementData, 0, (Object)intList.elementData, 0, this.elementCount);
        intList.elementCount = this.elementCount;
        return intList;
    }

    private void validateIndex(int n) {
        if (n < 0 || n >= this.elementCount) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Size: ").append(this.elementCount).toString());
        }
    }
}

