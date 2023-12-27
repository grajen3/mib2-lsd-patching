/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.MassUnit$Impl;
import de.vw.mib.physics.units.ScalarFactorUnit;

public interface MassUnit
extends ScalarFactorUnit {
    public static final MassUnit SI;
    public static final MassUnit KILOGRAM;
    public static final MassUnit POUND;

    static {
        KILOGRAM = SI = new MassUnit$Impl(1.0, "kg");
        POUND = new MassUnit$Impl(0.45359237, "lb");
    }
}

