/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.AbstractCarFPKFunctionAvailableReasonTransformer;

public class CarFPKFunctionAvailableReasonTransformer
extends AbstractCarFPKFunctionAvailableReasonTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

