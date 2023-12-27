/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.NavigableSet;
import java.util.Map$Entry;
import java.util.SortedMap;

public interface NavigableMap
extends SortedMap {
    default public Map$Entry lowerEntry(Object object) {
    }

    default public Object lowerKey(Object object) {
    }

    default public Map$Entry floorEntry(Object object) {
    }

    default public Object floorKey(Object object) {
    }

    default public Map$Entry ceilingEntry(Object object) {
    }

    default public Object ceilingKey(Object object) {
    }

    default public Map$Entry higherEntry(Object object) {
    }

    default public Object higherKey(Object object) {
    }

    default public Map$Entry firstEntry() {
    }

    default public Map$Entry lastEntry() {
    }

    default public Map$Entry pollFirstEntry() {
    }

    default public Map$Entry pollLastEntry() {
    }

    default public NavigableMap descendingMap() {
    }

    default public NavigableSet navigableKeySet() {
    }

    default public NavigableSet descendingKeySet() {
    }

    default public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
    }

    default public NavigableMap headMap(Object object, boolean bl) {
    }

    default public NavigableMap tailMap(Object object, boolean bl) {
    }

    @Override
    default public SortedMap subMap(Object object, Object object2) {
    }

    @Override
    default public SortedMap headMap(Object object) {
    }

    @Override
    default public SortedMap tailMap(Object object) {
    }
}

