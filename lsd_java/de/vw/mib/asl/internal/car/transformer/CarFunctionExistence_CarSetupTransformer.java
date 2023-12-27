/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.transformer.AbstractCarFunctionExistence_CarSetupTransformer;

public class CarFunctionExistence_CarSetupTransformer
extends AbstractCarFunctionExistence_CarSetupTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

