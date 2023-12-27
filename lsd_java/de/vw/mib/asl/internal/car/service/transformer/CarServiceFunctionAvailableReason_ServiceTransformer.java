/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceFunctionAvailableReason_ServiceTransformer;

public class CarServiceFunctionAvailableReason_ServiceTransformer
extends AbstractCarServiceFunctionAvailableReason_ServiceTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

