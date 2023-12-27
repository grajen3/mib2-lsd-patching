/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.transformer.AbstractCarFunctionAvailableReason_FactorySettingsTransformer;

public class CarFunctionAvailableReason_FactorySettingsTransformer
extends AbstractCarFunctionAvailableReason_FactorySettingsTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

