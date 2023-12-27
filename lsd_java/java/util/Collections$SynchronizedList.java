/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections$SynchronizedCollection;
import java.util.Collections$SynchronizedRandomAccessList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class Collections$SynchronizedList
extends Collections$SynchronizedCollection
implements List {
    private static final long serialVersionUID;
    final List list;

    Collections$SynchronizedList(List list) {
        super(list);
        this.list = list;
    }

    Collections$SynchronizedList(List list, Object object) {
        super(list, object);
        this.list = list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void add(int n, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.list.add(n, object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(int n, Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.addAll(n, collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.list.equals(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.get(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.hashCode();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int indexOf(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.list.indexOf(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int lastIndexOf(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.list.lastIndexOf(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ListIterator listIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.listIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ListIterator listIterator(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.listIterator(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object remove(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object set(int n, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.list.set(n, object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List subList(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return new Collections$SynchronizedList(this.list.subList(n, n2), this.mutex);
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

    private Object readResolve() {
        if (this.list instanceof RandomAccess) {
            return new Collections$SynchronizedRandomAccessList(this.list, this.mutex);
        }
        return this;
    }
}

