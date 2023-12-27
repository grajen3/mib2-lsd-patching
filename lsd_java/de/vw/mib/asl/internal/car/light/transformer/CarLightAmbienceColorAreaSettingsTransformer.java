/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.car.light.transformer.AmbienceLightAreaCollector;
import generated.de.vw.mib.asl.internal.car.light.transformer.AbstractCarLightAmbienceColorAreaSettingsTransformer;

public class CarLightAmbienceColorAreaSettingsTransformer
extends AbstractCarLightAmbienceColorAreaSettingsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                return ((AmbienceLightAreaCollector)object).isColorAreaMode();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 2: {
                return ((AmbienceLightAreaCollector)object).getColorAreaAvailability();
            }
            case 3: {
                return ((AmbienceLightAreaCollector)object).getBrightnessValue();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }
}

