/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Comparator;

final class AvlTree$1
implements Comparator {
    AvlTree$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo(object2);
    }
}

