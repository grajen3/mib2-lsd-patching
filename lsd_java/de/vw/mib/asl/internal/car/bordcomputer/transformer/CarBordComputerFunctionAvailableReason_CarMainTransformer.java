/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerFunctionAvailableReason_CarMainTransformer;

public class CarBordComputerFunctionAvailableReason_CarMainTransformer
extends AbstractCarBordComputerFunctionAvailableReason_CarMainTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

