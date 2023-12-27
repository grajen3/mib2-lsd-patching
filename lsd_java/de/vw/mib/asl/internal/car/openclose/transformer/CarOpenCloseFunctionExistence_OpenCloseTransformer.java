/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.openclose.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.openclose.transformer.AbstractCarOpenCloseFunctionExistence_OpenCloseTransformer;

public class CarOpenCloseFunctionExistence_OpenCloseTransformer
extends AbstractCarOpenCloseFunctionExistence_OpenCloseTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

