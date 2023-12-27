/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.AreaUnit$Impl;
import de.vw.mib.physics.units.LengthUnit;
import de.vw.mib.physics.units.ScalarFactorUnit;

public interface AreaUnit
extends ScalarFactorUnit {
    public static final AreaUnit SI;
    public static final AreaUnit SQUAREMETER;
    public static final AreaUnit SQUAREINCH;
    public static final AreaUnit SQUAREFOOT;
    public static final AreaUnit SQUAREYARD;
    public static final AreaUnit SQUARELANDMILE;
    public static final AreaUnit ACRE;
    public static final AreaUnit ARE;
    public static final AreaUnit HECTARE;
    public static final AreaUnit SQUAREKILOMETER;

    static {
        SQUAREMETER = SI = new AreaUnit$Impl(1.0, "m\u00b2");
        SQUAREINCH = new AreaUnit$Impl(Math.pow(LengthUnit.INCH.getFactor(), 2.0), "in\u00b2");
        SQUAREFOOT = new AreaUnit$Impl(Math.pow(LengthUnit.FOOT.getFactor(), 2.0), "ft\u00b2");
        SQUAREYARD = new AreaUnit$Impl(Math.pow(LengthUnit.YARD.getFactor(), 2.0), "yd\u00b2");
        SQUARELANDMILE = new AreaUnit$Impl(Math.pow(LengthUnit.LANDMILE.getFactor(), 2.0), "mi\u00b2");
        ACRE = new AreaUnit$Impl(4046.8564224, "ac");
        ARE = new AreaUnit$Impl(100.0, "a");
        HECTARE = new AreaUnit$Impl(10000.0, "ha");
        SQUAREKILOMETER = new AreaUnit$Impl(1000000.0, "km\u00b2");
    }
}

