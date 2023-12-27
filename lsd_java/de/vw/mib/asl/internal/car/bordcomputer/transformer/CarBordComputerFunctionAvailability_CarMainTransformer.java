/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerFunctionAvailability_CarMainTransformer;

public class CarBordComputerFunctionAvailability_CarMainTransformer
extends AbstractCarBordComputerFunctionAvailability_CarMainTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

