/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Comparator;
import java.util.Map;

public interface SortedMap
extends Map {
    default public Comparator comparator() {
    }

    default public Object firstKey() {
    }

    default public SortedMap headMap(Object object) {
    }

    default public Object lastKey() {
    }

    default public SortedMap subMap(Object object, Object object2) {
    }

    default public SortedMap tailMap(Object object) {
    }
}

