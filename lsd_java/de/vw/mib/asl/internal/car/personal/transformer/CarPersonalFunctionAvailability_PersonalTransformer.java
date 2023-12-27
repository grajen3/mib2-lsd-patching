/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.personal.transformer.AbstractCarPersonalFunctionAvailability_PersonalTransformer;

public class CarPersonalFunctionAvailability_PersonalTransformer
extends AbstractCarPersonalFunctionAvailability_PersonalTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        int n2 = ((FunctionState)object).getFunctionState();
        return n2 != 1;
    }
}

