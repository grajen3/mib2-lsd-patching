/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationsInfoForMainViewCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkFuelStationsInfoForMainViewTransformer;

public class TravelLinkFuelStationsInfoForMainViewTransformer
extends AbstractTravelLinkFuelStationsInfoForMainViewTransformer {
    @Override
    public String getString(int n, Object object) {
        TravelLinkFuelStationsInfoForMainViewCollector travelLinkFuelStationsInfoForMainViewCollector = (TravelLinkFuelStationsInfoForMainViewCollector)object;
        switch (n) {
            case 1: {
                return travelLinkFuelStationsInfoForMainViewCollector.travellinkFuelStationsInfoForMainViewNameString;
            }
            case 2: {
                return travelLinkFuelStationsInfoForMainViewCollector.travellinkFuelStationsInfoForMainViewPriceString;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        return 0;
    }
}

