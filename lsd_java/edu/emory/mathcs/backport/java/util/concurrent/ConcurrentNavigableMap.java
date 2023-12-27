/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.NavigableMap;
import edu.emory.mathcs.backport.java.util.NavigableSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentMap;
import java.util.Set;
import java.util.SortedMap;

public interface ConcurrentNavigableMap
extends ConcurrentMap,
NavigableMap {
    @Override
    default public NavigableMap subMap(Object object, boolean bl, Object object2, boolean bl2) {
    }

    @Override
    default public NavigableMap headMap(Object object, boolean bl) {
    }

    @Override
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

    @Override
    default public NavigableMap descendingMap() {
    }

    @Override
    default public NavigableSet navigableKeySet() {
    }

    @Override
    default public Set keySet() {
    }

    @Override
    default public NavigableSet descendingKeySet() {
    }
}

