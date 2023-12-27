/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.AreaUnit;
import de.vw.mib.physics.units.EnergyUnit;
import de.vw.mib.physics.units.LengthUnit;
import de.vw.mib.physics.units.MassUnit;
import de.vw.mib.physics.units.PressureUnit;
import de.vw.mib.physics.units.ScalarFactorUnit;
import de.vw.mib.physics.units.TemperatureUnit;
import de.vw.mib.physics.units.TimeUnit;
import de.vw.mib.physics.units.VolumeUnit;

public final class UnitConversion {
    public static double convertLength(double d2, LengthUnit lengthUnit, LengthUnit lengthUnit2) {
        return UnitConversion.convert(d2, lengthUnit, lengthUnit2);
    }

    public static double convertArea(double d2, AreaUnit areaUnit, AreaUnit areaUnit2) {
        return UnitConversion.convert(d2, areaUnit, areaUnit2);
    }

    public static double convertVolume(double d2, VolumeUnit volumeUnit, VolumeUnit volumeUnit2) {
        return UnitConversion.convert(d2, volumeUnit, volumeUnit2);
    }

    public static double convertTime(double d2, TimeUnit timeUnit, TimeUnit timeUnit2) {
        return UnitConversion.convert(d2, timeUnit, timeUnit2);
    }

    public static double convertMass(double d2, MassUnit massUnit, MassUnit massUnit2) {
        return UnitConversion.convert(d2, massUnit, massUnit2);
    }

    public static double convertPressure(double d2, PressureUnit pressureUnit, PressureUnit pressureUnit2) {
        return UnitConversion.convert(d2, pressureUnit, pressureUnit2);
    }

    public static double convertEnergy(double d2, EnergyUnit energyUnit, EnergyUnit energyUnit2) {
        return UnitConversion.convert(d2, energyUnit, energyUnit2);
    }

    public static double convertSpeed(double d2, LengthUnit lengthUnit, TimeUnit timeUnit, LengthUnit lengthUnit2, TimeUnit timeUnit2) {
        d2 = UnitConversion.convert(d2, lengthUnit, lengthUnit2);
        d2 = UnitConversion.convert(d2, timeUnit2, timeUnit);
        return d2;
    }

    public static double convertVolumePerDistance(double d2, VolumeUnit volumeUnit, LengthUnit lengthUnit, VolumeUnit volumeUnit2, LengthUnit lengthUnit2) {
        d2 = UnitConversion.convert(d2, volumeUnit, volumeUnit2);
        d2 = UnitConversion.convert(d2, lengthUnit2, lengthUnit);
        return d2;
    }

    public static double convertVolumePerTime(double d2, VolumeUnit volumeUnit, TimeUnit timeUnit, VolumeUnit volumeUnit2, TimeUnit timeUnit2) {
        d2 = UnitConversion.convert(d2, volumeUnit, volumeUnit2);
        d2 = UnitConversion.convert(d2, timeUnit2, timeUnit);
        return d2;
    }

    public static double convertTemperature(double d2, TemperatureUnit temperatureUnit, TemperatureUnit temperatureUnit2) {
        d2 = UnitConversion.toKelvin(d2, temperatureUnit);
        d2 = UnitConversion.fromKelvin(d2, temperatureUnit2);
        return d2;
    }

    private static double convert(double d2, ScalarFactorUnit scalarFactorUnit, ScalarFactorUnit scalarFactorUnit2) {
        if (scalarFactorUnit != scalarFactorUnit2) {
            d2 = d2 * scalarFactorUnit.getFactor() / scalarFactorUnit2.getFactor();
        }
        return d2;
    }

    private static double toKelvin(double d2, TemperatureUnit temperatureUnit) {
        if (TemperatureUnit.KELVIN != temperatureUnit) {
            d2 = (d2 + temperatureUnit.getOffset()) * temperatureUnit.getFactor();
        }
        return d2;
    }

    private static double fromKelvin(double d2, TemperatureUnit temperatureUnit) {
        if (TemperatureUnit.KELVIN != temperatureUnit) {
            d2 = d2 / temperatureUnit.getFactor() - temperatureUnit.getOffset();
        }
        return d2;
    }

    private UnitConversion() {
    }
}

