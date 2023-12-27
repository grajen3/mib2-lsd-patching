/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.transformer;

import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.AbstractCarParkAssistencePDCAcousticSettingsTransformer;

public class CarParkAssistencePDCAcousticSettingsTransformer
extends AbstractCarParkAssistencePDCAcousticSettingsTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((int[])object)[0];
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }
}

