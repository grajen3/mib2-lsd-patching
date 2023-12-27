/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsRankedListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class TravelLinkSportsRankedListTransformer
extends AbstractTravelLinkSportsRankedListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-694877184, 0, genericPropertyContainer);
                return travelLinkDate.getDay();
            }
            case 4: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-694877184, 0, genericPropertyContainer);
                return travelLinkDate.getMonth();
            }
            case 6: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-694877184, 0, genericPropertyContainer);
                return travelLinkDate.getYear();
            }
            case 1: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-694877184, 0, genericPropertyContainer);
                return travelLinkDate.getHour();
            }
            case 3: {
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-694877184, 0, genericPropertyContainer);
                return travelLinkDate.getMinute();
            }
            case 9: {
                return TLinkServiceManager.getServiceManager().getSports().getHmiSportId(GenericPropertyUtility.getInt(-678099968, 0, genericPropertyContainer));
            }
            case 10: {
                return GenericPropertyUtility.getInt(-627768320, 0, genericPropertyContainer);
            }
            case 2: {
                return GenericPropertyUtility.getInt(-728431616, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 5: {
                return GenericPropertyUtility.getString(-661322752, 0, genericPropertyContainer);
            }
            case 8: {
                return GenericPropertyUtility.getString(-644545536, 1, genericPropertyContainer);
            }
            case 11: {
                return GenericPropertyUtility.getString(-644545536, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

