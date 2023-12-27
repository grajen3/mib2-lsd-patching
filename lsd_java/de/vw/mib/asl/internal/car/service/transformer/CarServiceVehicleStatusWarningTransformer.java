/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.car.service.transformer.CarVehicleStatusWarningCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceVehicleStatusWarningTransformer;

public class CarServiceVehicleStatusWarningTransformer
extends AbstractCarServiceVehicleStatusWarningTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((CarVehicleStatusWarningCollector)object).warningId;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 1: {
                return ((CarVehicleStatusWarningCollector)object).warningText;
            }
            case 3: {
                return ((CarVehicleStatusWarningCollector)object).alternativeText;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }
}

