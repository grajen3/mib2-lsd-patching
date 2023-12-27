/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsRankedlistEventrankingsFinalTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSportsRankedlistEventrankingsFinalTransformer
extends AbstractTravelLinkSportsRankedlistEventrankingsFinalTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 2: {
                return GenericPropertyUtility.getString(1721172992, 0, genericPropertyContainer);
            }
            case 4: {
                return GenericPropertyUtility.getString(1721172992, 1, genericPropertyContainer);
            }
            case 3: {
                return GenericPropertyUtility.getString(1721172992, 2, genericPropertyContainer);
            }
            case 5: {
                return GenericPropertyUtility.getString(1721172992, 3, genericPropertyContainer);
            }
            case 6: {
                return GenericPropertyUtility.getString(1754727424, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return false;
            }
        }
        throw new IllegalArgumentException();
    }
}

