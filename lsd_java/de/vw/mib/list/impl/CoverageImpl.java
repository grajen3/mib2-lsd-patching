/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.Coverage;
import de.vw.mib.list.Range;
import de.vw.mib.list.impl.CoverageImpl$RangeImpl;

class CoverageImpl
implements Coverage {
    private final boolean autoCompact;
    private CoverageImpl$RangeImpl first;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$list$impl$CoverageImpl;

    static CoverageImpl create(boolean bl) {
        return new CoverageImpl(bl);
    }

    private CoverageImpl(boolean bl) {
        this.autoCompact = bl;
    }

    @Override
    public void addRange(int n, int n2) {
        if (n2 < n) {
            throw new IllegalArgumentException("end<start");
        }
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = null;
        while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n) {
            coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
        }
        while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start <= n && n <= n2) {
            n = coverageImpl$RangeImpl.end + 1;
            coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
        }
        if (null != coverageImpl$RangeImpl && n <= n2 && coverageImpl$RangeImpl.start <= n2) {
            int n3 = coverageImpl$RangeImpl.start - 1;
            while (true) {
                if (coverageImpl$RangeImpl.end < n2 && null != coverageImpl$RangeImpl.next && coverageImpl$RangeImpl.end >= coverageImpl$RangeImpl.next.start - 1) {
                    coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
                    continue;
                }
                if (coverageImpl$RangeImpl.end < n2) {
                    int n4 = n3 = null != coverageImpl$RangeImpl.next ? coverageImpl$RangeImpl.next.start - 1 : n2;
                }
                if (null == (coverageImpl$RangeImpl = coverageImpl$RangeImpl.next) || coverageImpl$RangeImpl.start > n2) break;
            }
            n2 = Math.min(n2, n3);
        }
        if (n <= n2) {
            this.append(coverageImpl$RangeImpl2, n, n2);
        }
    }

    @Override
    public void clear() {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        while (null != coverageImpl$RangeImpl) {
            CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            coverageImpl$RangeImpl2.release();
        }
        this.first = null;
    }

    @Override
    public void clearRange(int n, int n2) {
        if (n2 < n) {
            throw new IllegalArgumentException("end<start");
        }
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = null;
        while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n) {
            coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
        }
        if (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start <= n2) {
            if (coverageImpl$RangeImpl.start < n) {
                if (coverageImpl$RangeImpl.end > n2) {
                    coverageImpl$RangeImpl.next = CoverageImpl$RangeImpl.create(n2 + 1, coverageImpl$RangeImpl.end, coverageImpl$RangeImpl.next);
                }
                coverageImpl$RangeImpl.end = n - 1;
                coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            CoverageImpl$RangeImpl coverageImpl$RangeImpl3 = coverageImpl$RangeImpl;
            while (coverageImpl$RangeImpl != null && coverageImpl$RangeImpl.end <= n2) {
                CoverageImpl$RangeImpl coverageImpl$RangeImpl4 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
                coverageImpl$RangeImpl4.release();
            }
            if (coverageImpl$RangeImpl3 != coverageImpl$RangeImpl) {
                if (null != coverageImpl$RangeImpl2) {
                    coverageImpl$RangeImpl2.next = coverageImpl$RangeImpl;
                } else {
                    this.first = coverageImpl$RangeImpl;
                }
            }
            if (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start <= n2) {
                coverageImpl$RangeImpl.start = n2 + 1;
            }
        }
    }

    @Override
    public void compact() {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        if (null != coverageImpl$RangeImpl) {
            CoverageImpl$RangeImpl coverageImpl$RangeImpl2;
            while (null != (coverageImpl$RangeImpl2 = coverageImpl$RangeImpl.next)) {
                if (coverageImpl$RangeImpl.end + 1 == coverageImpl$RangeImpl2.start) {
                    coverageImpl$RangeImpl.end = coverageImpl$RangeImpl2.end;
                    coverageImpl$RangeImpl.next = coverageImpl$RangeImpl2.next;
                    coverageImpl$RangeImpl2.release();
                    continue;
                }
                coverageImpl$RangeImpl = coverageImpl$RangeImpl2;
            }
        }
    }

    @Override
    public boolean covers(int n, int n2) {
        boolean bl;
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        if (n > n2) {
            bl = true;
        } else {
            while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n) {
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            boolean bl2 = bl = null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start <= n;
            while (bl && null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n2) {
                bl = null != coverageImpl$RangeImpl.next && coverageImpl$RangeImpl.end == coverageImpl$RangeImpl.next.start - 1;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
        }
        return bl;
    }

    @Override
    public Range getFirstIntersection(Coverage coverage) {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl;
        int n;
        CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = this.first;
        Range range = coverage.getFirstRange();
        while (null != coverageImpl$RangeImpl2 && null != range && !range.intersects(coverageImpl$RangeImpl2.start, coverageImpl$RangeImpl2.end)) {
            if (coverageImpl$RangeImpl2.end < range.getStart()) {
                coverageImpl$RangeImpl2 = coverageImpl$RangeImpl2.next;
                continue;
            }
            n = range.getEnd();
            range.release();
            range = coverage.getRangeAfter(n);
        }
        if (null != coverageImpl$RangeImpl2 && null != range) {
            n = Math.max(coverageImpl$RangeImpl2.start, range.getStart());
            int n2 = Math.min(coverageImpl$RangeImpl2.end, range.getEnd());
            coverageImpl$RangeImpl = CoverageImpl$RangeImpl.create(n, n2, null);
        } else {
            coverageImpl$RangeImpl = null;
        }
        if (null != range) {
            range.release();
        }
        return coverageImpl$RangeImpl;
    }

    @Override
    public Range getFirstRange() {
        return null != this.first ? CoverageImpl$RangeImpl.clone(this.first) : null;
    }

    @Override
    public Range getRangeAfter(int n) {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start <= n) {
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
        }
        return null != coverageImpl$RangeImpl ? CoverageImpl$RangeImpl.clone(coverageImpl$RangeImpl) : null;
    }

    @Override
    public Range getRangeAt(int n) {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n) {
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
        }
        return null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.intersects(n, n) ? CoverageImpl$RangeImpl.clone(coverageImpl$RangeImpl) : null;
    }

    @Override
    public void insertGap(int n, int n2) {
        if (0 > n2) {
            throw new IllegalArgumentException("negative size");
        }
        if (0 < n2) {
            CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
            while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n) {
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            if (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start < n) {
                coverageImpl$RangeImpl.next = CoverageImpl$RangeImpl.create(n, coverageImpl$RangeImpl.end, coverageImpl$RangeImpl.next);
                coverageImpl$RangeImpl.end = n - 1;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            while (null != coverageImpl$RangeImpl) {
                coverageImpl$RangeImpl.start += n2;
                coverageImpl$RangeImpl.end += n2;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
        }
    }

    @Override
    public boolean intersects(int n, int n2) {
        boolean bl = false;
        if (n <= n2) {
            CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
            while (!bl && null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start <= n2) {
                bl = coverageImpl$RangeImpl.end >= n;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
        }
        return bl;
    }

    @Override
    public boolean isEmpty() {
        return null == this.first;
    }

    @Override
    public void removeRange(int n, int n2) {
        if (0 > n2) {
            throw new IllegalArgumentException("negative size");
        }
        if (0 < n2) {
            CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
            CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = null;
            while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end < n) {
                coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            if (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.start < n) {
                coverageImpl$RangeImpl.end = Math.max(coverageImpl$RangeImpl.end - n2, n - 1);
                coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            CoverageImpl$RangeImpl coverageImpl$RangeImpl3 = coverageImpl$RangeImpl;
            while (coverageImpl$RangeImpl != null && coverageImpl$RangeImpl.end - n2 < n) {
                CoverageImpl$RangeImpl coverageImpl$RangeImpl4 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
                coverageImpl$RangeImpl4.release();
            }
            if (coverageImpl$RangeImpl3 != coverageImpl$RangeImpl) {
                if (null != coverageImpl$RangeImpl2) {
                    coverageImpl$RangeImpl2.next = coverageImpl$RangeImpl;
                } else {
                    this.first = coverageImpl$RangeImpl;
                }
            }
            if (this.autoCompact && null != coverageImpl$RangeImpl2 && null != coverageImpl$RangeImpl && coverageImpl$RangeImpl2.end + 1 == Math.max(coverageImpl$RangeImpl.start - n2, n)) {
                coverageImpl$RangeImpl2.end = coverageImpl$RangeImpl.end - n2;
                coverageImpl$RangeImpl2.next = coverageImpl$RangeImpl.next;
                coverageImpl$RangeImpl.release();
                coverageImpl$RangeImpl = coverageImpl$RangeImpl2.next;
            }
            while (null != coverageImpl$RangeImpl) {
                coverageImpl$RangeImpl.start = Math.max(coverageImpl$RangeImpl.start - n2, n);
                coverageImpl$RangeImpl.end -= n2;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
        }
    }

    @Override
    public void upperBound(int n) {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl = this.first;
        CoverageImpl$RangeImpl coverageImpl$RangeImpl2 = null;
        while (null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end <= n) {
            coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
            coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
        }
        if (null != coverageImpl$RangeImpl) {
            if (coverageImpl$RangeImpl.start <= n) {
                coverageImpl$RangeImpl.end = n;
                coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
            }
            while (null != coverageImpl$RangeImpl) {
                CoverageImpl$RangeImpl coverageImpl$RangeImpl3 = coverageImpl$RangeImpl;
                coverageImpl$RangeImpl = coverageImpl$RangeImpl.next;
                coverageImpl$RangeImpl3.release();
            }
            if (null != coverageImpl$RangeImpl2) {
                coverageImpl$RangeImpl2.next = null;
            } else {
                this.first = null;
            }
        }
    }

    private CoverageImpl$RangeImpl append(CoverageImpl$RangeImpl coverageImpl$RangeImpl, int n, int n2) {
        CoverageImpl$RangeImpl coverageImpl$RangeImpl2;
        if (!$assertionsDisabled && null != coverageImpl$RangeImpl && coverageImpl$RangeImpl.end >= n) {
            throw new AssertionError();
        }
        if (null == coverageImpl$RangeImpl) {
            this.first = coverageImpl$RangeImpl2 = CoverageImpl$RangeImpl.create(n, n2, this.first);
        } else if (this.autoCompact && coverageImpl$RangeImpl.end == n - 1) {
            coverageImpl$RangeImpl.end = n2;
            coverageImpl$RangeImpl2 = coverageImpl$RangeImpl;
        } else {
            coverageImpl$RangeImpl.next = coverageImpl$RangeImpl2 = CoverageImpl$RangeImpl.create(n, n2, coverageImpl$RangeImpl.next);
        }
        CoverageImpl$RangeImpl coverageImpl$RangeImpl3 = coverageImpl$RangeImpl2.next;
        while (null != coverageImpl$RangeImpl3 && coverageImpl$RangeImpl3.end <= n2) {
            coverageImpl$RangeImpl2.next = coverageImpl$RangeImpl3.next;
            coverageImpl$RangeImpl3.release();
            coverageImpl$RangeImpl3 = coverageImpl$RangeImpl2.next;
        }
        if (null != coverageImpl$RangeImpl3) {
            if (coverageImpl$RangeImpl3.start <= n2) {
                coverageImpl$RangeImpl3.start = n2 + 1;
            }
            if (this.autoCompact && coverageImpl$RangeImpl3.start == n2 + 1) {
                coverageImpl$RangeImpl2.end = coverageImpl$RangeImpl3.end;
                coverageImpl$RangeImpl2.next = coverageImpl$RangeImpl3.next;
                coverageImpl$RangeImpl3.release();
            }
        }
        return coverageImpl$RangeImpl2;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$list$impl$CoverageImpl == null ? (class$de$vw$mib$list$impl$CoverageImpl = CoverageImpl.class$("de.vw.mib.list.impl.CoverageImpl")) : class$de$vw$mib$list$impl$CoverageImpl).desiredAssertionStatus();
    }
}

