/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatebar.transformer;

import de.vw.mib.asl.internal.car.climate.SeatHeaterCollector;
import generated.de.vw.mib.asl.internal.climatebar.transformer.AbstractClimateBarClimateBarSeatHeaterValueVectorTransformer;

public class ClimateBarClimateBarSeatHeaterValueVectorTransformer
extends AbstractClimateBarClimateBarSeatHeaterValueVectorTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((SeatHeaterCollector)object).seatHeaterValue;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

