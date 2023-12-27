/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyIterator;

public class LongReadOnlyCollection
implements LongCollection {
    protected final LongCollection backing;

    public LongReadOnlyCollection(LongCollection longCollection) {
        this.backing = longCollection;
    }

    @Override
    public boolean add(long l) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(long l) {
        return this.backing.contains(l);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public LongIterator iterator() {
        return new LongReadOnlyIterator(this.backing.iterator());
    }

    @Override
    public boolean remove(long l) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(LongCollection longCollection) {
        return this.backing.containsAll(longCollection);
    }

    @Override
    public boolean removeAll(LongCollection longCollection) {
        throw this.writeError();
    }

    @Override
    public boolean retainAll(LongCollection longCollection) {
        throw this.writeError();
    }

    @Override
    public long[] toArray() {
        return this.backing.toArray();
    }

    @Override
    public long[] toArray(long[] lArray) {
        return this.backing.toArray(lArray);
    }

    protected UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

