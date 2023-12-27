/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.TemperatureUnit;

public class TemperatureUnit$Impl
implements TemperatureUnit {
    private final double factor;
    private final double offset;
    private final String symbol;

    TemperatureUnit$Impl(double d2, double d3, String string) {
        this.factor = d2;
        this.offset = d3;
        this.symbol = string;
    }

    @Override
    public double getFactor() {
        return this.factor;
    }

    @Override
    public double getOffset() {
        return this.offset;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}

