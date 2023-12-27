/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections$SynchronizedCollection;
import java.util.Collections$SynchronizedSet;
import java.util.Map;
import java.util.Set;

class Collections$SynchronizedMap
implements Map,
Serializable {
    private static final long serialVersionUID;
    private final Map m;
    final Object mutex;

    Collections$SynchronizedMap(Map map) {
        this.m = map;
        this.mutex = this;
    }

    Collections$SynchronizedMap(Map map, Object object) {
        this.m = map;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.m.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.m.containsKey(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.m.containsValue(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            return new Collections$SynchronizedSet(this.m.entrySet(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.m.equals(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.m.get(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            return this.m.hashCode();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.m.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set keySet() {
        Object object = this.mutex;
        synchronized (object) {
            return new Collections$SynchronizedSet(this.m.keySet(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object put(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.m.put(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(Map map) {
        Object object = this.mutex;
        synchronized (object) {
            this.m.putAll(map);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.m.remove(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.m.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection values() {
        Object object = this.mutex;
        synchronized (object) {
            return new Collections$SynchronizedCollection(this.m.values(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            return this.m.toString();
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

