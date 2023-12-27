/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectIterator;

public class ObjectReadOnlyIterator
implements ObjectIterator {
    private final ObjectIterator backing;

    public ObjectReadOnlyIterator(ObjectIterator objectIterator) {
        this.backing = objectIterator;
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

    @Override
    public void reset() {
        this.backing.reset();
    }

    private UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to ObjectIterator: operation not allowed.");
    }
}

