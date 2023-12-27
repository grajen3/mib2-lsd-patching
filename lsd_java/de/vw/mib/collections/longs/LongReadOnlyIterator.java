/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongIterator;

public class LongReadOnlyIterator
implements LongIterator {
    private final LongIterator backing;

    public LongReadOnlyIterator(LongIterator longIterator) {
        this.backing = longIterator;
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public long next() {
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
        return new UnsupportedOperationException("Read only view to LongIterator: operation not allowed.");
    }
}

