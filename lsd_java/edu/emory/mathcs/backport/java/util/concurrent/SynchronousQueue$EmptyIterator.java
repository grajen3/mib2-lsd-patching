/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SynchronousQueue$EmptyIterator
implements Iterator {
    SynchronousQueue$EmptyIterator() {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new IllegalStateException();
    }
}

