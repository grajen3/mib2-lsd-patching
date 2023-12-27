/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.AbstractCarParkAssistenceFunctionAvailableReasonTransformer;

public class CarParkAssistenceFunctionAvailableReasonTransformer
extends AbstractCarParkAssistenceFunctionAvailableReasonTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

