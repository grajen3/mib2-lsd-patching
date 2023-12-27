/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.openclose.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.openclose.transformer.AbstractCarOpenCloseFunctionAvailableReason_OpenCloseTransformer;

public class CarOpenCloseFunctionAvailableReason_OpenCloseTransformer
extends AbstractCarOpenCloseFunctionAvailableReason_OpenCloseTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

