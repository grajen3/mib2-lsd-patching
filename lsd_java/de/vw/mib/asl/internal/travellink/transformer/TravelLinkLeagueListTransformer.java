/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkLeagueListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkLeagueListTransformer
extends AbstractTravelLinkLeagueListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getInt(-527236096, 0, genericPropertyContainer);
            }
            case 4: {
                return TLinkServiceManager.getServiceManager().getSports().getHmiSportId(GenericPropertyUtility.getInt(-493681664, 0, genericPropertyContainer));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return GenericPropertyUtility.getString(-476904448, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

