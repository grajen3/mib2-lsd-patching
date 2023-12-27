/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.personal.transformer.AbstractCarPersonalFunctionExistence_PersonalTransformer;

public class CarPersonalFunctionExistence_PersonalTransformer
extends AbstractCarPersonalFunctionExistence_PersonalTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

