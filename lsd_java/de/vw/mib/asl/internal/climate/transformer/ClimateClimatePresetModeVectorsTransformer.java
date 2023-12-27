/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climate.transformer;

import de.vw.mib.asl.internal.car.climate.PresetCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.AbstractClimateClimatePresetModeVectorsTransformer;

public class ClimateClimatePresetModeVectorsTransformer
extends AbstractClimateClimatePresetModeVectorsTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((PresetCollector)object).getPresetModeAuto();
            }
            case 2: {
                return ((PresetCollector)object).getPresetModeMaxDefrost();
            }
            case 3: {
                return ((PresetCollector)object).getPresetModeManual();
            }
            case 1: {
                return ((PresetCollector)object).getPresetModeMaxAc();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

