/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;

public class SyncIntSet
implements IntSet {
    private final Object mutex;
    private final IntSet set;

    public SyncIntSet(IntSet intSet) {
        this.set = intSet;
        this.mutex = this;
    }

    public SyncIntSet(IntSet intSet, Object object) {
        this.set = intSet;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.add(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.contains(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int get(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.get(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.remove(n);
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
    public IntIterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(IntCollection intCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.addAll(intCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(IntCollection intCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.containsAll(intCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(IntCollection intCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.removeAll(intCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(IntCollection intCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.retainAll(intCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] toArray(int[] nArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray(nArray);
        }
    }

    @Override
    public IntSet synchronize() {
        return this;
    }
}

