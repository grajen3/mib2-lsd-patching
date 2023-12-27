/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.seats.transformer.AbstractCarSeatsFunctionAvailability_2Transformer;

public class CarSeatsFunctionAvailability_2Transformer
extends AbstractCarSeatsFunctionAvailability_2Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

