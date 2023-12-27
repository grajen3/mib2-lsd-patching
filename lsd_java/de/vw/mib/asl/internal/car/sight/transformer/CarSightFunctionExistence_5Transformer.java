/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sight.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.sight.transformer.AbstractCarSightFunctionExistence_5Transformer;

public class CarSightFunctionExistence_5Transformer
extends AbstractCarSightFunctionExistence_5Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

