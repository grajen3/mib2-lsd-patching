/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.pnav.transformer;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavLikelyDestinationListCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.AbstractNavigationPnavLikelyDestinationListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPnavLikelyDestinationListTransformer
extends AbstractNavigationPnavLikelyDestinationListTransformer {
    @Override
    public int getInt(int n, Object object) {
        NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector = (NavigationPnavLikelyDestinationListCollector)object;
        switch (n) {
            case 1: {
                return navigationPnavLikelyDestinationListCollector.getCalculationProgress();
            }
            case 0: {
                return navigationPnavLikelyDestinationListCollector.getCalculationState();
            }
            case 3: {
                return (int)navigationPnavLikelyDestinationListCollector.getDistance();
            }
            case 14: {
                if (navigationPnavLikelyDestinationListCollector.getDestination() != null) {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getLatitude();
                }
                return 0;
            }
            case 2: {
                return navigationPnavLikelyDestinationListCollector.getLikelihood();
            }
            case 15: {
                if (navigationPnavLikelyDestinationListCollector.getDestination() != null) {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getLongitude();
                }
                return 0;
            }
            case 6: {
                return navigationPnavLikelyDestinationListCollector.getRouteColor();
            }
            case 4: {
                return (int)(navigationPnavLikelyDestinationListCollector.getRemainingTravelTime() + navigationPnavLikelyDestinationListCollector.getTimeDelay());
            }
            case 5: {
                return (int)navigationPnavLikelyDestinationListCollector.getTimeDelay();
            }
        }
        return 0;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (7 == n) {
            return ((NavigationPnavLikelyDestinationListCollector)object).getRouteColorIcon();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector;
        if (object != null && (navigationPnavLikelyDestinationListCollector = (NavigationPnavLikelyDestinationListCollector)object).getDestination() != null) {
            switch (n) {
                case 12: {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getTownRefinement();
                }
                case 11: {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getTown();
                }
                case 13: {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getJunction();
                }
                case 9: {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getHousenumber();
                }
                case 10: {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getStreetRefinement();
                }
                case 8: {
                    return navigationPnavLikelyDestinationListCollector.getDestination().getStreet();
                }
            }
        }
        return "";
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        NavigationPnavLikelyDestinationListCollector navigationPnavLikelyDestinationListCollector;
        FixFormatterFieldData fixFormatterFieldData = new FixFormatterFieldDataImpl();
        if (object != null && (navigationPnavLikelyDestinationListCollector = (NavigationPnavLikelyDestinationListCollector)object).getDestination() != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navigationPnavLikelyDestinationListCollector.getDestination());
            fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        }
        return fixFormatterFieldData;
    }
}

