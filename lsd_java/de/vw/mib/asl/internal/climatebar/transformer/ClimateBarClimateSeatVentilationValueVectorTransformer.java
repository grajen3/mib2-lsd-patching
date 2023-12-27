/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatebar.transformer;

import de.vw.mib.asl.internal.car.climate.SeatVentilationCollector;
import generated.de.vw.mib.asl.internal.climatebar.transformer.AbstractClimateBarClimateSeatVentilationValueVectorTransformer;

public class ClimateBarClimateSeatVentilationValueVectorTransformer
extends AbstractClimateBarClimateSeatVentilationValueVectorTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((SeatVentilationCollector)object).seatVentilationValue;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

