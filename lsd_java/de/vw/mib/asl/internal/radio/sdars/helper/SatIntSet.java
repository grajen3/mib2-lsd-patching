/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;

public final class SatIntSet {
    private final IntSet mSetSkipped = new IntOptHashSet();
    private final IntSet mSetNonSkipped = new IntOptHashSet();
    private final IAslPool mPool;

    public SatIntSet(IAslPool iAslPool) {
        this.mPool = iAslPool;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(int n) {
        if (n > 0) {
            IntSet intSet = this.mSetSkipped;
            synchronized (intSet) {
                if (!this.mSetSkipped.contains(n)) {
                    this.mSetSkipped.add(n);
                    this.markDirty();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addNonSkipped(int n) {
        if (n > 0) {
            IntSet intSet = this.mSetNonSkipped;
            synchronized (intSet) {
                if (!this.mSetNonSkipped.contains(n)) {
                    this.mSetNonSkipped.add(n);
                    this.markDirty();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean contains(int n) {
        IntSet intSet = this.mSetSkipped;
        synchronized (intSet) {
            return this.mSetSkipped.contains(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsNonSkipped(int n) {
        IntSet intSet = this.mSetNonSkipped;
        synchronized (intSet) {
            return this.mSetNonSkipped.contains(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(int n) {
        IntSet intSet = this.mSetSkipped;
        synchronized (intSet) {
            if (this.mSetSkipped.contains(n)) {
                this.mSetSkipped.remove(n);
                this.markDirty();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeNonSkipped(int n) {
        IntSet intSet = this.mSetNonSkipped;
        synchronized (intSet) {
            if (this.mSetNonSkipped.contains(n)) {
                this.mSetNonSkipped.remove(n);
                this.markDirty();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        IntSet intSet = this.mSetSkipped;
        synchronized (intSet) {
            if (this.mSetSkipped.size() > 0) {
                this.mSetSkipped.clear();
                this.markDirty();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearNonSkipped() {
        IntSet intSet = this.mSetNonSkipped;
        synchronized (intSet) {
            if (this.mSetNonSkipped.size() > 0) {
                this.mSetNonSkipped.clear();
                this.markDirty();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean toggle(int n) {
        boolean bl;
        IntSet intSet = this.mSetSkipped;
        synchronized (intSet) {
            if (this.mSetSkipped.contains(n)) {
                this.mSetSkipped.remove(n);
                bl = false;
            } else {
                this.mSetSkipped.add(n);
                bl = true;
            }
        }
        this.markDirty();
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean toggleNonSkipped(int n) {
        boolean bl;
        IntSet intSet = this.mSetNonSkipped;
        synchronized (intSet) {
            if (this.mSetNonSkipped.contains(n)) {
                this.mSetNonSkipped.remove(n);
                bl = true;
            } else {
                this.mSetNonSkipped.add(n);
                bl = false;
            }
        }
        this.markDirty();
        return bl;
    }

    private void markDirty() {
        if (this.mPool != null) {
            this.mPool.setBoolean(36, true);
        }
    }

    public IntIterator intIterator() {
        return this.mSetSkipped.iterator();
    }

    public int getSize() {
        return this.mSetSkipped.size();
    }

    public IntSet getSetSkipped() {
        return this.mSetSkipped;
    }

    public IntSet getSetNonSkipped() {
        return this.mSetNonSkipped;
    }
}

