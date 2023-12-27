/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Comparator;
import java.util.Set;

public interface SortedSet
extends Set {
    default public Comparator comparator() {
    }

    default public Object first() {
    }

    default public SortedSet headSet(Object object) {
    }

    default public Object last() {
    }

    default public SortedSet subSet(Object object, Object object2) {
    }

    default public SortedSet tailSet(Object object) {
    }
}

