/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.tourmode.transformer;

import de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourDestinationCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.AbstractNavigationTourModeTourListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationTourModeTourListTransformer
extends AbstractNavigationTourModeTourListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationTourModeTourDestinationCollector navigationTourModeTourDestinationCollector = (NavigationTourModeTourDestinationCollector)object;
        switch (n) {
            case 22: {
                return navigationTourModeTourDestinationCollector.isRubberbandDestination();
            }
            case 16: {
                return navigationTourModeTourDestinationCollector.isPassed();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationTourModeTourDestinationCollector navigationTourModeTourDestinationCollector = (NavigationTourModeTourDestinationCollector)object;
        int n2 = 0;
        block0 : switch (n) {
            case 3: {
                n2 = navigationTourModeTourDestinationCollector.getDtd();
                break;
            }
            case 4: {
                n2 = navigationTourModeTourDestinationCollector.getEtaD();
                break;
            }
            case 5: {
                n2 = navigationTourModeTourDestinationCollector.getEtaH();
                break;
            }
            case 6: {
                n2 = navigationTourModeTourDestinationCollector.getEtaM();
                break;
            }
            case 8: {
                n2 = navigationTourModeTourDestinationCollector.routeLocation.getLatitudeDegrees();
                break;
            }
            case 9: {
                n2 = navigationTourModeTourDestinationCollector.routeLocation.getLatitudeMinutes();
                break;
            }
            case 10: {
                n2 = navigationTourModeTourDestinationCollector.routeLocation.getLatitudeSeconds();
                break;
            }
            case 11: {
                n2 = navigationTourModeTourDestinationCollector.routeLocation.getLongitudeDegrees();
                break;
            }
            case 12: {
                n2 = navigationTourModeTourDestinationCollector.routeLocation.getLongitudeMinutes();
                break;
            }
            case 13: {
                n2 = navigationTourModeTourDestinationCollector.routeLocation.getLongitudeSeconds();
                break;
            }
            case 18: {
                switch (navigationTourModeTourDestinationCollector.routeLocation.getLocationType()) {
                    case 1: {
                        n2 = 0;
                        break block0;
                    }
                    case 2: {
                        n2 = 1;
                        break block0;
                    }
                    case 0: {
                        n2 = 3;
                        break block0;
                    }
                    case 3: {
                        n2 = 2;
                        break block0;
                    }
                }
                n2 = 0;
                break;
            }
            case 24: {
                n2 = navigationTourModeTourDestinationCollector.getTollCost();
                break;
            }
            case 23: {
                n2 = navigationTourModeTourDestinationCollector.getTollLength();
                break;
            }
            case 25: {
                n2 = navigationTourModeTourDestinationCollector.getTollCurrency();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return n2;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (14 == n) {
            return ((NavigationTourModeTourDestinationCollector)object).getPoiIcon();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationTourModeTourDestinationCollector navigationTourModeTourDestinationCollector = (NavigationTourModeTourDestinationCollector)object;
        switch (n) {
            case 1: {
                return "";
            }
            case 0: {
                return navigationTourModeTourDestinationCollector.routeLocation.getCity();
            }
            case 2: {
                return navigationTourModeTourDestinationCollector.routeLocation.getCrossing();
            }
            case 7: {
                return navigationTourModeTourDestinationCollector.routeLocation.getHousenumber();
            }
            case 15: {
                return navigationTourModeTourDestinationCollector.routeLocation.getPoiName();
            }
            case 17: {
                return navigationTourModeTourDestinationCollector.routeLocation.getStreet();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        NavigationTourModeTourDestinationCollector navigationTourModeTourDestinationCollector = (NavigationTourModeTourDestinationCollector)object;
        switch (n) {
            case 21: {
                return navigationTourModeTourDestinationCollector.getFixFormatterFieldData();
            }
        }
        throw new IllegalArgumentException();
    }
}

