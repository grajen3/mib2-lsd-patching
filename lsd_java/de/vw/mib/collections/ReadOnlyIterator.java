/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Iterator;

public class ReadOnlyIterator
implements Iterator {
    private final Iterator backing;

    public ReadOnlyIterator(Iterator iterator) {
        this.backing = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public Object next() {
        return this.backing.next();
    }

    @Override
    public void remove() {
        throw this.writeError();
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a iterator: operation not allowed.");
    }
}

