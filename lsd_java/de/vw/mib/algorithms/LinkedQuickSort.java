/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.algorithms;

import de.vw.mib.algorithms.LinkedQuickSort$1;
import java.util.Comparator;

public final class LinkedQuickSort {
    private static final Comparator COMPARABLE_COMPARATOR = new LinkedQuickSort$1();

    public static void sortLinkedArrays(Object[] objectArray, Object[] objectArray2) {
        LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2, 0, objectArray.length - 1, COMPARABLE_COMPARATOR);
    }

    public static void sortLinkedArrays(Object[] objectArray, Object[] objectArray2, int n, int n2) {
        LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2, n, n2, COMPARABLE_COMPARATOR);
    }

    public static void sortLinkedArrays(Object[] objectArray, Object[] objectArray2, Comparator comparator) {
        LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2, 0, objectArray.length - 1, comparator);
    }

    public static void sortLinkedArrays(Object[] objectArray, Object[] objectArray2, int n, int n2, Comparator comparator) {
        int n3 = n2 - n;
        if (n3 > 2) {
            int n4 = LinkedQuickSort.partition(objectArray, objectArray2, n, n2, comparator);
            LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2, n, n4 - 1, comparator);
            LinkedQuickSort.sortLinkedArrays(objectArray, objectArray2, n4 + 1, n2, comparator);
        } else if (n3 >= 1) {
            if (n3 == 1) {
                LinkedQuickSort.sortLinkedArray2Indices(objectArray, objectArray2, n, n2, comparator);
            } else if (n3 == 2) {
                LinkedQuickSort.sortLinkedArray3Indices(objectArray, objectArray2, n, n + 1, n2, comparator);
            }
        }
    }

    private static void sortLinkedArray2Indices(Object[] objectArray, Object[] objectArray2, int n, int n2, Comparator comparator) {
        if (comparator.compare(objectArray[n], objectArray[n2]) > 0) {
            LinkedQuickSort.exchangeBoth(objectArray, objectArray2, n, n2);
        }
    }

    private static void sortLinkedArray3Indices(Object[] objectArray, Object[] objectArray2, int n, int n2, int n3, Comparator comparator) {
        if (comparator.compare(objectArray[n2], objectArray[n3]) > 0) {
            LinkedQuickSort.exchangeBoth(objectArray, objectArray2, n2, n3);
        }
        if (comparator.compare(objectArray[n], objectArray[n3]) > 0) {
            LinkedQuickSort.exchangeBoth(objectArray, objectArray2, n, n3);
        }
        if (comparator.compare(objectArray[n], objectArray[n2]) > 0) {
            LinkedQuickSort.exchangeBoth(objectArray, objectArray2, n, n2);
        }
    }

    private static int partition(Object[] objectArray, Object[] objectArray2, int n, int n2, Comparator comparator) {
        LinkedQuickSort.sortPivotToRight(objectArray, objectArray2, n, n2, comparator);
        Object object = objectArray[n2];
        int n3 = n + 1;
        int n4 = n2 - 1;
        while (true) {
            if (comparator.compare(objectArray[n3], object) <= 0 && n3 < n2) {
                ++n3;
                continue;
            }
            while (comparator.compare(objectArray[n4], object) >= 0 && n4 > n3) {
                --n4;
            }
            if (n3 < n4) {
                LinkedQuickSort.exchangeBoth(objectArray, objectArray2, n3, n4);
            }
            if (n3 >= n4) break;
        }
        if (n3 < n2) {
            LinkedQuickSort.exchangeBoth(objectArray, objectArray2, n3, n2);
        }
        return n3;
    }

    private static void sortPivotToRight(Object[] objectArray, Object[] objectArray2, int n, int n2, Comparator comparator) {
        int n3 = n + n2 >>> 1;
        LinkedQuickSort.sortLinkedArray3Indices(objectArray, objectArray2, n, n2, n3, comparator);
    }

    public static void sortLinkedArrays(int[] nArray, Object[] objectArray) {
        LinkedQuickSort.sortLinkedArrays(nArray, objectArray, 0, nArray.length - 1);
    }

    public static void sortLinkedArrays(int[] nArray, Object[] objectArray, int n, int n2) {
        int n3 = n2 - n;
        if (n3 > 2) {
            int n4 = LinkedQuickSort.partition(nArray, objectArray, n, n2);
            LinkedQuickSort.sortLinkedArrays(nArray, objectArray, n, n4 - 1);
            LinkedQuickSort.sortLinkedArrays(nArray, objectArray, n4 + 1, n2);
        } else if (n3 >= 1) {
            if (n3 == 1) {
                LinkedQuickSort.sortLinkedArray2Indices(nArray, objectArray, n, n2);
            } else if (n3 == 2) {
                LinkedQuickSort.sortLinkedArray3Indices(nArray, objectArray, n, n + 1, n2);
            }
        }
    }

    private static void sortLinkedArray2Indices(int[] nArray, Object[] objectArray, int n, int n2) {
        if (nArray[n] > nArray[n2]) {
            LinkedQuickSort.exchangeBoth(nArray, objectArray, n, n2);
        }
    }

    private static void sortLinkedArray3Indices(int[] nArray, Object[] objectArray, int n, int n2, int n3) {
        if (nArray[n2] > nArray[n3]) {
            LinkedQuickSort.exchangeBoth(nArray, objectArray, n2, n3);
        }
        if (nArray[n] > nArray[n3]) {
            LinkedQuickSort.exchangeBoth(nArray, objectArray, n, n3);
        }
        if (nArray[n] > nArray[n2]) {
            LinkedQuickSort.exchangeBoth(nArray, objectArray, n, n2);
        }
    }

    private static int partition(int[] nArray, Object[] objectArray, int n, int n2) {
        LinkedQuickSort.sortPivotToRight(nArray, objectArray, n, n2);
        int n3 = nArray[n2];
        int n4 = n + 1;
        int n5 = n2 - 1;
        while (true) {
            if (nArray[n4] <= n3 && n4 < n2) {
                ++n4;
                continue;
            }
            while (nArray[n5] >= n3 && n5 > n4) {
                --n5;
            }
            if (n4 < n5) {
                LinkedQuickSort.exchangeBoth(nArray, objectArray, n4, n5);
            }
            if (n4 >= n5) break;
        }
        if (n4 < n2) {
            LinkedQuickSort.exchangeBoth(nArray, objectArray, n4, n2);
        }
        return n4;
    }

    private static void sortPivotToRight(int[] nArray, Object[] objectArray, int n, int n2) {
        int n3 = n + n2 >>> 1;
        LinkedQuickSort.sortLinkedArray3Indices(nArray, objectArray, n, n2, n3);
    }

    private static void exchangeBoth(Object[] objectArray, Object[] objectArray2, int n, int n2) {
        LinkedQuickSort.exchange(objectArray, n, n2);
        LinkedQuickSort.exchange(objectArray2, n, n2);
    }

    private static void exchangeBoth(int[] nArray, Object[] objectArray, int n, int n2) {
        LinkedQuickSort.exchange(nArray, n, n2);
        LinkedQuickSort.exchange(objectArray, n, n2);
    }

    private static void exchange(int[] nArray, int n, int n2) {
        int n3 = nArray[n];
        nArray[n] = nArray[n2];
        nArray[n2] = n3;
    }

    private static void exchange(Object[] objectArray, int n, int n2) {
        Object object = objectArray[n];
        objectArray[n] = objectArray[n2];
        objectArray[n2] = object;
    }
}

