/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatGroupListCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.AbstractNavigationPOISearchCategoryGroupListTransformer;

public class NavigationPOISearchCategoryGroupListTransformer
extends AbstractNavigationPOISearchCategoryGroupListTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return ((PoiCatGroupListCollector)object).catName;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }
}

