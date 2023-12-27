/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsRankedlistEventinfoTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSportsRankedlistEventinfoTransformer
extends AbstractTravelLinkSportsRankedlistEventinfoTransformer {
    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getString(-896072704, 0, genericPropertyContainer);
            }
            case 1: {
                return GenericPropertyUtility.getString(-879295488, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

