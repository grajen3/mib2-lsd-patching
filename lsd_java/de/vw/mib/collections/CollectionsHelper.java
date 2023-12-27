/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.algorithms.ComparableTimSort;
import de.vw.mib.algorithms.TimSort;
import de.vw.mib.collections.CollectionsHelper$SizeWarningsListener;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.Comparator;

public final class CollectionsHelper {
    public static final int DEFAULT_SIZE_WARNING_THRESHOLD = Integer.getInteger("de.vw.mib.collections.sizeWarningThreshold", 500);
    private static CollectionsHelper$SizeWarningsListener sizeWarningsListener;

    private CollectionsHelper() {
    }

    public static void sort(char[] cArray, int n, int n2) {
        Arrays.sort(cArray, n, n2);
    }

    public static void sort(int[] nArray, int n, int n2) {
        Arrays.sort(nArray, n, n2);
    }

    public static void sort(float[] fArray, int n, int n2) {
        Arrays.sort(fArray, n, n2);
    }

    public static void sort(long[] lArray, int n, int n2) {
        Arrays.sort(lArray, n, n2);
    }

    public static void sort(boolean[] blArray, int n, int n2) {
        int n3 = n;
        int n4 = n2 - 1;
        while (true) {
            if (n3 < n4 && !blArray[n3]) {
                ++n3;
                continue;
            }
            while (n3 < n4 && blArray[n4]) {
                --n4;
            }
            if (n3 >= n4) {
                return;
            }
            blArray[n3] = false;
            blArray[n4] = true;
        }
    }

    public static void sort(Object[] objectArray, int n, int n2) {
        ComparableTimSort.sort(objectArray, n, n2);
    }

    public static void sort(Object[] objectArray, int n, int n2, Comparator comparator) {
        TimSort.sort(objectArray, n, n2, comparator);
    }

    public static void setSizeWarningsListener(CollectionsHelper$SizeWarningsListener collectionsHelper$SizeWarningsListener) {
        sizeWarningsListener = collectionsHelper$SizeWarningsListener;
    }

    public static void writeSizeWarning(String string, int n, int n2) {
        if (null == sizeWarningsListener) {
            return;
        }
        sizeWarningsListener.newSizeWarning(string, n, n2);
    }
}

