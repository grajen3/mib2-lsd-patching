/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatesetup.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.climatesetup.transformer.AbstractClimateSetupFunctionExistence_ClimateSetupTransformer;

public class ClimateSetupFunctionExistence_ClimateSetupTransformer
extends AbstractClimateSetupFunctionExistence_ClimateSetupTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

