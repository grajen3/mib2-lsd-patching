/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanReadOnlyIterator;

public class BooleanReadOnlyCollection
implements BooleanCollection {
    protected final BooleanCollection backing;

    public BooleanReadOnlyCollection(BooleanCollection booleanCollection) {
        this.backing = booleanCollection;
    }

    @Override
    public boolean add(boolean bl) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(boolean bl) {
        return this.backing.contains(bl);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public BooleanIterator iterator() {
        return new BooleanReadOnlyIterator(this.backing.iterator());
    }

    @Override
    public boolean remove(boolean bl) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean addAll(BooleanCollection booleanCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(BooleanCollection booleanCollection) {
        return this.backing.containsAll(booleanCollection);
    }

    @Override
    public boolean removeAll(BooleanCollection booleanCollection) {
        throw this.writeError();
    }

    @Override
    public boolean retainAll(BooleanCollection booleanCollection) {
        throw this.writeError();
    }

    @Override
    public boolean[] toArray() {
        return this.backing.toArray();
    }

    @Override
    public boolean[] toArray(boolean[] blArray) {
        return this.backing.toArray(blArray);
    }

    protected UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

