/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatesetup.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.climatesetup.transformer.AbstractClimateSetupFunctionAvailability_ClimateSetupTransformer;

public class ClimateSetupFunctionAvailability_ClimateSetupTransformer
extends AbstractClimateSetupFunctionAvailability_ClimateSetupTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

