/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import java.util.Iterator;
import java.util.Set;

public class SyncIntIntOptHashMap
implements IntIntMap {
    IntIntMap map;
    Object mutex;

    public SyncIntIntOptHashMap(IntIntMap intIntMap) {
        this.map = intIntMap;
        this.mutex = this;
    }

    public SyncIntIntOptHashMap(IntIntMap intIntMap, Object object) {
        this.map = intIntMap;
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
    public boolean containsKey(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.containsKey(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsValue(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.containsValue(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int get(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.get(n);
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
    public int put(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.put(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int remove(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.remove(n);
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
    public IntIterator keyIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keyIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IntSet keySet() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keySet();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getOneKeyByValue(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.getOneKeyByValue(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int replaceKey(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceKey(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int replaceOneValue(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceOneValue(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IntIterator valueIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valueIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IntCollection values() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.values();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] valuesToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] valuesToArray(int[] nArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray(nArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] keysToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keysToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int[] keysToArray(int[] nArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.keysToArray(nArray);
        }
    }

    @Override
    public IntIntMap synchronize() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(IntIntMap intIntMap) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.putAll(intIntMap);
        }
    }
}

