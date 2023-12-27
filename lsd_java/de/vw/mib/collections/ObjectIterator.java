/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Iterator;

public interface ObjectIterator
extends Iterator {
    @Override
    default public boolean hasNext() {
    }

    @Override
    default public Object next() {
    }

    @Override
    default public void remove() {
    }

    default public void reset() {
    }
}

