/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.units;

import de.vw.mib.physics.units.ScalarFactorUnit;

public abstract class ScalarFactorUnit$AbstractImpl
implements ScalarFactorUnit {
    private final double factor;
    private final String symbol;

    protected ScalarFactorUnit$AbstractImpl(double d2, String string) {
        if (0.0 >= d2) {
            throw new IllegalArgumentException("factor must be positive");
        }
        this.factor = d2;
        this.symbol = null != string ? string : "";
    }

    @Override
    public double getFactor() {
        return this.factor;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}

