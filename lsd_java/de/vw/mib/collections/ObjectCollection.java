/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Collection;
import java.util.Iterator;

public interface ObjectCollection
extends Collection {
    @Override
    default public boolean add(Object object) {
    }

    @Override
    default public void clear() {
    }

    @Override
    default public boolean contains(Object object) {
    }

    @Override
    default public boolean isEmpty() {
    }

    @Override
    default public Iterator iterator() {
    }

    @Override
    default public boolean remove(Object object) {
    }

    @Override
    default public int size() {
    }

    @Override
    default public boolean addAll(Collection collection) {
    }

    @Override
    default public boolean containsAll(Collection collection) {
    }

    @Override
    default public boolean removeAll(Collection collection) {
    }

    @Override
    default public boolean retainAll(Collection collection) {
    }

    @Override
    default public Object[] toArray() {
    }

    @Override
    default public Object[] toArray(Object[] objectArray) {
    }
}

