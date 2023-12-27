/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkFavoriteTeamListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkFavoriteTeamListTransformer
extends AbstractTravelLinkFavoriteTeamListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        if (null != genericPropertyContainer) {
            switch (n) {
                case 4: {
                    return TLinkServiceManager.getServiceManager().getSports().getHmiSportId(GenericPropertyUtility.getInt(-1114045440, 0, genericPropertyContainer));
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
                return GenericPropertyUtility.getString(-1080491008, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

