/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectSet;
import java.util.Collection;
import java.util.Iterator;

public class SyncObjectSet
implements ObjectSet {
    private final Object mutex;
    private final ObjectSet set;

    public SyncObjectSet(ObjectSet objectSet) {
        this.set = objectSet;
        this.mutex = this;
    }

    public SyncObjectSet(ObjectSet objectSet, Object object) {
        this.set = objectSet;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.set.add(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.set.contains(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.set.get(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.set.remove(object);
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
    public Iterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.addAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.containsAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.removeAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.retainAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray(objectArray);
        }
    }

    @Override
    public ObjectSet synchronize() {
        return this;
    }
}

