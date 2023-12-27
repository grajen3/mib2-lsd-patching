/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntReadOnlyIterator;

public class IntReadOnlyArrayList
implements IntCollection {
    public static final IntCollection EMPTY = new IntReadOnlyArrayList();
    private final IntArrayList backingList;

    public IntReadOnlyArrayList(IntArrayList intArrayList) {
        this.backingList = intArrayList;
    }

    private IntReadOnlyArrayList() {
        this.backingList = new IntArrayList(0);
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
        return this.backingList.contains(n);
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public IntIterator iterator() {
        return new IntReadOnlyIterator(this.backingList.iterator());
    }

    @Override
    public boolean remove(int n) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean addAll(IntCollection intCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(IntCollection intCollection) {
        return this.backingList.containsAll(intCollection);
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
        return this.backingList.toArray();
    }

    @Override
    public int[] toArray(int[] nArray) {
        return this.backingList.toArray(nArray);
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
        IntReadOnlyArrayList intReadOnlyArrayList = (IntReadOnlyArrayList)object;
        return !(this.backingList == null ? intReadOnlyArrayList.backingList != null : !this.backingList.equals(intReadOnlyArrayList.backingList));
    }
}

