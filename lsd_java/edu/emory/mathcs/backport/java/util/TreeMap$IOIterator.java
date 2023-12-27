/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleImmutableEntry;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorIOException;
import edu.emory.mathcs.backport.java.util.TreeMap$IteratorNoClassException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeMap$IOIterator
implements Iterator {
    final ObjectInputStream ois;
    int remaining;

    TreeMap$IOIterator(ObjectInputStream objectInputStream, int n) {
        this.ois = objectInputStream;
        this.remaining = n;
    }

    @Override
    public boolean hasNext() {
        return this.remaining > 0;
    }

    @Override
    public Object next() {
        if (this.remaining <= 0) {
            throw new NoSuchElementException();
        }
        --this.remaining;
        try {
            return new AbstractMap$SimpleImmutableEntry(this.ois.readObject(), this.ois.readObject());
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

