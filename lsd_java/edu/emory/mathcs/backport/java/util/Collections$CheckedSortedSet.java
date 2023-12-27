/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections$CheckedSet;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;

class Collections$CheckedSortedSet
extends Collections$CheckedSet
implements SortedSet,
Serializable {
    final SortedSet set;

    Collections$CheckedSortedSet(SortedSet sortedSet, Class clazz) {
        super(sortedSet, clazz);
        this.set = sortedSet;
    }

    @Override
    public Object first() {
        return this.set.first();
    }

    @Override
    public Object last() {
        return this.set.last();
    }

    @Override
    public Comparator comparator() {
        return this.set.comparator();
    }

    @Override
    public SortedSet headSet(Object object) {
        return new Collections$CheckedSortedSet(this.set.headSet(object), this.type);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return new Collections$CheckedSortedSet(this.set.tailSet(object), this.type);
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return new Collections$CheckedSortedSet(this.set.subSet(object, object2), this.type);
    }
}

