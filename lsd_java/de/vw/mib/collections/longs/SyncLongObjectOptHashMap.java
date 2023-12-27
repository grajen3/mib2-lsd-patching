/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SyncLongObjectOptHashMap
implements LongObjectMap {
    LongObjectMap map;
    Object mutex;

    public SyncLongObjectOptHashMap(LongObjectMap longObjectMap) {
        this.map = longObjectMap;
        this.mutex = this;
    }

    public SyncLongObjectOptHashMap(LongObjectMap longObjectMap, Object object) {
        this.map = longObjectMap;
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
    public boolean containsKey(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.containsKey(l);
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
    public Object get(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.get(l);
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
    public Object put(long l, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.put(l, object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object remove(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.remove(l);
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
    public LongIterator keyIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keyIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public LongSet keySet() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keySet();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long getOneKeyByValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.map.getOneKeyByValue(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object replaceKey(long l, long l2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceKey(l, l2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long replaceOneValue(Object object, Object object2) {
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
    public long[] keysToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keysToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long[] keysToArray(long[] lArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keysToArray(lArray);
        }
    }

    @Override
    public LongObjectMap synchronize() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(LongObjectMap longObjectMap) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.putAll(longObjectMap);
        }
    }
}

