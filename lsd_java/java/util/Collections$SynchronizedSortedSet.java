/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.util.Collections$SynchronizedSet;
import java.util.Comparator;
import java.util.SortedSet;

class Collections$SynchronizedSortedSet
extends Collections$SynchronizedSet
implements SortedSet {
    private static final long serialVersionUID;
    private final SortedSet ss;

    Collections$SynchronizedSortedSet(SortedSet sortedSet) {
        super(sortedSet);
        this.ss = sortedSet;
    }

    Collections$SynchronizedSortedSet(SortedSet sortedSet, Object object) {
        super(sortedSet, object);
        this.ss = sortedSet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Comparator comparator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.ss.comparator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object first() {
        Object object = this.mutex;
        synchronized (object) {
            return this.ss.first();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedSet headSet(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return new Collections$SynchronizedSortedSet(this.ss.headSet(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object last() {
        Object object = this.mutex;
        synchronized (object) {
            return this.ss.last();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedSet subSet(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return new Collections$SynchronizedSortedSet(this.ss.subSet(object, object2), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedSet tailSet(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return new Collections$SynchronizedSortedSet(this.ss.tailSet(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object object = this.mutex;
        synchronized (object) {
            objectOutputStream.defaultWriteObject();
        }
    }
}

