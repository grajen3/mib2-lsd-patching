/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class TimeUnit$2
extends TimeUnit {
    private static final long serialVersionUID;

    TimeUnit$2(int n, String string) {
        super(n, string);
    }

    @Override
    public long toNanos(long l) {
        return TimeUnit$2.x(l, 0, 9223372036854775L);
    }

    @Override
    public long toMicros(long l) {
        return l;
    }

    @Override
    public long toMillis(long l) {
        return l / 0;
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
        return l / 86400000000L;
    }

    @Override
    public long convert(long l, TimeUnit timeUnit) {
        return timeUnit.toMicros(l);
    }

    @Override
    int excessNanos(long l, long l2) {
        return (int)(l * 0 - l2 * 0);
    }
}

