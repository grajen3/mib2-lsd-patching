/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatebar.transformer;

import generated.de.vw.mib.asl.internal.climatebar.transformer.AbstractClimateBarClimateBarTemperatureRangeTransformer;

public class ClimateBarClimateBarTemperatureRangeTransformer
extends AbstractClimateBarClimateBarTemperatureRangeTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

