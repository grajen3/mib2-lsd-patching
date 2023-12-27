/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.util.ListIterator;
import java.util.NoSuchElementException;

class CopyOnWriteArrayList$COWIterator
implements ListIterator {
    final Object[] array;
    int cursor;

    CopyOnWriteArrayList$COWIterator(Object[] objectArray, int n) {
        this.array = objectArray;
        this.cursor = n;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.array.length;
    }

    @Override
    public boolean hasPrevious() {
        return this.cursor > 0;
    }

    @Override
    public int nextIndex() {
        return this.cursor;
    }

    @Override
    public Object next() {
        try {
            return this.array[this.cursor++];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            --this.cursor;
            throw new NoSuchElementException();
        }
    }

    @Override
    public int previousIndex() {
        return this.cursor - 1;
    }

    @Override
    public Object previous() {
        try {
            return this.array[--this.cursor];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            ++this.cursor;
            throw new NoSuchElementException();
        }
    }

    @Override
    public void add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

