/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections;

import de.vw.mib.collections.ObjectLongMap;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import java.util.Iterator;
import java.util.Set;

public class SyncObjectLongOptHashMap
implements ObjectLongMap {
    ObjectLongMap map;
    Object mutex;

    public SyncObjectLongOptHashMap(ObjectLongMap objectLongMap) {
        this.map = objectLongMap;
        this.mutex = this;
    }

    public SyncObjectLongOptHashMap(ObjectLongMap objectLongMap, Object object) {
        this.map = objectLongMap;
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
    public boolean containsValue(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.containsValue(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long get(Object object) {
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
    public long put(Object object, long l) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.put(object, l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long remove(Object object) {
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
    public Object getOneKeyByValue(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.getOneKeyByValue(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long replaceKey(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.map.replaceKey(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object replaceOneValue(long l, long l2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceOneValue(l, l2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public LongIterator valueIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valueIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public LongCollection values() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.values();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long[] valuesToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long[] valuesToArray(long[] lArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray(lArray);
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
    public ObjectLongMap synchronize() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(ObjectLongMap objectLongMap) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.putAll(objectLongMap);
        }
    }
}

