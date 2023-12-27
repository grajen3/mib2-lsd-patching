/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.algorithms;

public class ComparableTimSort {
    private static final int MIN_MERGE;
    private final Object[] array;
    private static final int MIN_GALLOP;
    private int minimalGallop = 7;
    private static final int INITIAL_TMP_STORAGE_LENGTH;
    private Object[] temp;
    private int tempBase;
    private int tempLen;
    private int stackSize = 0;
    private final int[] runBase;
    private final int[] runLen;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$algorithms$ComparableTimSort;

    private ComparableTimSort(Object[] objectArray, Object[] objectArray2, int n, int n2) {
        int n3;
        this.array = objectArray;
        int n4 = objectArray.length;
        int n5 = n3 = n4 < 512 ? n4 >>> 1 : 256;
        if (objectArray2 == null || n2 < n3 || n + n3 > objectArray2.length) {
            this.temp = new Object[n3];
            this.tempBase = 0;
            this.tempLen = n3;
        } else {
            this.temp = objectArray2;
            this.tempBase = n;
            this.tempLen = n2;
        }
        int n6 = n4 < 120 ? 5 : (n4 < 1542 ? 10 : (n4 < 1875968256 ? 24 : 49));
        this.runBase = new int[n6];
        this.runLen = new int[n6];
    }

    public static void sort(Object[] objectArray, int n, int n2) {
        int n3;
        if (!($assertionsDisabled || objectArray != null && n >= 0 && n <= n2 && n2 <= objectArray.length)) {
            throw new AssertionError();
        }
        int n4 = n2 - n;
        if (n4 < 2) {
            return;
        }
        if (n4 < 32) {
            int n5 = ComparableTimSort.countRunAndMakeAscending(objectArray, n, n2);
            ComparableTimSort.binarySort(objectArray, n, n2, n + n5);
            return;
        }
        ComparableTimSort comparableTimSort = new ComparableTimSort(objectArray, null, 0, 0);
        int n6 = ComparableTimSort.minRunLength(n4);
        do {
            if ((n3 = ComparableTimSort.countRunAndMakeAscending(objectArray, n, n2)) < n6) {
                int n7 = n4 <= n6 ? n4 : n6;
                ComparableTimSort.binarySort(objectArray, n, n + n7, n + n3);
                n3 = n7;
            }
            comparableTimSort.pushRun(n, n3);
            comparableTimSort.mergeCollapse();
            n += n3;
        } while ((n4 -= n3) != 0);
        if (!$assertionsDisabled && n != n2) {
            throw new AssertionError();
        }
        comparableTimSort.mergeForceCollapse();
        if (!$assertionsDisabled && comparableTimSort.stackSize != 1) {
            throw new AssertionError();
        }
    }

    private static void binarySort(Object[] objectArray, int n, int n2, int n3) {
        if (!($assertionsDisabled || n <= n3 && n3 <= n2)) {
            throw new AssertionError();
        }
        if (n3 == n) {
            ++n3;
        }
        while (n3 < n2) {
            int n4;
            Comparable comparable = (Comparable)objectArray[n3];
            int n5 = n;
            int n6 = n3;
            if (!$assertionsDisabled && n5 > n6) {
                throw new AssertionError();
            }
            while (n5 < n6) {
                n4 = n5 + n6 >>> 1;
                if (comparable.compareTo(objectArray[n4]) < 0) {
                    n6 = n4;
                    continue;
                }
                n5 = n4 + 1;
            }
            if (!$assertionsDisabled && n5 != n6) {
                throw new AssertionError();
            }
            n4 = n3 - n5;
            switch (n4) {
                case 1: {
                    objectArray[n5 + 1] = objectArray[n5];
                    break;
                }
                case 2: {
                    objectArray[n5 + 2] = objectArray[n5 + 1];
                    objectArray[n5 + 1] = objectArray[n5];
                    break;
                }
                default: {
                    System.arraycopy((Object)objectArray, n5, (Object)objectArray, n5 + 1, n4);
                }
            }
            objectArray[n5] = comparable;
            ++n3;
        }
    }

    private static int countRunAndMakeAscending(Object[] objectArray, int n, int n2) {
        if (!$assertionsDisabled && n >= n2) {
            throw new AssertionError();
        }
        int n3 = n + 1;
        if (n3 == n2) {
            return 1;
        }
        if (((Comparable)objectArray[n3++]).compareTo(objectArray[n]) < 0) {
            while (n3 < n2 && ((Comparable)objectArray[n3]).compareTo(objectArray[n3 - 1]) < 0) {
                ++n3;
            }
            ComparableTimSort.reverseRange(objectArray, n, n3);
        } else {
            while (n3 < n2 && ((Comparable)objectArray[n3]).compareTo(objectArray[n3 - 1]) >= 0) {
                ++n3;
            }
        }
        return n3 - n;
    }

