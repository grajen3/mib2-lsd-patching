/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;
import java.util.Comparator;

class Collections$ReverseComparator
implements Comparator,
Serializable {
    private static final long serialVersionUID;

    Collections$ReverseComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return -((Comparable)object).compareTo(object2);
    }
}

