/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerHUDConfigurationTransformer;

public class CarBordComputerHUDConfigurationTransformer
extends AbstractCarBordComputerHUDConfigurationTransformer {
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

