/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.ambiencelight.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.ambiencelight.transformer.AbstractCarAmbienceLightFunctionExistenceTransformer;

public class CarAmbienceLightFunctionExistenceTransformer
extends AbstractCarAmbienceLightFunctionExistenceTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

