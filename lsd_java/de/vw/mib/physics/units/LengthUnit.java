/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.LengthUnit$Impl;
import de.vw.mib.physics.units.ScalarFactorUnit;

public interface LengthUnit
extends ScalarFactorUnit {
    public static final LengthUnit SI;
    public static final LengthUnit METER;
    public static final LengthUnit INCH;
    public static final LengthUnit FOOT;
    public static final LengthUnit YARD;
    public static final LengthUnit LANDMILE;
    public static final LengthUnit NAUTICALMILE;
    public static final LengthUnit LIGHTYEAR;
    public static final LengthUnit PARSEC;
    public static final LengthUnit ASTRONOMICALUNIT;
    public static final LengthUnit ANGSTROM;
    public static final LengthUnit FURLONG;
    public static final LengthUnit KILOMETER;

    static {
        METER = SI = new LengthUnit$Impl(1.0, "m");
        INCH = new LengthUnit$Impl(0.0254, "in");
        FOOT = new LengthUnit$Impl(0.30479999999999996, "ft");
        YARD = new LengthUnit$Impl(0.9144, "yd");
        LANDMILE = new LengthUnit$Impl(1609.344, "mi");
        NAUTICALMILE = new LengthUnit$Impl(1852.0, "nmi");
        LIGHTYEAR = new LengthUnit$Impl(9.4607304725808E15, "ly");
        PARSEC = new LengthUnit$Impl(3.08567782E16, "pc");
        ASTRONOMICALUNIT = new LengthUnit$Impl(1.495978707E11, "AU");
        ANGSTROM = new LengthUnit$Impl(1.0E-10, "\u00c5");
        FURLONG = new LengthUnit$Impl(201.168, "fur");
        KILOMETER = new LengthUnit$Impl(1000.0, "km");
    }
}

