/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Collection;

public interface Buffer {
    default public boolean add(Object object) {
    }

    default public boolean addAll(Collection collection) {
    }

    default public boolean offer(Object object) {
    }

    default public boolean offerAll(Collection collection) {
    }

    default public Object getNewest() {
    }

    default public Object getOldest() {
    }

    default public Object popNewest() {
    }

    default public Object popOldest() {
    }

    default public void clear() {
    }

    default public boolean isEmpty() {
    }

    default public int size() {
    }

    default public int capacity() {
    }

    default public Object[] toArray() {
    }

    default public Object[] toArray(Object[] objectArray) {
    }
}