    private static void reverseRange(Object[] objectArray, int n, int n2) {
        --n2;
        while (n < n2) {
            Object object = objectArray[n];
            objectArray[n++] = objectArray[n2];
            objectArray[n2--] = object;
        }
    }

    private static int minRunLength(int n) {
        if (!$assertionsDisabled && n < 0) {
            throw new AssertionError();
        }
        int n2 = 0;
        while (n >= 32) {
            n2 |= n & 1;
            n >>= 1;
        }
        return n + n2;
    }

    private void pushRun(int n, int n2) {
        this.runBase[this.stackSize] = n;
        this.runLen[this.stackSize] = n2;
        ++this.stackSize;
    }

    private void mergeCollapse() {
        while (this.stackSize > 1) {
            int n = this.stackSize - 2;
            if (n > 0 && this.runLen[n - 1] <= this.runLen[n] + this.runLen[n + 1]) {
                if (this.runLen[n - 1] < this.runLen[n + 1]) {
                    --n;
                }
                this.mergeAt(n);
                continue;
            }
            if (this.runLen[n] > this.runLen[n + 1]) break;
            this.mergeAt(n);
        }
    }

    private void mergeForceCollapse() {
        while (this.stackSize > 1) {
            int n = this.stackSize - 2;
            if (n > 0 && this.runLen[n - 1] < this.runLen[n + 1]) {
                --n;
            }
            this.mergeAt(n);
        }
    }

