/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceFunctionAvailability_ServiceTransformer;

public class CarServiceFunctionAvailability_ServiceTransformer
extends AbstractCarServiceFunctionAvailability_ServiceTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

