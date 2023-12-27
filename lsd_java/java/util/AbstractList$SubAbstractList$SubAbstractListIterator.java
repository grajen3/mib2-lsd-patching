/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractList$SubAbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

final class AbstractList$SubAbstractList$SubAbstractListIterator
implements ListIterator {
    private final AbstractList$SubAbstractList subList;
    private final ListIterator iterator;
    private int start;
    private int end;

    AbstractList$SubAbstractList$SubAbstractListIterator(ListIterator listIterator, AbstractList$SubAbstractList abstractList$SubAbstractList, int n, int n2) {
        this.iterator = listIterator;
        this.subList = abstractList$SubAbstractList;
        this.start = n;
        this.end = this.start + n2;
    }

    @Override
    public void add(Object object) {
        this.iterator.add(object);
        this.subList.sizeChanged(true);
        ++this.end;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.nextIndex() < this.end;
    }

    @Override
    public boolean hasPrevious() {
        return this.iterator.previousIndex() >= this.start;
    }

    @Override
    public Object next() {
        if (this.iterator.nextIndex() < this.end) {
            return this.iterator.next();
        }
        throw new NoSuchElementException();
    }

    @Override
    public int nextIndex() {
        return this.iterator.nextIndex() - this.start;
    }

    @Override
    public Object previous() {
        if (this.iterator.previousIndex() >= this.start) {
            return this.iterator.previous();
        }
        throw new NoSuchElementException();
    }

    @Override
    public int previousIndex() {
        int n = this.iterator.previousIndex();
        if (n >= this.start) {
            return n - this.start;
        }
        return -1;
    }

    @Override
    public void remove() {
        this.iterator.remove();
        this.subList.sizeChanged(false);
        --this.end;
    }

    @Override
    public void set(Object object) {
        this.iterator.set(object);
    }
}