    private void mergeAt(int n) {
        if (!$assertionsDisabled && this.stackSize < 2) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && n < 0) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && n != this.stackSize - 2 && n != this.stackSize - 3) {
            throw new AssertionError();
        }
        int n2 = this.runBase[n];
        int n3 = this.runLen[n];
        int n4 = this.runBase[n + 1];
        int n5 = this.runLen[n + 1];
        if (!($assertionsDisabled || n3 > 0 && n5 > 0)) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && n2 + n3 != n4) {
            throw new AssertionError();
        }
        this.runLen[n] = n3 + n5;
        if (n == this.stackSize - 3) {
            this.runBase[n + 1] = this.runBase[n + 2];
            this.runLen[n + 1] = this.runLen[n + 2];
        }
        --this.stackSize;
        int n6 = ComparableTimSort.gallopRight((Comparable)this.array[n4], this.array, n2, n3, 0);
        if (!$assertionsDisabled && n6 < 0) {
            throw new AssertionError();
        }
        n2 += n6;
        if ((n3 -= n6) == 0) {
            return;
        }
        n5 = ComparableTimSort.gallopLeft((Comparable)this.array[n2 + n3 - 1], this.array, n4, n5, n5 - 1);
        if (!$assertionsDisabled && n5 < 0) {
            throw new AssertionError();
        }
        if (n5 == 0) {
            return;
        }
        if (n3 <= n5) {
            this.mergeLo(n2, n3, n4, n5);
        } else {
            this.mergeHi(n2, n3, n4, n5);
        }
    }

    private static int gallopLeft(Comparable comparable, Object[] objectArray, int n, int n2, int n3) {
        int n4;
        if (!($assertionsDisabled || n2 > 0 && n3 >= 0 && n3 < n2)) {
            throw new AssertionError();
        }
        int n5 = 0;
        int n6 = 1;
        if (comparable.compareTo(objectArray[n + n3]) > 0) {
            n4 = n2 - n3;
            while (n6 < n4 && comparable.compareTo(objectArray[n + n3 + n6]) > 0) {
                n5 = n6;
                if ((n6 = (n6 << 1) + 1) > 0) continue;
                n6 = n4;
            }
            if (n6 > n4) {
                n6 = n4;
            }
            n5 += n3;
            n6 += n3;
        } else {
            n4 = n3 + 1;
            while (n6 < n4 && comparable.compareTo(objectArray[n + n3 - n6]) <= 0) {
                n5 = n6;
                if ((n6 = (n6 << 1) + 1) > 0) continue;
                n6 = n4;
            }
            if (n6 > n4) {
                n6 = n4;
            }
            int n7 = n5;
            n5 = n3 - n6;
            n6 = n3 - n7;
        }
        if (!($assertionsDisabled || -1 <= n5 && n5 < n6 && n6 <= n2)) {
            throw new AssertionError();
        }
        ++n5;
        while (n5 < n6) {
            n4 = n5 + (n6 - n5 >>> 1);
            if (comparable.compareTo(objectArray[n + n4]) > 0) {
                n5 = n4 + 1;
                continue;
            }
            n6 = n4;
        }
        if (!$assertionsDisabled && n5 != n6) {
            throw new AssertionError();
        }
        return n6;
    }

    private static int gallopRight(Comparable comparable, Object[] objectArray, int n, int n2, int n3) {
        int n4;
        if (!($assertionsDisabled || n2 > 0 && n3 >= 0 && n3 < n2)) {
            throw new AssertionError();
        }
        int n5 = 1;
        int n6 = 0;
        if (comparable.compareTo(objectArray[n + n3]) < 0) {
            n4 = n3 + 1;
            while (n5 < n4 && comparable.compareTo(objectArray[n + n3 - n5]) < 0) {
                n6 = n5;
                if ((n5 = (n5 << 1) + 1) > 0) continue;
                n5 = n4;
            }
            if (n5 > n4) {
                n5 = n4;
            }
            int n7 = n6;
            n6 = n3 - n5;
            n5 = n3 - n7;
        } else {
            n4 = n2 - n3;
            while (n5 < n4 && comparable.compareTo(objectArray[n + n3 + n5]) >= 0) {
                n6 = n5;
                if ((n5 = (n5 << 1) + 1) > 0) continue;
                n5 = n4;
            }
            if (n5 > n4) {
                n5 = n4;
            }
            n6 += n3;
            n5 += n3;
        }
        if (!($assertionsDisabled || -1 <= n6 && n6 < n5 && n5 <= n2)) {
            throw new AssertionError();
        }
        ++n6;
        while (n6 < n5) {
            n4 = n6 + (n5 - n6 >>> 1);
            if (comparable.compareTo(objectArray[n + n4]) < 0) {
                n5 = n4;
                continue;
            }
            n6 = n4 + 1;
        }
        if (!$assertionsDisabled && n6 != n5) {
            throw new AssertionError();
        }
        return n5;
    }

    private void mergeLo(int n, int n2, int n3, int n4) {
        if (!($assertionsDisabled || n2 > 0 && n4 > 0 && n + n2 == n3)) {
            throw new AssertionError();
        }
        Object[] objectArray = this.array;
        Object[] objectArray2 = this.ensureCapacity(n2);
        int n5 = this.tempBase;
        int n6 = n3;
        int n7 = n;
        System.arraycopy((Object)objectArray, n, (Object)objectArray2, n5, n2);
        objectArray[n7++] = objectArray[n6++];
        if (--n4 == 0) {
            System.arraycopy((Object)objectArray2, n5, (Object)objectArray, n7, n2);
            return;
        }
        if (n2 == 1) {
            System.arraycopy((Object)objectArray, n6, (Object)objectArray, n7, n4);
            objectArray[n7 + n4] = objectArray2[n5];
            return;
        }
        int n8 = this.minimalGallop;
        block0: while (true) {
            int n9 = 0;
            int n10 = 0;
            do {
                if (!($assertionsDisabled || n2 > 1 && n4 > 0)) {
                    throw new AssertionError();
                }
                if (((Comparable)objectArray[n6]).compareTo(objectArray2[n5]) < 0) {
                    objectArray[n7++] = objectArray[n6++];
                    ++n10;
                    n9 = 0;
                    if (--n4 != 0) continue;
                    break block0;
                }
                objectArray[n7++] = objectArray2[n5++];
                ++n9;
                n10 = 0;
                if (--n2 == 1) break block0;
            } while ((n9 | n10) < n8);
            do {
                if (!($assertionsDisabled || n2 > 1 && n4 > 0)) {
                    throw new AssertionError();
                }
                n9 = ComparableTimSort.gallopRight((Comparable)objectArray[n6], objectArray2, n5, n2, 0);
                if (n9 != 0) {
                    System.arraycopy((Object)objectArray2, n5, (Object)objectArray, n7, n9);
                    n7 += n9;
                    n5 += n9;
                    if ((n2 -= n9) <= 1) break block0;
                }
                objectArray[n7++] = objectArray[n6++];
                if (--n4 == 0) break block0;
                n10 = ComparableTimSort.gallopLeft((Comparable)objectArray2[n5], objectArray, n6, n4, 0);
                if (n10 != 0) {
                    System.arraycopy((Object)objectArray, n6, (Object)objectArray, n7, n10);
                    n7 += n10;
                    n6 += n10;
                    if ((n4 -= n10) == 0) break block0;
                }
                objectArray[n7++] = objectArray2[n5++];
                if (--n2 == 1) break block0;
                --n8;
            } while (n9 >= 7 | n10 >= 7);
            if (n8 < 0) {
                n8 = 0;
            }
            n8 += 2;
        }
        int n11 = this.minimalGallop = n8 < 1 ? 1 : n8;
        if (n2 == 1) {
            if (!$assertionsDisabled && n4 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy((Object)objectArray, n6, (Object)objectArray, n7, n4);
            objectArray[n7 + n4] = objectArray2[n5];
        } else {
            if (n2 == 0) {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
            if (!$assertionsDisabled && n4 != 0) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && n2 <= 1) {
                throw new AssertionError();
            }
            System.arraycopy((Object)objectArray2, n5, (Object)objectArray, n7, n2);
        }
    }

    private void mergeHi(int n, int n2, int n3, int n4) {
        if (!($assertionsDisabled || n2 > 0 && n4 > 0 && n + n2 == n3)) {
            throw new AssertionError();
        }
        Object[] objectArray = this.array;
        Object[] objectArray2 = this.ensureCapacity(n4);
        int n5 = this.tempBase;
        System.arraycopy((Object)objectArray, n3, (Object)objectArray2, n5, n4);
        int n6 = n + n2 - 1;
        int n7 = n5 + n4 - 1;
        int n8 = n3 + n4 - 1;
        objectArray[n8--] = objectArray[n6--];
        if (--n2 == 0) {
            System.arraycopy((Object)objectArray2, n5, (Object)objectArray, n8 - (n4 - 1), n4);
            return;
        }
        if (n4 == 1) {
            System.arraycopy((Object)objectArray, (n6 -= n2) + 1, (Object)objectArray, (n8 -= n2) + 1, n2);
            objectArray[n8] = objectArray2[n7];
            return;
        }
        int n9 = this.minimalGallop;
        block0: while (true) {
            int n10 = 0;
            int n11 = 0;
            do {
                if (!($assertionsDisabled || n2 > 0 && n4 > 1)) {
                    throw new AssertionError();
                }
                if (((Comparable)objectArray2[n7]).compareTo(objectArray[n6]) < 0) {
                    objectArray[n8--] = objectArray[n6--];
                    ++n10;
                    n11 = 0;
                    if (--n2 != 0) continue;
                    break block0;
                }
                objectArray[n8--] = objectArray2[n7--];
                ++n11;
                n10 = 0;
                if (--n4 == 1) break block0;
            } while ((n10 | n11) < n9);
            do {
                if (!($assertionsDisabled || n2 > 0 && n4 > 1)) {
                    throw new AssertionError();
                }
                n10 = n2 - ComparableTimSort.gallopRight((Comparable)objectArray2[n7], objectArray, n, n2, n2 - 1);
                if (n10 != 0) {
                    System.arraycopy((Object)objectArray, (n6 -= n10) + 1, (Object)objectArray, (n8 -= n10) + 1, n10);
                    if ((n2 -= n10) == 0) break block0;
                }
                objectArray[n8--] = objectArray2[n7--];
                if (--n4 == 1) break block0;
                n11 = n4 - ComparableTimSort.gallopLeft((Comparable)objectArray[n6], objectArray2, n5, n4, n4 - 1);
                if (n11 != 0) {
                    System.arraycopy((Object)objectArray2, (n7 -= n11) + 1, (Object)objectArray, (n8 -= n11) + 1, n11);
                    if ((n4 -= n11) <= 1) break block0;
                }
                objectArray[n8--] = objectArray[n6--];
                if (--n2 == 0) break block0;
                --n9;
            } while (n10 >= 7 | n11 >= 7);
            if (n9 < 0) {
                n9 = 0;
            }
            n9 += 2;
        }
        int n12 = this.minimalGallop = n9 < 1 ? 1 : n9;
        if (n4 == 1) {
            if (!$assertionsDisabled && n2 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy((Object)objectArray, (n6 -= n2) + 1, (Object)objectArray, (n8 -= n2) + 1, n2);
            objectArray[n8] = objectArray2[n7];
        } else {
            if (n4 == 0) {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
            if (!$assertionsDisabled && n2 != 0) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && n4 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy((Object)objectArray2, n5, (Object)objectArray, n8 - (n4 - 1), n4);
        }
    }

    private Object[] ensureCapacity(int n) {
        if (this.tempLen < n) {
            int n2 = n;
            n2 |= n2 >> 1;
            n2 |= n2 >> 2;
            n2 |= n2 >> 4;
            n2 |= n2 >> 8;
            n2 |= n2 >> 16;
            n2 = ++n2 < 0 ? n : Math.min(n2, this.array.length >>> 1);
            Object[] objectArray = new Object[n2];
            this.temp = objectArray;
            this.tempLen = n2;
            this.tempBase = 0;
        }
        return this.temp;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$algorithms$ComparableTimSort == null ? (class$de$vw$mib$algorithms$ComparableTimSort = ComparableTimSort.class$("de.vw.mib.algorithms.ComparableTimSort")) : class$de$vw$mib$algorithms$ComparableTimSort).desiredAssertionStatus();
    }
}

