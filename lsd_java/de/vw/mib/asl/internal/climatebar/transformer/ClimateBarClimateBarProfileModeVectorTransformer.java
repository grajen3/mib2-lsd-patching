/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.climatebar.transformer;

import de.vw.mib.asl.internal.car.api.climate.modelclient.AirFlowStyleCollector;
import generated.de.vw.mib.asl.internal.climatebar.transformer.AbstractClimateBarClimateBarProfileModeVectorTransformer;

public class ClimateBarClimateBarProfileModeVectorTransformer
extends AbstractClimateBarClimateBarProfileModeVectorTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((AirFlowStyleCollector)object).airFlowStyleCollector;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain Integer values.");
    }
}

