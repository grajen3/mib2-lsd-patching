/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.TemperatureUnit$Impl;

public interface TemperatureUnit {
    public static final TemperatureUnit SI;
    public static final TemperatureUnit KELVIN;
    public static final TemperatureUnit CELSIUS;
    public static final TemperatureUnit FAHRENHEIT;

    default public double getFactor() {
    }

    default public double getOffset() {
    }

    default public String getSymbol() {
    }

    static {
        KELVIN = SI = new TemperatureUnit$Impl(1.0, 0.0, "K");
        CELSIUS = new TemperatureUnit$Impl(1.0, 273.15, "\u00b0C");
        FAHRENHEIT = new TemperatureUnit$Impl(0.5555555555555556, 459.67, "\u00b0F");
    }
}

