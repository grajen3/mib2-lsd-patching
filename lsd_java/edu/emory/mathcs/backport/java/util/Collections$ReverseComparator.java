/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import java.io.Serializable;
import java.util.Comparator;

class Collections$ReverseComparator
implements Comparator,
Serializable {
    final Comparator cmp;

    Collections$ReverseComparator(Comparator comparator) {
        this.cmp = comparator;
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.cmp.compare(object2, object);
    }

    @Override
    public boolean equals(Object object) {
        return object == this || object instanceof Collections$ReverseComparator && ((Object)this.cmp).equals(((Collections$ReverseComparator)object).cmp);
    }

    public int hashCode() {
        return this.cmp.hashCode() ^ 0x10;
    }
}

