/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.light.transformer.AbstractCarLightFunctionExistence_Light1Transformer;

public class CarLightFunctionExistence_Light1Transformer
extends AbstractCarLightFunctionExistence_Light1Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

