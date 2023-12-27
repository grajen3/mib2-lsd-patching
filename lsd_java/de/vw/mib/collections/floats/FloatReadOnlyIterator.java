/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.floats.FloatIterator;

public class FloatReadOnlyIterator
implements FloatIterator {
    private final FloatIterator backing;

    public FloatReadOnlyIterator(FloatIterator floatIterator) {
        this.backing = floatIterator;
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public float next() {
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
        return new UnsupportedOperationException("Read only view to FloatIterator: operation not allowed.");
    }
}

