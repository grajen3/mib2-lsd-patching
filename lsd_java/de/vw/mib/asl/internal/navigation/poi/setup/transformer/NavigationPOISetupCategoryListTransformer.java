/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.transformer;

import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupPoiListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.setup.transformer.AbstractNavigationPOISetupCategoryListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOISetupCategoryListTransformer
extends AbstractNavigationPOISetupCategoryListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        PoiSetupPoiListCollector poiSetupPoiListCollector = (PoiSetupPoiListCollector)object;
        switch (n) {
            case 2: {
                bl = poiSetupPoiListCollector.selected;
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
        PoiSetupPoiListCollector poiSetupPoiListCollector = (PoiSetupPoiListCollector)object;
        switch (n) {
            case 1: {
                return poiSetupPoiListCollector.icon;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        String string = "";
        PoiSetupPoiListCollector poiSetupPoiListCollector = (PoiSetupPoiListCollector)object;
        switch (n) {
            case 0: {
                string = poiSetupPoiListCollector.catName;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }
}

