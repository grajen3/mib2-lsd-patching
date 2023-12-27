/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.AbstractNavigationPOISearchCategoryListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationPOISearchCategoryListTransformer
extends AbstractNavigationPOISearchCategoryListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 0: {
                return ((PoiCatListCollector)object).resourceLocator;
            }
        }
        throw new IllegalArgumentException("Columns does not contains String values!");
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 1: {
                return ((PoiCatListCollector)object).catName;
            }
        }
        throw new IllegalArgumentException("Columns does not contains String values!");
    }
}

