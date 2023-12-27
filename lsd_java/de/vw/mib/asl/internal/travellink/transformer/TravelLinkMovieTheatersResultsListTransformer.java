/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkMovieTheatersResultsListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkMovieTheatersResultsListTransformer
extends AbstractTravelLinkMovieTheatersResultsListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return 0;
            }
            case 3: {
                return 0;
            }
            case 2: {
                return GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
            }
            case 1: {
                return GenericPropertyUtility.getInt(159842560, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 4: {
                return GenericPropertyUtility.getResourceLocator(92733696, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 5: {
                return GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
            }
            case 6: {
                int n2 = GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDistanceValueAndUnit(n2);
            }
        }
        throw new IllegalArgumentException();
    }
}

