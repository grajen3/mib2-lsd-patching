/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkFuelResultsListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkFuelResultsListTransformer
extends AbstractTravelLinkFuelResultsListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return TLinkServiceManager.getServiceManager().getFuel().getFuelPriceCurrency(genericPropertyContainer);
            }
            case 1: {
                return 0;
            }
            case 2: {
                return GenericPropertyUtility.getInt(631310080, 0, genericPropertyContainer);
            }
            case 3: {
                return GenericPropertyUtility.getInt(614532864, 0, genericPropertyContainer);
            }
            case 4: {
                return 0;
            }
            case 7: {
                return (int)GenericPropertyUtility.getFloat(648087296, 0, genericPropertyContainer);
            }
            case 8: {
                float f2 = GenericPropertyUtility.getFloat(648087296, 0, genericPropertyContainer);
                int n2 = (int)(f2 * 51266);
                return n2 % 100;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 5: {
                return GenericPropertyUtility.getResourceLocator(564201216, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 6: {
                return GenericPropertyUtility.getString(597755648, 0, genericPropertyContainer);
            }
            case 9: {
                int n2 = GenericPropertyUtility.getInt(614532864, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDistanceValueAndUnit(n2);
            }
        }
        throw new IllegalArgumentException();
    }
}

