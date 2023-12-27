/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import java.util.Iterator;

public abstract class SortedList$BidirectionalRingIterator
implements Iterator {
    @Override
    public abstract Object next() {
    }

    public abstract Object prev() {
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

