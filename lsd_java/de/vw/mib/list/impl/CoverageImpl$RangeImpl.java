/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.Range;
import de.vw.mib.pool.PoorMansPool;

final class CoverageImpl$RangeImpl
implements Range {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    int start;
    int end;
    CoverageImpl$RangeImpl next;

    private CoverageImpl$RangeImpl() {
    }

    @Override
    public Range copy() {
        return CoverageImpl$RangeImpl.clone(this);
    }

    @Override
    public int getStart() {
        return this.start;
    }

    @Override
    public int getEnd() {
        return this.end;
    }

    @Override
    public Range intersect(int n, int n2) {
        int n3;
        int n4 = Math.max(n, this.start);
        return n4 <= (n3 = Math.min(n2, this.end)) ? CoverageImpl$RangeImpl.create(n4, n3, null) : null;
    }

    @Override
    public boolean intersects(Range range) {
        return null != range && this.intersects(range.getStart(), range.getEnd());
    }

    @Override
    public boolean intersects(int n, int n2) {
        return this.start <= n2 && this.end >= n;
    }

    static CoverageImpl$RangeImpl create(int n, int n2, CoverageImpl$RangeImpl coverageImpl$RangeImpl) {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = (CoverageImpl$RangeImpl)POOL.borrow();
        if (null == coverageImpl$RangeImpl2) {
            coverageImpl$RangeImpl2 = new CoverageImpl$RangeImpl();
        }
        coverageImpl$RangeImpl2.start = n;
        coverageImpl$RangeImpl2.end = n2;
        coverageImpl$RangeImpl2.next = coverageImpl$RangeImpl;
        return coverageImpl$RangeImpl2;
    }

    static CoverageImpl$RangeImpl clone(Range range) {
        return CoverageImpl$RangeImpl.create(range.getStart(), range.getEnd(), null);
    }

    @Override
    public void release() {
        this.next = null;
        POOL.release(this);
    }

    static {
        POOL = new PoorMansPool("HMIList.Coverage.Range", 10);
    }
}

