/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.seats.transformer.AbstractCarSeatsFunctionAvailableReason_2Transformer;

public class CarSeatsFunctionAvailableReason_2Transformer
extends AbstractCarSeatsFunctionAvailableReason_2Transformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

