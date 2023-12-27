/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.MetricFactor$Impl;

public interface MetricFactor {
    public static final MetricFactor YOCTO = new MetricFactor$Impl(1.0E-24, "y");
    public static final MetricFactor ZEPTO = new MetricFactor$Impl(1.0E-21, "z");
    public static final MetricFactor ATTO = new MetricFactor$Impl(1.0E-18, "a");
    public static final MetricFactor FEMTO = new MetricFactor$Impl(1.0E-15, "f");
    public static final MetricFactor PICO = new MetricFactor$Impl(1.0E-12, "p");
    public static final MetricFactor NANO = new MetricFactor$Impl(1.0E-9, "n");
    public static final MetricFactor MICRO = new MetricFactor$Impl(1.0E-6, "\u00b5");
    public static final MetricFactor MILLI = new MetricFactor$Impl(0.001, "m");
    public static final MetricFactor CENTI = new MetricFactor$Impl(0.01, "c");
    public static final MetricFactor DECI = new MetricFactor$Impl(0.1, "d");
    public static final MetricFactor DECA = new MetricFactor$Impl(10.0, "da");
    public static final MetricFactor HECTA = new MetricFactor$Impl(100.0, "h");
    public static final MetricFactor KILO = new MetricFactor$Impl(1000.0, "k");
    public static final MetricFactor MEGA = new MetricFactor$Impl(1000000.0, "M");
    public static final MetricFactor GIGA = new MetricFactor$Impl(1.0E9, "G");
    public static final MetricFactor TERA = new MetricFactor$Impl(1.0E12, "T");
    public static final MetricFactor PETA = new MetricFactor$Impl(1.0E15, "P");
    public static final MetricFactor EXA = new MetricFactor$Impl(1.0E18, "E");
    public static final MetricFactor ZETTA = new MetricFactor$Impl(1.0E21, "Z");
    public static final MetricFactor YOTTA = new MetricFactor$Impl(1.0E24, "Y");

    default public double getFactor() {
    }

    default public String getSymbol() {
    }

    default public double apply(double d2) {
    }

    default public double substitude(double d2) {
    }
}

