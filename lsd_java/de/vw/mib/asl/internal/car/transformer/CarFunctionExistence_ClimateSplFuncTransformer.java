/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.transformer.AbstractCarFunctionExistence_ClimateSplFuncTransformer;

public class CarFunctionExistence_ClimateSplFuncTransformer
extends AbstractCarFunctionExistence_ClimateSplFuncTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

