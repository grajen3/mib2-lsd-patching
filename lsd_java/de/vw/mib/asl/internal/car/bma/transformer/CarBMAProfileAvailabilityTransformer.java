/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bma.transformer;

import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import generated.de.vw.mib.asl.internal.car.bma.transformer.AbstractCarBMAProfileAvailabilityTransformer;

public class CarBMAProfileAvailabilityTransformer
extends AbstractCarBMAProfileAvailabilityTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return ((CarFunctionCollector)object).functionAvailable;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return ((CarFunctionCollector)object).functionReason;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }
}

