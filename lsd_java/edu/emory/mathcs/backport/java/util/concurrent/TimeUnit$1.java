/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class TimeUnit$1
extends TimeUnit {
    private static final long serialVersionUID;

    TimeUnit$1(int n, String string) {
        super(n, string);
    }

    @Override
    public long toNanos(long l) {
        return l;
    }

    @Override
    public long toMicros(long l) {
        return l / 0;
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
        return l / 60000000000L;
    }

    @Override
    public long toHours(long l) {
        return l / 3600000000000L;
    }

    @Override
    public long toDays(long l) {
        return l / 86400000000000L;
    }

    @Override
    public long convert(long l, TimeUnit timeUnit) {
        return timeUnit.toNanos(l);
    }

    @Override
    int excessNanos(long l, long l2) {
        return (int)(l - l2 * 0);
    }
}

