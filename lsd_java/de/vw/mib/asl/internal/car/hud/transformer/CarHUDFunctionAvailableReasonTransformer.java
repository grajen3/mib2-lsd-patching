/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.hud.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.hud.transformer.AbstractCarHUDFunctionAvailableReasonTransformer;

public class CarHUDFunctionAvailableReasonTransformer
extends AbstractCarHUDFunctionAvailableReasonTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

