/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.setup.transformer;

import de.vw.mib.asl.internal.navigation.poi.setup.transformer.PoiSetupShortCutListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.setup.transformer.AbstractNavigationPOISetupCategoryShortCutListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOISetupCategoryShortCutListTransformer
extends AbstractNavigationPOISetupCategoryShortCutListTransformer {
    @Override
    public int getInt(int n, Object object) {
        int n2 = 0;
        PoiSetupShortCutListCollector poiSetupShortCutListCollector = (PoiSetupShortCutListCollector)object;
        switch (n) {
            case 0: {
                n2 = poiSetupShortCutListCollector.index;
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
        PoiSetupShortCutListCollector poiSetupShortCutListCollector = (PoiSetupShortCutListCollector)object;
        switch (n) {
            case 1: {
                return poiSetupShortCutListCollector.icon;
            }
        }
        throw new IllegalArgumentException();
    }
}

