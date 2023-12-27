/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.booleans;

import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.booleans.BooleanSet;

public class SyncBooleanSet
implements BooleanSet {
    private final Object mutex;
    private final BooleanSet set;

    public SyncBooleanSet(BooleanSet booleanSet) {
        this.set = booleanSet;
        this.mutex = this;
    }

    public SyncBooleanSet(BooleanSet booleanSet, Object object) {
        this.set = booleanSet;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.add(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.contains(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean get(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.get(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.remove(bl);
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
    public BooleanIterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(BooleanCollection booleanCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.addAll(booleanCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(BooleanCollection booleanCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.containsAll(booleanCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(BooleanCollection booleanCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.removeAll(booleanCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(BooleanCollection booleanCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.retainAll(booleanCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean[] toArray(boolean[] blArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray(blArray);
        }
    }

    @Override
    public BooleanSet synchronize() {
        return this;
    }
}

