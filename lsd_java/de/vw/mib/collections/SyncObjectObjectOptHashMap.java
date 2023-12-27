/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectObjectMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SyncObjectObjectOptHashMap
implements ObjectObjectMap {
    ObjectObjectMap map;
    Object mutex;

    public SyncObjectObjectOptHashMap(ObjectObjectMap objectObjectMap) {
        this.map = objectObjectMap;
        this.mutex = this;
    }

    public SyncObjectObjectOptHashMap(ObjectObjectMap objectObjectMap, Object object) {
        this.map = objectObjectMap;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.map.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ensureAvailableSpaceAndAvoidFurtherRehashes(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.ensureAvailableSpaceAndAvoidFurtherRehashes(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.containsKey(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.containsValue(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.get(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object put(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.map.put(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.remove(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator entryIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.entryIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.entrySet();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator keyIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keyIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set keySet() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keySet();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object getOneKeyByValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.getOneKeyByValue(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object replaceKey(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.map.replaceKey(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object replaceOneValue(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.map.replaceOneValue(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Iterator valueIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valueIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection values() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.values();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] valuesToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] valuesToArray(Object[] objectArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray(objectArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] keysToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keysToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] keysToArray(Object[] objectArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keysToArray(objectArray);
        }
    }

    @Override
    public ObjectObjectMap synchronize() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(Map map) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.putAll(map);
        }
    }
}

