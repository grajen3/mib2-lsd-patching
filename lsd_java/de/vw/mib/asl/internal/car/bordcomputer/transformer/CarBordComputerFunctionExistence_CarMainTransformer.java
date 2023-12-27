/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerFunctionExistence_CarMainTransformer;

public class CarBordComputerFunctionExistence_CarMainTransformer
extends AbstractCarBordComputerFunctionExistence_CarMainTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

