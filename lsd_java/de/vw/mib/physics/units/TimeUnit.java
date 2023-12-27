/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.ScalarFactorUnit;
import de.vw.mib.physics.units.TimeUnit$Impl;

public interface TimeUnit
extends ScalarFactorUnit {
    public static final TimeUnit SI;
    public static final TimeUnit SECOND;
    public static final TimeUnit MINUTE;
    public static final TimeUnit HOUR;
    public static final TimeUnit DAY;
    public static final TimeUnit WEEK;
    public static final TimeUnit FORTNIGHT;
    public static final TimeUnit MONTH;
    public static final TimeUnit YEAR;
    public static final TimeUnit DECADE;
    public static final TimeUnit CENTURY;
    public static final TimeUnit JIFFY;

    static {
        SECOND = SI = new TimeUnit$Impl(1.0, "s");
        MINUTE = new TimeUnit$Impl(60.0, "m");
        HOUR = new TimeUnit$Impl(3600.0, "h");
        DAY = new TimeUnit$Impl(86400.0, "d");
        WEEK = new TimeUnit$Impl(604800.0, "wk");
        FORTNIGHT = new TimeUnit$Impl(1209600.0, "fn");
        MONTH = new TimeUnit$Impl(2592000.0, "mo");
        YEAR = new TimeUnit$Impl(3.1536E7, "y");
        DECADE = new TimeUnit$Impl(3.1536E8, "dec");
        CENTURY = new TimeUnit$Impl(3.1536E9, "c");
        JIFFY = new TimeUnit$Impl(0.016666666666666666, "j");
    }
}

