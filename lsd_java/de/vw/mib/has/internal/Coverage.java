/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.internal.Range;

class Coverage {
    private final boolean autoCompact;
    private Range first;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$has$internal$Coverage;

    Coverage() {
        this(false);
    }

    Coverage(boolean bl) {
        this.autoCompact = bl;
    }

    public void addRange(int n, int n2) {
        if (n2 < n) {
            throw new IllegalArgumentException("end<start");
        }
        Range range = this.first;
        Range range2 = null;
        while (null != range && range.end < n) {
            range2 = range;
            range = range.next;
        }
        while (null != range && range.start <= n && n <= n2) {
            n = range.end + 1;
            range2 = range;
            range = range.next;
        }
        if (null != range && n <= n2 && range.start <= n2) {
            int n3 = range.start - 1;
            while (true) {
                if (range.end < n2 && null != range.next && range.end >= range.next.start - 1) {
                    range = range.next;
                    continue;
                }
                if (range.end < n2) {
                    int n4 = n3 = null != range.next ? range.next.start - 1 : n2;
                }
                if (null == (range = range.next) || range.start > n2) break;
            }
            n2 = Math.min(n2, n3);
        }
        if (n <= n2) {
            this.append(range2, n, n2);
        }
    }

    public void clear() {
        Range range = this.first;
        while (null != range) {
            Range range2 = range;
            range = range.next;
            range2.release();
        }
        this.first = null;
    }

    public boolean intersects(int n, int n2) {
        boolean bl = false;
        if (n <= n2) {
            Range range = this.first;
            while (!bl && null != range && range.start <= n2) {
                bl = range.end >= n;
                range = range.next;
            }
        }
        return bl;
    }

    public boolean covers(int n, int n2) {
        boolean bl;
        Range range = this.first;
        if (n > n2) {
            bl = true;
        } else {
            while (null != range && range.end < n) {
                range = range.next;
            }
            boolean bl2 = bl = null != range && range.start <= n;
            while (bl && null != range && range.end < n2) {
                bl = null != range.next && range.end == range.next.start - 1;
                range = range.next;
            }
        }
        return bl;
    }

    public void clearRange(int n, int n2) {
        if (n2 < n) {
            throw new IllegalArgumentException("end<start");
        }
        Range range = this.first;
        Range range2 = null;
        while (null != range && range.end < n) {
            range2 = range;
            range = range.next;
        }
        if (null != range && range.start <= n2) {
            if (range.start < n) {
                if (range.end > n2) {
                    range.next = Range.create(n2 + 1, range.end, range.next);
                }
                range.end = n - 1;
                range2 = range;
                range = range.next;
            }
            Range range3 = range;
            while (range != null && range.end <= n2) {
                Range range4 = range;
                range = range.next;
                range4.release();
            }
            if (range3 != range) {
                if (null != range2) {
                    range2.next = range;
                } else {
                    this.first = range;
                }
            }
            if (null != range && range.start <= n2) {
                range.start = n2 + 1;
            }
        }
    }

    public void insertGap(int n, int n2) {
        if (0 > n2) {
            throw new IllegalArgumentException("negative size");
        }
        if (0 < n2) {
            Range range = this.first;
            while (null != range && range.end < n) {
                range = range.next;
            }
            if (null != range && range.start < n) {
                range.next = Range.create(n, range.end, range.next);
                range.end = n - 1;
                range = range.next;
            }
            while (null != range) {
                range.start += n2;
                range.end += n2;
                range = range.next;
            }
        }
    }

    public void removeRange(int n, int n2) {
        if (0 > n2) {
            throw new IllegalArgumentException("negative size");
        }
        if (0 < n2) {
            Range range = this.first;
            Range range2 = null;
            while (null != range && range.end < n) {
                range2 = range;
                range = range.next;
            }
            if (null != range && range.start < n) {
                range.end = Math.max(range.end - n2, n - 1);
                range2 = range;
                range = range.next;
            }
            Range range3 = range;
            while (range != null && range.end - n2 < n) {
                Range range4 = range;
                range = range.next;
                range4.release();
            }
            if (range3 != range) {
                if (null != range2) {
                    range2.next = range;
                } else {
                    this.first = range;
                }
            }
            if (this.autoCompact && null != range2 && null != range && range2.end + 1 == Math.max(range.start - n2, n)) {
                range2.end = range.end - n2;
                range2.next = range.next;
                range.release();
                range = range2.next;
            }
            while (null != range) {
                range.start = Math.max(range.start - n2, n);
                range.end -= n2;
                range = range.next;
            }
        }
    }

    public void upperBound(int n) {
        Range range = this.first;
        Range range2 = null;
        while (null != range && range.end <= n) {
            range2 = range;
            range = range.next;
        }
        if (null != range) {
            if (range.start <= n) {
                range.end = n;
                range2 = range;
                range = range.next;
            }
            while (null != range) {
                Range range3 = range;
                range = range.next;
                range3.release();
            }
            if (null != range2) {
                range2.next = null;
            } else {
                this.first = null;
            }
        }
    }

    public void compact() {
        Range range = this.first;
        if (null != range) {
            Range range2;
            while (null != (range2 = range.next)) {
                if (range.end + 1 == range2.start) {
                    range.end = range2.end;
                    range.next = range2.next;
                    range2.release();
                    continue;
                }
                range = range2;
            }
        }
    }

    private Range append(Range range, int n, int n2) {
        Range range2;
        if (!$assertionsDisabled && null != range && range.end >= n) {
            throw new AssertionError();
        }
        if (null == range) {
            this.first = range2 = Range.create(n, n2, this.first);
        } else if (this.autoCompact && range.end == n - 1) {
            range.end = n2;
            range2 = range;
        } else {
            range.next = range2 = Range.create(n, n2, range.next);
        }
        Range range3 = range2.next;
        while (null != range3 && range3.end <= n2) {
            range2.next = range3.next;
            range3.release();
            range3 = range2.next;
        }
        if (null != range3) {
            if (range3.start <= n2) {
                range3.start = n2 + 1;
            }
            if (this.autoCompact && range3.start == n2 + 1) {
                range2.end = range3.end;
                range2.next = range3.next;
                range3.release();
            }
        }
        return range2;
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
        $assertionsDisabled = !(class$de$vw$mib$has$internal$Coverage == null ? (class$de$vw$mib$has$internal$Coverage = Coverage.class$("de.vw.mib.has.internal.Coverage")) : class$de$vw$mib$has$internal$Coverage).desiredAssertionStatus();
    }
}

