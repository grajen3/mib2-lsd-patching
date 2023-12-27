/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climate.transformer;

import de.vw.mib.asl.internal.car.climate.ProfileCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.AbstractClimateClimateProfileModeVectorTransformer;

public class ClimateClimateProfileModeVectorTransformer
extends AbstractClimateClimateProfileModeVectorTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((ProfileCollector)object).profileStyle;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

