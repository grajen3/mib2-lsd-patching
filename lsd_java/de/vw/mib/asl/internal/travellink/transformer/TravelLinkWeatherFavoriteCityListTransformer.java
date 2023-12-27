/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkWeatherFavoriteCityListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkWeatherFavoriteCityListTransformer
extends AbstractTravelLinkWeatherFavoriteCityListTransformer {
    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                String string = GenericPropertyUtility.getString(-1390737920, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(-1373960704, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedNamingRuleE(string, string2);
            }
            case 2: {
                return "";
            }
        }
        throw new IllegalArgumentException();
    }
}

