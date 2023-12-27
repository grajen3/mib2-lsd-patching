/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class AbstractSequentialList
extends AbstractList {
    protected AbstractSequentialList() {
    }

    @Override
    public void add(int n, Object object) {
        this.listIterator(n).add(object);
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        ListIterator listIterator = this.listIterator(n);
        Iterator iterator = collection.iterator();
        int n2 = listIterator.nextIndex();
        while (iterator.hasNext()) {
            listIterator.add(iterator.next());
            listIterator.previous();
        }
        return n2 != listIterator.nextIndex();
    }

    @Override
    public Object get(int n) {
        try {
            return this.listIterator(n).next();
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator iterator() {
        return this.listIterator(0);
    }

    @Override
    public abstract ListIterator listIterator(int n) {
    }

    @Override
    public Object remove(int n) {
        try {
            ListIterator listIterator = this.listIterator(n);
            Object object = listIterator.next();
            listIterator.remove();
            return object;
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int n, Object object) {
        ListIterator listIterator = this.listIterator(n);
        Object object2 = listIterator.next();
        listIterator.set(object);
        return object2;
    }
}

