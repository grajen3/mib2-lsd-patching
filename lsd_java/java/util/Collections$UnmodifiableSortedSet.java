/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$UnmodifiableSet;
import java.util.Comparator;
import java.util.SortedSet;

class Collections$UnmodifiableSortedSet
extends Collections$UnmodifiableSet
implements SortedSet {
    private static final long serialVersionUID;
    private final SortedSet ss;

    Collections$UnmodifiableSortedSet(SortedSet sortedSet) {
        super(sortedSet);
        this.ss = sortedSet;
    }

    @Override
    public Comparator comparator() {
        return this.ss.comparator();
    }

    @Override
    public Object first() {
        return this.ss.first();
    }

    @Override
    public SortedSet headSet(Object object) {
        return new Collections$UnmodifiableSortedSet(this.ss.headSet(object));
    }

    @Override
    public Object last() {
        return this.ss.last();
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return new Collections$UnmodifiableSortedSet(this.ss.subSet(object, object2));
    }

    @Override
    public SortedSet tailSet(Object object) {
        return new Collections$UnmodifiableSortedSet(this.ss.tailSet(object));
    }
}

