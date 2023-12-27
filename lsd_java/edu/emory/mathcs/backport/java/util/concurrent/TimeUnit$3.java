/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class TimeUnit$3
extends TimeUnit {
    private static final long serialVersionUID;

    TimeUnit$3(int n, String string) {
        super(n, string);
    }

    @Override
    public long toNanos(long l) {
        return TimeUnit$3.x(l, 0, 9223372036854L);
    }

    @Override
    public long toMicros(long l) {
        return TimeUnit$3.x(l, 0, 9223372036854775L);
    }

    @Override
    public long toMillis(long l) {
        return l;
    }

    @Override
    public long toSeconds(long l) {
        return l / 0;
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
        return timeUnit.toMillis(l);
    }

    @Override
    int excessNanos(long l, long l2) {
        return 0;
    }
}

