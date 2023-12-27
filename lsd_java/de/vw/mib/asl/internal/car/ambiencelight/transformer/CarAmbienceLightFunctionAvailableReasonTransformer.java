/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.ambiencelight.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.ambiencelight.transformer.AbstractCarAmbienceLightFunctionAvailableReasonTransformer;

public class CarAmbienceLightFunctionAvailableReasonTransformer
extends AbstractCarAmbienceLightFunctionAvailableReasonTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

