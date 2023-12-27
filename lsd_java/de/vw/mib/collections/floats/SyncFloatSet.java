/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.floats;

import de.vw.mib.collections.floats.FloatCollection;
import de.vw.mib.collections.floats.FloatIterator;
import de.vw.mib.collections.floats.FloatSet;

public class SyncFloatSet
implements FloatSet {
    private final Object mutex;
    private final FloatSet set;

    public SyncFloatSet(FloatSet floatSet) {
        this.set = floatSet;
        this.mutex = this;
    }

    public SyncFloatSet(FloatSet floatSet, Object object) {
        this.set = floatSet;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(float f2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.add(f2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(float f2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.contains(f2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public float get(float f2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.get(f2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(float f2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.remove(f2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.set.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public FloatIterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(FloatCollection floatCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.addAll(floatCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(FloatCollection floatCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.containsAll(floatCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(FloatCollection floatCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.removeAll(floatCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(FloatCollection floatCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.retainAll(floatCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public float[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public float[] toArray(float[] fArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray(fArray);
        }
    }

    @Override
    public FloatSet synchronize() {
        return this;
    }
}

