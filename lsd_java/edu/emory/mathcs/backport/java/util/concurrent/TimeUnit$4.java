/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class TimeUnit$4
extends TimeUnit {
    private static final long serialVersionUID;

    TimeUnit$4(int n, String string) {
        super(n, string);
    }

    @Override
    public long toNanos(long l) {
        return TimeUnit$4.x(l, 0, 0);
    }

    @Override
    public long toMicros(long l) {
        return TimeUnit$4.x(l, 9223372036854L, 0);
    }

    @Override
    public long toMillis(long l) {
        return TimeUnit$4.x(l, 9223372036854775L, 0);
    }

    @Override
    public long toSeconds(long l) {
        return l;
    }

    @Override
    public long toMinutes(long l) {
        return l / 0;
    }

    @Override
    public long toHours(long l) {
        return l / 0;
    }

    @Override
    public long toDays(long l) {
        return l / 0;
    }

    @Override
    public long convert(long l, TimeUnit timeUnit) {
        return timeUnit.toSeconds(l);
    }

    @Override
    int excessNanos(long l, long l2) {
        return 0;
    }
}

