/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSetupSportsAddNewFavoriteLeaguesListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSetupSportsAddNewFavoriteLeaguesListTransformer
extends AbstractTravelLinkSetupSportsAddNewFavoriteLeaguesListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        if (null != genericPropertyContainer) {
            switch (n) {
                case 0: {
                    return TLinkServiceManager.getServiceManager().getSports().getHmiSportId(GenericPropertyUtility.getInt(-174586880, 0, genericPropertyContainer));
                }
            }
            throw new IllegalArgumentException();
        }
        return 0;
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return GenericPropertyUtility.getString(-157809664, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

