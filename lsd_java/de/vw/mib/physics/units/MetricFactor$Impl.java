/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.MetricFactor;

public class MetricFactor$Impl
implements MetricFactor {
    private final double factor;
    private final String prefix;

    MetricFactor$Impl(double d2, String string) {
        this.factor = d2;
        this.prefix = string;
    }

    @Override
    public double getFactor() {
        return this.factor;
    }

    @Override
    public String getSymbol() {
        return this.prefix;
    }

    @Override
    public double apply(double d2) {
        return d2 * this.factor;
    }

    @Override
    public double substitude(double d2) {
        return d2 / this.factor;
    }
}

