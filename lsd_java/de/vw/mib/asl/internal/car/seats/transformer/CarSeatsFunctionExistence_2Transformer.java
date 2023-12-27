/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.seats.transformer.AbstractCarSeatsFunctionExistence_2Transformer;

public class CarSeatsFunctionExistence_2Transformer
extends AbstractCarSeatsFunctionExistence_2Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

