/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.IndexIterator;
import java.util.NoSuchElementException;

public class ArrayIterator
implements IndexIterator {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    public static final ArrayIterator EMPTY_LIST_ITERATOR = new ArrayIterator(EMPTY_ARRAY, 0, 0);
    private final Object[] items;
    private final int end;
    private int index;

    public static ArrayIterator create(Object[] objectArray, int n, int n2) {
        return null == objectArray || 0 == objectArray.length || n2 <= n || 0 >= n2 || objectArray.length <= n ? EMPTY_LIST_ITERATOR : new ArrayIterator(objectArray, n, n2);
    }

    ArrayIterator(Object[] objectArray, int n, int n2) {
        this.items = objectArray;
        this.index = Math.max(0, n) - 1;
        this.end = Math.min(objectArray.length, n2);
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.end;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.items[++this.index];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

