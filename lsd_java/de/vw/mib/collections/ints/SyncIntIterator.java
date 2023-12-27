/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

import de.vw.mib.collections.ints.IntIterator;

public class SyncIntIterator
implements IntIterator {
    IntIterator iterator;
    Object mutex;

    public SyncIntIterator(IntIterator intIterator) {
        this.iterator = intIterator;
        this.mutex = this;
    }

    public SyncIntIterator(IntIterator intIterator, Object object) {
        this.iterator = intIterator;
        this.mutex = object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasNext() {
        Object object = this.mutex;
        synchronized (object) {
            return this.iterator.hasNext();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int next() {
        Object object = this.mutex;
        synchronized (object) {
            return this.iterator.next();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove() {
        Object object = this.mutex;
        synchronized (object) {
            this.iterator.remove();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        Object object = this.mutex;
        synchronized (object) {
            this.iterator.reset();
        }
    }
}

