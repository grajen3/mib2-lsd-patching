/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.AbstractCarFPKFunctionExistenceTransformer;

public class CarFPKFunctionExistenceTransformer
extends AbstractCarFPKFunctionExistenceTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

