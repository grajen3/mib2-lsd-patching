/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$1;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$2;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$3;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$4;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$5;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$6;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit$7;
import java.io.InvalidObjectException;
import java.io.Serializable;

public abstract class TimeUnit
implements Serializable {
    public static final TimeUnit NANOSECONDS = new TimeUnit$1(0, "NANOSECONDS");
    public static final TimeUnit MICROSECONDS = new TimeUnit$2(1, "MICROSECONDS");
    public static final TimeUnit MILLISECONDS = new TimeUnit$3(2, "MILLISECONDS");
    public static final TimeUnit SECONDS = new TimeUnit$4(3, "SECONDS");
    public static final TimeUnit MINUTES = new TimeUnit$5(4, "MINUTES");
    public static final TimeUnit HOURS = new TimeUnit$6(5, "HOURS");
    public static final TimeUnit DAYS = new TimeUnit$7(6, "DAYS");
    private static final TimeUnit[] values = new TimeUnit[]{NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS};
    private final int index;
    private final String name;
    static final long C0;
    static final long C1;
    static final long C2;
    static final long C3;
    static final long C4;
    static final long C5;
    static final long C6;
    static final long MAX;

    public static TimeUnit[] values() {
        return (TimeUnit[])values.clone();
    }

    public static TimeUnit valueOf(String string) {
        for (int i2 = 0; i2 < values.length; ++i2) {
            if (!TimeUnit.values[i2].name.equals(string)) continue;
            return values[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum const TimeUnit.").append(string).toString());
    }

    TimeUnit(int n, String string) {
        this.index = n;
        this.name = string;
    }

    static long x(long l, long l2, long l3) {
        if (l > l3) {
            return Long.MAX_VALUE;
        }
        if (l < -l3) {
            return Long.MIN_VALUE;
        }
        return l * l2;
    }

    public abstract long convert(long l, TimeUnit timeUnit) {
    }

    public abstract long toNanos(long l) {
    }

    public abstract long toMicros(long l) {
    }

    public abstract long toMillis(long l) {
    }

    public abstract long toSeconds(long l) {
    }

    public abstract long toMinutes(long l) {
    }

    public abstract long toHours(long l) {
    }

    public abstract long toDays(long l) {
    }

    abstract int excessNanos(long l, long l2) {
    }

    public String name() {
        return this.name;
    }

    public int ordinal() {
        return this.index;
    }

    protected Object readResolve() {
        try {
            return TimeUnit.valueOf(this.name);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidObjectException(new StringBuffer().append(this.name).append(" is not a valid enum for TimeUnit").toString());
        }
    }

    public void timedWait(Object object, long l) {
        if (l > 0L) {
            long l2 = this.toMillis(l);
            int n = this.excessNanos(l, l2);
            object.wait(l2, n);
        }
    }

    public void timedJoin(Thread thread, long l) {
        if (l > 0L) {
            long l2 = this.toMillis(l);
            int n = this.excessNanos(l, l2);
            thread.join(l2, n);
        }
    }

    public void sleep(long l) {
        if (l > 0L) {
            long l2 = this.toMillis(l);
            int n = this.excessNanos(l, l2);
            Thread.sleep(l2, n);
        }
    }

    public String toString() {
        return this.name;
    }
}

