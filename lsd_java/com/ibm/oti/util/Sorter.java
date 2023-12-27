/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.Sorter$Comparator;
import java.util.Arrays;

public final class Sorter {
    public static void sort(Object[] objectArray, Sorter$Comparator sorter$Comparator) {
        Arrays.sort(objectArray, sorter$Comparator);
    }
}

