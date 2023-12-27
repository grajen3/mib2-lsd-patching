/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongReadOnlyIterator;

public class LongReadOnlyArrayList
implements LongCollection {
    public static final LongCollection EMPTY = new LongReadOnlyArrayList();
    private final LongArrayList backingList;

    public LongReadOnlyArrayList(LongArrayList longArrayList) {
        this.backingList = longArrayList;
    }

    private LongReadOnlyArrayList() {
        this.backingList = new LongArrayList(0);
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
        return this.backingList.contains(l);
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public LongIterator iterator() {
        return new LongReadOnlyIterator(this.backingList.iterator());
    }

    @Override
    public boolean remove(long l) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean addAll(LongCollection longCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(LongCollection longCollection) {
        return this.backingList.containsAll(longCollection);
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
        return this.backingList.toArray();
    }

    @Override
    public long[] toArray(long[] lArray) {
        return this.backingList.toArray(lArray);
    }

    private RuntimeException writeError() {
        return new UnsupportedOperationException(new StringBuffer().append("No write to ").append(super.getClass()).append(" allowed.").toString());
    }

    public String toString() {
        return this.backingList.toString();
    }

    public int hashCode() {
        return (int)HashCodeBuilder.hash(this.backingList);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        LongReadOnlyArrayList longReadOnlyArrayList = (LongReadOnlyArrayList)object;
        return !(this.backingList == null ? longReadOnlyArrayList.backingList != null : !this.backingList.equals(longReadOnlyArrayList.backingList));
    }
}

