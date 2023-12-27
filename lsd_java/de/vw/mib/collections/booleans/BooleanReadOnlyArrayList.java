/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanReadOnlyIterator;

public class BooleanReadOnlyArrayList
implements BooleanCollection {
    public static final BooleanCollection EMPTY = new BooleanReadOnlyArrayList();
    private final BooleanArrayList backingList;

    public BooleanReadOnlyArrayList(BooleanArrayList booleanArrayList) {
        this.backingList = booleanArrayList;
    }

    private BooleanReadOnlyArrayList() {
        this.backingList = new BooleanArrayList(0);
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
        return this.backingList.contains(bl);
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public BooleanIterator iterator() {
        return new BooleanReadOnlyIterator(this.backingList.iterator());
    }

    @Override
    public boolean remove(boolean bl) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean addAll(BooleanCollection booleanCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(BooleanCollection booleanCollection) {
        return this.backingList.containsAll(booleanCollection);
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
        return this.backingList.toArray();
    }

    @Override
    public boolean[] toArray(boolean[] blArray) {
        return this.backingList.toArray(blArray);
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
        BooleanReadOnlyArrayList booleanReadOnlyArrayList = (BooleanReadOnlyArrayList)object;
        return !(this.backingList == null ? booleanReadOnlyArrayList.backingList != null : !this.backingList.equals(booleanReadOnlyArrayList.backingList));
    }
}

