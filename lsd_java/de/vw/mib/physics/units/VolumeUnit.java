/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.LengthUnit;
import de.vw.mib.physics.units.ScalarFactorUnit;
import de.vw.mib.physics.units.VolumeUnit$Impl;

public interface VolumeUnit
extends ScalarFactorUnit {
    public static final VolumeUnit SI;
    public static final VolumeUnit CUBICMETER;
    public static final VolumeUnit CUBICINCH;
    public static final VolumeUnit CUBICFOOT;
    public static final VolumeUnit CUBICYARD;
    public static final VolumeUnit CUBICLANDMILE;
    public static final VolumeUnit LITER;
    public static final VolumeUnit GALLON_IMPERIAL;
    public static final VolumeUnit GALLON_US;
    public static final VolumeUnit BARREL_IMPERIAL;
    public static final VolumeUnit BARREL_US;
    public static final VolumeUnit CUBICKILOMETER;

    static {
        CUBICMETER = SI = new VolumeUnit$Impl(1.0, "m\u00b3");
        CUBICINCH = new VolumeUnit$Impl(Math.pow(LengthUnit.INCH.getFactor(), 3.0), "in\u00b3");
        CUBICFOOT = new VolumeUnit$Impl(Math.pow(LengthUnit.FOOT.getFactor(), 3.0), "ft\u00b3");
        CUBICYARD = new VolumeUnit$Impl(Math.pow(LengthUnit.YARD.getFactor(), 3.0), "yd\u00b3");
        CUBICLANDMILE = new VolumeUnit$Impl(Math.pow(LengthUnit.LANDMILE.getFactor(), 3.0), "mi\u00b3");
        LITER = new VolumeUnit$Impl(0.001, "L");
        GALLON_IMPERIAL = new VolumeUnit$Impl(0.00454609, "gal (imp)");
        GALLON_US = new VolumeUnit$Impl(0.003785411784, "gal (US)");
        BARREL_IMPERIAL = new VolumeUnit$Impl(0.16365924, "bl (impl)");
        BARREL_US = new VolumeUnit$Impl(0.119240471196, "fl bl (US)");
        CUBICKILOMETER = new VolumeUnit$Impl(1.0E9, "km\u00b3");
    }
}

