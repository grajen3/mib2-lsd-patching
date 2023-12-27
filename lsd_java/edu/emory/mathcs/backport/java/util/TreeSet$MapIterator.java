/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.TreeSet;
import java.util.Iterator;

class TreeSet$MapIterator
implements Iterator {
    final Iterator itr;

    TreeSet$MapIterator(Iterator iterator) {
        this.itr = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.itr.hasNext();
    }

    @Override
    public Object next() {
        return new AbstractMap$SimpleImmutableEntry(this.itr.next(), TreeSet.access$000());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

