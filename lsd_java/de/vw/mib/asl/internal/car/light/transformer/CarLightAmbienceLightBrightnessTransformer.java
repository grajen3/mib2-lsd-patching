/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

import generated.de.vw.mib.asl.internal.car.light.transformer.AbstractCarLightAmbienceLightBrightnessTransformer;

public class CarLightAmbienceLightBrightnessTransformer
extends AbstractCarLightAmbienceLightBrightnessTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }
}

