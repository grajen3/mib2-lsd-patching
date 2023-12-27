/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer;

import de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer.NavInfoTileManeuverViewTenItemsManeuverViewDataCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer.AbstractNavInfoTileManeuverViewTenItemsManeuverViewDataListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTileManeuverViewTenItemsManeuverViewDataListTransformer
extends AbstractNavInfoTileManeuverViewTenItemsManeuverViewDataListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 44: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.isValid();
            }
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
                return this.retrieveLaneNumber(navInfoTileManeuverViewTenItemsManeuverViewDataCollector);
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
            case 40: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateCostCurrency();
            }
            case 39: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateCost();
            }
            case 0: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getType();
            }
        }
        throw new IllegalArgumentException();
    }

    private int retrieveLaneNumber(NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector) {
        if (navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getType() == 6) {
            return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateDirections() != null ? navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateDirections().length : 0;
        }
        return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneDirections() != null ? navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneDirections().length : 0;
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 32: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneDirections();
            }
            case 33: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneInfos();
            }
            case 34: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneMarkingsLeft();
            }
            case 35: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getLaneMarkingsRight();
            }
            case 25: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateDirections();
            }
            case 26: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateInfos();
            }
            case 27: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateMarkingsLeft();
            }
            case 28: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTollGateMarkingsRight();
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
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 29: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getColorIndicatorIcon();
            }
            case 11: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 1);
            }
            case 12: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 2);
            }
            case 13: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 3);
            }
            case 14: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 4);
            }
            case 15: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 5);
            }
            case 16: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 6);
            }
            case 17: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewTenItemsManeuverViewDataCollector, 7);
            }
            case 42: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getStopoverFlagIcon();
            }
            case 23: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcListIcon();
            }
            case 30: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTrafficLightIcon();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        switch (n) {
            case 3: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getAddress());
            }
            case 2: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getExitNumber());
            }
            case 4: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getSignPost());
            }
            case 1: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getName());
            }
            case 38: {
                return navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRoadSignLabeledIcon() != null ? this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getRoadSignLabeledIcon().getText()) : "";
            }
            case 21: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcEndLocation());
            }
            case 22: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcMessageText());
            }
            case 18: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcRoadName());
            }
            case 19: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcRoadNumber());
            }
            case 20: {
                return this.checkNull(navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getTmcStartLocation());
            }
        }
        throw new IllegalArgumentException();
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

