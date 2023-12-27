/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer.NavInfoTileManeuverViewTenItemsManeuverViewDataCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer.AbstractNavInfoTileManeuverViewTenItemsManeuverViewDataTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTileManeuverViewTenItemsManeuverViewDataTransformer
extends AbstractNavInfoTileManeuverViewTenItemsManeuverViewDataTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 31: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTrafficLightIconVisibility();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 43: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getFixFormatterFieldForAddressData();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 5: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getDtm();
            }
            case 36: {
                if (navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getType() == 6) {
                    return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateDirections() != null ? navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateDirections().length : 0;
                }
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneDirections() != null ? navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneDirections().length : 0;
            }
            case 41: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLength();
            }
            case 9: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getDirection();
            }
            case 8: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getMainElement();
            }
            case 10: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getNumberOfPoiIcons();
            }
            case 6: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRtth();
            }
            case 7: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRttm();
            }
            case 24: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcDelay();
            }
            case 39: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateCost();
            }
            case 40: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateCostCurrency();
            }
            case 0: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getType();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 32: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneDirections();
            }
            case 34: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneMarkingsLeft();
            }
            case 35: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneMarkingsRight();
            }
            case 33: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneInfos();
            }
            case 25: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateDirections();
            }
            case 27: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateMarkingsLeft();
            }
            case 28: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateMarkingsRight();
            }
            case 26: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateInfos();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 37: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRoadSignLabeledIcon();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator;
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 11: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 1);
                break;
            }
            case 12: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 2);
                break;
            }
            case 13: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 3);
                break;
            }
            case 14: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 4);
                break;
            }
            case 15: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 5);
                break;
            }
            case 16: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 6);
                break;
            }
            case 17: {
                resourceLocator = this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 7);
                break;
            }
            case 29: {
                resourceLocator = navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getColorIndicatorIcon();
                break;
            }
            case 42: {
                resourceLocator = navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getStopoverFlagIcon();
                break;
            }
            case 23: {
                resourceLocator = navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcListIcon();
                break;
            }
            case 30: {
                resourceLocator = navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTrafficLightIcon();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return resourceLocator;
    }

    @Override
    public String getString(int n, Object object) {
        String string;
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 3: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getAddress());
                break;
            }
            case 2: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getExitNumber());
                break;
            }
            case 4: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getSignPost());
                break;
            }
            case 1: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getName());
                break;
            }
            case 38: {
                string = navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRoadSignLabeledIcon() != null ? this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRoadSignLabeledIcon().getText()) : "";
                break;
            }
            case 21: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcEndLocation());
                break;
            }
            case 22: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcMessageText());
                break;
            }
            case 18: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcRoadName());
                break;
            }
            case 19: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcRoadNumber());
                break;
            }
            case 20: {
                string = this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcStartLocation());
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }

    private ResourceLocator getResourceLocatorPoiIcon(NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector, int n) {
        int n2 = n - 1;
        ResourceLocator resourceLocator = navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getPoiIcons() != null && navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getPoiIcons().length > n2 ? navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getPoiIcons()[n2] : null;
        return resourceLocator;
    }

    private String checkNull(String string) {
        return string != null ? string : "";
    }
}

