/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSelectableStationResortListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSelectableStationResortListTransformer
extends AbstractTravelLinkSelectableStationResortListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                int n2 = TLinkServiceManager.getServiceManager().getWeather().getSetupEntry();
                if (n2 == 2) {
                    return (int)GenericPropertyUtility.getLong(135136000, 0, genericPropertyContainer);
                }
                if (n2 != 1) break;
                return (int)GenericPropertyUtility.getLong(1209730560, 0, genericPropertyContainer);
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return 0;
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                int n2 = TLinkServiceManager.getServiceManager().getWeather().getSetupEntry();
                if (n2 == 2) {
                    return GenericPropertyUtility.getString(151913216, 0, genericPropertyContainer);
                }
                if (n2 != 1) break;
                return GenericPropertyUtility.getString(1226507776, 0, genericPropertyContainer);
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return "";
    }
}

