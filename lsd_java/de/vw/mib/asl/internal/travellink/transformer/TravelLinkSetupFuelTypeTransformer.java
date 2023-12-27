/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetupFuelTypeCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSetupFuelTypeTransformer;

public class TravelLinkSetupFuelTypeTransformer
extends AbstractTravelLinkSetupFuelTypeTransformer {
    @Override
    public String getString(int n, Object object) {
        TravelLinkSetupFuelTypeCollector travelLinkSetupFuelTypeCollector = (TravelLinkSetupFuelTypeCollector)object;
        switch (n) {
            case 0: {
                return travelLinkSetupFuelTypeCollector.fuelTypeName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        TravelLinkSetupFuelTypeCollector travelLinkSetupFuelTypeCollector = (TravelLinkSetupFuelTypeCollector)object;
        switch (n) {
            case 1: {
                return travelLinkSetupFuelTypeCollector.fuelTypeActivated;
            }
        }
        throw new IllegalArgumentException();
    }
}

