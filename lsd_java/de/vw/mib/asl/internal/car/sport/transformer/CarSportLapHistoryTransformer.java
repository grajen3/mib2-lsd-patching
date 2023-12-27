/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sport.transformer;

import de.vw.mib.asl.internal.car.sport.RaceLapCollector;
import generated.de.vw.mib.asl.internal.car.sport.transformer.AbstractCarSportLapHistoryTransformer;

public class CarSportLapHistoryTransformer
extends AbstractCarSportLapHistoryTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((RaceLapCollector)object).getLapTime();
            }
            case 1: {
                return ((RaceLapCollector)object).getDeviationTime();
            }
        }
        throw new IllegalArgumentException("columnID out of range");
    }
}

