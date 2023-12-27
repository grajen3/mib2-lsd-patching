/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.longs;

import de.vw.mib.collections.longs.LongCollection;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongSet;

public class SyncLongSet
implements LongSet {
    private final Object mutex;
    private final LongSet set;

    public SyncLongSet(LongSet longSet) {
        this.set = longSet;
        this.mutex = this;
    }

    public SyncLongSet(LongSet longSet, Object object) {
        this.set = longSet;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean add(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.add(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.contains(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long get(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.get(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(long l) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.remove(l);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.set.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public LongIterator iterator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.iterator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean addAll(LongCollection longCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.addAll(longCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(LongCollection longCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.containsAll(longCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(LongCollection longCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.removeAll(longCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(LongCollection longCollection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.retainAll(longCollection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long[] toArray(long[] lArray) {
        Object object = this.mutex;
        synchronized (object) {
            return this.set.toArray(lArray);
        }
    }

    @Override
    public LongSet synchronize() {
        return this;
    }
}

