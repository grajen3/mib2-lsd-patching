/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.util.ListIterator;
import java.util.NoSuchElementException;

class CopyOnWriteArrayList$COWSubIterator
implements ListIterator {
    final Object[] array;
    int cursor;
    int first;
    int last;

    CopyOnWriteArrayList$COWSubIterator(Object[] objectArray, int n, int n2, int n3) {
        this.array = objectArray;
        this.first = n;
        this.last = n2;
        this.cursor = n3;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.last;
    }

    @Override
    public boolean hasPrevious() {
        return this.cursor > this.first;
    }

    @Override
    public int nextIndex() {
        return this.cursor - this.first;
    }

    @Override
    public Object next() {
        if (this.cursor == this.last) {
            throw new NoSuchElementException();
        }
        return this.array[this.cursor++];
    }

    @Override
    public int previousIndex() {
        return this.cursor - this.first - 1;
    }

    @Override
    public Object previous() {
        if (this.cursor == this.first) {
            throw new NoSuchElementException();
        }
        return this.array[--this.cursor];
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

