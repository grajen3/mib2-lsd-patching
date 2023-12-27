/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.transformer;

import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupMultiLevelPoiListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.setup.transformer.AbstractNavigationPOISetupLevel1CategoryListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOISetupLevel1CategoryListTransformer
extends AbstractNavigationPOISetupLevel1CategoryListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = (PoiSetupMultiLevelPoiListCollector)object;
        switch (n) {
            case 2: {
                bl = poiSetupMultiLevelPoiListCollector.selected;
                break;
            }
            case 3: {
                bl = poiSetupMultiLevelPoiListCollector.isParent;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return bl;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = (PoiSetupMultiLevelPoiListCollector)object;
        switch (n) {
            case 1: {
                return poiSetupMultiLevelPoiListCollector.icon;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        String string = "";
        PoiSetupMultiLevelPoiListCollector poiSetupMultiLevelPoiListCollector = (PoiSetupMultiLevelPoiListCollector)object;
        switch (n) {
            case 0: {
                string = poiSetupMultiLevelPoiListCollector.catName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }
}

