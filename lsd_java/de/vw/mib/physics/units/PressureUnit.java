/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.PressureUnit$Impl;
import de.vw.mib.physics.units.ScalarFactorUnit;

public interface PressureUnit
extends ScalarFactorUnit {
    public static final PressureUnit SI;
    public static final PressureUnit PASCAL;
    public static final PressureUnit BAR;
    public static final PressureUnit PSI;
    public static final PressureUnit PIEZE;
    public static final PressureUnit ATMOSPHERE;

    static {
        PASCAL = SI = new PressureUnit$Impl(1.0, "Pa");
        BAR = new PressureUnit$Impl(100000.0, "bar");
        PSI = new PressureUnit$Impl(6894.757, "psi");
        PIEZE = new PressureUnit$Impl(1000.0, "pz");
        ATMOSPHERE = new PressureUnit$Impl(101325.0, "atm");
    }
}

