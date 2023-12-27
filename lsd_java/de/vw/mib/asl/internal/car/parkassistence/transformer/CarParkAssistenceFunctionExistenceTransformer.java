/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.AbstractCarParkAssistenceFunctionExistenceTransformer;

public class CarParkAssistenceFunctionExistenceTransformer
extends AbstractCarParkAssistenceFunctionExistenceTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

