/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.algorithms;

import java.util.Comparator;

final class LinkedQuickSort$1
implements Comparator {
    LinkedQuickSort$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo(object2);
    }
}

