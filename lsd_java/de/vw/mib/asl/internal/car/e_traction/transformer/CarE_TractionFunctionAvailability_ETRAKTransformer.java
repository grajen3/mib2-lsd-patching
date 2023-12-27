/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.AbstractCarE_TractionFunctionAvailability_ETRAKTransformer;

public class CarE_TractionFunctionAvailability_ETRAKTransformer
extends AbstractCarE_TractionFunctionAvailability_ETRAKTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

