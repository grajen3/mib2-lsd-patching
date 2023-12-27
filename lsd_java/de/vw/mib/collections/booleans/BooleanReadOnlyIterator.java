/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.booleans.BooleanIterator;

public class BooleanReadOnlyIterator
implements BooleanIterator {
    private final BooleanIterator backing;

    public BooleanReadOnlyIterator(BooleanIterator booleanIterator) {
        this.backing = booleanIterator;
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public boolean next() {
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
        return new UnsupportedOperationException("Read only view to BooleanIterator: operation not allowed.");
    }
}

