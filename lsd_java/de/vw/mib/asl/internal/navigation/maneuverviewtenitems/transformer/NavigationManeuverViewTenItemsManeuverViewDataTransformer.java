/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.maneuverviewtenitems.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.navigation.maneuverviewtenitems.transformer.NavigationManeuverViewDataTenItemsCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navigation.maneuverviewtenitems.transformer.AbstractNavigationManeuverViewTenItemsManeuverViewDataTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationManeuverViewTenItemsManeuverViewDataTransformer
extends AbstractNavigationManeuverViewTenItemsManeuverViewDataTransformer
implements ItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 33: {
                return navigationManeuverViewDataTenItemsCollector.type;
            }
            case 3: {
                return navigationManeuverViewDataTenItemsCollector.dtm;
            }
            case 8: {
                return navigationManeuverViewDataTenItemsCollector.numberOfPoiIcons;
            }
            case 4: {
                return navigationManeuverViewDataTenItemsCollector.rtth;
            }
            case 5: {
                return navigationManeuverViewDataTenItemsCollector.rttm;
            }
            case 7: {
                return navigationManeuverViewDataTenItemsCollector.direction;
            }
            case 6: {
                return navigationManeuverViewDataTenItemsCollector.mainElement;
            }
            case 40: {
                return navigationManeuverViewDataTenItemsCollector.tmcDelay;
            }
            case 32: {
                return navigationManeuverViewDataTenItemsCollector.tollGateCost;
            }
            case 46: {
                return navigationManeuverViewDataTenItemsCollector.tollGateCostCurrency;
            }
            case 36: {
                return navigationManeuverViewDataTenItemsCollector.length;
            }
            case 42: {
                if (navigationManeuverViewDataTenItemsCollector.type == 6) {
                    return navigationManeuverViewDataTenItemsCollector.tollGateDirections != null ? navigationManeuverViewDataTenItemsCollector.tollGateDirections.length : 0;
                }
                return navigationManeuverViewDataTenItemsCollector.laneDirections != null ? navigationManeuverViewDataTenItemsCollector.laneDirections.length : 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator;
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 9: {
                resourceLocator = this.getResourceLocatorPoiIcon1(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 10: {
                resourceLocator = this.getResourceLocatorPoiIcon2(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 11: {
                resourceLocator = this.getResourceLocatorPoiIcon3(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 12: {
                resourceLocator = this.getResourceLocatorPoiIcon4(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 13: {
                resourceLocator = this.getResourceLocatorPoiIcon5(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 23: {
                resourceLocator = this.getResourceLocatorPoiIcon6(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 24: {
                resourceLocator = this.getResourceLocatorPoiIcon7(navigationManeuverViewDataTenItemsCollector);
                break;
            }
            case 18: {
                resourceLocator = navigationManeuverViewDataTenItemsCollector.tmcListIcon;
                break;
            }
            case 25: {
                resourceLocator = navigationManeuverViewDataTenItemsCollector.colorIndicatorIcon;
                break;
            }
            case 34: {
                resourceLocator = navigationManeuverViewDataTenItemsCollector.trafficLightIcon;
                break;
            }
            case 37: {
                resourceLocator = navigationManeuverViewDataTenItemsCollector.stopoverFlagIcon;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon7(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 6 ? navigationManeuverViewDataTenItemsCollector.poiIcons[6] : null;
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon6(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 5 ? navigationManeuverViewDataTenItemsCollector.poiIcons[5] : null;
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon5(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 4 ? navigationManeuverViewDataTenItemsCollector.poiIcons[4] : null;
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon4(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 3 ? navigationManeuverViewDataTenItemsCollector.poiIcons[3] : null;
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon3(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 2 ? navigationManeuverViewDataTenItemsCollector.poiIcons[2] : null;
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon2(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 1 ? navigationManeuverViewDataTenItemsCollector.poiIcons[1] : null;
        return resourceLocator;
    }

    private ResourceLocator getResourceLocatorPoiIcon1(NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector) {
        ResourceLocator resourceLocator = navigationManeuverViewDataTenItemsCollector.poiIcons != null && navigationManeuverViewDataTenItemsCollector.poiIcons.length > 0 ? navigationManeuverViewDataTenItemsCollector.poiIcons[0] : null;
        return resourceLocator;
    }

    @Override
    public String getString(int n, Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 1: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.name);
            }
            case 39: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.exitNumber);
            }
            case 16: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.tmcEndLocation);
            }
            case 17: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.tmcMessageText);
            }
            case 14: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.tmcRoadName);
            }
            case 15: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.tmcStartLocation);
            }
            case 2: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.signPost);
            }
            case 38: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.address);
            }
            case 43: {
                return this.checkNull(navigationManeuverViewDataTenItemsCollector.tmcRoadNumber);
            }
            case 45: {
                return navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon != null ? this.checkNull(navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon.getText()) : "";
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 26: {
                return navigationManeuverViewDataTenItemsCollector.trafficLightIconVisibility;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 19: {
                return navigationManeuverViewDataTenItemsCollector.tollGateDirections;
            }
            case 20: {
                return navigationManeuverViewDataTenItemsCollector.tollGateInfos;
            }
            case 21: {
                return navigationManeuverViewDataTenItemsCollector.tollGateMarkingsLeft;
            }
            case 22: {
                return navigationManeuverViewDataTenItemsCollector.tollGateMarkingsRight;
            }
            case 27: {
                return navigationManeuverViewDataTenItemsCollector.laneDirections;
            }
            case 28: {
                return navigationManeuverViewDataTenItemsCollector.laneInfos;
            }
            case 29: {
                return navigationManeuverViewDataTenItemsCollector.laneMarkingsLeft;
            }
            case 30: {
                return navigationManeuverViewDataTenItemsCollector.laneMarkingsRight;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 35: {
                return navigationManeuverViewDataTenItemsCollector.roadSignLabeledIcon;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        switch (n) {
            case 44: {
                return navigationManeuverViewDataTenItemsCollector.fixFormatterFieldForAddressData;
            }
        }
        throw new IllegalArgumentException();
    }

    String checkNull(String string) {
        return string != null ? string : "";
    }
}

