/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

class Collections$SynchronizedCollection
implements Collection,
Serializable {
    private static final long serialVersionUID;
    final Collection c;
    final Object mutex;

    Collections$SynchronizedCollection(Collection collection) {
        this.c = collection;
        this.mutex = this;
    }

    Collections$SynchronizedCollection(Collection collection, Object object) {
        this.c = collection;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.c.add(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.addAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.c.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.c.contains(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.containsAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.c.remove(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.removeAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.retainAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] objectArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.c.toArray(objectArray);
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

