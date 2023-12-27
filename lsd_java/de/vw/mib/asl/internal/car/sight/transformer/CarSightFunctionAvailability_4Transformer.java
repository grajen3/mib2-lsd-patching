/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sight.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.sight.transformer.AbstractCarSightFunctionAvailability_4Transformer;

public class CarSightFunctionAvailability_4Transformer
extends AbstractCarSightFunctionAvailability_4Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

