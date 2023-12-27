/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.light.transformer.AbstractCarLightFunctionAvailableReason_LightTransformer;

public class CarLightFunctionAvailableReason_LightTransformer
extends AbstractCarLightFunctionAvailableReason_LightTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

