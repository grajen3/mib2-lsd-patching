/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sight.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.sight.transformer.AbstractCarSightFunctionAvailableReason_4Transformer;

public class CarSightFunctionAvailableReason_4Transformer
extends AbstractCarSightFunctionAvailableReason_4Transformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

