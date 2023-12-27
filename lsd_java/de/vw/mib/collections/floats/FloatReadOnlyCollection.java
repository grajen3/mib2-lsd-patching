/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.floats.FloatReadOnlyIterator;

public class FloatReadOnlyCollection
implements FloatCollection {
    protected final FloatCollection backing;

    public FloatReadOnlyCollection(FloatCollection floatCollection) {
        this.backing = floatCollection;
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
        return this.backing.contains(f2);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public FloatIterator iterator() {
        return new FloatReadOnlyIterator(this.backing.iterator());
    }

    @Override
    public boolean remove(float f2) {
        throw this.writeError();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean addAll(FloatCollection floatCollection) {
        throw this.writeError();
    }

    @Override
    public boolean containsAll(FloatCollection floatCollection) {
        return this.backing.containsAll(floatCollection);
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
        return this.backing.toArray();
    }

    @Override
    public float[] toArray(float[] fArray) {
        return this.backing.toArray(fArray);
    }

    protected UnsupportedOperationException writeError() {
        return new UnsupportedOperationException("Read only view to a collection: operation not allowed.");
    }
}

