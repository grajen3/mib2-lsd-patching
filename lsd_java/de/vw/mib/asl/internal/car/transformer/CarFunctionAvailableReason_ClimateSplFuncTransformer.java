/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.transformer.AbstractCarFunctionAvailableReason_ClimateSplFuncTransformer;

public class CarFunctionAvailableReason_ClimateSplFuncTransformer
extends AbstractCarFunctionAvailableReason_ClimateSplFuncTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

