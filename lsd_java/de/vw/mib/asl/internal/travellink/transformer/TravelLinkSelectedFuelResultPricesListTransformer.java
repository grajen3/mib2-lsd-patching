/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSelectedFuelResultPricesListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSelectedFuelResultPricesListTransformer
extends AbstractTravelLinkSelectedFuelResultPricesListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getInt(-1700722944, 0, genericPropertyContainer);
            }
            case 1: {
                return GenericPropertyUtility.getInt(-1717500160, 0, genericPropertyContainer);
            }
            case 2: {
                return GenericPropertyUtility.getInt(-1767831808, 0, genericPropertyContainer);
            }
            case 3: {
                return (int)GenericPropertyUtility.getFloat(-1734277376, 0, genericPropertyContainer);
            }
            case 4: {
                float f2 = GenericPropertyUtility.getFloat(-1734277376, 0, genericPropertyContainer);
                int n2 = (int)(f2 * 51266);
                return n2 % 100;
            }
        }
        throw new IllegalArgumentException();
    }
}

