/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceFunctionExistence_TiresTransformer;

public class CarServiceFunctionExistence_TiresTransformer
extends AbstractCarServiceFunctionExistence_TiresTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

