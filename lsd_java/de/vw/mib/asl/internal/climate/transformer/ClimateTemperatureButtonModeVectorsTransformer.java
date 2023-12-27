/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climate.transformer;

import de.vw.mib.asl.internal.car.climate.TemperatureButtonCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.AbstractClimateTemperatureButtonModeVectorsTransformer;

public class ClimateTemperatureButtonModeVectorsTransformer
extends AbstractClimateTemperatureButtonModeVectorsTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((TemperatureButtonCollector)object).tempIncDecModifiableViaHMI;
            }
            case 1: {
                return ((TemperatureButtonCollector)object).temperatureValue;
            }
            case 2: {
                return ((TemperatureButtonCollector)object).unit;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

