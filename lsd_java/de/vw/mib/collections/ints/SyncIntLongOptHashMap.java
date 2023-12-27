/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import java.util.Iterator;
import java.util.Set;

public class SyncIntLongOptHashMap
implements IntLongMap {
    IntLongMap map;
    Object mutex;

    public SyncIntLongOptHashMap(IntLongMap intLongMap) {
        this.map = intLongMap;
        this.mutex = this;
    }

    public SyncIntLongOptHashMap(IntLongMap intLongMap, Object object) {
        this.map = intLongMap;
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
    public long get(int n) {
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
    public long put(int n, long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.put(n, l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long remove(int n) {
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
    public int getOneKeyByValue(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.getOneKeyByValue(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long replaceKey(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceKey(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int replaceOneValue(long l, long l2) {
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
    public IntLongMap synchronize() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(IntLongMap intLongMap) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.putAll(intLongMap);
        }
    }
}

