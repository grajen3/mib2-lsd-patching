/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.util.Collections$SynchronizedMap;
import java.util.Comparator;
import java.util.SortedMap;

class Collections$SynchronizedSortedMap
extends Collections$SynchronizedMap
implements SortedMap {
    private static final long serialVersionUID;
    private final SortedMap sm;

    Collections$SynchronizedSortedMap(SortedMap sortedMap) {
        super(sortedMap);
        this.sm = sortedMap;
    }

    Collections$SynchronizedSortedMap(SortedMap sortedMap, Object object) {
        super(sortedMap, object);
        this.sm = sortedMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Comparator comparator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.sm.comparator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object firstKey() {
        Object object = this.mutex;
        synchronized (object) {
            return this.sm.firstKey();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedMap headMap(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return new Collections$SynchronizedSortedMap(this.sm.headMap(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object lastKey() {
        Object object = this.mutex;
        synchronized (object) {
            return this.sm.lastKey();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedMap subMap(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return new Collections$SynchronizedSortedMap(this.sm.subMap(object, object2), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedMap tailMap(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return new Collections$SynchronizedSortedMap(this.sm.tailMap(object), this.mutex);
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

