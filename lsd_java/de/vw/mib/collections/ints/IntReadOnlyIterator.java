/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntIterator;

public class IntReadOnlyIterator
implements IntIterator {
    private final IntIterator backing;

    public IntReadOnlyIterator(IntIterator intIterator) {
        this.backing = intIterator;
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public int next() {
        return this.backing.next();
    }

    @Override
    public void remove() {
        throw this.writeError();
    }

    @Override
    public void reset() {
        this.backing.reset();
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to IntIterator: operation not allowed.");
    }
}

