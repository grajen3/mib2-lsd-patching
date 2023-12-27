/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsFavoritesGameListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class TravelLinkSportsFavoritesGameListTransformer
extends AbstractTravelLinkSportsFavoritesGameListTransformer {
    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 5: {
                return GenericPropertyUtility.getString(261424128, 0, genericPropertyContainer);
            }
            case 6: {
                return GenericPropertyUtility.getString(311755776, 0, genericPropertyContainer);
            }
            case 1: {
                return GenericPropertyUtility.getString(244646912, 0, genericPropertyContainer);
            }
            case 2: {
                return GenericPropertyUtility.getString(294978560, 0, genericPropertyContainer);
            }
            case 14: {
                return GenericPropertyUtility.getString(429196288, 0, genericPropertyContainer);
            }
            case 15: {
                if (2 == TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListTimeframeForHeadToHeadGames()) {
                    return "";
                }
                return GenericPropertyUtility.getString(278201344, 0, genericPropertyContainer);
            }
            case 16: {
                if (2 == TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListTimeframeForHeadToHeadGames()) {
                    return "";
                }
                return GenericPropertyUtility.getString(328532992, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 12: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer);
                return travelLinkDate.getHour();
            }
            case 13: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer);
                return travelLinkDate.getMinute();
            }
            case 11: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer);
                return travelLinkDate.getDay();
            }
            case 10: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer);
                return travelLinkDate.getMonth();
            }
            case 9: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer);
                return travelLinkDate.getYear();
            }
            case 8: {
                return GenericPropertyUtility.getInt(345310208, 0, genericPropertyContainer);
            }
            case 7: {
                return GenericPropertyUtility.getInt(680854528, 0, genericPropertyContainer);
            }
            case 3: {
                return -1;
            }
            case 4: {
                return -1;
            }
        }
        throw new IllegalArgumentException();
    }
}

