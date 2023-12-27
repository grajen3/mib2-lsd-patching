/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.transformer.AbstractCarFunctionAvailability_CarSetupTransformer;

public class CarFunctionAvailability_CarSetupTransformer
extends AbstractCarFunctionAvailability_CarSetupTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 == 2;
    }
}

