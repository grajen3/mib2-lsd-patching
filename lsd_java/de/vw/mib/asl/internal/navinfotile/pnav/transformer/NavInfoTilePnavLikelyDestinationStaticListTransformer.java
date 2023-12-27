/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav.transformer;

import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.internal.navinfotile.pnav.PnavLikelyDestinationWrapper;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.navinfotile.pnav.transformer.AbstractNavInfoTilePnavLikelyDestinationStaticListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTilePnavLikelyDestinationStaticListTransformer
extends AbstractNavInfoTilePnavLikelyDestinationStaticListTransformer {
    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        IPnavLikelyDestination iPnavLikelyDestination = ((PnavLikelyDestinationWrapper)object).getPnavLikelyDestination();
        switch (n) {
            case 16: {
                return iPnavLikelyDestination.getLikelyDestAddressData();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        IPnavLikelyDestination iPnavLikelyDestination = ((PnavLikelyDestinationWrapper)object).getPnavLikelyDestination();
        switch (n) {
            case 1: {
                return iPnavLikelyDestination.getCalculationProgress();
            }
            case 0: {
                return iPnavLikelyDestination.getCalculationState();
            }
            case 3: {
                return (int)iPnavLikelyDestination.getDtd();
            }
            case 14: {
                return iPnavLikelyDestination.getLatitude();
            }
            case 2: {
                return iPnavLikelyDestination.getLikelyHood();
            }
            case 15: {
                return iPnavLikelyDestination.getLongitude();
            }
            case 6: {
                return iPnavLikelyDestination.getRouteColor();
            }
            case 4: {
                return (int)iPnavLikelyDestination.getRtt();
            }
            case 5: {
                return (int)iPnavLikelyDestination.getTimeDelay();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        IPnavLikelyDestination iPnavLikelyDestination = ((PnavLikelyDestinationWrapper)object).getPnavLikelyDestination();
        switch (n) {
            case 7: {
                return iPnavLikelyDestination.getColorIcon();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        IPnavLikelyDestination iPnavLikelyDestination = ((PnavLikelyDestinationWrapper)object).getPnavLikelyDestination();
        switch (n) {
            case 12: {
                return iPnavLikelyDestination.getCityRefinement();
            }
            case 11: {
                return iPnavLikelyDestination.getCity();
            }
            case 13: {
                return iPnavLikelyDestination.getCrossStreet();
            }
            case 9: {
                return iPnavLikelyDestination.getHousenumber();
            }
            case 10: {
                return iPnavLikelyDestination.getStreetRefinement();
            }
            case 8: {
                return iPnavLikelyDestination.getStreet();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PnavLikelyDestinationWrapper pnavLikelyDestinationWrapper = (PnavLikelyDestinationWrapper)object;
        switch (n) {
            case 17: {
                return pnavLikelyDestinationWrapper.isValid();
            }
        }
        throw new IllegalArgumentException();
    }
}

