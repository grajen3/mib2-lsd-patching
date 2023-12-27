/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.booleans.BooleanCollection;
import de.vw.mib.collections.booleans.BooleanIterator;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import java.util.Iterator;
import java.util.Set;

public class SyncIntBooleanOptHashMap
implements IntBooleanMap {
    IntBooleanMap map;
    Object mutex;

    public SyncIntBooleanOptHashMap(IntBooleanMap intBooleanMap) {
        this.map = intBooleanMap;
        this.mutex = this;
    }

    public SyncIntBooleanOptHashMap(IntBooleanMap intBooleanMap, Object object) {
        this.map = intBooleanMap;
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
    public boolean containsValue(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.containsValue(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean get(int n) {
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
    public boolean put(int n, boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.put(n, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(int n) {
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
    public int getOneKeyByValue(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.getOneKeyByValue(bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean replaceKey(int n, int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceKey(n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int replaceOneValue(boolean bl, boolean bl2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.replaceOneValue(bl, bl2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public BooleanIterator valueIterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valueIterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public BooleanCollection values() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.values();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean[] valuesToArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean[] valuesToArray(boolean[] blArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.map.valuesToArray(blArray);
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
    public IntBooleanMap synchronize() {
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void putAll(IntBooleanMap intBooleanMap) {
        Object object = this.mutex;
        synchronized (object) {
            this.map.putAll(intBooleanMap);
        }
    }
}

