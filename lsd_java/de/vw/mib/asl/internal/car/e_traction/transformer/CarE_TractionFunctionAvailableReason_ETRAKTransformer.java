/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.AbstractCarE_TractionFunctionAvailableReason_ETRAKTransformer;

public class CarE_TractionFunctionAvailableReason_ETRAKTransformer
extends AbstractCarE_TractionFunctionAvailableReason_ETRAKTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

