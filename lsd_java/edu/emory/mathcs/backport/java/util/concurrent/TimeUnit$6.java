/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class TimeUnit$6
extends TimeUnit {
    private static final long serialVersionUID;

    TimeUnit$6(int n, String string) {
        super(n, string);
    }

    @Override
    public long toNanos(long l) {
        return TimeUnit$6.x(l, 3600000000000L, 0);
    }

    @Override
    public long toMicros(long l) {
        return TimeUnit$6.x(l, 0, 0);
    }

    @Override
    public long toMillis(long l) {
        return TimeUnit$6.x(l, 0, 2562047788015L);
    }

    @Override
    public long toSeconds(long l) {
        return TimeUnit$6.x(l, 0, 2562047788015215L);
    }

    @Override
    public long toMinutes(long l) {
        return TimeUnit$6.x(l, 0, 0x222222222222222L);
    }

    @Override
    public long toHours(long l) {
        return l;
    }

    @Override
    public long toDays(long l) {
        return l / 0;
    }

    @Override
    public long convert(long l, TimeUnit timeUnit) {
        return timeUnit.toHours(l);
    }

    @Override
    int excessNanos(long l, long l2) {
        return 0;
    }
}

