/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsRankedlistEventrankingsTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSportsRankedlistEventrankingsTransformer
extends AbstractTravelLinkSportsRankedlistEventrankingsTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getInt(26674176, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return GenericPropertyUtility.getString(43451392, 0, genericPropertyContainer);
            }
            case 3: {
                return GenericPropertyUtility.getString(43451392, 1, genericPropertyContainer);
            }
            case 2: {
                return GenericPropertyUtility.getString(43451392, 2, genericPropertyContainer);
            }
            case 4: {
                return GenericPropertyUtility.getString(43451392, 3, genericPropertyContainer);
            }
            case 5: {
                return GenericPropertyUtility.getString(77005824, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

