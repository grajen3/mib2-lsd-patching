/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.TreeMap$IOIterator;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorIOException;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorNoClassException;
import edu.emory.mathcs.backport.java.util.TreeSet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.NoSuchElementException;

class TreeSet$IOIterator
extends TreeMap$IOIterator {
    TreeSet$IOIterator(ObjectInputStream objectInputStream, int n) {
        super(objectInputStream, n);
    }

    @Override
    public Object next() {
        if (this.remaining <= 0) {
            throw new NoSuchElementException();
        }
        --this.remaining;
        try {
            return new AbstractMap$SimpleImmutableEntry(this.ois.readObject(), TreeSet.access$000());
        }
        catch (IOException iOException) {
            throw new TreeMap$IteratorIOException(iOException);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new TreeMap$IteratorNoClassException(classNotFoundException);
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

