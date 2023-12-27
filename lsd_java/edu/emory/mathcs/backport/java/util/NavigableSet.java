/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import java.util.Iterator;
import java.util.SortedSet;

public interface NavigableSet
extends SortedSet {
    default public Object lower(Object object) {
    }

    default public Object floor(Object object) {
    }

    default public Object ceiling(Object object) {
    }

    default public Object higher(Object object) {
    }

    default public Object pollFirst() {
    }

    default public Object pollLast() {
    }

    @Override
    default public Iterator iterator() {
    }

    default public NavigableSet descendingSet() {
    }

    default public Iterator descendingIterator() {
    }

    default public NavigableSet subSet(Object object, boolean bl, Object object2, boolean bl2) {
    }

    default public NavigableSet headSet(Object object, boolean bl) {
    }

    default public NavigableSet tailSet(Object object, boolean bl) {
    }

    @Override
    default public SortedSet subSet(Object object, Object object2) {
    }

    @Override
    default public SortedSet headSet(Object object) {
    }

    @Override
    default public SortedSet tailSet(Object object) {
    }
}

