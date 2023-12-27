/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.hud.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.hud.transformer.AbstractCarHUDFunctionExistenceTransformer;

public class CarHUDFunctionExistenceTransformer
extends AbstractCarHUDFunctionExistenceTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

