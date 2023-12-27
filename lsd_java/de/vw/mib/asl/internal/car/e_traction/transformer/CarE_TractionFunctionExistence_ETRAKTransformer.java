/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.AbstractCarE_TractionFunctionExistence_ETRAKTransformer;

public class CarE_TractionFunctionExistence_ETRAKTransformer
extends AbstractCarE_TractionFunctionExistence_ETRAKTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

