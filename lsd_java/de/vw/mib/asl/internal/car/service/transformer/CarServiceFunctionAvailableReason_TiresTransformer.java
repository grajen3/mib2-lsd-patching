/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceFunctionAvailableReason_TiresTransformer;

public class CarServiceFunctionAvailableReason_TiresTransformer
extends AbstractCarServiceFunctionAvailableReason_TiresTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

