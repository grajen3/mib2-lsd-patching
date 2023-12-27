/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkFavoriteSkiResortListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkFavoriteSkiResortListTransformer
extends AbstractTravelLinkFavoriteSkiResortListTransformer {
    @Override
    public int getInt(int n, Object object) {
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
            case 1: {
                return GenericPropertyUtility.getString(1829634816, 0, genericPropertyContainer);
            }
            case 2: {
                return GenericPropertyUtility.getString(1846412032, 0, genericPropertyContainer);
            }
            case 3: {
                String string = GenericPropertyUtility.getString(1829634816, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(1846412032, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedNamingRuleF(string, string2);
            }
        }
        throw new IllegalArgumentException();
    }
}

