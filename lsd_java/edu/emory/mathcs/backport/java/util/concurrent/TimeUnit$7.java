/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class TimeUnit$7
extends TimeUnit {
    private static final long serialVersionUID;

    TimeUnit$7(int n, String string) {
        super(n, string);
    }

    @Override
    public long toNanos(long l) {
        return TimeUnit$7.x(l, 86400000000000L, 0);
    }

    @Override
    public long toMicros(long l) {
        return TimeUnit$7.x(l, 86400000000L, 0);
    }

    @Override
    public long toMillis(long l) {
        return TimeUnit$7.x(l, 0, 106751991167L);
    }

    @Override
    public long toSeconds(long l) {
        return TimeUnit$7.x(l, 0, 106751991167300L);
    }

    @Override
    public long toMinutes(long l) {
        return TimeUnit$7.x(l, 0, 0x16C16C16C16C16L);
    }

    @Override
    public long toHours(long l) {
        return TimeUnit$7.x(l, 0, 0x555555555555555L);
    }

    @Override
    public long toDays(long l) {
        return l;
    }

    @Override
    public long convert(long l, TimeUnit timeUnit) {
        return timeUnit.toDays(l);
    }

    @Override
    int excessNanos(long l, long l2) {
        return 0;
    }
}

