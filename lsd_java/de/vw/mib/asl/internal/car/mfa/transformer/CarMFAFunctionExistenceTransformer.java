/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.mfa.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.mfa.transformer.AbstractCarMFAFunctionExistenceTransformer;

public class CarMFAFunctionExistenceTransformer
extends AbstractCarMFAFunctionExistenceTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

