/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceRKA_RDKS_StatesTransformer;

public class CarServiceRKA_RDKS_StatesTransformer
extends AbstractCarServiceRKA_RDKS_StatesTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return (Boolean)object;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }
}

