/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyIterator;

public class IntReadOnlyCollection
implements IntCollection {
    protected final IntCollection backing;

    public IntReadOnlyCollection(IntCollection intCollection) {
        this.backing = intCollection;
    }

    @Override
    public boolean add(int n) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(int n) {
        return this.backing.contains(n);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public IntIterator iterator() {
        return new IntReadOnlyIterator(this.backing.iterator());
    }

    @Override
    public boolean remove(int n) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean addAll(IntCollection intCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(IntCollection intCollection) {
        return this.backing.containsAll(intCollection);
    }

    @Override
    public boolean removeAll(IntCollection intCollection) {
        throw this.writeError();
    }

    @Override
    public boolean retainAll(IntCollection intCollection) {
        throw this.writeError();
    }

    @Override
    public int[] toArray() {
        return this.backing.toArray();
    }

    @Override
    public int[] toArray(int[] nArray) {
        return this.backing.toArray(nArray);
    }

    protected UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

