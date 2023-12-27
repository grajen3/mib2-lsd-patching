/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerFunctionExistence_CarBordComputerTransformer;

public class CarBordComputerFunctionExistence_CarBordComputerTransformer
extends AbstractCarBordComputerFunctionExistence_CarBordComputerTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

