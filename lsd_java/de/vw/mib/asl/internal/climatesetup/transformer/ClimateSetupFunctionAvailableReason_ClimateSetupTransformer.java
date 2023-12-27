/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatesetup.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.climatesetup.transformer.AbstractClimateSetupFunctionAvailableReason_ClimateSetupTransformer;

public class ClimateSetupFunctionAvailableReason_ClimateSetupTransformer
extends AbstractClimateSetupFunctionAvailableReason_ClimateSetupTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

