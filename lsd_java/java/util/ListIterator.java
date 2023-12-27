/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Iterator;

public interface ListIterator
extends Iterator {
    default public void add(Object object) {
    }

    @Override
    default public boolean hasNext() {
    }

    default public boolean hasPrevious() {
    }

    @Override
    default public Object next() {
    }

    default public int nextIndex() {
    }

    default public Object previous() {
    }

    default public int previousIndex() {
    }

    @Override
    default public void remove() {
    }

    default public void set(Object object) {
    }
}

