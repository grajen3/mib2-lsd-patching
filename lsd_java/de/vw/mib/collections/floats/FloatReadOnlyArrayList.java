/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.floats.FloatArrayList;
import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.floats.FloatReadOnlyIterator;

public class FloatReadOnlyArrayList
implements FloatCollection {
    public static final FloatCollection EMPTY = new FloatReadOnlyArrayList();
    private final FloatArrayList backingList;

    public FloatReadOnlyArrayList(FloatArrayList floatArrayList) {
        this.backingList = floatArrayList;
    }

    private FloatReadOnlyArrayList() {
        this.backingList = new FloatArrayList(0);
    }

    @Override
    public boolean add(float f2) {
        throw this.writeError();
    }

    @Override
    public void clear() {
        throw this.writeError();
    }

    @Override
    public boolean contains(float f2) {
        return this.backingList.contains(f2);
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public FloatIterator iterator() {
        return new FloatReadOnlyIterator(this.backingList.iterator());
    }

    @Override
    public boolean remove(float f2) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean addAll(FloatCollection floatCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(FloatCollection floatCollection) {
        return this.backingList.containsAll(floatCollection);
    }

    @Override
    public boolean removeAll(FloatCollection floatCollection) {
        throw this.writeError();
    }

    @Override
    public boolean retainAll(FloatCollection floatCollection) {
        throw this.writeError();
    }

    @Override
    public float[] toArray() {
        return this.backingList.toArray();
    }

    @Override
    public float[] toArray(float[] fArray) {
        return this.backingList.toArray(fArray);
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
        FloatReadOnlyArrayList floatReadOnlyArrayList = (FloatReadOnlyArrayList)object;
        return !(this.backingList == null ? floatReadOnlyArrayList.backingList != null : !this.backingList.equals(floatReadOnlyArrayList.backingList));
    }
}

