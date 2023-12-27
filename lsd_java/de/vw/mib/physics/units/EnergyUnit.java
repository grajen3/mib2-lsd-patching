/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.EnergyUnit$Impl;
import de.vw.mib.physics.units.ScalarFactorUnit;

public interface EnergyUnit
extends ScalarFactorUnit {
    public static final EnergyUnit SI;
    public static final EnergyUnit JOULE;
    public static final EnergyUnit KILOWATTHOUR;
    public static final EnergyUnit CALORIE;
    public static final EnergyUnit ELECTRONVOLT;
    public static final EnergyUnit ERG;

    static {
        JOULE = SI = new EnergyUnit$Impl(1.0, "J");
        KILOWATTHOUR = new EnergyUnit$Impl(3600000.0, "kWh");
        CALORIE = new EnergyUnit$Impl(4.1868, "cal");
        ELECTRONVOLT = new EnergyUnit$Impl(1.60217733E-19, "eV");
        ERG = new EnergyUnit$Impl(1.0E-7, "erg");
    }
}

