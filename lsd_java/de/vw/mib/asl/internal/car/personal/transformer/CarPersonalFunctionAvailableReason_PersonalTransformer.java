/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.personal.transformer.AbstractCarPersonalFunctionAvailableReason_PersonalTransformer;

public class CarPersonalFunctionAvailableReason_PersonalTransformer
extends AbstractCarPersonalFunctionAvailableReason_PersonalTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

