/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.transformer.AbstractCarFunctionExistence_FactorySettingsTransformer;

public class CarFunctionExistence_FactorySettingsTransformer
extends AbstractCarFunctionExistence_FactorySettingsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

