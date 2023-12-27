/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.transformer;

import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileManeuverViewThreeItemsCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.AbstractNavInfoTileManeuverViewDataListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTileManeuverViewDataListTransformer
extends AbstractNavInfoTileManeuverViewDataListTransformer {
    @Override
    public int getInt(int n, Object object) {
        NavInfoTileManeuverViewThreeItemsCollector navInfoTileManeuverViewThreeItemsCollector = (NavInfoTileManeuverViewThreeItemsCollector)object;
        switch (n) {
            case 3: {
                return navInfoTileManeuverViewThreeItemsCollector.getDtm();
            }
            case 7: {
                return navInfoTileManeuverViewThreeItemsCollector.getDirection();
            }
            case 6: {
                return navInfoTileManeuverViewThreeItemsCollector.getMainElement();
            }
            case 8: {
                return navInfoTileManeuverViewThreeItemsCollector.getNumberOfPoiIcons();
            }
            case 4: {
                return navInfoTileManeuverViewThreeItemsCollector.getRtth();
            }
            case 5: {
                return navInfoTileManeuverViewThreeItemsCollector.getRttm();
            }
            case 0: {
                return navInfoTileManeuverViewThreeItemsCollector.getType();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        NavInfoTileManeuverViewThreeItemsCollector navInfoTileManeuverViewThreeItemsCollector = (NavInfoTileManeuverViewThreeItemsCollector)object;
        switch (n) {
            case 9: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewThreeItemsCollector, 1);
            }
            case 10: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewThreeItemsCollector, 2);
            }
            case 11: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewThreeItemsCollector, 3);
            }
            case 12: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewThreeItemsCollector, 4);
            }
            case 13: {
                return this.getResourceLocatorPoiIcon(navInfoTileManeuverViewThreeItemsCollector, 5);
            }
            case 17: {
                return navInfoTileManeuverViewThreeItemsCollector.getTmcListIcon();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavInfoTileManeuverViewThreeItemsCollector navInfoTileManeuverViewThreeItemsCollector = (NavInfoTileManeuverViewThreeItemsCollector)object;
        switch (n) {
            case 2: {
                return this.checkNull(navInfoTileManeuverViewThreeItemsCollector.getSignPost());
            }
            case 1: {
                return this.checkNull(navInfoTileManeuverViewThreeItemsCollector.getName());
            }
            case 16: {
                return this.checkNull(navInfoTileManeuverViewThreeItemsCollector.getTmcMessageText());
            }
            case 14: {
                return this.checkNull(navInfoTileManeuverViewThreeItemsCollector.getTmcRoadName());
            }
            case 15: {
                return this.checkNull(navInfoTileManeuverViewThreeItemsCollector.getTmcStartLocation());
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavInfoTileManeuverViewThreeItemsCollector navInfoTileManeuverViewThreeItemsCollector = (NavInfoTileManeuverViewThreeItemsCollector)object;
        switch (n) {
            case 18: {
                return navInfoTileManeuverViewThreeItemsCollector.isValid();
            }
        }
        throw new IllegalArgumentException();
    }

    private ResourceLocator getResourceLocatorPoiIcon(NavInfoTileManeuverViewThreeItemsCollector navInfoTileManeuverViewThreeItemsCollector, int n) {
        int n2 = n - 1;
        ResourceLocator resourceLocator = navInfoTileManeuverViewThreeItemsCollector.getPoiIcons() != null && navInfoTileManeuverViewThreeItemsCollector.getPoiIcons().length > n2 ? navInfoTileManeuverViewThreeItemsCollector.getPoiIcons()[n2] : null;
        return resourceLocator;
    }

    private String checkNull(String string) {
        return string != null ? string : "";
    }
}

