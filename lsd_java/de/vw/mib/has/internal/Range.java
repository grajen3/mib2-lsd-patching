/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.pool.PoorMansPool;

final class Range {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    int start;
    int end;
    Range next;

    private Range() {
    }

    boolean intersects(Range range) {
        return null != range && this.intersects(range.start, range.end);
    }

    boolean intersects(int n, int n2) {
        return this.start <= n2 && this.end >= n;
    }

    static Range create(int n, int n2, Range range) {
        Range range2 = (Range)POOL.borrow();
        if (null == range2) {
            range2 = new Range();
        }
        range2.start = n;
        range2.end = n2;
        range2.next = range;
        return range2;
    }

    static Range clone(Range range) {
        return Range.create(range.start, range.end, null);
    }

    void release() {
        this.next = null;
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("Range", 10);
    }
}

